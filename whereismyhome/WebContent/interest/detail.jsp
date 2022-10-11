<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="/common/header.jsp"%>
<div style="height : 70px"></div>
<div class="row justify-content-center">
	<div class="col-lg-8 col-md-10 col-sm-12">
		<h2 class="my-3 py-3 shadow-sm bg-light text-center">
			<mark class="sky">관심지역 정보</mark>
		</h2>
	</div>
	<div class="col-lg-8 col-md-10 col-sm-12">
		<table class="table table-hover text-center">
			<thead>
				<tr>
		          <th>아파트이름</th>
		          <th>층</th>
		          <th>면적</th>
		          <th>법정동</th>
		          <th>거래금액</th>
		        </tr>
			</thead>
			<tbody>
			<c:forEach var="info" items='${infos }'>
				<tr class="text-center">
					<td>${info.apartName }</td>
					<td>${info.floor }</td>
					<td>${info.area }</td>
					<td>${info.dong }</td>
					<td>${info.dealAmount }만원</td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</div>
	<div class="row">
		<ul class="pagination justify-content-center">
			<li class="page-item"><a class="page-link" href="#">이전</a></li>
			<li class="page-item active" ><a class="page-link" href="#">1</a></li>
			<li class="page-item"><a class="page-link" href="#">2</a>
			</li>
			<li class="page-item"><a class="page-link" href="#">3</a></li>
			<li class="page-item"><a class="page-link" href="#">4</a></li>
			<li class="page-item"><a class="page-link" href="#">5</a></li>
			<li class="page-item"><a class="page-link" href="#">다음</a></li>
		</ul>
	</div>
</div>
</body>
</html>