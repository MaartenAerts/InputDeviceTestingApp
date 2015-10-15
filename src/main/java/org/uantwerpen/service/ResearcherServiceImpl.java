package org.uantwerpen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.uantwerpen.model.Researcher;
import org.uantwerpen.repo.ResearcherRepo;
import org.uantwerpen.service.Interface.ResearcherService;

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
