public class Recipient {
    private final int clientID;
    private final String clientType;
    private final int wholeGrains;
    private final int fruitsVeggies;
    private final int protein;
    private final int other;
    private final int CALORIES;

    public Recipient(int recipientID){
        this.clientID = recipientID;
        switch(this.clientID){      // Fix using the values from the database

            case 0:
                this.clientType = "Adult Male";
                this.wholeGrains = 10;
                this.fruitsVeggies = 20;
                this.protein = 30;
                this.other = 40;
                this.CALORIES = 2000;
                break;
            case 1:
                this.clientType = "Adult Female";
                this.wholeGrains = 20;
                this.fruitsVeggies = 10;
                this.protein = 40;
                this.other = 30;
                this.CALORIES = 2500;
                break;
            case 2:
                this.clientType = "Child over 8";
                this.wholeGrains = 30;
                this.fruitsVeggies = 30;
                this.protein = 20;
                this.other = 20;
                this.CALORIES = 1000;
                break;
            case 3:
                this.clientType = "Child under 8";
                this.wholeGrains = 40;
                this.fruitsVeggies = 40;
                this.protein = 15;
                this.other = 5;
                this.CALORIES = 750;
                break;
                default:
                    throw new IllegalArgumentException("Recipient does not exist. Please enter another value");



        }
    }

    public int getClientID(){
        return this.clientID;
    }
    public String getClientType(){
        return this.clientType;
    }
    public int getWholeGrains(){
        return this.wholeGrains;
    }
    public int getFruitsVeggies(){
        return this.fruitsVeggies;
    }
    public int getProtein(){
        return this.protein;
    }
    public int getOther(){
        return this.other;
    }
    public int getCalories(){
        return this.CALORIES;
    }
}
