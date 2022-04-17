package edu.ucalgary.ensf409;

import java.util.*;

public class Order {
    private ArrayList<Hamper> hampers;
    private boolean orderFormCreated;
    private AvailableFood availableFood;

    public Order() {
        this.hampers = new ArrayList<Hamper>();

    }

    public void addNewHamper(Hamper hampers) {
        this.hampers.add(new Hamper()); 

    }

    public ArrayList<Hamper> getHampers() {
        return this.hampers;
    }

    public void calculateFoodDistribution(Hamper hamper, AvailableFood availableFood) {
        ArrayList<Food> foodData = availableFood.getAvailableFoods();
        ArrayList<Recipient> allRec = new ArrayList<>();
        allRec = hamper.getRecipients();
        int allGrainCal = 0;
        int allFvCal = 0;
        int allProCal = 0;
        int allOtherCal = 0;
        int allTotalCal = 0;
        for (int j = 0; j < allRec.size(); j++) {
            allGrainCal += (int) (allRec.get(j).getWholeGrains() / 100.0 * allRec.get(j).getCalories()) * 7;
            allFvCal += (int) (allRec.get(j).getFruitsVeggies() / 100.0 * allRec.get(j).getCalories()) * 7;
            allProCal += (int) (allRec.get(j).getProtein() / 100.0 * allRec.get(j).getCalories()) * 7;
            allOtherCal += (int) (allRec.get(j).getOther() / 100.0 * allRec.get(j).getCalories()) * 7;
            allTotalCal += allRec.get(j).getCalories();

        }
        System.out.println("Required grain " + allGrainCal);
        System.out.println("Required fv " + allFvCal);
        System.out.println("Required pro " + allProCal);
        System.out.println("Required other " + allOtherCal);
        ArrayList<Food> calcFood = new ArrayList<>();
        int grainSum = 0;
        int fvSum = 0;
        int proSum = 0;
        int otherSum = 0;
        int calSum = 0;

        Iterator<Food> iter = foodData.iterator();
        while (iter.hasNext()) {
            Food food = iter.next();

            if (grainSum <= allGrainCal || fvSum <= allFvCal || proSum <= allProCal ||
                    otherSum <= allOtherCal) {
                if (!calcFood.contains(food)) {
                    if (food.getGrainContent() <= (allGrainCal - grainSum)
                            && food.getFVContent() <= (allFvCal - fvSum)
                            && food.getProContent() <= (allProCal - proSum)
                            && food.getOtherContent() <= (allOtherCal - otherSum)) {

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
        System.out.println(foodData.size());
        System.out.println(calcFood.size());

        // System.out.println("------------");
        System.out.println("Given Grain " + grainSum);
        System.out.println("Given fv " + fvSum);
        System.out.println("Given protein " + proSum);
        System.out.println("Given other " + otherSum);

        hamper.setFoods(calcFood);
    }

    

    public void addRecipientToHamper(Hamper hamper, int recipientID) {
        hamper.addNewRecipient(recipientID);
    }
    public void setOrderFormCreated(boolean status){
        this.orderFormCreated=status;


    }
    public boolean getOrderFormCreated(){
        return this.orderFormCreated;
    }
    public boolean createOrderForm(){
        Order g= new Order();
        g.setHampers(this.hampers);
        g.setOrderFormCreated(this.orderFormCreated);
        OrderForm neww= new OrderForm(g);
        return true;
    }
    public void setHampers(ArrayList<Hamper> hampers){
        this.hampers=hampers;

    }
    public void setAvailableFood(AvailableFood availableFood){
        this.availableFood=availableFood;
    }
    public AvailableFood getAvailableFood(){
        return this.availableFood;
    }
    public void updateAvailableFood(ArrayList<Food> food){
        availableFood.setAvailableFoods(food);
    }
    public void addNewAvailableFood(Food newFood){
        ArrayList<Food> g = this.availableFood.getAvailableFoods();
        g.add(newFood);
        this.availableFood.setAvailableFoods(g);
    }


}
