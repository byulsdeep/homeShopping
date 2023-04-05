<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="./header.jsp"%>
<%@ page import="java.util.List" %>
<div class="content">
   <h2>회원매출조회</h2>
   <div class="table sales_table">
      <div>
         <p>회원정보</p>
         <p>회원성명</p>
         <p>고객등급</p>
         <p>매출</p>
      </div>
      
      <c:forEach items="${sales}" var="sale">
		<div class="sales_table_item">
			<p>${sale.custno}</p>
			<p>${sale.custname}</p>
			<p>${sale.grade}</p>
			<p>${sale.total}</p>
		</div>
      </c:forEach>
      
   </div>
</div>
<%@ include file="./footer.jsp"%>