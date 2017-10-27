<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 10/22/17
  Time: 3:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ru">
<head>
    <title>Player profile</title>
    <meta charset="UTF-8">
    <meta name="description" content="Описание">
    <meta name="author" content="Iskander Valiev">
    <!-- Стили -->
    <link rel="stylesheet" href="homepage/slick/slick.css">
    <link rel="stylesheet" href="homepage/slick/slick-theme.css">
    <link rel="stylesheet" href="/worldcup/style.css">
    <style>
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
<div class="main">
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
        <div class="image">
            <img src="${photo}" width="200" height="200" style="background-color: white;">
        </div>
        <div class="playerinfo">
            <table class="info">
                <tr>
                    <td><label>Firstname: ${name}</label></td>
                </tr>
                <tr>
                    <td><label>Lastname: ${lastname}</label></td>
                </tr>
                <tr>
                    <td><label>Age: ${age}</label></td>
                </tr>
                <tr>
                    <td><label>Number: #${number}</label></td>
                </tr>
                <tr>
                    <td><label>Position: ${position}</label></td>
                </tr>
                <tr>
                    <td><label>Club: ${club}</label></td>
                </tr>
                <tr>
                    <td><label>Country: ${country}</label></td>
                </tr>
            </table>
        </div>
        <div class="countryimage">
            <img src="${countryImage}">
        </div>
        <div class="clubimage">
            <img src="${clubLogo}">
        </div>
    </div>
</div>
</body>
</html>
