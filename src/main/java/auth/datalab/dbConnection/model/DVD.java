package auth.datalab.dbConnection.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Table(name = "DVD", catalog = "dvdclub")
@Entity
public class DVD implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="IDΤαινίας")
    private Movie movie;

    @Column(length = 4,name = "Τύπος")
    private String type;

    @Column(name = "Ποσότητα")
    private int quantity;

    @Column(name = "Τιμή")
    private int price;


    @OneToMany(mappedBy = "primaryKey.dvd",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Rent> rents = new ArrayList<>();

    public DVD(Movie movie, String type, int quantity, int price, List<Rent> rents) {
        this.movie = movie;
        this.type = type;
        this.quantity = quantity;
        this.price = price;
        this.rents = rents;
    }

    public DVD() {
    }

    public List<Rent> getRents() {
        return rents;
    }

    public void setRents(List<Rent> rents) {
        this.rents = rents;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DVD{" +
                "ID=" + ID +
                ", movie=" + movie +
                ", type='" + type + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
