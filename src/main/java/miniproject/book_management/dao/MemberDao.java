package miniproject.book_management.dao;

import miniproject.book_management.dto.MemberDto;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static miniproject.book_management.connection.DBConnection.getConnection;

public class MemberDao {
    private static final MemberDao instance = new MemberDao();

    private MemberDao() {
    }

    public static MemberDao getInstance() {
        return instance;
    }

    public boolean save(MemberDto memberDto) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("insert into member(name, username, password, birthday) VALUES (?, ?, ?, ?)")) {
            ps.setNString(1, memberDto.getName());
            ps.setNString(2, memberDto.getUsername());
            ps.setNString(3, memberDto.getPassword());
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

/*    public boolean insertMember(MemberDto dto) {
        boolean flag = false;
        String sql = "INSERT INTO member(password, name, username) VALUE(?,?,?)";
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, dto.getPassword());
            ps.setString(2, dto.getName());
            ps.setString(3, dto.getUsername());

            if (ps.executeUpdate() == 1) flag = true;
            else flag = false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }*/

    //중복 ID여부 검증 메서드
    public boolean checkId(String id) {
        String sql = "SELECT * FROM member WHERE username=?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                return rs.next();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteUser(String id) {
        String sql = "DELETE FROM member WHERE username=?";

        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() == 1;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private MemberDto mappingMember(ResultSet rs) throws SQLException {
        MemberDto dto = new MemberDto();
        dto.setId(rs.getLong("member_id"));
        dto.setName(rs.getNString("name"));
        dto.setUsername(rs.getNString("username"));
        dto.setPassword(rs.getNString("password"));
        dto.setBirthday(rs.getDate("birthday"));
        return dto;
    }

    public boolean isAdmin(long id) {
        try (Connection con = getConnection();
             PreparedStatement ps = con.prepareStatement("select name from member where member_id = ?")) {
            ps.setLong(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("name").equalsIgnoreCase("admin");
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
