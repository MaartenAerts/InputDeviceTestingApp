package InputDeviceTesting.uantwerpen.model;

import javax.persistence.*;
import java.security.Permission;
import java.util.List;

/**
 * Created by TooLate on 22/10/2015.
 */
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String roleName;

    @ManyToOne
    private Researcher researcher;

    public Role() {
    }

    public Role(Long id, Researcher researcher) {

        this.id = id;
        this.researcher = researcher;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Researcher getResearcher() {
        return researcher;
    }

    public void setResearcher(Researcher researcher) {
        this.researcher = researcher;
    }

    /* private String name;
    private List<Permission> permissions;

    public Role(String name) {this.name = name;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public List<Permission> getPermissions() {return permissions;}

    public void setPermissions(List<Permission> permissions) {this.permissions = permissions;}*/
}

