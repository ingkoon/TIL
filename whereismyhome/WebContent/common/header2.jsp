<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath}" />
<c:if test="${empty userinfo}">
	<script type="text/javascript">
		alert("로그인 후 이용 가능한 페이지입니다.");
		location.href = "${root}/user?command=mvlogin";
	</script>
</c:if>
<header>
	<jsp:include page="/WEB-INF/nav.jsp"></jsp:include>
	<jsp:include page="/WEB-INF/modals.jsp"></jsp:include>
</header>

<body>
	<div class="container">
		<c:if test="${!empty userinfo}">
			<%@ include file="/common/confirm.jsp"%>
		</c:if>
	</div>
</body>