import javax.swing.*;
import java.awt.*;

public class startNewGame extends JFrame {

    // Constructor for StartNewGame screen
    public startNewGame() {
        // Set the window title
        setTitle("Choose Your Pet");

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the window size
        setSize(800, 600);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Create a label to indicate this is the Start New Game screen
        JLabel label = new JLabel("Select Your Pet", JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        add(label, BorderLayout.NORTH);

        // Create a panel for pet selection (GridLayout: 2 rows, 3 columns)
        JPanel petPanel = new JPanel();
        petPanel.setLayout(new GridLayout(2, 3, 10, 10));

        // Create labels for pet names
        JLabel pet1Name = new JLabel("Cat", JLabel.CENTER);
        JLabel pet2Name = new JLabel("Dog", JLabel.CENTER);
        JLabel pet3Name = new JLabel("Rabbit", JLabel.CENTER);

        // Load pet images (replace these paths with actual image file paths)
        ImageIcon pet1Icon = new ImageIcon("sprites/cat_normal.png");
        ImageIcon pet2Icon = new ImageIcon("sprites/dog_normal.png");
        ImageIcon pet3Icon = new ImageIcon("sprites/sheep_normal.png");

        // Create buttons with images
        JButton pet1Button = new JButton(pet1Icon);
        JButton pet2Button = new JButton(pet2Icon);
        JButton pet3Button = new JButton(pet3Icon);

        // Set action listeners for the buttons
        pet1Button.addActionListener(e -> openPetDisplay("cat"));
        pet2Button.addActionListener(e -> openPetDisplay("dog"));
        pet3Button.addActionListener(e -> openPetDisplay("sheep"));

        // Add pet buttons with images (second row)
        petPanel.add(pet1Button);
        petPanel.add(pet2Button);
        petPanel.add(pet3Button);

        // Add pet names (first row)
        petPanel.add(pet1Name);
        petPanel.add(pet2Name);
        petPanel.add(pet3Name);

        // Add the panel to the center
        add(petPanel, BorderLayout.CENTER);
    }

    // Method to open the Pet display screen with the selected pet
    private void openPetDisplay(String petType) {
        pet pet = new pet(petType);  // Create Pet instance with the selected type
        pet.setVisible(true);  // Show the Pet display screen
        this.setVisible(false);  // Hide the current screen
    }

    public static void main(String[] args) {
        // Create and display the start new game screen
        SwingUtilities.invokeLater(() -> {
            startNewGame startGame = new startNewGame();
            startGame.setVisible(true);
        });
    }
}
