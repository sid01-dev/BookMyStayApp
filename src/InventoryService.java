public synchronized String allocateRoom(String roomType) {

    if (!isAvailable(roomType)) {
        return null;
    }

    allocatedRooms.putIfAbsent(roomType, new HashSet<>());

    String roomId = roomType.substring(0, 3).toUpperCase() + "-" + UUID.randomUUID();

    allocatedRooms.get(roomType).add(roomId);

    // Critical section
    inventory.put(roomType, inventory.get(roomType) - 1);

    return roomId;
}

void main() {
}
