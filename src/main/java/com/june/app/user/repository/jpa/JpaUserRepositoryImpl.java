/*
 * Copyright 2002-2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.june.app.user.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.june.app.user.model.MyUser;
import com.june.app.user.model.UserInfo;
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
public class JpaUserRepositoryImpl implements UserRepository {

    @PersistenceContext
    private EntityManager em;


    @Override
    public UserInfo selectUser(int seq) {
        Query query = this.em.createQuery("SELECT user FROM User user WHERE user.seq =:seq");
        query.setParameter("seq", seq);
        return (UserInfo) query.getSingleResult();
    }
    
    
    @Override
	public UserInfo getUser(String id) {
		
		Query query = this.em.createQuery("SELECT userInfo FROM UserInfo userInfo WHERE userInfo.id =:id");
		query.setParameter("id", id);
		
		return (UserInfo) query.getSingleResult();
	}

	

}
