<%@page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<%@ page import="vo.signvo.SignupVO"%>
<%@ page import="dao.signup.SignupDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<body>
<%
	SignupDAO dao = new SignupDAO();
	List<SignupVO> voArr = new ArrayList<>();
	voArr = dao.signupSelect();
%>

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

		<% for (int i = 0; i < voArr.size(); i++) { 
			SignupVO myVO = voArr.get(i); 
		%>
			<div class="list_table_item">
				<p>
					<a href="./update.jsp"><%=myVO.getCustno()%></a>
				</p>
				<p><%=myVO.getCustname()%></p>
				<p><%=myVO.getPhone()%></p>
				<p><%=myVO.getAddress()%></p>
				<p><%=myVO.getJoindate()%></p>
				<p><%=myVO.getGrade()%></p>
				<p><%=myVO.getCity()%></p>
			</div>
		<% } %>
	</div>
</div>
<%@ include file="./footer.jsp"%>
</body>