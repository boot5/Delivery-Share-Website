<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>포인트 상세 정보</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>포인트 상세 정보</h1>
	<ul>
		<li>번호 : ${boardDTO.num}</li>
		<li>작성자 : ${boardDTO.id}</li>
		<li>조회수 : ${boardDTO.hit}</li>
		<li>등록일 : ${boardDTO.reg_date}</li>
		<c:if test="${!empty boardDTO.filename }">
		<li>첨부파일 : <a href="file.do?num=${boardDTO.num}">${boardDTO.filename}</a></li>
		</c:if>
	</ul>
	<hr size="1" width=100%>
	
	
	<p>
		${boardDTO.content} 
	</p>
	<hr size="1" width="100%">
	<c:if test="${fn:endsWith(boardDTO.filename,'.jpg') || 
				  fn:endsWith(boardDTO.filename,'.JPG') || 
				  fn:endsWith(boardDTO.filename,'.jpeg') ||
				  fn:endsWith(boardDTO.filename,'.JPEG') ||  
				  fn:endsWith(boardDTO.filename,'.gif') ||
				  fn:endsWith(boardDTO.filename,'.GIF') ||
				  fn:endsWith(boardDTO.filename,'.png') ||
				  fn:endsWith(boardDTO.filename,'.PNG')}">
	<div class="align-center">
		<img src="imageView.do?num=${boardDTO.num}" style="max-width:500px">
	</div>
	</c:if>
	
	
	
	<p class="align-right">
		<c:if test="${!empty user_id && user_id == boardDTO.id}">
		<input type="button" value="수정" 
					onclick="location.href='update.do?num=${boardDTO.num}'">
		<input type="button" value="삭제" 
					onclick="location.href='delete.do?num=${boardDTO.num}'">
		<input type="button" value="목록" 
					onclick="location.href='list.do'">
		</c:if>
	
	</p>
	
</div>
</body>
</html>

