package object;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Client {
    private SimpleIntegerProperty idNumber;
    private SimpleStringProperty firstName;
    private SimpleStringProperty lastName;

    public Client () {}

    public Client(int iNumber, String fName, String lName) {
        this.idNumber = new SimpleIntegerProperty(iNumber);
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);

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
        int result = idNumber != null ? idNumber.hashCode() : 0;
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
        return idNumber.get();
    }

    public void setIdNumber(int iNumber) {
        idNumber.set(iNumber);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String lName) {
        lastName.set(lName);
    }

}
