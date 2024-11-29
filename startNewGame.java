import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class startNewGame extends JFrame {

    // Constructor for the StartGame screen
    public static void showWindow() {

        JFrame frame = new JFrame("Choose Your Pet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        JLabel pageTitle = new JLabel("Select Your Pet");
        pageTitle.setBounds(275, 45, 225, 30); // x, y, width, height
        pageTitle.setFont(new Font("Arial", Font.BOLD, 30));
        pageTitle.setOpaque(false);
        pageTitle.setBorder(null);
        frame.add(pageTitle);

        // Create a label for the name input
        JLabel nameLabel = new JLabel("Enter Pet's Name: ");
        nameLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel.setBounds(90, 100, 200, 30); // x, y, width, height
        frame.add(nameLabel);

        // Create a text field for entering the pet name
        JTextField petNameField = new JTextField();
        petNameField.setBounds(90, 135, 300, 30); // x, y, width, height
        frame.add(petNameField);

        // Create a button to submit the name
        JButton submitButton = new JButton("Submit Name");
        submitButton.setBounds(90, 180, 200, 40);
        frame.add(submitButton);

        // Create labels for pet names
        JLabel pet1Name = new JLabel("Pet 1", JLabel.CENTER);
        pet1Name.setFont(new Font("Arial", Font.BOLD, 16));
        pet1Name.setBounds(90, 250, 225, 30); // x, y, width, height

        JLabel pet2Name = new JLabel("Pet 2", JLabel.CENTER);
        pet2Name.setFont(new Font("Arial", Font.BOLD, 16));
        pet2Name.setBounds(275, 250, 225, 30); // x, y, width, height

        JLabel pet3Name = new JLabel("Pet 3", JLabel.CENTER);
        pet3Name.setFont(new Font("Arial", Font.BOLD, 16));
        pet3Name.setBounds(470, 250, 225, 30); // x, y, width, height

        frame.add(pet1Name);
        frame.add(pet2Name);
        frame.add(pet3Name);

        // PET IMAGE 1 SETUP
        ImageIcon pet1Icon = new ImageIcon("sprites/cat_normal.png");
        Image scaledPet1 = pet1Icon.getImage().getScaledInstance(225, 225, Image.SCALE_SMOOTH);
        ImageIcon scaledPet1Icon = new ImageIcon(scaledPet1);

        // Create buttons with images
        JButton pet1Button = new JButton(scaledPet1Icon);
        pet1Button.setBorderPainted(false);
        pet1Button.setFocusPainted(false);
        pet1Button.setContentAreaFilled(false);
        pet1Button.setBounds(95, 275, 200, 200);
        frame.add(pet1Button);

        // PET IMAGE 2 SETUP
        ImageIcon pet2Icon = new ImageIcon("sprites/dog_normal.png");
        Image scaledPet2 = pet2Icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
        ImageIcon scaledPet2Icon = new ImageIcon(scaledPet2);

        // Create buttons with images
        JButton pet2Button = new JButton(scaledPet2Icon);
        pet2Button.setBorderPainted(false);
        pet2Button.setFocusPainted(false);
        pet2Button.setContentAreaFilled(false);
        pet2Button.setBounds(285, 275, 200, 200);
        frame.add(pet2Button);

        // PET 3 IMAGE SETUP
        ImageIcon pet3Icon = new ImageIcon("sprites/sheep_normal.png");
        Image scaledPet3 = pet3Icon.getImage().getScaledInstance(225, 225, Image.SCALE_SMOOTH);
        ImageIcon scaledPet3Icon = new ImageIcon(scaledPet3);

        // PET 3 BUTTON
        JButton pet3Button = new JButton(scaledPet3Icon);
        pet3Button.setBorderPainted(false);
        pet3Button.setFocusPainted(false);
        pet3Button.setContentAreaFilled(false);
        pet3Button.setBounds(475, 275, 200, 200);
        frame.add(pet3Button);

        // Action listener for the submit button
        submitButton.addActionListener(e -> {
            String petName = petNameField.getText().trim();
            if (petName.isEmpty()) {
                JOptionPane.showMessageDialog(frame, "Please enter a valid pet name.", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                // Enable the pet buttons once the name is submitted
                pet1Button.setEnabled(true);
                pet2Button.setEnabled(true);
                pet3Button.setEnabled(true);
                petNameField.setEditable(false);  // Disable editing after name is submitted
                submitButton.setEnabled(false);  // Disable the submit button
            }
        });

        // Set action listeners for the pet selection buttons
        pet1Button.addActionListener(e -> {
            String petName = petNameField.getText().trim();
            pet petWindow = new pet("cat", petName); // Pass petName to the Pet window
            petWindow.setVisible(true);
            frame.dispose(); // Close the pet selection window
        });

        pet2Button.addActionListener(e -> {
            String petName = petNameField.getText().trim();
            pet petWindow = new pet("dog", petName); // Pass petName to the Pet window
            petWindow.setVisible(true);
            frame.dispose(); // Close the pet selection window
        });

        pet3Button.addActionListener(e -> {
            String petName = petNameField.getText().trim();
            pet petWindow = new pet("sheep", petName); // Pass petName to the Pet window
            petWindow.setVisible(true);
            frame.dispose(); // Close the pet selection window
        });

        // Initially disable the pet selection buttons
        pet1Button.setEnabled(false);
        pet2Button.setEnabled(false);
        pet3Button.setEnabled(false);

        frame.setVisible(true);
    }

    // Method to show the window
    public static void main(String[] args) {
        showWindow();
    }
}


