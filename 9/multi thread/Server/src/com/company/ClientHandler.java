package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHandler implements Runnable{
    Socket connection;
    int clientNumber;

    /**
     * constructor
     * @param connection connection
     * @param clientNumber client number
     */
    public ClientHandler(Socket connection , int clientNumber){
        this.connection = connection;
        this.clientNumber = clientNumber;
    }

    /**
     * run method in Runnable interface
     */
    @Override
    public void run() {
        try(DataInputStream in = new DataInputStream(connection.getInputStream());
            DataOutputStream out = new DataOutputStream(connection.getOutputStream())){
            out.writeUTF("Welcome to reverse Server client" + clientNumber + ", Enter new Word to reverse");
            while (true){
                String read = in.readUTF();
                if (read.equalsIgnoreCase("end")){
                    out.writeUTF("GoodBye.");
                    System.out.println("Client" + clientNumber + " Disconnected");
                    break;
                }
                out.writeUTF(reverseString(read));
            }
        } catch (IOException e) {
            System.err.println("Error has been occurred in I/O");
        }
    }

    /**
     * reverse string to write in client
     * @param input string
     * @return reversed input String
     */
    private String reverseString(String input){
        StringBuilder sb = new StringBuilder(input);
        sb.reverse();
        return sb.toString();
    }

}
