package miniproject.book_management.dao;

import miniproject.book_management.connection.DBConnection;
import miniproject.book_management.dto.BookDto;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    public boolean save(BookDto bookDto) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "insert into book(name, publisher, author) VALUES (?, ?, ?)"
             )) {
            ps.setNString(1, bookDto.getName());
            ps.setNString(2, bookDto.getPublisher());
            ps.setNString(3, bookDto.getAuthor());
            return ps.executeUpdate() > 0;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<BookDto> findAll() {
        List<BookDto> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("select * from book")
        ) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BookDto dto = mappingBook(rs);
                    list.add(dto);
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return list;
    }

    private BookDto mappingBook(ResultSet rs) throws SQLException {
        BookDto dto = new BookDto();
        dto.setId(rs.getLong("book_id"));
        dto.setName(rs.getNString("name"));
        dto.setPublisher(rs.getNString("publisher"));
        dto.setAuthor(rs.getNString("author"));
        return dto;
    }
}
