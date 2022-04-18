
/**
* @author  Xian, Jaxon, Aarushi, Aryan
* @version 1.3
* @since   2022-04-17
*/
package edu.ucalgary.ensf409;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

public class OrderTest {
    Order testOrder = new Order();
    ArrayList<Hamper> expectedHamper = new ArrayList<Hamper>();
    ArrayList<Recipient> expectedRecipients = new ArrayList<Recipient>();
    ArrayList<Food> expectedFoods = new ArrayList<Food>();

    /**
     * Checks order constructor.
     */
    @Test
    public void testOrder() {
        Order actualOrder = new Order();
        assertEquals("Order constructor did not initialize hampers properly",
                expectedHamper, actualOrder.getHampers());

    }

    /**
     * Checks that addNewHamper() successfully adds new recipients and foods.
     */
    @Test
    public void testAddNewHamper() {
        expectedHamper.clear();
        Hamper actualHamper = new Hamper();
        expectedRecipients.clear();
        expectedRecipients.add(new Recipient(1));
        expectedRecipients.add(new Recipient(2));
        expectedFoods.clear();
        expectedFoods.add(new Food(0023));
        actualHamper.setFoods(expectedFoods);
        actualHamper.setRecipients(expectedRecipients);
        Order actual = new Order();
        expectedHamper.add(actualHamper);
        actual.addNewHamper(actualHamper);
        assertEquals("addNewHamper() does not add hamper properly",
                expectedHamper, actual.getHampers());

    }

    /**
     * Checks the return value of getHampers().
     */
    @Test
    public void testGetHampers() {
        expectedHamper.clear();
        ArrayList<Hamper> actualHampers = new ArrayList<Hamper>();
        Hamper actualHamper = new Hamper();
        expectedRecipients.clear();
        expectedRecipients.add(new Recipient(1));
        expectedRecipients.add(new Recipient(2));
        expectedFoods.clear();
        expectedFoods.add(new Food(0023));
        actualHamper.setFoods(expectedFoods);
        actualHamper.setRecipients(expectedRecipients);
        actualHampers.add(actualHamper);
        Order actual = new Order();
        expectedHamper.add(actualHamper);
        actual.setHampers(actualHampers);
        assertEquals("getHampers() does not return hampers properly",
                expectedHamper, actual.getHampers());

    }

    /** Checks that status of orderform is crrectly set. */
    @Test
    public void testSetOrderFormStatus() {
        boolean testStatus = true;
        Order actual = new Order();
        actual.setOrderFormCreated(testStatus);
        assertEquals("setOrderFormCreated() does not set Order Form Status properly",
                testStatus, actual.getOrderFormCreated());

    }

    /**
     * Checks that expected food is provided for a child under 8.
     */
    @Test
    public void testCalculateFoodDistribution() {

        Order actual = new Order();
        Hamper testRealVal = new Hamper();
        ArrayList<Food> tmpArr = new ArrayList<Food>();
        tmpArr.add(new Food(3));
        testRealVal.setFoods(tmpArr);
        Recipient testRecipientVal = new Recipient(4);
        ArrayList<Recipient> fullList = new ArrayList<Recipient>();
        fullList.add(testRecipientVal);
        testRealVal.setRecipients(fullList);
        AvailableFood allAvail = new AvailableFood();
        actual.calculateFoodDistribution(testRealVal, allAvail);

        assertEquals("Food distribution was not calculated", 163, testRealVal.getFoods().get(16).getItemID());
    }

}
