<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<title>Mot de passe oublié ?</title>
</head>

<%@ include file="layouts/header.jsp" %>
	<h3>Mot de passe oublié</h3>
<form name="lostPasswordForm" method="post">
	<p>
		<label>Entrez votre adresse e-mail :</label>
		<input type="text" name="email">
		<input type="submit" value="Envoyer">
	</p>
</form>

<p>
	<c:out value="${error}"/>
</p>

<%@ include file="layouts/footer.jsp" %>