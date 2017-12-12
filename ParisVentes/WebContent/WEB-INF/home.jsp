<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.ArrayList" import="com.parisventes.beans.Articles" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%@ include file="layouts/head.jsp" %>
	<body>
	
		<%@ include file="layouts/header.jsp"%>
			<div class="container">
				<c:choose>
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
				</c:choose>
			</div>
		<%@ include file="layouts/footer.jsp" %>
	</body>
</html>