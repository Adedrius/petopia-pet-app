import java.awt.*;
import javax.swing.*;

public class saveGame {
  public static void showWindow() {
    // Create a new JFrame
    JFrame frame = new JFrame("Save Game");
    // Set the size of the frame
    frame.setSize(500, 400); // Width: 600px, Height: 600px
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);

    JLabel pageTitle = new JLabel("Save Game");
    pageTitle.setBounds(193, 25, 225, 30); // x, y, width, height
    pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
    pageTitle.setOpaque(false);
    pageTitle.setBorder(null);
    frame.add(pageTitle);

    JLabel prompt = new JLabel("Which Save Slot do you want to save to?");
    prompt.setBounds(97, 57, 300, 30); // x, y, width, height
    prompt.setFont(new Font("Arial", Font.PLAIN, 16));
    prompt.setOpaque(false);
    prompt.setBorder(null);
    frame.add(prompt); 

    JButton saveSlot1 = new JButton("Save Slot 1");
    saveSlot1.setBounds(195, 100, 100, 60); // x, y, width, height
    frame.add(saveSlot1);

    JButton saveSlot2 = new JButton("Save Slot 2");
    saveSlot2.setBounds(195, 175, 100, 60); // x, y, width, height
    frame.add(saveSlot2);

    JButton saveSlot3 = new JButton("Save Slot 3");
    saveSlot3.setBounds(195, 250, 100, 60); // x, y, width, height
    frame.add(saveSlot3);

    

    JButton mainMenu = new JButton("<-- Back");
    mainMenu.setBounds(30, 305, 100, 30); // x, y, width, height
    frame.add(mainMenu);

    // Set default close operation (exit the application when the window is closed)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set the frame's visibility
    frame.setVisible(true);

    // Optionally, center the frame on the screen
    frame.setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    showWindow();
  }
}