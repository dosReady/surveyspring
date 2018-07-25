<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>로그인</h1>
<form action='<c:url value="/login/process.do"/>' method="post">
	<table>
	  <tr>
	    <th>아이디</th>
	    <td><input name="id" type="text"/></td>
	  </tr>
	  <tr>
	    <th>비밀번호</th>
	    <td><input name="pwd" type="password"/></td>
	  </tr>
	  <tr>
	    <td rowspan="2">
		    <input type="submit" value="로그인"/>
	    </td>
	  </tr>
	  
	</table>
</form>
