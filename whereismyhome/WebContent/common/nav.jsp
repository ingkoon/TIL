<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />    
<%
	String id = (String)session.getAttribute("id");
	//String pw = (String)session.getAttribute("pw");
	//String email = (String)session.getAttribute("email");
	//String location = (String)session.getAttribute("location");
	//String phone = (String)session.getAttribute("phone");
	String name = (String)session.getAttribute("name");
%>

<nav class="navbar navbar-expand-lg navbar-light bg-light shadow fixed-top">
  <div class="container">
   <a class="navbar-brand text-dark fw-bold" href="index.jsp">
     <img src="./img/whereismyhome.png" alt="" width="60" />
     	HappyHouse
   </a>
   <div class="collapse navbar-collapse flex-row-reverse" id="navbarSupportedContent">
   <% 
   
   	if(id==null){
		%>  
		<ul class="navbar-nav mb-2 me-2 mb-lg-0">
			<li>
	       <li class="nav-item">
	         <a class="nav-link" id="btn-list" aria-current="page" href="#" >공지사항</a>
	       </li>
	       <li class="nav-item">
	         <a class="nav-link" aria-current="page" href="./member?command=goRegist">회원가입</a>

	       </li>
	       <li class="nav-item">
	         <a class="nav-link" aria-current="page" href="./member?command=goLogin">로그인</a>
	       </li>
	     </ul>
		<%   		
   	}else{
   		%>
   		<ul class="navbar-nav mb-2 me-2 mb-lg-0">
	   	   <li class="nav-item">
	          <a class="nav-link" aria-current="page" href="./member?command=goInfo&id=${id}">반갑습니다 <%= id %> 님</a>
	       </li>
	       	<li>
	         <a class="nav-link" id="btn-list" aria-current="page" href="#" >공지사항</a>
	       </li>
	       <li class="nav-item">
	         <a class="nav-link" aria-current="page" href="./member?command=logout">로그아웃</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" aria-current="page" href="#" data-bs-toggle="modal" data-bs-target="#main_user_info">회원정보</a>
	        </li>
	        <li class="nav-item">
	          <a class="nav-link" aria-current="page" href="./interest?command=list">관심지역</a>
	        </li>
	      </ul>
	    </div> 
	  </div>
   		<%
   	}
   
   %>
</nav>

<script>
	document.querySelector("#btn-list").addEventListener("click", function() {
		let form = document.querySelector("#form-param");
		document.querySelector("#command").value = "list";
		form.setAttribute("action", "${root}/board");
		form.submit();
	});

	/*document.querySelector("#btn-mv-modify").addEventListener("click",
			function() {
				let form = document.querySelector("#form-no-param");
				document.querySelector("#ncommand").value = "mvmodify";
				form.setAttribute("action", "${root}/board");
				form.submit();
			});*/

	document.querySelector("#btn-delete").addEventListener("click", function() {
		if (confirm("정말 삭제하시겠습니까?")) {
			let form = document.querySelector("#form-no-param");
			document.querySelector("#ncommand").value = "delete";
			form.setAttribute("action", "${root}/board");
			form.submit();
		}
	});
</script>

<script
  src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
  integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
  crossorigin="anonymous"
></script>