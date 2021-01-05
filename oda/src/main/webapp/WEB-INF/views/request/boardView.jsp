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
<title>글 상세 정보</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/request.reply.js"></script>
</head>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>

<hr width="100%" noshade="noshade" size="1">
	<h1 align="center">주문 정보</h1>
	
	<ul>
		<li>번호 : ${requestDTO.req_num}</li>
		<li>주문상품명 : ${requestDTO.req_pname}</li>
		<li>주문지역 : ${requestDTO.req_region}</li>
		<li>주문장소 : ${requestDTO.req_shop}</li>
		<li>작성자 : <span id="writer_id">${requestDTO.id}</span></li>
		<li>조회수 : ${requestDTO.req_hit}</li>
		<li>등록일 : ${requestDTO.req_date}</li>
		<c:if test="${!empty requestDTO.req_filename }">
		<li>첨부파일 : <a href="file.do?req_num=${requestDTO.req_num}">${requestDTO.req_filename}</a></li>
		</c:if>
	</ul>
	<hr size="1" width=100%>
	<p>
		${requestDTO.req_content} 
	</p>
	<hr size="1" width="100%">
	<c:if test="${fn:endsWith(requestDTO.req_filename,'.jpg') || 
				  fn:endsWith(requestDTO.req_filename,'.JPG') || 
				  fn:endsWith(requestDTO.req_filename,'.jpeg') ||
				  fn:endsWith(requestDTO.req_filename,'.JPEG') ||  
				  fn:endsWith(requestDTO.req_filename,'.gif') ||
				  fn:endsWith(requestDTO.req_filename,'.GIF') ||
				  fn:endsWith(requestDTO.req_filename,'.png') ||
				  fn:endsWith(requestDTO.req_filename,'.PNG')}">
	<div class="align-center">
		<img src="imageView.do?req_num=${requestDTO.req_num}" style="max-width:500px">
	</div>
	</c:if>
	<p class="align-right">
		<c:if test="${!empty user_id && user_id == requestDTO.id}">
		<input type="button" value="수정" 
					onclick="location.href='update.do?req_num=${requestDTO.req_num}'">
		<input type="button" value="삭제" 
					onclick="location.href='delete.do?req_num=${requestDTO.req_num}'">
		<input type="button" value="목록" 
					onclick="location.href='list.do'">
		</c:if>
	</p>
	<hr size="1" width="100%">
	    <c:if test="${requestDTO.req_accept==0}">
		<div id="reply_div">
			<span class="reply-title">댓글 달기</span>
			<form id="re_form">
				<input type="hidden" name="req_num"
				       value="${requestDTO.req_num}" id="req_num">
				<input type="hidden" name="id"
				       value="${user_id}" id="user_id">       
				<textarea rows="3" cols="50"
				  name="re_content" id="re_content"
				  class="rep-content"
				  <c:if test="${empty user_id}">disabled="disabled"</c:if>
				  ><c:if test="${empty user_id}">로그인해야 작성할 수 있습니다.</c:if></textarea>              
				<c:if test="${!empty user_id}">
				<div id="re_first">
					<span class="letter-count">300/300</span>
				</div>
				<div id="re_second" class="align-right">
					<input type="submit" value="전송">
				</div>
				</c:if>
			</form>
		</div>
		</c:if>
		<c:if test="${requestDTO.req_accept==1}">
		<div class="align-center"><b>배송자 선택이 완료되었습니다.</b></div>
		<hr size="1" width="100%">
		<input type="hidden" name="req_num" value="${requestDTO.req_num}" id="req_num">
		</c:if>
		<!-- 댓글 목록 출력 -->
		<div id="output"></div>
		<div class="paging-button" style="display:none;">
			<input type="button" value="다음글 보기">
		</div>
		<div id="loading" style="display:none;">
			<img src="${pageContext.request.contextPath}/resources/images/ajax-loader.gif">
		</div>
</div>
</body>
</html>

