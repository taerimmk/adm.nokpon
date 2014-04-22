package com.june.app.cmn.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.june.app.cmn.model.FIleList;
import com.june.app.cmn.model.FileDetail;
import com.june.app.cmn.repository.FileRepository;
import com.june.app.cmn.service.FileService;
import com.june.app.cmn.util.FIleMngUtil;

/**
 * Mostly used as a facade for all Petclinic controllers Also a placeholder for @Transactional
 * and @Cacheable annotations
 * 
 * @author Michael Isvy
 */
@Service
public class FileServiceImpl implements FileService {

	
	private FileRepository fileRepository;
	@Value("#{propUtil['file.Path']}")
	private String filePath;
	
	
	@Autowired
	public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
        
    }
	
	@Override
	@Transactional
	public FIleList fileListSave (FIleList vo) throws DataAccessException {
		return fileRepository.fileListSave(vo);
	}
	
	@Override
	@Transactional
	public FileDetail fileSaveDB (MultipartHttpServletRequest request) throws DataAccessException {
		
		
		Date today = new Date();
		//SimpleDateFormat sdformat  = new SimpleDateFormat("yyyy-MM-dd");
		FIleList fIleList = new FIleList();
		fIleList.setUseYn("Y");
		fIleList.setCreatDt(today);
		fIleList = fileRepository.fileListSave(fIleList);
		String atchFileId = fIleList.getAtchFileId();
		String streFileNm = "";
		
		FileDetail fileDetail = FIleMngUtil.writeFile(request, filePath);
		fileDetail.setAtchFileId(atchFileId);
		streFileNm = fileDetail.getStreFileNm();
		fileRepository.fileDetailSave(fileDetail);
		return fileDetail;
	}
	
	@Override
	@Transactional
	public FileDetail fileSaveDB (MultipartFile file) throws DataAccessException {
		
		
		Date today = new Date();
		//SimpleDateFormat sdformat  = new SimpleDateFormat("yyyy-MM-dd");
		FIleList fIleList = new FIleList();
		fIleList.setUseYn("Y");
		fIleList.setCreatDt(today);
		fIleList = fileRepository.fileListSave(fIleList);
		String atchFileId = fIleList.getAtchFileId();
		String streFileNm = "";
		
		FileDetail fileDetail = FIleMngUtil.writeFile(file, filePath);
		fileDetail.setAtchFileId(atchFileId);
		streFileNm = fileDetail.getStreFileNm();
		fileRepository.fileDetailSave(fileDetail);
		return fileDetail;
	}
	@Override
	@Transactional
	public FileDetail fileSave (MultipartHttpServletRequest request, String filePath) throws DataAccessException {
		
		FileDetail fileDetail = FIleMngUtil.writeFileWithOraginalName(request, filePath);
		return fileDetail;
	}
	
	
	
	@Override
	@Transactional
	public FileDetail fileSingle(FileDetail filedetail) throws DataAccessException {
		
		FileDetail fileDetail = fileRepository.fileSingle(filedetail);
		
		return fileDetail;
	}
	

}
