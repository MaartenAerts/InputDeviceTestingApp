package org.uantwerpen.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.uantwerpen.model.Researcher;


/**
 * Created by TooLate on 10/10/2015.
 */
@Repository
public interface ResearcherRepo extends BaseRepo<Researcher,Long> {


}
