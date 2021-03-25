package com.company;
import java.util.ArrayList;

import java.util.Iterator;
import java.util.Scanner;

/**
 * main function that manage other classes and run the menu
 * @author Hamidreza Abooei
 * @version 2021-3-15
 */
public class Main {

    public static void main(String[] args) {
	    Scanner input = new Scanner(System.in);
	    //the number of collections
	    int numberOfCollections = 4;
        //an array that keeps the collections
        MusicCollection[] categories = new MusicCollection[numberOfCollections];
        //defining music collections
        MusicCollection pop = new MusicCollection();
        MusicCollection jazz = new MusicCollection();
        MusicCollection rock = new MusicCollection();
        MusicCollection country = new MusicCollection();
        //refer categories to each collection
        categories[0] = pop;
        categories[1] = jazz;
        categories[2] = rock;
        categories[3] = country;
        // songs
        ArrayList<Song> songs = new ArrayList<>();
        // define the end of program
        boolean continueOfProgram = true;
        //define that we are in collection menu and don't turn back to main menu
        boolean collectionMenu ;

        //welcome massage
        System.out.println("welcome to your Music organizer");
        //the main while that shows music player is working
        while(continueOfProgram){
            System.out.println("Menu:(Enter the number of item to run)\n" +
                               "1-add song\t" +
                               "2-show all songs\t" +
                               "3-remove song\t" +
                               "4-collection settings\t"+
                               "5-exit\n");
            int in = input.nextInt();
            switch (in){
                case 1:
                    addSong(songs);
                    break;
                case 2:
                    showAllSongs(songs);
                    break;
                case 3:
                    removeSong(songs);
                    break;
                case 5:
                    continueOfProgram = false;
                    break;
            }
            if (in == 4) {
                collectionMenu = true;
                while (collectionMenu) {
                    System.out.println("Enter the collection number:" +
                            "1-pop\t2-jazz\t3-rock\t4-country");
                    int collectionNumber = input.nextInt();
                    collectionNumber--;
                    if (collectionNumber < numberOfCollections && collectionNumber >= 0) {

                        System.out.println("Collection settings: ");
                        System.out.println("Enter the number of function to run");
                        System.out.println("1-Add song to collection:");
                        System.out.println("2-Remove song from the collection");
                        System.out.println("3-Get number of songs in collection");
                        System.out.println("4-show all songs in collection");
                        System.out.println("5-add song to favorites");
                        System.out.println("6-show all favorite songs");
                        System.out.println("7-remove a song from favorites");
                        System.out.println("8-Start playing song");
                        System.out.println("9-stop playing song");
                        System.out.println("10-exit collection settings");
                        int collectionSettings = input.nextInt();

                        switch (collectionSettings) {
                            case 1:
                                addSongToCollection(categories[collectionNumber], songs);
                                break;
                            case 2:
                                removeSongFromCollection(categories[collectionNumber]);
                                break;
                            case 3:
                                System.out.println("the number of songs in current collection is:");
                                System.out.println(categories[collectionNumber].getNumberOfSongs());
                                break;
                            case 4:
                                categories[collectionNumber].listAllsongs();
                                break;
                            case 5:
                                addSongToFavorites(categories[collectionNumber], songs);
                                break;
                            case 6:
                                categories[collectionNumber].listAllFavorites();
                                break;
                            case 7:
                                removeSongFromFavorites(categories[collectionNumber]);
                                break;
                            case 8:
                                startPlayingMusic(categories[collectionNumber]);
                                break;
                            case 9:
                                categories[collectionNumber].stopPlaying();
                                break;
                            case 10:
                                collectionMenu = false;
                        }
                    }else{
                        System.out.println("You have to enter Right number.try again.");
                    }
                }
            }


        }
    }
    public static void addSong (ArrayList<Song> songs){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the name of song:");
        String songName = scanner.nextLine();
        Song newSong = new Song(songName);

        System.out.println("Enter the name of artist:");
        String authorName = scanner.nextLine();
        newSong.setArtist(authorName);

        System.out.println("Enter the release Date of song:");
        String releaseDate = scanner.nextLine();
        newSong.setReleaseDate(releaseDate);

        System.out.println("Enter the song directory:");
        String songDirectory = scanner.nextLine();
        newSong.setMusicDirectory(songDirectory);

        songs.add(newSong);
    }
    public static void showAllSongs (ArrayList<Song> songs){
        int index = 0;
        for(Song song: songs){
            System.out.print(index + ": ");
            song.showSong();
            index++;
        }
    }

