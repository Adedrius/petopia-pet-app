import java.awt.BorderLayout;

import javax.swing.*;

public class Tutorial extends JFrame {
    private JTextArea Title;
    private JButton mainMenu;
    
    public Tutorial() {
        setTitle("Instructions Menu");
        setSize(500,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        String tutorialTitle = "Game Instructions Video";

        Title = new JTextArea(tutorialTitle);
        Title.setLineWrap(true);
        Title.setWrapStyleWord(true);
        Title.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(Title);

        mainMenu = new JButton("Back to Main Menu");
        
        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(mainMenu, BorderLayout.SOUTH);

        setVisible(true);

    }   

    public static void main(String[] args) {
        new Tutorial();
    }
}
