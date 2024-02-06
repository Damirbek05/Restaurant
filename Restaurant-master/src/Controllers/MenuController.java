package Controllers;

import Data.Interface.IDB;
import Entities.Users.User;


import java.util.InputMismatchException;
import java.util.Scanner;
import java.sql.*;
public class MenuController {

    private static String url = "jdbc:mysql://localhost:3306/restaurant";
    private static String user = "root";
    private static String user_pass = "6021";
    public static double getBalance(String username) {
        try {
            Connection conn = DriverManager.getConnection(url,user,user_pass);
            String query = "SELECT balance FROM users WHERE username=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("balance");
            }
            else {
                return -1;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }

    // Update user balance
    public static void updateBalance(String username, double newBalance) {
        try {
            Connection conn = DriverManager.getConnection(url,user,user_pass);
            String query = "UPDATE users SET balance=? WHERE username=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, newBalance);
            stmt.setString(2, username);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Balance updated successfully!");
            }
            else {
                System.out.println("Balance could not be updated!");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Get dish price
    public static double getDishPrice(String dishName) {
        try {
            Connection conn = DriverManager.getConnection(url,user,user_pass);
            String query = "SELECT price FROM menu WHERE food_name=?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, dishName);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("price");
            }
            else {
                return -1;
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
    public void showMenu(){
        try{
            Connection conn = DriverManager.getConnection(url,user,user_pass);
            String query = "SELECT * FROM menu";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                System.out.println(rs.getString("id") + " " + rs.getString("food_name") + " " + rs.getString("price"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void buyDish(String username, String dishName) {
        double balance = getBalance(username);
        double price = getDishPrice(dishName);
        if (balance < price) {
            System.out.println("Insufficient balance!");
            return;
        }
        double newBalance = balance - price;
        updateBalance(username, newBalance);
        System.out.println("Receipt:");
        System.out.println("Dish: " + dishName);
        System.out.println("Price: " + price);
        System.out.println("New balance: " + newBalance);
    }


    public void start() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name: ");
        String username = sc.next();
        System.out.println("Menu:");
        showMenu();
        System.out.print("Dish name: ");
        String dishName = sc.next();
        buyDish(username, dishName);

    }
}
