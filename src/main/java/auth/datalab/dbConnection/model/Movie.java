package auth.datalab.dbConnection.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Table(name = "Movie", catalog = "dvdclub")
@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(length = 100)
    private String title;

    private int year;

    @OneToMany(mappedBy = "primaryKey.movie",cascade = CascadeType.ALL)
    private List<TS> tsList= new ArrayList<>();

    public List<TS> getTsList() {
        return tsList;
    }

    public void setTsList(List<TS> tsList) {
        this.tsList = tsList;
    }

    public Movie() {
    }

    public Movie(String title, int year, List<TS> tsList) {
        this.title = title;
        this.year = year;
        this.tsList = tsList;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", year=" + year +
                '}';
    }
}
