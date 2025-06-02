public class Movie {
    String movieName;
    String duration;
    String language;
    int totalSeats;
    int availableSeats;

    Movie(String movieName,String duration,String language,int totalSeats,int availableSeats){
        this.movieName=movieName;
        this.duration=duration;
        this.language=language;
        this.totalSeats=totalSeats;
        this.availableSeats=availableSeats;
    }
    void displayMovie(){
        System.out.println("MovieName : "+movieName + " Duration :"+duration +" Language : " +language +" TotalSeats : "+totalSeats +" AvailableSeats : " +availableSeats);
    }
    static class Ticket {
        int ticketID;
        int moiveName;
        int seatNumber;
        String seatType;
        double price;

        public Ticket(int ticketID, int moiveName, int seatNumber,String seatType, double price) {
            this.ticketID = ticketID;
            this.moiveName = moiveName;
            this.seatNumber = seatNumber;
            this.seatType =seatType;
            this.price = price;
        }
        void displayTicket(){
            System.out.println("Ticket ID "+ ticketID);
            System.out.println("Movie "+ moiveName);
            System.out.println("Seat "+ seatNumber);
            System.out.println("Seat Type "+ seatType);
            System.out.println("Price "+ price);


        }
    }



}
