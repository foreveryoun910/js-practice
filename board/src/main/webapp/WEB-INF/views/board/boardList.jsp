<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>글 목록</title>
	<script type="text/javascript">
		function getRecord(n) {
			frm.bId.value = n;
			frm.submit();
		}
	</script>
</head>
<body>
	<div align="center">
		<div><h1>글 목록</h1></div>
		<div>
			<table border="1" style="border-collapse: collapse;">
				<tr>
					<th width="70">글 번호</th>
					<th width="300">글 제목</th>
					<th width="150">작성자</th>
					<th width="150">작성일자</th>
					<th width="70">조회수</th>
				</tr>
				<c:forEach var="board" items="${ boards }">
					<tr onmouseover="this.style.background='yellow'" onmouseout="this.style.background='white'" onclick="getRecord(${ board.bId })">
						<td align="center">${ board.bId }</td>
						<td>${ board.bTitle }</td>
						<td align="center">${ board.bWriter }</td>
						<td align="center">${ board.bDate }</td>
						<td align="center">${ board.bHit }</td>							
					</tr>
				</c:forEach>
			</table>
		</div><br>
		<div>
			<button type="button" onclick="location.href='home.do'">back home</button>&nbsp;&nbsp;&nbsp;
			<button type="button" onclick="location.href='insertForm.do'">write</button>
		</div>
		
		<form id="frm" name="frm" action="boardSelect.do" method="post">
			<input type="hidden" id="bId" name="bId">	
		</form>
	</div>
</body>
</html>