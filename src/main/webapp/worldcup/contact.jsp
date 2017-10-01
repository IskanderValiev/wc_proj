<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 9/30/17
  Time: 10:55 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Contacts</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <style type="text/css">
        #content {
            position: relative;
        }

        #location {
            background: rgba(255, 255, 255, .9);
            float: right;
            margin: 0px 80px 0px 0px;
            text-align: center;
            position: relative;
            width: 400px;
            height: 350px;
        }

        #location iframe {
            margin: 25px;
        }

        #contact-info {
            text-align: left;
            float: left;
        }

        #contact-info a {
            color: #CCCC99;
            text-decoration: none;
        }

        #contact-info a:hover {
            color: #FFFFFF;
        }
    </style>
</head>
<body>
<div id="container">
    <div id="header">
        <span style="vertical-align: -22px">Contacts</span>
    </div>
    <hr>
    <div id="navigation">
        <table>
            <tr>
                <td><u>Menu:</u></td>
            </tr>
            <tr>
                <td><a href="/worldcup/profile.jsp">Profile</a></td>
            </tr>
            <tr>
                <td><a href="/worldcup/homepage.jsp">Homepage</a></td>
            </tr>
            <tr>
                <td><a href="/worldcup/matches.jsp">Matches</a></td>
            </tr>
            <tr>
                <td><a href="/worldcup/cities.jsp">Cities</a></td>
            </tr>
            <tr>
                <td><a href="staduims.html">Stadiums</a></td>
            </tr>
            <tr>
                <td><a href=#>Galary</a></td>
            </tr>
            <tr>
                <td><a href="/worldcup/contact.jsp">Contacts</a></td>
            </tr>
            <tr>
                <td><a href="/worldcup/authorization.html">Exit</a></td>
            </tr>
        </table>
    </div>

    <div id="content">
        <div id="location">
            <iframe src="https://yandex.ru/map-widget/v1/-/CBUoEJXRoB" width="350" height="300" frameborder="0"></iframe>
        </div>
        <div id="contact-info">
            World Cup Project<br>
            Kremlyovskaya street, 35<br>
            Kazan<br>
            Tel: +7 (123) 123-45-67<br>
            E-mail: wcproj@gmail.com<br>
            <a href="https://vk.com/welcome_2018" target="_blank"><img src="images/vklogo.png" alt="vk.com"></a>
            <a href="https://www.instagram.com/welcome_2018/" target="_blank"><img src="images/instagramlogo.png" alt="instagram.com"></a>
        </div>
    </div>

    <div id="footer">
        <img src="images/system/sponsors.png">
    </div>
</div>
</body>
</html>
