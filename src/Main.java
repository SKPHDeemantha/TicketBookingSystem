import java.util.*;

public class Main {
    private static List<Movie> movies = new ArrayList<>();
    private static List<Ticket> bookedTickets = new ArrayList<>();
    private static int nextTicketId = 1;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeMovies();
        
        while (true) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline
            
            switch (choice) {
                case 1:
                    displayMovies();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    cancelTicket();
                    break;
                case 4:
                    generateReport();
                    break;
                case 5:
                    System.out.println("Exiting system. Thank you!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    static void displayMenu() {
        System.out.println("\n---Movie Ticket Booking System---");
        System.out.println("1. Display Movies");
        System.out.println("2. Book a Ticket");
        System.out.println("3. Cancel a Ticket");
        System.out.println("4. Generate Report");
        System.out.println("5. Exit");
    }

    static void initializeMovies() {
        movies.add(new Movie("The Game", "2.5 h", "English", 25));
        movies.add(new Movie("Akasa Kusum", "2.0 h", "Sinhala", 30));
    }

    static void displayMovies() {
        System.out.println("\nAvailable Movies:");
        for (int i = 0; i < movies.size(); i++) {
            Movie movie = movies.get(i);
            System.out.println((i + 1) + ". " + movie.movieName + 
                              " (" + movie.language + ") - Duration: " + movie.duration +
                              ", Available Seats: " + movie.availableSeats);
        }
    }

    static void bookTicket() {
        displayMovies();
        System.out.print("Select a movie (1-" + movies.size() + "): ");
        int movieIndex = scanner.nextInt() - 1;
        scanner.nextLine();  // Consume newline
        
        if (movieIndex < 0 || movieIndex >= movies.size()) {
            System.out.println("Invalid movie selection!");
            return;
        }

        Movie selectedMovie = movies.get(movieIndex);
        
        if (selectedMovie.availableSeats <= 0) {
            System.out.println("No available seats for this movie!");
            return;
        }

        System.out.print("Enter seat number: ");
        int seatNumber = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        
        System.out.print("Enter seat type (Regular/Premium): ");
        String seatType = scanner.nextLine();
        
        double price = seatType.equalsIgnoreCase("Premium") ? 3500.0 : 2500.0;
        
        Ticket newTicket = new Ticket(nextTicketId++, movieIndex, seatNumber, seatType, price);
        bookedTickets.add(newTicket);
        selectedMovie.bookSeat();
        
        System.out.println("\nTicket Booked Successfully!");
        System.out.println("Ticket ID: " + newTicket.ticketID);
        System.out.println("Movie: " + selectedMovie.movieName);
        System.out.println("Seat: " + seatNumber + " (" + seatType + ")");
        System.out.println("Price: $" + price);
    }

    static void cancelTicket() {
        System.out.print("Enter Ticket ID to cancel: ");
        int ticketId = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        
        Ticket ticketToCancel = null;
        for (Ticket ticket : bookedTickets) {
            if (ticket.ticketID == ticketId) {
                ticketToCancel = ticket;
                break;
            }
        }

        if (ticketToCancel == null) {
            System.out.println("Ticket not found!");
            return;
        }

        Movie movie = movies.get(ticketToCancel.movieIndex);
        movie.cancelSeat();
        bookedTickets.remove(ticketToCancel);
        
        System.out.println("Ticket #" + ticketId + " canceled successfully!");
        System.out.println("Refund amount: $" + ticketToCancel.price);
    }

    static void generateReport() {
        double totalRevenue = 0;
        for (Ticket ticket : bookedTickets) {
            totalRevenue += ticket.price;
        }

        System.out.println("\n--- Booking Report ---");
        System.out.println("Tickets Sold: " + bookedTickets.size());
        System.out.println("Total Revenue: $" + totalRevenue);
        System.out.println("\nMovie-wise Availability:");
        
        for (Movie movie : movies) {
            System.out.println("- " + movie.movieName + ": " + 
                              movie.availableSeats + "/" + movie.totalSeats + " seats available");
        }
    }
}