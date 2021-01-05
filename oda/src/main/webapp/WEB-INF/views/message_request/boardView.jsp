<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>  
<%@ taglib prefix="form"
    uri="http://www.springframework.org/tags/form" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>메시지 상세 정보</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<hr width="100%" noshade="noshade" size="1">
	<h1>메시지 상세 정보</h1>
	<%-- <ul>
		<li>번호 : ${message_requestDTO.mess_num}</li>
		<li>배달자 아이디 : ${message_requestDTO.mess_deli}</li>
		<li>주문번호 : ${message_requestDTO.req_num}</li>
		<li>배달 댓글 번호 : ${message_requestDTO.re_num}</li>
		<li>주문자 아이디 : ${message_requestDTO.id}</li>
		<li>등록일 : ${message_requestDTO.re_date}</li>
	</ul> --%>
	<ul>
		<li>주문상품명 : ${requestDTO.req_pname}</li>
		<li>주문지역 : ${requestDTO.req_region}</li>
		<li>주문장소 : ${requestDTO.req_shop}</li>
		<li>작성자 : <span id="writer_id">${requestDTO.id}</span></li>
		<li>등록일 : ${requestDTO.req_date}</li>
	</ul>
	<hr size="1" width=100%>
	[배달자 신청 정보]
	<ul>
		<li>배달자 아이디 : ${replyDTO.id}</li>
		<li>배달자 신청 내용 : ${replyDTO.re_content}</li>
		<li>등록일 : ${replyDTO.mess_date}</li>
	</ul>
	<hr size="1" width=100%>
	<p class="align-right">
		<c:if test="${!empty user_id && user_id == replyDTO.id}">
			<c:if test="${message_requestDTO.mess_check == 0}">
				<input type="button" value="메시지 확인" 
							onclick="location.href='update.do?mess_num=${message_requestDTO.mess_num}'">
			</c:if>
			<input type="button" value="삭제" 
						onclick="location.href='delete.do?mess_num=${message_requestDTO.mess_num}'">
			<input type="button" value="목록" 
						onclick="location.href='list.do'">
		</c:if>
	</p>
</div>
</body>
</html>

