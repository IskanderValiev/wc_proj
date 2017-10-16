<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 9/30/17
  Time: 11:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Matches</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style>
        #group-a {
            margin: 0px 10px 0px 20px;
            float: left;
            text-align: center;
            border-collapse: collapse;
        }

        #group-b {
            margin: 0px 10px 0px 10px;
            float: left;
            text-align: center;
            border-collapse: collapse;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="header">
        <div id="menu">
            <ul class="menu">
                <li><a href="/worldcup/homepage.jsp">Homepage</a></li>
                <li><a href="/worldcup/matches.jsp">Matches</a>
                    <ul>
                        <li><a href="#">Group A</a></li>
                        <li><a href="#">Group B</a></li>
                        <li><a href="#">Group C</a></li>
                        <li><a href="#">Group D</a></li>
                        <li><a href="#">Group E</a></li>
                        <li><a href="#">Group F</a></li>
                        <li><a href="#">Group G</a></li>
                        <li><a href="#">Group H</a></li>
                    </ul>
                </li>
                <li><a href="/worldcup/cities.jsp">Cities</a>
                    <ul>
                        <li><a href="#">Kazan</a></li>
                        <li><a href="#">Moscow</a></li>
                        <li><a href="#">St. Petersburg</a></li>
                        <li><a href="#">Sochi</a></li>
                        <li><a href="#">Kaliningrad</a></li>
                        <li><a href="#">Saransk</a></li>
                        <li><a href="#">Nizhniy Novgorod</a></li>
                        <li><a href="#">Rostov-On-Don</a></li>
                        <li><a href="#">Volgograd</a></li>
                        <li><a href="#">Ekaterinburg</a></li>
                        <li><a href="#">Samara</a></li>
                    </ul>
                </li>
                <li><a href="#">Stadiums</a></li>
                <li><a href="/teams">Teams</a></li>
                <li><a href="/worldcup/galary.jsp">Galary</a></li>
                <li><a href="/worldcup/contact.jsp">Contacts</a></li>
            </ul>
        </div>
        <div id="profile-menu">
            <ul class="profile-menu">
                <li><a href="/profile">Profile</a></li>
                <li><a href="/exit">Exit</a></li>
            </ul>
        </div>
    </div>
    <hr>
    <div id="content">
        <div id="group-a">
            <table border="2" cellpadding="4" cellspacing="0">
                <tr>
                    <td colspan="2">Group A</td>
                </tr>
                <tr>
                    <td>"Luzhniki", Moscow, 14/06/2018</td>
                    <td>A1 vs A2</td>
                </tr>
                <tr>
                    <td>Ekaterinburg, 15/06/2018</td>
                    <td>A3 vs A4</td>
                </tr>
                <tr>
                    <td>St. Petersburg, 19/06/2018</td>
                    <td>A1 vs A3</td>
                </tr>
                <tr>
                    <td>Rostov-On-Don, 20/06/2018</td>
                    <td>A2 vs A4</td>
                </tr>
            </table>
        </div>
        <div id="group-b">
            <table border="2" cellpadding="4" cellspacing="0">
                <tr>
                    <td colspan="2">Group B</td>
                </tr>
            </table>
        </div>
    </div>
    <div id="footer">
        <img src="images/system/sponsors.png">
    </div>
</div>
</body>
</html>
