package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client(){

    }

    /**
     * to connect and interact with server
     */
    public void connect(){
        try {
            Socket socket = new Socket("127.0.0.1",7070);
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            while (true){
                String newString = getString();
                dataOutputStream.writeUTF(newString);
                String response = dataInputStream.readUTF();
                if (response.equals("over")){
                    System.out.println("Disconnected");
                    break;
                }
                System.out.println(response);
            }
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * get string from terminal
     * @return string
     */
    private String getString(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter new string:");
        return scanner.nextLine();
    }
}
