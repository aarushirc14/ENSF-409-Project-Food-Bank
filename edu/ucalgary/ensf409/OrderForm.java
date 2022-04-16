package edu.ucalgary.ensf409;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class OrderForm extends Order{
    private final static String OUTPUTFILENAME = "orderform.txt";
    private AccessFoodInventory access = new AccessFoodInventory("jdbc:mysql://localhost/food_inventory", "student", "ensf");

    public OrderForm(){
        File output = new File(OUTPUTFILENAME);
        String finalStringOut = "";
        try(FileWriter writer = new FileWriter(output)) {

            for(int i = 0; i < getHampers().size(); i++) {
                finalStringOut += "Hamper " + i + ": " + getHampers().get(i).recipientsToString() + "\n";
                finalStringOut += "Hamper " + i + " items:\n" + getHampers().get(i).foodsToString() + "\n";
            }
            writer.write(finalStringOut);
            setOrderFormCreated(true);
        }
        catch(IOException e){
            System.out.println("Could not write information into file");
            setOrderFormCreated(false);
        }
    }
    public void updateDataBase() throws IOException{
        try {
            access.initializeConnection();
            for (int i = 0; i < getHampers().size(); i++) {
                for (int j = 0; j < getHampers().get(i).getFoods().size(); j++) {
                    access.deleteAvailableFood(String.valueOf(getHampers().get(i).getFoods().get(j).getItemID()));
                }

            }
            access.dbConnectClose();
        }catch(Exception ex ) {
            throw new IOException();
        }
    }

}

