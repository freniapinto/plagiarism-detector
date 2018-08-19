<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

    <title>Cloned repo</title>
    <link rel = "stylesheet" type="text/css" href="style.css">
	<script src="jquery.js" type="text/javascript"></script>
    <script src="${contextPath}/resources/js/progress.js" type="text/javascript"></script>
    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<div class="bgimage">
<div class='progress' id="progress_div">
    <div class='bar' id='bar1'></div>
    <div class='percent' id='percent1'></div>
  </div>
    
  <input type="hidden" id="progress_width" value="0">
<div class="container">
	<div class="top-pane">
			<ul class="top-pane">
  <li class="top-pane"><a class="active-pane" href="/welcome">Clone Student Repository</a></li>
  <li class="top-pane"><a href="/reportoverview">Report</a></li>
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
      <div class="panel-heading" style="color:#fff">Cloned Repositories</div>
      <div class="panel-body"> 
<form:form method="POST" commandName="result" action="/result">

         <div class="select">
    <select name="HWfilter"  id="slct">
    <c:forEach  items="${folderfilterlist}" var ="folder">
      <option value="${folder}" >${folder}</option>
      </c:forEach>
    </select>
   
  </div> 
       <div style="margin-left:350px"> <input type="submit" class="button-filter" value="Filter Homework"> </div>
 </form:form>
 <form:form method="POST" modelAttribute="/repodisp" class="form-signin" action="/repodisp">
 <input type="radio" name="strategy" title="Longest Common Subsequence. A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous" value="LCS"> LCS
  	   <input type="radio" name="strategy" title="Cosine similarity. For text matching, the attribute vectors are usually the term frequency vectors of the documents" value="Cosine"> Cosine Similarity
       <input type="radio" name="strategy" title="Edit distance is a way of quantifying how dissimilar two strings (e.g., words) are to one another by counting the minimum number of operations required to transform one string into the other." value="Edit"> Edit Distance
       <input type="radio" name="strategy" value="All" checked> All
  <table class="repodisp" style="margin-top:40px">  
    
    <c:forEach  items="${clientDispList}" var ="gitrepo">
    <tr class="repodisp">
    
      <td class="repodisp">${gitrepo}</td>
      
    </tr>
    </c:forEach>
  </table>
       <button class="btn btn-lg btn-primary btn-block-clone" type="submit">Run Plagiarism detector</button>
          </form:form>
</div>
       
      </div>
      
    </div>
	
</div>


<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
