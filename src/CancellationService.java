package service;

import model.Reservation;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class CancellationService {

    private InventoryService inventory;
    private BookingHistory history;

    // Track reservationId → roomId
    private Map<String, String> reservationRoomMap = new HashMap<>();

    // Stack for rollback (LIFO)
    private Stack<String> rollbackStack = new Stack<>();

    public CancellationService(InventoryService inventory, BookingHistory history) {
        this.inventory = inventory;
        this.history = history;
    }

    // Call this when booking is confirmed
    public void registerBooking(String reservationId, String roomId) {
        reservationRoomMap.put(reservationId, roomId);
    }

    // Cancel booking
    public void cancelBooking(String reservationId, String roomType) {

        System.out.println("\nProcessing cancellation for: " + reservationId);

        // ✅ Validate existence
        if (!reservationRoomMap.containsKey(reservationId)) {
            System.out.println("Cancellation Failed: Reservation not found");
            return;
        }

        String roomId = reservationRoomMap.get(reservationId);

        // ✅ Push to rollback stack
        rollbackStack.push(roomId);

        try {
            // ✅ Release room (rollback inventory)
            inventory.releaseRoom(roomType, roomId);

            // ✅ Remove from history
            boolean removed = history.removeBooking(reservationId);

            if (!removed) {
                throw new RuntimeException("History inconsistency");
            }

            // ✅ Remove mapping
            reservationRoomMap.remove(reservationId);

            System.out.println("Cancellation Successful for: " + reservationId);

        } catch (Exception e) {
            System.out.println("Cancellation Failed: " + e.getMessage());
        }
    }

    public void showRollbackStack() {
        System.out.println("Rollback Stack: " + rollbackStack);
    }
}
