# ENSF-409-Project-Food-Bank
Group 33: Jaxon, Xian, Aryan, Aarushi

Winter 2022 @ University of Calgary

This is a Java application for a fictional food bank that reads an inventory from a SQL database and retrieves food items based on user input.

The user can enter the number and type of recipients through a GUI. This information is then used to calculate optimal amounts and types of foods from the available inventory. Each recipient's dietary needs (ie. the number of required calories in grains, fruits/vegetables, protein etc.) are considered. The program's output is a .txt file named "orderform.txt" which displays the list of recipients and food provided in each hamper. A sample orderform.txt is provided.

To run the program: compile all the java source files and run the main() method located in GUI.java 
Then enter user input in the GUI pop-up window.

Unit test files are provided for all classes except GUI. 

A video demonstration,"Demo.mp4" is provided.

The following .jar files are required to run this application: mysql-connector-java-8.0.28.jar, 
hamcrest-core-1.3.jar, junit-4.13.2.jar

We recommend adding these .jar files in a lib folder inside the main project folder. A lib folder with the files is provided in this repository.

