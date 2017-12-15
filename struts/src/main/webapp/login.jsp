<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<html>
	<jsp:include page="layouts/head.jsp">
		<jsp:param name="title" value="Se connecter" />
	</jsp:include>
	<body>
		<%@ include file="layouts/header.jsp" %>

		<s:form action="login">
			<s:textfield name="personBean.email" label="Adresse e-mail" />
			<s:textfield name="personBean.password" label="Mot de passe" />
			<s:submit/>
		</s:form>
		
		<p>
			<a href="lostpassword.jsp">Mot de passe oublié ?</a>
		</p>
		
		<%@ include file="layouts/footer.jsp" %>
	</body>
</html>
