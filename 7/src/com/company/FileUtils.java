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
    private String bufferAddress;
    private String bufferExtension;
    public FileUtils(){
        address = "./notes/";
        extension = ".note";
        bufferAddress = "./noteBuffer/";
        bufferExtension = ".noteBuff";
    }


    /**
     *
     * @param fileName filename to read
     * @return note that has been read
     */
    public Note fileReader(String fileName){
        fileName = address + fileName + extension;
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
     * @param fileName the name of buffer file
     * @return the note
     */
    public Note fileBufferedReader(String fileName){
        fileName = bufferAddress + fileName + bufferExtension;
        File srcFile = new File(fileName);
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(srcFile));
            int count = 0;
            char[] buffer = new char[2048];
            while (reader.ready()){
                count = reader.read(buffer);
            }
            int seperator1 = 0;
            int seperator2 = 0;
            for (int i = 0; i < buffer.length; i++) {
                if( buffer[i] == '\n' ){
                    if (seperator1 == 0){
                        seperator1 = i;
                    }else if(seperator2 == 0){
                        seperator2 = i;
                        break;
                    }
                }
            }

            String title = new String(buffer , 0 , seperator1 );
            String date = new String(buffer , seperator1 +1, seperator2 - seperator1 -1 );
            String content = new String(buffer , seperator2 +1 , count );
            Note readNote = new Note(title , content , date);
            return readNote;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(reader != null)
                    reader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     *
     * @param note the note that we want to write
     * @param fileName the name of file that we want to write in to it
     */
    public void fileBufferedWriter(Note note ,String fileName){
        fileName = bufferAddress + fileName + bufferExtension;
        File srcFile = new File(fileName);
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(srcFile));
            writer.write(note.getTitle()+"\n" + note.getDate()+
                    "\n" + note.getContent());
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer!= null)
                    writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }





    /**
     *
     * @param note note to write in file
     * @param fileName the name of output file
     */
    public void fileWriter(Note note , String fileName){
        fileName = address + fileName + extension;
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
                String pathString = p.toString();
                files.add( pathString.substring(address.length() , pathString.length() - extension.length()));
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
        fileName = address + fileName + extension;
        try {
            File f = new File(fileName);
            return f.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
