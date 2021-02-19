package PAT;
import java.sql.*;
import javax.swing.*;
/*
Class user
Stores the info of an individual user
*/
public class User {
    //User details
    private String username = "";
    private String userType = ""; 
    private String pw = "";
    private String uName = "";
    private String uSurname = "";
    private boolean active = true;
    /*
    Constructor method
    Creates an object of the class with all the data provided
    @parameters: String username, String user type, String password, String name, String surname, boolean is user active
    @return: none
    */
    public User(String _username, String _userType, String _pw, String _uName, String _uSurname, boolean _active){
        username = _username;
        userType = _userType;
        pw = _pw;
        uName = _uName;
        uSurname = _uSurname;
        active = _active;
    }
    /*
    Method getUsername
    Accessor Method for the username
    @parameters: none
    @return: String username
    */
    public String getUsername(){
        return username;
    }
    /*
    Method getPassword
    AccesorMethod to get the password
    @parameters: none
    @return: String password
    */
    public String getPassword(){
        return pw;
    }
    /*
    Method isActive
    Checks to see if user is active
    @parameters: none
    @return: boolean if user is active
    */
    public boolean isActive(){
        return active;
    }
    /*
    Method getUserType
    Accesor Method to get the userType
    @parameters: none
    @return: String user type
    */
    public String getUserType(){
        return userType;
    }
    /*
    Method getInfo
    Combines the user's name and surname in a single string
    @parameters: none
    @return: string fullname
    */
    public String getInfo(){
        return uName + " " + uSurname;
    }
}
