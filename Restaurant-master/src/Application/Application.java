package Application;

import Controllers.MenuController;
import Controllers.UserController;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Application {
    private final UserController userController;
    private final MenuController menuController;
    private final Scanner scanner;
    public Application(UserController userController, MenuController menuController) {
        this.userController = userController;
        this.menuController = menuController;
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        while (true) {
            try {
                UserMenu userMenu = new UserMenu(this.userController, scanner);
                AdminMenu adminMenu = new AdminMenu();
                MenuController menuController = new MenuController();
                System.out.println("1. Menu");
                System.out.println("2. Profile");
                System.out.println("3. for Admin");
                System.out.println("0. Exit");
                System.out.println("Option:");
                int option = scanner.nextInt();
                if (option == 1) {
                    menuController.start();
                } else if (option == 2) {
                    userMenu.start();
                } else if (option == 3) {
                    adminMenu.checkAdmin();
                } else if (option==0) {
                    break;
                } else {
                    this.scanner.close();
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() + ": Input must be integer");

            } catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
