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
package com.june.app.board.repository.jpa;

import java.util.Collection;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.june.app.board.model.Board;
import com.june.app.board.repository.BoardRepository;
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
public class BoardRepositoryImpl implements BoardRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    @SuppressWarnings("unchecked")
    public Collection<Board> boardList(Board vo) {
    	String queryString = "SELECT board FROM Board board WHERE board.useYn ='Y'";
    	int bbsId = vo.getBbsId();
    	if (bbsId > 0){
    		queryString += "and board.bbsId = :bbsId";
    	}
        Query query = this.em.createQuery(queryString);
        if (bbsId > 0){
        	query.setParameter("bbsId", bbsId);
    	}
        
        
        
        return query.getResultList();
    }
    
    /*@Override
    @SuppressWarnings("unchecked")*/
   /* public Collection<Board> boardListWithPaging(Board vo) {
    	int bbsId = vo.getBbsId();
    	int pageSize = vo.getPageSize();
    	int pageNumber = vo.getPageNumber();

    	String queryString = "SELECT board FROM Board board WHERE board.useYn ='Y'";
    	if (bbsId > 0){
    		queryString += "and board.bbsId = :bbsId";
    	}
        Query query = this.em.createQuery(queryString);
        if (bbsId > 0){
        	query.setParameter("bbsId", bbsId);
    	}
        configurePagination(query, pageNumber, pageSize);
        return query.getResultList();
    }*/
    /*public void configurePagination(Query query, int pageNumber, int pageSize) {
        query.setFirstResult((pageNumber - 1) * pageSize);
        query.setMaxResults(pageSize);
        
        //return query;
    }*/
    @Override
    public Collection<Board> boardListWithPaging(Board vo) {
    	int bbsId = vo.getBbsId();
    	int pageSize = vo.getPageSize();
    	int pageNumber = vo.getPageNumber();
        
    	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        CriteriaQuery<Board> criteriaQuery = criteriaBuilder.createQuery(Board.class);
        
        Root<Board> from = criteriaQuery.from(Board.class);
        CriteriaQuery<Board> select = criteriaQuery.select(from);
        TypedQuery<Board> typedQuery = em.createQuery(select);
        
        if (bbsId > 0){
        	criteriaQuery.where(criteriaBuilder.equal(from.get("bbsId"), bbsId));
    	}
        typedQuery.setFirstResult((pageNumber - 1) * pageSize);
        typedQuery.setMaxResults(pageSize);
        
        Collection<Board> fooList = typedQuery.getResultList();
        
       
        return fooList;

    }
    
    @Override
    public long boardListCnt(Board vo) {
    	
    	CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
        /*CriteriaQuery<Board> criteriaQuery = criteriaBuilder.createQuery(Board.class);
        
        countQuery.select(criteriaBuilder.count(countQuery.from(Board.class)));
        Long count = entityManager.createQuery(countQuery).getSingleResult();*/
        
    	int bbsId = vo.getBbsId();
        CriteriaQuery<Long> countQuery = criteriaBuilder.createQuery(Long.class);
        Root<Board> from = countQuery.from(Board.class);
        countQuery.select(criteriaBuilder.count(from));
        if (bbsId > 0){
        	countQuery.where(criteriaBuilder.equal(from.get("bbsId"), bbsId));
    	}
        Long count = em.createQuery(countQuery).getSingleResult();
       
        return count;

    }
    @Override
    public void save(Board vo) {
    	this.em.persist(vo);
    }

}
