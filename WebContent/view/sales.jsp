<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="./header.jsp"%>
<%@ page import="inquiry.inquiryvo.InquiryVO"%>
<%@ page import="inquiry.inquiryvo.InquiryDAO"%>
<%@ page import="java.util.List" %>
<%
    InquiryDAO dao = new InquiryDAO();
    List<InquiryVO> vos = dao.inquirySelect();
%>
<div class="content">
	<h2>회원매출조회</h2>
	<div class="table sales_table">
		<div>
			<p>회원정보</p>
			<p>회원성명</p>
			<p>고객등급</p>
			<p>매출</p>
		</div>

		<div class="sales_table_item">
			<p><%=vos.get(0).getCustno() %></p>
			<p><%=vos.get(0).getcustname() %></p>
			<p><%=vos.get(0).getGrade() %></p>
			<p><%=vos.get(0).getTotal() %></p>
		</div>
		<div class="sales_table_item">
			<p><%=vos.get(1).getCustno() %></p>
			<p><%=vos.get(1).getcustname() %></p>
			<p><%=vos.get(1).getGrade() %></p>
			<p><%=vos.get(1).getTotal() %></p>
		</div>
		<div class="sales_table_item">
			<p><%=vos.get(2).getCustno() %></p>
			<p><%=vos.get(2).getcustname() %></p>
			<p><%=vos.get(2).getGrade() %></p>
			<p><%=vos.get(2).getTotal() %></p>
		</div>
		<div class="sales_table_item">
			<p><%=vos.get(3).getCustno() %></p>
			<p><%=vos.get(3).getcustname() %></p>
			<p><%=vos.get(3).getGrade() %></p>
			<p><%=vos.get(3).getTotal() %></p>
		</div>
	</div>
</div>
<%@ include file="./footer.jsp"%>