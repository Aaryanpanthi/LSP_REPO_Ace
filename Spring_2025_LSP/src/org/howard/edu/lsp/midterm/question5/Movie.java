package org.howard.edu.lsp.midterm.question5;

/**
 * The Movie class implements the Streamable interface and represents a movie
 * with methods to play, pause, stop, and rewind the movie.
 * It provides functionality to control movie playback.
 * 
 * @author Aaryan
 * @version 1.0
 */
public class Movie implements Streamable {
    
    /** The title of the movie */
    private String title;

    /**
     * Constructs a Movie object with the specified title.
     * 
     * @param title the title of the movie
     */
    public Movie(String title) {
        this.title = title;
    }

    /**
     * Plays the movie, displaying the movie title.
     */
    @Override
    public void play() {
        System.out.println("Playing movie: " + title);
    }

    /**
     * Pauses the movie, displaying the movie title.
     */
    @Override
    public void pause() {
        System.out.println("Paused movie: " + title);
    }

    /**
     * Stops the movie, displaying the movie title.
     */
    @Override
    public void stop() {
        System.out.println("Stopped movie: " + title);
    }

    /**
     * Rewinds the movie by the specified number of seconds.
     * 
     * @param seconds the number of seconds to rewind the movie
     */
    public void rewind(int seconds) {
        System.out.println("Rewinding movie: " + title + " by " + seconds + " seconds");
    }
}
