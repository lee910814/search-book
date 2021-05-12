package miniproject.book_management.dao;

import miniproject.book_management.connection.DBConnection;
import miniproject.book_management.dto.RentalDto;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentalDao {
    public boolean save(RentalDto rentalDto) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "insert into rental(member_id, book_id, term_day, overdue_day) VALUES (?, ?, ?, ?)"
             )) {
            ps.setLong(1, rentalDto.getMemberId());
            ps.setLong(2, rentalDto.getBookId());
            ps.setInt(3, rentalDto.getTermDay());
            ps.setInt(4, rentalDto.getOverdueDay());
            return ps.executeUpdate() > 0;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<RentalDto> findAll() {
        List<RentalDto> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from rental")
        ) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    RentalDto dto = mappingRental(rs);
                    list.add(dto);
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return list;
    }

    private RentalDto mappingRental(ResultSet rs) throws SQLException {
        RentalDto dto = new RentalDto();
        dto.setId(rs.getLong("rental_id"));
        dto.setMemberId(rs.getLong("member_id"));
        dto.setBookId(rs.getLong("book_id"));
        dto.setTermDay(rs.getInt("term_day"));
        dto.setOverdueDay(rs.getInt("overdue_day"));
        return dto;
    }

    public boolean remove(Long memberId, Long bookId) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("delete from rental where member_id = ? and book_id = ?")
        ) {
            ps.setLong(1, memberId);
            ps.setLong(2, bookId);
            return ps.executeUpdate() > 0;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean removeAll(Long memberId) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("delete from rental where member_id = ?")
        ) {
            ps.setLong(1, memberId);
            return ps.executeUpdate() > 0;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
