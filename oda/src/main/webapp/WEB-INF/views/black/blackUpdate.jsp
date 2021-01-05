<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>블랙리스트 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
	<h2>블랙리스트 수정</h2>
	<form:form action="update.do" commandName="blackDTO">
		<form:hidden path="bla_num"/>
		<ul>
			<li>
				<label for="bla_title">제목</label>
				<form:input path="bla_title"/>
				<form:errors path="bla_title" cssClass="error-color"/>
			</li>
			<li>
				<label for="bla_id">신고아이디</label>
				${blackDTO.bla_id}
			</li>  
			<li class="font-dotum">
				<label for="bla_content">상세정보</label>
				<form:textarea path="bla_content" rows="8" cols="45"/>
				<form:errors path="bla_content" cssClass="error-color"/>
			</li>
		</ul>
		<div class="align-center">
			<input type="submit" value="수정">
			<input type="button" value="목록"
			                  onclick="location.href='list.do'">
		</div>
	</form:form>
</div>
</body>
</html>
