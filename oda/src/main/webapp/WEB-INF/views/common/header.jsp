<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!-- 상단 네비게이션 시작 -->

<style>
 .main-menu{
 	padding: 10px;
 	width:1000px;
 	margin:0 auto;	
 	}

 .li {
       display: inline;
       padding: 15px 30px;
	   color: #010101;
       font-weight: 1000;
     }

</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/check_count.js"></script>  
<ul class="header-nav" >
	<li class="header-brand" > </li>
	<li class="header-menu">
		<ul>		
			<c:if test="${!empty user_id}">
			<li><a href="${pageContext.request.contextPath}/member/detail.do">회원정보</a></li>
			</c:if>
			<c:if test="${empty user_id}">
			<li><a href="${pageContext.request.contextPath}/member/write.do">회원가입</a></li>
			<li><a href="${pageContext.request.contextPath}/member/login.do">로그인</a></li>
			</c:if>
			<c:if test="${!empty user_id}">
			<li><a href="${pageContext.request.contextPath}/member/logout.do">[${user_id}<c:if test="${!empty user_id && user_auth==2}">(관리자)</c:if>]님 로그아웃</a></li>
			</c:if>
		</ul>
	</li>
</ul>




<h2 align="center" class="w3-center"><a href="${pageContext.request.contextPath}/main/main.do"><img src="${pageContext.request.contextPath}/resources/images/logo2019.jpg" width=10%></a></h2>
<ul  align="center"  class="main-menu" id="menu" class="nav">
    <li class=li><a href="${pageContext.request.contextPath}/request/list.do">주문요청</a></li>
    <li class=li><a href="${pageContext.request.contextPath}/notice/list.do">공지사항</a></li>
    <li class=li><a href="${pageContext.request.contextPath}/compliment/list.do">우수회원</a></li>
    <li class=li><a href="${pageContext.request.contextPath}/black/list.do">블랙리스트</a></li>
    <c:if test="${!empty user_id}">
	<li class=li><a href="${pageContext.request.contextPath}/message_request/list.do">메시지보기(<span id="message_count"></span>)</a></li>
    <li class=li><a href="${pageContext.request.contextPath}/point/list.do">포인트확인</a></li>
	</c:if>
</ul>
<!-- 상단 네비게이션 끝 -->















