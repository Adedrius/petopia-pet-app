import java.awt.*;
import javax.swing.*;

public class parentalControlsMenu {
  public static void showWindow() {
    // Create a new JFrame
    JFrame frame = new JFrame("Parental Controls Menu");
    // Set the size of the frame
    frame.setSize(500, 400); // Width: 500px, Height: 400px
    frame.setLocationRelativeTo(null); // Center the frame on the screen
    frame.setLayout(null);

    JLabel pageTitle = new JLabel("Parental Controls Menu");
    pageTitle.setBounds(140, 25, 225, 30); // x, y, width, height
    pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
    pageTitle.setOpaque(false);
    pageTitle.setBorder(null);
    frame.add(pageTitle);

    JButton childStats = new JButton("View Child's Statistics");
    childStats.setBounds(155, 85, 180, 60); // x, y, width, height
    frame.add(childStats);

    JButton parentalChanges = new JButton("<html><div align='center'>Parental Limitations &<br>Changes</div></html>");
    parentalChanges.setBounds(155, 165, 180, 60); // x, y, width, height
    parentalChanges.setMargin(new Insets(10, 20, 10, 20)); // top, left, bottom, right
    parentalChanges.setHorizontalAlignment(SwingConstants.CENTER);
    frame.add(parentalChanges);

    JButton mainMenu = new JButton("Main Menu");
    mainMenu.setBounds(170, 290, 150, 30); // x, y, width, height
    frame.add(mainMenu);

    // Action listener for Main Menu button to dispose of the current window
    mainMenu.addActionListener(e -> frame.dispose()); // Close the frame when "Main Menu" is clicked

    // Action listener for View Child's Statistics button to open the playtimeStatistics window
    childStats.addActionListener(e -> {
      // Dispose of the current window
      frame.dispose();
      // Show the playtime statistics window
      playtimeStatistics.showWindow();
    });

    // Action listener for Parental Limitations & Changes button to open the childLimitations window
    parentalChanges.addActionListener(e -> {
      // Dispose of the current window
      frame.dispose();
      // Show the childLimitations window
      childLimitations.showWindow();
    });

    // Override the default close operation to close the frame (not the entire application)
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Close only the window

    // Set the frame's visibility
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    showWindow();
  }
}
