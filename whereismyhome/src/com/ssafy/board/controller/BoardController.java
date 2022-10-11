package com.ssafy.board.controller;

import java.io.IOException;
import java.io.PrintWriter;
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

import com.ssafy.board.model.BoardDto;
import com.ssafy.board.model.dao.BoardDao;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.member.model.Member;
import com.ssafy.util.ParameterCheck;

@WebServlet("/board")
public class BoardController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private BoardService boardService;
    private Map<String, String> map;

    public void init() {
        boardService = BoardServiceImpl.getBoardService();
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
        path = "/board/write.jsp";
        redirect(request, response, path);
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
    } else {
        redirect(request, response,path);
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

private String list(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    Member memberDto = (Member) session.getAttribute("member");
    System.out.println(memberDto);
    try {
        List<BoardDto> list=boardService.listArticle(map);
        request.setAttribute("articles", list);
        return "/board/list.jsp";
    } catch (Exception e) {
        e.printStackTrace();
        request.setAttribute("msg", "글 목록 로딩 중 에러 발생!!");
        return "/error/error.jsp";
    }
    
}

private String write(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    Member memberDto = (Member) session.getAttribute("member");
    
    if(memberDto !=null) {
        BoardDto boardDto = new BoardDto();
        boardDto.setUserId(memberDto.getUserId());
        boardDto.setSubject(request.getParameter("subject"));
        boardDto.setContent(request.getParameter("content"));
        try {
            boardService.writeArticle(boardDto);
            return "/board?command=list&pgno=1&key=&word=";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "글 작성 중 에러 발생!!");
            return "/error/error.jsp";
        }
    }else {
        return "/member/login.jsp";
    }
}

private String view(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    Member memberDto = (Member) session.getAttribute("member");
    if(memberDto !=null) {
        try {
            int articleNo= Integer.parseInt(request.getParameter("articleno"));
            BoardDto boardDto = boardService.getArticle(articleNo);
            boardService.updateHit(articleNo);
            request.setAttribute("article", boardDto);
            return "/board/view.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "글 로딩 중 에러 발생!!");
            return "/error/error.jsp";
        }
    }else {
        return "/member/login.jsp";
    }
}

private String mvModify(HttpServletRequest request, HttpServletResponse response) {
    BoardDto boardDto=null;
    try {
        boardDto= boardService.getArticle(Integer.parseInt(request.getParameter("articleno")));
        request.setAttribute("article", boardDto);
    } catch (NumberFormatException e) {
        e.printStackTrace();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "/board/modify.jsp";
}

private String modify(HttpServletRequest request, HttpServletResponse response)  {
    HttpSession session = request.getSession();
    Member memberDto = (Member) session.getAttribute("member");
    
    if(memberDto !=null) {
        try {
            BoardDto boardDto = boardService.getArticle(Integer.parseInt(request.getParameter("article_no")));
            boardDto.setSubject(request.getParameter("subject"));
            boardDto.setContent(request.getParameter("content"));
            boardService.modifyArticle(boardDto);
            request.setAttribute("article", boardDto);
            return "/board/view.jsp";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "글 작성 중 에러 발생!!");
            return "/error/error.jsp";
        }
    }else {
        return "/member/login.jsp";
    }
}

private String delete(HttpServletRequest request, HttpServletResponse response) {
    HttpSession session = request.getSession();
    Member memberDto = (Member) session.getAttribute("member");
    if(memberDto !=null) {
        try {
            int articleNo= Integer.parseInt(request.getParameter("articleno"));
            boardService.deleteArticle(articleNo);
            return "/board?command=list&pgno="+map.get("pgno")+"&key=&word=";
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "글 삭제 중 에러 발생!!");
            return "/error/error.jsp";
        }
    }else {
        return "/member/login.jsp";
    }
}
}
