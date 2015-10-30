package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.TestSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * Created by TooLate on 27/10/2015.
 */
@RepositoryRestResource
public interface TestSubjectRepo extends JpaRepository<TestSubject,Long> {
}
