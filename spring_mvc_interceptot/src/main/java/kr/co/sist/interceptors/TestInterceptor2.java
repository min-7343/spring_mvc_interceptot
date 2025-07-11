package kr.co.sist.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//1. HandlerInterceptor를 구현
// - Bean 만들기 : 웹서비스도 아님, 업무로직도 아님,  DB처리도 아님 ->  @Component
@Component
public class TestInterceptor2 implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("요청 URI : "+request.getRequestURI());
		System.out.println("1번 - TestInterceptor2 preHandle호출 : handlerMapper 호출 전 실행");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("2번 - TestInterceptor2 postHandle호출 : View (JSP, HTML)가 호출, 생성 전 실행");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("3번 - TestInterceptor2 afterCompletion호출 : View가 응답 전 실행");
	}

	
}//class
