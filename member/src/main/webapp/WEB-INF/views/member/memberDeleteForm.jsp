<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원삭제</title>
</head>
<body>
	<div align="center">
		<h1>회원삭제</h1>
		<div>
			<form id="frm" name="frm" action="memberDelete.do" method="post">
				<table border="1" style="border-collapse: collapse;">
					<tr>
						<th width="250">삭제할 회원 아이디 입력</th>
						<td width="170" align="center">
							<input type="text" id="id" name="id">
						</td>
						<td width="50" align="center">
							<input type="submit" value="삭제">
						</td>
					</tr>
				</table><br>
				<button type="button" onclick="location.href='main.do'">홈으로 돌아가기</button>
			</form>
		</div>	
	</div>
</body>
</html>