package com.githrd.www.dao;

import java.util.List;

import org.mybatis.spring.*;
import org.springframework.beans.factory.annotation.*;

import com.githrd.www.vo.*;

public class SurveyDao {
	@Autowired
	SqlSessionTemplate sqlSession;
	
	//참여하지 않은 설문 갯수 조회 함수
	public int getCount(SurveyVO sVO) {
		return sqlSession.selectOne("sSQL.remainSurvey", sVO);	
	}
	
	//진행 중인 설문 리스트 조회 함수
	public List<SurveyVO> getIngList(String id) {
		return sqlSession.selectList("sSQL.ingList", id);
	}

	//종료된 설문 리스트 조회 함수
	public List<SurveyVO> getOldList() {
		return sqlSession.selectList("sSQL.oldList");
	}
	
	//설문 문항 리스트 조회 함수
	public List<SurveyVO> getQuestList(int sino) {
		return sqlSession.selectList("sSQL.testList", sino);
	}
	
	//설문 문항 하나에 해당하는 보기 리스트 조회 함수
	public List<SurveyVO> getBogiList(int upno) {
		return sqlSession.selectList("sSQL.bogiList", upno);
	}
	
	//계층형 질의로 설문 문항 + 보기 리스트 조회 함수
	public List<SurveyVO> getQList(int sino) {
		return sqlSession.selectList("sSQL.qList", sino);
	}
	
	//설문 응답 입력 함수
	public int addSurvey(SurveyVO sVO) {
		return sqlSession.insert("sSQL.addSurvey", sVO);
	}
	
	//설문 주제 번호로 설문 결과 조회 함수
	public List<SurveyVO> getResultList(int sino) {
		return sqlSession.selectList("sSQL.resultList", sino);	
	}
	
	//설문 문항 보기 결과 조회 함수
	public List<SurveyVO> getBogiResult(int sqno) {
		return sqlSession.selectList("sSQL.bogiResult", sqno);
	}
} 