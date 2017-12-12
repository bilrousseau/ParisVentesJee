<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Insert title here</title>
	</head>
	<body>
		<div class="header">
			<nav class="navbar navbar-default">
				<div class="container-fluid">
					<ul class="nav navbar-nav">
						<li><a href="${pageContext.request.contextPath}/home">Accueil</a></li>
						<c:choose>
							<c:when test="${sessionScope.isUserLogged}">
								<li>
									<a href="<c:url value="/logout"></c:url>">Se déconnecter</a>
								</li>
							</c:when>
							<c:otherwise>
								<li>
									<a href="<c:url value="/login" />">Se connecter</a>
								</li>
							</c:otherwise>
						</c:choose>
						<li><a href="#contact">Contact</a></li>
						<li><a href="#formulaire">Formulaire</a></li>
						<li class="greeting"><a>Bienvenue <c:out value="${sessionScope.userName}" default="Invité" /></a></li>
						<c:if test="${sessionScope.isUserLogged}">
							<li><a><span class="user-email"><c:out value="${sessionScope.userEmail}" /></span></a></li>
						</c:if>
					</ul>	
				</div>
			</nav>
		</div>
	</body>
</html>