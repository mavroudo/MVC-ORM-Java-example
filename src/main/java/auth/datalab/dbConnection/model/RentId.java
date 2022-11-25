package auth.datalab.dbConnection.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

@Embeddable
public class RentId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("IDdvd")
    private DVD dvd;
    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("IDCustomer")
    private Customer customer;

    public RentId() {
    }

    public RentId(DVD dvd, Customer customer) {
        this.dvd = dvd;
        this.customer = customer;
    }

    public DVD getDvd() {
        return dvd;
    }

    public void setDvd(DVD dvd) {
        this.dvd = dvd;
    }


    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
