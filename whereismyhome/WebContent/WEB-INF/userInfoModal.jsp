<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String id = (String)session.getAttribute("id");
	String pw = (String)session.getAttribute("pw");
	String email = (String)session.getAttribute("email");
	String location = (String)session.getAttribute("location");
	String phone = (String)session.getAttribute("phone");
%>
    
<div class="modal user_info" id="main_user_info">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">회원정보확인</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <form class="was-validated">
          <div class="modal-body">
            <div class="form-floating input-group mb-3">
              <input class="form-control" type="text" name="id" id="main_user_info_id" placeholder="Enter id" pattern=".{6,}" value="<%= id %>>" required disabled/>
              <label class="form-label" for="main_user_info_id">아이디</label>
              <div class="invalid-feedback">ID는 6자 이상</div>
            </div>
            <div class="form-floating input-group mb-3">
              <input class="form-control" type="password" name="pw" id="main_user_info_pw" placeholder="Enter password" pattern=".{8,}" value="<%= pw %>>" required disabled/>
              <label class="form-label" for="main_user_info_pw">비밀번호</label>
              <div class="invalid-feedback">비밀번호는 8자 이상</div>
              <button id="main_user_info_pw_button" type="button" class="btn btn-primary" onclick="edit('main_user_info_pw', 'main_user_info_pw_button');">✎</button>
            </div>
            <div class="form-floating input-group mb-3">
              <input class="form-control" type="email" name="email" id="main_user_info_email" placeholder="Enter email" value="<%= email %>>" required disabled/>
              <label class="form-label" for="main_user_info_email">이메일</label>
              <div class="invalid-feedback">유효하지 않은 이메일 형식입니다.</div>
              <button id="main_user_info_email_button" type="button" class="btn btn-primary" onclick="edit('main_user_info_email', 'main_user_info_email_button');">✎</button>
            </div>
            <div class="form-floating input-group mb-3">
              <input class="form-control" type="text" name="location" id="main_user_info_location" placeholder="Enter location" value="<%= location %>>" required disabled/>
              <label class="form-label" for="main_user_info_location">주소</label>
              <div class="invalid-feedback">주소는 필수입니다.</div>
              <button id="main_user_info_location_button" type="button" class="btn btn-primary" onclick="edit('main_user_info_location', 'main_user_info_location_button');">✎</button>
            </div>
            <div class="form-floating input-group mb-3">
              <input class="form-control" type="text" name="phone" id="main_user_info_phone" placeholder="Enter phone number" pattern="[0-9]{3}-[0-9]{3,4}-[0-9]{4}|[0-9]{4}-[0-9]{4}" value="<%= phone %>>" required disabled/>
              <label class="form-label" for="main_user_info_phone">휴대폰 번호</label>
              <div class="invalid-feedback">유효하지 않은 휴대폰 번호 형식입니다.</div>
              <button id="main_user_info_phone_button" type="button" class="btn btn-primary" onclick="edit('main_user_info_phone', 'main_user_info_phone_button');">✎</button>
            </div>
          </div>
          <div class="modal-footer container-md-2">
            <button type="button" onclick="update();" class="btn btn-info" data-bs-dismiss="modal">수정하기</button>
            <button type="button" onclick="delete_();" class="btn btn-info" data-bs-dismiss="modal">탈퇴하기</button>
          </div>
        </form>
      </div>
    </div>
  </div>