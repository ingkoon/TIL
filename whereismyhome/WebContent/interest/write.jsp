<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<div style="height: 70px"></div>
<div class="row justify-content-center">
	<div class="col-lg-8 col-md-10 col-sm-12">
		<h2 class="my-3 py-3 shadow-sm bg-light text-center">
			<mark class="sky">관심지역추가</mark>
		</h2>
	</div>
	<div class="col-lg-8 col-md-10 col-sm-12">
		<form class="d-flex" id="form-register" action="">
			<input type='hidden' name='command' value="write"> 
			<select	class="form-select form-select-sm ms-5 me-1 w-50" id='sido' name="sido" aria-label="검색조건">
			</select>
			<select	class="form-select form-select-sm ms-5 me-1 w-50" id='gugun' name="gugun" aria-label="검색조건">
			</select>
			<select	class="form-select form-select-sm ms-5 me-1 w-50" id='dong' name="dong" aria-label="검색조건">
			</select>
			<div class="col-auto text-center">
				<button type="button" id="btn-register" class="btn btn-outline-primary mb-3">추가</button>
				<button type="button" id="btn-interlist" class="btn btn-outline-danger mb-3">목록으로이동...</button>
			</div>
		</form>
	</div>
</div>

<script src="./js/interest.js"></script>
<script>
	document.querySelector("#btn-register").addEventListener("click",
			function() {
				const dongSel = document.querySelector("#dong");
			    const dong = dongSel[dongSel.selectedIndex].value;
				alert(dong);
				if (!document.querySelector("#sido").value) {
					alert("시도 선택!!");
					return;
				} else if (!document.querySelector("#gugun").value) {
					alert("구군 선택!!");
					return;
				}else if (!document.querySelector("#dong").value) {
					alert("동 선택!!");
					return;
				}  else {
					let form = document.querySelector("#form-register");
					form.setAttribute("action", "${root}/interest");
					form.submit();
				}
			});

	document.querySelector("#btn-interlist").addEventListener("click", function() {
		if (confirm("취소를 하시면 작성한 글은 삭제됩니다.\n취소하시겠습니까?")) {
			location.replace("${root}/interest?command=list");
		}
	});
</script>
<%@ include file="/common/footer.jsp"%>
