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

    //My additions
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

/***********ADD CODE HERE***********/

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

/***********ADD CODE HERE***********/
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

/***********ADD CODE HERE***********/
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


    private boolean validateTeacher(String teacherID){

        boolean validTeacher = false;

        try {
            Statement myStmt = dbConnect.createStatement();

            // Execute SQL query
            results = myStmt.executeQuery("SELECT * FROM teacher");

            // Process the results set
            while (results.next()){
                if(results.getString("TeacherID").equals(teacherID))
                    validTeacher = true;
            }

            myStmt.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return validTeacher;

    }


    public void deleteCompetitor(String id){


        try {
            String query = "DELETE FROM competitor WHERE CompetitorID = ?";
            PreparedStatement myStmt = dbConnect.prepareStatement(query);

            myStmt.setString(1,id);
            int rowCount = myStmt.executeUpdate();
            System.out.println("Rows affected: " + rowCount);
            myStmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }



    }

    public void close() {

        try {
            results.close();
            dbConnect.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
    public static void main(String[] args) {

        // Remember that each time you execute the given .sql file, the database will be reset.
        // You should reset the database before each test run of your code.

        //Use the following account information: Username = student, Password = ensf
        AccessFoodInventory myJDBC = new AccessFoodInventory("jdbc:mysql://localhost/food_inventory", "student", "ensf");

        //1 mark - initializeConnection method must create a connection to the database, may not take in any arguments or return any values
        // Must throw an SQLException if connection cannot be made
        myJDBC.initializeConnection();
        String[] tmp = myJDBC.getSpecificFood(1).split(" ");
        System.out.println(tmp[0]);

    }

}
/*
    USE competition;

SELECT * FROM competitor;

 */
