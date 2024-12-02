import java.awt.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.annotation.processing.FilerException;
import javax.swing.*;

public class loadGame {
    public static void showWindow() {
        // Create a new JFrame
        JFrame frame = new JFrame("Load Game");
        // Set the size of the frame
        frame.setSize(500, 400); // Width: 600px, Height: 600px
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setLayout(null);

        JLabel pageTitle = new JLabel("Load Game");
        pageTitle.setBounds(193, 25, 225, 30); // x, y, width, height
        pageTitle.setFont(new Font("Arial", Font.PLAIN, 20));
        pageTitle.setOpaque(false);
        pageTitle.setBorder(null);
        frame.add(pageTitle);

        JButton saveSlot1 = new JButton("Save Slot 1");
        saveSlot1.setBounds(195, 75, 100, 60); // x, y, width, height
        frame.add(saveSlot1);
        saveSlot1.addActionListener(e -> {
            frame.dispose();
            try {
              loadPlayerData("1");
            } catch (Exception e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
          });

        JButton saveSlot2 = new JButton("Save Slot 2");
        saveSlot2.setBounds(195, 150, 100, 60); // x, y, width, height
        frame.add(saveSlot2);
        saveSlot2.addActionListener(e -> {
            frame.dispose();
            try {
              loadPlayerData("2");
            } catch (Exception e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
          });

        JButton saveSlot3 = new JButton("Save Slot 3");
        saveSlot3.setBounds(195, 225, 100, 60); // x, y, width, height
        frame.add(saveSlot3);
        saveSlot3.addActionListener(e -> {
            frame.dispose();
            try {
              loadPlayerData("3");
              frame.dispose();
            } catch (Exception e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
          });

        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(170, 305, 150, 30); // x, y, width, height
        frame.add(mainMenu);

        // Action listener to close the load game window and return to the main menu
        mainMenu.addActionListener(e -> frame.dispose()); // Close the frame when "Main Menu" is clicked

        // Override the default close operation to close the frame (not the entire application)
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // This will close the window instead of the application

        // Set the frame's visibility
        frame.setVisible(true);
    }
     public static void loadPlayerData(String saveSlot ) throws Exception { //read from savefile and load game
        String path =  "saveSlot" + saveSlot + ".csv";
        String line = "";
    try{
       BufferedReader br = new BufferedReader(new FileReader(path));
       String[] values = {""};
      // type name health happiness full sleep
      while((line = br.readLine()) != null){
        values = line.split(",");
      }
      String petType = values[0];
      String petName = values[1];
      int health = Integer.parseInt(values[2]);
      int happiness = Integer.parseInt(values[3]);
      int fullness = Integer.parseInt(values[4]);
      int sleep = Integer.parseInt(values[5]);
      int balls = Integer.parseInt(values[6]);
      int fish = Integer.parseInt(values[7]);
      int bears = Integer.parseInt(values[8]);
      int milk = Integer.parseInt(values[9]);
      int blocks = Integer.parseInt(values[10]);
      int treats = Integer.parseInt(values[11]);
      int spinners = Integer.parseInt(values[12]);
      int chicken = Integer.parseInt(values[13]);
      int score = Integer.parseInt(values[14]);


      
            pet petWindow = new pet(petType, petName, health, happiness, fullness, sleep, balls, fish, bears, milk, blocks, treats, spinners, chicken, score); // Pass name to pet window
            petWindow.setVisible(true);
      }
    catch(FileNotFoundException e){
        JFrame frame = new JFrame("Load Game");
                JOptionPane.showMessageDialog(frame, "Save File not found. Please try again or start a new game.", "Error Loading Game", JOptionPane.ERROR_MESSAGE);
    e.printStackTrace();
    }
    catch(IOException e){
        JFrame frame = new JFrame("Load Game");
        JOptionPane.showMessageDialog(frame, "Save File not found. Please try again or start a new game.", "Error Loading Game", JOptionPane.ERROR_MESSAGE);
        e.printStackTrace();
        }
  }

    public static void main(String[] args) {
        showWindow();
    }
}
