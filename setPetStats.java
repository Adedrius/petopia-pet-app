public class setPetStats extends pet {
    
    // Constructor that takes a Pet object
    public setPetStats(String petType, String petName, int health, int happiness, int fullness, int sleep, int balls, int fish, int bears, int milk, int blocks, int treats, int spinners, int chicken) {
        super(petType, petName, health, happiness, fullness, sleep, score);  // Call the parent constructor
    }

    // Setter methods for the Pet stats (non-static)
    public void setPetType(String petType) {
        super.setPetType(petType);
    }

    public void setPetName(String petName) {
        super.setPetName(petName);
    }

    public void setHealth(int health) {
        super.setHealth(health);
    }

    public void setHappiness(int happiness) {
        super.setHappiness(happiness);
    }

    public void setFullness(int fullness) {
        super.setFullness(fullness);
    }

    public void setSleep(int sleep) {
        super.setSleep(sleep);
    }
    public void setScore(int score) {
        super.setScore(score);
    }
}
