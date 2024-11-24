
import java.awt.*;
import javax.swing.*;

public class parentalControlsMenu {
  public static void showWindow() {
    // Create a new JFrame
    JFrame frame = new JFrame("Parental Controls Menu");
    // Set the size of the frame
    frame.setSize(500, 400); // Width: 600px, Height: 600px
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
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