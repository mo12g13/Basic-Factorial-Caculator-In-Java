package com.momoJohnson;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

/**
 * Created by Momo Johnson on 9/18/2016.
 */
//Setting up of the JFrame
public class FactorialCalculator extends JFrame {
    private JTextField txtNumberInput;
    private JTextField txtFactorialCalculatedField;
    private JPanel rootPane;
    private JButton calculate;
    private JButton btnClear;
    private JButton btnExit;

    public FactorialCalculator(){
        super("Factorial Calculator");
        setPreferredSize(new Dimension(400, 200));
        setContentPane(rootPane);

        setLocationRelativeTo(null);
        rootPane.getRootPane().setDefaultButton(calculate);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);



        //A button that clears the  form
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogueButton = JOptionPane.YES_NO_CANCEL_OPTION;



                   int  result = JOptionPane.showConfirmDialog(rootPane,
                           "No input has been made, so there is nothing to clear","Error", dialogueButton);
                    if(result == JOptionPane.YES_OPTION){
                        txtFactorialCalculatedField.setText("");
                        txtNumberInput.setText("");
                        txtNumberInput.requestFocus();
                    }

            }
        });

        //A Event handler that exits the form
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int dialogueButton = JOptionPane.YES_NO_CANCEL_OPTION;
                int result = JOptionPane.showConfirmDialog(rootPane, "Are sure you want to exit?", "Confirm", dialogueButton);
                if(result == JOptionPane.YES_OPTION){
                    System.exit(0);
                }


            }
        });


        calculate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                long factorial =1;
               if(isValidData()){
                   int number = Integer.parseInt(txtNumberInput.getText());
                   for(int i=1; i<=number; i++){
                       factorial*=i;
                   }
                   DecimalFormat df = new DecimalFormat("#, ###");
                   txtFactorialCalculatedField.setText(""+df.format(factorial));

               }

            }

        });
    }
    //A method that checks for a valid integer entered by the user
    private  boolean isInteger(JTextField textField, String name) {

        try{
        if (Integer.parseInt(textField.getText()) > 0 && Integer.parseInt(textField.getText()) <= 20) {
            return true;
        } else {
            JOptionPane.showMessageDialog(rootPane, "Please enter a number between 1-20 for "
                    + name, "Input error", JOptionPane.ERROR_MESSAGE);
            textField.setText("");
            textField.requestFocus();
            return false;
        }
        }catch (NumberFormatException exe){
            JOptionPane.showConfirmDialog(rootPane, "Number shouldn't letters", "Input Error", JOptionPane.ERROR_MESSAGE);
            txtNumberInput.requestFocus();
            txtNumberInput.setText("");
            return false;
        }
    }
    // A method that checks to make sure that the text box is not empty
    private  boolean isPresent(JTextField textField, String name){
        if(textField.getText().equals("")){
            JOptionPane.showMessageDialog(this.rootPane, name+
                    " is a required field, please enter a valid number", "Input Error", JOptionPane.ERROR_MESSAGE);
            textField.requestFocus();

            return false;
        }else {

            return true;
        }


    }
    // A method that checks to make sure that all entry are valid
    private boolean isValidData(){
        if(!isPresent(txtNumberInput, "Number")){
            return  false;
        }else  if(!isInteger(txtNumberInput, "Number")) {
            return false;
        }
        return true;
    }

}
