import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class pet extends JFrame {
    private static String petType;
        private static String petName;
        private BufferedImage petImage;
        private BufferedImage backgroundImage;
    
        private int health = 100;
        private int happiness = 100;
        private int fullness = 100;
        private int sleep = 100;
    
        private Timer timer;  // Timer to decrease stats over time

        //pet mood states
        private boolean isAlive;
        private boolean isAwake;
        private boolean isFull;
        private boolean isHappy;
    
        // Declare buttons
        private JButton feedButton;
        private JButton sleepButton;
        private JButton playButton;
        private JButton vetButton;
        private JButton gameOverButton;
    
        public pet(String petType, String petName) {
            pet.petType = petType;
            pet.petName = petName;
            isAlive = true;
            isAwake =true;
            isFull = true;
            isHappy = true;
    
            // Set up window properties
            setTitle("Your Pet in Petopia");
            setSize(800, 600);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);  // Use null layout for absolute positioning
    
            // Load images
            loadImages();
            // Create and add the feed button
            if (isAlive && isAwake ){ //can only fully interact with pet when alive and awake
        if (isHappy){ //can only feet, sleep and take pet to vet when pet is happy
                feedButton = new JButton("Feed Pet");
        feedButton.setBounds(650, 20, 120, 40);  // Set position and size
        feedButton.addActionListener(e -> feedPet());  // Add action listener for feeding pet
        add(feedButton);

        // Create and add the sleep button
        sleepButton = new JButton("Put pet to sleep");
        sleepButton.setBounds(20, 20, 150, 40);  // Position along the top (x: 20px)
        sleepButton.addActionListener(e -> putToSleep());  // Add action listener for sleep
        add(sleepButton);
        // Create and add the vet button
        vetButton = new JButton("Bring pet to vet");
        vetButton.setBounds(340, 20, 150, 40);  // Position along the top (x: 340px)
        vetButton.addActionListener(e -> bringToVet());  // Add action listener for vet
        add(vetButton);
        }
        else{ //only playing allowed when pet is unhappy
            // Create and add the play button
           playButton = new JButton("Play with Pet");
           playButton.setBounds(180, 20, 150, 40);  // Position along the top (x: 180px)
           playButton.addActionListener(e -> playWithPet());  // Add action listener for play
           add(playButton);
        }
        }
    
            
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
            // Decrease stats over time
            if (health > 0) {
                isAlive = true;
            }
            if (happiness > 0) {
                isHappy = true;
                happiness -= 1;
              
            }
            if (!isFull){ //when pet is starving healthy and happiness penalty applied 
                health -= 5;
                happiness -= 3;
            }
            if (fullness > 0) {
                isFull = true;
                fullness -= 1;
            }
            if (sleep > 0 && isAwake == true) {
                isAwake = true;
                sleep -= 1;
            }
            
            //set states when 0
            if (health <= 0){
                health = 0;
                isAlive = false;
            }
            if (happiness <= 0){
                happiness = 0;
                isHappy = false;
            }
            if (fullness <= 0 ){
                fullness = 0;
                isFull = false;
            }
            if (sleep <= 0 || !isAwake){
                isAwake = false;
                putToSleep();
            }

    
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
            if (sleep <= 0){ //health penalty & happiness penalty applied for exhausted pet
                health -= 25;
                happiness -= 25;
            }
            try {
                backgroundImage = ImageIO.read(new File("images/background.png"));
               
                petImage = ImageIO.read(new File("sprites/" + petType + "_sleeping.png"));
                sleep = Math.min(sleep + 25, 100);; // slowly adds sleep until it is fully restored
                if (sleep == 100){ // wakes up pet when it is full rested
                    isAwake = true;
                }
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
                petImage = ImageIO.read(new File("sprites/" + petType + "_playing.png"));
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
        // Call the parent class's paint method to ensure proper behavior
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
    
        // // Draw the pet's stats AFTER images to ensure they appear on top
         g.setColor(Color.WHITE);
         g.setFont(new Font("Arial", Font.PLAIN, 20));
         int yPos = getHeight() - 40;  // Start position for stats text (a bit above the bottom)
        // // Display each stat one after the other

        //ends game when pet is dead
        if (!isAlive){
            g.setColor(Color.RED);
            g.setFont(new Font("Arial", Font.PLAIN, 40));
            g.drawString("PET IS DEAD. GAME OVER", 130, 200);
            gameOverButton = new JButton("Main Menu");
            gameOverButton.setBounds(320, 100, 150, 40);  // Position along the top (x: 180px)
            gameOverButton.addActionListener( e -> {
                this.dispose();
                    mainMenu mainMenu = new mainMenu();
        });
        add(gameOverButton);

    }
        else{

         g.drawString("Health: " + health, 20, yPos);
         g.drawString("Happiness: " + happiness, 220, yPos);
         g.drawString("Fullness: " + fullness, 420, yPos);
         g.drawString("Sleep: " + sleep, 620, yPos);
    }
       
    }
    
    
        public static void main(String[] args) {
            // Display the pet screen for a "cat" as an example
            pet pet = new pet(petType, petName);
        pet.setVisible(true);
    }
}
