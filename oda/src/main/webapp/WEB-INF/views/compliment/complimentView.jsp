<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우수회원 상세 정보</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>우수회원 상세 정보</h1>
	<ul>
		<li>내용 :${complimentDTO.com_content}</li> 
		<li>번호 : ${complimentDTO.com_num}</li>
		<li>작성자 : ${complimentDTO.id}</li>
		<li>조회수 : ${complimentDTO.com_hit}</li>
		<li>배달원아이디 : ${complimentDTO.com_deli}</li>
		<li>등록일 : ${complimentDTO.com_date}</li>
		
	</ul>
	<hr size="1" width=100%>
	
	
	<p>
	
	</p>
	
	<p class="align-right">
		<c:if test="${!empty user_id && user_id == complimentDTO.id}">
		<input type="button" value="수정" 
					onclick="location.href='update.do?com_num=${complimentDTO.com_num}'">
		<input type="button" value="삭제" 
					onclick="location.href='delete.do?com_num=${complimentDTO.com_num}'">
		<input type="button" value="목록" 
					onclick="location.href='list.do'">
		</c:if>
	
	</p>
	
</div>
</body>
</html>

