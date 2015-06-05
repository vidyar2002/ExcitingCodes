<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en"  ng-app="cms">
  <head >
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <title>Contact Management System</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
     
    <!-- Bootstrap CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet"> 
    
    <!-- Font Awesome -->
    <link href="css/font-awesome.min.css" rel="stylesheet">
    
    
    
    <!-- Theme style -->
    <link href="css/theme-style.min.css" rel="stylesheet">
    
    <!--Your custom colour override-->
    <link href="#" id="colour-scheme" rel="stylesheet">
    
    <!-- Your custom override --> 
    <link href="css/custom-style.css" rel="stylesheet">
    
   
    
    <!-- Le fav and touch icons - @todo: fill with your icons or remove -->
    <link rel="shortcut icon" href="img/icons/favicon.png">
    <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/icons/114x114.png">
    <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/icons/72x72.png">
    <link rel="apple-touch-icon-precomposed" href="img/icons/default.png">
    
      
	<!--Scripts -->
	<script src="js/jquery.min.js"></script>
	
	<!--Custom scripts mainly used to trigger libraries/plugins -->
	<script src="js/script.min.js"></script>
	<script src="lib/angular/angular.min.js"></script>
	<script src="lib/angular/angular-resource.js"></script>
	<script src="lib/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<script src="lib/angular-ui/0.11.2/ui-bootstrap-tpls-0.11.2.min.js"></script>
	<script src="js/app.js"></script>
	<script src="js/services/restServices.js"></script>
	<script src="js/controllers/signupController.js"></script>  
	<script src="js/controllers/loginController.js"></script>
	<script src="js/controllers/contactController.js"></script>
  </head>
  
   <!-- ======== @Region: body ======== -->
  <body class="page page-signup">  
  <!-- ======== @Region: navigation ======== --> 
	<div id="navigation" class="wrapper"> 
	   <jsp:include page="navigation.jsp"/>
	</div>
<!-- ======== @Region: #content ======== -->
<div id="content">
  <jsp:include page="${contentUrl}"/> 
  <input type="hidden" id="userToken" name="userToken" value="${userToken}"/>
</div>  

<!-- ======== @Region: #content-below ======== -->
<div id="content-below" class="wrapper">

</div>

</body>
</html>