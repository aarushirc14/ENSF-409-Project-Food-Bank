package edu.ucalgary.ensf409;

public class Food {
    private final int ITEM_ID;
    private final String NAME;
    private final int GRAIN_CONTENT;
    private final int FV_CONTENT;
    private final int PRO_CONTENT;
    private final int OTHER_CONTENT;
    private final int CALORIES;

    // setters are not required since all attributes are final and
    // read from the data base

    Food(int ITEM_ID) {
        // use ITEM_ID to retrive nutrition info from data base
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
