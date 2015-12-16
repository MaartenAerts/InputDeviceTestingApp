package InputDeviceTesting.uantwerpen.repo;

import InputDeviceTesting.uantwerpen.model.Device;
import InputDeviceTesting.uantwerpen.model.Researcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by TooLate on 25/10/2015.
 */
@Repository
public interface DeviceRepo extends JpaRepository<Device,Long> {

    Device findByName(@Param("name")String name);
}
