package auth.datalab.dbConnection.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="ΕΝΟΙΚΙΑΣΗ",catalog = "dvdclub")
@AssociationOverrides({
        @AssociationOverride(name = "primaryKey.customer",
        joinColumns = @JoinColumn(name = "IDΠελάτη")),
        @AssociationOverride(name = "primaryKey.dvd",
        joinColumns = @JoinColumn(name = "IDdvd"))
})
public class Rent implements Serializable {

    @Column(nullable = false, name = "Από")
    private Date start;

    @Column(name = "Έως")
    private Date end;


    public Rent() {
    }

    public Rent(Customer c, DVD d, Date start, Date end) {
        this.start = start;
        this.end = end;
        this.primaryKey=new RentId(d,c);
    }

    @EmbeddedId
    private RentId primaryKey = new RentId();

    public RentId getPrimaryKey() {
        return primaryKey;
    }

    public void setPrimaryKey(RentId primaryKey) {
        this.primaryKey = primaryKey;
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
