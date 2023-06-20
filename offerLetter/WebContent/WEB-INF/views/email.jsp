<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="com.nkxgen.spring.orm.model.Candidate" %>
<%@page import="com.nkxgen.spring.orm.model.OfferModel" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Offer Letter</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 30px;
        }
        
        h1 {
            text-align: center;
            margin-bottom: 20px;
        }
        
        p {
            margin-bottom: 10px;
        }
        
        ul {
            list-style-type: disc;
            margin-left: 20px;
        }
        
        .button-container {
            text-align: center;
            margin-top: 20px;
        }
        
        .send-button {
            padding: 10px 20px;
            background-color: #4CAF50;
            color: white;
            border: none;
            cursor: pointer;
            font-size: 16px;
            border-radius: 4px;
        }
    </style>
</head>
<body>
    <% OfferModel offerModel = (OfferModel) request.getAttribute("offerModel"); %>

    <h1>Offer Letter</h1>
    <p>Dear <%= offerModel.getCandidateName() %>,</p>
    
    <p>We are pleased to offer you employment for the position of "Associate Software Engineer Trainee" at Pennant Technologies Pvt. Ltd. As part of the offer, you have to undergo Pre-Employment Internship from 1st February 2023 for a period of 5 months and during the Pre-Employment Internship period, you will undergo training across the technical, functional and product framework domains. During the training period you will be entitled for a stipend of Rs.12,000/-pm for the period of 5 months and on successful completion of your training and the performance during the assessment determine your allocation to the compensation packages of either 4.1 lpa or 5.1 lpa for the first year of your employment and then you will have annual pay increases in line with the three year pay structure and based on the annual performance ratings.</p>
    
    <p>This offer is subjected to the conditions and commitment that you will undergo Internship and join us as a full-time employee without fail. This offer requires you to sign a service agreement that is effective from the internship date and the assured/committed duration of 3 years that will be effective from your date of joining as a full-time employee.</p>
    
    <p>Please note that your compensation package would be as outlined in Annexure A attached here under and the few of the preparatory actions outlined in Annexure A.</p>
    
    <p>You will receive a formal letter of appointment (on probation basis) with all the terms and conditions post joining the organization. For any questions or clarifications regarding this offer, please contact the HR Team at <%= offerModel.getAdminEmail() %> or on office number <%= offerModel.getAdminMobile() %>.</p>
    
    <p>I hope you will accept this offer of internship to employment, thereby allowing me to welcome you as an associate of our Company.</p>
    
    <p>With best wishes and looking forward to a mutually fruitful association,</p>
    
    <p>For Pennant Technologies Pvt. Ltd.</p>
    
    <p>Ravi Varma Datla</p>
    <p>Director, Consulting</p>
    
    <h2>Details:</h2>
    <p>HR Mobile Number: <%= offerModel.getAdminMobile() %></p>
    <p>HR Email: <%= offerModel.getAdminEmail() %></p>
    <p>Offer Date: <%= offerModel.getOfferDate() %></p>
    <p>Offered Job: <%= offerModel.getOfferedJob() %></p>
    <p>Reporting Date: <%= offerModel.getReportingDate() %></p>
    <p>Documents to Bring While Coming:</p>
    <ul>
        <c:forEach var="document" items="${offerModel.getDocuments()}">
            <li>${document}</li>
        </c:forEach>
    </ul>
    
    
    
    
  <div class="button-container">
    <form id="sendOfferForm" action="sendOfferLetter" method="post">

        <button id="sendOfferButton" class="send-button" type="submit">Send Offer Letter via Email</button>
    </form>
</div>




    
    
    
</body>
</html>
