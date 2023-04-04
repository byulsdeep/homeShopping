<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<div class="content">
        <h2>홈쇼핑 회원 등록</h2>
        <form action="signup.jsp" method="post">
          <div class="form_item">
            <label for="custno">회원번호</label
            ><input type="text" name="custno" id="custno" required value="${signup.custno}" />
          </div>
          <div class="form_item">
            <label for="custname">회원성명</label
            ><input type="text" name="custname" id="custname" required value="${signup.custname}" />
          </div>
          <div class="form_item">
            <label for="phone">회원전화</label
            ><input type="text" name="phone" id="phone" required value="${signup.phone}" />
          </div>
          <div class="form_item">
            <label for="address">주소</label
            ><input type="text" name="address" id="address" required value="${signup.address}" />
          </div>
          <div class="form_item">
            <label for="joindate">가입일자</label
            ><input type="text" name="joindate" id="joindate" required value="${signup.joindate}" />
          </div>
          <div class="form_item">
            <label for="grade">고객등급</label
            ><input type="text" name="grade" id="grade" required value="${signup.grade}" />
          </div>
          <div class="form_item">
            <label for="city">거주도시</label
            ><input type="text" name="city" id="city" required value="${signup.city}" />
          </div>
          <div class="create_btn">
            <button type="submit">제출</button>
            <button type="button" onclick="location.href='list.jsp'">
              조회
            </button>
          </div>
        </form>
      </div>
<%@ include file="./footer.jsp"%>