<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 10/17/17
  Time: 8:22 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html>
<head>
    <title>Add news</title>
    <link rel="stylesheet" href="/worldcup/homepage/style.css">
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
    <div class="newnews">
        <form action="/addnews" method="post">
            <input type="text" name="header" placeholder="news header">
            <textarea name="text" rows="20"></textarea>
            <input type="text" name="imagePath" placeholder="image path">
            <select name="type">
                <option disabled>Choose news type</option>
                <option name="type" value="News">News</option>
                <option name="type" value="Article">Article</option>
                <option name="type" value="Blog">Blog</option>
            </select>
            <input type="submit" value="Add news">
        </form>
    </div>
</div>
</body>
</html>
