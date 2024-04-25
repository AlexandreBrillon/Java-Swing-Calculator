import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame frame;
    private JTextField displayField;
    private JButton[] numberButtons;
    private JButton[] operationButtons;

    private double num1 = 0;
    private double num2 = 0;
    private char operation = ' ';

    public Calculator() {
        // Create the JFrame
        frame = new JFrame("Calculator");
        frame.setSize(300, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        // Create Field for Inputs
        displayField = new JTextField();
        displayField.setEditable(false);
        frame.add(displayField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        //Create Number Buttons
        numberButtons = new JButton[10];
        for (int i=0; i<10; i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            int number = i;
            numberButtons[i].addActionListener(new ActionListener (){
                @Override
                public void actionPerformed(ActionEvent e) {
                    displayField.setText(displayField.getText() + number);
                }
            });
            buttonPanel.add(numberButtons[i]);
        }

        //Create Operation Buttons
        operationButtons = new JButton[4];
        String[] operationSymbols = {"+", "-", "*", "/"};
        for (int i=0; i<operationSymbols.length; i++){
            char op = operationSymbols[i].charAt(0);
            operationButtons[i] = new JButton(String.valueOf(op));
            operationButtons[i].addActionListener(new ActionListener (){
                @Override
                public void actionPerformed(ActionEvent e) {
                    num1 = Double.parseDouble(displayField.getText());
                    operation = op;
                    displayField.setText("");
                }

            });
            buttonPanel.add(operationButtons[i]);
        }

        //Create Equal Button
        JButton equalButton = new JButton("=");
        equalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                num2 = Double.parseDouble(displayField.getText());
                switch(operation) {
                    case '+':
                        displayField.setText(String.valueOf(num1 + num2));
                        break;
                    case '-':
                        displayField.setText(String.valueOf(num1 - num2));
                        break;
                    case '*':
                        displayField.setText(String.valueOf(num1 * num2));
                        break;
                    case '/':
                        displayField.setText(String.valueOf(num1 / num2));
                        break;
                }
            }
        });
        buttonPanel.add(equalButton);

        //Create AC button
        JButton clearButton = new JButton("AC");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayField.setText(" ");
                num1 = 0;
                num2 = 0;
            }
        });
        buttonPanel.add(clearButton);

        frame.add(buttonPanel, BorderLayout.CENTER);
        frame.setVisible(true);


    }

    public static void main(String[] args) {
        new Calculator();
    }
}
