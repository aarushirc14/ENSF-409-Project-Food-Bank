/**
* @author  Xian, Jaxon, Aarushi, Aryan
* @version 1.4
* @since   2022-04-17
*/

package edu.ucalgary.ensf409;

import org.junit.*;

import static org.junit.Assert.*;

public class FoodTest {
    int EXPECTED_ITEM_ID = 23;
    String EXPECTED_NAME = "Tuna, six small cans";
    int EXPECTED_GRAIN_CONTENT = 0;
    int EXPECTED_FV_CONTENT = 0;
    int EXPECTED_PRO_CONTENT = 171;
    int EXPECTED_OTHER = 729;
    int EXPECTED_CALORIES = 900;

    public Food testObject1 = new Food(EXPECTED_ITEM_ID);

    /**
     * The following tests all check the getters of the Food class.
     * The constructor is not tested as the getters passing these tests
     * indicates the constructor is functiong as expected.
     */
    @Test
    public void testGetItemID() {
        int ACTUAL_ITEM_ID = testObject1.getItemID();
        assertEquals("Incorrect information stored/returned for food Item ID.", EXPECTED_ITEM_ID, ACTUAL_ITEM_ID);
    }

    @Test
    public void testGetName() {
        String ACTUAL_NAME = testObject1.getName();
        assertEquals("Incorrect information stored/returned for food name.", EXPECTED_NAME, ACTUAL_NAME);
    }

    @Test
    public void testGetGrainContent() {
        int ACTUAL_GRAIN_CONTENT = testObject1.getGrainContent();
        assertEquals("Incorrect information stored/returned for grain content.", EXPECTED_GRAIN_CONTENT,
                ACTUAL_GRAIN_CONTENT);
    }

    @Test
    public void testGetFVContent() {
        int ACTUAL_FV_CONTENT = testObject1.getFVContent();
        assertEquals("Incorrect information stored/returned for fruits/veggies content.", EXPECTED_FV_CONTENT,
                ACTUAL_FV_CONTENT);
    }

    @Test
    public void testGetProContent() {
        int ACTUAL_PRO_CONTENT = testObject1.getProContent();
        assertEquals("Incorrect information stored/returned for protein content.", EXPECTED_PRO_CONTENT,
                ACTUAL_PRO_CONTENT);
    }

    @Test
    public void testGetOtherContent() {
        int ACTUAL_OTHER_CONTENT = testObject1.getOtherContent();
        assertEquals("Incorrect information stored/returned for other content.", EXPECTED_OTHER,
                ACTUAL_OTHER_CONTENT);
    }

    @Test
    public void testGetCalories() {
        int ACTUAL_CALORIES = testObject1.getCalories();
        assertEquals("Incorrect information stored/returned for calories.", EXPECTED_CALORIES,
                ACTUAL_CALORIES);
    }
}
