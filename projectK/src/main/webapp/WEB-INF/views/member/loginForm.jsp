<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>LOGIN</title>
	<jsp:include page="../home/header.jsp"></jsp:include>
</head>
<body>
	<div align="center">
		<div><h1>LOG-IN</h1></div>
		<hr><br>
		<div>
			<form id="frm" name="frm" action="login.do" method="post">
				<div>
					<table border="1">
						<tr>
							<th width="100">아이디</th>
							<td width="200"><input type="text" id="id" name="id" size="30" placeholder="아이디를 입력하세요." required="required"></td>
						</tr>
						<tr>
							<th width="100">패스워드</th>
							<td width="200"><input type="password" id="password" name="password" size="30" placeholder="패스워드를 입력하세요." required="required"></td>
						</tr>
					</table>
				</div><br>
				<div>
					<input type="submit" value="로그인">&nbsp;&nbsp;&nbsp;
					<input type="reset" value="취소">
				</div>
			</form>
		</div>
	</div>
</body>
</html>