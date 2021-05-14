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

    // void 라서 제대로 삭제 되었는지 아닌지 알 수가 없음.
    public void deleteUser(String id) throws Exception { // 의미 없는 throws.
        Connection conn = null;
        PreparedStatement ps = null;
        String sql = null; // 의미 없는 null 초기화.

        try {
            conn = getConnection();
            sql = "DELETE FROM member WHERE member_id=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally { // try-with-resources 사용하기.
            try {
                conn.close();   // null check 하기.
                ps.close();     // try-with-resources 를 사용하면 필요없음.
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    // 함수명.
    public int checkpw(String id, String pw) throws Exception { // 의미없는 throws.

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
            // ?는 두갠데 하나만 설정함.

            // rs에 아무 대입도 안함.
            if (rs.next()) {
                // pw 에 바로 대입.. 매개변수로 넘어온 pw 값이 버려짐.
                pw = rs.getString("password");

                // int 대신 enum 사용하기.
                // SUCCESS, FAIL, NOT_FOUND 등... 바로 알아볼 수 있도록...
                // 또는 예외를 발생시켜서 호출하는 쪽에서 처리하도록 만들기. -> throw new ...
                if (pw.equals("password"))
                    x = 1;//인증 성공
                else
                    x = 0;//비밀번호 틀림
            } else
                x = -1;//해당 아이디 없음

        } catch (Exception e) {
            e.printStackTrace();
        } finally { // try-with-resource 사용하기.
            try {
                conn.close();
                ps.close();
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return x;
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
