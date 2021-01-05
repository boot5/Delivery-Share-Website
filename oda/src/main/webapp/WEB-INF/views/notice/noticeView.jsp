<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css?after">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>

<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>공지사항</h1>
	<ul>
		<li>번호 : ${noticeDTO.noti_num}</li>
		<li>제목 : ${noticeDTO.noti_title}</li>
		<li>작성자 : ${noticeDTO.id}</li>
		<li>조회수 : ${noticeDTO.noti_hit}</li>
		<li>등록일 : ${noticeDTO.noti_date}</li>
	</ul>
	<hr size="1" width=100%>
	
	<p>
		${noticeDTO.noti_content} 
	</p>
	<hr size="1" width="100%">
	
	<p class="align-right">
		<c:if test="${!empty user_id && user_id == noticeDTO.id}">
		<input type="button" value="수정" 
					onclick="location.href='update.do?noti_num=${noticeDTO.noti_num}'">
		<input type="button" value="삭제" 
					onclick="location.href='delete.do?noti_num=${noticeDTO.noti_num}'">
		<input type="button" value="목록" 
					onclick="location.href='list.do'">
		</c:if>
	
	</p>
	
</div>
</body>
</html>

