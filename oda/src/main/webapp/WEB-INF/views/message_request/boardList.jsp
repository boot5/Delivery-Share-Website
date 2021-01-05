<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
     uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메시지 목록</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>

<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>메시지 목록</h1>
	<div class="align-right">
		<c:if test="${!empty user_id}">
		<input type="button" value="메시지요청하기"
		  onclick="location.href='write.do'">
		</c:if>
	</div>
	
	<form action="list.do" id="search_form"
	      method="get">
		<ul class="search">
			<li>
				<select name="keyfield" id="keyfield">
					<option value="mess_num">주문 메시지 번호</option>
					<option value="id">주문자ID</option>
					<option value="req_num">주문 번호</option>
					<option value="re_num">주문할 가게명</option>
					<option value="mess_deli">배달자 아이디</option>
					<option value="all">전체</option>
				</select>
			</li>
			<li>
				<input type="text" name="keyword" id="keyword">
			</li>
			<li>
				<input type="submit" value="찾기">
				<input type="button" value="목록"
				       onclick="location.href='list.do'">
			</li>
		</ul>      
	</form>
	
	<c:if test="${count == 0}">
	<div class="align-center">
		등록된 메시지가 없습니다.
	</div>
	</c:if>
	<c:if test="${count > 0}">
	<table align="center">
		<tr>
			<th align="center" width="60">번호</th>
			<th width="200">배달자 아이디</th>
			<th width="200">주문번호</th>
			<th width="200">주문자ID</th>
			<th width="200">등록날짜</th>
			<th width="200">확인여부</th>
		</tr>
		<c:forEach var="request" items="${list}">
		<tr>
			<td align="center">${request.mess_num}</td>
			<td align="center">${request.mess_deli}</td>
			<td align="center"><a href="detail.do?mess_num=${request.mess_num}">${request.req_num}</a></td>
			<td align="center">${request.id}</td>
			<td align="center">${request.re_date}</td>
			<td align="center">
			<c:if test="${request.mess_check == 0}">미확인</c:if>
			<c:if test="${request.mess_check == 1}">확인</c:if>
			</td>
		</tr>
		</c:forEach>
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>
</body>
</html>






