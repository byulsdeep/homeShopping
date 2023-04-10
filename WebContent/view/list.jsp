<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./header.jsp"%>
<div class="content">
	<h2>회원 목록 조회 수정</h2>
	<div class="table list_table">
		<div>
			<p>회원정보</p>
			<p>회원성명</p>
			<p>전화번호</p>
			<p>주소</p>
			<p>가입일자</p>
			<p>고객등급</p>
			<p>거주지역</p>
		</div>

		<c:forEach items="${members}" var="member">

			<div class="list_table_item">
				<p>
					<a href="./update.do?custno=${member.custno }">${member.custno }</a>
				</p>
				<p>${member.custname}</p>
				<p>${member.phone}</p>
				<p>${member.address}</p>
				<p>${member.joindate}</p>
				<p>
					<c:choose>
						<c:when test="${member.grade == 'A'}">
			  VIP
			 </c:when>
						<c:when test="${member.grade == 'B'}">
			  일반
			 </c:when>
						<c:when test="${member.grade == 'C'}">
			  직원
			 </c:when>
					</c:choose>
				</p>
				<p>${member.city}</p>
			</div>
		</c:forEach>
	</div>
</div>
<%@ include file="./footer.jsp"%>
