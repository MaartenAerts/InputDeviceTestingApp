package InputDeviceTesting.uantwerpen.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by TooLate on 22/10/2015.
 */
@Entity
public class Role implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "ROLE_ID")
    private Long id;

    private String roleName;

    @ManyToMany(mappedBy="roles")
    private List<Researcher> researchers = new ArrayList<Researcher>();

    public Role() {

    }

    public Role(String roleName) {

        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {return roleName;}

    public void setRoleName(String roleName) {this.roleName = roleName;}

    public List<Researcher> getResearchers() {
        return researchers;
    }

    public void setResearchers(List<Researcher> researchers) {
        this.researchers = researchers;
    }
}

