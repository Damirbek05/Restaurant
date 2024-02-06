package Entities.Users.Interfaces;

public interface IUser {
    public String getUserName();
    public void setUserName(String userName);
    public String getPassword();
    public void setPassword(String password);
    public int getId();
    public void setId(int id);
    public String toString();
}
