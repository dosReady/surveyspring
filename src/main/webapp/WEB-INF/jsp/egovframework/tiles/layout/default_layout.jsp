<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>기본 레이아웃 </title>
</head>
<style>
@import url(//fonts.googleapis.com/earlyaccess/nanumgothic.css);

body {
	background-image: url("<c:url value='/images/green.jpg'/>");
}

#content {
	background-color: white;
	overflow:hidden;
	height: auto;
}
</style>

<body>
	<div id="wrap">
    <!-- head -->
    <div id="header"><tiles:insertAttribute name="header" /></div>
     
    <!-- content -->
     <div id="content"><tiles:insertAttribute name="content" /></div>
 
    <!-- footer -->
    <div id="footer"><tiles:insertAttribute name="footer" /></div>
</div>


</body>
</html>