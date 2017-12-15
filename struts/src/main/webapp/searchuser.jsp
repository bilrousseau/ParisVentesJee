<%@ include file="layouts/libs.jsp" %>
<html>
	<jsp:include page="layouts/head.jsp">
		<jsp:param name="title" value="Rechercher un utilisateur" />
	</jsp:include>
	<body>
		<%@ include file="layouts/header.jsp" %>
		<h3>Rechercher un utilisateur</h3>
		
		<s:form action="searchUser">
		  <s:textfield name="personBean.email" label="Entrez une adresse e-mail" />
		  <s:submit value="Rechercher" />
		</s:form>
		
		<s:if test="%{personBean==null}">
			Aucun résultat.
		</s:if>
		<s:else>
			<div class="panel panel-info">
					<div class="panel-heading"><s:property value="personBean.firstname" /> <s:property value="personBean.lastname" /><s:property value="" /></div>
					<div class="panel-body">
						<p>
							Numéro de téléphone : <s:property value="personBean.phone" />
						</p>
					</div>
				</div>
		</s:else>
		<%@ include file="layouts/footer.jsp" %>
	</body>
</html>