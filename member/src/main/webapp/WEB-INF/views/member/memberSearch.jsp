<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원조회</title>
</head>
<body>
	<div align="center">
		<c:if test="${ not empty message }">
			<h1>${ message }</h1>
		</c:if>
		<!-- 비어있지 않다면 == member가 있다 == message가 없다 == 값이 반환된다 -->
		<c:if test="${ not empty member }">
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<td align="center" width="150">${ member.id }</td>
					<td align="center" width="150">${ member.name }</td>
				</tr>
			</table><br>
			<form>
				<button type="button" onclick="location.href='main.do'">홈으로 돌아가기</button>
			</form>
		</c:if>
	</div>
</body>
</html>