package auth.datalab.dbConnection.model;


import javax.persistence.*;

@Entity
@Table(name = "TS",catalog = "dvdclub")
@AssociationOverrides({
        @AssociationOverride(name="primaryKey.movie",
        joinColumns = @JoinColumn(name = "IDMovie")),
        @AssociationOverride(name = "primaryKey.contributor",
        joinColumns = @JoinColumn(name = "IDContributor"))
})
public class TS {

    @Column(length = 30)
    private String role;

    @EmbeddedId
    private TSId primaryKey;

    public TS() {
    }

    public TS(Movie m, Contributor c,String role) {
        this.role = role;
        this.primaryKey=new TSId(c,m);
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public TSId getTsId() {
        return primaryKey;
    }

    public void setTsId(TSId tsId) {
        this.primaryKey = tsId;
    }
}
