import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class pet extends JFrame {
    private String petType;
    private BufferedImage petImage;
    private BufferedImage backgroundImage;

    public pet(String petType) {
        this.petType = petType;

        // Set up window properties
        setTitle("Your Pet in Petopia");
        setSize(800, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Load the background image
        try {
            backgroundImage = ImageIO.read(new File("images/background.png"));
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading background image.");
        }

        // Load the appropriate pet image
        try {
            switch (petType) {
                case "cat":
                    petImage = ImageIO.read(new File("sprites/cat_normal.png"));
                    break;
                case "dog":
                    petImage = ImageIO.read(new File("sprites/dog_normal.png"));
                    break;
                case "sheep":
                    petImage = ImageIO.read(new File("sprites/sheep_normal.png"));
                    break;
                default:
                    throw new IllegalArgumentException("Unknown pet type");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error loading pet image.");
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        // Draw the background image (fill the entire window)
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), null);
        }

        // Draw the pet image (centered on the screen)
        if (petImage != null) {
            int x = (getWidth() - petImage.getWidth()) / 2;
            int y = (getHeight() - petImage.getHeight()) / 2;
            g.drawImage(petImage, x, y, null);
        }
    }

    public static void main(String[] args) {
        // Display the pet screen for a "cat" as an example
        pet pet = new pet("cat");
        pet.setVisible(true);
    }
}



