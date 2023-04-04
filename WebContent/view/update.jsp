<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<script src="validate.js"></script>
<div class="content">
            <h2>쇼핑몰 회원 정보 수정</h2>
            <form action="" method="post">
                <div class="form_item"><label for="custno">회원번호</label><input type="text" name="custno" id="custno" placeholder="custno" value="${client.custno}"></div>
                <div class="form_item"><label for="custname">회원성명</label><input type="text" name="custname" id="custname" placeholder="custname" value="${client.custname}"></div>
                <div class="form_item"><label for="phone">회원전화</label><input type="text" name="phone" id="phone" placeholder="phone" value="${client.phone}"></div>
                <div class="form_item"><label for="address">주소</label><input type="text" name="address" id="address" placeholder="address" value="${client.address}"></div>
                <div class="form_item"><label for="joindate">가입일자</label><input type="text" name="joindate" id="joindate" placeholder="joindate" value="${client.joindate}"></div>
                <div class="form_item"><label for="grade">고객등급</label><input type="text" name="grade" id="grade" placeholder="grade" value="${client.grade}"></div>
                <div class="form_item"><label for="city">거주도시</label><input type="text" name="city" id="city" placeholder="city" value="${client.city}"></div>
                <div class="create_btn">
                    <button type="submit" onclick="event.preventDefault();validate('update')">제출</button>
                    <button type="button" onclick="location.href='list.do'">조회</button>
                </div>
            </form>
        </div>
       <script>
	function update() {
		const form = document.querySelector('form');
		form.action = 'update.do';
		form.submit();
	}
	window.onload = () => {if ('${message}' != '') alert('${message}')}
       </script>
<%@ include file="./footer.jsp"%>