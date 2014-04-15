package com.june.app.cmn.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.june.app.cmn.model.FIleList;
import com.june.app.cmn.repository.FileRepository;
import com.june.app.cmn.service.FileService;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder for @Transactional
 * and @Cacheable annotations
 * 
 * @author Michael Isvy
 */
@Service
public class FileServiceImpl implements FileService {

	
	private FileRepository fileRepository;
	
	@Autowired
	public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
        
    }
	
	@Override
	@Transactional
	public FIleList fileListSave (FIleList vo) throws DataAccessException {
		return fileRepository.fileListSave(vo);
	}
	
	

}
