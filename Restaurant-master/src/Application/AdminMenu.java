package Application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;

public class AdminMenu {
    private String Admin_name;
    private String Admin_password;
    private Connection con;



    public void checkAdmin() {
        System.out.println("Username: ");
        Scanner in = new Scanner(System.in);
        Admin_name = in.next();
        System.out.println("Password: ");
        Admin_password = in.next();
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/restaurant", "root", "6021");
            String sql = "select * from admin where Admin_name = ? and Admin_password = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, Admin_name);
            stmt.setString(2, Admin_password);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                System.out.println("Welcome "+Admin_name+"!");
                changeMenu();
            }
            else
                System.out.println("Error: User not found!");
        }
        catch(SQLException ex) {
            System.out.println(ex);
        }
    }

    public void changeMenu() {
        Scanner sc = new Scanner(System.in);
        String sql = "update menu set price = ? where Food_name = ?";
        try {

            System.out.println("Enter the dish name to update: ");
            String food_name = sc.next();
            System.out.println("Enter the new price of the dish: ");
            int price = sc.nextInt();
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, price);
            stmt.setString(2, food_name);
            int rows = stmt.executeUpdate();
            if(rows>0)
                System.out.println("Price of "+food_name+" updated successfully!");
            else
                System.out.println("Error in updating price of "+food_name);
        }
        catch(SQLException ex) {
            System.out.println(ex);
        }
    }
}
