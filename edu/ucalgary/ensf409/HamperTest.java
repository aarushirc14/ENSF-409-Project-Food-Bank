/**
* @author  Xian, Jaxon, Aarushi, Aryan
* @version 1.4
* @since   2022-04-17
*/

package edu.ucalgary.ensf409;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class HamperTest {
    Hamper testHamper = new Hamper();
    ArrayList<Recipient> expectedRecipients = new ArrayList<Recipient>();
    ArrayList<Food> expectedFoods = new ArrayList<Food>();

    /**
     * Checking Hamper constructor.
     */
    @Test
    public void testHamper() {
        Hamper actualHamper = new Hamper();
        assertEquals("Hamper Constructor did not initialize Recipients properly",
                expectedRecipients, actualHamper.getRecipients());
        assertEquals("Hamper Constructor did not initialize Recipients properly",
                expectedFoods, actualHamper.getFoods());
    }

    /**
     * Checking getRecipients() returns correct recipients.
     */

    @Test
    public void testGetRecipients() {
        expectedRecipients.clear();
        expectedRecipients.add(new Recipient(1));
        expectedRecipients.add(new Recipient(2));
        String expectedFinalStr = expectedRecipients.get(0).getClientType() + " "
                + expectedRecipients.get(1).getClientType();
        Hamper actualHamper = new Hamper();
        actualHamper.addNewRecipient(1);
        actualHamper.addNewRecipient(2);
        String finalStr = actualHamper.getRecipients().get(0).getClientType() + " "
                + actualHamper.getRecipients().get(1).getClientType();
        assertEquals("getRecipients() did not return correct list",
                expectedFinalStr, finalStr);
    }

    /**
     * Checking getFoods() returns correct foods.
     */
    @Test
    public void testGetFoods() {
        expectedFoods.clear();
        expectedFoods.add(new Food(23));
        Hamper actualHamper = new Hamper();
        actualHamper.setFoods(expectedFoods);
        assertEquals("getFoods() did not return correct list",
                expectedFoods, actualHamper.getFoods());
    }

    /**
     * Checking setRecipients() correctly sets ArrayList of recipients.
     */

    @Test
    public void testSetRecipients() {
        expectedRecipients.clear();
        expectedRecipients.add(new Recipient(1));
        expectedRecipients.add(new Recipient(2));
        Hamper actualHamper = new Hamper();
        actualHamper.setRecipients(expectedRecipients);
        assertEquals("setRecipients() did not store correct list",
                expectedRecipients, actualHamper.getRecipients());
    }

    /**
     * Checking setFoods() correctly sets array list of foods.
     */

    @Test
    public void testSetFoods() {
        expectedFoods.clear();
        expectedFoods.add(new Food(23));
        Hamper actualHamper = new Hamper();
        actualHamper.setFoods(expectedFoods);
        assertEquals("setFoods() did not store correct list",
                expectedFoods, actualHamper.getFoods());
    }

    /**
     * Checking addNewRecipient() correctly adds a recipient to the ArrayList.
     */
    @Test
    public void testAddNewRecipient() {
        expectedRecipients.clear();
        expectedRecipients.add(new Recipient(1));
        expectedRecipients.add(new Recipient(2));
        String expectedFinalStr = expectedRecipients.get(0).getClientType() + " "
                + expectedRecipients.get(1).getClientType();
        Hamper actualHamper = new Hamper();
        actualHamper.addNewRecipient(1);
        actualHamper.addNewRecipient(2);
        String finalStr = actualHamper.getRecipients().get(0).getClientType() + " "
                + actualHamper.getRecipients().get(1).getClientType();
        assertEquals("addNewRecipient() did not add a new recipient properly",
                expectedFinalStr, finalStr);
    }

    /**
     * Checking foodsToString() correctly converts the ArrayList to a formatted
     * string.
     */
    @Test
    public void testFoodsToString() {
        String expectedOutput = "34\tAvocado, dozen\n35\tAvocado, dozen\n";
        Hamper actualHamper = new Hamper();
        ArrayList<Food> foods = new ArrayList<Food>();
        foods.add(new Food(34));
        foods.add(new Food(35));
        actualHamper.setFoods(foods);
        assertEquals("foodsToString() did not return correctly formatted string",
                expectedOutput, actualHamper.foodsToString());

    }

    /**
     * Checking recipientsToString() correctly converts the ArrayList to a formatted
     * string.
     */
    @Test
    public void testRecipientsToString() {
        String expectedOutput = "1 Adult Female, 2 Child under 8";
        Hamper actualHamper = new Hamper();
        actualHamper.addNewRecipient(2);
        actualHamper.addNewRecipient(4);
        actualHamper.addNewRecipient(4);
        assertEquals("recipientsToString() did not return correctly formatted string",
                expectedOutput, actualHamper.recipientsToString());
    }

}
