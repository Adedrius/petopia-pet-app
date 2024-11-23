import java.awt.Font;

import javax.swing.*;

public class parentalControlsLogin {
  public static void showWindow() {
    // Create a new JFrame
    JFrame frame = new JFrame("Parental Controls Login");
    // Set the size of the frame
    frame.setSize(500, 400); // Width: 600px, Height: 600px
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);

    JLabel pageTitle = new JLabel("Parental Controls Login");
    pageTitle.setBounds(140, 25, 225, 30); // x, y, width, height
    pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
    pageTitle.setOpaque(false);
    pageTitle.setBorder(null);
    frame.add(pageTitle);

    JLabel pinEntry = new JLabel("Enter PIN :");
    pinEntry.setBounds(170, 90, 75, 30); // x, y, width, height
    frame.add(pinEntry);

    JPasswordField pin = new JPasswordField();
    pin.setBounds(235, 90, 75, 30); // x, y, width, height
    frame.add(pin);
    

    JButton loginButton = new JButton("Login");
    loginButton.setBounds(208, 135, 67, 30); // x, y, width, height
    frame.add(loginButton);

    JButton mainMenu = new JButton("Main Menu");
    mainMenu.setBounds(165, 290, 150, 30); // x, y, width, height
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