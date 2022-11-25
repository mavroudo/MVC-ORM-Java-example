package auth.datalab.dbConnection.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="rent",catalog = "dvdclub")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.customer",
        joinColumns = @JoinColumn(name = "IDCustomer")),
        @AssociationOverride(name = "primaryKey.dvd",
        joinColumns = @JoinColumn(name = "IDdvd"))
})
public class Rent implements Serializable {

    @Column(nullable = false)
    private Date start;

    private Date end;




    @EmbeddedId
    private RentId primaryKey = new RentId();

    public RentId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(RentId primaryKey) {
        this.primaryKey = primaryKey;
    }

    @Transient
    public Customer getCustomer(){
        return getPrimaryKey().getCustomer();
    }
    @Transient
    public DVD getDvd(){
        return getPrimaryKey().getDvd();
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

}
