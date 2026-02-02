package helpdesk;

public class Ticket {

    private int ticketId;
    private String userName;
    private String issue;
    private String status;

    public Ticket(int ticketId, String userName, String issue) {
        this.ticketId = ticketId;
        this.userName = userName;
        this.issue = issue;
        this.status = "OPEN";
    }

    public int getTicketId() {
        return ticketId;
    }

    public String getUserName() {
        return userName;
    }

    public String getIssue() {
        return issue;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String newStatus) {
        this.status = newStatus;
    }

    @Override
    public String toString() {
        return "Ticket ID: " + ticketId +
                " | User: " + userName +
                " | Issue: " + issue +
                " | Status: " + status;
    }
}
