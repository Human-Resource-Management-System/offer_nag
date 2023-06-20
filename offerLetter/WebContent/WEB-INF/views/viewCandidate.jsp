<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="java.time.LocalDate" %>
<%@page import="com.nkxgen.spring.orm.model.Candidate" %>
<%@page import="com.nkxgen.spring.orm.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <style>
    body {
      font-family: Arial, sans-serif;
      margin: 20px;
    }

    h1 {
      font-size: 24px;
      margin-bottom: 10px;
    }

    .form-group {
      margin-bottom: 20px;
    }

    .form-group label {
      font-weight: bold;
      display: block;
    }

    .form-group input[type="text"],
    .form-group input[type="email"] {
      width: 300px;
      padding: 5px;
      border: 1px solid #ddd;
    }

    .form-group input[type="text"][readonly],
    .form-group input[type="email"][readonly] {
      background-color: #f5f5f5;
    }

    .form-group input[type="file"] {
      margin-top: 5px;
    }

    #components-container {
      margin-top: 20px;
    }

    .component {
      border: 1px solid #ddd;
      padding: 10px;
      margin-bottom: 10px;
    }

    .component label {
      display: block;
      margin-bottom: 5px;
    }

    .component select {
      width: 300px;
      padding: 5px;
    }

    .add-component-button {
      margin-top: 10px;
      font-size: 14px;
    }

    .create-button {
      margin-top: 20px;
      font-size: 16px;
      padding: 10px 20px;
      display: block;
    }
  </style>
</head>
<body>


<form action="email" method="POST" >

  <h1>New Offer Letter</h1>
           <%  Candidate candidate = (Candidate)request.getAttribute("candidate"); %> 
           <%  Employee hr = (Employee)request.getAttribute("hr"); %> 
           <%  List <String> listOfDocuments =(List<String>) request.getAttribute("listOfDocuments"); %> 

   <div class="form-group">
    <label for="candidate-name">Candidate Name:</label>
<input type="text" id="candidateName" name="candidateName" value="<%= candidate.getCand_firstname() + candidate.getCand_lastname() %>" readonly>
  </div>
  
<div class="form-group">
    <label for="hr-mobile">Admin Mobile:</label>
    <input type="text" id="adminMobile" name="adminMobile" value="<%= hr.getEmpl_mobile()%>" readonly>
  </div>

  <div class="form-group">
    <label for="hr-email">Admin Email:</label>
    <input type="email" id="adminEmail" name="adminEmail" value="<%= hr.getEmpl_offemail() %>"readonly>
  </div>

  <div class="form-group">
    <label for="offer-date">Offer Date:</label>
    <input type="text" id="offerDate" name="offerDate" value="<%= LocalDate.now().toString() %>" readonly>
  </div>

  <div class="form-group">
    <label for="offered-job">Offered Job:</label>
    <input type="text" id="offeredJob" name="offeredJob">
  </div>

  <div class="form-group">
    <label for="reporting-date">Reporting Date:</label>
    <input type="date" id="reportingDate" name="reportingDate">
  </div>

  

 

  <div id="components-container">
    <!-- Components will be dynamically added here -->
  </div>

<button class="add-component-button" onclick="addComponent(); event.preventDefault()">Add Component</button>
  <br>
  



  <button class="create-button" onclick="displaySelectedOptions()">Create</button>
</form>
  <script>
    let componentCount = 0;

    function addComponent() {
      const componentsContainer = document.getElementById('components-container');
      componentCount++;

      const component = document.createElement('div');
      component.className = 'component';
      component.innerHTML = `
        <label for="component-input-${componentCount}"></label>
        <label for="documents">Document:</label>
        <select id="documents" name="documents">
            <c:forEach var="document" items="${listOfDocuments}">
                <c:if test="${document != 'offer letter'}">
                    <option value="${document}">${document}</option>
                </c:if>
            </c:forEach>
        </select>
      `;
      componentsContainer.appendChild(component);
    }

   
  </script>
</body>
</html>
