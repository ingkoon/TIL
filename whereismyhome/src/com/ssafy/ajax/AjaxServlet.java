package com.ssafy.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.ssafy.dong.model.Dong;
import com.ssafy.dong.model.service.DongServiceImpl;
import com.ssafy.dong.model.service.IDongService;
import com.ssafy.housedeal.model.service.HouseDealServiceImpl;
import com.ssafy.housedeal.model.service.IHouseDealService;

@WebServlet("/ajax")
public class AjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IDongService dservice = DongServiceImpl.getInstance();
	IHouseDealService hdservice = HouseDealServiceImpl.getInstance();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String command = request.getParameter("command");
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		System.out.println("ajax : "+command+"로 들어옴");
		switch(command) {
		case "sidoNames":
			doGetSidoNames(request,response);
			break;
		case "gugunNames":
			doGetGugunNames(request,response);
			break;
		case "dongNames":
			doGetDongNames(request,response);
			break;
		case "searchHouseDealInfo":
			dosearchHouseDealInfo(request,response);
			break;
		}
	}
	private void dosearchHouseDealInfo(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub
		String fullCode = request.getParameter("fullCode");
		String dealYear = request.getParameter("dealYear");
		String dealMonth = request.getParameter("dealMonth");
		System.out.println(fullCode + " "+dealYear+" "+dealMonth);
		Gson gson = new Gson();
		String result = "";
		try {
			result = gson.toJson(hdservice.getHouseDeal(fullCode, dealYear, dealMonth));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		out.print(result);
		out.flush();
	}
	private void doGetSidoNames(HttpServletRequest request, HttpServletResponse response) throws IOException {
		// TODO Auto-generated method stub

		Gson gson = new Gson();
		String result = "";
		try {
			result = gson.toJson(dservice.getSidoNames());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		out.print(result);
		out.flush();
	}
	private void doGetGugunNames(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sidoName = request.getParameter("sidoName"); 
		System.out.println(sidoName);
		Gson gson = new Gson();
		String result = "";
		try {
			result = gson.toJson(dservice.getGugunNames(sidoName));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		out.print(result);
		out.flush();
	}
	private void doGetDongNames(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String sidoName = request.getParameter("sidoName"); 
		String gugunName = request.getParameter("gugunName"); 
		Dong dong = new Dong();
		dong.setSidoName(sidoName);
		dong.setGugunName(gugunName);
		Gson gson = new Gson();
		String result = "";
		try {
			result = gson.toJson(dservice.getDongNames(dong));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(result);
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		out.print(result);
		out.flush();
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	public  void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=UTF-8");
		
		Gson gson = new Gson();
		String employeeJsonString = "";
//		try {
////			employeeJsonString = gson.toJson(bservice.select());
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		PrintWriter out = response.getWriter();
		response.setContentType("application/json");
		response.setCharacterEncoding("utf-8");
		out.print(employeeJsonString);
		out.flush();
	}
	
}