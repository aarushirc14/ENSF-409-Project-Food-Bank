

package edu.ucalgary.ensf409;

import java.util.Arrays;

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
        this.CALORIES = Integer.parseInt(tmp[5]);
        this.WHOLEGRAINS = Integer.parseInt(tmp[1]);
        this.FRUITSVEGGIES = Integer.parseInt(tmp[2]);
        this.PROTEIN = Integer.parseInt(tmp[3]);
        this.OTHER = Integer.parseInt(tmp[4]);

        access.close();
        System.out.println(Arrays.toString(tmp));
    }

    public int getClientID() {
        return this.CLIENTID;
    }

    public String getClientType() {
        return this.CLIENTTYPE;
    }

    public int getWholeGrains() {
        return this.WHOLEGRAINS;
    }

    public int getFruitsVeggies() {
        return this.FRUITSVEGGIES;
    }

    public int getProtein() {
        return this.PROTEIN;
    }

    public int getOther() {
        return this.OTHER;
    }

    public int getCalories() {
        return this.CALORIES;
    }
}
