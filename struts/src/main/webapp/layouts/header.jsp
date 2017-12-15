<%@ include file="libs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<body>
		<div class="header">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<ul class="nav navbar-nav">
						<li><a href="index.jsp">Accueil</a></li>
						<c:choose>
							<c:when test="${sessionScope.isUserLogged}">
								<li>
									<a href="logout.jsp">Se déconnecter</a>
								</li>
								
								<li>
									<a href="searchuser.jsp">Rechercher un utilisateur</a>
								</li>
							</c:when>
							<c:otherwise>
								<li>
									<a href="login.jsp">Se connecter</a>
								</li>
								<li>
									<a href="register.jsp">S'enregistrer</a>
								</li>
							</c:otherwise>
						</c:choose>
						<li><a href="contact.jsp">Contact</a></li>
						<li><a href="form.jsp">Formulaire</a></li>
						<li class="greeting">
							<a>
								<c:choose>
									<c:when test="${sessionScope.isUserLogged}">
										Bienvenue <c:out value="${sessionScope.user.firstname}"></c:out>
									</c:when>
									<c:otherwise>
										Invité
									</c:otherwise>
								</c:choose>
							</a>
						</li>
						<c:if test="${sessionScope.isUserLogged}">
							<li><a><span class="user-email"><c:out value="${sessionScope.userEmail}" /></span></a></li>
						</c:if>
					</ul>	
				</div>
			</nav>
		</div>
	</body>
</html>