package org.uantwerpen.repo;

import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

/**
 * Created by TooLate on 10/10/2015.
 */
public interface BaseRepo<T, ID extends Serializable> extends Repository<T,ID> {
    void delete(T deleted);

    List<T> findAll();

    Optional<T> findOne(ID id);

    T save(T persisted);
}


