package service;

import model.Reservation;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookingReportService {

    private BookingHistory history;

    public BookingReportService(BookingHistory history) {
        this.history = history;
    }

    // Generate summary report
    public void generateSummaryReport() {
        List<Reservation> bookings = history.getAllBookings();

        System.out.println("\n--- Booking Summary Report ---");

        if (bookings.isEmpty()) {
            System.out.println("No data available.");
            return;
        }

        System.out.println("Total Bookings: " + bookings.size());

        // Count by room type
        Map<String, Integer> roomTypeCount = new HashMap<>();

        for (Reservation r : bookings) {
            roomTypeCount.put(
                    r.getRoomType(),
                    roomTypeCount.getOrDefault(r.getRoomType(), 0) + 1
            );
        }

        System.out.println("Bookings by Room Type:");
        for (Map.Entry<String, Integer> entry : roomTypeCount.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
