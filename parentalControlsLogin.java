import java.awt.Font;
import javax.swing.*;

public class parentalControlsLogin {
  public static void showWindow() {
    String passwordString = "123";
    // Create a new JFrame
    JFrame frame = new JFrame("Parental Controls Login");
    // Set the size of the frame
    frame.setSize(500, 400); // Width: 600px, Height: 600px
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change to DISPOSE_ON_CLOSE
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

    // Action listener to close the parental controls login window and return to the main menu
    mainMenu.addActionListener(e -> frame.dispose()); // Close the frame when "Main Menu" is clicked

    // Action listener to validate PIN and open the Parental Controls Menu window
    loginButton.addActionListener(e -> {
      char[] enteredPin = pin.getPassword(); // Get the entered PIN
      String pinString = new String(enteredPin); // Convert to String

      // Check if the entered PIN is correct
      if (pinString.equals(passwordString)) {
        // Open the parental controls menu window
        frame.dispose(); // Close the current login window
        parentalControlsMenu.showWindow(); // Open the parental controls menu window
      } else {
        JOptionPane.showMessageDialog(frame, "Incorrect PIN, please try again.", "Error", JOptionPane.ERROR_MESSAGE);
      }
    });

    // Set the frame's visibility
    frame.setVisible(true);

    // Optionally, center the frame on the screen
    frame.setLocationRelativeTo(null);
  }

  public static void main(String[] args) {
    showWindow();
  }
}
