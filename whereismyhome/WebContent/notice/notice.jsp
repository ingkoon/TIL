<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp" %>
      <div class="row justify-content-center">
        <div class="col-lg-8 col-md-10 col-sm-12">
          <h2 class="my-3 py-3 shadow-sm bg-light text-center">
            <mark class="sky">${ title }</mark>
          </h2>
        </div>
          <div class="card text-center bg-light">
            <h2 class="fw-bold text-primary pt-3">${subtitle}</h2>
            <div class="card-body">
              <p class="card-text">
                ${msg}
              </p>
              <a href="${src}" id="btn-index" class="btn btn-outline-primary">
               	${srcTitle }
               	</a>
            </div>
          </div>
        </div>
      </div>
    </div>
<%@ include file="/common/footer.jsp" %>
