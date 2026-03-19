/**
 * Book My Stay App - Use Case 2
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");
        System.out.println("Hotel Booking System v1.0\n");

        // Create room objects (Polymorphism)
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        // Static availability
        int singleAvailable = 5;
        int doubleAvailable = 3;
        int suiteAvailable = 2;

        // Display details
        r1.displayRoomDetails();
        System.out.println("Available: " + singleAvailable + "\n");

        r2.displayRoomDetails();
        System.out.println("Available: " + doubleAvailable + "\n");

        r3.displayRoomDetails();
        System.out.println("Available: " + suiteAvailable);
    }
}
