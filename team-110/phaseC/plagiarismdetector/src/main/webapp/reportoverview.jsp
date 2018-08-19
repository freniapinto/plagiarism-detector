<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<div class="logoheader">
  <img src="${contextPath}/resources/img/logo2.png" alt="logo" />
</div>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Report Overview</title>
<link rel = "stylesheet" type="text/css" href="style.css">
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="bgimage">
<h1 align="center">Plagiarism Content Overview</h1>
<br><br>
<h2 align="left">Plagiarism Bar graph</h2>

  <div class="stack-horz">
        <div class="content" style="width: 450px; height: 100%; background-color: #E61D1D;overflow: auto">
		<table class="repodisp" style="margin-top:40px"> 
      <c:forEach  items="${highplag}" var ="highplag">
      <tr class="repodisp">
       <td class="repodisp" style="color:#000">${highplag.key}</td>      
       <td class="repodisp" style="color:#000">${highplag.value}</td>      
       </tr>
       <span style="margin-left:100px;font-size:17px;color:yellow">${error}</span>
       </c:forEach>
       </table>
		
		</div>
        <div class="content" style="width: 450px; height: 100%; background-color: #E6811D; overflow: auto">
        <table class="repodisp" style="margin-top:40px"> 
      <c:forEach  items="${medplag}" var ="medplag">
      <tr class="repodisp">
       <td class="repodisp" style="color:#000">${medplag.key}</td>      
       <td class="repodisp" style="color:#000">${medplag.value}</td>      
       </tr>
       <span style="margin-left:100px;font-size:17px;color:yellow">${error}</span>
       </c:forEach>
       </table>
        </div>
        <div class="content" style="width: 450px; height: 100%; background-color: #54920E; overflow: auto">
        <table class="repodisp" style="margin-top:40px"> 
      <c:forEach  items="${lowplag}" var ="lowplag">
      <tr class="repodisp">
       <td class="repodisp" style="color:#000">${lowplag.key}</td>      
       <td class="repodisp" style="color:#000">${lowplag.value}</td>      
       </tr>
       <span style="margin-left:100px;font-size:17px;color:yellow">${error}</span>
       </c:forEach>
       </table>
        </div> <br><br><br>
<ul class="legend">
    <li><span class="highplag"></span> High Plagiarism content</li>&emsp;&emsp;
    <li><span class="medplag"></span> Medium Plagiarism content</li>&emsp;&emsp;
    <li><span class="lowplag"></span> Low Plagiarism content</li>&emsp;&emsp;
    <li style="float:right;"> <form:form method="GET" modelAttribute="welcome" action="/welcome">
        <button class="btn btn-lg btn-primary btn-block-back" type="submit" style="float: right;" onclick="/welcome.jsp">Go Back to Homepage</button>
      </form:form></li>
     <li style="float:right;"> <form:form method="POST" modelAttribute="reportoverview" action="/reportoverview">
        <button class="btn btn-lg btn-primary btn-block-back" type="submit" style="float: right;" >View Detailed Report</button>
      </form:form> </li>
</ul><br><br>
    </div> 
    </div>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>