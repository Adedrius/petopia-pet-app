import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.*;
import java.io.BufferedWriter;

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
    saveSlot1.addActionListener(e -> {
      try {
        savePlayerData("1");
      } catch (Exception e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }); // Save game to save slot 1

    JButton saveSlot2 = new JButton("Save Slot 2");
    saveSlot2.setBounds(195, 175, 100, 60); // x, y, width, height
    frame.add(saveSlot2);
    saveSlot2.addActionListener(e -> {
      try {
        savePlayerData("2");
      } catch (Exception e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }); // Save game to save slot 2

    JButton saveSlot3 = new JButton("Save Slot 3");
    saveSlot3.setBounds(195, 250, 100, 60); // x, y, width, height
    frame.add(saveSlot3);
    saveSlot3.addActionListener(e -> {
      try {
        savePlayerData("3");
      } catch (Exception e1) {
        // TODO Auto-generated catch block
        e1.printStackTrace();
      }
    }); // Save game to save slot 3


    

    JButton backToGame = new JButton("<-- Back");
    backToGame.setBounds(30, 305, 100, 30); // x, y, width, height
    frame.add(backToGame);
    backToGame.addActionListener(e -> 
    frame.dispose()); // Close the frame when "Main Menu" is clicked


    // Set default close operation (exit the application when the window is closed)
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    // Set the frame's visibility
    frame.setVisible(true);

    // Optionally, center the frame on the screen
    frame.setLocationRelativeTo(null);
  }
  public static void savePlayerData(String saveSlot ) throws Exception {
    try{
      BufferedWriter writer =new BufferedWriter(new FileWriter("saveSlot" + saveSlot + ".csv"));
      // type name health happiness full sleep
      String petStatData = getPetStats.getPetType() + "," 
      + getPetStats.getPetName() + "," 
      + getPetStats.getHealth() + "," 
      + getPetStats.getHappiness() + "," 
      + getPetStats.getFullness() + "," 
      + getPetStats.getSleep() + "," 
      + playerInventory.getBalls() + "," 
      + playerInventory.getFish() + "," 
      + playerInventory.getBears() + "," 
      + playerInventory.getMilk() + "," 
      + playerInventory.getBlocks() + "," 
      + playerInventory.getTreats() + "," 
      + playerInventory.getSpinners() + "," 
      + playerInventory.getChicken() + "," // balls, fish, bears, milk, blocks, treats, spinners, chicken
      + getPetStats.getScore();
      writer.write(petStatData);
      writer.close();
      JFrame frame = new JFrame("Save Game");
      JOptionPane.showMessageDialog(frame, "Game has been saved to Save Slot" + saveSlot, "Saved", JOptionPane.INFORMATION_MESSAGE);

    }
    catch(IOException e){
    e.printStackTrace();
    }
  }
  public static void main(String[] args) {
    showWindow();
  }
}