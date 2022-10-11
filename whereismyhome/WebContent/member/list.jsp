<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<c:if test="${members == null}">
	<script type="text/javascript">
		alert("정상적인 URL 접근이 아닙니다.");
		location.href = "${root}/indes.jsp";
	</script>
</c:if>
<div style="height : 70px"></div>
<div class="row justify-content-center">
	<div class="col-lg-8 col-md-10 col-sm-12">
		<h2 class="my-3 py-3 shadow-sm bg-light text-center">
			<mark class="sky">회원 목록</mark>
		</h2>
	</div>
	<div class="col-lg-8 col-md-10 col-sm-12">
		<table class="table table-hover">
			<thead>
				<tr class="text-center">
					<th scope="col">아이디</th>
					<th scope="col">이름</th>
					<th scope="col">나이</th>
					<th scope="col">역할</th>
					<th scope="col">삭제</th>
				</tr>
			</thead>
			<tbody>
			<c:forEach var="member" items='${members }'>
				<c:if test="${member.delflag eq 0}">
					<c:if test="${member.role ne 'admin'}">
					<tr class="text-center">
						<td>${member.userId }</td>
						<td>${member.userName }</td>
						<td>${member.age  }</td>
						<td>${member.role  }</td>
						<td><a href="./member?command=delete&id=${member.userId }">삭제</a></td>
					</tr>
					</c:if>
				</c:if>
				
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="row">
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link" href="#">이전</a></li>
			<li class="page-item"><a class="page-link" href="#">1</a></li>
			<li class="page-item active"><a class="page-link" href="#">2</a>
			</li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">4</a></li>
			<li class="page-item"><a class="page-link" href="#">5</a></li>
			<li class="page-item"><a class="page-link" href="#">다음</a></li>
		</ul>
	</div>
</div>
</div>
<form id="form-no-param" method="get" action="${root }/board">
	<input type="hidden" id="act" name="command" value="view"> 
	<input		type="hidden" id="pgno" name="pgno" value="${param.pgno }"> 
	<input		type="hidden" id="key" name="key" value="${param.key }"> 
	<input		type="hidden" id="word" name="word" value="${param.word }"> 
	<input		type="hidden" id="articleno" name="articleno" value="">
</form>
<script>
	let titles = document.querySelectorAll(".article-title");
	titles.forEach(function(title) {
		title.addEventListener("click", function() {
			document.querySelector("#articleno").value= this.getAttribute("data-no");
			document.querySelector("#form-no-param").submit();
		});
	});

	document.querySelector("#btn-mv-register").addEventListener("click",
			function() {
				location.href = "${root}/board?command=mvwrite";
			});

	document.querySelector("#btn-search").addEventListener("click", function() {
		let form = document.querySelector("#form-search");
		form.setAttribute("action", "${root}/board");
		form.submit();
	});
</script>
<%@ include file="/common/footer.jsp"%>
