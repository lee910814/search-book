package miniproject.book_management.dao;

import miniproject.book_management.connection.DBConnection;
import miniproject.book_management.dto.MemberDto;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemberDao {
    public boolean save(MemberDto memberDto) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("insert into member(name, username, password, birthday) VALUES (?, ?, ?, ?)")) {
            ps.setNString(1, memberDto.getName());
            ps.setNString(2, memberDto.getUsername());
            ps.setNString(3, memberDto.getPassword());
            ps.setDate(4, memberDto.getBirthday());
            return ps.execute();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Optional<Long> login(MemberDto memberDto) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("select member_id from member where username = ? and password = ?")
        ) {
            ps.setString(1, memberDto.getUsername());
            ps.setString(2, memberDto.getPassword());

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(rs.getLong("member_id"));
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<MemberDto> findAll() {
        List<MemberDto> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
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

    private MemberDto mappingMember(ResultSet rs) throws SQLException {
        MemberDto dto = new MemberDto();
        dto.setId(rs.getLong("member_id"));
        dto.setName(rs.getNString("name"));
        dto.setUsername(rs.getNString("username"));
        dto.setPassword(rs.getNString("password"));
        dto.setBirthday(rs.getDate("birthday"));
        return dto;
    }
}
