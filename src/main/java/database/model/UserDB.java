package database.model;

import database.Connector.MyConnection;

import java.sql.*;
import java.util.ArrayList;

public class UserDB {

    public static ArrayList<User> getAllUsers() throws SQLException, ClassNotFoundException {
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users order by user_id";
        Statement statement = MyConnection.openConnection().createStatement();
        final ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String name = resultSet.getString("name");
            String surname = resultSet.getString("surname");
            int age = resultSet.getInt(4);
            User user = new User(id, name, surname, age);
            users.add(user);
        }
        return users;
    }

    public static int createUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO  users (name, surname, age) Values (?, ?, ?)";
        PreparedStatement preparedStatement = MyConnection.openConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setInt(3, user.getAge());
        return preparedStatement.executeUpdate();
    }

    public static User getUser(int id) throws SQLException, ClassNotFoundException {
        User user = null;
        String sql = "SELECT * FROM users WHERE user_id=?";

        PreparedStatement preparedStatement = MyConnection.openConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            int userId = resultSet.getInt(1);
            String name = resultSet.getString(2);
            String surname = resultSet.getString(3);
            int age = resultSet.getInt(4);
            user = new User(userId, name, surname, age);
        }
        return user;
    }

    public static int updateUser(User user) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE users SET name = ?, surname = ?, age = ? WHERE user_id = ?";
        PreparedStatement preparedStatement = MyConnection.openConnection().prepareStatement(sql);
        preparedStatement.setString(1, user.getName());
        preparedStatement.setString(2, user.getSurname());
        preparedStatement.setInt(3, user.getAge());
        preparedStatement.setInt(4, user.getId());
        return preparedStatement.executeUpdate();
    }

    public static int deleteUser(int id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM users WHERE user_id = ?";
        PreparedStatement preparedStatement = MyConnection.openConnection().prepareStatement(sql);
        preparedStatement.setInt(1, id);
        return preparedStatement.executeUpdate();
    }
}
