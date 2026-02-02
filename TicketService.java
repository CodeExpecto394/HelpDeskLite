package helpdesk;

import java.io.*;
import java.util.*;

public class TicketService {

    private ArrayList<Ticket> ticketList = new ArrayList<>();
    private int ticketCounter = 1001;

    private final String FILE_NAME = "tickets.txt";

    public TicketService() {
        loadTicketsFromFile();
    }

    // Add New Ticket
    public void raiseTicket(String userName, String issue) {
        Ticket ticket = new Ticket(ticketCounter++, userName, issue);
        ticketList.add(ticket);
        saveTicketsToFile();
        System.out.println("✅ Ticket Raised Successfully!");
        System.out.println(ticket);
    }

    // View All Tickets
    public void viewAllTickets() {
        if (ticketList.isEmpty()) {
            System.out.println("No tickets available.");
            return;
        }

        System.out.println("\n📌 All Tickets:");
        for (Ticket ticket : ticketList) {
            System.out.println(ticket);
        }
    }

    // Search Ticket by ID
    public void searchTicket(int id) {
        for (Ticket ticket : ticketList) {
            if (ticket.getTicketId() == id) {
                System.out.println("🎯 Ticket Found:");
                System.out.println(ticket);
                return;
            }
        }
        System.out.println("❌ Ticket Not Found!");
    }

    // Update Ticket Status
    public void updateStatus(int id, String newStatus) {
        for (Ticket ticket : ticketList) {
            if (ticket.getTicketId() == id) {
                ticket.setStatus(newStatus);
                saveTicketsToFile();
                System.out.println("✅ Status Updated Successfully!");
                return;
            }
        }
        System.out.println("❌ Ticket Not Found!");
    }

    // Save Tickets to File
    private void saveTicketsToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {

            for (Ticket ticket : ticketList) {
                writer.write(ticket.getTicketId() + "," +
                        ticket.getUserName() + "," +
                        ticket.getIssue() + "," +
                        ticket.getStatus());
                writer.newLine();
            }

        } catch (IOException e) {
            System.out.println("Error saving tickets.");
        }
    }

    // Load Tickets from File
    private void loadTicketsFromFile() {
        File file = new File(FILE_NAME);

        if (!file.exists())
            return;

        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {

            String line;
            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");
                Ticket ticket = new Ticket(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2]
                );

                ticket.setStatus(parts[3]);
                ticketList.add(ticket);

                ticketCounter = Math.max(ticketCounter, ticket.getTicketId() + 1);
            }

        } catch (IOException e) {
            System.out.println("Error loading tickets.");
        }
    }
}
