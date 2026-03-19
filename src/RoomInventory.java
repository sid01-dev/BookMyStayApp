public class Main {

    public static void main(String[] args) {

        System.out.println("Welcome to Book My Stay App");
        System.out.println("Hotel Booking System v1.0\n");

        // Create room objects
        Room r1 = new SingleRoom();
        Room r2 = new DoubleRoom();
        Room r3 = new SuiteRoom();

        // Create centralized inventory
        RoomInventory inventory = new RoomInventory();

        // Display room details + availability
        r1.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability("Single Room") + "\n");

        r2.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability("Double Room") + "\n");

        r3.displayRoomDetails();
        System.out.println("Available: " + inventory.getAvailability("Suite Room") + "\n");

        // Show full inventory
        inventory.displayInventory();
    }
}