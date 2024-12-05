import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * This class provides unit tests for the Pet class in the Petopia application.
 */
public class PetTest {
    private pet testPet;

    @BeforeEach
    void setUp() {
        // Set up a new pet object before each test with some initial stats
        testPet = new pet("dog", "Buddy", 100, 100, 100, 100, 0);
    }

    @Test
    void testFeedPet() {
        // Given initial fullness is 100, feeding should not increase beyond the cap.
        testPet.feedPet();
        assertEquals(100, testPet.getFullness(), "Fullness should be capped at 100.");
        assertEquals(1, testPet.getScore(), "Score should increase by 1 after feeding the pet.");

        // Lower the fullness and test feeding again.
        testPet.updateStats(); // simulate time passing that decreases fullness
        testPet.feedPet();
        assertTrue(testPet.getFullness() > 80, "Fullness should increase after feeding.");
    }

    @Test
    void testPlayWithPet() {
        // Lower happiness and check the effect of playing.
        testPet.updateStats(); // simulate time passing that decreases happiness
        testPet.playWithPet();
        assertTrue(testPet.getHappiness() > 90, "Happiness should increase after playing.");
        assertEquals(2, testPet.getScore(), "Score should increase by 2 after playing.");
    }

    @Test
    void testPutToSleep() {
        // Lower sleep and check if sleep is replenished
        testPet.updateStats(); // simulate time passing that decreases sleep
        testPet.putToSleep();
        assertTrue(testPet.getSleep() >= 25, "Sleep should increase after putting pet to sleep.");
    }

    @Test
    void testBringToVet() {
        // Lower health and check if the health increases after going to the vet.
        testPet.updateStats(); // simulate time passing that decreases health
        testPet.bringToVet();
        assertTrue(testPet.getHealth() > 80, "Health should increase after going to the vet.");
        assertEquals(0, testPet.getScore(), "Score should decrease by 1 after going to the vet.");
    }

    @Test
    void testExercisePet() {
        // Decrease health and verify the effect of exercising.
        testPet.updateStats(); // simulate time passing that decreases health
        testPet.exercisePet();
        assertTrue(testPet.getHealth() >= 10, "Health should increase after exercising.");
        assertEquals(1, testPet.getScore(), "Score should increase by 1 after exercising.");
    }

    @Test
    void testUpdateStats() {
        // Decrease stats over time and verify the changes
        testPet.updateStats(); // This simulates the pet's stat decay
        assertTrue(testPet.getHappiness() < 100, "Happiness should decrease over time.");
        assertTrue(testPet.getFullness() < 100, "Fullness should decrease over time.");
        assertTrue(testPet.getSleep() < 100, "Sleep should decrease over time.");
    }

    @Test
    void testIsAlive() {
        // Reduce the health to 0 and check if the pet dies.
        while (testPet.getHealth() > 0) {
            testPet.updateStats(); // this simulates the health decreasing over time
        }
        assertFalse(testPet.isAlive(), "Pet should be dead when health reaches 0.");
    }

    // Add any additional tests for specific behaviors like updating inventory, score limits, etc.
    
}
