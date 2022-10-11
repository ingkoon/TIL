<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }"></c:set>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous" />
<link href="${root}/assets/css/app.css" rel="stylesheet" />
<title>SSAFY</title>
</head>
<body>
	<div class="container">
		<div class="row justify-content-center">
			<div class="col-lg-8 col-md-10 col-sm-12">
				<h2 class="my-3 py-3 shadow-sm bg-light text-center">
					<mark class="orange">회원 정보</mark>
				</h2>
				<c:if test="${role eq 'admin'}">
					<button type="type" id="btn-get-list"
							class="btn btn-outline-primary mb-3 right"><a href="./member?command=goList">전체 회원 관리</a></button>
				</c:if>
			</div>
			<div class="col-lg-8 col-md-10 col-sm-12">
			
			
				<form id="form-join" method="POST" action="">
					<input type='hidden' id='command' name='command' value='update'>
					<div class="mb-3">
						<label for="username" class="form-label">이름 : </label> <input
							type="text" class="form-control" id="username" name="username"
							placeholder="이름..." value="${name}">
					</div>
					<div class="mb-3">
						<label for="userid" class="form-label">아이디 : </label> <input
							type="text" class="form-control" id="userid" name="userid"
							placeholder="아이디..." value="${user_id}" readonly/>
					</div>
					<div id="idcheck-result"></div>
					<div class="mb-3">
						<label for="userpwd" class="form-label">비밀번호 : </label> <input
							type="password" class="form-control" id="userpwd" name="userpwd"
							placeholder="비밀번호..."  />
					</div>
					<div class="mb-3">
						<label for="pwdcheck" class="form-label">비밀번호확인 : </label> <input
							type="password" class="form-control" id="pwdcheck"
							placeholder="비밀번호확인..." />
					</div>
					<div class="mb-3">
						<label for="age" class="form-label">나이 : </label> <input
							type="number" class="form-control" id="age" name="age"
							placeholder="나이..." value="${age}" />
					</div>
					<div class="mb-3">
						<label for="role" class="form-label">역할 : </label> 
							<select class="form-select"
								id="emaildomain" name="role" aria-label="이메일 도메인 선택" >
								<option>선택</option>
								<option  value="origin" <c:if test="${role eq 'origin' }">selected</c:if>>일반 회원</option>
								<option value="important" <c:if test="${role eq 'important' }">selected</c:if>>중요 회원</option>
								<option value="admin" <c:if test="${role eq 'admin' }">selected</c:if>>관리자</option>
							</select>
					</div>
					<div class="mb-3">
						<label for="emailid" class="form-label">이메일 : </label>
						<div class="input-group">
							<input type="text" class="form-control" id="emailid"
								name="emailid" placeholder="이메일아이디" value="${emailId }" /> <span
								class="input-group-text">@</span> <select class="form-select"
								id="emaildomain" name="emaildomain" aria-label="이메일 도메인 선택">
								<option selected>선택</option>
								<option value="ssafy.com" <c:if test="${emailDomain eq 'ssafy.com' }">selected</c:if>>싸피</option>
								<option value="google.com" <c:if test="${emailDomain eq 'google.com' }">selected</c:if>>구글</option>
								<option value="naver.com" <c:if test="${emailDomain eq 'naver.com' }">selected</c:if>>네이버</option>
								<option value="kakao.com" <c:if test="${emailDomain eq 'kakao.com' }">selected</c:if>>카카오</option>
							</select>
						</div>
					</div>
					<!-- 
            <div class="mb-3">
              <label for="sido" class="form-label">지역 : </label>
              <div class="input-group">
                <select class="form-select me-1" id="sido" aria-label="시도">
                  <option selected>시도선택</option>
                  <option value="1100000000">서울특별시</option>
                  <option value="2200000000">경기도</option>
                  <option value="3300000000">강원도</option>
                  <option value="4400000000">충청도</option>
                </select>
                <select class="form-select" id="gugun" aria-label="구군">
                  <option selected>구군선택</option>
                  <option value="1111000000">종로구</option>
                  <option value="1112000000">중구</option>
                  <option value="1113000000">서초구</option>
                  <option value="1114000000">강남구</option>
                </select>
              </div>
            </div>
             -->
					<div class="col-auto text-center">
						<button type="button" id="btn-join"
							class="btn btn-outline-primary mb-3">수정</button>
							
						<button type="button" id="btn-home"
							class="btn btn-outline-primary mb-3"><a href="./index.jsp">홈으로 돌아가기</a></button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
	<script>
      
      console.log(document.querySelector("#btn-join"));
     document.querySelector("#btn-join").addEventListener("click", function () {
    	 alert("오예!!");
        if (!document.querySelector("#username").value) {
          alert("이름 입력!!");
          return;
        } else if (!document.querySelector("#userid").value) {
          alert("아이디 입력!!");
          return;
        } else if (!document.querySelector("#userpwd").value) {
          alert("비밀번호 입력!!");
          return;
        } else if (document.querySelector("#userpwd").value != document.querySelector("#pwdcheck").value) {
          alert("비밀번호 확인!!");
          return;
        } else {
          let form = document.querySelector("#form-join");
          let command = document.querySelector("#command");
          form.setAttribute("action", "${root}/member");
          form.submit();
        }
      });
    </script>
</body>
</html>
