package com.company;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server implements Runnable{
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


    public synchronized void notifyAddNewClient(){
        notify();
    }

    /**
     * Start server
     */
    @Override
    public synchronized void run() {
        clientNumber = 0;
        ExecutorService pool = Executors.newCachedThreadPool();
        try (ServerSocket connection = new ServerSocket(port)){
            System.out.println("Server is using port " + port );
            System.out.println("Server is waiting for new client...");
            while (true){
                clientNumber ++;
                pool.execute(new ClientHandler(connection.accept() , clientNumber, this) );
                System.out.println("client" + clientNumber + " connected.");
                if (clientNumber >= serverCapacity) {
                    wait();
                }
            }
        } catch (IOException e) {
            System.err.println(e.toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
