package Service;

import DBConnection.DBConnection;
import Model.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    // Return single user
    public User getUser(String username, String password) {
        User user = null;
        String query = "Select * from user where username = ? and password = ?";

        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, username);
            pstm.setString(2, password);

            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                user = new User();

                user.setId(rs.getInt("id"));
                user.setRole(rs.getString("role"));
                user.setPassword(rs.getString("password"));
                user.setUsername(rs.getString("username"));
                user.setFull_name(rs.getString("fullname"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    //return
    public List<User> getUserList() {

        ArrayList<User> getUserList = new ArrayList<User>();

        String query = "Select * from user";

        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {

            ResultSet rs = pstm.executeQuery();
            while (rs.next()) {
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setRole(rs.getString("role"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFull_name(rs.getString("fullname"));

                getUserList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return getUserList;
    }

    //Insert User
    public void insertUser(User user) {
        String query = "insert into user (username, role, password, fullname)" + "values(?,?,?,?)";

        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setString(1, user.getFull_name());
            pstm.setString(2, user.getUsername());
            pstm.setString(3, user.getPassword());
            pstm.setString(4, user.getRole());

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }

    //Delete User
    public void deleteUser(int id) {

        String query = "delete from user where id = ?";

        PreparedStatement pstm = new DBConnection().getStatement(query);
        try {
            pstm.setInt(1, id);

            pstm.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //Update User

    public void updateUser(int id, User user) throws SQLException {
        String query = "update from user set fullname = ?, username = ?, role = ?, password = ?," + "where id = ?";

        PreparedStatement pstm = new DBConnection().getStatement(query);

        pstm.setString(1, user.getFull_name());
        pstm.setString(2, user.getUsername());
        pstm.setString(3, user.getPassword());
        pstm.setString(4, user.getRole());
        pstm.setInt(5, user.getId());

        pstm.execute();


    }

    public User getRow(int id) {
        User user = new User();
        String query = "select * from user where id = ?";
        PreparedStatement pstm = new DBConnection().getStatement(query);

        try {

            pstm.setInt(1, id);
            ResultSet rs = pstm.executeQuery();

            while (rs.next()) {
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFull_name(rs.getString("fullname"));
                user.setRole(rs.getString("role"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return user;
    }
}














