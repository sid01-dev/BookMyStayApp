public void processNextThreadSafe() {

    Reservation reservation;

    synchronized (queue) {
        reservation = queue.processNextRequest();
    }

    if (reservation == null) return;

    synchronized (inventory) {
        if (!inventory.isAvailable(reservation.getRoomType())) {
            System.out.println(Thread.currentThread().getName() +
                    " -> No rooms available");
            return;
        }

        String roomId = inventory.allocateRoom(reservation.getRoomType());

        System.out.println(Thread.currentThread().getName() +
                " -> Booked " + roomId + " for " + reservation.getGuestName());
    }
}

void main() {
}
