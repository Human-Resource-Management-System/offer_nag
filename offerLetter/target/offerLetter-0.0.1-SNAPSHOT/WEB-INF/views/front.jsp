
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ page import="models.Candidate" %>
<%@ page import="java.util.List" %>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>List of Candidates</title>
    <style>
        h2 {
            margin-top: 20px;
        }

        table {
            margin: 0 auto;
            border-collapse: collapse;
            background-color: #fff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);
        }

        th, td {
            padding: 10px;
        }

        th {
            background-color: #333;
            color: #fff;
            font-weight: bold;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #ddd;
        }

        #filterInput {
            width: 100%;
            padding: 10px;
            font-size: 16px;
            border-radius: 5px;
            border: 1px solid #ccc;
            margin-bottom: 10px;
        }

        #tableContainer {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <div id="tableContainer">
        <input type="text" id="filterInput" placeholder="Search...">

        <table id="dataTable">
            <thead>
                <tr>
                    <th>Candidate ID</th>
                    <th>Candidate First Name</th>
                    <th>Candidate Last Name</th>
                    <th>Candidate Register Date</th>
                    <th>Candidate Status</th>
                    <th>View Candidate</th>
               
                </tr>
            </thead>
            <tbody>
                <%
                List<Candidate> candidates = (List<Candidate>) request.getAttribute("candidates");
                if (candidates != null) {
                    for (Candidate candidate : candidates) { %>
                        <tr>
                            <td><%= candidate.getCand_id() %></td>
                            <td><%= candidate.getCand_firstname()%></td>
                            <td><%= candidate.getCand_lastname() %></td>
                            <td><%= candidate.getCand_rdate() %></td>
                            <td><%= candidate.getCand_status() %></td>
            				<td><a href="#"> View</a></td>
                        </tr>
                    <% }
                } %>
            </tbody>
        </table>
    </div>

    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
    <script>
        $(document).ready(function () {
            $("#filterInput").on("keyup", function () {
                var value = $(this).val().toLowerCase();
                $("#dataTable tbody tr").filter(function () {
                    $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1);
                });
            });
        });
    </script>
</body>
</html>

