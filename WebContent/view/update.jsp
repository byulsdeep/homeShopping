<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<div class="content">
            <h2>쇼핑몰 회원 정보 수정</h2>
            <form action="" method="post">
                <div class="form_item"><label for="custno">회원번호</label><input type="text" name="custno" id="custno" placeholder="custno"></div>
                <div class="form_item"><label for="custname">회원성명</label><input type="text" name="custname" id="custname" placeholder="custname"></div>
                <div class="form_item"><label for="phone">회원전화</label><input type="text" name="phone" id="phone" placeholder="phone"></div>
                <div class="form_item"><label for="address">주소</label><input type="text" name="address" id="address" placeholder="address"></div>
                <div class="form_item"><label for="joindate">가입일자</label><input type="text" name="joindate" id="joindate" placeholder="joindate"></div>
                <div class="form_item"><label for="grade">고객등급</label><input type="text" name="grade" id="grade" placeholder="grade"></div>
                <div class="form_item"><label for="city">거주도시</label><input type="text" name="city" id="city" placeholder="city"></div>
                <div class="create_btn">
                    <button type="submit" onclick="alert('회원정보수정이 완료 되었습니다!');">제출</button>
                    <button type="button" onclick="location.href='list.jsp'">조회</button>
                </div>
            </form>
        </div>
<%@ include file="./footer.jsp"%>