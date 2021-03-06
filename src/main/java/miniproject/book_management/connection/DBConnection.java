package miniproject.book_management.connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DBConnection {
    private DBConnection() {

    }

    public static Connection getConnection() throws NamingException, SQLException {
        Context context = new InitialContext();
        DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/mysql");
        return ds.getConnection();
    }
}
