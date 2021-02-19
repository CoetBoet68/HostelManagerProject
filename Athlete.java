
package PAT;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
athlete Class
Class is the backend of the athleteGUI and extends the DB class so that it can connect with the database
an retrieve information from it.
@Parameters: none
*/
public class Athlete extends DBConnect{
    String sql; //string that holds the SQL query
    ResultSet rs; //Resultset to store the info retrieved from the database
    
    /*
    Method getAthleteInfo()
    Collects all the Athletes info and stores it in a result set
    @parameters: none
    @return Resultset containing all the athlete info
    */
    public ResultSet getAthleteInfo() throws SQLException{
        sql = "SELECT * FROM tblAthlete";
        return query(sql);
    }
    /*
    Method getPositionName
    Generates the name of a specific position
    @parameters: int position number
    @return: String name of the position
    */
    public String getPositionName(int pos) throws SQLException{
        sql = "SELECT posName FROM tblPositions WHERE PositionID = "+ pos + ";";
        rs = query(sql);
        if(rs.next()){
            return rs.getString("posName"); //return the name of the position
        }
        return "Unmatched"; //if position not found return "unmatched"
    }
    /*
    Method updateAthlete
    Updates the current information of an Athlete using a query to the database
    @parameters: String athlete ID, String name, String surna,e, int age, int grade, int weight,
    int athlete's position, int length, int missed meal count
    @return nothing
    */
    public void updateAthlete(String _id, String _name, String _surname, int _age, int _grade, int _weight, int _pos, int _length, int _mm) {
        sql = "UPDATE tblAthlete SET athName ='" + _name + "', " +
                                        "athSurname ='" + _surname + "', " +
                                        "athAge =" + _age + ", " +
                                        "athGrade =" + _grade + ", " +
                                        "athWeight=" + _weight + ", " +
                                        "PositionID =" + _pos + ", " +
                                        "athLength =" + _length + ", " +
                                        "missedMeals =" + _mm + 
                " WHERE AthleteID = " + _id + ";";
        try {
            update(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Athlete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Method insertAthlete
    Inserts a new Athlete into the database
    @parameters: String name, String surna,e, int age, int grade, int weight,
    int athlete's position, int length, int missed meal count
    @return: nothing
    */
    public void insertAthlete(String _name, String _surname, int _age, int _grade, int _weight, int _pos, int _length, int _mm){
        sql = "INSERT INTO tblAthlete(athName, athSurname,athAge, athGrade,athWeight,PositionID, athLength, missedMeals) " +
               "Values ('" +   _name  + "', '"
                        +   _surname   + "', "
                        +   _age   + ", "
                        +   _grade   + ", "
                        +   _weight   + ", "
                        +   _pos   + ", "
                        +   _length   + ", "
                        +   _mm   + "); ";
        try {
            update(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Athlete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Method deleteAthlete
    Deletes current athlete from the datbase
    @parameters: string Athlete's ID
    @return: nothing
    */
    public void deleteAthlete(String ID){
        sql = "DELETE FROM tblAthlete WHERE AthleteID = " + ID + ";";
        try {
            update(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Athlete.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Method findAthlete
    Finds the the top five Athletes that match the name that the user provides
    @parameters: String name
    @return: resultSet with all the top 5 athletes' info in it
    */
    public ResultSet findAthlete(String _name) throws SQLException{
        sql = "SELECT TOP 5 AthleteID, athName, athSurname AdmiAdmin,athGrade "
                + "FROM tblAthlete "
                + "WHERE athName LIKE '" + _name+ "*';";
        return query(sql);
    }

}
