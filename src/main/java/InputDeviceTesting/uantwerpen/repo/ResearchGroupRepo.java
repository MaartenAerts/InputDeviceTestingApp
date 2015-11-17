package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.ResearchGroup;
import InputDeviceTesting.uantwerpen.model.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Niels on 16/11/2015.
 */
@Repository
public interface ResearchGroupRepo extends JpaRepository<ResearchGroup,Long> {
}
