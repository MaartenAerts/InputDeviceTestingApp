package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Niels on 23/10/2015.
 */
@Repository
public interface RoleRepo extends CrudRepository<Role,Long> {
}
