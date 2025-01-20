import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorApp {

    // Core calculator logic
    public static double add(double a, double b) {
        return a + b;
    }

    public static double subtract(double a, double b) {
        return a - b;
    }

    public static double multiply(double a, double b) {
        return a * b;
    }

    public static double divide(double a, double b) throws ArithmeticException {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return a / b;
    }

    public static void main(String[] args) {
        // Create JFrame
        JFrame frame = new JFrame("Arithmetic Operations Application");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        frame.setLayout(new GridLayout(6, 2, 5, 5));

        // Input fields and labels
        JLabel label1 = new JLabel("Enter first number:");
        JTextField field1 = new JTextField();
        JLabel label2 = new JLabel("Enter second number:");
        JTextField field2 = new JTextField();

        JLabel resultLabel = new JLabel("Result:");
        JLabel resultValue = new JLabel();

        // Buttons for operations
        JButton addButton = new JButton("Add");
        JButton subtractButton = new JButton("Subtract");
        JButton multiplyButton = new JButton("Multiply");
        JButton divideButton = new JButton("Divide");

        // Adjust button sizes
        Dimension buttonSize = new Dimension(100, 30);
        addButton.setPreferredSize(buttonSize);
        subtractButton.setPreferredSize(buttonSize);
        multiplyButton.setPreferredSize(buttonSize);
        divideButton.setPreferredSize(buttonSize);

        // ActionListener for buttons
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double num1 = Double.parseDouble(field1.getText());
                    double num2 = Double.parseDouble(field2.getText());
                    double result = 0;

                    if (e.getSource() == addButton) {
                        result = add(num1, num2);
                    } else if (e.getSource() == subtractButton) {
                        result = subtract(num1, num2);
                    } else if (e.getSource() == multiplyButton) {
                        result = multiply(num1, num2);
                    } else if (e.getSource() == divideButton) {
                        result = divide(num1, num2);
                    }

                    resultValue.setText(String.valueOf(result));
                } catch (NumberFormatException ex) {
                    resultValue.setText("Invalid input!");
                } catch (ArithmeticException ex) {
                    resultValue.setText(ex.getMessage());
                }
            }
        };

        addButton.addActionListener(listener);
        subtractButton.addActionListener(listener);
        multiplyButton.addActionListener(listener);
        divideButton.addActionListener(listener);

        // Add components to frame
        frame.add(label1);
        frame.add(field1);
        frame.add(label2);
        frame.add(field2);
        frame.add(addButton);
        frame.add(subtractButton);
        frame.add(multiplyButton);
        frame.add(divideButton);
        frame.add(resultLabel);
        frame.add(resultValue);

        // Display the frame
        frame.setVisible(true);
    }
}
