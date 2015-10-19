package org.uantwerpen.model;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Created by TooLate on 3/10/2015.
 */
@Entity
@DynamicUpdate
public class Researcher extends AbstractEntity implements Serializable {

    private String firstName;
    private String lastName;
    @Email
    @Column(unique = true)
    @NotNull
    private String email;
    private String organization;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    public Researcher(String firstName, String lastName, String email, String organization, LocalDateTime createdDate, LocalDateTime modifiedDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.organization = organization;
        this.createdDate = createdDate;
        this.modifiedDate = modifiedDate;
    }

    public Researcher() {
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Researcher that = (Researcher) o;

        if (getId() != (that.getId())) return false;
        if (!getFirstName().equals(that.getFirstName())) return false;
        if (!getLastName().equals(that.getLastName())) return false;
        if (!getEmail().equals(that.getEmail())) return false;
        return getOrganization().equals(that.getOrganization());

    }

    @Override
    public int hashCode() {

        int result = (int) (getId() ^ (getId() >>> 32));

        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getOrganization().hashCode();
        return result;
    }
}
