<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>About Us</title>
    <link rel = "stylesheet" type="text/css" href="style.css">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>

<div class="container">
	
			<div class="top-pane">
<ul class="top-pane">
  <li class="top-pane"><a href="/welcome">Clone Student Repository</a></li>
  <li class="top-pane"><a href="#report">Report</a></li>
  <li class="top-pane"><a href="/statistics">Usage Stats</a>
  <li class="top-pane"><a class="active-pane" href="aboutus.jsp">About Us</a></li>
</ul>
			</div>
	
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>
    </c:if>
    <h2 class="welcome"> <a class="logout" onclick="document.forms['logoutForm'].submit()">Logout</a></h2>
</div>
<div class="panel-group">
    
    <div class="panel panel-default">
      <div class="panel-heading" style="color:#fff">About Us</div>
      <div class="panel-body"> 

		<img src="${contextPath}/resources/img/neulogo.png" alt="neulogo" width="500" height="80">
		<br><br><br><br>
		<p style="font-family:Courier;font-weight=bold;font-size:30px;color:#FF0000">
		Contributors for this project:
		</p>
		<ul>
		<li style="font-size:20px;font-weight:bold"> Frenia Pinto</li>
		<li style="font-size:20px;font-weight:bold"> Vaibhav Shukla</li>
		<li style="font-size:20px;font-weight:bold"	> Vaibhav Rangarajan</li>
		</ul>
		<br>
		<p style="font-family:FreeMono;font-size:20px">
		We are Northeastern University graduate students currently pursuing our Masters in Computer Science.
		</p>
		<p style="font-family:FreeMono;font-size:20px">
		We have developed this project as part of our course work for subject CS5500-Managing Software Development
		<br>
		 under Professor Michael Weintraub.
		</p>
      </div>
      
    </div>
</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
