
package PAT;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
/*
Class Stock
backend of the stockGUI class, extends DBConnect class
in order to communicate with the database
*/
public class Stock extends DBConnect{
    String sql = ""; //Variable to store the query to be executed
    ResultSet rs; // resultset to store the data retrieved from the database
    /*
    Method getstockInfo
    Retrieves all the ingredients information from the database
    @parameters: none
    @return: Resultset of the retrieved information
    */
    public ResultSet getStockInfo() throws SQLException{
        sql = "SELECT * FROM tblInventory;";
        return query(sql);
    }
    /*
    Method getItemNames
    Gets the Names of the items in stock
    @parameters: none
    @return: Resultset of the items names
    */
    public ResultSet getItemNames() throws SQLException{
        sql = "SELECT itemID, itemName FROM tblInventory;";
        return query(sql);
    }
    /*
    Method getOrderInfo
    Retrieves all the pending orders
    @parameters: none
    @return none
    */
    public ResultSet getOrderInfo() throws SQLException{
        sql = "SELECT * FROM tblOrders;";
        return query(sql);
    }
    /*
    Method updateStockItem
    Updates the quantity and/or name of a current stock item
    @parameters: string item id, String item name, Integer quanitity of item
    @return: none
    */
    public void updateStockItem(String _id, String _name, int _quantity) {
        sql = "UPDATE tblInventory SET itemName ='" + _name + "', " +
                                        "itemQuantity =" + _quantity +
                " WHERE itemID = " + _id + ";";
        try {
            update(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Method addStock
    Adds a specified amount of stock to the current amount
    @parameters: String item's ID, int the quanitty to be added
    @return: none
    */
    public void addStock(String ID, int quantity) throws SQLException{
        sql = "SELECT itemQuantity FROM tblInventory WHERE itemID = " + ID + ";";
        rs = query(sql);
        int currentAmo = 0;
        if(rs.next()){
            currentAmo = rs.getInt("itemQuantity"); //get current amount
        }
        //add new amount
        int newAmo = currentAmo + quantity;
        //update the item with the new amount
        sql = "UPDATE tblInventory SET itemQuantity =" + newAmo +
                " WHERE itemID = " + ID + ";";
        update(sql);
    }
    /*
    Method findItem
    Returns the top 5 ingredient matches in terms of the ingredient name provided
    @parameters: String name provided by user
    @return: resultset with the top 5 matches
    */
    public ResultSet findItem(String _name) throws SQLException{
        sql = "SELECT TOP 5 itemID, itemName "
                + "FROM tblInventory "
                + "WHERE itemName LIKE '" + _name+ "*';";
        return query(sql);
    }
    /*
    Method findOrder
    Searches for the selected orderID
    @parameters: string order's ID
    @return: resultset with the selected order's ID
    */
    public ResultSet findOrder(String ID) throws SQLException{
        sql = "SELECT orderID "
                + "FROM tblOrders "
                + "WHERE orderID = " + ID + ";";
        return query(sql);
    }
    /*
    Method getOrderItem
    Retrieves the Item of a specific order
    @parameters: String Order ID
    @return String itemID
    */
    public String getOrderItem(String ID) throws SQLException{
        sql = "SELECT itemID FROM tblOrders WHERE orderID = " + ID + ";";
        rs = query(sql);
        String itemID = "";
        if(rs.next()){
            //retrieves item ID from the resultset
            itemID = rs.getString("itemID");
        }
        return itemID;
    }
    /*
    Method getOrderAmount
    Gets the amount of items in a specific order
    @parameters: String orderID
    @return: int amount of items
    */
    public Integer getOrderAmount(String ID) throws SQLException{
        sql = "SELECT orderQuantity FROM tblOrders WHERE orderID = " + ID + ";";
        rs = query(sql);
        String amount = "";
        if(rs.next()){
            amount = rs.getString("orderQuantity");
        }
        return Integer.parseInt(amount);
    }    
    /*
    Method insertOrder
    Adds a new order to the database
    @parameters: String item's ID, Int amount of item
    @return: none
    */
    public void insertOrder(String _itemID, int _quantity){
        sql = "INSERT INTO tblOrders( itemID, orderQuantity) " +
               "Values ("+   _itemID   + ", "
                        +   _quantity  +"); ";
        try {
            update(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Method deleteOrder
    Deletes order from the database
    @parameters: string orderID
    @return: nothing
    */
    public void deleteOrder(String ID){
        sql = "DELETE FROM tblOrders WHERE orderID = " + ID + ";";
        try {
            update(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Stock.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /*
    Method getItemName
    Gets the name of a specific item in the stock
    @parameters: String item ID
    @return: String name of item
    */
    public String getItemName(String ID) throws SQLException{
        sql = "SELECT itemName FROM tblInventory WHERE itemID = " + ID + ";";
        rs = query(sql);
        String name = "";
        if(rs.next()){
            name = rs.getString("itemName");
        }
        return name;
    }

}
