package miniproject.book_management.dao;

import miniproject.book_management.connection.DBConnection;
import miniproject.book_management.dto.BookDto;
import miniproject.book_management.dto.BookManageDto;

import javax.naming.NamingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookManageDao {
    public boolean save(BookManageDto bookManageDto) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "insert into book_manage(book_id, available) VALUES (?, ?)"
             )) {
            ps.setLong(1, bookManageDto.getBookId());
            ps.setBoolean(2, bookManageDto.isAvailable());
            return ps.execute();
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
