package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Server server = new Server ( 8888 , 3);
        Thread serverT = new Thread(server);
        serverT.start();

    }
}
