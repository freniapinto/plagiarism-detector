<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Detailed Report</title>
</head>
<body>
<h1 align="center"> DETAILED REPORT</h1>


<c:forEach  items="${commonSub}" var ="commonSub">
<div id="text1" style="font-family:Courier New;font-weight:bold;margin-top:40px;margin-left: 150px;float:left; width: 600px; height: 600px; background-color: lightblue;overflow: auto">

${commonSub.key}
</div>
<div id="text2" style="font-family:Courier New;font-weight:bold;margin-top:40px;margin-left: 30px;float:left; width: 600px; height: 600px; background-color: lightblue;overflow: auto">
${commonSub.value}
</div>
</c:forEach>
<div id="text1" style="font-family:Courier New;font-weight:bold;margin-top:40px;margin-left: 500px;float:left; width: 500px; height: 200px; background-color: lightblue;overflow: auto">
<table class="repodisp" style="margin-top:40px"> 
        <thead>
      <tr>
        <th style="background-color:#fff">Strategy Used</th>
        
      </tr>
    </thead>
      
      
      <tr class="repodisp">
       <td class="repodisp" style="color:#000">LCS</td> <td></td> <td></td>    
       <td class="repodisp" style="color:#000">${lcs}</td> 
       
       </tr>
       <tr class="repodisp">
       <td class="repodisp" style="color:#000">Cosine Similarity</td>  <td></td>  <td></td>  
       <td class="repodisp" style="color:#000">${cosine}</td> 
       
       </tr>
       
       <tr class="repodisp">
       <td class="repodisp" style="color:#000">Edit Distance</td>   <td></td>  <td></td>
       <td class="repodisp" style="color:#000">${edit}</td> 
       
       </tr>
       
       <tr class="repodisp">
       <td class="repodisp" style="color:#000">Weighted Average</td> <td></td> <td></td>   
       <td class="repodisp" style="color:#000">${total}</td> 
       
       </tr>
       <tr>
       <td>
       <form:form method="GET" modelAttribute="welcome" action="/welcome">
        <button class="btn btn-lg btn-primary btn-block-back" type="submit" style="float: right;">Go Back to Homepage</button>
      </form:form>
       </td>
       <td></td>
       <td>
       <form:form method="POST" modelAttribute="statistics" action="/statistics">
        <button class="btn btn-lg btn-primary btn-block-back" type="submit" style="float: right;" >View Usage Stats</button>
      </form:form>
       </td>
       </tr>
       </table>
</div>


</body>

<style type="text/css">
    .highlight {color:red;background-color:yellow}
</style>
<script>
var t1 = $("#text1").html();
$('#text1').each(function(){
t1 = t1.replace(/\/\/.*\/\//g, "<span class='highlight'>$&</span>");
t1 = t1.replace(/\/\//g, "");
$("#text1").html(t1);
});

var t2 = $("#text2").html();
$('#text2').each(function(){
	t2 = t2.replace(/\/\/.*\/\//g, "<span class='highlight'>$&</span>");
	t2 = t2.replace(/\/\//g, "");
	$("#text2").html(t2);
	});
</script>
</html>