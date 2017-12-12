<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<title>Se connecter</title>
</head>

<%@ include file="layouts/header.jsp" %>

<form name="loginForm" action="" method="POST">
	<p>	
		<label>Login :</label>
		<input type="text" name="username">
	</p>
	<p>	
		<label>E-mail :</label>
		<input type="email" name="email">
	</p>
	<p>	
		<label>Mot de passe :</label>
		<input class="<c:out value="${errorPwdClass}" />" type="password" name="password">
	</p>
	<p>
		<input type="submit" value="Se connecter">
	</p>
</form>

<c:if test="${sessionScope.isUserLogged}">
	<c:redirect url="/home"></c:redirect>
</c:if>

<%@ include file="layouts/footer.jsp" %>