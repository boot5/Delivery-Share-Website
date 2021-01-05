<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>포인트쓰기</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>포인트쓰기</h1>
	<form:form action="write.do" 
	                    commandName="pointDTO" enctype="multipart/form-data">
		<form:errors element="div"
		             cssClass="error-color"/>
		<ul>
			<li>
				<label for="poi_point">보유포인트</label>
				<form:textarea path="poi_point"/>
				<form:errors path="poi_point"
				     cssClass="error-color"/>
			</li>
			<li>
				<label for="poi_date">적립/사용날짜</label>
				<form:input path="poi_date"/>
				<form:errors path="poi_date"
				     cssClass="error-color"/>
			</li>
			<li>
				<label for="poi_kind">포인트 사용유형</label>
				<input type= />
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






