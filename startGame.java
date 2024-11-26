import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class startGame extends JFrame {

  // Constructor for the StartGame screen
  public static void showWindow() {

      JFrame frame = new JFrame("Choose Your Pet");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setSize(800, 600);
      frame.setLocationRelativeTo(null);
      frame.setLayout(null);

      JLabel pageTitle = new JLabel("Select Your Pet");
      pageTitle.setBounds(275, 45, 225, 30); // x, y, width, height
      pageTitle.setFont(new Font("Arial", Font.BOLD, 30));
      pageTitle.setOpaque(false);
      pageTitle.setBorder(null);
      frame.add(pageTitle);


      // Create labels for pet names
      JLabel pet1Name = new JLabel("Pet 1", JLabel.CENTER);
      pet1Name.setFont(new Font("Arial", Font.BOLD, 16));
      pet1Name.setBounds(90, 145, 225, 30); // x, y, width, height

      JLabel pet2Name = new JLabel("Pet 2", JLabel.CENTER);
      pet2Name.setFont(new Font("Arial", Font.BOLD, 16));
      pet2Name.setBounds(275, 145, 225, 30); // x, y, width, height

      JLabel pet3Name = new JLabel("Pet 3", JLabel.CENTER);
      pet3Name.setFont(new Font("Arial", Font.BOLD, 16));
      pet3Name.setBounds(470, 145, 225, 30); // x, y, width, height

      frame.add(pet1Name);
      frame.add(pet2Name);
      frame.add(pet3Name);



      // PET IMAGE 1 SETUP
      ImageIcon pet1Icon = new ImageIcon("group34/sprites/cat_normal.png");
      Image scaledPet1 = pet1Icon.getImage().getScaledInstance(225, 225, Image.SCALE_SMOOTH);
      ImageIcon scaledPet1Icon = new ImageIcon(scaledPet1);


      // Create buttons with images
      JButton pet1Button = new JButton(scaledPet1Icon);
      pet1Button.setBorderPainted(false);
      pet1Button.setFocusPainted(false);
      pet1Button.setContentAreaFilled(false);

      pet1Button.setBounds(95, 175, 200, 200);

      pet1Button.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            // Add a border
            pet1Button.setBorder(new LineBorder(Color.BLUE, 2));

            // Scale up the icon slightly
            Image scaledImage = pet1Icon.getImage().getScaledInstance(
                    (int) (250 * 1.1), // 10% larger width
                    (int) (250 * 1.1), // 10% larger height
                    Image.SCALE_SMOOTH
            );
            pet1Button.setIcon(new ImageIcon(scaledImage));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Remove the border
            pet1Button.setBorder(null);

            // Reset the icon to its original size
            pet1Button.setIcon(pet1Icon);
        }
      });

      frame.add(pet1Button);


      // PET IMAGE 2 SETUP
      ImageIcon pet2Icon = new ImageIcon("group34/sprites/dog_normal.png");
      Image scaledPet2 = pet2Icon.getImage().getScaledInstance(250, 250, Image.SCALE_SMOOTH);
      ImageIcon scaledPet2Icon = new ImageIcon(scaledPet2);


      // Create buttons with images
      JButton pet2Button = new JButton(scaledPet2Icon);
      pet2Button.setBorderPainted(false);
      pet2Button.setFocusPainted(false);
      pet2Button.setContentAreaFilled(false);

      pet2Button.setBounds(285, 175, 200, 200);

      pet2Button.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            // Add a border
            pet2Button.setBorder(new LineBorder(Color.BLUE, 2));

            // Scale up the icon slightly
            Image scaledImage = pet2Icon.getImage().getScaledInstance(
                    (int) (250 * 1.1), // 10% larger width
                    (int) (250 * 1.1), // 10% larger height
                    Image.SCALE_SMOOTH
            );
            pet2Button.setIcon(new ImageIcon(scaledImage));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Remove the border
            pet2Button.setBorder(null);

            // Reset the icon to its original size
            pet2Button.setIcon(pet2Icon);
        }
      });

      frame.add(pet2Button);


      ImageIcon pet3Icon = new ImageIcon("group34/sprites/sheep_normal.png");
      Image scaledPet3 = pet3Icon.getImage().getScaledInstance(225, 225, Image.SCALE_SMOOTH);
      ImageIcon scaledPet3Icon = new ImageIcon(scaledPet3);


      // PET 3 IMAGE SETUP
      JButton pet3Button = new JButton(scaledPet3Icon);
      pet3Button.setBorderPainted(false);
      pet3Button.setFocusPainted(false);
      pet3Button.setContentAreaFilled(false);

      pet3Button.setBounds(475, 175, 200, 200);

      pet3Button.addMouseListener(new MouseAdapter() {
        @Override
        public void mouseEntered(MouseEvent e) {
            // Add a border
            pet3Button.setBorder(new LineBorder(Color.BLUE, 2));

            // Scale up the icon slightly
            Image scaledImage = pet3Icon.getImage().getScaledInstance(
                    (int) (225 * 1.1), // 10% larger width
                    (int) (225 * 1.1), // 10% larger height
                    Image.SCALE_SMOOTH
            );
            pet3Button.setIcon(new ImageIcon(scaledImage));
        }

        @Override
        public void mouseExited(MouseEvent e) {
            // Remove the border
            pet3Button.setBorder(null);

            // Reset the icon to its original size
            pet3Button.setIcon(pet3Icon);
        }
      });

      frame.add(pet3Button);


      // Set action listeners for the buttons (for future functionality)
      pet1Button.addActionListener(e -> System.out.println("Pet 1 selected"));
      pet2Button.addActionListener(e -> System.out.println("Pet 2 selected"));
      pet3Button.addActionListener(e -> System.out.println("Pet 3 selected"));

      frame.setVisible(true);

  }

    // Method to show the window
    public static void main(String[] args) {
      showWindow();
    }
}
