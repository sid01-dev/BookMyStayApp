public class Main {
    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();
        InventoryService inventory = new InventoryService();
        BookingHistory history = new BookingHistory();

        BookingService bookingService =
                new BookingService(queue, inventory, history);

        // VALID
        queue.addRequest(new Reservation("Alice", "Deluxe"));

        // INVALID room type
        queue.addRequest(new Reservation("Bob", "Luxury"));

        // EMPTY name
        queue.addRequest(new Reservation("", "Standard"));

        // Process all
        bookingService.processNext();
        bookingService.processNext();
        bookingService.processNext();
    }
}

