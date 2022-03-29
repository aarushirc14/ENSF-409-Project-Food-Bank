package edu.ucalgary.ensf409;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class AvailableFoodTest {

    @Test
    public void testAvailableFoods(){
        AvailableFood test = new AvailableFood();
        assertEquals(0, test.getAvailableFood(0).getItemID);
    }
    @Test
    public void setAvailableFood(){
        AvailableFood test = new AvailableFood();
        ArrayList<Food> realVal = new ArrayList<Food>();
        Food realFood = new Food(2);
        test.setAvailableFood(realVal);
        assertEquals(realVal.get(0).getItemID, test.get(0).getItemID);
    }

    @Test
    public void testRemoveFoodItem(){
        AvailableFood test = new AvailableFood();
        Food delFood = new Food(0);
        int itemID = delFood.getItemID();
        test.removeFoodItem(delFood);
        assertEquals(itemID, test.get(0).getItemID());
    }
}
