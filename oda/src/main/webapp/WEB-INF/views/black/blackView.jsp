<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글 상세 정보</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>피해사례 상세보기</h1>
	<ul>
		<li>번호 : ${blackDTO.bla_num}</li>
		<li>신고자 : ${blackDTO.id}</li>
		<li>신고아이디 : ${blackDTO.bla_id}</li>
		<li>조회수 : ${blackDTO.bla_hit}</li>
		<li>등록일 : ${blackDTO.bla_date}</li>
	</ul>
	<hr size="1" width=100%>
	<p>
		${blackDTO.bla_content} 
	</p>
	<hr size="1" width="100%">
	<p class="align-right">
		<c:if test="${!empty user_id && user_id == blackDTO.id}">
		<input type="button" value="수정" 
					onclick="location.href='update.do?num=${blackDTO.bla_num}'">
		<input type="button" value="삭제" 
					onclick="location.href='delete.do?num=${blackDTO.bla_num}'">
		</c:if>
		<input type="button" value="목록" 
					onclick="location.href='list.do'">
		
	
	</p>
	
</div>
</body>
</html>
