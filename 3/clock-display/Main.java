package com.company;


public class Main {

    public static void main(String[] args) throws InterruptedException {
	// write your code here
        ClockDisplay clockDisplay = new ClockDisplay();
        while (true)
        {
            Thread.sleep(1000);
            clockDisplay.timeTick();
            System.out.print("\033[H\033[2J");
            System.out.flush();
            System.out.println(clockDisplay.getTime());
        }
    }

}
