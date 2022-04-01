package edu.ucalgary.ensf409;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OrderFormTest {

    @Test
    public void testOrderFormCreated(){ // Test whether the orderFormCreated value gets changed when orderform object is created
        OrderForm test = new OrderForm();
        assertEquals(true, test.getOrderFormCreated());
    }

    @Test(expected = IOException.class)
    public void testUpdateDataBase() throws IOException { // Test whether updateDataBase throws a IOException when database is incorrect
        OrderForm test = new OrderForm();
        test.updateDataBase();
    }
}
