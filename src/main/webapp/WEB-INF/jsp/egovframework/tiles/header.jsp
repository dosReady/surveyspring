<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:if test="${sessionScope.id ne null }">
<div>
<h1>로그인 : ${sessionScope.id} <a href="<c:url value='/login/out.do'/>">로그아웃</a></h1> 
</div>

<div>
	<ul>
			<li><a href="<c:url value='/survey/management/list.do'/>">설문지관리</a></li>
			<li><a href="<c:url value='/survey/userList.do'/>">사용자목록</a></li>
			<li><a href="<c:url value='/survey/management/goWorkspace.do'/>">작업공간</a></li>
	</ul>
</div>

</c:if>
<div>
	<h1>헤더</h1>
</div>
