<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<script>
window.onload = function () {

var chart = new CanvasJS.Chart("chartContainer", {
  animationEnabled: true,
  theme: "light2",
  title:{
    text: "Simple Line Chart"
  },
  axisY:{
    includeZero: false
  },
  data: [
        {
            type: "line",
            dataPoints: ${mUserStats},
        }
        ]
});
chart.render();


}
</script>
<body>
<center><H1>User Statistics</H1>
<div id="chartContainer" style="height: 370px; width: 50%;"></div></center>
<center>
<table class="report" id="reportListmed" style="margin-top:40px"> 
        <thead>
      <tr>
        <th style="background-color:#fff">Legend for Date against X-axis</th>
        
      </tr>
    </thead>
      <c:forEach  items="${mLegends}" var ="mLegends">
      <tr class="report">
       <td class="report" style="color:#000">${mLegends.key}</td>      
       <td class="report" style="color:#000">${mLegends.value}</td>       
       </tr>
       <span style="margin-left:100px;font-size:17px;color:yellow">${error}</span>
       </c:forEach>
       </table></center>
<div> <form:form method="GET" modelAttribute="welcome" action="/welcome">
        <button class="btn btn-lg btn-primary btn-block-back" type="submit" style="float: right;">Go Back to Homepage</button>
      </form:form></div>
<script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/sample.js"></script>
<script src="${contextPath}/resources/js/collapse.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

</body>
</html>
