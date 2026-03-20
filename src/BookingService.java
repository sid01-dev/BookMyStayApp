import exception.InvalidBookingException;

public void processNext() {

    Reservation reservation = queue.processNextRequest();

    if (reservation == null) {
        System.out.println("No requests to process");
        return;
    }

    try {
        // ✅ VALIDATION (Fail-Fast)
        service.BookingValidator.validate(reservation, inventory);

        String roomId = inventory.allocateRoom(reservation.getRoomType());

        System.out.println("Booking Confirmed!");
        System.out.println("Guest: " + reservation.getGuestName());
        System.out.println("Room ID: " + roomId);

        // existing history logic (Use Case 8)
        bookingHistory.addBooking(reservation);

    } catch (InvalidBookingException e) {
        // ✅ Graceful failure
        System.out.println("Booking Failed: " + e.getMessage());
    } catch (Exception e) {
        System.out.println("Unexpected error: " + e.getMessage());
    }
}

void main() {
}
