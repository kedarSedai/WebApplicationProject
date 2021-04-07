package DBConnection;

import java.sql.*;

public class DBConnection {

    Connection connection = null;

    public DBConnection() {
        try {


            Class.forName("com.mysql.jdbc.Driver");
            String name = "root";
            String password = "";
            String DB_URL = "jdbc:mysql://localhost:3306/student";

            //Establish Connection
            connection = DriverManager.getConnection(DB_URL, name, password);

            System.out.println("Database Connected !!! ");

            //Creating Statement
            //Statement stmt = connection.createStatement();


        } catch (SQLException | ClassNotFoundException e) {

            e.printStackTrace();

        }


    }

    public static void main(String[] args) {
        DBConnection dbConnection = new DBConnection();
        System.out.println(dbConnection);
    }

    public PreparedStatement getStatement(String query) {

        PreparedStatement pstm = null;

        try {

            pstm = connection.prepareStatement(query);

        } catch (SQLException e) {
            e.printStackTrace();

        }
        return pstm;
    }
}

