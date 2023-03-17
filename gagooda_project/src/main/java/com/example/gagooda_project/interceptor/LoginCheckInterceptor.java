package com.example.gagooda_project.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component //스프링이 컨테이너에서 이 클래스를 객체로 관리할 수 있게 해주는 어노테이션
public class LoginCheckInterceptor implements HandlerInterceptor {
    Logger log = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();
        Object loginUser_obj=session.getAttribute("loginUser");
        String url = request.getRequestURI();
        String querString=request.getQueryString();
        url+=(querString!=null)?"?"+querString:"";
        log.info("preHandle(url) : "+ url);
        String method = request.getMethod();
        System.out.println(method);
        if(loginUser_obj==null) {
            session.setAttribute("msg", "로그인 후 이용 가능한 서비스 입니다.");
            if (request.getMethod().equals("GET")) {
                session.setAttribute("getUrl", url);
            } else {
                session.setAttribute("postUrl", true);
            }
            response.sendRedirect("/user/login.do");
            return false;
        }
        return true; //true or false
    }

    //동적 페이지에서 view를 렌더링(합성) 하기 전
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
    }

    //동적 페이지에서 view를 렌더링한 후, 요청 처리가 다 끝나서 응답하기 직전
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
    }
}
