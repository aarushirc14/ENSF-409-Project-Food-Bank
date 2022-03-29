import java.util.ArrayList;

package edu.ucalgary.ensf409;

public class Hamper {

    private ArrayList<Recipient> recipients;
    private ArrayList<Food> foods;

    public Hamper(){
        recipients = null;
        foods = null;
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
        // will wait until food class is implemented
        // will be used by orderform
    }

    public String recipeintsToString() {
        // will be used by orderform
    }

}