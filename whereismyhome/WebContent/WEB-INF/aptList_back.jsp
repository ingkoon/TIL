<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- 중앙 content start -->
    <div class="container">
    
      <div style="height: 70px"></div>
      <h2 class="text-center mt-5 mb-3">아파트 매매 정보</h2>
      <div class="row col-md-12 justify-content-center mb-2">
        <div class="form-group col-md-2">
          <select class="form-select bg-secondary text-light" id="sido">
            <option value="">시도선택</option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <select class="form-select bg-secondary text-light" id="gugun">
            <option value="">구군선택</option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <select class="form-select bg-secondary text-light" id="dong">
            <option value="">동선택</option>
          </select>
        </div>
        
        <!-- 아파트이름 검색 -->
        <div class="form-group col-md-2">
          <input type="text" id="aptName" placeholder="아파트 이름">
        </div>
        
        <div class="form-group col-md-2">
          <select class="form-select bg-dark text-light" id="year"></select>
        </div>
        <div class="form-group col-md-2">
          <select class="form-select bg-dark text-light" id="month">
            <option value="">매매월선택</option>
          </select>
        </div>
        <div class="form-group col-md-2">
          <button type="button" id="list-btn" class="btn btn-outline-primary" onclick="document.getElementById('homesImg').style.display='none';">
            아파트매매정보가져오기
          </button>
        </div>
      </div>
      <div style="text-align: center" id ="homesImg"  >
      	<img src="./img/homes.jpg" width="100%" height="600px"/>
      </div>
      <table class="table table-hover text-center" style="display: none">
        <tr>
          <th>아파트이름</th>
          <th>층</th>
          <th>면적</th>
          <th>법정동</th>
          <th>거래금액</th>
        </tr>
        <tbody id="aptlist"></tbody>
      </table>
    </div>
    
    <!-- 동별 실거래가 조회 로직 script -->
	<script src="./js/aptList.js"></script>
    <!-- 중앙 content end -->