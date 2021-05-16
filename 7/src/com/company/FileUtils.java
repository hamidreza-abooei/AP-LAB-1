package com.company;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtils {
    private String address;
    public FileUtils(){
        address = "./notes/";

    }

    /**
     *
     * @param fileName filename to read
     * @return note that has been read
     */
    public Note fileReader(String fileName){
        fileName = address + fileName;
        System.out.println(fileName);
        try (FileInputStream fi = new FileInputStream(fileName)){
            ObjectInputStream os = new ObjectInputStream(fi);
            return (Note) os.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     * @param note note to write in file
     * @param fileName the name of output file
     */
    public void fileWriter(Note note , String fileName){
        fileName = address + fileName;
        try(FileOutputStream fo = new FileOutputStream(fileName)){
            ObjectOutputStream os = new ObjectOutputStream(fo);
            os.writeObject(note);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @return the ArrayList of note files available
     * @throws IOException don't handeled and throws to caller
     */
    public ArrayList<String> getAvailableNotes() throws IOException {
        Path path = Paths.get(address);
        ArrayList<String> files = new ArrayList<>();
        if(Files.exists(path)){
            DirectoryStream<Path> directoryStream = Files.newDirectoryStream(path);
            for (Path p: directoryStream) {
                files.add(p.toString().substring(address.length()));
            }
        }
        return files;
    }

    /**
     * remove one note file
     * @param fileName name of file to remove
     * @return removed or not
     */
    public boolean removeFile (String fileName){
        fileName = address + fileName;
        try {
            File f = new File(fileName);
            return f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
