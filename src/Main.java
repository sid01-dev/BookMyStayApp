import model.*;
import service.*;

public class Main {
    public static void main(String[] args) {

        PersistenceService persistence = new PersistenceService();

        // 🔄 Load previous state
        SystemState state = persistence.loadState();

        InventoryService inventory;
        BookingHistory history;

        if (state != null) {
            inventory = state.getInventory();
            history = state.getHistory();
        } else {
            inventory = new InventoryService();
            history = new BookingHistory();
        }

        BookingRequestQueue queue = new BookingRequestQueue();
        CancellationService cancelService =
                new CancellationService(inventory, history);

        BookingService bookingService =
                new BookingService(queue, inventory, history, cancelService);

        // Add booking
        queue.addRequest(new Reservation("Alice", "Deluxe"));
        bookingService.processNext();

        history.displayHistory();
        inventory.printStatus();

        // 💾 Save before exit
        persistence.saveState(new SystemState(inventory, history));
    }
}
