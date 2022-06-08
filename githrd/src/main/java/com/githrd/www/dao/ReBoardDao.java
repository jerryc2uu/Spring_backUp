package com.githrd.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.www.util.PageUtil;
import com.githrd.www.vo.BoardVO;
/**
 * 이 클래스는 댓글 게시판 관련 데이터 베이스 전담 처리 함수들로 구성된 클래스
 * @author 박소연
 * @since  2022.06.08
 * @version v.1.0
 * 
 * 			작업이력 ]
 * 				2022.06.08 - 담당자 : 박소연
 * 									클래스 제작, 리스트 조회
 */
public class ReBoardDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//댓글 리스트 조회 함수
	public List<BoardVO> getList(PageUtil page) {
		return sqlSession.selectList("rSQL.getList", page);
	}
	
	//총 댓글 수 조회 함수
	public int getTotal() {
		return sqlSession.selectOne("rSQL.getTotal");
	}
	
	//작성자 데이터 조회 함수
	public BoardVO getWriterInfo(String id) {
		return sqlSession.selectOne("rSQL.getWriterInfo", id);
	}
	
	//댓글 및 대댓글 등록 처리 함수
	public int addReBoard(BoardVO bVO) {
		return sqlSession.insert("rSQL.addReBoard", bVO);
	}
}
