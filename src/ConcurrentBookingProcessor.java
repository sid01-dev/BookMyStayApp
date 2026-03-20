package service;

public class ConcurrentBookingProcessor implements Runnable {

    private BookingService bookingService;

    public ConcurrentBookingProcessor(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public void run() {
        bookingService.processNextThreadSafe();
    }
}
