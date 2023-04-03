<!--			 <p>Custname</p> -->
<!-- 			<p>Phone</p> -->
<!-- 			<p>Address</p> -->
<!-- 			<p>Joindate</p> -->
<!-- 			<p>Grade</p> -->
<!-- 			<p>City</p> -->

<%@ page import="java.util.List"%>
<%@ page import="signup.signupvo.SignupVO"%>
<%@ page import="signup.signupdao.SignupDAO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<body>
<%
	SignupDAO dao = new SignupDAO();
	List<SignupVO> vos = dao.signupSelect();
%>
<%
	
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
		<div class="list_table_item">
			<p>
				<a href="./update.jsp"><%=vos.get(0).getCustno()%></a>
			</p>
			<p><%=vos.get(0).getCustname()%></p>
			<p><%=vos.get(0).getPhone()%></p>
			<p><%=vos.get(0).getAddress()%></p>
			<p><%=vos.get(0).getJoindate()%></p>
			<p><%=vos.get(0).getGrade()%></p>
			<p><%=vos.get(0).getCity()%></p>
		</div>



		<div class="list_table_item">
			<p>
				<a href="./update.jsp"><%=vos.get(1).getCustno()%></a>
			</p>
			<p><%=vos.get(1).getCustname()%></p>
			<p><%=vos.get(1).getPhone()%></p>
			<p><%=vos.get(1).getAddress()%></p>
			<p><%=vos.get(1).getJoindate()%></p>
			<p><%=vos.get(1).getGrade()%></p>
			<p><%=vos.get(1).getCity()%></p>
		</div>

		<div class="list_table_item">
			<p>
				<a href="./update.jsp"><%=vos.get(2).getCustno()%></a>
			</p>
			<p><%=vos.get(2).getCustname()%></p>
			<p><%=vos.get(2).getPhone()%></p>
			<p><%=vos.get(2).getAddress()%></p>
			<p><%=vos.get(2).getJoindate()%></p>
			<p><%=vos.get(2).getGrade()%></p>
			<p><%=vos.get(2).getCity()%></p>
		</div>

		<div class="list_table_item">
			<p>
				<a href="./update.jsp"><%=vos.get(3).getCustno()%></a>
			</p>
			<p><%=vos.get(3).getCustname()%></p>
			<p><%=vos.get(3).getPhone()%></p>
			<p><%=vos.get(3).getAddress()%></p>
			<p><%=vos.get(3).getJoindate()%></p>
			<p><%=vos.get(3).getGrade()%></p>
			<p><%=vos.get(3).getCity()%></p>
		</div>

		<div class="list_table_item">
			<p>
				<a href="./update.jsp"><%=vos.get(4).getCustno()%></a>
			</p>
			<p><%=vos.get(4).getCustname()%></p>
			<p><%=vos.get(4).getPhone()%></p>
			<p><%=vos.get(4).getAddress()%></p>
			<p><%=vos.get(4).getJoindate()%></p>
			<p><%=vos.get(4).getGrade()%></p>
			<p><%=vos.get(4).getCity()%></p>
		</div>

		<div class="list_table_item">
			<p>
				<a href="./update.jsp"><%=vos.get(5).getCustno()%></a>
			</p>
			<p><%=vos.get(5).getCustname()%></p>
			<p><%=vos.get(5).getPhone()%></p>
			<p><%=vos.get(5).getAddress()%></p>
			<p><%=vos.get(5).getJoindate()%></p>
			<p><%=vos.get(5).getGrade()%></p>
			<p><%=vos.get(5).getCity()%></p>
		</div>

		<div class="list_table_item">
			<p>
				<a href="./update.jsp"><%=vos.get(6).getCustno()%></a>
			</p>
			<p><%=vos.get(6).getCustname()%></p>
			<p><%=vos.get(6).getPhone()%></p>
			<p><%=vos.get(6).getAddress()%></p>
			<p><%=vos.get(6).getJoindate()%></p>
			<p><%=vos.get(6).getGrade()%></p>
			<p><%=vos.get(6).getCity()%></p>
		</div>

	</div>
</div>
<%@ include file="./footer.jsp"%>
</body>