<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 모달 코드만 포함 -->
<div class="modal fade" id="loginModal" tabindex="-1" role="dialog" aria-labelledby="loginModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="loginModalLabel">로그인</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- 로그인 폼 -->
        <form action="user/login.do" method="POST">
          <div class="form-group">
            <label for="userEmail">이메일</label>
            <input type="text" class="form-control" id="userEmail" placeholder="사용자 이메일 입력">
          </div>
          <div class="form-group">
            <label for="userPassword">비밀번호</label>
            <input type="password" class="form-control" id="userPassword" placeholder="비밀번호 입력">
          </div>
          <button type="submit" class="btn btn-primary">로그인</button>
        </form>
      </div>
    </div>
  </div>
</div>
