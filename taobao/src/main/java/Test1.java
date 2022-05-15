import java.sql.*;

public class Test1 {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/elmdb?useUnicode=true&characterEncoding=utf8";
        String user="elmadmin";
        String password="123456";

        String sql = "select * from table_name";
        Connection connection = DriverManager.getConnection(url,user,password);
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            System.out.println(resultSet.getString("name"));
        }

        resultSet.close();
        preparedStatement.close();
        connection.close();
    }
}