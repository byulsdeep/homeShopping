<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<script src="validate.js"></script>
<div class="content">
	<h2>홈쇼핑 회원 등록</h2>
	<form method="post">
		<div class="form_item">
			<label for="custno">회원번호</label><input type="text" name="custno"
				id="custno" value="${nextCustNo}" readonly />
		</div>
		<div class="form_item">
			<label for="custname">회원성명</label><input type="text" name="custname"
				id="custname" required />
		</div>
		<div class="form_item">
			<label for="phone">회원전화</label><input type="text" name="phone"
				id="phone" required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" />
		</div>
		<div class="form_item">
			<label for="address">주소</label><input type="text" name="address"
				id="address" required />
		</div>
		<div class="form_item">
			<label for="joindate">가입일자</label><input type="text" name="joindate"
				id="joindate" required pattern="[0-9]{8}" />
		</div>
		<div class="form_item">
			<label for="grade">고객등급 [A:VIP,B:일반,C:직원]</label><input type="text"
				name="grade" id="grade" required pattern="[A-C]{1}" />
		</div>
		<div class="form_item">
			<label for="city">거주도시</label><input type="text" name="city"
				id="city" required pattern="[0-9]{2}" />
		</div>
		<div class="create_btn">
			<button type="submit" onclick="event.preventDefault();validate('signup')">제출</button>
			<button type="button" onclick="location.href='list.jsp'">조회
			</button>
		</div>
	</form>
</div>
<script>
	function signup() {
		const form = document.querySelector('form');
		form.action = 'signup.do';
		form.submit();
	}
	window.onload = () => {if ('${message}' != '') alert('${message}')}
</script>
<%@ include file="./footer.jsp"%>