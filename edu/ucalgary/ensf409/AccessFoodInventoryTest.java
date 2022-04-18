/**
* @author  Xian, Jaxon, Aarushi, Aryan
* @version 1.2
* @since   2022-04-17
*/

package edu.ucalgary.ensf409;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AccessFoodInventoryTest {
    private AccessFoodInventory access = new AccessFoodInventory("jdbc:mysql://localhost/food_inventory", "student",
            "ensf");

    /**
     * Check total number of food items in the database.
     * Checks for 169 (consistent with inventory provided on D2L).
     */
    @Test
    public void testGetTotalFoodItems() {
        access.initializeConnection();
        assertEquals("Total values was not correct", 169, access.getTotalFoodItems());
        access.dbConnectClose();
    }

    /**
     * Check if GetSpecificFood() returns correct food name given ID.
     */

    @Test
    public void testGetSpecificFood() {
        access.initializeConnection();
        String[] real = access.getSpecificFood(62).split("/");
        assertEquals("The specific food item was incorrect", "Bacon, 1 kg", real[0]);
        access.close();
    }

    /**
     * Check if GetSpecificRecipient() returns correct recipient type given ID.
     */

    @Test
    public void testGetSpecificRecipient() {
        access.initializeConnection();
        String[] real = access.getSpecificRecipient(2).split("/");
        assertEquals("The specific recipient was incorrect", "Adult Female", real[0]);
        access.close();
    }

    /**
     * Check if a food item is deleted from database given the ID.
     */

    @Test
    public void testDeleteAvailableFood() {
        access.initializeConnection();
        access.deleteAvailableFood("5");
        String[] tmp = access.getSpecificFood(5).split("/");
        assertEquals("The available food was not deleted from the database", "", tmp[0]);
        access.dbConnectClose();
    }
}
