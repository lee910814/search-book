package miniproject.book_management.dao;

import miniproject.book_management.connection.DBConnection;
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
                     "insert into book_manage(id, available) VALUES (?, ?)"
             )) {
            ps.setLong(1, bookManageDto.getId());
            ps.setBoolean(2, bookManageDto.isAvailable());
            return ps.executeUpdate() > 0;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean save(Long id) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "insert into book_manage(id) VALUES (?)"
             )) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public List<BookManageDto> findAll() {
        List<BookManageDto> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "select m.id, name, publisher, author " +
                     "from book_manage m " +
                     "inner join book b on m.id = b.book_id"
             )
        ) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BookManageDto dto = mappingBookManage(rs);
                    list.add(dto);
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return list;
    }

    private BookManageDto mappingBookManage(ResultSet rs) throws SQLException {
        BookManageDto dto = new BookManageDto();
        dto.setId(rs.getLong("id"));
        dto.setName(rs.getNString("name"));
        dto.setAuthor(rs.getNString("author"));
        dto.setPublisher(rs.getNString("publisher"));
        dto.setAvailable(rs.getBoolean("available"));
        return dto;
    }

    public List<BookManageDto> findByName(String name) {
        List<BookManageDto> list = new ArrayList<>();
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "select m.id, name, publisher, author, available " +
                     "from book_manage m " +
                     "inner join book b on m.id = b.book_id " +
                     "where b.name like ?;")
        ) {
            ps.setString(1, "%" + name + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BookManageDto dto = mappingBookManage(rs);
                    list.add(dto);
                }
            }
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean rental(Long id) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("update book_manage set available=0 where id=? and available = 1")
        ) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean returnBook(Long id) {
        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement("update book_manage set available=1 where id=?")
        ) {
            ps.setLong(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException | NamingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
