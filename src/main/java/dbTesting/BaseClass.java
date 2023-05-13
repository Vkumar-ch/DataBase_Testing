package dbTesting;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseClass {
    public static Connection con;
    @BeforeTest
    public Connection setUpConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice1","root","Kumar@768");
        return con;
    }

    @AfterTest
    public void tearDown() throws SQLException {
        con.close();
    }
}
