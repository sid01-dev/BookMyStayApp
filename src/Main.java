import model.*;
import service.*;

public class Main {
    public static void main(String[] args) {

        BookingRequestQueue queue = new BookingRequestQueue();
        InventoryService inventory = new InventoryService();
        BookingHistory history = new BookingHistory();

        BookingService bookingService =
                new BookingService(queue, inventory, history);

        BookingReportService reportService =
                new BookingReportService(history);

        // Add requests
        queue.addRequest(new Reservation("Alice", "Deluxe"));
        queue.addRequest(new Reservation("Bob", "Standard"));
        queue.addRequest(new Reservation("Charlie", "Suite"));

        // Process bookings
        bookingService.processNext();
        bookingService.processNext();
        bookingService.processNext();

        // Show history
        history.displayHistory();

        // Generate report
        reportService.generateSummaryReport();
    }
}
