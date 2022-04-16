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

    public ArrayList<String> calculateFoodDistribution(Hamper hamper, AvailableFood availableFood) {
        ArrayList<Food> foodData = availableFood.getAvailableFoods();
        ArrayList<Recipient> allRec = new ArrayList<>();
        allRec = hamper.getRecipients();
        int allGrainCal = 0;
        int allFvCal = 0;
        int allProCal = 0;
        int allOtherCal = 0;
        // int allTotalCal = 0;
        for (int j = 0; j < allRec.size(); j++) {
            allGrainCal += (int) (allRec.get(j).getWholeGrains() / 100.0 * allRec.get(j).getCalories());
            allFvCal += (int) (allRec.get(j).getFruitsVeggies() / 100.0 * allRec.get(j).getCalories());
            allProCal += (int) (allRec.get(j).getProtein() / 100.0 * allRec.get(j).getCalories());
            allOtherCal += (int) (allRec.get(j).getOther() / 100.0 * allRec.get(j).getCalories());
            // allTotalCal += allRec.get(j).getCalories();

        }
        System.out.println("Required grain " + allGrainCal);
        System.out.println("Required fv " + allFvCal);
        System.out.println("Required pro " + allProCal);
        System.out.println("Required other " + allOtherCal);
        ArrayList<String> calcFood = new ArrayList<>();
        int grainSum = 0;
        int fvSum = 0;
        int proSum = 0;
        int otherSum = 0;
        for (Food food : foodData) {

            if (grainSum <= allGrainCal || fvSum <= allFvCal || proSum <= allProCal ||
                    otherSum <= allOtherCal) {
                if (!calcFood.contains(food.getName())) {
                    grainSum += food.getGrainContent();
                    fvSum += food.getFVContent();
                    proSum += food.getProContent();
                    otherSum += food.getOtherContent();
                    calcFood.add(food.getName());

                }

            }

        }
        System.out.println("------------");
        System.out.println("Given Grain " + grainSum);
        System.out.println("Given fv " + fvSum);
        System.out.println("Given protein " + proSum);
        System.out.println("Given other " + otherSum);

        return calcFood;

    }

    public void addRecipientToHamper(Hamper hamper, int recipientID) {
        hamper.addNewRecipient(recipientID);
    }

}
