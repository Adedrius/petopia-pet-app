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

        mainMenu = new JButton("Back to Main Menu");

        setVisible(true);

    }   

    public static void main(String[] args) {
        new Tutorial();
    }
}
