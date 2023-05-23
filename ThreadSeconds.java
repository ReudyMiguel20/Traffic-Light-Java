package traffic;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class ThreadSeconds extends Thread {
    private int counter = 0;
    private Scanner scanner;
    private boolean inSystemState;

    public ThreadSeconds() {
        this.counter = 0;
        this.scanner = new Scanner(System.in);
//        this.inSystemState = false;
    }

    @Override
    public void run() {

        this.counter++;
        if (!inSystemState){
            return;
        }
        getSystemInfo();

//        while (true) {
//            this.counter++;
//            try {
//                Thread.sleep(1000); // Wait for 1 second
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
    }


    public void showCounter(int numberOfRoads, int interval) throws IOException {
        int counter = this.counter;
        Console console = System.console();

        while (true) {
            if (console != null && console.reader().ready() && console.readLine().isEmpty()) {
                return; // Exit the loop if the user pressed Enter
            }
            try {
                counter++;
                if (System.in.available() > 0 && scanner.nextLine().isEmpty()) {
                    return;// Exit the loop if the user pressed Enter

                }
                clearConsole();
                System.out.printf("\r! %ds. have passed since system startup !\n", counter);
                System.out.print("! Number of roads: " + numberOfRoads + " !\n");
                System.out.print("! Interval: " + interval + " !\n");
                System.out.print("! Press \"Enter\" to open menu !\n");
                Thread.sleep(1000);
                if (System.in.available() > 0 && scanner.nextLine().isEmpty()) {
                    return;  // Exit the loop if the user pressed Enter
                }// Wait for 1 second
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void setInSystemState(boolean inSystemState) {
        this.inSystemState = inSystemState;
    }

//    public void returnCounter() {
////        System.out.println("! " + this.counter + "s. have passed since system startup !");
//
//        for (int counter = this.counter; ; counter++) {
//            try {
//                String userInput = "2345";
//                System.out.println("! " + counter + "s. have passed since system startup !");
//                System.out.println("! Number of roads: " + " !");
//                System.out.println("! Interval: " + " !");
//                System.out.println("! Press \"Enter\" to open menu !");
//                Thread.sleep(1000);
//                if (scanner.next().equals("")) {
//                    break;
//                } else {
//                    Thread.sleep(1000);
//                }
//            } catch (InterruptedException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }

    String getSystemInfo() {
        return """
                ! %ds. have passed since system startup !
                ! Number of roads: %d !
                ! Interval: %d !
                ! Press "Enter" to open menu !"""
                .formatted(this.counter, 5, 5);
    }

//    private class DisplayTask extends ThreadSeconds {
//
//        @Override
//        public void run() {
//            this.counter++;
//            if (!inSystemState) {
//                return;
//            }
//            printer.clear();
//            printer.printInfo(getSystemInfo());
//        }
//    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException e) {
        }
    }

}
//}

