package InputDeviceTesting.uantwerpen.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Set;


/**
 * Created by TooLate on 3/10/2015.
 */

@Entity
public class Researcher implements Serializable, Comparable<Researcher> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String firstName;
    private String lastName;

    private String organization;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    @Email
    @NotNull
    @Column(unique = true)
    private String email;
    @NotNull
    private String password;

    @ManyToMany(mappedBy = "researchers")
    private List<Role> roles;


    public Researcher() {

    }

    public Researcher(String email, String password) {
        this.email=email;
        this.password=password;
    }
    public Researcher(String email, String password,String firstName, String lastName, String organization, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.email=email;
        this.password=password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.organization = organization;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Researcher that = (Researcher) o;

        if (getId() != that.getId()) return false;
        if (getFirstName() != null ? !getFirstName().equals(that.getFirstName()) : that.getFirstName() != null)
            return false;
        if (getLastName() != null ? !getLastName().equals(that.getLastName()) : that.getLastName() != null)
            return false;
        if (getOrganization() != null ? !getOrganization().equals(that.getOrganization()) : that.getOrganization() != null)
            return false;
        if (getCreatedDate() != null ? !getCreatedDate().equals(that.getCreatedDate()) : that.getCreatedDate() != null)
            return false;
        if (getModifiedDate() != null ? !getModifiedDate().equals(that.getModifiedDate()) : that.getModifiedDate() != null)
            return false;
        if (!getEmail().equals(that.getEmail())) return false;
        if (!getPassword().equals(that.getPassword())) return false;
        return (!(getRoles() != null ? !getRoles().equals(that.getRoles()) : that.getRoles() != null));

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getOrganization() != null ? getOrganization().hashCode() : 0);
        result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
        result = 31 * result + (getModifiedDate() != null ? getModifiedDate().hashCode() : 0);
        result = 31 * result + (getEmail() != null ? getEmail().hashCode() : 0);
        result = 31 * result + (getPassword() != null ? getPassword().hashCode(): 0);
        result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Researcher:[ Id = " + this.id + " firstName = " + this.firstName + " lastName = " + this.lastName + " email = " + this.email
                + "organization = " + this.organization + " ]";
    }

    public static Comparator<Researcher> ResearcherNameComparator
            = new Comparator<Researcher>() {

        public int compare(Researcher researcher1, Researcher researcher2) {

            String ReName1 = researcher1.getFirstName().toUpperCase();
            String ReName2 = researcher2.getFirstName().toUpperCase();

            //ascending order
            return ReName1.compareTo(ReName2);

            //descending order
            //return fruitName2.compareTo(fruitName1);
        }

    };

    @Override
    public int compareTo(Researcher o) {
        long compareQuantity = ((Researcher) o).getId();


        //ascending order
        return (int)this.id - (int)compareQuantity;

        //descending order
        //return compareQuantity - this.quantity;
    }
}