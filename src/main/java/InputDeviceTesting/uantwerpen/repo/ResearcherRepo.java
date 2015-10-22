package InputDeviceTesting.uantwerpen.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import InputDeviceTesting.uantwerpen.model.Researcher;


/**
 * Created by TooLate on 10/10/2015.
 */
@RepositoryRestResource
public interface ResearcherRepo extends CrudRepository<Researcher,Long> {


}
