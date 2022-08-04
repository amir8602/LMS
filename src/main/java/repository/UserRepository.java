package repository;

import domain.User;
import domain.UserBook;

import java.sql.*;
import java.util.List;
import java.util.Optional;

public class UserRepository {


    public User creatUser(User user) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO user(name, family ) values (?,?);");
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getFamily());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int id = 0;
        try {
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("SELECT * FROM user where name=? and family=?  ");
            preparedStatement1.setString(1, user.getName());
            preparedStatement1.setString(2, user.getFamily());
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("Id");
            }
        } catch (SQLException e) {
        }
        return new User(Long.valueOf(id), user.getName(), user.getFamily());
    }


    public Optional<User> getUserById(Long id) {
        Connection connection = getConnection();
        User user = null;

        try {
            PreparedStatement preparedStatement=connection.prepareStatement("select * from User where id=?;");
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user=new User(resultSet.getLong("id"),resultSet.getString("name"),resultSet.getString("family"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(user) ;
    }


    public Optional<User> getUserByNameAndFamily(String name, String family) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement= null;
        User user=new User();
        try {
            preparedStatement = connection.prepareStatement("select * from user where name=? and family=?;");
            preparedStatement.setString(1,name);
            preparedStatement.setString(2,family);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setFamily(resultSet.getString("family"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return Optional.of(user);
    }

    public User updateUser(User user) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE user SET name=? , family=? WHERE id=?;");
            preparedStatement.setString(1,user.getName());
            preparedStatement.setString(2,user.getFamily());
            preparedStatement.setInt(3, Math.toIntExact(user.getId()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void deleteUser(Long id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement1 = null;
        try {
            preparedStatement1 = connection.prepareStatement("DELETE  FROM user where id=? ");
            preparedStatement1.setInt(1, Math.toIntExact(id));
            preparedStatement1.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Deleted");
    }


    public void borrowBook(UserBook userBook) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO user_book(create_date, status, book_fk, user_fk) VALUES (?,?,?,?);");
            preparedStatement.setDate(1,userBook.getCreateDate());
            preparedStatement.setInt(2,0);
            preparedStatement.setInt(3, Math.toIntExact(userBook.getBookFk()));
            preparedStatement.setInt(4, Math.toIntExact(userBook.getUserFk()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/lms", "root", "1995");
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


}
