import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PalindromeChecker {

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Palindrome Checker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);
        
        // Create components
        JLabel instructionLabel = new JLabel("Enter a word, phrase, or number:");
        JTextField inputField = new JTextField(20);
        JButton checkButton = new JButton("Check Palindrome");
        JLabel resultLabel = new JLabel("Result will appear here", SwingConstants.CENTER);

        // Configure components
        resultLabel.setFont(new Font("Arial", Font.BOLD, 14));
        resultLabel.setForeground(Color.BLUE);

        // Layout setup
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1, 10, 10));
        panel.add(instructionLabel);
        panel.add(inputField);
        panel.add(checkButton);
        panel.add(resultLabel);

        frame.add(panel);

        // Add action listener for the button
        checkButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText().trim();
                if (input.isEmpty()) {
                    resultLabel.setText("Please enter a valid input.");
                } else {
                    if (isPalindrome(input)) {
                        resultLabel.setText("\"" + input + "\" is a Palindrome!");
                    } else {
                        resultLabel.setText("\"" + input + "\" is NOT a Palindrome.");
                    }
                }
            }
        });

        // Make the frame visible
        frame.setVisible(true);
    }

    // Core logic to check for palindrome
    private static boolean isPalindrome(String input) {
        // Remove non-alphanumeric characters and convert to lowercase
        String cleanedInput = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        String reversedInput = new StringBuilder(cleanedInput).reverse().toString();
        return cleanedInput.equals(reversedInput);
    }
}
