public synchronized void addRequest(Reservation reservation) {
    requestQueue.offer(reservation);
}

public synchronized Reservation processNextRequest() {
    return requestQueue.poll();
}

void main() {
}