package edu.ucalgary.ensf409;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
public class AvailableFoodTest {

    @Test
    public void testAvailableFoods(){ // Testing for ID when taken from SQL
        AvailableFood test = new AvailableFood();
        assertEquals("FoodID was not correct",1, test.getAvailableFoods().get(0).getItemID());
    }
    @Test
    public void setAvailableFood(){ // Test whether the values will be set to equal each other
        AvailableFood test = new AvailableFood();
        ArrayList<Food> realVal = new ArrayList<Food>();
        Food realFood = new Food(2);
        realVal.add(realFood);
        test.setAvailableFoods(realVal);
        assertEquals("AvailableFood was not correctly set",realVal.get(0).getItemID(), test.getAvailableFoods().get(0).getItemID());
    }

    @Test
    public void testRemoveFoodItem(){ // Test whether the values actually gets removed or not from the sql
        AvailableFood test = new AvailableFood();
        Food delFood = new Food(3);
        int itemID = delFood.getItemID();
        test.removeFoodItem(delFood);
        assertEquals("Item was not correctly removed","Apple, dozen", test.getAvailableFoods().get(2).getName());
    }
}
