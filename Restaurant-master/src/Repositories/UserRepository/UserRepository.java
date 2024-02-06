package Repositories.UserRepository;

import Data.Interface.IDB;
import Entities.Users.User;
import Repositories.UserRepository.Interface.IUserRepository;

import java.sql.*;
import java.util.LinkedList;
import java.util.List;

import static Repositories.DBProperties.DBUserProperties.*;

public class UserRepository implements IUserRepository {
    private static IDB db;

    public UserRepository(IDB db) {
        this.db = db;
    }

    @Override
    public boolean createUser(User user) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO users"  + "(" +
                    DB_User_Name + "," +
                    DB_User_Password + "," +
                    DB_User_Balance + ") VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, user.getUserName());
            st.setString(2, user.getPassword());
            st.setFloat(3, user.getBalance());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

    @Override
    public boolean deleteUser(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM users" + " WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.executeUpdate();
            return true;
        } catch(SQLException throwables){
            throwables.printStackTrace();
        } catch(ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch(SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateUserName(int id, String newValue) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE users SET " + DB_User_Name + " = ? WHERE id=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, newValue);
            st.setInt(2, id);


            st.executeUpdate();
            return true;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateUserPassword(int id, String newValue) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE users SET " + DB_User_Password + " = ? WHERE id=?";

            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, newValue);
            st.setInt(2, id);

            st.executeUpdate();
            return true;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean updateUserBalance(int id, float newValue) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "UPDATE users SET " + DB_User_Balance + " = ? WHERE id=?";

            PreparedStatement st = con.prepareStatement(sql);

            st.setFloat(1, newValue);
            st.setInt(2, id);


            st.executeUpdate();
            return true;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public User getUser(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT " +
                    DB_User_Name + "," +
                    DB_User_Password + "," +
                    DB_User_Balance + " FROM users WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();

            if(rs.next()) {
                User user = new User(rs.getString(DB_User_Name),
                        rs.getString(DB_User_Password),
                        rs.getFloat(DB_User_Balance),
                        rs.getInt(DB_User_Id));
                return user;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT " + DB_User_Id +"," +
                    DB_User_Name + "," +
                    DB_User_Password + "," +
                    DB_User_Balance + " FROM users";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<User> users = new LinkedList<>();
            while(rs.next()) {
                User user = new User(rs.getString(DB_User_Name),
                        rs.getString(DB_User_Password),
                        rs.getFloat(DB_User_Balance),
                        rs.getInt(DB_User_Id));

                users.add(user);
            }

            return users;
        } catch (SQLException throwables){
            throwables.printStackTrace();
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables){
                throwables.printStackTrace();
            }
        }
        return null;
    }
    }

