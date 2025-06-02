public class Movie {
    String movieName;
    String duration;
    String language;
    int totalSeats;
    int availableSeats;

    Movie(String movieName, String duration, String language, int totalSeats) {
        this.movieName = movieName;
        this.duration = duration;
        this.language = language;
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }
    
    void bookSeat() {
        if (availableSeats > 0) availableSeats--;
    }
    
    void cancelSeat() {
        if (availableSeats < totalSeats) availableSeats++;
    }
}

class Ticket {
    int ticketID;
    int movieIndex;
    int seatNumber;
    String seatType;
    double price;

    public Ticket(int ticketID, int movieIndex, int seatNumber, String seatType, double price) {
        this.ticketID = ticketID;
        this.movieIndex = movieIndex;
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.price = price;
    }
}
