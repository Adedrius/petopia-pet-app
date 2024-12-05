import javax.swing.*;
import java.awt.*;

/**
 * This class is the playerInventory class that provides a graphical user interface
 * to manage and display the player's inventory. This includes items such as
 * balls, fish, and other resources that can be used to interact with the pet.
 * 
 * <p>This class also provides the methods to update item counts and integrate
 * with the pet's attributes like fullness and happiness.</p>
 * 
 * @author group 34
 * @version 1.0
 * @since 2024-12-04
 */
public class playerInventory {

    // this is where inventory item counts
    public static int balls = 5;
    public static int fish = 5;
    public static int bears = 4;
    public static int milk = 4;
    public static int blocks = 3;
    public static int treats = 3;
    public static int spinners = 2;
    public static int chicken = 2;

    private JButton backtoGame;

    /**
     * this displays the inventory window. The window contains all inventory items
     * and their remaining quantities, as well as buttons to use the items.
     * A "Back to Game" button is provided to return to the main game screen.
     */
    public static void showWindow() {
        JFrame frame = new JFrame("Inventory");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        // this creates a layered pane to manage layers
        JLayeredPane layeredPane = new JLayeredPane();
        layeredPane.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        // this is the background image
        ImageIcon originalBackgroundImage = new ImageIcon("images/background.png");
        JLabel backgroundLabel = new JLabel();
        Image backgroundImage = originalBackgroundImage.getImage()
                .getScaledInstance(frame.getWidth(), frame.getHeight(), Image.SCALE_SMOOTH);
        backgroundLabel.setIcon(new ImageIcon(backgroundImage));
        backgroundLabel.setBounds(0, 0, frame.getWidth(), frame.getHeight());

        // tjis adds the background to the lowest layer
        layeredPane.add(backgroundLabel, Integer.valueOf(0));

        // this is for the back to Game button
        JButton backToGame = new JButton("<-- Back to Game");
        backToGame.setBounds(600, 20, 140, 40); // this sets the x, y, width, height
        frame.add(backToGame);
        backToGame.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            frame.dispose();
        });

        // this is page title with rounded background
        JLabel pageTitle = makeRoundedLabel("Inventory", Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 30));
        pageTitle.setBounds(275, 45, 225, 50); // this increases the height for padding
        pageTitle.setHorizontalAlignment(SwingConstants.CENTER); // this center-aligns the text
        layeredPane.add(pageTitle, Integer.valueOf(1));

        // this adds the inventory item: Fish
        /**
         * this adds the fish inventory item to the window. It displays the fish image,
         * remaining quantity, and a button to use the item.
         */
        ImageIcon fishImage = new ImageIcon("inventory/food1.png");
        JLabel fishLabel = new JLabel(fishImage);
        fishLabel.setBounds(50, 100, fishImage.getIconWidth(), fishImage.getIconHeight());
        JLabel fishRemLabel = makeRoundedLabel(" Fish Remaining: " + getFish(), Color.WHITE, Color.BLACK,
                new Font("Arial", Font.BOLD, 20));
        fishRemLabel.setBounds(180, 140, 195, 50); // this ensures enough space for larger font
        layeredPane.add(fishLabel, Integer.valueOf(1));
        layeredPane.add(fishRemLabel, Integer.valueOf(1));

        // this is for the fish button
        /**
         * This creates a button for the fish inventory item. When clicked, it decreases
         * the fish count, updates the pet's fullness, and updates the GUI to reflect
         * the new count.
         */
        JButton fishButton = new JButton("");
        fishButton.setBounds(50, 100, fishImage.getIconWidth(), fishImage.getIconHeight()); // this sets x, y, width, height
        fishButton.setBorderPainted(false);
        fishButton.setFocusPainted(false);
        fishButton.setContentAreaFilled(false);
        frame.add(fishButton);
        fishButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            if (getFish() > 0) {
                setFish(getFish() - 1);
                pet.setFullnessValue((pet.getFullnessValue() + 5)); // this adds 5 to fullness
                fishRemLabel.setText(" Fish Remaining: " + getFish());
                System.out.println("Fish used! Remaining fish: " + getFish());
                System.out.println("Pet fullness: " + pet.getFullnessValue());
            } else {
                JOptionPane.showMessageDialog(frame, "No fish remaining!", "Error", JOptionPane.WARNING_MESSAGE);
            }
            frame.dispose();
        });

        // Adds inventory item: Ball
        /**
         * this adds the ball inventory item to the window. Displays the ball image,
         * remaining quantity, and a button to use the item.
         */
        ImageIcon ballImage = new ImageIcon("inventory/ball.png");
        JLabel ballLabel = new JLabel(ballImage);
        ballLabel.setBounds(400, 100, ballImage.getIconWidth(), ballImage.getIconHeight());
        JLabel ballRemLabel = makeRoundedLabel(" Balls Remaining: " + getBalls(), Color.WHITE, Color.BLACK,
                new Font("Arial", Font.BOLD, 20));
        ballRemLabel.setBounds(530, 140, 200, 50);
        layeredPane.add(ballLabel, Integer.valueOf(1));
        layeredPane.add(ballRemLabel, Integer.valueOf(1));
    }

    /**
     * this creates a JLabel with a rounded background for better visual appearance
     * 
     * @param text      The text to display on the label.
     * @param bgColor   The background color of the label.
     * @param textColor The text color of the label.
     * @param font      The font used for the label text.
     * @return A {@code JLabel} with a rounded background.
     */
    public static JLabel makeRoundedLabel(String text, Color bgColor, Color textColor, Font font) {
        JLabel label = new JLabel(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // this draws the rounded background
                g2.setColor(bgColor);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                // this draws the text
                super.paintComponent(g);
            }
        };

        label.setFont(font);
        label.setForeground(textColor);
        label.setOpaque(false);
        return label;
    }

    /**
     * this retrieves the current number of fish in the inventory
     * 
     * @return the number of fish remaining.
     */
    public static int getFish() {
        return fish;
    }

    /**
     * this sets the number of fish in the inventory.
     * 
     * @param setFish the new fish count.
     */
    public static void setFish(int setFish) {
        fish = setFish;
    }

    /**
     * this retrieves the current number of balls in the inventory
     * 
     * @return the number of balls remaining.
     */
    public static int getBalls() {
        return balls;
    }

    /**
     * this sets the number of balls in the inventory
     * 
     * @param setBalls the new ball count.
     */
    public static void setBalls(int setBalls) {
        balls = setBalls;
    }

    public static void main(String[] args) {
        showWindow();
    }
}

        // this is for the ball button
        /**
         * this adds the ball inventory item to the window. Displays the ball image,
         * remaining quantity, and a button to use the item.
         */
        JButton ballButton = new JButton("");
        ballButton.setBounds(400, 100, ballImage.getIconWidth(), ballImage.getIconHeight()); // this sets x, y, width, height
        ballButton.setBorderPainted(false);
        ballButton.setFocusPainted(false);
        ballButton.setContentAreaFilled(false);
        frame.add(ballButton);
        ballButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            if (getBalls() > 0) {
                setBalls(getBalls() - 1);
                pet.setHappinessValue((pet.getHappinessValue() + 5)); // this adds 5 to happiness
                ballRemLabel.setText(" Balls Remaining: " + getBalls());
                System.out.println("Ball used! Remaining balls: " + getBalls());
                System.out.println("Pet happiness: " + pet.getHappinessValue());
            } else {
                JOptionPane.showMessageDialog(frame, "No balls remaining!", "Error", JOptionPane.WARNING_MESSAGE);
            }
            frame.dispose();
        });

        // this is for the milk inventory item
        /**
         * this adds the milk inventory item to the window. Displays the milk image,
         * remaining quantity, and a button to use the item.
         */
        ImageIcon MilkImage = new ImageIcon("inventory/food4.png");
        JLabel MilkLabel = new JLabel(MilkImage);
        MilkLabel.setBounds(45, 200, MilkImage.getIconWidth(), MilkImage.getIconHeight());
        JLabel milkRemLabel = makeRoundedLabel(" Milk Remaining: " + getMilk(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        milkRemLabel.setBounds(180, 240, 195, 50);
        layeredPane.add(MilkLabel, Integer.valueOf(1));
        layeredPane.add(milkRemLabel, Integer.valueOf(1));

        // this is for the milk button
        /**
         * this creates a button for the milk inventory item. When clicked, it decreases
         * the milk count, updates the pet's fullness, and updates the GUI to reflect
         * the new count.
         */
        JButton milkButton = new JButton("");
        milkButton.setBounds(45, 200, MilkImage.getIconWidth(), MilkImage.getIconHeight()); // x, y, width, height
        milkButton.setBorderPainted(false);
        milkButton.setFocusPainted(false);
        milkButton.setContentAreaFilled(false);
        frame.add(milkButton);
        milkButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            if (getMilk() > 0) {
                setMilk(getMilk() - 1);
                pet.setFullnessValue((pet.getFullnessValue() + 10)); // this adds 10 to fullness
                milkRemLabel.setText(" Milk Remaining: " + getMilk());
                System.out.println("Milk used! Remaining milk: " + getMilk());
                System.out.println("Pet fullness: " + pet.getFullnessValue());
            } else {
                JOptionPane.showMessageDialog(frame, "No milk remaining!", "Error", JOptionPane.WARNING_MESSAGE);
            }
            frame.dispose();
        });

        // this is for the bear inventory item
        /**
         * this adds the bear inventory item to the window. Displays the bear image,
         * remaining quantity, and a button to use the item.
         */
        ImageIcon bearImage = new ImageIcon("inventory/bear.png");
        JLabel bearLabel = new JLabel(bearImage);
        bearLabel.setBounds(400, 200, bearImage.getIconWidth(), bearImage.getIconHeight());
        JLabel bearRemLabel = makeRoundedLabel(" Bears Remaining: " + getBears(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        bearRemLabel.setBounds(530, 240, 200, 50);
        layeredPane.add(bearLabel, Integer.valueOf(1));
        layeredPane.add(bearRemLabel, Integer.valueOf(1));

        //this is for the bear button
        /**
         * this creates a button for the bear inventory item. When clicked, it decreases
         * the bear count, updates the pet's happiness, and updates the GUI to reflect
         * the new count.
         */
        JButton bearButton = new JButton("");
        bearButton.setBounds(400, 200, bearImage.getIconWidth(), bearImage.getIconHeight()); // this sets the x, y, width, height
        bearButton.setBorderPainted(false);
        bearButton.setFocusPainted(false);
        bearButton.setContentAreaFilled(false);
        frame.add(bearButton);
        bearButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            if (getBears() > 0) {
                setBears(getBears() - 1);
                pet.setHappinessValue((pet.getHappinessValue() + 10)); // this adds 10 to happiness
                bearRemLabel.setText(" Bears Remaining: " + getBears());
                System.out.println("Bear used! Remaining bears: " + getBears());
                System.out.println("Pet happiness: " + pet.getHappinessValue());
            } else {
                JOptionPane.showMessageDialog(frame, "No bears remaining!", "Error", JOptionPane.WARNING_MESSAGE);
            }
            frame.dispose();
        });

        // this adds treats inventory item
        /**
         * This adds the treats inventory item to the window. Displays the treats image,
         * remaining quantity, and a button to use the item.
         */
        ImageIcon treatsImage = new ImageIcon("inventory/food6.png");
        JLabel treatsLabel = new JLabel(treatsImage);
        treatsLabel.setBounds(45, 310, treatsImage.getIconWidth(), treatsImage.getIconHeight());
        JLabel treatsRemLabel = makeRoundedLabel(" Treats Remaining: " + getTreats(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        treatsRemLabel.setBounds(180, 340, 210, 50);
        layeredPane.add(treatsLabel, Integer.valueOf(1));
        layeredPane.add(treatsRemLabel, Integer.valueOf(1));


        // this adds the treats button
        /**
         * this creates a button for the treats inventory item. When clicked, it decreases
         * the treats count, updates the pet's fullness, and updates the GUI to reflect
         * the new count. Displays an error if no treats are left.
         */
        JButton treatsButton = new JButton("");
        treatsButton.setBounds(45, 310, treatsImage.getIconWidth(), treatsImage.getIconHeight()); // this sets x, y, width, height
        treatsButton.setBorderPainted(false);
        treatsButton.setFocusPainted(false);
        treatsButton.setContentAreaFilled(false);
        frame.add(treatsButton);
        treatsButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            if (getTreats() > 0) {
                // this decreases the treats count
                setTreats(getTreats() - 1);

                // this updates the pet's fullness
                pet.setFullnessValue((pet.getFullnessValue() + 15)); // this adds 15 to fullness

                // this refreshes the treats label
                treatsRemLabel.setText(" Treats Remaining: " + getTreats());

                // this optionally prints to console for debugging
                System.out.println("Treat used! Remaining treats: " + getTreats());
                System.out.println("Pet fullness: " + pet.getFullnessValue());
            } else {
                // this shows error if no treats are left
                JOptionPane.showMessageDialog(frame, "No treats remaining!", "Error", JOptionPane.WARNING_MESSAGE);
            }
            frame.dispose();
        });

        // this adds the blocks inventory item
        /**
         * this adds the blocks inventory item to the window. Displays the blocks image,
         * remaining quantity, and a button to use the item.
         */
        ImageIcon blockImage = new ImageIcon("inventory/blocks.png");
        JLabel blockLabel = new JLabel(blockImage);
        blockLabel.setBounds(400, 310, blockImage.getIconWidth(), blockImage.getIconHeight());
        JLabel blockRemLabel = makeRoundedLabel(" Blocks Remaining: " + getBlocks(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        blockRemLabel.setBounds(530, 340, 210, 50);
        layeredPane.add(blockLabel, Integer.valueOf(1));
        layeredPane.add(blockRemLabel, Integer.valueOf(1));

        // this adds the blocks button
        /**
         * this creates a button for the blocks inventory item. When clicked, it decreases
         * the blocks count, updates the pet's happiness, and updates the GUI to reflect
         * the new count. Displays an error if no blocks are left.
         */
        JButton blocksButton = new JButton("");
        blocksButton.setBounds(400, 310, blockImage.getIconWidth(), blockImage.getIconHeight()); // this sets x, y, width, height
        blocksButton.setBorderPainted(false);
        blocksButton.setFocusPainted(false);
        blocksButton.setContentAreaFilled(false);
        frame.add(blocksButton);
        blocksButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            if (getBlocks() > 0) {
                // this decreases the block count
                setBlocks(getBlocks() - 1);

                // this updates the pet's happiness
                pet.setHappinessValue((pet.getHappinessValue() + 15)); // this adds 15 to happiness

                // this refreshes the block label
                blockRemLabel.setText(" Blocks Remaining: " + getBlocks());

                // this optionally prints to console for debugging
                System.out.println("Block used! Remaining blocks: " + getBlocks());
                System.out.println("Pet happiness: " + pet.getHappinessValue());
            } else {
                // this shows error if no blocks are left
                JOptionPane.showMessageDialog(frame, "No blocks remaining!", "Error", JOptionPane.WARNING_MESSAGE);
            }
            frame.dispose();
        });

        // this adds the chicken inventory item
        /**
         * this adds the chicken inventory item to the window. It displays the chicken image,
         * remaining quantity, and a button to use the item.
         */
        ImageIcon chickenImage = new ImageIcon("inventory/food3.png");
        JLabel chickenLabel = new JLabel(chickenImage);
        chickenLabel.setBounds(45, 410, chickenImage.getIconWidth(), chickenImage.getIconHeight());
        JLabel chickenRemLabel = makeRoundedLabel(" Chicken Remaining: " + getChicken(), Color.WHITE, Color.BLACK, new Font("Arial", Font.BOLD, 20));
        chickenRemLabel.setBounds(180, 440, 225, 50);
        layeredPane.add(chickenLabel, Integer.valueOf(1));
        layeredPane.add(chickenRemLabel, Integer.valueOf(1));

        // this adds the chicken button
        /**
         * this creates a button for the chicken inventory item. When clicked, it decreases
         * the chicken count, updates the pet's fullness, and updates the GUI to reflect
         * the new count. It displays an error if no chicken is left.
         */
        JButton chickenButton = new JButton("");
        chickenButton.setBounds(45, 410, chickenImage.getIconWidth(), chickenImage.getIconHeight()); // this sets x, y, width, height
        chickenButton.setBorderPainted(false);
        chickenButton.setFocusPainted(false);
        chickenButton.setContentAreaFilled(false);
        frame.add(chickenButton);
        chickenButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            if (getChicken() > 0) {
                setChicken(getChicken() - 1);
                pet.setFullnessValue((pet.getFullnessValue() + 20)); // this adds 20 to fullness
                chickenRemLabel.setText(" Chicken Remaining: " + getChicken());
                System.out.println("Chicken used! Remaining chicken: " + getChicken());
                System.out.println("Pet fullness: " + pet.getFullnessValue());
            } else {
                JOptionPane.showMessageDialog(frame, "No chicken remaining!", "Error", JOptionPane.WARNING_MESSAGE);
            }
            frame.dispose();
        });

        // this adds the spinner inventory item
        /**
         * this adds the spinner inventory item to the window. Displays the spinner image,
         * remaining quantity, and a button to use the item.
         */
        ImageIcon spinnerImage = new ImageIcon("inventory/spinner.png");
        JLabel spinnerLabel = new JLabel(spinnerImage); // this is the corrected to use the image icon
        spinnerLabel.setBounds(400, 410, spinnerImage.getIconWidth(), spinnerImage.getIconHeight());
        layeredPane.add(spinnerLabel, Integer.valueOf(1));

        // this adds the spinner remaining label
        /**
         * this displays the label showing the remaining count of spinners in the inventory.
         */
        JLabel spinnerRemLabel = makeRoundedLabel(
            " Spinners Remaining: " + getSpinners(),
            Color.WHITE,
            Color.BLACK,
            new Font("Arial", Font.BOLD, 20)
        );
        spinnerRemLabel.setBounds(530, 440, 230, 50);
        layeredPane.add(spinnerRemLabel, Integer.valueOf(1));

        // this adds the spinner button
        /**
         * this creates a button for the spinner inventory item. When clicked, it decreases
         * the spinner count, updates the pet's happiness, and updates the GUI to reflect
         * the new count. Displays an error if no spinners are left.
         */
        JButton spinnerButton = new JButton("");
        spinnerButton.setBounds(400, 410, spinnerImage.getIconWidth(), spinnerImage.getIconHeight()); // this sets x, y, width, height
        spinnerButton.setBorderPainted(false);
        spinnerButton.setFocusPainted(false);
        spinnerButton.setContentAreaFilled(false);
        frame.add(spinnerButton);
        spinnerButton.addActionListener(e -> {
            mainMenu.playSound("sounds/button_click.wav");
            if (getSpinners() > 0) {
                setSpinners(getSpinners() - 1);
                pet.setHappinessValue((pet.getHappinessValue() + 20)); // this adds 20 to happiness
                spinnerRemLabel.setText(" Spinners Remaining: " + getSpinners());
                System.out.println("Spinner used! Remaining spinners: " + getSpinners());
                System.out.println("Pet happiness: " + pet.getHappinessValue());
            } else {
                JOptionPane.showMessageDialog(frame, "No spinners remaining!", "Error", JOptionPane.WARNING_MESSAGE);
            }
            frame.dispose();
        });

        // this adds the layered pane to the frame
        frame.add(layeredPane);
        frame.setVisible(true);
    }

    /**
     * this creates a JLabel with a rounded background for improved visual appearance.
     *
     * @param text      The text to display on the label.
     * @param bgColor   The background color of the label.
     * @param textColor The text color of the label.
     * @param font      The font used for the label text.
     * @return A {@code JLabel} with a rounded background.
     */
    public static JLabel makeRoundedLabel(String text, Color bgColor, Color textColor, Font font) {
        JLabel label = new JLabel(text) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // this draws the rounded background
                g2.setColor(bgColor);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);

                // this draws the text
                super.paintComponent(g);
            }
        };

        label.setFont(font);  // this sets the font for the label
        label.setForeground(textColor);  // this sets the text color
        label.setOpaque(false);  // this is the transparent background
        return label;
    }

    /**
     * this retrieves the current number of balls in the inventory.
     * 
     * @return the number of balls remaining.
     */
    public static int getBalls() {
        return balls;
    }

    /**
     * this sets the number of balls in the inventory.
     * 
     * @param setBalls the new count of balls to set.
     */
    public static void setBalls(int setBalls) {
        balls = setBalls;
    }

    /**
     * this retrieves the current number of fish in the inventory.
     * 
     * @return the number of fish remaining.
     */
    public static int getFish() {
        return fish;
    }

    /**
     * this sets the number of fish in the inventory.
     * 
     * @param setFish the new count of fish to set.
     */
    public static void setFish(int setFish) {
        fish = setFish;
    }

    /**
     * this retrieves the current number of bears in the inventory.
     * 
     * @return the number of bears remaining.
     */
    public static int getBears() {
        return bears;
    }

    /**
     * this sets the number of bears in the inventory.
     * 
     * @param setBears the new count of bears to set.
     */
    public static void setBears(int setBears) {
        bears = setBears;
    }

    /**
     * this retrieves the current number of milk items in the inventory
     * 
     * @return the number of milk items remaining.
     */
    public static int getMilk() {
        return milk;
    }

    /**
     * this sets the number of milk items in the inventory.
     * 
     * @param setMilk the new count of milk items to set.
     */
    public static void setMilk(int setMilk) {
        milk = setMilk;
    }

    /**
     * this retrieves the current number of blocks in the inventory
     * 
     * @return the number of blocks remaining.
     */
    public static int getBlocks() {
        return blocks;
    }

    /**
     * this sets the number of blocks in the inventory
     * 
     * @param setBlocks the new count of blocks to set.
     */
    public static void setBlocks(int setBlocks) {
        blocks = setBlocks;
    }

    /**
     * this retrieves the current number of treats in the inventory
     * 
     * @return the number of treats remaining.
     */
    public static int getTreats() {
        return treats;
    }

    /**
     * this sets the number of treats in the inventory
     * 
     * @param setTreats the new count of treats to set.
     */
    public static void setTreats(int setTreats) {
        treats = setTreats;
    }

    /**
     * this retrieves the current number of spinners in the inventory
     * 
     * @return the number of spinners remaining.
     */
    public static int getSpinners() {
        return spinners;
    }

    /**
     * this sets the number of spinners in the inventory
     * 
     * @param setSpinners the new count of spinners to set.
     */
    public static void setSpinners(int setSpinners) {
        spinners = setSpinners;
    }

    /**
     * this retrieves the current number of chicken items in the inventory
     * 
     * @return the number of chicken items remaining.
     */
    public static int getChicken() {
        return chicken;
    }

    /**
     * this sets the number of chicken items in the inventory
     * 
     * @param setChicken the new count of chicken items to set.
     */
    public static void setChicken(int setChicken) {
        chicken = setChicken;
    }

    /**
     * this is the main method to launch the inventory GUI
     * 
     * @param args command-line arguments (not used).
     */
    public static void main(String[] args) {
        showWindow();
    }
}

