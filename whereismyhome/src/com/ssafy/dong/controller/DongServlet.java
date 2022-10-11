package com.ssafy.dong.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssafy.dong.model.service.DongServiceImpl;
import com.ssafy.dong.model.service.IDongService;

@WebServlet("/dong")
public class DongServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private IDongService dservice;
    
    public void init() {
    	dservice = DongServiceImpl.getInstance();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		String path = "/index.jsp";
		
		switch(command) {
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
