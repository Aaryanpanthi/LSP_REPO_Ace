package org.howard.edu.lsp.midterm.question5;

/**
 * The Audiobook class implements the Streamable interface and represents an audiobook.
 * It provides methods to control the playback of the audiobook, including play, pause, stop,
 * and setting the playback speed.
 * 
 * @author Aaryan
 * @version 1.0
 */
public class Audiobook implements Streamable {
    
    /** The title of the audiobook */
    private String title;

    /**
     * Constructs an Audiobook object with the specified title.
     * 
     * @param title the title of the audiobook
     */
    public Audiobook(String title) {
        this.title = title;
    }

    /**
     * Plays the audiobook.
     */
    @Override
    public void play() {
        System.out.println("Playing audiobook: " + title);
    }

    /**
     * Pauses the audiobook.
     */
    @Override
    public void pause() {
        System.out.println("Paused audiobook: " + title);
    }

    /**
     * Stops the audiobook.
     */
    @Override
    public void stop() {
        System.out.println("Stopped audiobook: " + title);
    }

    /**
     * Sets the playback speed for the audiobook.
     * 
     * @param speed the playback speed (e.g., 1.0 for normal speed, 1.5 for 1.5x speed)
     */
    public void setPlaybackSpeed(double speed) {
        System.out.println("Setting playback speed of audiobook: " + title + " to " + speed + "x");
    }
}
