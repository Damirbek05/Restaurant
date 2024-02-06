package Application;


import Controllers.UserController;
import Entities.Users.User;


import java.util.InputMismatchException;
import java.util.Scanner;

import static Repositories.DBProperties.DBUserProperties.*;

public class UserMenu {

    Scanner scanner;
    UserController userController;

    public UserMenu(UserController userController, Scanner scanner) {
        this.userController = userController;
        this.scanner = scanner;
    }
    public void start() {
        while (true) {
            System.out.println();
            System.out.println("**********************************");
            System.out.println("Welcome to My Application");
            System.out.println("Select option:");
            System.out.println("1. Create user");
            System.out.println("2. Update user");
            System.out.println("3. Delete user");

            System.out.println("0. Exit");
            System.out.println();

            try {
                System.out.print("Enter option (1-3): ");
                int option = scanner.nextInt();
                if (option == 1) {
                    createUserMenu();
                } else if (option == 2) {
                    updateUserMenu();
                } else if (option == 3) {
                    deleteUserMenu();
                }  else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() + ": Input must be integer");
                scanner.nextLine(); // to ignore incorrect input
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println("**********************************");
        }
    }

    public void createUserMenu() {
        System.out.println("Please enter " + DB_User_Name);
        String name = scanner.next();

        System.out.println("Please enter " + DB_User_Password);
        String password = scanner.next();

        System.out.println("Please enter " + DB_User_Balance);
        float balance = scanner.nextFloat();

        String response = userController.createUser(name, password, balance);
        System.out.println(response);
    }

    public void updateUserMenu(){
        System.out.print("Enter id: ");
        int id = scanner.nextInt();
        while(true) {
            userController.getUser(id).toString();
            System.out.print("Edit:" +
                    "\n1. " + DB_User_Name +
                    "\n2. " + DB_User_Password +
                    "\n3. " + DB_User_Balance +
                    "\n9. back" +
                    "\nEnter option(1-5): ");
            try {
                int option = scanner.nextInt();
                if (option == 1) {
                    System.out.print("Edit" + DB_User_Name + " : ");
                    System.out.println("\t" + userController.updateUserName(id, scanner.next()));
                } else if (option == 2) {
                    System.out.print("Edit" + DB_User_Password + " : ");
                    System.out.println("\t" + userController.updateUserPassword(id, scanner.next()));
                } else if (option == 3) {
                    System.out.print("Edit" + DB_User_Balance + " : ");
                    System.out.println("\t" + userController.updateUserBalance(id, scanner.nextFloat()));
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage() + ": Input must be integer");
                scanner.nextLine();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void deleteUserMenu(){
        System.out.print("Please enter id: ");

        int id = scanner.nextInt();
        String response = userController.deleteUser(id);
        System.out.println(response);
    }

}
