<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"  
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<%
	String contextPath = request.getContextPath();
	String currentUrl = request.getRequestURL().toString();
%>

<meta name="_csrf" content="${_csrf.token}" />
<meta name="_csrf_header" content="${_csrf.headerName}" />
<meta name="_locale" content="${pageContext.response.locale}" />

<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/third-parties/bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/third-parties/dataTables.bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/third-parties/buttons.bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/third-parties/colReorder.bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/third-parties/fixedHeader.bootstrap.min.css" />
<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/third-parties/responsive.bootstrap.min.css" />

<script type="text/javascript" src="${contextPath}/resources/js/third-parties/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/jszip.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/pdfmake.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/vfs_fonts.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/dataTables.buttons.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/buttons.bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/buttons.colVis.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/buttons.html5.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/dataTables.colReorder.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/dataTables.fixedHeader.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/dataTables.responsive.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/third-parties/responsive.bootstrap.min.js"></script>
<script type="text/javascript" src="${contextPath}/resources/js/util.js"></script>

<script>
	var ctx = "${contextPath}"
	var _csrf = $("meta[name='_csrf']").attr("content");
	var _csrf_header = $("meta[name='_csrf_header']").attr("content");
	var _locale = $("meta[name='_locale']").attr("content");
</script>

<title><tiles:insertAttribute name="title" ignore="true" /></title>
</head>

<body>
	<div>
		<tiles:insertAttribute name="header" />
	</div>
	<div style="float: left; padding: 10px; width: 15%;">
		<tiles:insertAttribute name="menu" />
	</div>
	<div style="float: left; padding: 10px; width: 80%; border-left: 1px solid pink;">
		<tiles:insertAttribute name="body" />
	</div>
	<div style="clear: both">
		<tiles:insertAttribute name="footer" />
	</div>
</body>

</html>
