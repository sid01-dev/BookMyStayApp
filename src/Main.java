public class Main {
    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();
        InventoryService inventory = new InventoryService();
        BookingHistory history = new BookingHistory();
        CancellationService cancelService =
                new CancellationService(inventory, history);

        BookingService bookingService =
                new BookingService(queue, inventory, history, cancelService);

        // Add bookings
        Reservation r1 = new Reservation("Alice", "Deluxe");
        Reservation r2 = new Reservation("Bob", "Standard");

        queue.addRequest(r1);
        queue.addRequest(r2);

        // Confirm bookings
        bookingService.processNext();
        bookingService.processNext();

        history.displayHistory();

        // Cancel one booking
        cancelService.cancelBooking(r1.getReservationId(), r1.getRoomType());

        // Show updated state
        history.displayHistory();
        inventory.printStatus();
        cancelService.showRollbackStack();
    }
}

