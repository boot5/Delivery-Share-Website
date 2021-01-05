<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>내 포인트 보기</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>내 포인트 보기</h1>
	<div class="align-right">
	    <b>보유 포인트 : <fmt:formatNumber value="${pointDTO.poi_sum}" type="number"/>P</b>
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
			<th width="400">포인트유형</th>
			<th>적립</th>
			<th>사용</th>
			<th>등록일</th>
		</tr>
		<c:forEach var="point" items="${list}">
		<tr>
			<td>${point.poi_num}</td>
			<td>
			<c:if test="${point.poi_kind==1}">충전</c:if>
			<c:if test="${point.poi_kind==2}">반환</c:if>
			<c:if test="${point.poi_kind==3}">적립</c:if>
			<c:if test="${point.poi_kind==4}">사용</c:if>
			</td>
			<td>${point.poi_plpoint}</td>
			<td>${point.poi_mipoint}</td>
			<td>${point.poi_date}</td>
		</tr>
		</c:forEach>
	</table>
	<div class="align-center">${pagingHtml}</div>
	</c:if>
</div>
</body>
</html>