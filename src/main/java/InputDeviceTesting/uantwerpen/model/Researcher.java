package InputDeviceTesting.uantwerpen.model;

import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;


/**
 * Created by TooLate on 3/10/2015.
 */

@Entity
public class Researcher implements Serializable {

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

    //@ManyToMany
    /*@JoinTable(
            name = "USER_ROLE",
            joinColumns = {@JoinColumn(name = "USER_ID",
                                        referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "ROLE_ID",
                                                referencedColumnName = "ID")}
    )*/
    @OneToMany(mappedBy = "researcher")
    private Set<Role> roles;

    public Researcher() {

    }
    public Researcher(String email, String password) {
        this.email=email;
        this.password=password;
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

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
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
        return !(getRoles() != null ? !getRoles().equals(that.getRoles()) : that.getRoles() != null);

    }

    @Override
    public int hashCode() {
        int result = (int) (getId() ^ (getId() >>> 32));
        result = 31 * result + (getFirstName() != null ? getFirstName().hashCode() : 0);
        result = 31 * result + (getLastName() != null ? getLastName().hashCode() : 0);
        result = 31 * result + (getOrganization() != null ? getOrganization().hashCode() : 0);
        result = 31 * result + (getCreatedDate() != null ? getCreatedDate().hashCode() : 0);
        result = 31 * result + (getModifiedDate() != null ? getModifiedDate().hashCode() : 0);
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getPassword().hashCode();
        result = 31 * result + (getRoles() != null ? getRoles().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "TestSubject:[ Id = " + this.id + " firstName = " + this.firstName + " lastName = " + this.lastName + " email = " + this.email
                + "organization = " + this.organization + " ]";
    }
}