<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
     uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>블랙리스트</h1>
	<form action="list.do" id="search_form"
	      method="get">
		<ul class="search">
			<li>
				<select name="keyfield" id="keyfield">
					<option value="bla_id">ID</option>
				</select>
			</li>
			<li>
				<input type="text" name="keyword" id="keyword">
			</li>
			<li>
				<input type="submit" value="피해조회">
				<input type="button" value="전체목록"
				       onclick="location.href='list.do'">
			</li>
		</ul>      
	</form>
	<div class="align-right">
		<c:if test="${!empty user_id}">
		<input type="button" value="신고하기"
		  onclick="location.href='write.do'">
		</c:if>
	</div>
	<c:if test="${count == 0}">
	<div class="align-center">
		신고된 아이디가 없습니다.
	</div>
	</c:if>
	<c:if test="${count > 0}">
	<table class="align-center">
		<tr>
			<th>번호</th>
			<th width="250">제목</th>
			<th>신고아이디</th>
			<th>등록날짜</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="black" items="${list}">
		<tr>
			<td>${black.bla_num}</td>
			<td><a href="detail.do?num=${black.bla_num}">${black.bla_title}</a></td>
			<td>${black.bla_id}</td>
			<td>${black.bla_date}</td>
			<td>${black.bla_hit}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>
</body>
</html>