package com.june.app.user.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.june.app.user.model.RoleInfo;
import com.june.app.user.model.UserInfo;
import com.june.app.user.repository.RoleRepository;
import com.june.app.user.repository.UserRepository;

/**
 * JPA implementation of the {@link UserRepository} interface.
 *
 * @author Mike Keith
 * @author Rod Johnson
 * @author Sam Brannen
 * @author Michael Isvy
 * @since 22.4.2006
 */
@Repository
public class RoleRepositoryImpl implements RoleRepository {

    @PersistenceContext
    private EntityManager em;


  
    
    @SuppressWarnings("unchecked")
	@Override
    public Collection<RoleInfo> roleListAll() {
        
    	String queryString = "SELECT role FROM RoleInfo role";
        Query query = this.em.createQuery(queryString);
        return query.getResultList();
    }
    
    

}
