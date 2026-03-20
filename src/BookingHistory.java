public boolean removeBooking(String reservationId) {
    return history.removeIf(r -> r.getReservationId().equals(reservationId));
}

void main() {
}