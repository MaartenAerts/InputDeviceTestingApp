package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.Test;
import InputDeviceTesting.uantwerpen.model.createTest;
import org.jboss.logging.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by TooLate on 27/10/2015.
 */
@Repository
public interface TestRepo extends JpaRepository<Test,Long> {

}
