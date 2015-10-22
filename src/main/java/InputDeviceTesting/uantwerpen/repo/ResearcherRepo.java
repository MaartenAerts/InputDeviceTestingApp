package InputDeviceTesting.uantwerpen.repo;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import InputDeviceTesting.uantwerpen.model.Researcher;

import java.util.List;


/**
 * Created by TooLate on 10/10/2015.
 */
@RepositoryRestResource
public interface ResearcherRepo extends JpaRepository<Researcher,Long> {
    List<Researcher> findByLastName(@Param("lastName") String lastName);
    Researcher findByUserName(String username);
}
