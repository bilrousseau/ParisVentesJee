<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
		<label>Mot de passe :</label>
		<input type="password" name="password">
	</p>
	<p>
		<input type="submit" value="Se connecter">
	</p>
</form>

<div>
	<p>${emailCookie}</p>
	<p>${passwordCookie}</p>
</div>

<%@ include file="layouts/footer.jsp" %>