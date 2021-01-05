<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메시지 정보 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>                                                                     
	<h2>메시지 수정</h2>
	<form:form action="update.do" commandName="requestDTO" enctype="multipart/form-data">                     
		<form:hidden path="mess_num"/>
		<ul>
			
			<li>
				<label for="id">주문자 아이디</label>
				<form:input path="id"/>
				<form:errors path="id"
				     cssClass="error-color"/>
			</li>
			<li>
				<label for="mess_deli">배달자 아이디</label>
				<form:input path="mess_deli"/>
				<form:errors path="mess_deli"
				     cssClass="error-color"/>
			</li>
			<li>
				<label for="mess_check">신여부</label>
				<form:input path="mess_check"/>
				<form:errors path="mess_check"
				     cssClass="error-color"/>
			</li>
			<li>
				<label for="req_num">주문 번호</label>
				<form:input path="req_num"/>
				<form:errors path="req_num"
				     cssClass="error-color"/>
			</li>
			
			<li>
				<label for="re_num">주문한 사람의 댓글번호</label>
				<form:textarea path="re_num"/>
				<form:errors path="re_num"
				     cssClass="error-color"/>
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