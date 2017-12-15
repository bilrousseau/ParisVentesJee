<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<jsp:include page="layouts/head.jsp">
		<jsp:param value="Accueil" name="title"/>
	</jsp:include>
	<body>
		<%@ include file="layouts/header.jsp"%>
			<div class="container">
				<s:if test="#session.isUserLogged">
						<table id="home-section" class="table table-striped">
							<tr>
								<th>Titre</th>
								<!-- <th>Image</th> -->
								<th>Description</th>
								<th>Prix</th>
							</tr>
							
							<s:iterator value="articleList">
								<tr class="article" data-id="<s:property value="id" />" >
									<th>
										<h3><s:property value="title" /></h3>
									</th>
<%-- 									<th>
										<figure>
											<a href="<s:url value="/article"><s:param name="id" value="${article.id}"/></s:url>">
												<img src="<c:url value="/img/${article.linkImg}" />" alt="<c:out value="${article.description}" />">
											</a>
										</figure>
									</th> --%>
									<th>
										<span class="article-description"><s:property value="description" /></span>
									</th>
									<th>
										<span class="article-price"><s:property value="price" /> €</span>
									</th>
								</tr>
							</s:iterator>
						</table>

				</s:if>
				<s:else>
					<span>Veuillez <a href="login.jsp"></a>vous connecter pour accéder à nos articles.</span>
				</s:else>
				<%-- <c:choose>
					<c:when test="${empty articleList}">
						<span>Aucun article.</span>
					</c:when>
					<c:otherwise>
						<table id="home-section" class="table table-striped">
							<tr>
								<th>Titre</th>
								<th>Image</th>
								<th>Description</th>
								<th>Prix</th>
							</tr>
							<c:forEach items="${articleList}" var="article">
								<tr class="article" data-id="<c:out value="${article.id}" />">
									<th>
										<h3><c:out value="${article.title}" /></h3>
									</th>
									<th>
										<figure>
											<a href="<c:url value="/article"><c:param name="id" value="${article.id}"/></c:url>">
												<img src="<c:url value="/img/${article.linkImg}" />" alt="<c:out value="${article.description}" />">
											</a>
										</figure>
									</th>
									<th>
										<span class="article-description"><c:out value="${article.description}" /></span>
									</th>
									<th>
										<span class="article-price"><c:out value="${article.price}" /> €</span>
									</th>
								</tr>
							</c:forEach>
						</table>
					</c:otherwise>
				</c:choose> --%>
			</div>
		<%@ include file="layouts/footer.jsp" %>
	</body>
</html>