<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />    
<!DOCTYPE html>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<%@include file ="/WEB-INF/include.jsp" %>
  <title>구해줘 Home</title>
</head>
<body>
	<%@include file ="/common/header.jsp" %>
	<%@include file ="/WEB-INF/main.jsp" %>
	<%@include file ="/common/footer.jsp" %>
</body>
</html>