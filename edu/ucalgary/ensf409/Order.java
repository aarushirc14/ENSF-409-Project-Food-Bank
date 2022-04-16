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
        float totalCal = recipient.getCalories();
        // System.out.println(totalCal);
        float grainCal = recipient.getWholeGrains() / 100.0f * totalCal;
        // System.out.println(grainCal);
        float fvCal = recipient.getFruitsVeggies() / 100.0f * totalCal;
        // System.out.println(fvCal);
        float proCal = recipient.getProtein() / 100.0f * totalCal;
        // System.out.println(proCal);
        float otherCal = recipient.getOther() / 100.0f * totalCal;
        // System.out.println(otherCal);

        ArrayList<String> calcFood = new ArrayList<>();
        int grainSum = 0;
        int fvSum = 0;
        int proSum = 0;
        int otherSum = 0;
        for (int i = 0; i < foodData.size(); i++) {

            if (grainSum <= grainCal) {

                for (Food food : foodData) {
                    // System.out.println(foodData);
                    // System.out.println(food);
                    // System.out.println(food.getGrainContent());
                    fvSum += food.getGrainContent();
                    // System.out.println(fvSum);
                    // System.out.println(food.getName());
                    if (food.getGrainContent() != 0) {
                        if (!calcFood.contains(food.getName())) {
                            calcFood.add(food.getName());
                        }
                    }
                    // break;
                }
            }
            // break;

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
