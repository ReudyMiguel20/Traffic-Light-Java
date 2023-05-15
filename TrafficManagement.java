package traffic;

import java.util.Scanner;

public class TrafficManagement {
    private int numberOfRoads;
    private int interval;
    private Scanner scanner;

    public TrafficManagement(int numberOfRoads, int interval) {
        this.numberOfRoads = numberOfRoads;
        this.interval = interval;
        this.scanner = new Scanner(System.in);
    }

    public int getNumberOfRoads() {
        return numberOfRoads;
    }

    public void addRoad() {
        this.numberOfRoads += 1;
        System.out.println("Road added");
        scanner.nextLine();
    }

    public void deleteRoad() {
        this.numberOfRoads -= 1;
        System.out.println("Road deleted");
        scanner.nextLine();
    }

    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public void openSystem() {
        System.out.println("System opened");
        scanner.nextLine();
    }

    public boolean exitSystem() {
        System.out.println("Bye!");
        return true;
    }
}
