<%@ include file="layouts/libs.jsp" %>
<html>
	<body>
		<div class="file-info">
			<p>
				<h4>Nom du fichier : </h4> <s:property value="fileUploadFileName" />
			</p>
			<p>
				<h4>Type de contenu : </h4> <s:property value="fileUploadContentType" />
			</p>
			<p>
				<h4>Fichier : </h4> <s:property value="fileUpload" />
			</p>
		</div>
	</body>
</html>