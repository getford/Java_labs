import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;

class ConnectionDataBase {
    private Connection connection;

    private static final String url = "jdbc:mysql://localhost:3306/lb10";
    private static final String login = "root";
    private static final String password = "";

    ConnectionDataBase() throws SQLException, ClassNotFoundException {
        setConnection(DriverManager.getConnection(url, login, password));
        if (connection != null) {
            System.out.println("Access granted.");
        } else {
            System.out.println("Access denied.");
        }
    }

    void closeConnect() {
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
