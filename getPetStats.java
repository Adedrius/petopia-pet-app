
public class getPetStats extends pet {
    
    private static pet pet;
    
        // Constructor that takes a Pet object
        public getPetStats(String petType, String petName, int health, int happiness, int fullness, int sleep, int balls, int fish, int bears, int milk, int blocks, int treats, int spinners, int chicken, int score) {
            super(petType, petName, health, happiness, fullness, sleep, balls, fish, bears, milk, blocks, treats, spinners, chicken, score);  // Call the parent constructor
        }
    
        // Getter methods for the Pet stats
        public static String getPetType() {
            return pet.getPetType();
    }

    public static String getPetName() {
        return pet.getPetName();
    }

    public static String getHealth() {
        return pet.getHealth();
    }

    public static String getHappiness() {
        return pet.getHappiness();
    }

    public static String getFullness() {
        return pet.getFullness();
    }
    public static String getSleep() {
        return pet.getSleep();
    }
    public static String getBalls() {
        return pet.getBalls();
    }
    public static String getFish() {
        return pet.getFish();
    }
    public static String getBears() {
        return pet.getBears();
    }
    public static String getMilk() {
        return pet.getMilk(); // balls, fish, bears, milk, blocks, treats, spinners, chicken
    }
    public static String getBlocks() {
        return pet.getBlocks();
    }
    public static String getTreats() {
        return pet.getTreats();
    }
    public static String getSpinners() {
        return pet.getSpinners();
    }
    public static String getChicken() {
        return pet.getChicken();
    }
    public static String getScore() {
        return pet.getScore();
    }
    
}
