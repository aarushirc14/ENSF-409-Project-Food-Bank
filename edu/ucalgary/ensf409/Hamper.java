/**
* @author  Xian, Jaxon, Aarushi, Aryan
* @version 1.5
* @since   2022-04-17
*/
package edu.ucalgary.ensf409;

import java.util.ArrayList;

public class Hamper {

    private ArrayList<Recipient> recipients;
    private ArrayList<Food> foods;

    /**
     * Constructor creates ArrayList of Recipient and Food objects.
     */
    public Hamper() {
        recipients = new ArrayList<Recipient>();
        foods = new ArrayList<Food>();
    }

    /**
     * Getters and setters for recipients and foods
     */
    public ArrayList<Recipient> getRecipients() {
        return recipients;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setRecipients(ArrayList<Recipient> recipients) {
        this.recipients = recipients;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    /**
     * Adds a new recipient to the list, give the recipient's ID.
     * 
     * @param clientID
     */

    public void addNewRecipient(int clientID) {
        recipients.add(new Recipient(clientID));
    }

    /**
     * Returns food name and ID as a string from ArrayList of foods.
     * 
     * @return
     */
    public String foodsToString() {
        String output = "";
        for (int i = 0; i < foods.size(); i++) {
            output += foods.get(i).getItemID() + "\t" + foods.get(i).getName() + "\n";
        }
        return output;
    }

    /**
     * Returns type and number of recipients as a string from ArrayList of
     * recipients.
     * 
     * @return
     */

    public String recipientsToString() {
        String output = "";
        int maleCount = 0;
        int femaleCount = 0;
        int childUnderCount = 0;
        int childOverCount = 0;
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).getClientType().equals("Adult Male")) {
                maleCount++;
            } else if (recipients.get(i).getClientType().equals("Adult Female")) {
                femaleCount++;
            } else if (recipients.get(i).getClientType().equals("Child over 8")) {
                childOverCount++;
            } else if (recipients.get(i).getClientType().equals("Child under 8")) {
                childUnderCount++;
            }
        }
        if (maleCount != 0) {
            output += maleCount + " Adult Male";
        }
        if (femaleCount != 0) {
            if (maleCount == 0) {
                output += femaleCount + " Adult Female";
            } else {
                output += ", " + femaleCount + " Adult Female";
            }
        }
        if (childOverCount != 0) {
            if (femaleCount == 0 && maleCount == 0) {
                output += childOverCount + " Child over 8";
            } else {
                output += ", " + childOverCount + " Child over 8";
            }
        }
        if (childUnderCount != 0) {
            if (maleCount == 0 && femaleCount == 0 && childOverCount == 0) {
                output += childUnderCount + " Child under 8";
            } else {
                output += ", " + childUnderCount + " Child under 8";
            }
        }
        return output;
    }

}
