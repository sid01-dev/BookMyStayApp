/**
 * Abstract Room class
 */
abstract class Room {
    protected String type;
    protected int beds;
    protected double price;

    // Constructor
    public Room(String type, int beds, double price) {
        this.type = type;
        this.beds = beds;
        this.price = price;
    }

    // Abstract method
    public abstract void displayRoomDetails();
}