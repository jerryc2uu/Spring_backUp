package com.githrd.www.controller;

import java.util.*;



import javax.servlet.http.*;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.*;
import org.springframework.web.servlet.view.RedirectView;

import com.githrd.www.dao.GBoardDao;
import com.githrd.www.dao.MemberDao;
import com.githrd.www.vo.MemberVO;

@Controller
@RequestMapping("/member")
public class Member {
	
	//뷰에 사용할 데이터와 뷰를 관리하는 클래스
	
	@Autowired
	MemberDao mDao;
	@Autowired
	GBoardDao gDao;
	
	//로그인 페이지 보이기
	@RequestMapping("/login.blp")
	public ModelAndView loginForm(ModelAndView mv, HttpSession session) {
		mv.setViewName("member/login");
		return mv;
	}
	/*
	//로그인 페이지 보이기
	@RequestMapping("/login.blp")
	public String loginForm(HttpSession session, HttpServletResponse resp) {
		
		
		return "member/login";
	}*/
	
	//일반 회원 로그인 처리
	@RequestMapping(path="/loginProc.blp", method=RequestMethod.POST, params={"id", "pw"})
	public ModelAndView loginProc(MemberVO mVO, HttpSession session, ModelAndView mv, RedirectView rv) {
		//System.out.println("####일반 사용자");
		//System.out.println("*************** sid : " + sid);//파라미터의 키값(input 태그의 name 값이 id이기 때문..
		
		/*System.out.println("********** id : " + id);
		System.out.println("********** pw : " + pw);
		System.out.println("********** mVO.id : " + mVO.getId());
		System.out.println("********** mVO.pw : " + mVO.getPw());*/
		
		int cnt = mDao.getLogin(mVO);
		
		String view = "";
		
		if(cnt == 1) {
			session.setAttribute("SID", mVO.getId());
			session.setAttribute("MSG_CHECK", "OK");
			
			int count = gDao.getMyCount(mVO.getId());
			
			session.setAttribute("CNT", count);
			
			if(count == 0) {
				rv.setUrl("/www/gBoard/gBoardList.blp");
			} else {
				rv.setUrl("/www/main.blp");				
			}
			
		} else {
			rv.setUrl("/www/member/login.blp");
		}
		mv.setView(rv);
		return mv;
	}
	/*
	//일반 회원 로그인 처리
	@RequestMapping(path="/loginProc.blp", method=RequestMethod.POST, params={"id", "pw"})
	public ModelAndView loginProc(String id, String pw, MemberVO mVO, HttpSession session, ModelAndView mv) {
		//System.out.println("####일반 사용자");
		//System.out.println("*************** sid : " + sid);//파라미터의 키값(input 태그의 name 값이 id이기 때문..
		
		/*System.out.println("********** id : " + id);
		System.out.println("********** pw : " + pw);
		System.out.println("********** mVO.id : " + mVO.getId());
		System.out.println("********** mVO.pw : " + mVO.getPw());*/
		/*
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
	}*/
	
	//관리자 계정 로그인 처리
	@RequestMapping(path="/loginProc.blp", params="id=admin")
	public ModelAndView adminLogin(MemberVO mVO, HttpSession session, ModelAndView mv, RedirectView rv) {
		System.out.println("### 관리자");
		int cnt = mDao.getLogin(mVO);
		
		String view = "";
		
		if(cnt == 1) {
			session.setAttribute("SID", mVO.getId());
			rv.setUrl("/www/main.blp");
		} else {
			rv.setUrl("/www/member/login.blp");
		}
		mv.setView(rv);
		return mv; // Model : 데이터  View : jsp 파일,  화면
	}
	/*
	//관리자 계정 로그인 처리
	@RequestMapping(path="/loginProc.blp", params="id=admin")
	public ModelAndView adminLogin(MemberVO mVO, HttpSession session, ModelAndView mv) {
		System.out.println("### 관리자");
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
	//관리자 계정 로그인 처리
	@RequestMapping(path="/loginProc.blp", params="id=admin")
	public ModelAndView adminLogin(MemberVO mVO, HttpSession session, ModelAndView mv) {
		System.out.println("### 관리자");
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
	}*/
	
	//로그아웃 처리
	@RequestMapping("/logout.blp")
	public ModelAndView logout(ModelAndView mv, HttpSession session, String vw, String nowPage) {
		session.removeAttribute("SID");
		
		if(vw == null) {
			vw = "/www/";
		}
		
		if(nowPage != null) {
			mv.addObject("NOWPAGE", nowPage);
		}
		
		mv.addObject("VIEW", vw);
		mv.setViewName("member/redirect");
		return mv;
	}
	
	/*//로그아웃 처리
	@RequestMapping("/logout.blp")
	public ModelAndView logout(ModelAndView mv, HttpSession session) {
		session.removeAttribute("SID");
		mv.setViewName("redirect:../main.blp");
		return mv;
	}*/
	
	
	//회원가입 폼보기 요청
	@RequestMapping("/join.blp")
	public ModelAndView joinForm(ModelAndView mv, RedirectView rv) {
		List<MemberVO> list = mDao.getAvtList();
		
		//ModelAndView에 데이터 심고
		mv.addObject("LIST", list);	
		mv.setViewName("member/join");
		return  mv;
	}
	
	/*
	//회원가입 폼보기 요청
	@RequestMapping("/join.blp")
	public String joinForm(HttpSession session, HttpServletResponse resp) {
		String view = "member/join";
		
		//반환값 void도 가능
		return view;
	}*/
	
