import domain.Book;
import domain.User;
import domain.UserBook;
import service.BookService;
import service.UserService;
import service.impl.BookServiceImpl;
import service.impl.UserServiceImpl;
import java.lang.reflect.*;

import java.sql.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BookService bookService = new BookServiceImpl();
        UserService userService = new UserServiceImpl();
        Scanner scanner = new Scanner(System.in);
        String name, family, author;
        Long id;
        Book.Status status;





        Integer selectedOption, statusInt;

        while (true) {
            System.out.println("LMS");
            System.out.println("-- Book operation --");
            System.out.println();
            System.out.println("1 - Add book");
            System.out.println("2 - Delete book");
            System.out.println("3 - Update book");
            System.out.println("4 - Get book by name of book");
            System.out.println("5 - Get book by id of book");
            System.out.println();
            System.out.println("-- User operation --");
            System.out.println();
            System.out.println("6 - Add user");
            System.out.println("7 - Delete user");
            System.out.println("8 - Update user");
            System.out.println("9 - Get user by name and family");
            System.out.println("10 - Get user by id of user");
            System.out.println("11 - Borrow book");
            System.out.println("12 - Get back book");
            System.out.println();
            System.out.printf("Select option : ");
            selectedOption = scanner.nextInt();

            if (selectedOption == 1) {
                System.out.println("Add book");
                System.out.printf("name : ");
                name = scanner.next();
                System.out.printf("author : ");
                author = scanner.next();
                Book book = new Book(name, author, Book.Status.RETURNED);
                System.out.println(bookService.creatBook(book));
            } else if (selectedOption == 2) {
                System.out.println("Delete book");
                System.out.printf("id : ");
                id = scanner.nextLong();
                bookService.deleteBook(id);
            } else if (selectedOption == 3) {
                System.out.println("Update book");
                System.out.printf("id : ");
                id = scanner.nextLong();
                System.out.printf("name : ");
                name = scanner.next();
                System.out.printf("author : ");
                author = scanner.next();
                System.out.printf("status : ");
                statusInt = scanner.nextInt();
                if (statusInt == 1)
                    status = Book.Status.RETURNED;
                else
                    status = Book.Status.BORROWED;
                System.out.println(bookService.updateBook(new Book(id, name, author, status)));

            } else if (selectedOption == 4) {
                System.out.println("Get book by name of book");
                System.out.printf("name : ");
                name = scanner.next();
                System.out.println(bookService.getBookByName(name));
            } else if (selectedOption == 5) {
                System.out.println("Get book by id of book");
                System.out.printf("id : ");
                id = scanner.nextLong();
                System.out.println(bookService.getBookById(id));
            } else if (selectedOption == 6) {
                System.out.println("Add user");
                System.out.printf("name : ");
                name = scanner.next();
                System.out.printf("family : ");
                family = scanner.next();
                System.out.println(userService.creatUser(new User(name, family)));
            } else if (selectedOption == 7) {
                System.out.println("Delete user");
                System.out.println("id : ");
                id = scanner.nextLong();
                userService.deleteUser(id);
            } else if (selectedOption == 8) {
                System.out.println("Update user");
                System.out.printf("id : ");
                id = scanner.nextLong();
                System.out.printf("name : ");
                name = scanner.next();
                System.out.printf("family : ");
                family = scanner.next();
                System.out.println(userService.updateUser(new User(id, name, family)));
            } else if (selectedOption == 9) {
                System.out.println("Get user by name and family");
                System.out.println("name : ");
                name = scanner.next();
                System.out.printf("family : ");
                family = scanner.next();
                System.out.println(userService.getUserByNameAndFamily(name, family));
            } else if (selectedOption == 10) {
                System.out.println("Get user by id of user");
                System.out.printf("id : ");
                id = scanner.nextLong();
                System.out.println(userService.getUserById(id));
            } else if (selectedOption == 11) {
                System.out.println("Borrow book");
                System.out.printf("name of user : ");
                name = scanner.next();
                System.out.printf("family of user : ");
                family = scanner.next();
                User user = userService.getUserByNameAndFamily(name, family).get();
                System.out.println(user);
                System.out.printf("name of book : ");
                name = scanner.next();
                Book book = bookService.getBookByName(name).get();
                System.out.println(book);
                if (book.getStatus() == Book.Status.BORROWED) {
                    System.out.println("Not Available");
                } else {
                    long time = System.currentTimeMillis();
                    UserBook userBook = new UserBook(new Date(time), Book.Status.BORROWED, book.getId(), user.getId());
                    userService.borrowBook(userBook);
                }

            } else if (selectedOption == 12) {

            }


        }

    }

}


//    JFrame jFrame = new JFrame();
//            JButton jButton = new JButton("click");
//
//
//            jButton.setBounds(130,100,100, 40);
//            JCheckBox jCheckBox = new JCheckBox();
//            jCheckBox.setBounds(250,200,200, 50);
//            JComboBox jComboBox = new JComboBox();
//            jComboBox.setBounds(400,200,200, 50);
//            jFrame.add(jCheckBox);
//            jFrame.add(jButton);
//            jFrame.setSize(500,500);
//            jFrame.setLayout(null);
//            jFrame.setVisible(true);