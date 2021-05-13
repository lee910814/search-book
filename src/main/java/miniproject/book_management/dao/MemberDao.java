package miniproject.book_management.dao;

import miniproject.book_management.connection.DBConnection;
import miniproject.book_management.dto.MemberDto;

import javax.naming.NamingException;
import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static miniproject.book_management.connection.DBConnection.getConnection;

public class MemberDao {
    private static MemberDao instance =new MemberDao();

      public static MemberDao getInstance(){
           return instance;
           }



    public boolean save(MemberDto memberDto) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("insert into member(name, username, password, birthday) VALUES (?, ?, ?, ?)")) {
            ps.setNString(1, memberDto.getName());
            ps.setNString(2, memberDto.getUsername());
            ps.setNString(3, memberDto.getPassword());
            ps.setNString(4, memberDto.getCheckpw());
            ps.setDate(5, memberDto.getBirthday());
            return ps.executeUpdate() > 0;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public long login(MemberDto memberDto) {
        long id = 0;
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("select member_id from member where username = ? and password = ?")
        ) {
            ps.setString(1, memberDto.getUsername());
            ps.setString(2, memberDto.getPassword());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    id = rs.getLong("member_id");
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return id;
    }

    public List<MemberDto> findAll() {
        List<MemberDto> list = new ArrayList<>();
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("select * from member")
        ) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MemberDto dto = mappingMember(rs);
                    list.add(dto);
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return list;
    }
    public void deleteUser(String id) throws Exception{
        Connection conn = null;
        PreparedStatement ps = null;
        String sql= null;


        try{conn = getConnection();
            sql = "DELETE FROM member WHERE member_id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                conn.close();ps.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }
    public int checkpw(String id,String pw)throws Exception {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "";
        int x = -1;
        try {
            conn = getConnection();
            sql = "select member_id from member where username = ? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);

            if (rs.next()) {
                pw = rs.getString("password");
                if (pw.equals("password"))
                    x = 1;//인증 성공
                else
                    x = 0;//비밀번호 틀림
            } else
                x = -1;//해당 아이디 없음

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                conn.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return  x;
        }
    }



    private MemberDto mappingMember(ResultSet rs) throws SQLException {
        MemberDto dto = new MemberDto();
        dto.setId(rs.getLong("member_id"));
        dto.setName(rs.getNString("name"));
        dto.setUsername(rs.getNString("username"));
        dto.setPassword(rs.getNString("password"));
        dto.setCheckpw(rs.getNString("checkpw"));
        dto.setBirthday(rs.getDate("birthday"));
        return dto;
    }
}
