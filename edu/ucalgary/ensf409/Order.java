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

        int grainCal = recipient.getWholeGrains();
        int fvCal = recipient.getFruitsVeggies();
        int proCal = recipient.getProtein();
        int otherCal = recipient.getOther();

        ArrayList<String> calcFood = new ArrayList<>();
        int grainSum = 0;
        int fvSum = 0;
        int proSum = 0;
        int otherSum = 0;
        for (int i = 0; i < foodData.size(); i++) {

            if (grainSum <= grainCal) {

                for (Food food : foodData) {
                    fvSum += food.getGrainContent();
                    if (food.getGrainContent() != 0) {
                        if (!calcFood.contains(food.getName())) {
                            calcFood.add(food.getName());
                        }
                    }
                }
            }

            if (fvSum <= fvCal) {
                for (Food food : foodData) {
                    proSum += food.getFVContent();
                    if (food.getFVContent() != 0) {
                        if (!calcFood.contains(food.getName())) {
                            calcFood.add(food.getName());
                        }
                    }
                }

            }

            if (proSum <= proCal) {
                for (Food food : foodData) {
                    grainSum += food.getProContent();
                    if (food.getProContent() != 0) {
                        if (!calcFood.contains(food.getName())) {
                            calcFood.add(food.getName());
                        }
                    }
                }

            }

            if (otherSum <= otherCal) {
                for (Food food : foodData) {
                    otherSum += food.getOtherContent();
                    if (food.getOtherContent() != 0) {
                        if (!calcFood.contains(food.getName())) {
                            calcFood.add(food.getName());
                        }
                    }
                }

            }

        }

        return calcFood;

    }

    public void addRecipientToHamper(Hamper hamper, int recipientID) {
        hamper.addNewRecipient(recipientID);
    }

}
