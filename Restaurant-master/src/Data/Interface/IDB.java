package Data.Interface;

import java.sql.Connection;
import java.sql.SQLException;

public interface IDB {
    public Connection getConnection() throws SQLException, ClassNotFoundException;
}
