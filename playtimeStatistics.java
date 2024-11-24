
import java.awt.*;
import javax.swing.*;

public class playtimeStatistics {
  public static void showWindow() {
    // Create a new JFrame
    JFrame frame = new JFrame("Parental Controls Menu");
    // Set the size of the frame
    frame.setSize(500, 400); // Width: 600px, Height: 600px
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setLayout(null);

    JLabel pageTitle = new JLabel("Playtime Statistics");
    pageTitle.setBounds(163, 25, 225, 30); // x, y, width, height
    pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
    pageTitle.setOpaque(false);
    pageTitle.setBorder(null);
    frame.add(pageTitle);

    JLabel text1 = new JLabel("Total Playtime:");
    text1.setBounds(75, 90, 225, 30); // x, y, width, height
    text1.setFont(new Font("Arial", Font.PLAIN, 15));
    text1.setOpaque(false);
    text1.setBorder(null);
    frame.add(text1);

    JLabel text2 = new JLabel("<html><div align='center'>Average Playtime <br>Per Session:</div></html>");
    text2.setBounds(70, 175, 225, 30); // x, y, width, height
    text2.setFont(new Font("Arial", Font.PLAIN, 15));
    text2.setOpaque(false);
    text2.setBorder(null);
    frame.add(text2);
    

    JButton parentalChanges = new JButton("<html><div align='center'>Back to<br>Parental Controls</div></html>");
    parentalChanges.setBounds(155, 275, 180, 60); // x, y, width, height
    parentalChanges.setMargin(new Insets(10, 20, 10, 20)); // top, left, bottom, right
    parentalChanges.setHorizontalAlignment(SwingConstants.CENTER);
    frame.add(parentalChanges);

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