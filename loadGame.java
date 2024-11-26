import java.awt.*;
import javax.swing.*;

public class loadGame {
    public static void showWindow() {
        // Create a new JFrame
        JFrame frame = new JFrame("Load Game");
        // Set the size of the frame
        frame.setSize(500, 400); // Width: 600px, Height: 600px
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setLayout(null);

        JLabel pageTitle = new JLabel("Load Game");
        pageTitle.setBounds(193, 25, 225, 30); // x, y, width, height
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        pageTitle.setOpaque(false);
        pageTitle.setBorder(null);
        frame.add(pageTitle);

        JButton saveSlot1 = new JButton("Save Slot 1");
        saveSlot1.setBounds(195, 75, 100, 60); // x, y, width, height
        frame.add(saveSlot1);

        JButton saveSlot2 = new JButton("Save Slot 2");
        saveSlot2.setBounds(195, 150, 100, 60); // x, y, width, height
        frame.add(saveSlot2);

        JButton saveSlot3 = new JButton("Save Slot 3");
        saveSlot3.setBounds(195, 225, 100, 60); // x, y, width, height
        frame.add(saveSlot3);

        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(170, 305, 150, 30); // x, y, width, height
        frame.add(mainMenu);

        // Action listener to close the load game window and return to the main menu
        mainMenu.addActionListener(e -> frame.dispose()); // Close the frame when "Main Menu" is clicked

        // Override the default close operation to close the frame (not the entire application)
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // This will close the window instead of the application

        // Set the frame's visibility
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        showWindow();
    }
}
