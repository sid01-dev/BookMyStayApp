package service;

import exception.InvalidBookingException;
import model.Reservation;

import java.util.Set;

public class BookingValidator {

    private static final Set<String> VALID_ROOM_TYPES =
            Set.of("Standard", "Deluxe", "Suite");

    public static void validate(Reservation reservation, InventoryService inventory) {

        // Validate guest name
        if (reservation.getGuestName() == null || reservation.getGuestName().isEmpty()) {
            throw new InvalidBookingException("Guest name cannot be empty");
        }

        // Validate room type
        if (!VALID_ROOM_TYPES.contains(reservation.getRoomType())) {
            throw new InvalidBookingException("Invalid room type: " + reservation.getRoomType());
        }

        // Validate availability
        if (!inventory.isAvailable(reservation.getRoomType())) {
            throw new InvalidBookingException(
                    "No rooms available for type: " + reservation.getRoomType()
            );
        }
    }
}
