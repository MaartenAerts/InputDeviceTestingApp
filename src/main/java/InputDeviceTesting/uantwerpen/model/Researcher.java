package InputDeviceTesting.uantwerpen.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Singular;
import org.hibernate.validator.constraints.Email;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


/**
 * Created by TooLate on 3/10/2015.
 */
@Data
@Entity
@Builder
public class Researcher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String firstName;
    @NotNull
    private String lastName;
    @Email
    //@Column(unique = true)
    //@NotNull
    private String email;
    private String organization;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime modifiedDate;

    private String userName;
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
    @Singular
    private Set<Role> roles;

}