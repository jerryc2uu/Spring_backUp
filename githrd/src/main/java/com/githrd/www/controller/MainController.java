package com.githrd.www.controller;

import java.util.*;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.githrd.www.dao.SurveyDao;
import com.githrd.www.vo.SurveyVO;

@Controller
public class MainController {
	@Autowired
	SurveyDao sDao;
	
	@RequestMapping({"/", "/main.blp"})
	public ModelAndView getMain(ModelAndView mv, SurveyVO sVO, HttpSession session) {
		String sid = (String) session.getAttribute("SID");
		if(sid != null) {
			sVO.setId(sid);
			int cnt = sDao.getCount(sVO);
			mv.addObject("SCOUNT", cnt);
		}
		mv.setViewName("main");
		return mv;
	}
	
	@RequestMapping("/mainMsgCheck.blp")
	@ResponseBody
	public Map<String, String> msgCheck(HttpSession session) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		session.setAttribute("MSG_CHECK", "NO");
		map.put("result", "OK");
		return map;
	}
	
}
