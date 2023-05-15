package traffic;

import java.io.IOException;
import java.util.Scanner;

public class UserInterface {

    private TrafficManagement trafficManagement;
    private static Scanner scanner;

    public UserInterface(TrafficManagement trafficManagement) {
        this.trafficManagement = trafficManagement;
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        boolean isUserDone = false;
        while (!isUserDone) {
        try {



                printMenu();
                int userInput = Integer.parseInt(scanner.nextLine());

                switch (userInput) {
                    case 1 -> {
                        this.trafficManagement.addRoad();
                        clearConsole();
                    }
                    case 2 -> {
                        this.trafficManagement.deleteRoad();
                    }
                    case 3 -> {
                        this.trafficManagement.openSystem();
                    }
                    case 0 -> {
                        isUserDone = this.trafficManagement.exitSystem();
                    }
                    default -> {
                        incorrectOption();
                    }
                }

        }
        catch (NumberFormatException e) {
            incorrectOption();
        }
        }

    }

    public static void printMenu() {
        System.out.println("""
                Menu:
                1. Add road
                2. Delete road
                3. Open system
                0. Quit""");
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        }
        catch (IOException | InterruptedException e) {}
    }

    public static void incorrectOption() {
        System.out.println("Incorrect option");
        scanner.nextLine();
    }
}


