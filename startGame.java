import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;

public class startGame extends JFrame {

    // Constructor for the StartGame screen
    public static void showWindow() {
        JFrame frame = new JFrame("Choose Your Pet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Title label
        JLabel pageTitle = new JLabel("Select Your Pet");
        pageTitle.setBounds(275, 45, 225, 30); // x, y, width, height
        pageTitle.setFont(new Font("Arial", Font.BOLD, 30));
        pageTitle.setOpaque(false);
        pageTitle.setBorder(null);
        frame.add(pageTitle);

        // Label for entering pet name
        JLabel nameLabel = new JLabel("Enter your pet's name:");
        nameLabel.setBounds(275, 100, 250, 30); // x, y, width, height
        nameLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        frame.add(nameLabel);

        // Text field for pet's name
        JTextField petNameField = new JTextField();
        petNameField.setBounds(275, 130, 250, 30); // x, y, width, height
        frame.add(petNameField);

        // Button to confirm pet name
        JButton confirmButton = new JButton("Confirm Name");
        confirmButton.setBounds(275, 170, 250, 30); // x, y, width, height
        frame.add(confirmButton);

        // Disable pet selection buttons initially
        JButton pet1Button = createPetButton("cat_normal.png", 95, 175);
        JButton pet2Button = createPetButton("dog_normal.png", 285, 175);
        JButton pet3Button = createPetButton("sheep_normal.png", 475, 175);

        pet1Button.setEnabled(false);
        pet2Button.setEnabled(false);
        pet3Button.setEnabled(false);

        frame.add(pet1Button);
        frame.add(pet2Button);
        frame.add(pet3Button);

        // When the confirm button is clicked, enable pet selection buttons
        confirmButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            playerInventory.setBalls(5);
            playerInventory.setFish(5);
            playerInventory.setBears(5);
            playerInventory.setMilk(5);
            playerInventory.setBlocks(5);
            playerInventory.setTreats(5);
            playerInventory.setSpinners(5);
            playerInventory.setChicken(5);

            String petName = petNameField.getText().trim();
            if (!petName.isEmpty()) {
                // Enable pet selection buttons
                pet1Button.setEnabled(true);
                pet2Button.setEnabled(true);
                pet3Button.setEnabled(true);

                // Optionally, show a confirmation message
                JOptionPane.showMessageDialog(frame, "Your pet's name is: " + petName);
            } else {
                // If no name is entered, show an error message
                JOptionPane.showMessageDialog(frame, "Please enter a valid pet name.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        // Set action listeners for the pet buttons
        pet1Button.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            String petName = petNameField.getText().trim();
            pet petWindow = new pet("cat", petName, 100, 100, 100, 100, 5); // Pass name to pet window
            petWindow.setVisible(true);
            frame.dispose(); // Close the pet selection window
        });

        pet2Button.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            String petName = petNameField.getText().trim();
            pet petWindow = new pet("dog", petName, 100, 100, 100, 100, 5); // Pass name to pet window
            petWindow.setVisible(true);
            frame.dispose(); // Close the pet selection window
        });

        pet3Button.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            String petName = petNameField.getText().trim();
            pet petWindow = new pet("sheep", petName, 100, 100, 100, 100, 5); // Pass name to pet window
            petWindow.setVisible(true);
            frame.dispose(); // Close the pet selection window
        });

        frame.setVisible(true);
    }

   

    // Method to create pet selection buttons with images
    private static JButton createPetButton(String petImagePath, int x, int y) {
        ImageIcon petIcon = new ImageIcon("sprites/" + petImagePath);
        Image scaledPet = petIcon.getImage().getScaledInstance(225, 225, Image.SCALE_SMOOTH);
        ImageIcon scaledPetIcon = new ImageIcon(scaledPet);

        JButton petButton = new JButton(scaledPetIcon);
        petButton.setBorderPainted(false);
        petButton.setFocusPainted(false);
        petButton.setContentAreaFilled(false);
        petButton.setBounds(x, y, 200, 200);

        petButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                petButton.setBorder(new LineBorder(Color.BLUE, 2));
                Image scaledImage = petIcon.getImage().getScaledInstance(
                        (int) (250 * 1.1), (int) (250 * 1.1), Image.SCALE_SMOOTH);
                petButton.setIcon(new ImageIcon(scaledImage));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                petButton.setBorder(null);
                petButton.setIcon(petIcon);
            }
        });

        return petButton;
    }
    

    // Main method to launch the start screen
    public static void main(String[] args) {
        showWindow();
    }
}

