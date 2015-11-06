package InputDeviceTesting.uantwerpen.model;

import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

/**
 * Created by TooLate on 22/10/2015.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roleName;


    @ManyToMany
    private Set<Researcher> researchers;


    public Role(String roleName) {

        this.roleName = roleName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Set<Researcher> getResearchers() {
        return researchers;
    }

    public void setResearchers(Set<Researcher> researchers) {
        this.researchers = researchers;
    }

    public String getRoleName() {return roleName;}

    public void setRoleName(String roleName) {this.roleName = roleName;}


    /* private String name;
    private List<Permission> permissions;

    public Role(String name) {this.name = name;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public List<Permission> getPermissions() {return permissions;}

    public void setPermissions(List<Permission> permissions) {this.permissions = permissions;}*/
}

