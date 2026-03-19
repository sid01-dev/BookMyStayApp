class DoubleRoom extends Room {

    public DoubleRoom() {
        super("Double Room", 2, 2000);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println(type + " | Beds: " + beds + " | Price: ₹" + price);
    }
}