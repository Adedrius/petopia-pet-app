import java.awt.*;
import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

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
    saveSlot1.addActionListener(e -> {
      try {
        revivePet("1");
      } catch (Exception e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }); 

    JButton saveSlot2 = new JButton("<html><div align='center'>REVIVE<br>Save Slot 2 Pet</div></html>");
    saveSlot2.setBounds(305, 160, 120, 50); // x, y, width, height
    saveSlot2.setMargin(new Insets(10, 20, 10, 20)); // top, left, bottom, right
    saveSlot2.setHorizontalAlignment(SwingConstants.CENTER);
    frame.add(saveSlot2);
    saveSlot2.addActionListener(e -> {
      try {
        revivePet("2");
      } catch (Exception e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }); 

    JButton saveSlot3 = new JButton("<html><div align='center'>REVIVE<br>Save Slot 3 Pet</div></html>");
    saveSlot3.setBounds(305, 215, 120, 50); // x, y, width, height
    saveSlot3.setMargin(new Insets(10, 20, 10, 20)); // top, left, bottom, right
    saveSlot3.setHorizontalAlignment(SwingConstants.CENTER);
    frame.add(saveSlot3);
    saveSlot3.addActionListener(e -> {
      try {
        revivePet("3");
      } catch (Exception e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }); 

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
  
  //revive pet
  public static void revivePet(String saveSlot ) throws Exception {
    String path = "saveSlot" +saveSlot + ".csv";
    try{
      BufferedReader br = new BufferedReader(new FileReader(path));
      BufferedWriter writer =new BufferedWriter(new FileWriter("saveSlot" + saveSlot + ".csv"));
      String petReset = getPetStats.getPetType() + ','
      + getPetStats.getPetName() + ","
      + "100," // health
      + "100," // happiness
      + "100," // fullness
      + "100," // sleep
      + "5," // Balls
      + "5," // fish
      + "5," // bears
      + "5," // milk
      + "5," // blocks
      + "5," // treats
      + "5," // spinners
      + "5," // chicken
      + getPetStats.getScore(); // score
      writer.write(petReset);
      writer.close();
      JFrame frame = new JFrame("Revived Pet");
      JOptionPane.showMessageDialog(frame, "Save Slot " + saveSlot + " has had the pet revived", "Revived", JOptionPane.INFORMATION_MESSAGE);

    }
    catch(FileNotFoundException e){
        JFrame frame = new JFrame("GAME DOES NOT EXIST");
                JOptionPane.showMessageDialog(frame, "Save File not found. Please try again or start a new game.", "Error Finding Game", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
    }
    catch(IOException e){
        JFrame frame = new JFrame("GAME DOES NOT EXIST");
        JOptionPane.showMessageDialog(frame, "Save File not found. Please try again or start a new game.", "Error Finding Game", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
        }
  }
  public static void main(String[] args) {
    showWindow();
  }
}
