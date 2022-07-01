package com.githrd.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.www.util.*;
import com.githrd.www.vo.*;

public class BoardDao {
	
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//게시글 수 조회
	public int getTotal() {
		return sqlSession.selectOne("bSQL.getTotal");
	}
	
	//게시글 리스트 조회
	public List<BoardVO> getList(PageUtil page) {
		return sqlSession.selectList("bSQL.getList", page);
	}
	
	//게시글 번호로 첨부 파일 리스트 조회
	public List<FileVO> getFileList(int bno) {
		return sqlSession.selectList("bSQL.fileList", bno);
	}
	
	//게시글 번호로 게시글 정보 조회
	public BoardVO getDetail(int bno) {
		return sqlSession.selectOne("bSQL.boardDetail", bno);
	}
	
	//회원 번호 조회 전담 함수
	public int getMno(String id) {
		return sqlSession.selectOne("bSQL.selMno", id);
	}
	
	//게시글 입력 전담 처리 함수
	public int addBoard(BoardVO bVO) {
		return sqlSession.insert("bSQL.insertBoard", bVO);
	}
	
	//첨부파일 정보 입력 전담 처리 함수
	public int addFile(FileVO fVO) {
		return sqlSession.insert("bSQL.insertFile", fVO);
	}
	
	//첨부파일 삭제 함수
	public int delFile(int fno) {
		return sqlSession.update("bSQL.delFile", fno);
    } 
	
	//파일 게시판 게시글 수정 전담 처리 함수
	public int editBoard(BoardVO bVO) {
		return sqlSession.update("bSQL.editBoard", bVO);
	}
	
	//게시글 삭제 전담 처리 함수
	public int delBoard(int bno) {
		return sqlSession.update("bSQL.delBoard", bno);
	}
}
