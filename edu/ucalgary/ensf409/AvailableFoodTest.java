/**
* @author  Xian, Jaxon, Aarushi, Aryan
* @version 1.2
* @since   2022-04-17
*/

package edu.ucalgary.ensf409;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AvailableFoodTest {
    /**
     * Checks AvailableFood constructor.
     * Checks first food item's item ID.
     */
    @Test
    public void testAvailableFoods() { // Testing for ID when taken from SQL
        AvailableFood test = new AvailableFood();
        assertEquals("Food item ID was not correct", 1, test.getAvailableFoods().get(0).getItemID());
    }

    /**
     * Checks AvailableFood setter.
     * Tests whether the values will be set equal to each other.
     */
    @Test
    public void setAvailableFood() {
        AvailableFood test = new AvailableFood();
        ArrayList<Food> realVal = new ArrayList<Food>();
        Food realFood = new Food(2);
        realVal.add(realFood);
        test.setAvailableFoods(realVal);
        assertEquals("AvailableFood was not correctly set", realVal.get(0).getItemID(),
                test.getAvailableFoods().get(0).getItemID());
    }

    /**
     * Checks that food item is removed from the inventory.
     */
    @Test
    public void testRemoveFoodItem() {
        AvailableFood test = new AvailableFood();
        Food delFood = new Food(3);
        int itemID = delFood.getItemID();
        test.removeFoodItem(delFood);
        assertEquals("Item was not correctly removed", "Apple, dozen", test.getAvailableFoods().get(2).getName());
    }
}
