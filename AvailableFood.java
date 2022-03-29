package edu.ucalgary.ensf409;

import java.util.*;

public class AvailableFood {
    private ArrayList<Food> availableFood = new ArrayList<Food>();

    public AvailableFood(){ //Use values from sql when done that class
        Food testFood = new Food(0);
        Food testFood2 = new Food(1);
        this.availableFood.add(testFood);
        this.availableFood.add(testFood2);
    }
    public ArrayList<Food> getAvailableFoods(){
        return this.availableFood;
    }
    public void setAvailableFoods(ArrayList<Food> availableFood){
        this.availableFood = availableFood;
    }
    public void removeFoodItem(Food foodItem){
        this.availableFood.remove(usedFood);
    }
}
