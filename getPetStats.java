
public class getPetStats extends pet {
    
    private static pet pet;
    
        // Constructor that takes a Pet object
        public getPetStats(String petType, String petName, int health, int happiness, int fullness, int sleep, int score) {
            super(petType, petName, health, happiness, fullness, sleep, score);  // Call the parent constructor
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
    public static String getScore() {
        return pet.getScore();
    }
}
