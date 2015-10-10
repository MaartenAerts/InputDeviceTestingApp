package org.uantwerpen.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.uantwerpen.repository.ResearcherRepo;
import org.uantwerpen.service.Interface.ResearcherService;

import javax.annotation.Resource;

/**
 * Created by TooLate on 10/10/2015.
 */
public class ResearcherServiceImpl implements ResearcherService{
    @Autowired
    private ResearcherRepo repo;


}
