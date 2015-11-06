package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;


/**
 * Created by TooLate on 10/10/2015.
 */
@Repository
public interface ResearcherRepo extends JpaRepository<Researcher,Long> {
    List<Researcher> findByLastName(@Param("lastName") String lastName);
    Researcher findByEmail(@Param("email")String email);
    Researcher findById(@Param("id")Long id);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN 'true' ELSE 'false' END FROM  Researcher as u WHERE u.email = ?1")
    Boolean existsByEmaile(String email);

}
