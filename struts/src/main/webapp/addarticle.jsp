<%@ include file="layouts/libs.jsp" %>
<html>
	<jsp:include page="layouts/head.jsp">
		<jsp:param name="title" value="Ajouter un article" />
	</jsp:include>
	<body>
		<%@ include file="layouts/header.jsp" %>
		<h3>Ajouter un article</h3>
		
		<s:form action="addArticle" method="POST">
			<s:file name="articleImgUpload" label="Sélectionnez un fichier" size="40" />
			<s:submit value="Valider" name="submit" />
		</s:form>
		
		<%@ include file="layouts/footer.jsp" %>
	</body>
</html>