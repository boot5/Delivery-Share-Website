<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 상세 정보</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>회원 상세정보</h1>
	<ul>
		<li>회원아이디 : ${memberDTO.id}</li>
		<li>이름 : ${memberDTO.name}</li>
		<li>비밀번호 : ${memberDTO.passwd}</li>
		<li>이메일 : ${memberDTO.email}</li>
		<li>우편주소 : ${memberDTO.address1}</li>
		<li>우편주소2 : ${memberDTO.address2}</li>
		<li>등록일 : ${memberDTO.reg_date}</li>
	</ul>
	<hr size="1" width="100%">
	<p>
		${memberDTO.content}
	</p>
	<hr size="1" width="100%">
	
	<div class="align-center">
		<img src="imageView.do?id=${memberDTO.id}" style="max-width:500px">
	</div>
	
	<p class="align-right">
		
		<input type="button" value="수정" 
		                   onclick="location.href='update.do?num=${memberDTO.id}'">
		<input type="button" value="삭제" 
		                   onclick="location.href='delete.do?num=${memberDTO.id}'">
		<input type="button" value="목록" 
		                   onclick="location.href='list.do'">                                      
		
	</p>
</div>
</body>
</html>















