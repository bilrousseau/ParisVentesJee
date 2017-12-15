<%@ include file="libs.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

	<body>
		<div class="header">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<ul class="nav navbar-nav">
						<li><a href="index.jsp">Accueil</a></li>
						<s:if test="#session.isUserLogged">
							<li>
								<a href="<s:url action="logout" />">Se déconnecter</a>
							</li>
							
							<li>
								<a href="<s:url action="searchuser" />">Rechercher un utilisateur</a>
							</li>
						</s:if>
						<s:else>
							<li>
								<a href="<s:url action="loginInput" />">Se connecter</a>
							</li>
							<li>
								<a href="<s:url action="registerInput" />">S'enregistrer</a>
							</li>
						</s:else>

						<li><a href="<s:url action="contact" />">Contact</a></li>
						<li><a href="<s:url action="form" />">Formulaire</a></li>
						<li class="greeting">
							<a>
							
								<s:if test="#session.isUserLogged">
									Bienvenue <s:property value="#user.firstname"/>
								</s:if>
								<s:else>
									Invité
								</s:else>
							</a>
						</li>
						<s:if test="#session.isUserLogged">
							<li><a><span class="user-email"><c:out value="${sessionScope.userEmail}" /></span></a></li>
						</s:if>
						<c:if test="${sessionScope.isUserLogged}">
							<li><a><span class="user-email"><c:out value="${sessionScope.userEmail}" /></span></a></li>
						</c:if>
					</ul>	
				</div>
			</nav>
		</div>
	</body>
</html>