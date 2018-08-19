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

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="bgimage">
<div class="container">

    <form:form name="myform" method="POST" modelAttribute="userForm" class="form-signin" onsubmit="return(validate());">
        <h2 class="form-signin-heading">Create your account</h2>
        <span>${error}</span>
        <spring:bind path="username">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="text" path="username" class="form-control" name="username" placeholder="Username"
                            autofocus="true"></form:input>
                <form:errors path="username"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="password">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="password" class="form-control" name="password" placeholder="Password"></form:input>
                <form:errors path="password"></form:errors>
            </div>
        </spring:bind>

        <spring:bind path="passwordConfirm">
            <div class="form-group ${status.error ? 'has-error' : ''}">
                <form:input type="password" path="passwordConfirm" class="form-control"
                            name= "passwordConfirm" placeholder="Confirm your password"></form:input>
                <form:errors path="passwordConfirm"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="emailAddress">
            <div class="form-group ${status.error ? 'has-error' : ''}">

                <form:input type="text" path="emailAddress" class="form-control" name="emailAddress" placeholder="Email-address"

                            autofocus="true"></form:input>
                <form:errors path="emailAddress"></form:errors>
            </div>
        </spring:bind>
        
        <spring:bind path="position">
            <div class="form-group ${status.error ? 'has-error' : ''}">

                <input type="radio" name="strategy" value="Instructor"> Instructor &emsp;
       <input type="radio" name="strategy" value="TA" checked> TA

                <form:errors path="position"></form:errors>
            </div>
        </spring:bind>
        
        
        

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
        
    </form:form>
</div>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>

<script type="text/javascript">
   <!--
      // Form validation code will come here.
      function validate()
      {
      
         if( document.myform.username.value == "" )
         {
            alert( "Please provide your name!" );
            //document.myForm.Name.focus() ;
            return false;
         }
         if(document.myform.password.value.length<6){  
       	  alert("Password must be at least 6 characters long.");  
       	  return false;  
       	  }  
         if(document.myform.password.value!=document.myform.passwordConfirm.value){  
        	 alert("Passwords does not match!");   
        	 return false;
        	 }
        
         if( document.myform.emailAddress.value == "" )
         {
            alert( "Please provide your Email!" );
            //document.myform.EMail.focus() ;
            return false;
         }
        
         atpos = document.myform.emailAddress.value.indexOf("@");
         dotpos = document.myform.emailAddress.value.lastIndexOf(".");
         
         if (atpos < 1 || ( dotpos - atpos < 2 )) 
         {
            alert("Please enter correct email ID")
            //document.myform.emailAddress.value.focus() ;
            return false;
         }
                  
      }
   
   
 </script>
</body>
</html>