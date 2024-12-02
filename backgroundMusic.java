import javax.sound.sampled.*;
import java.io.File;

public class backgroundMusic {

    public static void playSong() {
        try {
            // Load the audio file
            File audioFile = new File("sounds/backgroundSound.wav");
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);

            // Create a clip for playback
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);

            // Set volume (optional)
            FloatControl volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volumeControl.setValue(-10.0f); // Adjust volume level (in decibels)

            // Loop the audio indefinitely
            clip.loop(Clip.LOOP_CONTINUOUSLY);

            // Start playing
            clip.start();
            System.out.println("Playing audio...");

            // Keep the program running indefinitely
            while (true) {
                Thread.sleep(1000); // Sleep to reduce CPU usage
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        playSong();
    }
}
