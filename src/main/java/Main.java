import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    static final String databaseURL = "jdbc:oracle:thin:@localhost:49161:xe";
    static final String username = "system";
    static final String password = "oracle";
    public static void main(String[] args) throws SQLException {

        try {

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (ClassNotFoundException e) {

            System.out.println("Where is your Oracle JDBC Driver?");
            e.printStackTrace();
            return;

        }

        Connection connection = DriverManager.getConnection(databaseURL,username,password);

        System.out.println("Connection to the Oracle database established successfully");

        connection.close();
    }
}
