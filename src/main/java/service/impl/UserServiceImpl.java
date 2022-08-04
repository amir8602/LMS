package service.impl;

import domain.User;
import domain.UserBook;
import repository.UserRepository;
import service.UserService;

import java.util.Optional;

public class UserServiceImpl implements UserService {
    UserRepository userRepository = new UserRepository();


    @Override
    public User creatUser(User user) {
        return userRepository.creatUser(user);
    }

    @Override
    public Optional<User> getUserById(Long id) {
        return userRepository.getUserById(id);
    }

    @Override
    public Optional<User> getUserByNameAndFamily(String name, String family) {
        return userRepository.getUserByNameAndFamily(name , family);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteUser(id);
    }

    @Override
    public void borrowBook(UserBook userBook) {
        userRepository.borrowBook(userBook);
    }


}
