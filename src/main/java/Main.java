import java.sql.*;

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

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try{
            connection = DriverManager.getConnection(databaseURL,username,password);
            System.out.println("Connection to the Oracle database established successfully");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM HR.countries");
            String stringFormat = "%-20s%-20s\n";
            while(resultSet.next()){
                System.out.printf(stringFormat,resultSet.getString("COUNTRY_ID"),resultSet.getString("COUNTRY_NAME"));
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            if(resultSet!=null){
                resultSet.close();
            }
            if (statement!=null){
                statement.close();
            }
            if(connection!=null){
                connection.close();
            }
        }

    }
}
