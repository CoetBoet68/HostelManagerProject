
package PAT;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
Class Meal 
Backend of the MealGUI class and used to communicate with the database
*/
public class Meal extends DBConnect{
    String sql = ""; //Contains the SQL that will be executed
    ResultSet rs; //Contains resultset of the data retrieved from the database
    /*
    Method getRecipNames
    Returns all the recipe names in the datbase of a certain type
    @parameters: String recipe type
    @return: Resultset recipe names
    */
    public ResultSet getRecipeNames(String type) throws SQLException{
        sql = "SELECT recipeName FROM tblRecipes WHERE recipeType = '" + type +"';";
        return query(sql);
    }
    /*
    Method getIngredients
    Retrieves all the ingredients needed to complete a recipe
    @parameters: String recipe ID
    @return: Resultset needed ingredients
    */
    public ResultSet getIngredients(String ID) throws SQLException{
        sql = "SELECT tblIngredients.itemID, tblIngredients.inQuantity " +
                "FROM tblIngredients " +
                "INNER JOIN tblRecipes " +
                "ON tblRecipes.recipeID = tblIngredients.recipeID " +
                "WHERE tblRecipes.recipeID = "+ ID + ";";
        return query(sql);
    }
    /*
    Method getRecipeID
    Gets the recipe ID of the name provided as input
    @parameters: String recipe name
    @return: none
    */
    public String getRecipeID(String recipeName){
        String ID = "";
        try {
            sql ="SELECT recipeID FROM tblRecipes WHERE recipeName = '" + recipeName +"';";
            rs = query(sql);
            if(rs.next()){
                //extract recipe ID
                ID = rs.getString("recipeID");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Meal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ID;
    }
    /*
    Method getAthleteAmount
    Gets the total amount of athletes in the hostel
    @parameters: none
    @return: int amount of athletes
    */
    public int getAthleteAmount(){
        int amount = 0;
        try {
            sql ="SELECT COUNT(*) AS amountOfAthletes\n" +
                    "FROM tblAthlete;";
            rs = query(sql);
            if(rs.next()){
                //extract total amount of athletes from the resultset
                amount = rs.getInt("amountOfAthletes");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(Meal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return amount;
    }
    /*
    Method getItemName
    Retrieves the name of an item based on the ID provided
    */
    public String getItemName(String ID){
        String iName = "";
        try {
            sql ="SELECT itemName FROM tblInventory WHERE itemID = " + ID +";";
            rs = query(sql);
            if(rs.next()){
                // extract item name
                iName = rs.getString("itemName");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Meal.class.getName()).log(Level.SEVERE, null, ex);
        }
        return iName;
    }
}
