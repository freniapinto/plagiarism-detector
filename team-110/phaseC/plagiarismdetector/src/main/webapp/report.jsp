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

    <title>Report Overview</title>
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

  <li class="top-pane"><a href="/welcome">Clone Student Repository</a></li>
  <li class="top-pane"><a class="active-pane" href="/report">Report</a></li>

 <li class="top-pane"><a href="/statistics">Usage Stats</a>
  <li class="top-pane"><a href="aboutus.jsp">About Us</a></li>
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
      <div class="panel-heading" style="color:#ffff00">Detailed Report</div>
      <div class="panel-body"> 
      
 <div class="wrapper center-block">
  <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
  <div class="panel panel-default">
    <div class="panel-heading active" style="background-color:#000;color:#fff" role="tab" id="headingOne">
      <h4 class="panel-title">
        <a role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
          04/01/2018
        </a>
      </h4>
    </div>
    <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
      <div class="panel-body">
        <table class="report" id="reportListhigh" style="margin-top:40px"> 
        <thead>
      <tr>
        <th style="background-color:#fff">High Plagiarism</th>
        
      </tr>
    </thead>
      <c:forEach  items="${highplag}" var ="highplag">
      
      <tr class="report">
       <td class="report" style="color:#000">${highplag.key}</td>      
       <td class="report" style="color:#000">${highplag.value}</td> 
       
       </tr>
       <span style="margin-left:100px;font-size:17px;color:yellow">${error}</span>
       
       </c:forEach>
       </table>
       
       <table class="report" id="reportListmed" style="margin-top:40px"> 
        <thead>
      <tr>
        <th style="background-color:#fff">Medium Plagiarism</th>
        
      </tr>
    </thead>
      <c:forEach  items="${medplag}" var ="medplag">
      <tr class="report">
       <td class="report" style="color:#000">${medplag.key}</td>      
       <td class="report" style="color:#000">${medplag.value}</td>       
       </tr>
       <span style="margin-left:100px;font-size:17px;color:yellow">${error}</span>
       </c:forEach>
       </table>
        
        <table class="report" id="reportListlow" style="margin-top:40px"> 
        <thead>
      <tr>
        <th style="background-color:#fff">Low Plagiarism</th>
        
      </tr>
    </thead>
      <c:forEach  items="${lowplag}" var ="lowplag">
      <tr class="report">
       <td class="report" style="color:#000">${lowplag.key}</td>      
       <td class="report" style="color:#000">${lowplag.value}</td> 
      </tr>
       <span style="margin-left:100px;font-size:17px;color:yellow">${error}</span>
       </c:forEach>
       </table>
        
      </div>
      
    </div>
	
  </div><br><br>
      <form:form method="POST" modelAttribute="/report" id="file-form" name="file-form" action="/report">
       <td><input type="text" id="file1" name="file1" /></td>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp;
		<td><input type="text" id="file2" name="file2"/> </td>
       <td> <button class="btn btn-lg btn-primary btn-block-back" type="submit" style="float: right;" onclick="/welcome.jsp">View Detailed Report</button></td>    
      </form:form>
</div>
</div>
</div> 

</div>
 </div>
 </div>

<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/sample.js"></script>
<script src="${contextPath}/resources/js/collapse.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
