package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RecipientTest {

    @Test
    public void testClientType(){
        Recipient test = new Recipient(0);
        assertEquals("Adult Male", test.getClientType());
    }

    @Test
    public void testWholeGrain(){
        Recipient test = new Recipient(1);
        assertEquals(20, test.getWholeGrains());
    }

    @Test
    public void testProtein(){
        Recipient test = new Recipient(2);
        assertEquals(20, test.getProtein());
    }

    @Test
    public void testFruitsVeg(){
        Recipient test = new Recipient(3);
        assertEquals(40, test.getFruitsVeggies());
    }

    @Test
    public void testOther(){
        Recipient test = new Recipient(0);
        assertEquals(40, test.getOther());
    }

    @Test
    public void testCalories(){
        Recipient test = new Recipient(0);
        assertEquals(2000, test.getCalories());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIncorrectArgument(){
        Recipient test = new Recipient(5);

    }
}
