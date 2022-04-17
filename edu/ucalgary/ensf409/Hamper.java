package edu.ucalgary.ensf409;

import java.util.ArrayList;


public class Hamper {

    private ArrayList<Recipient> recipients;
    private ArrayList<Food> foods;

    public Hamper(){
        recipients = new ArrayList<Recipient>();
        foods = new ArrayList<Food>();
    }

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

    public void addNewRecipient(int clientID) {
        recipients.add(new Recipient(clientID));
    }

    public String foodsToString() {
        String output = "";
        for (int i = 0; i < foods.size(); i++) {
            output += foods.get(i).getItemID() + "\t" + foods.get(i).getName() + "\n";
        }
        return output;
    }

    public String recipientsToString() {
        String output = "";
        int maleCount = 0;
        int femaleCount = 0;
        int childUnderCount = 0;
        int childOverCount = 0;
        for (int i = 0; i < recipients.size(); i++) {
            if (recipients.get(i).getClientType().equals("Adult Male")){
                maleCount++;
            }
            else if (recipients.get(i).getClientType().equals("Adult Female")){
                femaleCount++;
            }
            else if (recipients.get(i).getClientType().equals("Child Over 8")) {
                childOverCount++;
            }
            else if (recipients.get(i).getClientType().equals("Child Under 8")) {
                childUnderCount++;
            }
        }
        if (maleCount != 0) {
            output += maleCount + " Adult Male, ";
        }
        if (femaleCount != 0) {
            output += femaleCount + " Adult Female, ";
        }
        if (childOverCount != 0) {
            output += childOverCount + " Child Over 8, ";
        }
        if (childUnderCount != 0) {
            output += childUnderCount + " Child Under 8, ";
        }
        return output;
    }

}