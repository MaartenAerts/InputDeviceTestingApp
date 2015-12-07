package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Niels on 3/12/2015.
 */
@Repository
public interface TestResultRepo extends JpaRepository<TestResult,Long> {
}
