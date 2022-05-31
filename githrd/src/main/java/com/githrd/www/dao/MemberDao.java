package com.githrd.www.dao;

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
}
