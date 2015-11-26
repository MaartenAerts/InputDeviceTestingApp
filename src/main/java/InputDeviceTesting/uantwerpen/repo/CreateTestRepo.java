package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.createTest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Joelg on 26/11/2015.
 */
@Repository
public interface CreateTestRepo extends JpaRepository<createTest,Long>{
}
