package com.company;

/**
 * a class to hold and define song
 * @author Hamidreza Abooei
 * @version 2021-3-15
 */
public class Song
{
    // the name of music
    private String musicName;
    // a string for music directory
    private String musicDirectory;
    // a string for artist of music
    private String artist;
    // a string for release date of music
    private String releaseDate;

    public Song(String musicName)
    {
        this.musicName = musicName;
        musicDirectory = "";
        artist = "";
        releaseDate = "";
    }

    /**
     * setter for artist
     * @param artist artist of song
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * setter for music directory
     * @param musicDirectory Direction of music
     */
    public void setMusicDirectory(String musicDirectory) {
        this.musicDirectory = musicDirectory;
    }

    /**
     * setter for Date of release
     * @param releaseDate Date of release
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * setter for Name of music
     * @param musicName name of music
     */
    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    /**
     * getter for artist
     * @return artist
     */
    public String getArtist() {
        return artist;
    }

    /**
     * getter for music directory
     * @return music directory
     */
    public String getMusicDirectory() {
        return musicDirectory;
    }

    /**
     * getter for Date of release
     * @return release date
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * getter for music name
     * @return music name
     */
    public String getMusicName() {
        return musicName;
    }

    /**
     * show song
     */
    public void showSong(){
        System.out.println(musicName + ": " +
                           artist + ",\t" +
                           releaseDate + " " +
                           musicDirectory);
        System.out.println("-------------------------------------------------------");
    }


}
