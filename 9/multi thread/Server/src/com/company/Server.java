package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    private final int port;
    private final int serverCapacity;
    private int clientNumber;

    /**
     * server constructor
     * @param port port number
     * @param serverCapacity server capacity
     */

    public Server( int port ,int serverCapacity){
        this.port = port;
        this.serverCapacity = serverCapacity;
    }

    /**
     * Start server
     */
    public void startServer(){
        clientNumber = 0;
        ExecutorService pool = Executors.newCachedThreadPool();
        try (ServerSocket connection = new ServerSocket(port)){
            System.out.println("Server is using port " + port );
            System.out.println("Server is waiting for new client...");
            while (true){
                clientNumber ++;
                pool.execute(new ClientHandler(connection.accept() , clientNumber) );
                System.out.println("client" + clientNumber + " connected.");
                if (clientNumber >= serverCapacity){
                    System.out.println("Server capacity reach its end.");
                    break;
                }
            }
            pool.shutdown();
        } catch (IOException e) {
            System.err.println(e.toString());
        }

    }

}
