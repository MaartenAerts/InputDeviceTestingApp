package org.uantwerpen.repository;

import org.springframework.data.repository.CrudRepository;
import org.uantwerpen.model.Researcher;

import java.util.List;
import java.util.Optional;

/**
 * Created by TooLate on 10/10/2015.
 */
public class ResearcherRepo implements BaseRepo<Researcher,Long> {


    @Override
    public void delete(Researcher deleted) {

    }

    @Override
    public List<Researcher> findAll() {
        return null;
    }

    @Override
    public Optional<Researcher> findOne(Long aLong) {
        return null;
    }

    @Override
    public Researcher save(Researcher persisted) {
        return null;
    }
}
