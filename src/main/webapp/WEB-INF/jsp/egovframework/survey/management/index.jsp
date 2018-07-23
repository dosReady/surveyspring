<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script type="text/javascript">
	function goReg(){
		location.href="<c:url value='/survey/regForm.do'/>"
	}
	
	function goDel(){
		// 다중 선택 삭제 로직
	}
</script>

<div>
<h1>설문지 관리</h1>
<input type="button" value="등록" onclick="goReg()"/>
<input type="button" value="삭제" onclick="goDel()"/>
</div>

<ul>
  <li> 설문지 1 </li>
  <li> 설문지 2 </li>
</ul>
