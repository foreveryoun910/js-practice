<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원정보변경</title>
</head>
<body>
	<div align="center">
		<div>
			<h1>회원정보변경</h1>
		</div>
		<div>
			<form id="frm" name="frm" action="memberUpdateSearch.do" method="post">
				<table border="1" style="border-collapse: collapse;">
					<tr>
						<th width="250">변경할 회원 아이디 입력</th>
						<td width="170" align="center">
							<input type="text" id="id" name="id">
						</td>
						<td width="50" align="center">
							<input type="submit" value="검색">
						</td>
					</tr>
				</table><br>
				<button type="button" onclick="location.href='main.do'">홈으로 돌아가기</button>
			</form>
		</div>
	</div>
</body>
</html>