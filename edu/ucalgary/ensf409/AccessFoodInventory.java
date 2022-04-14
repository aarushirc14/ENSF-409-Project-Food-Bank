/*
Copyright Ann Barcomb and Emily Marasco, 2022
Licensed under GPL v3
See LICENSE.txt for more information.
*/

package edu.ucalgary.ensf409;

import java.sql.*;

public class AccessFoodInventory{

    public final String DBURL;
    public final String USERNAME;
    public final String PASSWORD;

    private Connection dbConnect;
    private ResultSet results;

    //Xian Wei Low additions
    private int totalFoodItems;

    public int getTotalFoodItems(){
        try {
            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM " + "available_food");
            while(results.next()){
                if(results.isLast()){
                    this.totalFoodItems = results.getInt("ItemID");
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        return this.totalFoodItems;
    }

    public String getSpecificFood(int itemID){
        StringBuffer full = new StringBuffer();
        try {
            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "available_food");
            while(results.next()){
                if(results.getInt("ItemID") == itemID){
                    full.append(results.getString("Name") + "/" + results.getString("GrainContent") + "/"
                            + results.getString("FVContent") + "/" + results.getString("ProContent") + "/"
                            + results.getString("Other") + "/" + results.getString("Calories"));
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }

        return full.toString();
    }
    public String getSpecificRecipient(int recipientID){
        StringBuffer full = new StringBuffer();
        try {

            Statement myStmt = dbConnect.createStatement();
            results = myStmt.executeQuery("SELECT * FROM " + "daily_client_needs");
            while(results.next()){
                if(results.getInt("ClientID") == recipientID){
                    full.append(results.getString("Client") + "/" + results.getString("WholeGrains") + "/"
                            + results.getString("FruitVeggies") + "/" + results.getString("Protein") + "/"
                            + results.getString("Other") + "/" + results.getString("Calories"));
                }
            }
            myStmt.close();
        }catch(SQLException e){

        }
        return full.toString();
    }

    public void deleteAvailableFood(String id){
        try {
            String query = "DELETE FROM available_food WHERE ItemID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1,id);
            int rowCount = myStmt.executeUpdate();
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void dbConnectClose(){
        try {
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
//Xian Wei Additions end

    public AccessFoodInventory(String url, String user, String pw){

        // Database URL
        this.DBURL = url;

        //  Database credentials
        this.USERNAME = user;
        this.PASSWORD = pw;
    }


    //Must create a connection to the database, no arguments, no return value
    public void initializeConnection(){
        try {
            dbConnect = DriverManager.getConnection(this.DBURL, this.USERNAME, this.PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    String getDburl(){
        return this.DBURL;
    }

    String getUsername(){
        return this.USERNAME;
    }

    String getPassword(){
        return this.PASSWORD;
    }


    public String selectAllAvailableFood(){

        StringBuffer full = new StringBuffer();
        try {

            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM " + "available_food");

            while(results.next()){

                full.append(results.getString("ItemID") + ", "  + results.getString("Name"));
                full.append("\n");
            }
            full.deleteCharAt(full.length() - 1);
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return full.toString();
    }
    public String selectAllDailyClientNeeds(){

        StringBuffer full = new StringBuffer();
        try {

            Statement myStmt = dbConnect.createStatement();
            ResultSet results = myStmt.executeQuery("SELECT * FROM " + "daily_client_needs");

            while(results.next()){

                full.append(results.getString("ClientID") + ", "  + results.getString("Client"));
                full.append("\n");
            }
            full.deleteCharAt(full.length() - 1);
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return full.toString();
    }

    public void close() {

        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
/*
    USE competition;

SELECT * FROM competitor;

 */
