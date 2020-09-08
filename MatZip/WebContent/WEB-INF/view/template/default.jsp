<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${title }</title>
<link rel="stylesheet" type="text/css" href="/res/css/common.css">

</head>
<body>
	<div id="container">
					<!--UserController 클래스 내용보면 이해될거임 -->
					<!--view 라는 이름을 오타방지용으로 Const(final)를 주고 그 밸류값은 user/login 임  -->
		<jsp:include page="/WEB-INF/view/${view}.jsp"></jsp:include>
	</div>
	
</body>
</html>