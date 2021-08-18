<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script>
        	$(document).ready(function(){
				// 조회
        		$.ajax({
        			url: 'ReviewListServlet', // 요청페이지
        			dataType: 'json',
        			success: reviewListFnc,
        			error: function(reject){
        				console.error(reject);
        			}
        		});
				
				// 한건조회
				$.ajax({
					url: 'ReviewSelectServlet',
					dataType: 'json',
					success: reviewSelectFnc,
					error: function(reject){
        				console.error(reject);
        			}
				});
        		
				// 입력
				$('#insertFrm').on('submit', function(event){
					event.preventDefault();
					$.ajax({
						url: $('#insertFrm').attr('action'),
						method: 'post',
						data: $('#insertFrm').serialize(),
						dataType: 'json',
						success: insertFnc,
						error: function(reject){
							console.error(reject);
						}
					});
				});
				// 삭제
        		
        	});
        	
        	// 리뷰리스트조회 콜백함수
        	function reviewListFnc(data){
        		let br = $('<br>');
        		let table = $('<table />').attr('border', '1');
        		
        		for(let i=0; i<data.length; i++){
        			let tr1 = $('<tr />');
        			let th_writer = $('<th />').attr('width', '90').text('작성자');
            		let td_writer = $('<td />').text(data[i].email).attr('width', '200');
            		let th_like = $('<th />').attr('width', '90').text('별점');
       				let td_like = $('<td />').attr('width', '130').text(data[i].reviewLike);
       				$(tr1).append(th_writer, td_writer, th_like, td_like);
       				
       				let tr2 = $('<tr />');
       				let td_content = $('<td />').attr('colspan', '3').attr('height', '150').text(data[i].reviewContent);
       				let td_button = $('<td />');
       				let updateBtn = $('<button />').attr('id', 'updateBtn').text('수정');
       				$(updateBtn).on('click', function(){
       					// 수정 함수
       					$.ajax({
       						url: 'reviewUpdateForm.do',
       						method: 'post',
       						success: function(){
       							//
       						},
       						error: function(){}
       					});
       				});
       				$(td_button).append(updateBtn)
					$(tr2).append(td_content, td_button);
					
       				$(table).append(tr1, tr2, br);
        		}
        		$('#list').append(table);
        	}        	
        	
        	// 한건조회 콜백함수
        	function reviewSelectFnc(data){
        		
        	}
        	
        	
        	// 입력 콜백함수
        	function insertFnc(data){
        		let table = $('<table />').attr('border', '1');
        		
       			let tr1 = $('<tr />');
       			let th_writer = $('<th />').attr('width', '90').text('작성자');
           		let td_writer = $('<td />').text(data.email).attr('width', '200');
           		let th_like = $('<th />').attr('width', '90').text('별점');
      			let td_like = $('<td />').attr('width', '130').text(data.reviewLike);
      			$(tr1).append(th_writer, td_writer, th_like, td_like);
       				
       			let tr2 = $('<tr />');
       			let td_content = $('<td />').attr('colspan', '3').attr('height', '150').text(data.reviewContent);
       			let td_button = $('<td />');
       			let updateBtn = $('<button />').attr('id', 'updateBtn').text('수정');
       			$(updateBtn).on('click', function(){});
       			$(td_button).append(updateBtn)
				$(tr2).append(td_content, td_button);
					
       			$(table).append(tr1, tr2, br);
        		$('#list').append(table);
        	}
        	
        	$("#update").hide();
        	// 삭제 콜백함수
        </script>	
</head>
<body>

	<!-- 수정폼 // 안 보이다가 수정버튼을 누르면 보이도록 -->
	<h3>수정</h3>
	<div id="update">
		<form id="updateFrm" action="reviewUpdate.do" method="post">
			<table border="1">
				<tr>
					<th width="90">작성자</th>
					<td width="200"><input type="text" id ="email" name ="email" value="${sessionEmail}"></td>
					<th width="90">별점</th>
					<td width="130"><input type="text" id ="reviewLike" name ="reviewLike" required="required"></td>
				</tr>
				<tr>
					<td colspan="4" height="150">
						<textarea rows="9" cols="70" id = "reviewContent" name ="reviewContent" required="required"></textarea>
					</td>
				</tr>
			</table>
		   <br>
		   <input type="submit" value="수정">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소">
		</form>	
	</div>


	<!-- 입력폼 -->
	<h3>입력</h3>
	<div id="insert">
		<form id="insertFrm" action="ReviewInsertServlet" method="post">
			<table border="1">
				<tr>
					<th width="90">작성자</th>
					<td width="200"><input type="text" id ="email" name ="email" value="${sessionEmail}" required="required"></td>
					<th width="90">별점</th>
					<td width="130"><input type="text" id ="reviewLike" name ="reviewLike" required="required"></td>
				</tr>
				<tr>
					<td colspan="4" height="150">
						<textarea rows="9" cols="70" id = "reviewContent" name ="reviewContent" required="required"></textarea>
					</td>
				</tr>
			</table>
		   <br>
		   <input type="submit" value="글쓰기">&nbsp;&nbsp;&nbsp;<input type="reset" value="취소">
		</form>	
	</div>

	<div id="list">
	</div>
	
	
	<!-- 목록 출력 
	<div id="list" align="center">
		<div><h3>리뷰목록</h3></div>
		<div>
			<table border="1">
			<c:forEach var="review" items="${list}">
				<tr>
					<th width="90">작성자</th>
					<td width="200" align="center">${review.email}</td>
					<th width="90">별점</th>
					<td width="160" align="center">${review.reviewLike}</td>
				</tr>
				<tr>
					<td colspan="3" height="150">${review.reviewContent}</td>
					<td align="center">
						<br><br><br><br>
						<button type="button" onclick="location.href='reviewUpdateForm.do'">수정</button>&nbsp;
						<button type="button">삭제</button>
					</td>
				</tr>
			</c:forEach>				
			</table>		
		</div>
		<div>
			<button type="button" onclick="location.href='home.do'">HOME</button>
		</div>
	</div>
-->
</body>
</html>