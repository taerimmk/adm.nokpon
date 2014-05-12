
package com.june.app.user.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.june.app.user.model.UserInfo;
import com.june.app.user.repository.UserRepository;


@Repository
public class UserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public UserInfo getUser(Integer seq) {
        Query query = this.em.createQuery("SELECT user FROM UserInfo user WHERE user.seq =:seq");
        query.setParameter("seq", seq);
        return (UserInfo) query.getSingleResult();
    }
    
    
    @Override
	public UserInfo getUser(String userId) {
		
		//Query query = this.em.createQuery("SELECT userInfo FROM UserInfo userInfo left join fetch userInfo.roleInfos WHERE userInfo.userId =:userId");
		Query query = this.em.createQuery("SELECT userInfo FROM UserInfo userInfo WHERE userInfo.userId =:userId");
		query.setParameter("userId", userId);
		
		return (UserInfo) query.getSingleResult();
	}
    
    
    @SuppressWarnings("unchecked")
	@Override
    public Collection<UserInfo> userList(UserInfo vo) {
    	
    	int pageSize = vo.getPageSize();
    	int pageNumber = (int) vo.getPageIndex();
        
    	String queryString = "SELECT user FROM UserInfo user WHERE user.seq > 1";
        Query query = this.em.createQuery(queryString);
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        return query.getResultList();
    }
    
    @Override
    public long userListCnt(UserInfo vo) {
    	
    	String queryString = "SELECT count(*) FROM UserInfo user WHERE user.seq > 1";
        Query query = this.em.createQuery(queryString);
        Long count = (Long) query.getSingleResult();
        return count;

    }
    
    @Override
    public void save(UserInfo vo) {
    	this.em.persist(vo);
    }
    
    

}
