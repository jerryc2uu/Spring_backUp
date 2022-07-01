package com.githrd.www.service;

import javax.servlet.http.HttpSession;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.githrd.www.dao.*;
import com.githrd.www.vo.*;

@Service //sevice 클래스를 bean 처리 해주는 어노테이션
@Aspect
public class LoginLogService {
	private static Logger loginLog = LoggerFactory.getLogger("memberLog"); // static : 스태틱 멤버로 올릴 때
	private static Logger boardLog = LoggerFactory.getLogger("boardLog"); // static : 스태틱 멤버로 올릴 때
	private static Logger gBoardLog = LoggerFactory.getLogger("gBoardLog"); // static : 스태틱 멤버로 올릴 때
	private static Logger reBoardLog = LoggerFactory.getLogger("reBoardLog"); // static : 스태틱 멤버로 올릴 때
	
	@Autowired
	BoardDao bDao;
	/*
		@Pointcut : 처리기가 실행될 시점을 지정(요청처리함수)
		
		[참고] 
			패턴 지정 형식은 
				execution(* 패키지경로.Member.**Proc(..)) ==> Member 클래스의 함수 중 Proc로 끝나는 함수들 모두를 의미
		
		@After : 요청 처리함수가 실행된 후에 실행
		@Before : 요청 처리 함수가 실행되기 전에 실행
		@Arround : 실행 전 + 실행 후
	*/
	@Pointcut("execution(* com.githrd.www.controller.Member.loginProc(..))") //이 함수가 실행될 때 아래 함수를 실행하겠따~~
	public void recordLogin() {
		System.out.println("######## aop start ##########");
	}
	
	@After("recordLogin()")
	public boolean rec(JoinPoint join) {
		MemberVO mVO = (MemberVO) join.getArgs()[1]; //매개변수 리스트를 배열 타입으로 추출
		
		if(mVO.getCnt() == 1) {
			loginLog.info(mVO.getId() + " 님 로그인");
		}
		return true;
	}
	
	@Before("execution(* com.githrd.www.controller.Member.logoutProc(..))")
	public void logoutSetData(JoinPoint join) {
		HttpSession session = (HttpSession) join.getArgs()[1];
		MemberVO mVO = (MemberVO) join.getArgs()[2];
		mVO.setId((String) session.getAttribute("SID"));
	}
	
	@After("execution(* com.githrd.www.controller.Member.logoutProc(..))")
	public void logoutRecord(JoinPoint join) {
		MemberVO mVO = (MemberVO) join.getArgs()[2];
		String id = mVO.getId();
		String result = mVO.getResult();
		
		if(result != null && result.equals("OK")) {
			loginLog.info(id + " 님 로그아웃");
		}
	}
	
	@Before("execution(* com.githrd.www.controller.Board.boardWriteProc(..))")
	public void setBoardMnoData(JoinPoint join) {
		BoardVO bVO = (BoardVO) join.getArgs()[1];
		String id = bVO.getId();
		
		bVO.setMno(bDao.getMno(id));
	}
	
	@After("execution(* com.githrd.www.controller.**.**WriteProc(..))")
	public void boardLogWrite(JoinPoint join) {
		BoardVO bVO = (BoardVO) join.getArgs()[1];
		String result = bVO.getResult();
		String id = bVO.getId();
		int bno = bVO.getBno();
		
		if(result.equals("OK")){
			//정상 등록
			boardLog.info(id + " 회원님이 [ " + bno + " ] 번 게시글을 작성했습니다.");
		}
	}
	
	//글 삭제 로그
	@After("execution(* com.githrd.www.controller.Board.delBoard(..))")
	public void boardLogDel(JoinPoint join) {
		BoardVO bVO = (BoardVO) join.getArgs()[1];
		String result = bVO.getResult();
		String id = bVO.getId();
		int bno = bVO.getBno();
		
		if(result.contentEquals("OK")) {
			//정상 삭제
			boardLog.info(id + " 회원님이 [ " + bno + " ] 번 게시글을 삭제했습니다.");
		}
	}
}
