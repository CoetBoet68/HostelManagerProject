package PAT;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
Admin Class
Class is the backend of the AdminGUI and extends the DB class so that it can connect with the database
an retrieve information from it.
@Parameters: none
*/
public class Admin extends DBConnect{
    String sql; // stores the query that is sent to the database to retrieve the desired info
    ResultSet rs; //stores the Resultset retrieved via the query
    
    /*
    Method getUserInfo()
    Collects all the user info and stores it in a result set
    @parameters: none
    @return Resultset containing all the user info
    */
    public ResultSet getUserInfo() throws SQLException{
        sql = "SELECT * FROM tblUsers";
        return query(sql);
    }
    /*
    Method updateUser
    Updates the current information of a user using a query to the database
    @parameters: String username, String user type, String password, String name, String surname, Bolean tha dictates if user
    is active
    @return nothing
    */
    public void updateUser(String _username, String _type, String _password, String _name, String _surname, boolean _active){
        try {
            String userName = updateUsername(_name, _surname, _username); //calls method that generates a new username
            sql = "UPDATE tblUsers SET userType ='" + _type + "', " +
                                        "uPassword ='" + _password + "', " +
                                        "uName ='" + _name + "', " +
                                        "uSurname ='" + _surname + "', " +
                                        "username = '" + userName + "', " +
                                        "active =" + _active + " " +
                " WHERE username = '" + _username + "';";
            update(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Method insertUser
    Inserts a new user into the database
    @parameters: string user type, String password, String name, String surname, boolean that states if user is active
    @return: nothing
    */
    public void insertUser(String _type, String _password, String _name, String _surname, boolean _active){
        
        try {
            String _username = generateUsername(_name, _surname); //method that generates username for new user 
            sql = "INSERT INTO tblUsers(username, userType, uPassword, uName,uSurname,active) " +
               "Values ('" +   _username  + "', '"
                        +   _type   + "', '"
                        +   _password   + "', '"
                        +   _name   + "', '"
                        +   _surname   + "', "
                        +   _active   +  "); ";
            update(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Method deleteUser
    Deletes current user from the datbase
    @parameters: string user's username
    @return: nothing
    */
    public void deleteUser(String username){
        sql = "DELETE FROM tblUsers WHERE username = '" + username + "';";
        try {
            update(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Method findUser
    Finds the the top five users that match the name that the user provides
    @parameters: String name
    @return: resultSet with all the top 5 user's info in it
    */
    public ResultSet findUser(String _name) throws SQLException{
        sql = "SELECT TOP 5 username, uName, uSurname "
                + "FROM tblUsers "
                + "WHERE uName LIKE '" + _name+ "*';";
        return query(sql);
    }
    /*
    Method generateUsername
    Generates a new username based on the information provided by the user
    @parameters: string user's name, String user's surname
    @return: String new username
    */
    private String generateUsername(String _name, String _surname) throws SQLException{
        // Takes first 3 letters of first name and last 2 letters of the last name and combines them
        String username = _name.substring(0,3) + _surname.substring(0,2);
        sql = "SELECT COUNT(*) AS numUsers FROM tblUsers";
        rs = query(sql);
        if(rs.next()){
        //adds the number user the new user is
        username += rs.getString("numUsers");
        }
        return username;
    }
    /*
    Method updateUsername
    Edits the existing username to adjust with the new data
    @parameters: String user's name, string  user's surname, user's old username
    @return: String new username
    */
    private String updateUsername(String _name, String _surname, String _OldUsername){
        //takes first three letters of name, first two letters of surname and the last number of the username 
        String username = _name.substring(0,3) + _surname.substring(0,2) +_OldUsername.substring(5,6);
        return username;
    }
}
