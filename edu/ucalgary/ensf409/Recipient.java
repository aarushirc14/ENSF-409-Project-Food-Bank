//Xian Wei Additions start

package edu.ucalgary.ensf409;

public class Recipient {
    private final int CLIENTID;
    private final String CLIENTTYPE;
    private final int WHOLEGRAINS;
    private final int FRUITSVEGGIES;
    private final int PROTEIN;
    private final int OTHER;
    private final int CALORIES;
    private AccessFoodInventory access = new AccessFoodInventory("jdbc:mysql://localhost/food_inventory", "student",
            "ensf");

    public Recipient(int recipientID) {
        if (recipientID > 4 || recipientID < 1) {
            throw new IllegalArgumentException("Recipient does not exist. Please enter another value");
        }
        this.CLIENTID = recipientID;
        access.initializeConnection();
        String[] tmp = access.getSpecificRecipient(recipientID).split("/");
        this.CLIENTTYPE = tmp[0];
        this.WHOLEGRAINS = Integer.parseInt(tmp[1]);
        this.FRUITSVEGGIES = Integer.parseInt(tmp[2]);
        this.PROTEIN = Integer.parseInt(tmp[3]);
        this.OTHER = Integer.parseInt(tmp[4]);
        this.CALORIES = Integer.parseInt(tmp[5]);
        access.close();
    }

    public int getClientID() {
        return this.CLIENTID;
    }

    public String getClientType() {
        return this.CLIENTTYPE;
    }

    // convert contents from percentages to calories
    public int getWholeGrains() {
        return (this.WHOLEGRAINS / 100) * this.CALORIES;
    }

    public int getFruitsVeggies() {
        return (this.FRUITSVEGGIES / 100) * this.CALORIES;
    }

    public int getProtein() {
        return (this.PROTEIN / 100) * this.CALORIES;
    }

    public int getOther() {
        return (this.OTHER / 100) * this.CALORIES;
    }

    public int getCalories() {
        return this.CALORIES;
    }
}
// Xian Wei Additions end