package edu.ucalgary.ensf409;

import java.util.*;

public class Order {
    private ArrayList<Hamper> hampers;

    public Order() {
        this.hampers = new ArrayList<Hamper>();

    }

    public void addNewHamper() {
        hampers.add(new Hamper());

    }

    public ArrayList<Hamper> getHampers() {
        return this.hampers;
    }

    public ArrayList<String> calculateFoodDistribution(Recipient recipient, AvailableFood availableFood) {
        ArrayList<Food> foodData = availableFood.getAvailableFoods();
        // System.out.println(foodData);
        int totalCal = recipient.getCalories();
        // System.out.println(totalCal);
        int grainCal = (int) (recipient.getWholeGrains() / 100.0 * totalCal);
        // System.out.println(grainCal);
        int fvCal = (int) (recipient.getFruitsVeggies() / 100.0 * totalCal);
        // System.out.println(fvCal);
        int proCal = (int) (recipient.getProtein() / 100.0 * totalCal);
        // System.out.println(proCal);
        int otherCal = (int) (recipient.getOther() / 100.0 * totalCal);
        // System.out.println(otherCal);

        ArrayList<String> calcFood = new ArrayList<>();
        int grainSum = 0;
        int fvSum = 0;
        int proSum = 0;
        int otherSum = 0;
        System.out.println(grainCal + "," + fvCal + "," + proCal + "," + otherCal);
        System.out.println(foodData.size());

        for (Food food : foodData) {
            if (grainSum <= grainCal || fvSum <= fvCal || proSum <= proCal || otherSum <= otherCal) {
                if (!calcFood.contains(food.getName())) {
                    grainSum += food.getGrainContent();
                    fvSum += food.getFVContent();
                    proSum += food.getProContent();
                    otherSum += food.getOtherContent();
                    calcFood.add(food.getName());
                }

            }

        }

        return calcFood;

    }

    public void addRecipientToHamper(Hamper hamper, int recipientID) {
        hamper.addNewRecipient(recipientID);
    }

}
