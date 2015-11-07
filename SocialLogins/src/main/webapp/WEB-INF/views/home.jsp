<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<script>
	  window.fbAsyncInit = function() {
	    FB.init({
	      appId      : '1662225340682673',
	      xfbml      : true,
	      version    : 'v2.5'
	    });
	  };
	
	  (function(d, s, id){
	     var js, fjs = d.getElementsByTagName(s)[0];
	     if (d.getElementById(id)) {return;}
	     js = d.createElement(s); js.id = id;
	     js.src = "//connect.facebook.net/en_US/sdk.js";
	     fjs.parentNode.insertBefore(js, fjs);
	   }(document, 'script', 'facebook-jssdk'));
	</script>
	
	
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>


<button><a href="https://www.facebook.com/dialog/oauth?client_id=${clientId}&redirect_uri=${redirectUrl}&scope=email,
																												user_birthday,
																												user_education_history,
																												user_hometown,
																												user_location,
																												user_work_history">Log in with Facebook</a></button>


<div
  class="fb-like"
  data-share="true"
  data-width="450"
  data-show-faces="true">
</div>
</body>
</html>
