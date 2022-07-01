package com.githrd.www.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;

import com.githrd.www.vo.EmpVO;

public class EmpDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//분류 리스트 조회 함수
	public List<EmpVO> selList(EmpVO eVO) {
		return sqlSession.selectList("eSQL.selList", eVO);
	}
	
	//분류별 직원 리스트 조회 함수
	public List<EmpVO> partList(EmpVO eVO) {
		return sqlSession.selectList("eSQL.partList", eVO);
	}
	
	//사원 정보 조회 함수
	public EmpVO getInfo(EmpVO eVO) {
		return sqlSession.selectOne("eSQL.getInfo", eVO);
	}
	
	//이니셜 리스트 조회
	public List<EmpVO> getIniList() {
		return sqlSession.selectList("eSQL.getInitial");
	}
	
	//선택한 이니셜로 회원 리스트 조회
	public List<EmpVO> nameList(EmpVO eVO) {
		return sqlSession.selectList("eSQL.nameList", eVO);
	}
}
