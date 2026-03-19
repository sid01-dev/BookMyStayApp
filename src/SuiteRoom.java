class SuiteRoom extends Room {

    public SuiteRoom() {
        super("Suite Room", 3, 5000);
    }

    @Override
    public void displayRoomDetails() {
        System.out.println(type + " | Beds: " + beds + " | Price: ₹" + price);
    }
}