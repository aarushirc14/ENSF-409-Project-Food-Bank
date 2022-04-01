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
        expectedRecipients.add(new Recepient(0));
        expectedRecipients.add(new Recepient(1));
        expectedFoods.clear();
        expectedFoods.add(new Food(0023));
        actualHamper.setFoods(expectedFoods);
        actualHamper.setRecepients(expectedRecipients);
        Order actual =new Order();
        actual.addNewHamper(actualHamper);
        assertEquals("addNewHamper() does not add hamper properly",
        expectedHamper,actual.getHampers());
        


        


    }
    @Test
    public void testGetHampers(){

    }
    @Test
    public void testSetOrderFormStatus(){

    }
    @Test
    public void testCalculateFoodDistribution(){

    }
    @Test
    public void testCreateOrderForm(){

    }

}
