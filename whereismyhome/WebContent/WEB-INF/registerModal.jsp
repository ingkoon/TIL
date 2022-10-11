<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal register" id="main_register">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">회원가입</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <form class="was-validated">
          <div class="modal-body">
            <div class="form-floating mb-3">
              <input class="form-control" type="text" name="register_id" id="main_register_id" placeholder="Enter id" pattern=".{6,}" required/>
              <label class="form-label" for="main_register_id">아이디</label>
              <div class="invalid-feedback">ID는 6자 이상</div>
            </div>
            <div class="form-floating mb-3">
              <input class="form-control" type="password" name="register_pw" id="main_register_pw" placeholder="Enter password" pattern=".{8,}" required/>
              <label class="form-label" for="main_register_pw">비밀번호</label>
              <div class="invalid-feedback">비밀번호는 8자 이상</div>
            </div>
            <div class="form-floating mb-3">
              <input class="form-control" type="email" name="register_email" id="main_register_email" placeholder="Enter email" required/>
              <label class="form-label" for="main_register_email">이메일</label>
              <div class="invalid-feedback">유효하지 않은 이메일 형식입니다.</div>
            </div>
            <div class="form-floating mb-3">
              <input class="form-control" type="text" name="register_location" id="main_register_location" placeholder="Enter location" required/>
              <label class="form-label" for="main_register_location">주소</label>
              <div class="invalid-feedback">주소는 필수입니다.</div>
            </div>
            <div class="form-floating m b-3">
              <input class="form-control" type="text" name="register_phone" id="main_register_phone" placeholder="Enter phone number" pattern="[0-9]{3}-[0-9]{3,4}-[0-9]{4}|[0-9]{4}-[0-9]{4}" required/>
              <label class="form-label" for="main_register_phone">휴대폰 번호</label>
              <div class="invalid-feedback">유효하지 않은 휴대폰 번호 형식입니다.</div>
            </div>
          </div>
          <div class="modal-footer container-md-2">
            <button type="button" onclick="register()" class="btn btn-success" data-bs-dismiss="modal">회원가입</button>
          </div>
        </form>
      </div>
    </div>
  </div>