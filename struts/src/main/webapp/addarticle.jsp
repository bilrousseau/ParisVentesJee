<%@ include file="layouts/libs.jsp" %>
<html>
	<jsp:include page="layouts/head.jsp">
		<jsp:param name="title" value="Ajouter un article" />
	</jsp:include>
	<body>
		<%@ include file="layouts/header.jsp" %>
		<h3>Ajouter un article</h3>
		
		<s:form action="addArticle">
			<s:textfield name="articleBean.title" label="Titre" />
			<s:file name="fileUpload" label="Sélectionnez un fichier" size="40" />
			<s:textfield name="articleBean.description" label="Description"  />
			<s:textfield type="number" name="articleBean.price" label="Prix" />
			<s:submit value="Valider" />
		</s:form>
		
		<%@ include file="layouts/footer.jsp" %>
	</body>
</html>