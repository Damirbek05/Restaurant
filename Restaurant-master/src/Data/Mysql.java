package Data;

import Data.Interface.IDB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Mysql implements IDB {

    @Override
    public Connection getConnection() throws SQLException, ClassNotFoundException {
        String connectionUrl = "jdbc:mysql://localhost:3306/restaurant";
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");


            Connection con = DriverManager.getConnection(connectionUrl, "root", "6021");

            return con;
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
