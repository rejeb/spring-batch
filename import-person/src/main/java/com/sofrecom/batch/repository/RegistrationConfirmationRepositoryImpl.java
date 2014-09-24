package com.sofrecom.batch.repository;



import com.sofrecom.batch.entity.RegistrationConfirmation;
import org.springframework.stereotype.Repository;


/**
 *
 * @author r.benrejeb
 */
@Repository
public class RegistrationConfirmationRepositoryImpl  extends GenericRepository< RegistrationConfirmation > implements  RegistrationConfirmationRepository{
 
   public RegistrationConfirmationRepositoryImpl(){
      setClazz(RegistrationConfirmation.class );
   }
    
}
