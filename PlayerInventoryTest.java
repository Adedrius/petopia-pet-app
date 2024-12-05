import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PlayerInventoryTest {
    
    @BeforeEach
    public void setup() {
        // Reset the inventory before each test
        playerInventory.balls = 5;
        playerInventory.fish = 5;
        playerInventory.bears = 4;
        playerInventory.milk = 4;
        playerInventory.blocks = 3;
        playerInventory.treats = 3;
        playerInventory.spinners = 2;
        playerInventory.chicken = 2;
    }

    @Test
    public void testGetFish() {
        assertEquals(5, playerInventory.getFish());
    }

    @Test
    public void testSetFish() {
        playerInventory.setFish(3);
        assertEquals(3, playerInventory.getFish());
    }

    @Test
    public void testGetBalls() {
        assertEquals(5, playerInventory.getBalls());
    }

    @Test
    public void testSetBalls() {
        playerInventory.setBalls(2);
        assertEquals(2, playerInventory.getBalls());
    }

    @Test
    public void testUseFish() {
        int initialFish = playerInventory.getFish();
        playerInventory.setFish(initialFish - 1);
        assertEquals(initialFish - 1, playerInventory.getFish());
        // Assuming there's a method to test pet fullness
        // assertEquals(pet.getFullnessValue(), initialFullness + 5); // Example
    }

    @Test
    public void testUseBalls() {
        int initialBalls = playerInventory.getBalls();
        playerInventory.setBalls(initialBalls - 1);
        assertEquals(initialBalls - 1, playerInventory.getBalls());
        // Assuming there's a method to test pet happiness
        // assertEquals(pet.getHappinessValue(), initialHappiness + 5); // Example
    }

    @Test
    public void testInventoryUpdatesWhenUsed() {
        // Test when using Fish
        int initialFish = playerInventory.getFish();
        playerInventory.setFish(initialFish - 1);
        assertEquals(initialFish - 1, playerInventory.getFish());

        // Test when using Balls
        int initialBalls = playerInventory.getBalls();
        playerInventory.setBalls(initialBalls - 1);
        assertEquals(initialBalls - 1, playerInventory.getBalls());
    }

    @Test
    public void testUseMilk() {
        int initialMilk = playerInventory.getMilk();
        playerInventory.setMilk(initialMilk - 1);
        assertEquals(initialMilk - 1, playerInventory.getMilk());
        // Check that fullness is updated
        // assertEquals(pet.getFullnessValue(), initialFullness + 10);
    }

    @Test
    public void testInventoryButtons() {
        // Test button clicks for various items (this could be more complex if you integrate with GUI testing frameworks like AssertJ or Fest)
        // 
