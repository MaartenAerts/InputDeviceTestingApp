package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.Test;
import InputDeviceTesting.uantwerpen.model.TestSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by TooLate on 27/10/2015.
 */
@Repository
public interface TestSubjectRepo extends JpaRepository<TestSubject,Long> {
    TestSubject findById(@Param("id") long id);
}
