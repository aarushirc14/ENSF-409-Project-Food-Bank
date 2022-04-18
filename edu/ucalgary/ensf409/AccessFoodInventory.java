/**
* @author  Xian, Jaxon, Aarushi, Aryan
* @version 1.5
* @since   2022-04-17
*/

package edu.ucalgary.ensf409;

import java.sql.*;

public class AccessFoodInventory {

    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;

    private int totalFoodItems;

    /**
     * Returns total number of food items in the database.
     * for the inventory provided in D2L this method returns 169
     * when no food items have been deleted.
     * 
     * @return totalFoodItems
     */
    public int getTotalFoodItems() {
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM " + "available_food");
            while (results.next()) {
                if (results.isLast()) {
                    this.totalFoodItems = results.getInt("ItemID");
                }
            }
            myStmt.close();
        } catch (SQLException e) {

        }
        return this.totalFoodItems;
    }

    /**
     * Takes a food item's ID and returns the name and nutritional
     * contents for that item.
     * 
     * @param itemID
     * @return
     */
    public String getSpecificFood(int itemID) {
        StringBuffer full = new StringBuffer();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "available_food");
            while (results.next()) {
                if (results.getInt("ItemID") == itemID) {
                    full.append(results.getString("Name") + "/" + results.getString("GrainContent") + "/"
                            + results.getString("FVContent") + "/" + results.getString("ProContent") + "/"
                            + results.getString("Other") + "/" + results.getString("Calories"));
                }
            }
            myStmt.close();
        } catch (SQLException e) {

        }

        return full.toString();
    }

    /**
     * Takes a recipient's ID and returns the nutritional
     * requirements for that recipient.
     * 
     * @param recipientID
     * @return
     */
    public String getSpecificRecipient(int recipientID) {
        StringBuffer full = new StringBuffer();
        try {

            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "daily_client_needs");
            while (results.next()) {
                if (results.getInt("ClientID") == recipientID) {
                    full.append(results.getString("Client") + "/" + results.getString("WholeGrains") + "/"
                            + results.getString("FruitVeggies") + "/" + results.getString("Protein") + "/"
                            + results.getString("Other") + "/" + results.getString("Calories"));
                }
            }
            myStmt.close();
        } catch (SQLException e) {

        }
        return full.toString();
    }

    /**
     * Deletes a food item from the inventory given the item's ID.
     * 
     * @param id
     */
    public void deleteAvailableFood(String id) {
        try {
            String query = "DELETE FROM available_food WHERE ItemID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1, id);
            myStmt.executeUpdate();
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Closes connection to the database.
     */
    public void dbConnectClose() {
        try {
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Contructor that sets the database's username, password and url.
     * 
     * @param url
     * @param user
     * @param pw
     */

    public AccessFoodInventory(String url, String user, String pw) {

        // Database URL
        this.DBURL = url;

        // Database credentials
        this.USERNAME = user;
        this.PASSWORD = pw;
    }

    /**
     * Creates a connection to the database.
     * Should not have arguments or a return value
     */

    public void initializeConnection() {
        try {
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    /**
     * Getters that return the database's URL, username and password.
     * 
     * @return
     */
    String getDburl() {
        return this.DBURL;
    }

    String getUsername() {
        return this.USERNAME;
    }

    String getPassword() {
        return this.PASSWORD;
    }

    /**
     * Returns a string of all availble foods from the database.
     * 
     * @return
     */
    public String selectAllAvailableFood() {

        StringBuffer full = new StringBuffer();
        try {

            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM " + "available_food");

            while (results.next()) {

                full.append(results.getString("ItemID") + ", " + results.getString("Name"));
                full.append("\n");
            }
            full.deleteCharAt(full.length() - 1);
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return full.toString();
    }

    /**
     * Returns a string of all client's daily nutritional requirememts from the
     * database.
     * 
     * @return
     */
    public String selectAllDailyClientNeeds() {

        StringBuffer full = new StringBuffer();
        try {

            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM " + "daily_client_needs");

            while (results.next()) {

                full.append(results.getString("ClientID") + ", " + results.getString("Client"));
                full.append("\n");
            }
            full.deleteCharAt(full.length() - 1);
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return full.toString();
    }

    /**
     * Closes connection to database.
     */
    public void close() {

        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}
