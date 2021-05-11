package miniproject.book_management.dao;

import miniproject.book_management.connection.DBConnection;
import miniproject.book_management.dto.RentalDto;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
            return ps.execute();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
