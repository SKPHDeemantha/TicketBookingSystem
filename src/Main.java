import java.util.Scanner;
public class Main {
    void  displayList(){

        System.out.println("---Movie Ticket Booking System---");
        System.out.println("1. Display a Movie");
        System.out.println("2. Book a Ticket");
        System.out.println("3. Cancel a Ticket");
        System.out.println("4. Generate Report");
        System.out.println("5. Exit");

    }
    public static void main(String[]args){
        Scanner scanner=new Scanner(System.in);
        Main main=new Main();

        main.displayList();
        System.out.println("Enter your choice : ");
        int userInput= scanner.nextInt();

        if (userInput==1) {

            System.out.println(" ");
            Movie movie1 = new Movie("The Game", "2.5 h", "English", 25, 20);
            Movie movie2 = new Movie("The Game", "2.5 h", "English", 25, 20);
            movie1.displayMovie();
            movie2.displayMovie();

        } else if (userInput==2) {
            System.out.println("Available Movies");
            System.out.println("1. The Game");
            System.out.println("2. Akasa kusum");
            System.out.println("Select a movie (1 or 2)");
            int selectMovie= scanner.nextInt();
            System.out.println("Enter  seat Number :");
            int selectSeatNumbers= scanner.nextInt();
            System.out.println("Enter seat Type (Regular/Premium) :");
            String selectSeatType=scanner.nextLine();

            System.out.println("Ticket Booked");
            Movie.Ticket ticket=new Movie.Ticket(1,selectMovie,selectSeatNumbers,selectSeatType,2500);

        } else if (userInput==3) {
            System.out.println("Enter The ticket ID :");
            int selectTicketId = scanner.nextInt();

        } else if(userInput==4) {
            System.out.println("Booking Summery :");
            System.out.println("Ticket sold :");
            System.out.println("Total revenue : $");

        }


    }

}

