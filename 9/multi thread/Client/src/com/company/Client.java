package com.company;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    private String ip ;
    private int port ;

    /**
     * constructor
     * @param ip Server address
     * @param port port
     */
    public Client(String ip , int port){
        this.ip = ip;
        this.port = port;
    }

    /**
     * start client
     */
    public void startClient(){
        try (Socket connection = new Socket(ip,port);
            DataInputStream in = new DataInputStream(connection.getInputStream());
            DataOutputStream out = new DataOutputStream(connection.getOutputStream())){
            System.out.println(in.readUTF());
            Scanner scanner = new Scanner(System.in);
            while (true){
                out.writeUTF(scanner.nextLine());
                String read = in.readUTF();
                System.out.println(read);
                if(read.equalsIgnoreCase("GoodBye.")){
                    break;
                }
            }
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
