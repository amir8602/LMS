package service;

import domain.User;
import domain.UserBook;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User creatUser(User user);
    Optional<User> getUserById(Long Id);
    Optional<User> getUserByNameAndFamily(String name,String family);
    User updateUser(User user);
    void deleteUser(Long Id);
    void borrowBook(UserBook userBook);

}

//Optional<List<User>> getMemberByFamily(String family);
//Optional<User> getMemberByPojo(User user);