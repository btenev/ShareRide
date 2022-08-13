package softuni.bg.model.dto;

public class DataDto {
    private String registeredUsers;
    private String publishedRides;

    public String getRegisteredUsers() {
        return registeredUsers;
    }

    public DataDto setRegisteredUsers(String registeredUsers) {
        this.registeredUsers = registeredUsers;
        return this;
    }

    public String getPublishedRides() {
        return publishedRides;
    }

    public DataDto setPublishedRides(String publishedRides) {
        this.publishedRides = publishedRides;
        return this;
    }
}
