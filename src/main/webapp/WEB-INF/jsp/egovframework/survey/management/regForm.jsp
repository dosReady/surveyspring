<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function goList() {
		location.href="<c:url value='/survey/management.do'/>"
	}
</script>

<div>
<h1>설문지 등록</h1>

<form action="<c:url value='/survey/reg.do'/>">
<ul>
  <li>
  	<input type="submit" value="저장"/>
	<input type="button" value="목록" onclick="goList()"/>
  </li>
  <li> 설문지 1 </li>
  <li> 설문지 2 </li>
  
</ul>
</form>

</div>

