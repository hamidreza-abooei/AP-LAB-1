package com.company;

import java.io.*;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class FileUtils {
    private String address;
    private String extension;
    public FileUtils(){
        address = "./VotingFile/";
        extension = ".votingSystem";
    }


    /**
     *
     * @param fileName filename to read
     * @return note that has been read
     */
    public VotingSystem fileReader(String fileName){
        fileName = address + fileName + extension;
        try (FileInputStream fi = new FileInputStream(fileName)){
            ObjectInputStream os = new ObjectInputStream(fi);
            return (VotingSystem) os.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }



    public void fileWriter(VotingSystem votingSystem , String fileName){
        fileName = address + fileName + extension;
        try(FileOutputStream fo = new FileOutputStream(fileName)){
            ObjectOutputStream os = new ObjectOutputStream(fo);
            os.writeObject(votingSystem);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
