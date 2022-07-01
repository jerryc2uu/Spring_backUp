package com.githrd.www.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.githrd.www.dao.*;
import com.githrd.www.service.BoardService;
import com.githrd.www.vo.*;
import com.githrd.www.util.*;

/**
 * 이 클래스는 파일 게시판 관련된 요청 처리할 컨트롤러
 * @author	박소연
 * @since	2022.06.17	
 * @version v.1.0
 * 
 * 			작업이력]
 * 					
 * 				2022.06.17	-	담당자 : 박소연
 * 								
 * 								클래스 제작
 * 								게시글 리스트 보기 요청 함수 제작
 * 				
 * 				2022.06.22	-	담당자 : 박소연
 * 								게시글 등록 요청 처리 함수 추가
 */
@Controller
@RequestMapping("/board")
public class Board {
	
	@Autowired
	BoardDao bDao;
	@Autowired
	BoardService bSrvc;
	
	//게시글 리스트 폼보기 요청
	@RequestMapping("/boardList.blp")
	public ModelAndView boardList(ModelAndView mv, PageUtil page) {
		// 총 게시글 수 가져오고
		int total = bDao.getTotal();
		// 해당 페이지의 페이지 정보 만들고
		page.setPage(total);	
		// 해당 페이지의 글 목록 가져옴
		List<BoardVO> list = bDao.getList(page);
		// 데이터 심고
		mv.addObject("LIST", list);
		mv.addObject("PAGE", page);
		// 뷰 부르고
		mv.setViewName("board/boardList");
		// 반환
		return mv;
	}
	
	//게시글 상세 페이지 폼보기 요청
	@RequestMapping(path="/boardDetail.blp", method=RequestMethod.POST, params={"bno", "nowPage"})
	public ModelAndView boardDetail(ModelAndView mv, BoardVO bVO) {
	
		//첨부파일 리스트 조회
		List<FileVO> list = bDao.getFileList(bVO.getBno());
		bVO = bDao.getDetail(bVO.getBno());
		
		//데이터 심고
		mv.addObject("DATA", bVO);
		mv.addObject("LIST", list);	
		
		//뷰
		mv.setViewName("board/boardDetail");
		return mv;
	}
	
	//파일게시판 글쓰기 폼보기 요청 처리 함수
	@RequestMapping("/boardWrite.blp")
	public ModelAndView boardWrite(ModelAndView mv) {
		mv.setViewName("board/boardWrite");
		return mv;
	}
	
	//파일게시판 글등록 요청 처리 함수
	@RequestMapping("/boardWriteProc.blp")
	public ModelAndView boardWriteProc(ModelAndView mv, BoardVO bVO, String nowPage) {
		String view = "/www/board/boardList.blp";
		System.out.println("************ " + bVO.getMno());
		try {
			bSrvc.addBoardData(bVO);
			//정상 등록
			bVO.setResult("OK");
			nowPage = "1";
		} catch(Exception e) {
			// 게시글 등록 실패
			// 결과적으로 롤백된 경우
			//get방식
			//view = "/www/board/boardWrite.blp?nowPage=" + nowPage;
			bVO.setResult("NO");
			view = "/www/board/boardWrite.blp";
			e.printStackTrace();
		}
		
		mv.addObject("NOWPAGE", nowPage);
		mv.addObject("VIEW", view);

		mv.setViewName("board/redirect");
		return mv;
	}
	
	//파일 게시판 글 수정 폼보기 요청
	@RequestMapping(path="/boardEdit.blp", method=RequestMethod.POST, params= {"nowPage", "bno"})
	public ModelAndView boardEdit(ModelAndView mv, BoardVO bVO) {
		//첨부파일 리스트 조회
		List<FileVO> list = bDao.getFileList(bVO.getBno());
		bVO = bDao.getDetail(bVO.getBno());
		
		//데이터 심고
		mv.addObject("DATA", bVO);
		mv.addObject("LIST", list);	
		mv.setViewName("board/boardEdit");
		return mv;
	}
	
	//첨부파일 삭제 요청 처리 함수
	@RequestMapping(path="/fileDel.blp", method=RequestMethod.POST, params="fno")
	@ResponseBody
	public HashMap<String, String> fileDel(FileVO fVO) {
		
		 HashMap<String, String> map = new  HashMap<String, String>();
		 String result = "OK";
		 
		 int cnt = bDao.delFile(fVO.getFno());
		 
		 if(cnt != 1) {
			 result = "NO";
		 }
		 
		 map.put("result", result);
		 return map;
	}
	
	//게시글 수정 요청 처리 함수
	@RequestMapping("/boardEditProc.blp")
	public ModelAndView boardEditProc(ModelAndView mv, BoardVO bVO, String nowPage) {
		String view = "/www/board/boardDetail.blp";
		
		try {
			bSrvc.editBoard(bVO);
		} catch(Exception e) {
			e.printStackTrace();
			view = "/www/board/boardEdit.blp";
		}
		
		mv.addObject("VIEW", view);
		mv.addObject("NOWPAGE", nowPage);
		
		mv.setViewName("board/redirect");
		return mv;
	}
	
	// 게시글 삭제 요청 함수
	@RequestMapping("/boardDel.blp")
	public ModelAndView delBoard(ModelAndView mv, BoardVO bVO, String nowPage) {
		int cnt = bDao.delBoard(bVO.getBno());
		
		String view = "/www/board/boardList.blp";
		
		if(cnt != 1) {
			bVO.setResult("NO");
			view = "/www/board/boardDetail.blp";
		}
		
		bVO.setResult("OK");
		mv.addObject("VIEW", view);
		mv.addObject("NOWPAGE", nowPage);
		
		mv.setViewName("board/redirect");
		return mv;
	}
}
