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
