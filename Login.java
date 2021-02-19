
package PAT;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
Class Login
Backend of the LoginGUI that checks that all the information is correct and that only
people with the correct permissions acces the program
*/
public class Login extends DBConnect{
    
    User users[]; //Array of user instances
    private int amountOfUsers = 0; //Counter variable for the amount of users
    private String sql; //String containing the SQL sent to the database
    private ResultSet rs; //resultset to store the data received from the database
    private int userIndex; //Used to reference the currently selected user
    /*
    Method intitiateUsers
    Used to determine the size of the users[] array and initialize it
    @parameters: none
    @return: none
    */
    private void initiateUsers(){
        try {
            sql = "SELECT COUNT(*) AS [Amount] FROM tblUsers;";
            rs = query(sql);
            if(rs.next()){
                amountOfUsers = rs.getInt("Amount");
                //Initialize array with total number of users in the database
                users = new User[amountOfUsers];
            }
        } catch (SQLException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Method populateUsers
    Populates the users[] array with the user data from the database
    @parameters: none
    @return: none
    */
    public void populateUsers() throws SQLException{
        initiateUsers(); //intialize the users[] array
        sql = "SELECT * FROM tblUsers;";
        rs = query(sql);
            for(int i = 0; i < amountOfUsers; i ++){
                if(rs.next()){
                    //extract user information from resultset
                    String username = rs.getString("username");
                    String uType = rs.getString("userType");
                    String pw= rs.getString("uPassword");
                    String uName = rs.getString("uName");
                    String uSurname= rs.getString("uSurname");
                    boolean active = rs.getBoolean("active");
                    //Create a new user object with extracted data from the resultset
                    users[i] = new User(username, uType, pw, uName, uSurname, active);
                }
            }
    }
    /*
    Method userExists
    Checks if the user is in the database and if they are the userIndex is changed to 
    the user count (the number of user it is)
    @parameters: String Username 
    @return: Boolean true or false
    */            
    public boolean userExists(String un){
        boolean userFound = false;
        int count = 0;
        while(userFound != true && count < amountOfUsers){
            //checks if the username is in the database
            if(un.equals(users[count].getUsername())){
                userFound = true;
                userIndex = count;
            }else{
                count++;
            }
        }
        //return if the user is found or not
        return userFound;
    }
    /*
    Method passwordCorrect
    Checks if password is correct
    @parameters: String password
    @return: boolean true or false
    */
    public boolean passwordCorrect(String pw){
        return users[userIndex].getPassword().equals(pw);
    }
    /*
    Method isActive
    Checks if the user's account is active
    @parameters: none
    @return: boolean true or false
    */
    public boolean isActive(){
        return users[userIndex].isActive();
    }
    /*
    Method getUserType
    Gets the type of user of the specified user
    @parameters: none
    @return: String user type
    */
    public String getUserType(){
        return users[userIndex].getUserType(); 
    }
    /*
    Method getUserInfo
    Provides the info of the specified user
    @parameters: none
    @return: String user info
    */
    public String getUserInfo(){
        return users[userIndex].getInfo();
    }

    

}
