package com.githrd.www.controller;

import java.util.List;

import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.githrd.www.dao.SurveyDao;
import com.githrd.www.service.SurveyService;
import com.githrd.www.vo.SurveyVO;

@Controller
@RequestMapping("/survey")
public class Survey {
	
	private static final Logger surveyLog = LoggerFactory.getLogger(Survey.class);
	
	@Autowired
	SurveyDao sDao;
	@Autowired
	SurveyService sSrvc;
	
	//설문 주제 폼 보기 요청
	@RequestMapping("/surveyInfo.blp")
	public ModelAndView surveyInfo(ModelAndView mv, SurveyVO sVO) {
		List<SurveyVO> list = sDao.getIngList(sVO.getId());
		List<SurveyVO> old = sDao.getOldList();
		
		//데이터 심고
		mv.addObject("ING", list);
		mv.addObject("OLD", old);		
		//뷰 정하고
		mv.setViewName("survey/surveyInfo");
		return mv;
	}
	
	//설문 조사 폼 보기 요청
	@RequestMapping("/survey.blp")
	public ModelAndView survey(ModelAndView mv, SurveyVO sVO) {
		
		//sSrvc.setBogi(sVO);
		sSrvc.settingList(sVO);
		/*
		List<SurveyVO> list = sDao.getQuestList(sVO.getSino());
		
		sVO.setBogi(list);*/
		
		//데이터 심고
		mv.addObject("DATA", sVO);
		
		//뷰 설정
		mv.setViewName("survey/survey");
		return mv;
	}
	
	//설문 조사 응답 처리 요청
	@RequestMapping("/surveyProc.blp")
	public ModelAndView surveyProc(ModelAndView mv, SurveyVO sVO) {
		/*
		for(int no : sVO.getDap()) {
			System.out.println("qno : " + no);
		}*/
		boolean bool = sSrvc.applyTx(sVO);			
		
		String view = "/www/survey/surveyResult.blp";
		
		if(!bool) {
			//입력 실패
			System.out.println("실패!!");
			view = "/www/survey/survey.blp";	
		} else {
			
			//로그 기록
			surveyLog.info(sVO.getId() + " 님이 [ " + sVO.getSino() + " ] 번 설문에 참여 완료했습니다.");	
		}
		
		mv.addObject("VIEW", view);
		mv.setViewName("survey/redirect");
		
		return mv;
	}
	
	//설문 결과 페이지 폼 보기 요청
	@RequestMapping("/surveyResult.blp")
	public ModelAndView surveyResult(ModelAndView mv, SurveyVO sVO) {
		//sSrvc.resultService(sVO);
		sSrvc.setMunhangList(sVO);
		//위 함수 호출로 sVO의 변수에 변화가 생겼으니 그냥 채워준다.
		
		//데이터 심고
		mv.addObject("DATA", sVO);
		mv.setViewName("survey/surveyResult");
		return mv;
	}
}
