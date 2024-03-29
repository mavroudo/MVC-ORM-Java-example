package auth.datalab.dbConnection.model;



import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Table(name = "ΠΕΛΑΤΗΣ", catalog = "dvdclub")
@Entity
public class Customer implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(length = 30, nullable = false, name = "Επίθετο")
    private String surname;

    @Column(length = 30, name = "Τηλέφωνο")
    private String phone;

    @Column(length = 30, name = "Οδός")
    private String address;

    @Column(length = 10, name = "Αριθμός")
    private String number;

    @OneToMany(mappedBy = "primaryKey.customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rent> rents;

    public Customer() {
    }

    public Customer(String surname, String phone, String address, String number) {
        this.surname = surname;
        this.phone = phone;
        this.address = address;
        this.number = number;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getSurname() {
        return surname;
    }

    public List<Rent> getRents() {
        return rents;
    }


    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
