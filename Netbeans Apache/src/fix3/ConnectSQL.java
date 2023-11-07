package fix3;

import java.sql.*;

public class ConnectSQL {
    private static Connection connection;
    private static Statement statement;
    private static PreparedStatement preparedStatement;
    private static ResultSet resultSet;
    
    public static java.sql.Connection getConexaoMySQL(){
        Connection conn = null;

        String serverName = "localhost";
        String port = "3306";
        String mydatabase = "aula12";
        String url = "jdbc:mysql://" + serverName + ":" + port + "/" + mydatabase;
        String username = "root";
        String password = "1234";

        try{
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e){
            e.printStackTrace();
        }
        return conn;
    }
    
    private static void closeDatabaseConnection() {
        try {
            if (resultSet != null) resultSet.close();
            if (preparedStatement != null) preparedStatement.close();
            if (statement != null) statement.close();
            if (connection != null) connection.close();
        } catch (SQLException e) {
        }
    }
}
