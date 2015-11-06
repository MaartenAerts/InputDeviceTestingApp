package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.Researcher;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Niels on 6/11/2015.
 */
public interface RoleRepo extends CrudRepository<Researcher,Long> {
}
