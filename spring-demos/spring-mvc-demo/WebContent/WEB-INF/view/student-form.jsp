<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
</head>

<body>
	<h2>Student form</h2>
	<hr>
	<form:form action="processForm" modelAttribute="student">
	
		First name: <form:input path="firstName" />
		
		<br><br>
		
		Last name: <form:input path="lastName" />
		
		<br><br>
		
		Country: 
		
		<form:select path="country">
			<form:options items="${student.countryOptions}" />
			<!--<form:option value="${student.countryOptions.BR}" label="${student.countryOptions.BR}" />
			<form:option value="${student.countryOptions.FR}" label="${student.countryOptions.FR}" />
			<form:option value="Germany" label="Germany" />
			<form:option value="India" label="India" />-->
		</form:select>	
		
		<br><br>
		
		Favorite language: 
		<form:radiobuttons path="favoriteLanguage" items="${student.favoriteLanguageOptions}" />
		
		<!-- 
		Java <form:radiobutton path="favoriteLanguage" value="Java" /> 
		C# <form:radiobutton path="favoriteLanguage" value="C#" /> 
		PHP <form:radiobutton path="favoriteLanguage" value="PHP" /> 
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" /> 
		-->
		 
		<br><br>
		
		Operating systems:
		Linux <form:checkbox path="operatingSystems" value="Linux" />
		Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
		MS Windows <form:checkbox path="operatingSystems" value="MS Windows" />
		
		<input type="submit" value="Submit" />
	</form:form>
</body>

</html>