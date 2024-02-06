package Repositories.UserRepository.Interface;

import Entities.Users.User;

import java.util.List;

public interface IUserRepository {
    public boolean createUser(User user);
    public boolean deleteUser(int id);
    public boolean updateUserName(int id, String newValue);
    public boolean updateUserPassword(int id, String newValue);
    public boolean updateUserBalance(int id, float newValue);
    public User getUser(int id);

    List<User> getAllUsers();
}
