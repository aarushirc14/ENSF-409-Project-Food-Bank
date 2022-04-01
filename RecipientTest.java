package edu.ucalgary.ensf409;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class RecipientTest {

    @Test
    public void testClientType(){ // Test the client type/gender
        Recipient test = new Recipient(0);
        assertEquals("Adult Male", test.getClientType());
    }

    @Test
    public void testWholeGrain(){ // Test the wholegrains needed for adult female
        Recipient test = new Recipient(1);
        assertEquals(16, test.getWholeGrains());
    }

    @Test
    public void testProtein(){ // Test the protein for Child over 8
        Recipient test = new Recipient(2);
        assertEquals(31, test.getProtein());
    }

    @Test
    public void testFruitsVeg(){ // Test the FruitsVeg for child under 8
        Recipient test = new Recipient(3);
        assertEquals(33, test.getFruitsVeggies());
    }

    @Test
    public void testOther(){ // Test the other for adult male
        Recipient test = new Recipient(0);
        assertEquals(30, test.getOther());
    }

    @Test
    public void testCalories(){ //Test the calories needed for adult male
        Recipient test = new Recipient(0);
        assertEquals(2500, test.getCalories());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testIncorrectArgument(){ // Test if whether the recipient will give a IllegalArgumentException if given the wrong recipientID
        Recipient test = new Recipient(5);

    }
}
