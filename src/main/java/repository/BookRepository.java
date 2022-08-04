package repository;

import domain.Book;

import java.sql.*;
import java.util.Optional;

public class BookRepository {


    public Book creatBook(Book book) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement =
                    connection.prepareStatement("INSERT INTO book(name,status,author ) values (?,?,?);");
            preparedStatement.setString(1, book.getName());
            preparedStatement.setInt(2, book.getStatus().ordinal());
            preparedStatement.setString(3,book.getAuthor());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        int id = 0;
        try {
            PreparedStatement preparedStatement1 =
                    connection.prepareStatement("SELECT id FROM book where name=? and status=? and author=?;");
            preparedStatement1.setString(1, book.getName());
            preparedStatement1.setInt(2,1);
            preparedStatement1.setString(3,book.getAuthor());
            System.out.println(preparedStatement1);
            ResultSet resultSet = preparedStatement1.executeQuery();
            while (resultSet.next()) {
                id = resultSet.getInt("Id");
            }
        } catch (SQLException e) {
        }
        return new Book(Long.valueOf(id), book.getName(),book.getAuthor() ,book.getStatus());
    }




    public Optional<Book> getBookById(Long id) {
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        Book book=new Book();
        try {
            preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE id=?;");
            preparedStatement.setInt(1, Math.toIntExact(id));
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                book.setId((long) resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                if (resultSet.getInt("status")==1){
                    book.setStatus(Book.Status.RETURNED);
                }else {
                    book.setStatus(Book.Status.BORROWED);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(book);
    }


    public Optional<Book> getBookByName(String name) {
        Book book=new Book();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM book WHERE name=?;");
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                book.setId((long) resultSet.getInt("id"));
                book.setName(resultSet.getString("name"));
                book.setAuthor(resultSet.getString("author"));
                if (resultSet.getInt("status")==1){
                    book.setStatus(Book.Status.RETURNED);
                }else {
                    book.setStatus(Book.Status.BORROWED);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.of(book);
    }


    public Book updateBook(Book book) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE book SET name=? , author=? , status=? where id=?;");
            preparedStatement.setString(1,book.getName());
            preparedStatement.setString(2,book.getAuthor());
            preparedStatement.setInt(3,book.getStatus().ordinal());
            preparedStatement.setInt(4, Math.toIntExact(book.getId()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return book;
    }

    public void deleteBook(Long id) {
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM book WHERE id=?;");
            preparedStatement.setInt(1, Math.toIntExact(id));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Deleted");
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

//    public Optional<List<Book>> getBookByPojo(Book book) {
//        //todo
//        return null;
//    }
//
//    public Optional<List<Book>> getAllBook() {
//        Connection connection = getConnection();
//        List<Book> books = new ArrayList<>();
//        try {
//            Statement statement = connection.createStatement();
//
//            ResultSet resultSet = statement.executeQuery("SELECT * FROM book WHERE broowed=1");
//            while (resultSet.next()){
//                books.add(new Book(resultSet.getString("name"), Book.statusOfBook.Available));
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        Optional<List<Book>> books1 = Optional.of(books);
//        return books1;
//    }
//public Optional<List<Book>> getBookBySearchSubName(String subName) {
//    //todo
//    return null;
//}