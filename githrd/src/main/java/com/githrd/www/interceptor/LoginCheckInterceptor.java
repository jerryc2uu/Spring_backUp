package com.githrd.www.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 회원 관련 요청 시 
 * 로그인이 되어 있는 경우 메인 페이지로 돌려보내는 작업을 처리할
 * 인터셉터 클래스
 * @author	박소연
 * @since	2022.06.24
 * @version	v.1.0
 * 
 * 					작업 이력 ]
 * 						2022/06/24	-	담당자 : 박소연
 * 										클래스 제작
 *
 */
//@Component => 붙는 순간 bean 처리(자동 new) 끝
@Service
public class LoginCheckInterceptor implements HandlerInterceptor {

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler)
			throws Exception {
		System.out.println("----------------------");
		
		if(req.getSession().getAttribute("SID") != null) {
			resp.sendRedirect("/www/main.blp");
			return false; //원래 요청 함수 실행 NO
		}
		return true; // 원래 요청 함수 실행 OK
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {

	}

}
