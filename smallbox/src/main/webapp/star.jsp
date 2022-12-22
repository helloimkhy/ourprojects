<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var locked = 0;
	var i;
	var image;
	var el;

	function mouseover(star) {
		if (locked == 1)
			return;
			image = 'image' + star;
			el = document.getElementById(image);
			el.src = "image/star1.png";
		} // ~~~ for end~~~

	} // ~~~~function mouseover end~~~~

	function mouseout(star) {
		if (locked == 1)
			return;

		for (i = 1; i <= star; i++) {
			image = 'image' + i;
			el = document.getElementById(image);
			el.src = "image/star0.png";
		}// ~~~ for end~~~
	} // ~~~~function mouseout end~~~~

	function lock(star) {
		mouseover(star);
		locked = 1;
	} // ~~~~function lock end~~~~

	function onClk(star) {
		lock(star);
		alert("별점 : " + star);
		document.commentForm.star.value = star;
	} // ~~~~function onClk end~~~~
</script>
</head>
<body>
		<h2>영화 예약</h2>
		<hr>
		<form action=""method="post" name="reserve">
			<div>
				<span>
					<img id="image1" onmouseover=mouseover(1) onclick=onClk(1) onmouseout=mouseout(1) src="image/star0.png" width="20" height="20">
					<img id="image2" onmouseover=mouseover(2) onclick=onClk(2) onmouseout=mouseout(2) src="image/star0.png" width="20" height="20">
					<img id="image3" onmouseover=mouseover(3) onclick=onClk(3) onmouseout=mouseout(3) src="image/star0.png" width="20" height="20">
					<img id="image4" onmouseover=mouseover(4) onclick=onClk(4) onmouseout=mouseout(4) src="image/star0.png" width="20" height="20">
					<img id="image5" onmouseover=mouseover(5) onclick=onClk(5) onmouseout=mouseout(5) src="image/star0.png" width="20" height="20">
					<img id="image6" onmouseover=mouseover(6) onclick=onClk(6) onmouseout=mouseout(6) src="image/star0.png" width="20" height="20">
					<img id="image7" onmouseover=mouseover(7) onclick=onClk(7) onmouseout=mouseout(7) src="image/star0.png" width="20" height="20">
					<img id="image8" onmouseover=mouseover(8) onclick=onClk(8) onmouseout=mouseout(8) src="image/star0.png" width="20" height="20">
				</span>
				<span>
				</span>
			</div>
			<input type="hidden" name="star" >	
		</form>
		<hr>
		
</body>
</html>