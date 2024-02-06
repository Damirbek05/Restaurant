import Application.Application;
import Controllers.MenuController;
import Controllers.UserController;
import Data.Interface.IDB;
import Data.Mysql;
import Repositories.UserRepository.Interface.IUserRepository;
import Repositories.UserRepository.*;

public class Main {
    public static void main(String[] args) {


        IDB db = new Mysql();


        IUserRepository userRepo = new UserRepository(db);
        UserController userController = new UserController(userRepo);
        MenuController menuController = new MenuController();


        Application app = new Application(userController, menuController);
        app.start();

    }
}