package com.githrd.www.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.githrd.www.dao.GBoardDao;
import com.githrd.www.dao.ReBoardDao;
import com.githrd.www.util.PageUtil;
import com.githrd.www.vo.BoardVO;

/**
 * 이 클래스는 댓글 게시판 관련 요청을 처리할 클래스
 * 
 * @author 박소연
 * @since 2022.06.08
 * @version v.1.0
 * 
 * 		작업 이력 ]
 * 			2022.06.08 - 담당자 : 박소연
 * 							클래스 제작,
 *  						리스트 보기 요청 처리
 */
@Controller
@RequestMapping("/reBoard")
public class ReBoard {
	@Autowired
	ReBoardDao rDao;
	@Autowired
	GBoardDao gDao;
	
	
	//댓글 게시판 리스트 보기 요청
	@RequestMapping("/reBoardList.blp")
	public ModelAndView reBoardList(ModelAndView mv, PageUtil page, String msg) {
		//할일
		//데이터베이스에서 데이터 가져오기
		
		//PageUtil이 먼저 만들어져야 하기 때문에
		
		//총 게시글 수부터 가져온다.
		int total = rDao.getTotal();
		
		//PageUtil을 셋팅
		page.setPage(total);
		
		// 댓글 리스트 조회
		List<BoardVO> list = rDao.getList(page);
		
		if(msg != null) {
			mv.addObject("MSG", msg);
		}
		
		mv.addObject("LIST", list);
		mv.addObject("PAGE", page);
		mv.setViewName("reBoard/reBoardList");
		
		return mv;
	}
	
	//새 댓글 작성 폼보기 요청
	@RequestMapping(path="/reBoardWrite.blp", method=RequestMethod.POST, params={"id", "nowPage"})
	public ModelAndView reBoardWrite(ModelAndView mv, String id, String nowPage) {
		BoardVO bVO = rDao.getWriterInfo(id);
		
		//데이터 넘겨주고
		mv.addObject("DATA", bVO);
		mv.setViewName("reBoard/reBoardWrite");
		
		return mv;
	}
	
	//댓글 등록 처리 요청
	@RequestMapping("/writeProc.blp")
	public ModelAndView writeProc(ModelAndView mv, BoardVO bVO, String nowPage) {
		int cnt = rDao.addReBoard(bVO);
		
		String view = "/www/reBoard/reBoardList.blp";
		if(cnt == 0) {
			//실패
			view = "/www/reBoard/reBoardWrite.blp";
			mv.addObject("MSG", "게시글 등록에 실패했습니다.");			
		} else {
			//성공
			nowPage = "1";
			mv.addObject("MSG", "게시글 등록에 성공했습니다.");			
		}
		
		mv.addObject("VIEW", view);
		mv.addObject("NOWPAGE", nowPage);
		
		mv.setViewName("reBoard/redirect");
		return mv;
	}
}
