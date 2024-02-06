package Controllers;

import Entities.Users.User;
import Repositories.UserRepository.Interface.IUserRepository;



import java.util.List;

public class UserController {
    private final IUserRepository userRepo;

    public UserController(IUserRepository userRepo) {
        this.userRepo = userRepo;
    }


    public String createUser(String user_name, String password, float balance) {
        User user = new User(user_name, password, balance);
        boolean created = userRepo.createUser(user);
        return (created) ? "|------| User created |------|" : "|------| User not created |------|";
    }

    public String deleteUser(int id) {
        boolean deleted = userRepo.deleteUser(id);
        return (deleted) ? "|------| User deleted |------|" : "|------| User not deleted |------|";
    }

    public String updateUserName(int id, String newValue) {
        boolean updated = userRepo.updateUserName(id, newValue);
        return (updated) ? "|------| User updated |------|" : "|------| User not updated |------|";
    }

    public String updateUserPassword(int id, String newValue) {
        boolean updated = userRepo.updateUserPassword(id, newValue);
        return (updated) ? "|------| User updated |------|" : "|------| User not updated |------|";
    }

    public String updateUserBalance(int id, float newValue) {
        boolean updated = userRepo.updateUserBalance(id, newValue);
        return (updated) ? "|------| User updated |------|" : "|------| User not updated |------|";
    }

    public String getUser(int id){
        User u = userRepo.getUser(id);
        return (u != null) ? u.toString() : "|------| User not found |------|";
    }

    public String getAllUsers() {
        List<User> users = userRepo.getAllUsers();
        return users.toString();
    }
}
