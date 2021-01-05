   <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/confirmId_black.js"></script>  
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>신고하기</h1>
	<form:form id="register_form" action="write.do" 
	                    commandName="blackDTO" enctype="multipart/form-data">
		<form:errors element="div"
		             cssClass="error-color"/>
		<ul>
			<li>
				<label for="bla_title">제목</label>
				<form:input path="bla_title"/>
				<form:errors path="bla_title" cssClass="error-color"/>
			</li>
			<li>
				<label for="bla_id">신고아이디</label>
				<form:input path="bla_id"/>
				<!-- 중복체크 member테이블에 중복된id없을시 신고불가 --> 
				<input type="button" id="confirmId" value="ID조회">
				<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif"
						   id="loading" width="16" height="16" style="display:none;">  
				<span id="message_id"></span>  
				<form:errors path="id" cssClass="error-color"/>
			</li>
			<li>
				<label for="bla_content">상세내용</label>
				<form:textarea rows="8" cols="45" path="bla_content"/>
				<form:errors path="bla_content" cssClass="error-color"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="저장">
			<input type="button" value="목록" onclick="location.href='list.do'">
		</div>             
	</form:form>
</div>
</body>
</html>
