import javax.swing.*;

public class startGame {
  public static void showWindow() {
    // Create a new JFrame
    JFrame frame = new JFrame("Blank GUI Page");

    JLabel label = new JLabel("Start Game");
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
