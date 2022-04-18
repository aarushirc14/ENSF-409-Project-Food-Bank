/**
* @author  Xian, Jaxon, Aarushi, Aryan
* @version 1.2
* @since   2022-04-17
*/

package edu.ucalgary.ensf409;

import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class OrderFormTest {
    private AccessFoodInventory access = new AccessFoodInventory("jdbc:mysql://localhost/food_inventory", "student",
            "ensf");

    /**
     * Check whether the orderFormCreated value gets changed when orderform object
     * is created
     */
    @Test
    public void testOrderFormCreated() {
        Order realVal = new Order();
        Hamper testRealVal = new Hamper();
        Recipient testRecipientVal = new Recipient(2);
        ArrayList<Recipient> fullList = new ArrayList<Recipient>();
        fullList.add(testRecipientVal);
        testRealVal.setRecipients(fullList);
        realVal.addNewHamper(testRealVal);
        OrderForm test = new OrderForm(realVal);
        assertEquals("Order form boolean value was not changed", true, test.getOrderFormCreated());
    }

    /**
     * Check whether updateDataBase changes the value in the database when provided
     * the order
     * NOTE: Must refresh the database everytime to make this test pass
     * 
     * @throws IOException
     */
    @Test
    public void testUpdateDataBase() throws IOException {
        access.initializeConnection();
        Order realVal = new Order();
        Hamper testRealVal = new Hamper();
        ArrayList<Food> tmpArr = new ArrayList<Food>();
        tmpArr.add(new Food(3));
        testRealVal.setFoods(tmpArr);
        Recipient testRecipientVal = new Recipient(4);
        ArrayList<Recipient> fullList = new ArrayList<Recipient>();
        fullList.add(testRecipientVal);
        testRealVal.setRecipients(fullList);
        realVal.addNewHamper(testRealVal);

        OrderForm test = new OrderForm(realVal);
        test.updateDataBase(realVal);

        AvailableFood finalVal = new AvailableFood();
        assertEquals("The values from the order has not been updated to database", "Apple, dozen",
                finalVal.getAvailableFoods().get(2).getName());
        access.dbConnectClose();
    }

}
