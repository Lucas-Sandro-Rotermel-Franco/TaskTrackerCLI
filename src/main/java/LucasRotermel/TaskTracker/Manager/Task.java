package LucasRotermel.TaskTracker.Manager;

public class Task {
    private int id;
    private String description;
    private String status;
    private String dtCreated;
    private String dtUpdated;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDtCreated() {
        return dtCreated;
    }

    public void setDtCreated(String dtCreated) {
        this.dtCreated = dtCreated;
    }

    public String getDtUpdated() {
        return dtUpdated;
    }

    public void setDtUpdated(String dtUpdated) {
        this.dtUpdated = dtUpdated;
    }

    @Override
    public String toString() {
        return "{\"id\": \"" + id + "\", \"description\": \"" + description + "\", \"status\": \"" + status + "\", \"createdAt\": \"" + dtCreated + "\", \"updatedAt\": \"" + dtUpdated + "\"}\n";
    }
}
