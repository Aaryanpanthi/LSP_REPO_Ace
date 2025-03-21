package org.howard.edu.lsp.midterm.question5;

/**
 * The Music class implements the Streamable interface and represents a music track.
 * It provides methods to control the playback of the music, including play, pause, stop,
 * and adding the music track to a playlist.
 * 
 * @author Aaryan
 * @version 1.0
 */
public class Music implements Streamable {
    
    /** The title of the music track */
    private String title;

    /**
     * Constructs a Music object with the specified title.
     * 
     * @param title the title of the music track
     */
    public Music(String title) {
        this.title = title;
    }

    /**
     * Plays the music track.
     */
    @Override
    public void play() {
        System.out.println("Playing music: " + title);
    }

    /**
     * Pauses the music track.
     */
    @Override
    public void pause() {
        System.out.println("Paused music: " + title);
    }

    /**
     * Stops the music track.
     */
    @Override
    public void stop() {
        System.out.println("Stopped music: " + title);
    }

    /**
     * Adds the music track to a playlist.
     * 
     * @param playlistName the name of the playlist to which the music track will be added
     */
    public void addToPlaylist(String playlistName) {
        System.out.println("Added " + title + " to " + playlistName + " playlist.");
    }
}
