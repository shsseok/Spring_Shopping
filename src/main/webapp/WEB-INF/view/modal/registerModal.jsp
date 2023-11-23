<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!-- 회원가입 모달 -->
<div class="modal fade" id="signupModal" tabindex="-1" role="dialog" aria-labelledby="signupModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="signupModalLabel">회원 가입</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <!-- 회원가입 폼 -->
        <form>
          <div class="form-group">
            <label for="newUsername">사용자 이름</label>
            <input type="text" class="form-control" id="newUsername" placeholder="사용자 이름 입력">
          </div>
          <div class="form-group">
            <label for="newEmail">이메일 주소</label>
            <input type="email" class="form-control" id="newEmail" placeholder="이메일 주소 입력">
          </div>
          <div class="form-group">
            <label for="newPassword">비밀번호</label>
            <input type="password" class="form-control" id="newPassword" placeholder="비밀번호 입력">
          </div>
          <button type="submit" class="btn btn-primary">가입하기</button>
        </form>
      </div>
    </div>
  </div>
</div>