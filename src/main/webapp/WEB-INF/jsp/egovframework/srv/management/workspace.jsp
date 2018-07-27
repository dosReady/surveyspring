<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
<h1>작업도구</h1>

<div id ="tool-container">
	<select-type></select-type>
	<text-type></text-type>
</div>

</div>

<script>

	
	var textType = {
		template : '<h1> 텍스트타입 </h1>'
	};
	
	
	var selectType = {
		template : '<h1> 선택 타입</h1>'
	};
	
	new Vue({
		el : '#tool-container',
		components : {
			'select-type' : selectType,
			'text-type' : textType
		}
	});

</script>
