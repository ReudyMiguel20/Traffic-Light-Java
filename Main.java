package traffic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInterface UI = new UserInterface(startingTraffic());
        UI.start();
    }

    public static TrafficManagement startingTraffic() {
        Scanner scanner = new Scanner(System.in);
        int numberOfRoads = 0;
        int interval = 0;

        //Asking user for values
        System.out.println("Welcome to the traffic management system!");
        System.out.println("Input the number of roads: ");

        //Handling exceptions here and checking that value is not negative integer
        while (numberOfRoads <= 0) {
            try {
                numberOfRoads = Integer.parseInt(scanner.nextLine());
                if (numberOfRoads >= 1) {
                    break;
                }
                System.out.println("Error! Incorrect Input. Try Again:");
            } catch (NumberFormatException e) {
                System.out.println("Error! Incorrect Input. Try Again:");
            }
        }

        //Handling exceptions here and checking that value is not negative integer
        System.out.println("Input the interval: ");
        while (interval <= 0) {
            try {
                interval = Integer.parseInt(scanner.nextLine());
                if (interval >= 1) {
                    break;
                }
                System.out.println("Error! Incorrect Input. Try Again:");
            } catch (NumberFormatException e) {
                System.out.println("Error! Incorrect Input. Try Again:");
            }
        }

        //Initializing new TrafficManagement object with the user values
        return new TrafficManagement(numberOfRoads, interval);
    }


}
