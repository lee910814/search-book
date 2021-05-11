package miniproject.book_management.dao;

import miniproject.book_management.connection.DBConnection;
import miniproject.book_management.dto.BookDto;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookDao {
    public boolean registerBook(BookDto bookDto) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "insert into book(name, publisher, author) VALUES (?, ?, ?)"
             )) {
            ps.setNString(1, bookDto.getName());
            ps.setNString(2, bookDto.getPublisher());
            ps.setNString(3, bookDto.getAuthor());
            return ps.execute();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
