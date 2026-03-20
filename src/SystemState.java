package model;

import service.InventoryService;
import service.BookingHistory;

import java.io.Serializable;

public class SystemState implements Serializable {

    private static final long serialVersionUID = 1L;

    private InventoryService inventory;
    private BookingHistory bookingHistory;

    // Constructor
    public SystemState(InventoryService inventory, BookingHistory bookingHistory) {
        this.inventory = inventory;
        this.bookingHistory = bookingHistory;
    }

    // Getters
    public InventoryService getInventory() {
        return inventory;
    }

    public BookingHistory getBookingHistory() {
        return bookingHistory;
    }
}


