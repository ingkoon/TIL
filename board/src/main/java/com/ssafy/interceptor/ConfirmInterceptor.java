package com.ssafy.interceptor;

import com.ssafy.member.model.MemberDto;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
public class ConfirmInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler) throws Exception{
        HttpSession session = request.getSession();
        MemberDto memberDto = (MemberDto) session.getAttribute("userinfo");
        if(memberDto==null){
            response.sendRedirect(request.getContextPath() + "/user/login");
            return false;
        }
        return true;
    }
}
