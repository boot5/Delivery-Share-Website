<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 정보 수정</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>                                                                     
	<h2 align="center">게시글 수정</h2>
	<form:form action="update.do" commandName="requestDTO" enctype="multipart/form-data">                     
		<form:hidden path="req_num"/>
		<ul>
			<li>                                                  
				<label for="req_pname">주문제품명</label>
				<form:input path="req_pname"/>
				<form:errors path="req_pname"
				     cssClass="error-color"/>
			</li>
			<li>
				<label for="req_region">주문지역</label>
				<form:input path="req_region"/>
				<form:errors path="req_region"
				     cssClass="error-color"/>
			</li>
			<li>
				<label for="req_shop">주문장소</label>
				<form:input path="req_shop"/>
				<form:errors path="req_shop"
				     cssClass="error-color"/>
			</li>
			<li>
				<label for="req_point">요청자 포인트</label>
				<form:input path="req_point"/>
				<form:errors path="req_point"
				     cssClass="error-color"/>
			</li>
			<li>
				<label for="req_content">내용</label>
				<form:textarea path="req_content"/>
				<form:errors path="req_content"
				     cssClass="error-color"/>
			</li>
			<li>
				<label for="upload">파일업로드</label>
				<input type="file" name="upload" 
				       id="upload"/>
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