<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" 
     uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>공지사항</title>
<link rel="stylesheet" 
 href="${pageContext.request.contextPath}/resources/css/style.css?after">
<script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/jquery-3.3.1.min.js"></script>
</head>
<style>
table{
	width:900px;
	border:1px solid #000;
	border-collapse:collapse;
	margin-top: 5px;
	margin-bottom: 5px;
}
table td, table th{
	border:1px solid #000;
	padding:5px;
}
</style>
<body>
<div class="page-main-style">
<%@ include file="/WEB-INF/views/common/header.jsp" %>
<hr width="100%" noshade="noshade" size="1">
	<h1>공지사항 목록</h1>
	<c:if test="${count == 0}">
	<div class="align-center">
		등록된 게시물이 없습니다.
	</div>
	</c:if>
	<c:if test="${count > 0}">
	<table align="center">
		<thead>
		<tr align="center">
			<th>번호</th>
			<th width="400">제목</th>
			<th>작성자</th>
			<th>등록일</th>
			<th>조회수</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach var="notice" items="${list}">
		<tr align="center">
			<td>${notice.noti_num}</td>
			<td><a href="detail.do?num=${notice.noti_num}">${notice.noti_title}</a></td>
			<td>${notice.id}</td>
			<td>${notice.noti_date}</td>
			<td>${notice.noti_hit}</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
	<form action="list.do" id="search_form"
	      method="get"> 
		<ul class="search" align="center">
			<li> 
				<select name="keyfield" id="keyfield">
					<option value="noti_title">제목</option>
					<option value="id">작성자</option>
					<option value="noti_content">내용</option>
					<option value="all">전체</option> 
						</select>
					</li>
					<li>
						<input type="text" name="keyword" id="keyword">
					</li>
					<li>
						<input type="submit" value="검색">
						<input type="button" value="목록"
					       onclick="location.href='list.do'">
					</li>
				</ul>      
			</form>
	
		<div class="align-center">${pagingHtml}</div>
	</c:if>
	<div class="align-right">
		<c:if test="${!empty user_id && user_auth==2}">  
		<input type="button" value="글쓰기"
		  onclick="location.href='write.do'">
		</c:if>
	</div>
</div>
</body>
</html>






