package edu.ucalgary.ensf409;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class OrderFormTest {

    @Test
    public void testOrderFormCreated(){
        OrderForm test = new OrderForm();
        assertEquals(true, test.getOrderFormCreated());
    }

    @Test(expected = IOException.class)
    public void testUpdateDataBase() throws IOException {
        OrderForm test = new OrderForm();
        test.updateDataBase();
    }
}
