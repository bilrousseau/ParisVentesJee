<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<title>S'enregistrer</title>
</head>

<%@ include file="layouts/header.jsp" %>

<form name="signupForm" method="post">
	<p>
		<label>Prénom :</label>
		<input type="text" name="firstname">
		<span class="error"><c:out value="${signupErrors.errorFirstname}" /></span>
	</p>
	<p>
		<label>Nom :</label>
		<input type="text" name="lastname">
		<span class="error"><c:out value="${signupErrors.errorLastname}" /></span>
	</p>
	<p>
		<label>Adresse e-mail :</label>
		<input type="text" name="email">
		<span class="error"><c:out value="${signupErrors.errorEmail}" /></span>
	</p>
	<p>
		<label>Numéro de téléphone :</label>
		<input type="tel" name="phone">
		<span class="error"><c:out value="${signupErrors.errorPhone}" /></span>
	</p>
	<p>
		<label>Mot de passe :</label>
		<input type="password" name="password">
		<span class="error"><c:out value="${signupErrors.errorPassword}" /></span>	
	</p>
	<p>
		<label>Confirmer le mot de passe :</label>
		<input type="password" name="passwordRepeat">		
		<span class="error"><c:out value="${signupErrors.errorPassword}" /></span>	
	</p>
	<p>
		<input type="submit" value="Confirmer">
	</p>
</form>

<%@ include file="layouts/footer.jsp" %>