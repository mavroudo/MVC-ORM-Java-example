package auth.datalab.dbConnection.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Table(name = "ΣΥΝΤΕΛΕΣΤΗΣ", catalog = "dvdclub")
@Entity
public class Contributor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(length = 50,name = "Όνομα")
    private String name;

    @OneToMany(mappedBy = "primaryKey.contributor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<TS> tsList = new ArrayList<>( );

    public List<TS> getTsList() {
        return tsList;
    }

    public void setTsList(List<TS> tsList) {
        this.tsList = tsList;
    }

    public Contributor() {
    }

    public Contributor(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
