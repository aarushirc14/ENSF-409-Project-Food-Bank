package edu.ucalgary.ensf409;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrderForm extends Order{
    private final static String OUTPUTFILENAME = "orderform.txt";
    private AccessFoodInventory access = new AccessFoodInventory("jdbc:mysql://localhost/food_inventory", "student", "ensf");

    public OrderForm(Order order){
        File output = new File(OUTPUTFILENAME);
        String finalStringOut = "";
        try(FileWriter writer = new FileWriter(output)) {

            for(int i = 0; i < order.getHampers().size(); i++) {
                finalStringOut += "Hamper " + i + ": " + order.getHampers().get(i).recipientsToString() + "\n";
                finalStringOut += "Hamper " + i + " items:\n" + order.getHampers().get(i).foodsToString() + "\n";
            }
            writer.write(finalStringOut);
            setOrderFormCreated(true);
        }
        catch(IOException e){
            System.out.println("Could not write information into file");
             setOrderFormCreated(false);
        }
    }
    public void updateDataBase(Order order) throws IOException{
        try {
            access.initializeConnection();
            for (int i = 0; i < order.getHampers().size(); i++) {
                for (int j = 0; j < order.getHampers().get(i).getFoods().size(); j++) {
                    access.deleteAvailableFood(String.valueOf(order.getHampers().get(i).getFoods().get(j).getItemID()));
                }
            }
            access.dbConnectClose();
        }catch(Exception ex ) {
            throw new IOException();
        }
    }

}

