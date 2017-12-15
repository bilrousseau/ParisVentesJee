<%@ include file="layouts/libs.jsp" %>
<html>
	<jsp:include page="layouts/head.jsp">
		<jsp:param name="title" value="S'enregistrer" />
	</jsp:include>
	<body>
		<%@ include file="layouts/header.jsp" %>
		<h3>Enregistrez-vous ici.</h3>
		
		<s:form action="register">
		  <s:textfield name="personBean.firstname" label="Nom" />
		  <s:textfield name="personBean.lastname" label="Prénom" />
		  <s:textfield name="personBean.email"  label ="Adresse e-mail"/>  
		  <s:textfield name="personBean.phone"  label="Numéro de téléphone"  />
		  <s:password name="personBean.password"  label="Mot de passe"  />
		  <s:password name="passwordRepeat"  label="Confirm password"  />
		  <s:submit/>
		</s:form>
		
		<%@ include file="layouts/footer.jsp" %>
	</body>
</html>