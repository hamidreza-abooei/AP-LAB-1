package com.company;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {


    public Server() {
    }
    /**
     * to connect and interact with client
     */
    public void connect()  {

        try {
            ServerSocket serverSocket = new ServerSocket(7070);
            System.out.println("Server is ready...");
            Socket socket = serverSocket.accept();
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            String allData = "";
            while(true){
                System.out.println("waiting for new input...");
                String newData = dataInputStream.readUTF();
                if (newData.equals("over")) {
                    dataOutputStream.writeUTF("over");
                    System.out.println("Server is over.");
                    break;
                }
                allData = allData + newData;
                dataOutputStream.writeUTF(allData);
            }
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
