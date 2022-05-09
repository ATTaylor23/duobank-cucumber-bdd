package utilities;

import java.sql.*;

public class TestJDBC_DuoBank {

    public static void main(String[] args) throws SQLException {

        String url = "jdbc:mysql://db-duotech.cc652zs7kmja.us-east-2.rds.amazonaws.com/loan";

        Connection connection = DriverManager.getConnection(url, "duotech", "duotech2021");

        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        ResultSet resultSet = statement.executeQuery("Select * from tbl_mortagage limit 10");

        resultSet.next();
        System.out.println(resultSet.getString(3));

        resultSet.absolute(5);

        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println(metaData.getColumnCount());

        System.out.println(metaData.getColumnName(2));


    }

}
