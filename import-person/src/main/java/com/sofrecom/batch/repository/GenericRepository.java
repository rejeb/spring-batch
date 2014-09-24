package com.sofrecom.batch.repository;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


/**
 *
 * @author r.benrejeb
 */
@Repository
public abstract class GenericRepository< T extends Serializable > implements JpaRepository<T> {
 
   private Class< T > clazz;
 
   @PersistenceContext
   EntityManager entityManager;
 
   public void setClazz( Class< T > clazzToSet ){
      this.clazz = clazzToSet;
   }
 
    @Override
   public T findOne( Long id ){
      return entityManager.find( clazz, id );
   }
    @Override
   public List< T > findAll(){
      return entityManager.createQuery( "from " + clazz.getName() )
       .getResultList();
   }
 
    @Override
   public void save( T entity ){
      entityManager.persist( entity );
   }
 
    @Override
   public void update( T entity ){
      entityManager.merge( entity );
   }
 
    @Override
   public void delete( T entity ){
      entityManager.remove( entity );
   }
    @Override
   public void deleteById( Long entityId ){
      T entity = findOne( entityId );
      delete( entity );
   }
}