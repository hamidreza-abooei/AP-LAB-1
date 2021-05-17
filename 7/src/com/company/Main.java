package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static ArrayList<String> files = new ArrayList<>();
    public static FileUtils fileUtils = new FileUtils();
    public static void main(String[] args) throws IOException {
        Note newnote = new Note("this is test title" , "this is test context", "02-25-55");
        fileUtils.fileBufferedWriter(newnote,"testFile");
        Note readBuffered = fileUtils.fileBufferedReader("testFile");
        System.out.println(readBuffered);

        menu();
    }

    /**
     * main menu
     * @throws IOException exception don't handel
     */
    public static void menu() throws IOException {
        boolean isContinued = true;
        while (isContinued) {
            showMenuOptions();
            Scanner scanner = new Scanner(System.in);
            int entered = scanner.nextInt();
            if (entered == 1){
                showAvailableFiles();
            }else if(entered == 2){
                showOneNoteContent();
            }else if(entered == 3){
                writeNote();
            }else if(entered == 4){
                removeFile();
            }else if(entered == 5){
                briefShow();
            }else if(entered == 6){
                isContinued = false;
            }else{
                System.out.println("Please enter the right number");
            }
        }
    }

    /**
     * just for print
     */
    public static void showMenuOptions(){
        System.out.println("Main Menue:");
        System.out.println("What do you want to do?");
        System.out.println("1- Show Available files");
        System.out.println("2- Show one of the note contents");
        System.out.println("3- Add new note");
        System.out.println("4- remove note");
        System.out.println("5- show brief version of all files");
        System.out.println("6- Exit");
    }

    /**
     * show all available note files
     * @throws IOException
     */
    public static void showAvailableFiles() throws IOException {
        int counter = 0;
        System.out.println("Available notes are listed bellow");
        updateAllAvailableFiles();
        for (String file : files) {
            counter++;
            System.out.println(counter + " : " +file);
        }
    }

    /**
     * this method update the available files in the directory
     * @throws IOException
     */
    public static void updateAllAvailableFiles() throws IOException {
        files = fileUtils.getAvailableNotes();
    }

    /**
     * show content of one note of one file
     */
    public static void showOneNoteContent(){
        System.out.println("Enter the file number");
        Scanner scanner = new Scanner(System.in);
        int fileNumber = scanner.nextInt();
        String fileName = files.get(fileNumber-1);
        Note readNotes = fileUtils.fileReader(fileName);
        System.out.println(readNotes);
    }

    /**
     *
     * @return one new note
     */
    public static Note addNote(){

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the title:");
        String title = scanner.nextLine();
        System.out.println("Enter the date");
        String date = scanner.nextLine();
        System.out.println("Enter the content:");
        String content = scanner.nextLine();
        Note newNote = new Note(title,content,date);
        return newNote;
    }

    /**
     * write note in a file
     */
    public static void writeNote(){
        System.out.println("Enter the file Name:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        Note newNote = addNote();
        fileUtils.fileWriter(newNote,fileName);
    }

    /**
     * remove a note file
     */
    public static void removeFile(){
        System.out.println("Enter the file Name:");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();
        System.out.println(fileUtils.removeFile(fileName) ? "File has been removed successfully": "FileName is not true");
    }

    /**
     * this method print a brief show of note content
     * @throws IOException dont handle Exception
     */
    public static void briefShow() throws IOException {
        int counter = 0;
        updateAllAvailableFiles();

        for (String file : files) {
            counter++;
            Note readNotes = fileUtils.fileReader(file);
            System.out.println(counter + " : " + readNotes.briefToString(20));
        }
    }



}
