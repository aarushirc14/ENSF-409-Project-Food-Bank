
package edu.ucalgary.ensf409;

public class Food {
    private final int ITEM_ID;
    private final String NAME;
    private final int GRAIN_CONTENT;
    private final int FV_CONTENT;
    private final int PRO_CONTENT;
    private final int OTHER_CONTENT;
    private final int CALORIES;

    private AccessFoodInventory access = new AccessFoodInventory("jdbc:mysql://localhost/food_inventory", "student", "ensf");

    // setters are not required since all attributes are final and
    // read from the data base

    public Food(int ITEM_ID) {
        this.ITEM_ID = ITEM_ID;
        access.initializeConnection();
        String[] tmp = access.getSpecificFood(ITEM_ID).split("/");

        this.NAME = tmp[0];
        this.GRAIN_CONTENT = Integer.parseInt(tmp[1]);
        this.FV_CONTENT = Integer.parseInt(tmp[2]);
        this.PRO_CONTENT = Integer.parseInt(tmp[3]);
        this.OTHER_CONTENT = Integer.parseInt(tmp[4]);
        this.CALORIES = Integer.parseInt(tmp[5]);
        access.close();
    }

    public int getItemID() {
        return this.ITEM_ID;
    }

    public String getName() {
        return this.NAME;
    }

    public int getGrainContent() {
        return this.GRAIN_CONTENT;
    }

    public int getFVContent() {
        return this.FV_CONTENT;
    }

    public int getProContent() {
        return this.PRO_CONTENT;
    }

    public int getOtherContent() {
        return this.OTHER_CONTENT;
    }

    public int getCalories() {
        return this.CALORIES;
    }

}

