<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="modal login" id="main_login">
    <div class="modal-dialog modal-dialog-centered">
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">로그인</h4>
          <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
        </div>
        <form>
          <div class="modal-body">
            <div class="form-floating mb-3">
              <input class="form-control" type="text" name="login_id" id="main_login_id" placeholder="Enter id" pattern=".{6,}" required/>
              <label class="form-label" for="main_login_id">아이디</label>
            </div>
            <div class="form-floating mb-3">
              <input class="form-control" type="password" name="login_pw" id="main_login_pw" placeholder="Enter password" pattern=".{8,}" required/>
              <label class="form-label" for="main_login_pw">비밀번호</label>
            </div>
          </div>
          <div class="modal-footer container-md-2">
            <button type="button" onclick="login();" class="btn btn-success" data-bs-dismiss="modal">로그인</button>
          </div>
        </form>
      </div>
    </div>
  </div>