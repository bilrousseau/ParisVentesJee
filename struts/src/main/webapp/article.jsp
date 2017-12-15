<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<html>
<jsp:include page="layouts/head.jsp">
	<jsp:param value="Détail de l'article" name="title" />
</jsp:include>
<body>
	<%@ include file="layouts/header.jsp"%>
	<h2>Détail de l'article</h2>
	<div class="container">
		<s:if test="%{articleBean==null}">
			<span>Aucun article correspondant à cet identifiant.</span>
		</s:if>
		<s:else>
			<section>
				<article data-id="<s:property value="id"/>">
					<h3><s:property value="articleBean.title"/></h3>
					<figure>
						<img src="<s:url value="/img/%{articleBean.linkImg}" />" 
							alt=""<s:property value="articleBean.description"/>
						/>
						<figcaption><s:property value="articleBean.description"/></figcaption>
					</figure>
					<span><s:property value="articleBean.price"/> €</span>
				</article>
			</section>
		</s:else>
	</div>
	<%@ include file="layouts/footer.jsp"%>
</body>
</html>