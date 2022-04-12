package edu.ucalgary.ensf409;

import org.junit.*;

import static org.junit.Assert.*;
import java.io.*;
import java.util.*;

public class FoodTest {
    int EXPECTED_ITEM_ID = 0023;
    String EXPECTED_NAME = "Tomato Sauce, jar";
    int EXPECTED_GRAIN_CONTENT = 0;
    int EXPECTED_FV_CONTENT = 80;
    int EXPECTED_PRO_CONTENT = 10;
    int EXPECTED_OTHER = 10;
    int EXPECTED_CALORIES = 120;

    public Food testObject1= new Food(EXPECTED_ITEM_ID);

    @Test
    public void testGetItemID() {
        String ACTUAL_ITEM_ID = testObject1.getItemID();
        assertEquals("Incorrect information stored/returned for food Item ID.", EXPECTED_ITEM_ID, ACTUAL_ITEM_ID);
    }

    @Test
    public void testGetName() {
        String ACTUAL_NAME = testObject1.getName();
        assertEquals("Incorrect information stored/returned for food name.", EXPECTED_NAME, ACTUAL_NAME);
    }

    @Test
    public void testGetGrainContent() {
        String ACTUAL_GRAIN_CONTENT = testObject1.getGrainContent();
        assertEquals("Incorrect information stored/returned for grain content.", EXPECTED_GRAIN_CONTENT,
                ACTUAL_GRAIN_CONTENT);
    }

    @Test
    public void testGetFVContent() {
        String ACTUAL_FV_CONTENT = testObject1.getFVContent();
        assertEquals("Incorrect information stored/returned for fruits/veggies content.", EXPECTED_FV_CONTENT,
                ACTUAL_FV_CONTENT);
    }

    @Test
    public void testGetProContent() {
        String ACTUAL_PRO_CONTENT = testObject1.getProContent();
        assertEquals("Incorrect information stored/returned for protein content.", EXPECTED_PRO_CONTENT,
                ACTUAL_PRO_CONTENT);
    }

    @Test
    public void testGetOtherContent() {
        String ACTUAL_OTHER_CONTENT = testObject1.getOtherContent();
        assertEquals("Incorrect information stored/returned for other content.", EXPECTED_OTHER_CONTENT,
                ACTUAL_OTHER_CONTENT);
    }

    @Test
    public void testGetCalories() {
        String ACTUAL_CALORIES = testObject1.getCalories();
        assertEquals("Incorrect information stored/returned for calories.", EXPECTED_CALORIES,
                ACTUAL_CALORIES);
    }
}
