public class Main {
    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();
        InventoryService inventory = new InventoryService();
        BookingHistory history = new BookingHistory();
        CancellationService cancelService =
                new CancellationService(inventory, history);

        BookingService bookingService =
                new BookingService(queue, inventory, history, cancelService);

        // Add multiple requests
        for (int i = 1; i <= 10; i++) {
            queue.addRequest(new Reservation("Guest-" + i, "Standard"));
        }

        // Create multiple threads
        Thread t1 = new Thread(new ConcurrentBookingProcessor(bookingService), "Thread-1");
        Thread t2 = new Thread(new ConcurrentBookingProcessor(bookingService), "Thread-2");
        Thread t3 = new Thread(new ConcurrentBookingProcessor(bookingService), "Thread-3");

        // Start threads
        t1.start();
        t2.start();
        t3.start();
    }
}


