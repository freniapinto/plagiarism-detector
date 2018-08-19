<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<div class="logoheader">
  <img src="${contextPath}/resources/img/logo2.png" alt="logo" />
</div>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">

    <title>GIT HUB LINK</title>
    <link rel = "stylesheet" type="text/css" href="style.css">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="bgimage">
<div class="container">
	
			<div class="top-pane">
<ul class="top-pane">
  <li class="top-pane"><a class="active-pane" href="/welcome">Clone Student Repository</a></li>

  <li class="top-pane"><a href="/report">Report</a></li>

  <li class="top-pane"><a href="/statistics">Usage Stats</a>
  <li class="top-pane"><a href="aboutus.jsp">About Us</a></li>
</ul>
			</div>
	
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

        <h2 class="welcome">Welcome ${pageContext.request.userPrincipal.name} | <a class="logout" onclick="document.forms['logoutForm'].submit()">Logout</a></h2>

    </c:if>
    
<div class="gitlink">
        <form:form method="POST" modelAttribute="welcome" class="form-signin" >
              <h2 class="form-heading-clone">Git Clone User</h2>

              <div class="form-group ${error != null ? 'has-error' : ''}">
                  <span>${message}</span>
                  <input type="text" name="gitlink" class="form-control-clone" placeholder="Git User here..."
                         autofocus="true"/> 
                  <span style="margin-left:100px;font-size:17px;color:yellow">${error}</span>
              </div>
 <button class="btn btn-lg btn-primary btn-block-clone" type="submit">Clone Repository</button>
          </form:form>
</div>
</div>
</div>


<!-- /container -->
<!-- /gitlink -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
