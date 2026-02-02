package helpdesk;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TicketService service = new TicketService();

        while (true) {

            System.out.println("\n==============================");
            System.out.println("   HelpDeskLite Ticket System");
            System.out.println("==============================");
            System.out.println("1. Raise New Ticket");
            System.out.println("2. View All Tickets");
            System.out.println("3. Search Ticket by ID");
            System.out.println("4. Update Ticket Status");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter your name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter issue: ");
                    String issue = sc.nextLine();

                    service.raiseTicket(name, issue);
                    break;

                case 2:
                    service.viewAllTickets();
                    break;

                case 3:
                    System.out.print("Enter Ticket ID: ");
                    int id = sc.nextInt();
                    service.searchTicket(id);
                    break;

                case 4:
                    System.out.print("Enter Ticket ID: ");
                    int ticketId = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter new status (OPEN / IN_PROGRESS / CLOSED): ");
                    String status = sc.nextLine();

                    service.updateStatus(ticketId, status);
                    break;

                case 5:
                    System.out.println("Exiting HelpDeskLite... धन्यवाद!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
