package com.ssafy.interest.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.tribes.util.Arrays;

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.dong.model.Dong;
import com.ssafy.dong.model.service.DongServiceImpl;
import com.ssafy.dong.model.service.IDongService;
import com.ssafy.housedeal.model.HouseDealInfo;
import com.ssafy.housedeal.model.service.HouseDealServiceImpl;
import com.ssafy.housedeal.model.service.IHouseDealService;
import com.ssafy.interest.model.InterestDto;
import com.ssafy.interest.model.service.InterestService;
import com.ssafy.interest.model.service.InterestServiceImpl;
import com.ssafy.member.model.Member;
import com.ssafy.util.ParameterCheck;

@WebServlet("/interest")
public class InterestController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private Map<String, String> map;
    private InterestService interestService;
    private IDongService dongService;
	IHouseDealService hdservice;
    
    public void init() {
        interestService= InterestServiceImpl.getInterestService();
		dongService = DongServiceImpl.getInstance();
		hdservice = HouseDealServiceImpl.getInstance();
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    String command = request.getParameter("command");
    
    int pgNo= ParameterCheck.notNumberToOne(request.getParameter("pgno"));
    String key= ParameterCheck.nullToBlank(request.getParameter("key"));
    String word= ParameterCheck.nullToBlank(request.getParameter("word"));
    String queryString = "?pgno="+pgNo+"&key="+key+"&word="+word;
    map= new HashMap<>();
    map.put("pgno", pgNo+"");
    map.put("key", key);
    map.put("word", word);
    
    String path = "/index.jsp";
    if("list".equals(command)) {
        path = list(request, response);
        forward(request, response, path+queryString);
    } else if("mvwrite".equals(command)) {
        path = mvwrite(request, response);
        forward(request, response, path);
    } else if("write".equals(command)) {
        path = write(request, response);
        forward(request, response, path);
    } else if("view".equals(command)) {
        path = view(request, response);
        forward(request, response, path+queryString);
    } else if("mvmodify".equals(command)) {
        path = mvModify(request, response);
        forward(request, response, path);
    } else if("modify".equals(command)) {
        path = modify(request, response);
        forward(request, response, path);
    } else if("delete".equals(command)) {
        path = delete(request, response);
        redirect(request, response, path);
    } else if("detail".equals(command)) {
        path = detail(request, response);
        forward(request, response, path);
    } else {
        redirect(request, response,path);
    }
}

private String detail(HttpServletRequest request, HttpServletResponse response) {
	String dongCode = request.getParameter("dongCode");
	System.out.println(dongCode);
	try {
		List<HouseDealInfo> list = hdservice.getHouseDealFull(dongCode);
		request.setAttribute("infos", list);
		return "/interest/detail.jsp";
	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("msg", "관심지역 작성 중 에러 발생!!");
        return "/error/error.jsp";
	}
}

private void forward(HttpServletRequest request, HttpServletResponse response, String path) throws ServletException, IOException {
    RequestDispatcher dispatcher = request.getRequestDispatcher(path);
    dispatcher.forward(request, response);
}

private void redirect(HttpServletRequest request, HttpServletResponse response, String path) throws IOException {
    response.sendRedirect(request.getContextPath() + path);
}

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    request.setCharacterEncoding("utf-8");
    doGet(request, response);
}


private String mvwrite(HttpServletRequest request, HttpServletResponse response) {
	
	return "/interest/write.jsp";
}


private String list(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    Member memberDto = (Member) session.getAttribute("member");
    if(memberDto !=null) {
    	try {
    		List<InterestDto> interests = interestService.getList(memberDto.getUserId());
    		List<Dong> dongs = new ArrayList<Dong>();
    		System.out.println(Arrays.toString(interests.toArray()));
    		if(interests !=null) {
    			for(InterestDto i : interests) {
    				System.out.println(i.getDongCode());
    				Dong d = dongService.select(i.getDongCode());
    				System.out.println(d);
    				dongs.add(d);
    			}
    		}
    		
    		session.setAttribute("dongs", dongs);
    		return "/interest/list.jsp";
    		
    	} catch (Exception e) {
    		e.printStackTrace();
    		request.setAttribute("msg", "관심지역 정보 가져오는 중 에러 발생");
    		return "/error/error.jsp";
    	}
    }else {
    	return "/member/login.jsp";
    }
}

private String write(HttpServletRequest request, HttpServletResponse response) {
	String dongCode = request.getParameter("dong");
	HttpSession session = request.getSession();
    Member memberDto = (Member) session.getAttribute("member");
	
    InterestDto interestDto = new InterestDto();
    interestDto.setUser_id(memberDto.getUserId());
    interestDto.setDongCode(dongCode);
    
    try {
		interestService.insert(interestDto);
		return "/interest?command=list";
	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("msg", "관심지역 작성 중 에러 발생!!");
        return "/error/error.jsp";
	}
}

private String view(HttpServletRequest request, HttpServletResponse response) {
	return null;
}

private String mvModify(HttpServletRequest request, HttpServletResponse response) {
	return null;
	}

private String modify(HttpServletRequest request, HttpServletResponse response)  {
	return null;
}

private String delete(HttpServletRequest request, HttpServletResponse response) {
	String user_id = request.getParameter("user_id");
	String dongCode = request.getParameter("dongCode");
	
	try {
		interestService.delete(user_id, dongCode);
		return "/interest?command=list";
	} catch (Exception e) {
		e.printStackTrace();
		request.setAttribute("msg", "관심지역 삭제 중 에러 발생");
		return "/error/error.jsp";
	}
}
}