	//회원가입 처리 요청
	@RequestMapping(path="/joinProc.blp", method=RequestMethod.POST)
	public ModelAndView joinProc(MemberVO mVO, ModelAndView mv, RedirectView rv, HttpSession session) {
		
		System.out.println("######### before mno : " + mVO.getMno());
		int cnt = mDao.addMember(mVO);
		System.out.println("######### after mno : " + mVO.getMno());
		
		if(cnt == 1) {
			// 회원가입 성공
			session.setAttribute("SID", mVO.getId());
			session.setAttribute("MSG_CHECK", "OK");
			
			int count = gDao.getMyCount(mVO.getId());
			
			session.setAttribute("CNT", count);
			
			if(count == 0) {
				rv.setUrl("/www/gBoard/gBoardList.blp");
			} else {
				rv.setUrl("/www/main.blp");				
			}
		} else {
			rv.setUrl("/www/member/join.blp");			
		}
		
		mv.setView(rv);
		
		return mv;
	}
	
	//아이디 체크 처리
	@RequestMapping(path="/idCheck.blp", method=RequestMethod.POST, params="id")	
	@ResponseBody
	public Map idCheck(String id) {
		
		HashMap<String, String> map = new HashMap<String, String>();
		String result = "NO";
		
		int cnt = mDao.getIdCnt(id);
		
		if(cnt == 0) {
			result = "OK";
		}
		
		map.put("result", result);
		/*
		 * map.put("id", id); map.put("result", "OK");
		 */
		
		//map = new HashMap(); // java.api 내의 클래스는 bean 처리 불가능. 따로 new 시켜 줘야 한당..
		//map.put("result", "OK");
		/*
		 * ArrayList<String> list = new ArrayList<String>(); list.add("제니");
		 * list.add("리사"); list.add("로제"); list.add("지수");
		 */
		return map;
	}
	
	//내 정보 보기
	@RequestMapping("/myInfo.blp")
	public ModelAndView myInfo(ModelAndView mv, String id) {
		
		//데이터 가져오고
		MemberVO mVO = mDao.getIdInfo(id);
		//뷰에 데이터 심고
		mv.addObject("DATA", mVO);
		//뷰 정하고(포워드)
		mv.setViewName("member/memberInfo");
		return mv;
	}
	
	
	//회원 리스트 폼보기
	@RequestMapping("/memberList.blp")
	public ModelAndView memberList(ModelAndView mv, RedirectView rv) {
		//데이터 가져오고
		List<MemberVO> list = mDao.memberList();
		
		//ModelAndView에 데이터 심고
		mv.addObject("LIST", list);	
		//뷰 설정하고(포워딩)
		mv.setViewName("member/memberList");
		
		return mv;
	}
	
	//회원 정보 보기
	@RequestMapping("/memberInfo.blp")
	public ModelAndView memberInfo(ModelAndView mv, int mno) {
		//데이터 가져오고
		MemberVO mVO = mDao.getMnoInfo(mno);
		//뷰에 데이터 심고
		mv.addObject("DATA", mVO);
		//뷰 정하고(포워드)
		mv.setViewName("member/memberInfo");
		return mv;
	}
	
	//회원 탈퇴
	@RequestMapping("/delMember.blp")
	public ModelAndView delMember(ModelAndView mv, String id, RedirectView rv, HttpSession session) {
		String sid = (String) session.getAttribute("SID");
		if(sid == null) {
			rv.setUrl("/www/member/login.blp");
			mv.setView(rv);
			return mv;
		}
		if(!id.equals(sid)) {
			rv.setUrl("/www/member/myInfo.blp");
			mv.setView(rv);
			return mv;
		}
		
		int cnt = mDao.delMember(id);
		
		if(cnt == 1) {
			//탈퇴 성공
			//세션에 기억시켜둔 데이터를 삭제
			session.removeAttribute("SID");
			rv.setUrl("/www/");
		} else {
			rv.setUrl("/www/member/myInfo.blp");			
		}
		
		mv.setView(rv);
		return mv;
	}
	
	//내 정보 수정 폼보기
	@RequestMapping("/myInfoEdit.blp")
	public ModelAndView myInfoEdit(ModelAndView mv, String id, RedirectView rv, HttpSession session) {
		String sid = (String) session.getAttribute("SID");
		if(sid == null) {
			rv.setUrl("/www/member/login.blp");
			mv.setView(rv);
			return mv;
		} 
			 
		if(!id.equals(sid)) { 
			 rv.setUrl("/www/main.blp"); 
			 mv.setView(rv);
			 return mv; 
		}	 
		
		//데이터베이스 조회
		MemberVO mVO = mDao.getIdInfo(id);
		List<MemberVO> list = mDao.genAvtList(id);
		
		mv.addObject("DATA", mVO);
		mv.addObject("LIST", list);
		
		//뷰 정하고
		mv.setViewName("member/editInfo");
		return mv;
	}
	
	// 내 정보 수정 처리
	@RequestMapping("/infoEditProc.blp")
	public ModelAndView infoEditProc(ModelAndView mv, MemberVO mVO, RedirectView rv) {
		int cnt = mDao.editMyInfo(mVO);
		String view = "member/redirect";
		
		if(cnt == 0) {
			mv.addObject("VIEW", "/www/member/myInfoEdit.blp");
		} else {
			mv.addObject("VIEW", "/www/member/myInfo.blp");
		}
		mv.setViewName(view);
		return mv;
	}
	
}
