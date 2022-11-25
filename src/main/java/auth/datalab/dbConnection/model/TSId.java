package auth.datalab.dbConnection.model;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import java.io.Serializable;

@Embeddable
public class TSId implements Serializable {

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("IDContributor")
    private Contributor contributor;

    @ManyToOne(cascade = CascadeType.ALL)
    @MapsId("IDMovie")
    private Movie movie;

    public TSId() {
    }

    public TSId(Contributor contributor, Movie movie) {
        this.contributor = contributor;
        this.movie = movie;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
