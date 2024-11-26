import java.awt.Font;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tutorial extends JFrame {
    public static void showWindow() {
        JFrame frame = new JFrame("Instructions Menu");
        frame.setTitle("Instructions Menu");
        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Change to DISPOSE_ON_CLOSE
        frame.setLocationRelativeTo(null);
        frame.setLayout(null); 

        // Title label
        JLabel Title = new JLabel("Game Instructions Video");
        Title.setBounds(130, 25, 225, 30); // x, y, width, height
        Title.setFont(new Font("Arial", Font.PLAIN, 20));
        Title.setOpaque(false);
        Title.setBorder(null);
        frame.add(Title); 

        // Main Menu button
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.setBounds(165, 290, 150, 30); // x, y, width, height
        frame.add(mainMenu); 

        // Action listener to close the tutorial window and return to main menu
        mainMenu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose(); // Closes the tutorial window
                // Optionally, you can open the main menu window here if needed:
                // mainMenu.showWindow();
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        showWindow();
    }
}
