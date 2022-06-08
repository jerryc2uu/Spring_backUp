package com.githrd.www.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.githrd.www.dao.*;
import com.githrd.www.util.*;
import com.githrd.www.vo.BoardVO;

@Controller
@RequestMapping("/gBoard")
public class GuestBoard {
	@Autowired(required=false)
	GBoardDao gDao;
	
	@RequestMapping("/gBoardList.blp")
	public ModelAndView gBoardList(ModelAndView mv, PageUtil page, HttpSession session) {
		//System.out.println("************** page.nowPage : " + page.getNowPage());
		//System.out.println("************** page.pageRow : " + page.getPageRow());
		
		String sid = (String) session.getAttribute("SID");
		if(sid != null) {
			int cnt = gDao.getMyCount(sid);
			mv.addObject("CNT", cnt);
		}
		//총 게시글 수 조회
		int total = gDao.getTotal();
		
		page.setPage(page.getNowPage(), total);

		//게시글 목록 조회
		List<BoardVO> list = gDao.getList(page);
		
		//데이터 심고
		mv.addObject("LIST", list);
		mv.addObject("PAGE", page);
		
		//뷰 부르고
		mv.setViewName("gBoard/gBoardList");
		return mv;
	}
	
	//방명록 작성 폼 보기
	@RequestMapping("/gBoardWrite.blp")
	public ModelAndView gBoardWrite(ModelAndView mv, HttpSession session) {
		String sid = (String) session.getAttribute("SID");
		BoardVO bVO = gDao.getWriteData(sid);
		
		//데이터 심고
		mv.addObject("DATA", bVO);
		mv.setViewName("gBoard/gBoardWrite");
		return mv;
	}
	
	//방명록 등록 처리 요청
	@RequestMapping("/gBoardWriteProc.blp")
	public ModelAndView gBoardWriteProc(ModelAndView mv, BoardVO bVO, int nowPage) {
		int cnt = gDao.addGBoard(bVO);
		String view = "/www/gBoard/gBoardList.blp";
		if(cnt != 1) {
			//실패			
			view = "/www/gBoard/gBoardWrite.blp";
			mv.addObject("NOWPAGE", nowPage);
		}
		
		mv.addObject("VIEW", view);
		mv.setViewName("gBoard/redirect");
		return mv;
	}
}
