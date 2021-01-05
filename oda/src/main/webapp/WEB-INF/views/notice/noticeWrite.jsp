<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항 입력</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css?after">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>공지사항</h1>
	<form:form action="write.do" 
	                    commandName="noticeDTO" enctype="multipart/form-data">
		<form:errors element="div"
		             cssClass="error-color"/>
		<ul>
			<li>
				<label for="noti_title">제목</label>
				<form:input path="noti_title"/>
				<form:errors path="noti_title"
				     cssClass="error-color"/>
			</li>
		</ul>
		<ul>
			<li>
				<label for="noti_content">본문</label>
				<form:textarea path="noti_content"/>
				<form:errors path="noti_content"
				     cssClass="error-color"/>
			</li>
		</ul> 
		<div class="align-center">
			<input type="submit" value="전송">
			<input type="button" value="목록"
			   onclick="location.href='list.do'">
		</div>             
	</form:form>
</div>
</body>
</html>






