package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Niels on 3/12/2015.
 */
@Repository
public interface TestResultRepo extends JpaRepository<TestResult,Long> {
   // List<TestResult> findByTestId(long testId);

/*    @Query(value = "Select avg(test_result.tp) from test_result inner join test on test_result.test=test.id " +
            "group by test.difficulty",nativeQuery = true)
    List<Double> avgByDifficulty();*/
}
