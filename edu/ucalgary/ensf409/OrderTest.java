package edu.ucalgary.ensf409;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
public class OrderTest {
    Order testOrder= new Order();
    ArrayList<Hamper> expectedHamper = new ArrayList<Hamper>();
    ArrayList<Recipient> expectedRecipients = new ArrayList<Recipient>();
    ArrayList<Food> expectedFoods = new ArrayList<Food>();
    @Test
    public void testOrder(){
        Order actualOrder=new Order();
        assertEquals("Order constructor did not initialize hampers properly",
        expectedHamper,actualOrder.getHampers());

    }
    @Test
    public void testAddNewHamper(){
        expectedHamper.clear();
        Hamper actualHamper=new Hamper();
        expectedRecipients.clear();
        expectedRecipients.add(new Recipient(0));
        expectedRecipients.add(new Recipient(1));
        expectedFoods.clear();
        expectedFoods.add(new Food(0023));
        actualHamper.setFoods(expectedFoods);
        actualHamper.setRecipients(expectedRecipients);
        Order actual =new Order();
        expectedHamper.add(actualHamper);
        actual.addNewHamper(actualHamper);
        assertEquals("addNewHamper() does not add hamper properly",
        expectedHamper,actual.getHampers());

    }
    @Test
    public void testGetHampers(){
         expectedHamper.clear();
        ArrayList<Hamper> actualHampers = new ArrayList<Hamper>();
        Hamper actualHamper=new Hamper();
        expectedRecipients.clear();
        expectedRecipients.add(new Recipient(0));
        expectedRecipients.add(new Recipient(1));
        expectedFoods.clear();
        expectedFoods.add(new Food(0023));
        actualHamper.setFoods(expectedFoods);
        actualHamper.setRecipients(expectedRecipients);
        actualHampers.add(actualHamper);
        Order actual =new Order();
        expectedHamper.add(actualHamper);
        actual.setHampers(actualHampers);
        assertEquals("getHampers() does not return hampers properly",
        expectedHamper,actual.getHampers());
        

    }
    @Test
    public void testSetOrderFormStatus(){
        boolean testStatus=true;
        Order actual =new Order();
        actual.setOrderFormCreated(testStatus);
        assertEquals("setOrderFormCreated() does not set Order Form Status properly",
        testStatus,actual.getOrderFormCreated());

    }
    @Test
    public void testCalculateFoodDistribution(){
        expectedFoods.clear();
        Food g= new Food(0023);
        expectedFoods.add(g);
         Order actual =new Order();
        actual.calculateFoodDistribution(testStatus);
    }

}
