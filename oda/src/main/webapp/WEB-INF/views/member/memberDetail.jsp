<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원상세정보</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId.js"></script>  
</head>
<body>
<div class="page-main-style">
	<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<hr width="100%" noshade="noshade" size="1">
	
	<h2>회원상세정보</h2>
		<ul>
		<li>회원아이디 : ${memberDTO.id}</li>
		<li>이름 : ${memberDTO.name}</li>
		<li>비밀번호 : ${memberDTO.passwd}</li>
		<li>보유 포인트 : <fmt:formatNumber value="${pointDTO.poi_sum}" type="number"/>P</li>
		<li>이메일 : ${memberDTO.email}</li>
		<li>우편주소 : ${memberDTO.address1}</li>
		<li>우편주소2 : ${memberDTO.address2}</li>
		<li>등록일 : ${memberDTO.reg_date}</li>
		
	</ul>

		
	
		<div class="align-center">
		<input type="button" value="수정" 
		                   onclick="location.href='update.do'">
		<input type="button" value="삭제" 
		                   onclick="location.href='delete.do'">
			<input type="button" value="홈으로"
			   onclick="location.href='${pageContext.request.contextPath}/main/main.do'">
		</div>             
</div>
</body>
</html>






