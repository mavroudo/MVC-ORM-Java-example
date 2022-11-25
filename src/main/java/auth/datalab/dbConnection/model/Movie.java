package auth.datalab.dbConnection.model;

import javax.persistence.*;
import java.io.Serializable;

@Table(name = "Movie", catalog = "dvdclub")
@Entity
public class Movie implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;

    @Column(length = 100)
    private String title;

    private int year;

    public Movie(int ID, String title, int year) {
        this.ID = ID;
        this.title = title;
        this.year = year;
    }

    public Movie(String title, int year) {
        this.title = title;
        this.year = year;
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
