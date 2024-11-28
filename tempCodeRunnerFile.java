import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class pet extends JFrame {
    private String petType;
    private BufferedImage petImage;
    private BufferedImage backgroundImage;

    private int health = 100;
    private int happiness = 100;
    private int fullness = 100;
    private int sleep = 100;

    private Timer timer;  // Timer to decrease stats over time

    // Declare buttons
    private JButton feedButton;
    private JButton sleepButton;
    private JButton playButton;
    private JButton vetButton;

    public pet(String petType) {
        this.petType = petType;

        // Set up window properties
        setTitle("Your Pet in Petopia");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);  // Use null layout for absolute positioning

        // Load images
        loadImages();

        // Create and add the feed button
        feedButton = new JButton("Feed Pet");
        feedButton.setBounds(650, 20, 120, 40);  // Set position and size
        feedButton.addActionListener(e -> feedPet());  // Add action listener for feeding pet
        add(feedButton);

        // Create and add the sleep button
        sleepButton = new JButton("Put pet to sleep");
        sleepButton.setBounds(20, 20, 150, 40);  // Position along the top (x: 20px)
        sleepButton.addActionListener(e -> putToSleep());  // Add action listener for sleep
        add(sleepButton);

        // Create and add the play button
        playButton = new JButton("Play with Pet");
        playButton.setBounds(180, 20, 150, 40);  // Position along the top (x: 180px)
        playButton.addActionListener(e -> playWithPet());  // Add action listener for play
        add(playButton);

        // Create and add the vet button
        vetButton = new JButton("Bring pet to vet");
        vetButton.setBounds(340, 20, 150, 40);  // Position along the top (x: 340px)
        vetButton.addActionListener(e -> bringToVet());  // Add action listener for vet
        add(vetButton);

        // Create a timer that decreases the stats over time
        timer = new Timer(5000, e -> updateStats());  // Decrease stats every 5 seconds
        timer.start();
    }

    private void loadImages() {
        try {
            backgroundImage = ImageIO.read(new File("images/background.png"));
           
            petImage = ImageIO.read(new File("sprites/" + petType + "_normal.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading image.");
        }
    }

    // Method to update stats over time
    private void updateStats() {
        // Decrease stats if they are above 0
        if (health > 0) health -= 2;
        if (happiness > 0) happiness -= 1;
        if (fullness > 0) fullness -= 3;
        if (sleep > 0) sleep -= 2;

        // Trigger a repaint to update the pet stats
        repaint();
    }

    // Method to feed the pet
    private void feedPet() {
        // Increase fullness when pet is fed (but don't exceed 100)
        fullness = Math.min(fullness + 20, 100);
        try {
            backgroundImage = ImageIO.read(new File("images/background.png"));
           
            petImage = ImageIO.read(new File("sprites/" + petType + "_eating.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading image.");
        }
        // Trigger a repaint to update the UI after feeding
        repaint();
    }

    // Method to put pet to sleep (increase health by 10)
    private void putToSleep() {
        health = Math.min(health + 10, 100);  // Increase health but don't exceed 100
        try {
            backgroundImage = ImageIO.read(new File("images/background.png"));
           
            petImage = ImageIO.read(new File("sprites/" + petType + "_sleeping.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading image.");
        }
        repaint();
    }

    // Method to play with pet (increase happiness by 10)
    private void playWithPet() {
        happiness = Math.min(happiness + 10, 100);  // Increase happiness but don't exceed 100
        try {
            backgroundImage = ImageIO.read(new File("images/background.png"));
           
            petImage = ImageIO.read(new File("sprites/" + petType + "_sleeping.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading image.");
        }
        repaint();
    }

    // Method to bring pet to vet (increase health by 20)
    private void bringToVet() {
        health = Math.min(health + 20, 100);  // Increase health but don't exceed 100
        try {
            backgroundImage = ImageIO.read(new File("images/background.png"));
           
            petImage = ImageIO.read(new File("sprites/" + petType + "_sad.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading image.");
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Ensure we don't clear the whole screen on repaint
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        }
        if (petImage != null) {
            int x = (getWidth() - petImage.getWidth()) / 2;
            int y = (getHeight() - petImage.getHeight()) / 2;
            g.drawImage(petImage, x, y, null);
        }

        // Display the pet's stats along the bottom of the screen
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));

        int yPos = getHeight() - 40;  // Start position for stats text (a bit above the bottom)

        // Display each stat one after the other
        g.drawString("Health: " + health, 20, yPos);
        g.drawString("Happiness: " + happiness, 220, yPos);
        g.drawString("Fullness: " + fullness, 420, yPos);
        g.drawString("Sleep: " + sleep, 620, yPos);
    }

    public static void main(String[] args) {
        // Display the pet screen for a "cat" as an example
        pet pet = new pet("cat");
        pet.setVisible(true);
    }
}
