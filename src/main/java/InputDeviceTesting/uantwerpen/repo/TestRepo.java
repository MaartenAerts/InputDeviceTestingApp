package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Stream;

/**
 * Created by TooLate on 27/10/2015.
 */
@Repository
public interface TestRepo extends JpaRepository<Test,Long> {
    Test findById(@Param("id") long id);
/*    @Query("select Test from Test inner join TestSequence on TestSequence.test=Test.id " +
            "inner join TestResult on TestResult.sequence=TestSequence.id")
    Stream<Test> eagerAll();*/
}
