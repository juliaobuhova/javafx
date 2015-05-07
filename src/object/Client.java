package object;

public class Client {
    private int idNumber;
    private String firstName;
    private String lastName;

    public Client(int idNumber, String firstName, String lastName) {
        this.setIdNumber(idNumber);
        this.setFirstName(firstName);
        this.setLastName(lastName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Client client = (Client) o;

        if (idNumber != client.idNumber) return false;
        if (firstName != null ? !firstName.equals(client.firstName) : client.firstName != null) return false;
        return !(lastName != null ? !lastName.equals(client.lastName) : client.lastName != null);

    }

    @Override
    public int hashCode() {
        int result = idNumber;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "object.Client{" +
                "idNumber=" + idNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
