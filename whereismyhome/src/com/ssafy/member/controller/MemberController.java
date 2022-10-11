package com.ssafy.member.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ssafy.dong.model.Dong;
import com.ssafy.dong.model.service.DongServiceImpl;
import com.ssafy.dong.model.service.IDongService;
import com.ssafy.interest.model.InterestDto;
import com.ssafy.interest.model.service.InterestService;
import com.ssafy.interest.model.service.InterestServiceImpl;
import com.ssafy.member.model.Member;
import com.ssafy.member.model.service.MemberService;
import com.ssafy.member.model.service.MemberServiceImpl;

@WebServlet("/member")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MemberService memberService;
	private InterestService interestService;
	private IDongService dongService;
	public void init() {
		memberService= MemberServiceImpl.getMemberService();
		interestService= InterestServiceImpl.getInterestService();
		dongService = DongServiceImpl.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		System.out.println(command+"이거로 들어옴!");
		String path = "/index.jsp";
//		if("mvjoin".equals(command)) {
//			path="/user/join.jsp";
//			redirect(request,response,path);
//		}
		
		switch(command) {
		case "goRegist":
			redirect(request, response, "/member/register.jsp");
			break;
		case "regist":
			path= doRegist(request,response);
			forward(request, response, path);
			break;
		case "goLogin":
			redirect(request, response, "/member/login.jsp");
			break;
		case "login":
			path= doLogin(request,response);
			forward(request, response, path);
			break;
		case "logout":
			path= doLogout(request,response);
			forward(request, response, path);
			break;
		case "goFindPwd":
			redirect(request, response, "/member/findPwd.jsp");
			break;	
		case "findPwd":
			path= doFindPwd(request,response);
			forward(request, response, path);
			break;
		case "goInfo":
			path = getInfo(request,response);
			forward(request, response, path);
			break;	
		case "update":
			path = doUpdate(request,response);
			forward(request, response, path);
			break;	
		case "goList":
			path = getList(request,response);
			forward(request, response, path);
			break;	
		case "delete":
			path = doDel(request,response);
			redirect(request, response, path);
			break;
		case "interest":
			path = doInter(request,response);
			redirect(request, response, path);
			break;
		}
		
	}
	private String doInter(HttpServletRequest request, HttpServletResponse response) {
	    HttpSession session = request.getSession();
	    Member memberDto = (Member) session.getAttribute("member");
	    if(memberDto !=null) {
	    	
	    	try {
	    		List<InterestDto> interests = interestService.getList(memberDto.getUserId());
	    		List<Dong> dongs = null;
	    		
	    		if(interests !=null) {
	    			for(InterestDto i : interests) {
	    				Dong d = dongService.select(i.getDongCode());
	    				dongs.add(d);
	    			}
	    		}
	    		
	    		session.setAttribute("dongs", dongs);
	    		return "/member/interest.jsp";
	    		
	    	} catch (Exception e) {
	    		e.printStackTrace();
	    		request.setAttribute("msg", "관심지역 정보 가져오는 중 에러 발생");
	    		return "/error/error.jsp";
	    	}
	    }else {
	    	return "/member/login.jsp";
	    }
	}
	private String doDel(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		try {
			memberService.delete(id);
			return "/member?command=goList";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원 삭제 중 에러 발생");
			return "/error/error.jsp";
		}
	}
	private String getList(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Member> members = memberService.getList();
			if(members!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("members", members);
				return "/member/list.jsp";
			}else { // 로그인 실패
				request.setAttribute("msg", "회원이 없습니다.");
				return "/error/error.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원 정보 가져오는 중 에러 발생");
			return "/error/error.jsp";
		}
	}
	private String doUpdate(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("들어옴");
		Member member = new Member();
		member.setUserId(request.getParameter("userid"));
		member.setUserName(request.getParameter("username"));
		member.setUserPwd(request.getParameter("userpwd"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setRole(request.getParameter("role"));
		String emailId= request.getParameter("emailid");
		String emailDomain = request.getParameter("emaildomain");
		member.setEmail(emailId+"@"+emailDomain);
		try {
			memberService.update(member);
			return "/member?command=goInfo&id="+member.getUserId();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원 정보 수정 중 에러 발생");
			return "/error/error.jsp";
		}
	}
	private String getInfo(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println(id);
		try {
			Member member = memberService.getInfo(id);
			if(member!=null) {
				request.setAttribute("name", member.getUserName());
				request.setAttribute("user_id", member.getUserId());
				request.setAttribute("age", member.getAge());
				String[] email = member.getEmail().split("@");
				request.setAttribute("emailId", email[0]);
				request.setAttribute("emailDomain", email[1]);
				return "/member/info.jsp";
			} else {
				request.setAttribute("msg", "일치하는 계정이 없습니다.");
				return "/error/error.jsp";
			}
		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "계정 정보 불러오는 중 에러 발생");
			return "/error/error.jsp";
		}
	}
	private String doFindPwd(HttpServletRequest request, HttpServletResponse response) {
		String userName= request.getParameter("username");
		String userId= request.getParameter("userid");
		try {
			Member member = memberService.findPwd(userName,userId);
//			System.out.println(member.toString());
			if(member!=null) {
				request.setAttribute("title", "비밀번호 결과");
				request.setAttribute("subtitle", "찾았습니다 !");
				request.setAttribute("msg", "비밀번호는   "+member.getUserPwd()+"   입니다.");
				request.setAttribute("src", "./member?command=goLogin");
				request.setAttribute("srcTitle", "로그인 페이지로 이동");
				return "/notice/notice.jsp";
			}else {
				request.setAttribute("msg", "일치하는 계정이 없습니다.");
				return "/member/findPwd.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "비밀번호 찾는 중 에러 발생");
			return "/error/error.jsp";
		}
	}
	private String doLogout(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		session.invalidate();
		return "/index.jsp";
	}
	private String doLogin(HttpServletRequest request, HttpServletResponse response) {
		String userId= request.getParameter("userid");
		String userPwd= request.getParameter("userpwd");
		try {
			Member member = memberService.login(userId, userPwd);
			if(member!=null) {
				HttpSession session = request.getSession();
				session.setAttribute("id", member.getUserId());
				session.setAttribute("name", member.getUserName());
				session.setAttribute("role", member.getRole());
				session.setAttribute("member", member);
				return "./index.jsp";
			}else { // 로그인 실패
				request.setAttribute("msg", "아이디 또는 비밀번호 확인 후 다시 로그인!!");
				return "/member/login.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "로그인 처리 중 에러 발생");
			return "/error/error.jsp";
		}
	}
	private String doRegist(HttpServletRequest request, HttpServletResponse response) {
		Member member = new Member();
		member.setUserId(request.getParameter("userid"));
		member.setUserName(request.getParameter("username"));
		member.setUserPwd(request.getParameter("userpwd"));
		member.setAge(Integer.parseInt(request.getParameter("age")));
		member.setRole(request.getParameter("role"));
		String emailId= request.getParameter("emailid");
		String emailDomain = request.getParameter("emaildomain");
		member.setEmail(emailId+"@"+emailDomain);
		member.setDelflag(0);
		
		try {
			memberService.regist(member);
			return "/member?command=goLogin";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원가입 처리 중 에러 발생");
			return "/error/error.jsp";
		}
	}
	private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException  {
		RequestDispatcher disaptcher= request.getRequestDispatcher(path);
		disaptcher.forward(request, response);
	}
	
	private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
		System.out.println(request.getContextPath());
		response.sendRedirect(request.getContextPath()+ path);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		doGet(request,response);
	}

}
