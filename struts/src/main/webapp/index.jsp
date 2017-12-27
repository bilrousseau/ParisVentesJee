<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<jsp:include page="layouts/head.jsp">
	<jsp:param value="Accueil" name="title" />
</jsp:include>
<body>
	<%@ include file="layouts/header.jsp"%>
	<div class="container">
		<s:if test="#session.isUserLogged">
			<s:if test="%{articleList.isEmpty()}">
						Aucun article.
			</s:if>
			<s:else>
				<table id="home-section" class="table table-striped">
					<thead>
						<tr>
							<th>ID</th>
							<th>Titre</th>
							<th>Image</th>
							<th>Description</th>
							<th>Prix</th>
							<th>Actions</th>
						</tr>
					</thead>					
					<tbody>
						<s:iterator value="articleList">
							<tr class="article" data-id="<s:property value="id" />">
								<td>
									<s:property value="id" />
								</td>
								<td>
									<h3>
										<s:property value="title" />
									</h3>
								</td>
								<td>
									<s:set var="articleId" value="id"></s:set> 
									<s:set var="articleLinkImg" value="linkImg"></s:set>
									<figure>
										<a
											href="<s:url action="article/%{#articleId}" />">
											<img style="width: 100px; height: 100px"
											src="<s:url value="img/%{#articleLinkImg}" />"
											alt="<s:property value="description" />">
										</a>
									</figure>
								</td>
								<td>
									<span class="article-description">
										<s:property value="description" />
									</span>
								</td>
								<td>
									<span class="article-price">
										<s:property	value="price" /> €
									</span>
								</td>
								<td>
									<div class="btn-group-vertical">
										<button type="button" class="btn btn-primary">Modifier</button>
										<a href="<s:url action="deleteArticle/%{#articleId}" />">
											<button type="button" class="btn btn-danger">Supprimer</button>
										</a>
									</div>
								</td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</s:else>
				<a href="<s:url action="addArticleInput" />">
					Ajouter un article
				</a>
		</s:if>
		<s:else>
			
			<span>Veuillez <a href="<s:url action="loginInput" />">vous connecter</a> pour
				accéder à nos articles.
			</span>
		</s:else>
	</div>
	<%@ include file="layouts/footer.jsp"%>
</body>
</html>