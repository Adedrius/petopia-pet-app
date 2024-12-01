import javax.swing.*;
import java.awt.*;

public class playerInventory { 
    public static int balls = 0;
    public static int fish = 0;
    public static int bears = 0;
    public static int milk = 0;
    public static int blocks = 0;
    public static int treats = 0;
    public static int spinners = 0;
    public static int chicken = 0;

    public static void showWindow() {

        JFrame frame = new JFrame("Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        // Create a layered pane to manage layers
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        // Background image
        ImageIcon originalBackgroundImage = new ImageIcon("images/background.png");
        JLabel backgroundLabel = new JLabel();
        Image backgroundImage = originalBackgroundImage.getImage().getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        // Add background to the lowest layer
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        // Page title with rounded background
        JLabel pageTitle = makeRoundedLabel("Inventory", Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 30));
        pageTitle.setBounds(275, 45, 225, 50); // Increase height for padding
        pageTitle.setHorizontalAlignment(SwingConstants.CENTER);  // Center-align text
        layeredPane.add(pageTitle, Integer.valueOf(1));

        // Add inventory item: Fish
        ImageIcon fishImage = new ImageIcon("inventory/food1.png");
        JLabel fishLabel = new JLabel(fishImage);
        fishLabel.setBounds(50, 100, fishImage.getIconWidth(), fishImage.getIconHeight());
        JLabel fishRemLabel = makeRoundedLabel(" Fish Remaining: " + getFish(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        fishRemLabel.setBounds(180, 140, 195, 50); // Ensure enough space for larger font
        layeredPane.add(fishLabel, Integer.valueOf(1));
        layeredPane.add(fishRemLabel, Integer.valueOf(1));

        // Add inventory item: Ball
        ImageIcon ballImage = new ImageIcon("inventory/ball.png");
        JLabel ballLabel = new JLabel(ballImage);
        ballLabel.setBounds(400, 100, ballImage.getIconWidth(), ballImage.getIconHeight());
        JLabel ballRemLabel = makeRoundedLabel(" Balls Remaining: " + getBalls(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        ballRemLabel.setBounds(530, 140, 200, 50);
        layeredPane.add(ballLabel, Integer.valueOf(1));
        layeredPane.add(ballRemLabel, Integer.valueOf(1));

        // Add inventory item: Milk
        ImageIcon MilkImage = new ImageIcon("inventory/food4.png");
        JLabel MilkLabel = new JLabel(MilkImage);
        MilkLabel.setBounds(45, 200, MilkImage.getIconWidth(), MilkImage.getIconHeight());
        JLabel milkRemLabel = makeRoundedLabel(" Milk Remaining: " + getMilk(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        milkRemLabel.setBounds(180, 240, 195, 50);
        layeredPane.add(MilkLabel, Integer.valueOf(1));
        layeredPane.add(milkRemLabel, Integer.valueOf(1));

        // Add inventory item: Bear
        ImageIcon bearImage = new ImageIcon("inventory/bear.png");
        JLabel bearLabel = new JLabel(bearImage);
        bearLabel.setBounds(400, 200, bearImage.getIconWidth(), bearImage.getIconHeight());
        JLabel bearRemLabel = makeRoundedLabel(" Bears Remaining: " + bears, Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        bearRemLabel.setBounds(530, 240, 200, 50);
        layeredPane.add(bearLabel, Integer.valueOf(1));
        layeredPane.add(bearRemLabel, Integer.valueOf(1));

        // Add inventory item: Treats
        ImageIcon treatsImage = new ImageIcon("inventory/food6.png");
        JLabel treatsLabel = new JLabel(treatsImage);
        treatsLabel.setBounds(45, 310, treatsImage.getIconWidth(), treatsImage.getIconHeight());
        JLabel treatsRemLabel = makeRoundedLabel(" Treats Remaining: " + getTreats(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        treatsRemLabel.setBounds(180, 340, 210, 50);
        layeredPane.add(treatsLabel, Integer.valueOf(1));
        layeredPane.add(treatsRemLabel, Integer.valueOf(1));

        // Add inventory item: Blocks
        ImageIcon blockImage = new ImageIcon("inventory/blocks.png");
        JLabel blockLabel = new JLabel(blockImage);
        blockLabel.setBounds(400, 310, blockImage.getIconWidth(), blockImage.getIconHeight());
        JLabel blockRemLabel = makeRoundedLabel(" Blocks Remaining: " + getBlocks(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        blockRemLabel.setBounds(530, 340, 210, 50);
        layeredPane.add(blockLabel, Integer.valueOf(1));
        layeredPane.add(blockRemLabel, Integer.valueOf(1));

        // Add inventory item: Chicken
        ImageIcon chickenImage = new ImageIcon("inventory/food3.png");
        JLabel chickenLabel = new JLabel(chickenImage);
        chickenLabel.setBounds(45, 410, chickenImage.getIconWidth(), chickenImage.getIconHeight());
        JLabel chickenRemLabel = makeRoundedLabel(" Chicken Remaining: " + getChicken(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        chickenRemLabel.setBounds(180, 440, 225, 50);
        layeredPane.add(chickenLabel, Integer.valueOf(1));
        layeredPane.add(chickenRemLabel, Integer.valueOf(1));

        // Add inventory item: Spinner
        ImageIcon spinnerImage = new ImageIcon("inventory/spinner.png");
        JLabel spinnerLabel = new JLabel(spinnerImage);
        spinnerLabel.setBounds(400, 410, spinnerImage.getIconWidth(), spinnerImage.getIconHeight());
        JLabel spinnerRemLabel = makeRoundedLabel(" Spinners Remaining: " + getSpinners(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        spinnerRemLabel.setBounds(530, 440, 230, 50);
        layeredPane.add(spinnerLabel, Integer.valueOf(1));
        layeredPane.add(spinnerRemLabel, Integer.valueOf(1));


        // Add the layered pane to the frame
        frame.add(layeredPane);
        frame.setVisible(true);
    }

    /**
     * Creates a JLabel with a rounded background.
     *
     * @param text      The text to display on the label.
     * @param bgColor   The background color of the label.
     * @param textColor The text color of the label.
     * @param font      The font of the label.
     * @return A JLabel with a rounded background.
     */
    public static JLabel makeRoundedLabel(String text, Color bgColor, Color textColor, Font font) {
        JLabel label = new JLabel(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // Draw the rounded background
                g2.setColor(bgColor);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                // Draw the text
                super.paintComponent(g);
            }
        };

        label.setFont(font);  // Set font for the label
        label.setForeground(textColor);  // Set text color
        label.setOpaque(false);  // Transparent background
        return label;
    }

    public static int getBalls() {
        return balls;
    }

    public static void setBalls(int balls) {
        playerInventory.balls = balls;
    }

    public static int getFish() {
        return fish;
    }

    public static void setFish(int fish) {
        playerInventory.fish = fish;
    }

    public static int getBears() {
        return bears;
    }

    public static void setBears(int bears) {
        playerInventory.bears = bears;
    }

    public static int getMilk() {
        return milk;
    }

    public static void setMilk(int milk) {
        playerInventory.milk = milk;
    }

    public static int getBlocks() {
        return blocks;
    }

    public static void setBlocks(int blocks) {
        playerInventory.blocks = blocks;
    }

    public static int getTreats() {
        return treats;
    }

    public static void setTreats(int treats) {
        playerInventory.treats = treats;
    }

    public static int getSpinners() {
        return spinners;
    }

    public static void setSpinners(int spinners) {
        playerInventory.spinners = spinners;
    }

    public static int getChicken() {
        return chicken;
    }

    public static void setChicken(int chicken) {
        playerInventory.chicken = chicken;
    }

    public static void main(String[] args) {
        setFish(5); // Example of setting a value from another class
        showWindow();
    }
}
