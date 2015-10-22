package InputDeviceTesting.uantwerpen.service;

import org.springframework.beans.factory.annotation.Autowired;
import InputDeviceTesting.uantwerpen.model.Researcher;
import InputDeviceTesting.uantwerpen.repo.ResearcherRepo;
import InputDeviceTesting.uantwerpen.service.Interface.ResearcherService;

/**
 * Created by TooLate on 10/10/2015.
 */
public class ResearcherServiceImpl implements ResearcherService{
    @Autowired
    private ResearcherRepo repo;


    public void addResearcher(Researcher researcher){
        //repo.save(researcher);
    }
}
