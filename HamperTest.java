// package edu.ucalgary.ensf409;

import org.junit.Test;

import edu.ucalgary.ensf409.Food;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;


public class HamperTest {
    Hamper testHamper = new Hamper();
    ArrayList<Recipient> expectedRecipients = new ArrayList<Recipient>();
    ArrayList<Food> expectedFoods = new ArrayList<Food>();
    
    @Test
    public void testHamper() {
        Hamper actualHamper = new Hamper();
        assertEquals("Hamper Constructor did not initialize Recipients properly", 
                    expectedRecipients, actualHamper.getRecipients());
        assertEquals("Hamper Constructor did not initialize Recipients properly", 
                    expectedFoods, actualHamper.getFoods());
    }

    @Test
    public void testGetRecipients() {
        expectedRecipients.clear();
        expectedRecipients.add(new Recipient(0));
        expectedRecipients.add(new Recipient(1));
        Hamper actualHamper = new Hamper();
        actualHamper.addNewRecipient(0);
        actualHamper.addNewRecipient(1);
        assertEquals("getRecipients() did not return correct list", 
                    expectedRecipients, actualHamper.getRecipients());
    }

    @Test
    public void testGetFoods() {
        expectedFoods.clear();
        expectedFoods.add(new Food(0023));
        Hamper actualHamper = new Hamper();
        actualHamper.setFoods(expectedFoods);
        assertEquals("getFoods() did not return correct list", 
                    expectedFoods, actualHamper.getFoods());
    }

    @Test
    public void testSetRecipients() {
        expectedRecipients.clear();
        expectedRecipients.add(new Recipient(0));
        expectedRecipients.add(new Recipient(1));
        Hamper actualHamper = new Hamper();
        actualHamper.setRecipients(expectedRecipients);
        assertEquals("setRecipients() did not store correct list",
                    expectedRecipients, actualHamper.getRecipients());
    }

    @Test
    public void testSetFoods() {
        expectedFoods.clear();
        expectedFoods.add(new Food(0023));
        Hamper actualHamper = new Hamper();
        actualHamper.setFoods(expectedFoods);
        assertEquals("setFoods() did not store correct list",
                    expectedFoods, actualHamper.getFoods());
    }

    @Test
    public void testAddNewRecipient() {
        expectedRecipients.clear();
        expectedRecipients.add(new Recipient(0));
        expectedRecipients.add(new Recipient(1));
        Hamper actualHamper = new Hamper();
        actualHamper.addNewRecipient(0);
        actualHamper.addNewRecipient(1);
        assertEquals("addNewRecipient() did not add a new recipient properly",
                    expectedRecipients, actualHamper.getRecipients());
    }

    @Test
    public void testFoodsToString() {
        String expectedOutput = "34    Avocado, dozen\n35    Avocado, dozen";
        Hamper actualHamper = new Hamper();
        ArrayList<Food> foods = new ArrayList<Food>();
        foods.add(new Food(0034));
        foods.add(new Food(0035));
        actualHamper.setFoods(foods);
        assertEquals("foodsToString() did not return correctly formatted string",
                    expectedOutput, actualHamper.foodsToString());

    }

    @Test
    public void testRecipientsToString() {
        String expectedOutput = "1 Adult Female, 2 Child under 8";
        Hamper actualHamper = new Hamper();
        actualHamper.addNewRecipient(1);
        actualHamper.addNewRecipient(3);
        actualHamper.addNewRecipient(3);
        assertEquals("recipientsToString() did not return correctly formatted string",
                    expectedOutput, actualHamper.recipeintsToString());
    }


}   
