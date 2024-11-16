package petopia_2212;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame {
    
    // Constructor to set up the main menu window
    public MainMenu() {
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
        buttonPanel.setLayout(new GridLayout(6, 1, 10, 10));
        
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
        JPanel infoPanel = new JPanel(new GridLayout(4, 1));
        JLabel teamLabel = new JLabel("Developers: Team 34", JLabel.CENTER);
        JLabel namesLabel = new JLabel("Thevindu, Isabella, Keith, Hassan, Ade", JLabel.CENTER);
        JLabel termLabel = new JLabel("Fall 2024 - CS2212 at Western University", JLabel.CENTER);
        
        // Add info to the panel
        infoPanel.add(teamLabel);
        infoPanel.add(namesLabel);
        infoPanel.add(termLabel);
        
        // Add info panel to the bottom of the window
        add(infoPanel, BorderLayout.SOUTH);
        
        // Optional: Add an image or graphic at the top
        ImageIcon gameLogo = new ImageIcon("path_to_logo.png"); // You can replace with the actual image path
        JLabel imageLabel = new JLabel(gameLogo);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.NORTH);
        
        // Event listeners for buttons
        startGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to start a new game
                startNewGame();
            }
        });
        
        loadGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to load a saved game
                loadGame();
            }
        });
        
        tutorialButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to display tutorial or instructions
                showTutorial();
            }
        });
        
        parentalControlsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Call the method to open parental controls
                openParentalControls();
            }
        });
        
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Exit the application
                System.exit(0);
            }
        });
    }
    
    // Method to start a new game
    private void startNewGame() {
        // Implement logic to start a new game
        System.out.println("Starting a new game...");
    }
    
    // Method to load a saved game
    private void loadGame() {
        // Implement logic to load a previously saved game
        System.out.println("Loading a saved game...");
    }
    
    // Method to show the tutorial or instructions
    private void showTutorial() {
        // Implement logic to show tutorial or instructions
        JOptionPane.showMessageDialog(this, "This is where the tutorial or instructions will be displayed.");
    }
    
    // Method to open parental controls
    private void openParentalControls() {
        // Implement logic to open parental controls
        System.out.println("Opening parental controls...");
    }

    // Main method to launch the main menu
    public static void main(String[] args) {
        // Create the main menu and make it visible
        MainMenu mainMenu = new MainMenu();
        mainMenu.setVisible(true);
    }
}
