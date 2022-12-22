<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예매 날짜 선택</title>
</head>
<body>
	<h1>예매 날짜 선택</h1>
	<form action="reserve_result.jsp" name="fr" method="post">
		<table border="1">
			<tr><td>상영 영화명</td><td><input type="text" name="the_title" required="required"></td></tr>
			<tr>
				<td>상영 날짜</td>
				<td>
					<input type="date" name="the_date" required="required">
				</td>
			</tr>
			<tr>
				<td>상영 시간</td>
				<td>
					<input type="text" name="the_time" required="required"> 
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="등록">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>