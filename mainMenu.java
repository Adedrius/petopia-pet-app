import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class mainMenu extends JFrame {

    // Constructor to set up the main menu window
    public mainMenu() {
        // Set the window title
        setTitle("Petopia - Virtual Pet Game");

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the window size
        setSize(800, 600);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Set the layout for the window
        setLayout(new BorderLayout());

        // Create the title label
        JLabel titleLabel = new JLabel("Welcome to Petopia!", JLabel.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 30));
        add(titleLabel, BorderLayout.NORTH);

        // Create a panel for the buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(5, 1, 10, 10));

        // Create buttons for each menu option
        JButton startGameButton = new JButton("Start New Game");
        JButton loadGameButton = new JButton("Load Game");
        JButton tutorialButton = new JButton("Tutorial / Instructions");
        JButton parentalControlsButton = new JButton("Parental Controls");
        JButton exitButton = new JButton("Exit");

        // Add buttons to the panel
        buttonPanel.add(startGameButton);
        buttonPanel.add(loadGameButton);
        buttonPanel.add(tutorialButton);
        buttonPanel.add(parentalControlsButton);
        buttonPanel.add(exitButton);

        // Add the button panel to the center of the window
        add(buttonPanel, BorderLayout.CENTER);

        // Create a panel for developer information
        JPanel infoPanel = new JPanel(new GridLayout(3, 1));
        JLabel teamLabel = new JLabel("Developers: Team 34", JLabel.CENTER);
        JLabel namesLabel = new JLabel("Thevindu, Isabella, Keith, Hassan, Ade", JLabel.CENTER);
        JLabel termLabel = new JLabel("Fall 2024 - CS2212 at Western University", JLabel.CENTER);

        // Add info to the panel
        infoPanel.add(teamLabel);
        infoPanel.add(namesLabel);
        infoPanel.add(termLabel);

        // Add info panel to the bottom of the window
        add(infoPanel, BorderLayout.SOUTH);

        // Event listeners for buttons
        startGameButton.addActionListener(e -> {
            startGame StartGame = new startGame();
            StartGame.showWindow();
        });

        loadGameButton.addActionListener(e -> {
            loadGame loadGame = new loadGame();
            loadGame.showWindow();
        });

        tutorialButton.addActionListener( e -> {
            Tutorial tutorial = new Tutorial();
            tutorial.showWindow();
        });

        parentalControlsButton.addActionListener(e -> {
            parentalControlsLogin parentalControls = new parentalControlsLogin();
            parentalControls.showWindow();
        });

        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application
                System.exit(0);
            }
        });
    }

    // Splash Screen Implementation
    public static void showSplashScreen(Runnable onComplete) {
        JFrame splashScreen = new JFrame();
        splashScreen.setUndecorated(true);
        splashScreen.setSize(800, 600);
        splashScreen.setLocationRelativeTo(null);

        // Add image to the splash screen
        JLabel splashImage = new JLabel(new ImageIcon("images/title.png"));
        splashImage.setHorizontalAlignment(JLabel.CENTER);
        splashScreen.add(splashImage);

        // Set opacity control
        splashScreen.setOpacity(1.0f);
        splashScreen.setVisible(true);

        Timer timer = new Timer(50, new ActionListener() {
            float opacity = 1.0f;

            @Override
            public void actionPerformed(ActionEvent e) {
                opacity -= 0.02f;
                if (opacity <= 0.0f) {
                    splashScreen.dispose();
                    ((Timer) e.getSource()).stop();
                    onComplete.run(); // Launch the main menu
                } else {
                    splashScreen.setOpacity(opacity);
                }
            }
        });

        timer.start();
    }

    // Main method to launch the main menu
    public static void main(String[] args) {
        // Create the main menu and make it visible
        showSplashScreen(() -> {
            mainMenu mainMenu = new mainMenu();
            mainMenu.setVisible(true);
        });
    }
}
