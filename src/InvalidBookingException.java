import static jdk.jfr.internal.JVM.isAvailable;

public String allocateRoom(String roomType) {

    if (!isAvailable(roomType)) {
        throw new RuntimeException("Inventory error: No rooms available for " + roomType);
    }

    // existing logic...
}