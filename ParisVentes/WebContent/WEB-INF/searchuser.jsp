<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link href="${pageContext.request.contextPath}/css/styles.css" rel="stylesheet">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
	<title>Rechercher un utilisateur</title>
</head>

<%@ include file="layouts/header.jsp" %>

<h3>Rechercher un utilisateur</h3>
<form name="searchUserForm" method="POST">
	<p>
		<label>Entrez une adresse e-mail valide:</label>
		<input type="email" name="userEmail">
		<input type="submit" value="Rechercher">
	</p>
</form>
	
<div class="search-results">
	<c:if test="${requestSent == true}">
		<c:choose>
			<c:when test="${userFound == null}">
				<p>
					Aucun utilisateur correspondant à l'e-mail "<c:out value="${userEmail}" />". Veuillez réessayer.
				</p>
			</c:when>
			<c:otherwise>
				<div class="panel panel-info">
					<div class="panel-heading"><c:out value="${userFound.firstname} ${userFound.lastname}" /></div>
					<div class="panel-body">
						<p>
							Numéro de téléphone : <c:out value="${userFound.phone}" />
						</p>
					</div>
				</div>
			</c:otherwise>
		</c:choose>
	</c:if>
	
</div>
<%@ include file="layouts/footer.jsp" %>