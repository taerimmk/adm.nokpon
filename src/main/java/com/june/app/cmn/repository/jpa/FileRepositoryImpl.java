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
package com.june.app.cmn.repository.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.june.app.cmn.model.FIleList;
import com.june.app.cmn.model.FileDetail;
import com.june.app.cmn.repository.FileRepository;
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
public class FileRepositoryImpl implements FileRepository {
	
	private static final Logger logger = LoggerFactory
			.getLogger(FileRepositoryImpl.class);
    @PersistenceContext
    private EntityManager em;

    @Override
    public FIleList fileListSave(FIleList vo) {
    	this.em.persist(vo);
    	return vo;
    }
    
    @Override
    public void fileDetailSave(FileDetail vo) {
    	this.em.persist(vo);
    }
    
    @Override
    public FileDetail fileSingle(FileDetail filedetail) {
    	String atchFileId = filedetail.getAtchFileId();
    	int fileSn = filedetail.getFileSn();
        Query query = this.em.createQuery("SELECT fileDetail FROM FileDetail fileDetail WHERE fileDetail.atchFileId =:atchFileId and fileDetail.fileSn =:fileSn");
        query.setParameter("atchFileId", atchFileId);
        query.setParameter("fileSn", fileSn);
        return (FileDetail) query.getSingleResult();
    	
    }

}
