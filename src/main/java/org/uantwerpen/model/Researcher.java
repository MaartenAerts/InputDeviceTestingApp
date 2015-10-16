package org.uantwerpen.model;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.time.LocalDateTime;


/**
 * Created by TooLate on 3/10/2015.
 */
@Entity
@DynamicUpdate
public class Researcher implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    @Email
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

        if (!getId().equals(that.getId())) return false;
        if (!getFirstName().equals(that.getFirstName())) return false;
        if (!getLastName().equals(that.getLastName())) return false;
        if (!getEmail().equals(that.getEmail())) return false;
        return getOrganization().equals(that.getOrganization());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getFirstName().hashCode();
        result = 31 * result + getLastName().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getOrganization().hashCode();
        return result;
    }
}
