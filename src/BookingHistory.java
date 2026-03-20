package service;

import model.Reservation;
import java.util.ArrayList;
import java.util.List;

public class BookingHistory {

    // List to maintain order
    private List<Reservation> history = new ArrayList<>();

    // Add confirmed booking
    public void addBooking(Reservation reservation) {
        history.add(reservation);
        System.out.println("Added to history: " + reservation.getReservationId());
    }

    // Get all bookings
    public List<Reservation> getAllBookings() {
        return history;
    }

    // Display all bookings
    public void displayHistory() {
        if (history.isEmpty()) {
            System.out.println("No booking history available.");
            return;
        }

        System.out.println("\n--- Booking History ---");
        for (Reservation r : history) {
            System.out.println(r);
        }
    }
}\
