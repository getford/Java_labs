import com.mysql.jdbc.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;

class ConnectionDataBase {
    private Connection connection;

    private static final String url = "jdbc:mysql://localhost:3306/lb10";
    private static final String login = "root";
    private static final String password = "";

    ConnectionDataBase() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.jdbc.Driver");
        setConnection((Connection) DriverManager.getConnection(url, login, password));
        if (connection != null) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }

    void close() {
        try {
            getConnection().close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
}
