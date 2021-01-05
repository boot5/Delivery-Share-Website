<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
     uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우수회원 목록</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>우수회원 목록</h1>
	<form action="list.do" id="search_form"
	      method="get">
		<ul class="search">
			<li>
				<select name="keyfield" id="keyfield">
					<option value="com_title">제목</option>
					<option value="id">ID</option>
					<option value="com_content">내용</option>
					<option value="com_deli">배달원 아이디</option>
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
	<div class="align-right">
		<c:if test="${!empty user_id}">
		<input type="button" value="우수회원 등록"
		  onclick="location.href='write.do'">
		</c:if>
	</div>
	<c:if test="${count == 0}">
	<div class="align-center">
		등록된 게시물이 없습니다.
	</div>
	</c:if>
	<c:if test="${count > 0}">
	<table>
		<tr>
			<th>번호</th>
			<th width="300">제목</th>
			<th>ID</th>
			<th>등록날짜</th>
			<th>배달원 아이디</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="compliment" items="${list}">
		<tr>
			<td>${compliment.com_num}</td>
			<td><a href="detail.do?com_num=${compliment.com_num}">${compliment.com_title}</a></td>
			<td>${compliment.id}</td>
			<td>${compliment.com_date}</td>
			<td>${compliment.com_deli}</td>
			<td>${compliment.com_hit}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>
</body>
</html>






