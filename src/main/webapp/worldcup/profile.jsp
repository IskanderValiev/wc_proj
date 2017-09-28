<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 9/24/17
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String login = request.getParameter("login");
    String name = request.getParameter("name") + " " + request.getParameter("lname");
    String city = request.getParameter("city");
    String gender = request.getParameter("gender");
    String email = request.getParameter("email");
    String bday = request.getParameter("bday") + " " + request.getParameter("bmon") + " " + request.getParameter("byear");
%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="worldcup/style.css">
    <style type="text/css">
        .information {
            background: clear;
            font-size: 25px;
            float: left;
            width: 60%;
        }

        .image {
            background: #CCCC99;
            float: left;
            width: 250px;
            height: 250px;
            margin: 0px 50px 0px 50px;
        }

        .image img {
            margin: 25px 25px 25px 25px;
        }

        .info {
            text-align: left;
            width: 100%;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="header">
        <span style="vertical-align: -22px">Profile</span>
        <table class="userlogin">
            <tr>
                <td>Welcome, <%=login%></td>
            </tr>
        </table>
    </div>
    <hr>

    <div id="navigation">
        <table>
            <tr>
                <td><u>Menu:</u></td>
            </tr>
            <tr>
                <td><a href="authorization.html">Profile</a></td>
            </tr>
            <tr>
                <td><a href="homepage.html">Homepage</a></td>
            </tr>
            <tr>
                <td><a href="matches.html">Matches</a></td>
            </tr>
            <tr>
                <td><a href="cities.html">Cities</a></td>
            </tr>
            <tr>
                <td><a href="staduims.html">Stadiums</a></td>
            </tr>
            <tr>
                <td><a href=#>Galary</a></td>
            </tr>
            <tr>
                <td><a href=#>Contacts</a></td>
            </tr>
        </table>
    </div>

    <div id="content">
        <div class="image">
            <img src="worldcup/images/system/null.jpg" width="200" height="200">
            <a href=""></a>
        </div>

        <div class="information">
            <table class="info">
                <tr>
                    <td><label><%=name%></label></td>
                </tr>
                <tr>
                    <td><hr></td>
                </tr>
                <tr>
                    <td><label>Bday: <%=bday%></label></td>
                </tr>
                <tr>
                    <td><label>City: <%=city%></label></td>
                </tr>
                <tr>
                    <td><label>Gender: <%=gender%></label></td>
                </tr>
                <tr>
                    <td><label>E-mail: <%=email%></label></td>
                </tr>
                <tr>
                    <td><label>Instagram:</label></td>
                </tr>
            </table>
        </div>
    </div>

    <div id="footer">
        <img src="worldcup/images/system/sponsors.png">
    </div>
</div>
</body>
</html>