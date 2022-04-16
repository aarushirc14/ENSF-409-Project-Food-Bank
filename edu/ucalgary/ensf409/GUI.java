package edu.ucalgary.ensf409;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;


public class GUI extends JFrame implements ActionListener, MouseListener {

    private Order order;

    private int numberMale;
    private int numberFemale;
    private int numberChildOverEight;
    private int numberChildUnderEight;

    private JLabel instructions;
    private JLabel maleLabel;
    private JLabel femaleLabel;
    private JLabel childOverEightLabel;
    private JLabel childUnderEightLabel;

    private JTextField maleInput;
    private JTextField femaleInput;
    private JTextField childOverEightInput;
    private JTextField childUnderEightInput;

    public GUI(){
        super("Order Creation");
        setupGUI();
        setSize(1000, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setupGUI(){
        instructions = new JLabel("<html>To add a new Hamper, " +
        "fill out the amount of each recipient for the hamper below, " + 
        "then press \"Create New Hamper\" to add the hamper " + 
        "to the order.<br>When you are finished, click \"Attempt To Create Order and Order Form " + 
        "to attempt to complete the order.<br>You can terminate the program at any time by closing the window.</html>");
        maleLabel = new JLabel("Number of Male Recipients: ");
        femaleLabel = new JLabel("Number of Female Recipients: ");
        childOverEightLabel = new JLabel("Number of Children Over Eight Recipients: ");
        childUnderEightLabel = new JLabel("Number of Children Under Eight Recipients: ");

        maleInput = new JTextField("e.g. 2", 5);
        femaleInput = new JTextField("e.g. 2", 5);
        childOverEightInput = new JTextField("e.g. 2", 5);
        childUnderEightInput = new JTextField("e.g. 2", 5);

        maleInput.addMouseListener(this);
        femaleInput.addMouseListener(this);
        childOverEightInput.addMouseListener(this);
        childUnderEightInput.addMouseListener(this);

        JButton addHamper = new JButton("Create New Hamper");
        addHamper.addActionListener(this);
        JButton createOrder = new JButton("Attempt To Create Order and Order Form");
        createOrder.addActionListener(this);

        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(new FlowLayout());
        JPanel clientPanel = new JPanel();
        clientPanel.setLayout(new FlowLayout());
        JPanel submitPanel = new JPanel();
        submitPanel.setLayout(new FlowLayout());

        headerPanel.add(instructions);
        clientPanel.add(maleLabel);
        clientPanel.add(maleInput);
        clientPanel.add(femaleLabel);
        clientPanel.add(femaleInput);
        clientPanel.add(childOverEightLabel);
        clientPanel.add(childOverEightInput);
        clientPanel.add(childUnderEightLabel);
        clientPanel.add(childUnderEightInput);
        submitPanel.add(addHamper);
        submitPanel.add(createOrder);

        this.add(headerPanel, BorderLayout.NORTH);
        this.add(clientPanel, BorderLayout.CENTER);
        this.add(submitPanel, BorderLayout.PAGE_END);

        order = new Order();
    }

    public void actionPerformed(ActionEvent event) {
        String command = event.getActionCommand();
        if(!validInput()){
            JOptionPane.showMessageDialog(this, "Input to text boxes must be positive integers");
            return;
        }
        if(command.equals("Create New Hamper")){
            numberMale = Integer.parseInt(maleInput.getText());
            numberFemale = Integer.parseInt(femaleInput.getText());
            numberChildOverEight = Integer.parseInt(childOverEightInput.getText());
            numberChildUnderEight = Integer.parseInt(childUnderEightInput.getText());
            Hamper hamper = new Hamper();
            for (int i = 0; i < numberMale; i++){
                hamper.addNewRecipient(1);
            }
            for (int i = 0; i < numberFemale; i++){
                hamper.addNewRecipient(2);
            }
            for (int i = 0; i < numberChildOverEight; i++){
                hamper.addNewRecipient(3);
            }
            for (int i = 0; i < numberChildUnderEight; i++){
                hamper.addNewRecipient(4);
            }
            order.addNewHamper(hamper);
            JOptionPane.showMessageDialog(this, "Hamper Successfully Added To Order!");
        }
        else {
            // order.calculateFoodDistribution();
            // need to set up calculate food distribution such that it takes no arguments, 
            // just uses the list of hampers and will get the list of avaiblefood in the method
            // OrderForm orderForm = new OrderForm(order)
            // Comment this and the above back in once calculatefooddistribution is functional
            // Need to make orderform work such that if i give it an order it will print out 
            // all the hampers to the orderform.txt file
            OrderForm orderForm = new OrderForm();
            try{
                orderForm.updateDataBase();
            } catch(IOException e){
                JOptionPane.showMessageDialog(this, "Unable to Update Database with needed food, order not completed");
                Order order = new Order();
                return;
            }
            JOptionPane.showMessageDialog(this, "Order and OrderForm Successfully Created!");
            Order order = new Order();
        }
    }

    public boolean validInput(){
        boolean valid = true;
        String regex = "^\\d+$";
        if(!maleInput.getText().matches(regex)||!femaleInput.getText().matches(regex)||
        !childOverEightInput.getText().matches(regex)||!childUnderEightInput.getText().matches(regex)){
            valid = false;
        }
        return valid;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if(e.getSource().equals(maleInput)){
            maleInput.setText("");
        }
        if(e.getSource().equals(femaleInput)){
            femaleInput.setText("");
        }
        if(e.getSource().equals(childOverEightInput)){
            childOverEightInput.setText("");
        }
        if(e.getSource().equals(childUnderEightInput)){
            childUnderEightInput.setText("");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //Nothing needs to be done
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //Nothing needs to be done
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //Nothing needs to be done
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //Nothing needs to be done
        
    }

    public static void main(String args[]){
        EventQueue.invokeLater(() -> {
            new GUI().setVisible(true);
        });
    }
}