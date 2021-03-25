package com.company;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A class to hold details of audio songs.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2011.07.31
 */
public class MusicCollection
{
    // An ArrayList for storing the file names of music songs.
    private ArrayList<Song> songs;
    // A player for the music songs.
    private MusicPlayer player;
    // favorite songs
    private ArrayList<Song> favorites;
        
    /**
     * Create a MusicCollection
     */
    public MusicCollection()
    {
        songs = new ArrayList<>();
        player = new MusicPlayer();
        favorites = new ArrayList<>();
    }

    /**
     * add a song to favorites
     * @param song the song to be added to favorites
     */
    public void addToFavorites (Song song){
        favorites.add(song);
    }

    /**
     * show all songs in favorites
     */
    public void listAllFavorites (){
        for(Song song : favorites)
            song.showSong();
    }

    /**
     * retern all of favorite lists
     * @return favorite list.
     */
    public ArrayList<Song> getFavorites(){
        return favorites;
    }

    /**
     * remove song from favorites
     * @param song the song to be removed from favorites
     */
    public void removeSongFavorites(Song song){
        Iterator<Song> it = favorites.iterator();
        while(it.hasNext()){
            Song itSong = it.next();
            if (itSong.equals(song)){
                it.remove();
            }
        }
    }

    /**
     * remove one song from favorites
     * @param index the index of song in favorites to be removed
     */
    public void removeSongFavorites(int index){
        favorites.remove(index);
    }



    /**
     * Add a file to the collection.
     * @param song The song to be added.
     */
    public void addSong(Song song)
    {
        songs.add(song);
    }

    
    /**
     * Return the number of songs in the collection.
     * @return The number of songs in the collection.
     */
    public int getNumberOfSongs()
    {
        return songs.size();
    }
    
    /**
     * List a song from the collection.
     * @param index The index of the song to be listed.
     */
    public void listSong(int index)
    {
        songs.get(index).showSong();
    }
    
    /**
     * Show a list of all the songs in the collection.
     */
    public void listAllsongs()
    {
        for(Song song: songs){
            song.showSong();
        }
    }
    
    /**
     * Remove a song from the collection.
     * @param index The index of the song to be removed.
     */
    public void removeSong(int index)
    {
        songs.remove(index);
    }

    /**
     * Remove a song from the collection.
     * @param song The song to be removed.
     */
    public void removeSong(Song song)
    {
        Iterator<Song> it = songs.iterator();
        while(it.hasNext()){
            Song itSong = it.next();
            if (itSong.equals(song)){
                it.remove();
            }
        }
    }

    /**
     * Start playing a file in the collection.
     * Use stopPlaying() to stop it playing.
     * @param index The index of the file to be played.
     */
    public void startPlaying(int index)
    {
        player.startPlaying(songs.get(index).getMusicName());
    }

    /**
     * Stop the player.
     */
    public void stopPlaying()
    {
        player.stop();
    }

    /**
     * return all songs in collection
     * @return all songs in collection
     */
    public ArrayList<Song> getSongs(){
        return songs;
    }
    /**
     * Determine whether the given index is valid for the collection.
     * Print an error message if it is not.
     * @param index The index to be checked.
     * @return true if the index is valid, false otherwise.
     */

    private boolean validIndex(int index)
    {
        // The return value.
        // Set according to whether the index is valid or not.
        if (index >= songs.size())
            System.out.println("the index that you entered is NOT valid.");
        return  (index < songs.size());
       
    }
}