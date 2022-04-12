
package edu.ucalgary.ensf409;

import java.util.*;

public class AvailableFood {
    private ArrayList<Food> availableFood = new ArrayList<Food>();
    private AccessFoodInventory access = new AccessFoodInventory("jdbc:mysql://localhost/food_inventory", "student", "ensf");

    public AvailableFood(){
        access.initializeConnection();
        for(int i = 1; i < this.access.getTotalFoodItems() + 1; i++){
            Food testFood = new Food(i);
            this.availableFood.add(testFood);
        }

    }
    public ArrayList<Food> getAvailableFoods(){
        return this.availableFood;
    }
    public void setAvailableFoods(ArrayList<Food> availableFood){
        this.availableFood = availableFood;
    }
    public void removeFoodItem(Food foodItem){
        int counter = 0;
        while(this.availableFood.iterator().hasNext() && counter < this.availableFood.size()){
            if(foodItem.getName().equals(this.availableFood.get(counter).getName())){
                this.availableFood.remove(counter);
                break;
            }
            counter++;
        }

    }

}


