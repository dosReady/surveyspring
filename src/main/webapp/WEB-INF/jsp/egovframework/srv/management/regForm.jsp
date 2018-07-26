<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div>
<h1>설문지 등록</h1>

<div id="form-group-title">
	<label for="surveyMtNm">설문조사명</label>
	<input type="text" name="surveyMtNm"/>
</div>

<div id="form-group-category">
	<label for="surveyCategryId">Category</label>
	<input type="text" name="surveyCategryId"/>
</div>

<div id="form-group-tmplt">
	<label for="surveyTmpltId">Template</label>
	<input type="text" name="surveyTmpltId"/>
</div>

<div id="form-group-description">
	<label for="surveyDescription">Description</label>
	<input type="text" name="surveyDescription"/>
</div>


<div id="form-group-button">
	<input type="button" value="저장" v-on:click="getData"/>
	<input type="button" value="목록" onclick="goList()"/>
</div>


</div>

<script type="text/javascript">
	function goList() {
		location.href="<c:url value='/survey/management/list.do'/>"
	}
	
	var buttonObj1 = {
		el : "#form-group-button",
		data : { 
			request :{				
				url : "<c:url value='/action/management/test.do'/>",
				method : "POST",
				dataType : "json",
				data : {
					data : "data"	
				}
			}			
		}
	}
	
	new Vue (buttonObj1);
</script>