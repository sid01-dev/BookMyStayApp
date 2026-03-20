public void releaseRoom(String roomType, String roomId) {

    if (!allocatedRooms.containsKey(roomType) ||
            !allocatedRooms.get(roomType).contains(roomId)) {
        throw new RuntimeException("Invalid rollback: Room not found");
    }

    // Remove from allocated set
    allocatedRooms.get(roomType).remove(roomId);

    // Restore inventory
    inventory.put(roomType, inventory.get(roomType) + 1);

    System.out.println("Room released: " + roomId);
}

void main() {
}