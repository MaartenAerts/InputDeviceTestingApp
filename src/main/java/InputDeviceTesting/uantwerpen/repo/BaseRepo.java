package InputDeviceTesting.uantwerpen.repo;

import org.springframework.data.repository.Repository;

import java.io.Serializable;

/**
 * Created by TooLate on 10/10/2015.
 */

public interface BaseRepo<T, ID extends Serializable> extends Repository<T,ID> {


}


