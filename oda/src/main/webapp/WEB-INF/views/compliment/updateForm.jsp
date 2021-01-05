<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>우수회원 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<h2>우수회원 수정</h2>
	<form:form action="update.do" commandName="complimentDTO">
	<form:hidden path="com_num"/>
		<ul>
		<li>
				<label for="com_title">제목</label>
				<form:input path="com_title"/>
				<form:errors path="com_title" cssClass="error-color"/>
			</li>
			<li>
				<label for="com_deli">배달원아이디</label>
				${complimentDTO.com_deli}
			</li>
			<li>
				<label for="com_content">내용</label>
				<form:textarea path="com_content"/>
				<form:errors path="com_content" cssClass="error-color"/>
			</li>
			
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="홈으로"
			                  onclick="location.href='list.do'">
		</div>
	</form:form>
</div>
</body>
</html>
