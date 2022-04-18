/**
* @author  Xian, Jaxon, Aarushi, Aryan
* @version 3.1
* @since   2022-04-17
*/

package edu.ucalgary.ensf409;

import java.util.*;

public class Order {
    private ArrayList<Hamper> hampers;
    private boolean orderFormCreated;
    private AvailableFood availableFood;

    /**
     * Constructor creates a new hamper.
     */
    public Order() {
        this.hampers = new ArrayList<Hamper>();

    }

    /**
     * Adds new hamper to ArrayList.
     * 
     * @param hamper
     */
    public void addNewHamper(Hamper hamper) {
        this.hampers.add(hamper);

    }

    /**
     * Returns hampers ArrayList
     * 
     * @return
     */
    public ArrayList<Hamper> getHampers() {
        return this.hampers;
    }

    /**
     * Algorithm for calculating the optimal amount of food for each hamper
     * depending on given recipients.
     * 
     * @param hamper
     * @param availableFood
     */
    public void calculateFoodDistribution(Hamper hamper, AvailableFood availableFood) {
        ArrayList<Food> foodData = availableFood.getAvailableFoods();
        ArrayList<Recipient> allRec = new ArrayList<>();
        allRec = hamper.getRecipients(); // All recipients in a hamper
        int allGrainCal = 0; // intialize required food values for all recipients in a hamper
        int allFvCal = 0;
        int allProCal = 0;
        int allOtherCal = 0;
        int allTotalCal = 0;
        // use a loop to get all the required calories
        for (int j = 0; j < allRec.size(); j++) {
            allGrainCal += (int) (allRec.get(j).getWholeGrains() / 100.0 * allRec.get(j).getCalories()) * 7;
            allFvCal += (int) (allRec.get(j).getFruitsVeggies() / 100.0 * allRec.get(j).getCalories()) * 7;
            allProCal += (int) (allRec.get(j).getProtein() / 100.0 * allRec.get(j).getCalories()) * 7;
            allOtherCal += (int) (allRec.get(j).getOther() / 100.0 * allRec.get(j).getCalories()) * 7;
            allTotalCal += allRec.get(j).getCalories();

        }
        // print statements added to confirm correct operation,
        // so these values can also be viewed in the terminal
        System.out.println("Required grain " + allGrainCal);
        System.out.println("Required fv " + allFvCal);
        System.out.println("Required pro " + allProCal);
        System.out.println("Required other " + allOtherCal);
        ArrayList<Food> calcFood = new ArrayList<>();
        int grainSum = 0; // intialize all calculated food values to 0
        int fvSum = 0;
        int proSum = 0;
        int otherSum = 0;
        int calSum = 0;

        Iterator<Food> iter = foodData.iterator();
        while (iter.hasNext()) {
            Food food = iter.next();
            // keep adding more food if the calculated amount is less than the required
            // amount for any category
            if (grainSum <= allGrainCal || fvSum <= allFvCal || proSum <= allProCal ||
                    otherSum <= allOtherCal) {
                // add only if the food is not already in the hamper, to avoid giving multiple
                // units of the same item
                if (!calcFood.contains(food)) {
                    // only add if the content of each food item is less than differnce between the
                    // required calories and calculated calories.
                    if (food.getGrainContent() <= (allGrainCal - grainSum)
                            && food.getFVContent() <= (allFvCal - fvSum)
                            && food.getProContent() <= (allProCal - proSum)
                            && food.getOtherContent() <= (allOtherCal - otherSum)) {
                        // if all conditions are add the food
                        grainSum += food.getGrainContent();
                        fvSum += food.getFVContent();
                        proSum += food.getProContent();
                        otherSum += food.getOtherContent();
                        calSum += food.getCalories();

                        calcFood.add(food);
                        iter.remove();
                        // this remove will only delete from foodData NOT from inventory database
                    }

                }

            }
        }

        // print statements added to confirm correct operation,
        // so these values can also be viewed in the terminal
        System.out.println(foodData.size());
        System.out.println(calcFood.size());

        System.out.println("--------------------------");
        System.out.println("Given Grain " + grainSum);
        System.out.println("Given fv " + fvSum);
        System.out.println("Given protein " + proSum);
        System.out.println("Given other " + otherSum);

        hamper.setFoods(calcFood);
    }

    /**
     * Adds recipient to hamper. Calls addNewRecipient(recipientID) from Hamper
     * class.
     * 
     * @param hamper
     * @param recipientID
     */
    public void addRecipientToHamper(Hamper hamper, int recipientID) {
        hamper.addNewRecipient(recipientID);
    }

    /**
     * Sets boolean for OrderFormCreated
     * 
     * @param status
     */
    public void setOrderFormCreated(boolean status) {
        this.orderFormCreated = status;

    }

    /**
     * Returns boolean for OrderFormCreated
     * 
     * @return
     */

    public boolean getOrderFormCreated() {
        return this.orderFormCreated;
    }

    /**
     * Create orderform.
     * 
     * @return
     */
    public boolean createOrderForm() {
        Order g = new Order();
        g.setHampers(this.hampers);
        g.setOrderFormCreated(this.orderFormCreated);
        OrderForm neww = new OrderForm(g);
        return true;
    }

    /**
     * Sets hampers.
     * 
     * @param hampers
     */
    public void setHampers(ArrayList<Hamper> hampers) {
        this.hampers = hampers;

    }

    /**
     * Sets available food.
     * 
     * @param availableFood
     */
    public void setAvailableFood(AvailableFood availableFood) {
        this.availableFood = availableFood;
    }

    /**
     * Returns avaialble in inventory.
     * 
     * @return
     */
    public AvailableFood getAvailableFood() {
        return this.availableFood;
    }

    /**
     * Updates inventory.
     * 
     * @return
     */
    public void updateAvailableFood(ArrayList<Food> food) {
        availableFood.setAvailableFoods(food);
    }

    /**
     * Add new food to inventory
     * 
     * @param newFood
     */
    public void addNewAvailableFood(Food newFood) {
        ArrayList<Food> g = this.availableFood.getAvailableFoods();
        g.add(newFood);
        this.availableFood.setAvailableFoods(g);
    }

}
