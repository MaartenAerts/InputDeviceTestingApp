package InputDeviceTesting.uantwerpen.model;

import java.security.Permission;
import java.util.List;

/**
 * Created by TooLate on 22/10/2015.
 */
public class Role {
    private String name;
    private List<Permission> permissions;

    public Role(String name) {this.name = name;}

    public String getName() {return name;}
    public void setName(String name) {this.name = name;}

    public List<Permission> getPermissions() {return permissions;}

    public void setPermissions(List<Permission> permissions) {this.permissions = permissions;}
}

