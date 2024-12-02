import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial extends JFrame {
    public static void showWindow() {
        JFrame frame = new JFrame("Game Instructions");
        frame.setTitle("Game Instructions");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change to DISPOSE_ON_CLOSE
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);

        // Title label
        JLabel title = new JLabel("Welcome to Petopia!");
        title.setBounds(200, 20, 400, 40); // x, y, width, height
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 36));
        title.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(title);

        ImageIcon trainerImage = new ImageIcon("icons/trainer.jpg");
        JLabel trainerLabel = new JLabel(trainerImage);
        trainerLabel.setBounds(50, 100, trainerImage.getIconWidth(), trainerImage.getIconHeight());

        // Instructions text area
        JTextArea instructions = new JTextArea();
        instructions.setText("""
        🐾 Hi there, Petopia Trainer! 🐾

        - 🎮 **Getting Started**:
          Start a new game, load an old one, or check out the parental controls from the main menu!

        - 🐶 **Choose Your Pet**:
          Pick your favorite pet: Cat, Dog, or Sheep! Don't forget to name them!

        - 🍗 **Caring for Your Pet**:
          - Feed your pet to keep their belly full.
          - Put them to sleep to help them rest.
          - Play with them to boost their happiness.
          - Take them to the vet if they're feeling sick.

        - 🛒 **Check Your Inventory**:
          Manage your items wisely! Different foods, toys, and treats have unique effects on your pet's stats. Choose carefully to keep your pet happy and healthy!

        - 🌟 **Stay Alert**:
          Watch your pet's stats (Health, Happiness, Fullness, and Sleep). If they reach zero, your pet might get sad!

        - 💾 **Save and Load**:
          Save your progress and continue your journey anytime!

        🐾 Enjoy your time in Petopia! 🐾
        """);
        instructions.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
        instructions.setLineWrap(true);
        instructions.setWrapStyleWord(true);
        instructions.setEditable(false);
        instructions.setOpaque(false); // Transparent background

        // Wrap the text area inside a scroll pane
        JScrollPane scrollPane = new JScrollPane(instructions);
        scrollPane.setBounds(50, 100, 700, 350); // Adjusted height and position
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        frame.add(scrollPane);

        // Main Menu button
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(50, 500, 150, 40); // x, y, width, height
        mainMenu.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
        frame.add(mainMenu);

        // Action listener to close the tutorial window and return to main menu
        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Closes the tutorial window
                // Optionally, you can open the main menu window here if needed:
                // mainMenu.showWindow();
            }
        });

        // Set the frame's visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        showWindow();
    }
}
