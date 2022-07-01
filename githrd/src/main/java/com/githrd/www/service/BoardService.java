package com.githrd.www.service;

import java.io.File;
import java.util.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.githrd.www.dao.*;
import com.githrd.www.util.FileUtil;
import com.githrd.www.vo.*;

public class BoardService {
	
	@Autowired
	BoardDao bDao;

	
	//단일 파일 업로드 함수
	public FileVO uploadProc(MultipartFile file) {
		
		/*
			이 함수가 파일을 업로드하려면 컨트롤러에서 
			업로드할 파일의 정보를 받아와야 한다.
			
			여러 개의 파일 중 이 함수에서는 한 개의 파일만 처리한다.
		*/
		
		//반환값 변수
		FileVO fVO = new FileVO();
		
		//저장경로
		String path = this.getClass().getResource("").getPath(); 
		path = path.substring(0, path.indexOf("/WEB-INF")) + "/resources/upload";
		
		fVO.setDir("/www/upload");
		
		//파일크기
		long len = file.getSize();
		fVO.setLen(len);
		
		//파일 원이름
		String oldName = file.getOriginalFilename();
		
		if(oldName == null) {
			return fVO;
		}
		
		fVO.setOriname(oldName);
		
		//저장이름 만들기
		String rename = FileUtil.rename(path, oldName);
		fVO.setSavename(rename);
		//파일 업로드
		try {
			File f = new File(path,  rename);
			file.transferTo(f); // 파일 내용 기록
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return fVO;
	}
	
	//다중 파일 업로드 함수
	public ArrayList<FileVO> uploadProc(MultipartFile[] file) {
		ArrayList<FileVO> list = new ArrayList<FileVO>();
		
		for(MultipartFile f : file) {
			list.add(uploadProc(f));
		}
		
		return list;
	}
	
	//데이터 베이스 입력 처리 함수
	@Transactional
	public void addBoardData(BoardVO bVO) {
		// 게시판 테이블에 데이터 입력
		bDao.addBoard(bVO);
		
		if(bVO.getFile() != null) {
			// 파일 정보 테이블에 파일들 정보 입력
			ArrayList<FileVO> list = uploadProc(bVO.getFile());
			//bno 꺼내서 fileVO들에 채워준다.
			for(FileVO f : list) {
				f.setBno(bVO.getBno());
			}
			//데이터 입력 작업을 파일 갯수만큼 반복
			for(FileVO f : list) {
				bDao.addFile(f);
			}
		}
	}
	
	//게시글 수정 처리 함수
	@Transactional
	public void editBoard(BoardVO bVO) {
		if(bVO.getTitle() != null || bVO.getBody() != null) {
			bDao.editBoard(bVO);
		}
		
		// 파일 정보 테이블에 파일들 정보 입력
		if(bVO.getFile() != null) {
			
			ArrayList<FileVO> list = uploadProc(bVO.getFile());
			//bno 꺼내서 fileVO들에 채워준다.
			for(FileVO f : list) {
				f.setBno(bVO.getBno());
			}
			
			//데이터 입력 작업을 파일 갯수만큼 반복
			for(FileVO f : list) {
				bDao.addFile(f);
			}
		}
	}
}
