import javax.swing.*;

public class parentalControls {
  public static void showWindow() {
    // Create a new JFrame
    JFrame frame = new JFrame("Blank GUI Page");

    JLabel label = new JLabel("Parental Controls");
    label.setHorizontalAlignment(SwingConstants.CENTER);
    frame.add(label);
    // Set the size of the frame
    frame.setSize(600, 600); // Width: 600px, Height: 600px

    // Set default close operation (exit the application when the window is closed)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set the frame's visibility
    frame.setVisible(true);

    // Optionally, center the frame on the screen
    frame.setLocationRelativeTo(null);
  }
}



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
    JLabel pet1Name = new JLabel("Pet 1", JLabel.CENTER);
    JLabel pet2Name = new JLabel("Pet 2", JLabel.CENTER);
    JLabel pet3Name = new JLabel("Pet 3", JLabel.CENTER);

    // Load pet images (replace these paths with actual image file paths)
    ImageIcon pet1Icon = new ImageIcon("MainBefore.jpg");
    ImageIcon pet2Icon = new ImageIcon("MainBefore.jpg");
    ImageIcon pet3Icon = new ImageIcon("MainBefore.jpg");

    // Create buttons with images
    JButton pet1Button = new JButton(pet1Icon);
    JButton pet2Button = new JButton(pet2Icon);
    JButton pet3Button = new JButton(pet3Icon);

    // Set action listeners for the buttons (for future functionality)
    pet1Button.addActionListener(e -> System.out.println("Pet 1 selected"));
    pet2Button.addActionListener(e -> System.out.println("Pet 2 selected"));
      pet3Button.addActionListener(e -> System.out.println("Pet 3 selected"));

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

    public static void main(String[] args) {
        // Create and display the start new game screen
        SwingUtilities.invokeLater(() -> {
            startNewGame startGame = new startNewGame();
            startGame.setVisible(true);
        });
    }
}