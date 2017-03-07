<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>   
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">


<input type="Submit" value="Add" style="color:white;background-color:red;float:right;margin:20px;margin-right:200px;">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP List Users Records</title>
</head>
<body>

     
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>Equipment Registration</h2></caption>
            <tr>
                <TH>SNO</TH>
               <TH>Equipment_Name</TH>
               <TH>Description</TH>
               <TH>RegNo</TH>
               	
            </tr>
           <form action="/QRCode" method="Get" >
            <c:forEach var="users" items="${userLists}">
                <tr>
                    <td id ="test"><c:out value="${users.SNO}" /></td>
                    <td><c:out value="${users.equipment_Name}" /></td>
                    
                    <td><c:out value="${users.description}" /></td>
                  	<td><c:out value="${users.regNO}" /></td>
                  	 
                  <td><input type="button" value="Submit"  onclick="submitter(form)" /></td>
                </tr>
            </c:forEach>
            </form>
        </table>
    </div>
    </body>
    <script>
    function submitter(test){
    	
    	/* var s = $( "#test").val();
    	alert(s);
    	alert(test); */
    	var qrcode = new QRCode("qrcode");

    	function makeCode () {      
    	    var elText = document.getElementById("text");
    	    
    	    if (!elText.value) {
    	        alert("Input a text");
    	        elText.focus();
    	        return;
    	    }
    	    
    	    qrcode.makeCode(elText.value);
    	}

    	makeCode();

    	$("#text").
    	    on("blur", function () {
    	        makeCode();
    	    }).
    	    on("keydown", function (e) {
    	        if (e.keyCode == 13) {
    	            makeCode();
    	        }
    	    });
    }
    </script>
    </html>