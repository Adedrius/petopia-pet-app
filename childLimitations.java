import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class childLimitations {
  public static void showWindow() {
    // Create a new JFrame
    JFrame frame = new JFrame("Parental Controls Menu");
    // Set the size of the frame
    frame.setSize(500, 400); // Width: 500px, Height: 400px
    frame.setLocationRelativeTo(null); // Center the frame on the screen
    frame.setLayout(null);

    JLabel pageTitle = new JLabel("Parental Change Options");
    pageTitle.setBounds(130, 25, 225, 30); // x, y, width, height
    pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
    pageTitle.setOpaque(false);
    pageTitle.setBorder(null);
    frame.add(pageTitle);

    JLabel text1 = new JLabel("Child Play Time Preferences");
    text1.setBounds(25, 75, 275, 30); // x, y, width, height
    text1.setFont(new Font("Arial", Font.PLAIN, 16));
    text1.setOpaque(false);
    text1.setBorder(null);
    frame.add(text1);

    JLabel text2 = new JLabel("Revive Pet");
    text2.setBounds(330, 75, 275, 30); // x, y, width, height
    text2.setFont(new Font("Arial", Font.PLAIN, 16));
    text2.setOpaque(false);
    text2.setBorder(null);
    frame.add(text2);
    
    JButton saveSlot1 = new JButton("<html><div align='center'>REVIVE<br>Save Slot 1 Pet</div></html>");
    saveSlot1.setBounds(305, 105, 120, 50); // x, y, width, height
    saveSlot1.setMargin(new Insets(10, 20, 10, 20)); // top, left, bottom, right
    saveSlot1.setHorizontalAlignment(SwingConstants.CENTER);
    frame.add(saveSlot1);

    JButton saveSlot2 = new JButton("<html><div align='center'>REVIVE<br>Save Slot 2 Pet</div></html>");
    saveSlot2.setBounds(305, 160, 120, 50); // x, y, width, height
    saveSlot2.setMargin(new Insets(10, 20, 10, 20)); // top, left, bottom, right
    saveSlot2.setHorizontalAlignment(SwingConstants.CENTER);
    frame.add(saveSlot2);

    JButton saveSlot3 = new JButton("<html><div align='center'>REVIVE<br>Save Slot 3 Pet</div></html>");
    saveSlot3.setBounds(305, 215, 120, 50); // x, y, width, height
    saveSlot3.setMargin(new Insets(10, 20, 10, 20)); // top, left, bottom, right
    saveSlot3.setHorizontalAlignment(SwingConstants.CENTER);
    frame.add(saveSlot3);

    JButton parentalChanges = new JButton("<html><div align='center'>Back to<br>Parental Controls</div></html>");
    parentalChanges.setBounds(155, 300, 180, 45); // x, y, width, height
    parentalChanges.setMargin(new Insets(10, 20, 10, 20)); // top, left, bottom, right
    parentalChanges.setHorizontalAlignment(SwingConstants.CENTER);
    frame.add(parentalChanges);

    // Action listener for Back to Parental Controls button
    parentalChanges.addActionListener(e -> {
      // Dispose of the current window (childLimitations)
      frame.dispose();
      // Show the parentalControlsMenu window
      parentalControlsMenu.showWindow();
    });

    // Override the default close operation (close only the window, not the entire application)
    frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

    // Add WindowListener to handle the close event
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        // Dispose of the current window and go back to the parentalControlsMenu
        frame.dispose();
        parentalControlsMenu.showWindow();
      }
    });

    // Set the frame's visibility
    frame.setVisible(true);
  }

  public static void main(String[] args) {
    showWindow();
  }
}
