
package com.june.app.user.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import org.springframework.stereotype.Repository;

import com.june.app.user.model.UserRoleInfo;
import com.june.app.user.repository.UserRoleRepository;


@Repository
public class UserRoleRepositoryImpl implements UserRoleRepository {

    @PersistenceContext(type=PersistenceContextType.EXTENDED)
    private EntityManager em;

    
    @Override
    public void save(UserRoleInfo vo) {
    	//this.em.persist(vo);
    	if (vo.getSeq() == null) {
    		this.em.persist(vo);     		
    	} else {
    		this.em.merge(vo); 
    		/** if merge  @PersistenceContext(type=PersistenceContextType.EXTENDED) or this.em.flush() option setting */
    		//this.em.flush(); 
    	}
    }
    

}
