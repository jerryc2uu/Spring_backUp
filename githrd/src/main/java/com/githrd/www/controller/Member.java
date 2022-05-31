package com.githrd.www.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.githrd.www.dao.MemberDao;
import com.githrd.www.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class Member {
	
	//뷰에 사용할 데이터와 뷰를 관리하는 클래스
	
	@Autowired
	MemberDao mDao;
	
	@RequestMapping("/login.blp")
	public String loginForm(HttpSession session, HttpServletResponse resp) {
		
		
		return "member/login";
	}
	
	@RequestMapping("/loginProc.blp")
	public ModelAndView loginProc(MemberVO mVO, HttpSession session, ModelAndView mv) {
		
		int cnt = mDao.getLogin(mVO);
		
		String view = "";
		
		if(cnt == 1) {
			session.setAttribute("SID", mVO.getId());
			view = "redirect:../main.blp";
		} else {
			view = "redirect:login.blp";
		}
		mv.setViewName(view);
		return mv; // Model : 데이터  View : jsp 파일,  화면
	}
	
	@RequestMapping("/logout.blp")
	public ModelAndView logout(ModelAndView mv, HttpSession session) {
		session.removeAttribute("SID");
		mv.setViewName("redirect:../main.blp");
		return mv;
	}
}
