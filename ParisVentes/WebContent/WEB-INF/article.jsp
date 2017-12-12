<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ include file="layouts/head.jsp" %>
<%@ include file="layouts/header.jsp" %>

	<c:choose>
		<c:when test="${article == null}">
			<span>Aucun article ne correspond à cet identifiant.</span>
		</c:when>
		<c:otherwise>
			<section>
	    		<article data-id="${article.id}">
	    			<h3>${article.title}</h3>
	    			<figure>	
	    				<img src="<c:url value="/img/${article.linkImg}" />" alt="${article.description}">
	    				<figcaption>${article.description}</figcaption>
	    			</figure>
	    			<span>${article.price} €</span>
	    		</article>
		    </section>
		</c:otherwise>
	</c:choose>
<%@ include file="layouts/footer.jsp" %>
