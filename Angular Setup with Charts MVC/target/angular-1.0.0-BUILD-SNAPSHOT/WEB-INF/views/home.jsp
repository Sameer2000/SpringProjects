<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html data-ng-app="testModule">
<head>
	<title>Home</title>
	<jsp:include page="scripts.jsp"></jsp:include>
</head>
<body >
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

<div >


<input type="text" data-ng-model="firstName"/>

{{firstName}}
</div>


<div data-ng-view=""></div>

</body>


</html>
