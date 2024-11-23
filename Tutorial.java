import java.awt.Font;

import javax.swing.*;

public class Tutorial extends JFrame {
    public static void showWindow() {
        JFrame frame = new JFrame("Instructions Menu");
        frame.setTitle("Instructions Menu");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); 

        
        JLabel Title = new JLabel("Game Instructions Video");
        Title.setBounds(130, 25, 225, 30); // x, y, width, height
        Title.setFont(new Font("Arial", Font.PLAIN, 20));
        Title.setOpaque(false);
        Title.setBorder(null);
        frame.add(Title); 

        
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(165, 290, 150, 30); // x, y, width, height
        frame.add(mainMenu); 

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        showWindow();
    }
}
