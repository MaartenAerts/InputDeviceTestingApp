package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.TestSequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by TooLate on 27/10/2015.
 */
@Repository
public interface TestSequenceRepo extends JpaRepository<TestSequence,Long>{
}
