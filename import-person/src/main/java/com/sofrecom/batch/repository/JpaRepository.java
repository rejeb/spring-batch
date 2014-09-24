package com.sofrecom.batch.repository;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author r.benrejeb
 */
public interface JpaRepository<T extends Serializable> {

    void delete(T entity);

    void deleteById(Long entityId);

    List<T> findAll();

    T findOne(Long id);

    void save(T entity);

    void update(T entity);
    
}
