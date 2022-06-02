package com.githrd.www.dao;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.www.vo.MemberVO;

public class MemberDao {
	
	//데이터베이스 작업만 하면 된다
	@Autowired // 알아서 객체 만들어 준다.
	SqlSessionTemplate sqlSession; //DI 
	
	//로그인 처리
	public int getLogin(MemberVO mVO) {
		return sqlSession.selectOne("mSQL.login", mVO); //sql의 parameterType과 동일해야 한다.
	}
	
	//아이디 카운트 조회
	public int getIdCnt(String id) {
		return sqlSession.selectOne("mSQL.idCnt", id);
	}
	
	//아바타 리스트 조회 전담 처리 함수
	public List<MemberVO> getAvtList() {
		return sqlSession.selectList("mSQL.avtList");
	}
	
	//회원 정보 데이터베이스 추가작업 전담 처리함수
	public int addMember(MemberVO mVO) {
		/*
			Dao에서 입력해주는 매개변수이름 = sql의 #{변수이름} 과 같아야함..
		*/
		return sqlSession.insert("mSQL.addMember", mVO);
	}
	
	//회원 정보 리스트 조회 함수
	public List<MemberVO> memberList() {
		return sqlSession.selectList("mSQL.memberList");
	}
}
