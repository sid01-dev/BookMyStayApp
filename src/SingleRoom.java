class SingleRoom extends Room {

    public SingleRoom() {
        super("Single Room", 1, 1000);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println(type + " | Beds: " + beds + " | Price: ₹" + price);
    }
}