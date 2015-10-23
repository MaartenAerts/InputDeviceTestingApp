package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * Created by Niels on 23/10/2015.
 */
@RepositoryRestResource
public interface RoleRepo extends CrudRepository<Role,Long> {
}
