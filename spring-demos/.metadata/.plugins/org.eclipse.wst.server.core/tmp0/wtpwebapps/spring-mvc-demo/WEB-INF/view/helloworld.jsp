<!DOCTYPE html>
<html>
<head>
	<title>Hello world - Result</title>
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/my-test.css">
    <script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>
</head>

<body>
	<h1>Hello world of Spring!</h1>
	
	<br><br>
	
	Student name: ${param.studentName}
	
	<br><br>
	
	The message: ${message}

</body>
</html>