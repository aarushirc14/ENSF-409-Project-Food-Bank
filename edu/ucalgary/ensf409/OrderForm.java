/**
* @author  Xian, Jaxon, Aarushi, Aryan
* @version 1.8
* @since   2022-04-17
*/

package edu.ucalgary.ensf409;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrderForm extends Order {
    private final static String OUTPUTFILENAME = "orderform.txt";
    private AccessFoodInventory access = new AccessFoodInventory("jdbc:mysql://localhost/food_inventory", "student",
            "ensf");

    /**
     * Constructor creates orderform.txt and writes the output to the .txt file
     * 
     * @param order
     */

    public OrderForm(Order order) {
        File output = new File(OUTPUTFILENAME);
        String finalStringOut = "";
        try (FileWriter writer = new FileWriter(output)) {

            for (int i = 0; i < order.getHampers().size(); i++) {
                finalStringOut += "Hamper " + (int) (i + 1) + ": " + order.getHampers().get(i).recipientsToString()
                        + "\n";
                finalStringOut += "Hamper " + (int) (i + 1) + " items:\n" + order.getHampers().get(i).foodsToString()
                        + "\n";
            }
            writer.write(finalStringOut);
            setOrderFormCreated(true);
        } catch (IOException e) {
            System.out.println("Could not write information into file");
            setOrderFormCreated(false);
        }
    }

    /**
     * Updates inventory database to remove any food items provided in an order.
     * 
     * @param order
     * @throws IOException
     */
    public void updateDataBase(Order order) throws IOException {
        try {
            access.initializeConnection();
            for (int i = 0; i < order.getHampers().size(); i++) {
                for (int j = 0; j < order.getHampers().get(i).getFoods().size(); j++) {
                    access.deleteAvailableFood(String.valueOf(order.getHampers().get(i).getFoods().get(j).getItemID()));
                }
            }
            access.dbConnectClose();
        } catch (Exception ex) {
            throw new IOException();
        }
    }

}