    public static void removeSong (ArrayList<Song> songs){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name or index of song:");
        String songName = scanner.nextLine();
        if (isNumeric(songName)) {
            songs.remove(Integer.parseInt(songName));
        }else{
            Iterator<Song> it = songs.iterator();
            while (it.hasNext()) {
                Song itSong = it.next();
                if (itSong.getMusicName().equals(songName)) {
                    it.remove();
                }
            }
        }
    }

    /**
     * function to add song to collection
     * @param collection Music collection that song will added
     * @param songs all songs that special song will choosen and will added to end of it
     */
    public static void addSongToCollection (MusicCollection collection , ArrayList<Song> songs){
        System.out.println("Enter Name of song or song index:");
        Scanner scanner = new Scanner(System.in);
        String indexOrName = scanner.nextLine();
        if (isNumeric(indexOrName)){
            collection.addSong(songs.get(Integer.parseInt(indexOrName)));
        }else{
            boolean flag = false;
            for(Song song: songs) {
                if(song.getMusicName().equals(indexOrName)){
                    collection.addSong(song);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("your music name is not one of song lists");
            }
        }
    }

    /**
     * remove one song from music collection
     * @param collection the collection that song will be removed from.
     */
    public static void removeSongFromCollection(MusicCollection collection){
        ArrayList<Song> songs =  collection.getSongs();
//        collection.listAllsongs();
        System.out.println("Enter Name of song or song index:");
        Scanner scanner = new Scanner(System.in);
        String indexOrName = scanner.nextLine();
        if (isNumeric(indexOrName)){
            collection.removeSong(Integer.parseInt(indexOrName));
        }else{
            boolean flag = false;
            for(Song song: songs) {
                if(song.getMusicName().equals(indexOrName)){
                    collection.removeSong(song);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("your music name is not one of song lists");
            }
        }
    }

    /**
     * add song to favorites in each collection
     * @param collection the collection that we will add song to its favorites
     * @param songs all of the songs that favorite songs will be choosen from
     */
    public static void addSongToFavorites(MusicCollection collection , ArrayList<Song> songs){
        System.out.println("Enter Name of song or song index:");
        Scanner scanner = new Scanner(System.in);
        String indexOrName = scanner.nextLine();
        if (isNumeric(indexOrName)){
            collection.addToFavorites(songs.get(Integer.parseInt(indexOrName)));
        }else{
            boolean flag = false;
            for(Song song: songs) {
                if(song.getMusicName().equals(indexOrName)){
                    collection.addToFavorites(song);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("your music name is not one of song lists");
            }
        }
    }

    /**
     * remove song from favorites
     * @param collection the collection that song will be removed from it's favorites
     */
    public static void removeSongFromFavorites(MusicCollection collection ){
        ArrayList<Song> songs = collection.getFavorites();
        System.out.println("Enter Name of song or song index:");
        Scanner scanner = new Scanner(System.in);
        String indexOrName = scanner.nextLine();
        if (isNumeric(indexOrName)){
            collection.removeSongFavorites(Integer.parseInt(indexOrName));
        }else{
            boolean flag = false;
            for(Song song: songs) {
                if(song.getMusicName().equals(indexOrName)){
                    collection.removeSongFavorites(song);
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("your music name is not one of song lists");
            }
        }
    }

    /**
     * get name of song or song index and run stopPlaying method of
     * @param collection collection that we are going to play its songs
     */
    public static void startPlayingMusic(MusicCollection collection ){
        ArrayList<Song> songs = collection.getSongs();
        System.out.println("Enter Name of song or song index:");
        Scanner scanner = new Scanner(System.in);
        String indexOrName = scanner.nextLine();
        if (isNumeric(indexOrName)){
            collection.startPlaying(Integer.parseInt(indexOrName));
        }else{
            boolean flag = false;
            for(Song song: songs) {
                if(song.getMusicName().equals(indexOrName)){
                    collection.startPlaying(songs.indexOf(song));
                    flag = true;
                    break;
                }
            }
            if(!flag){
                System.out.println("your music name is not one of song lists");
            }
        }
    }


    /**
     * a funciton that tell us that a string is contain of Number or not
     * @param str the input string that will be discussed
     * @return if the string consist of numbers, this function will return true and wise verse.
     */
    public static boolean isNumeric(final String str) {

        // null or empty
        if (str == null || str.length() == 0) {
            return false;
        }

        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;

    }

}
