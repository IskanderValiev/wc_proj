<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 9/24/17
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.usersdao.UsersDao" %>
<%@ page import="dao.usersdao.UsersDoaJdbcTemplateImpl" %>
<%@ page import="org.springframework.jdbc.datasource.DriverManagerDataSource" %>
<%@ page import="cookies.Cookies" %>
<%@ page import="cookies.CookiesImpl" %>


<%
//    DriverManagerDataSource dataSource = new DriverManagerDataSource();
//    dataSource.setUrl("jdbc:postgresql://localhost:5432/wc_proj_users");
//    dataSource.setUsername("postgres");
//    dataSource.setPassword("BVB09");
//    UsersDao usersDao = new UsersDoaJdbcTemplateImpl(dataSource);
//
//    Cookies cookies = new CookiesImpl();
//
//    String login = cookies.getCookie("login", request).getValue();
//    System.out.println(login);
//
//
//    String name = usersDao.getColumnByLogin("name", login);
//    String lastname = usersDao.getColumnByLogin("lastname", login);
//    String city = usersDao.getColumnByLogin("city", login);
//    String gender = usersDao.getColumnByLogin("gender", login);
//    String email = usersDao.getColumnByLogin("email", login);
//    String bday = usersDao.getColumnByLogin("bday", login);

%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="/worldcup/style.css">
    <style type="text/css">

    </style>
    <script src="http://yastatic.net/jquery/2.1.1/jquery.min.js"></script>
    <script type="text/javascript">
        window.onload = function () {
            jQuery("#user-city").text(ymaps.geolocation.city);
        }
    </script>
    <script src="http://api-maps.yandex.ru/2.0-stable/?load=package.standard&lang=en-RU" type="text/javascript"></script>
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
        <div class="image">
            <img src="${image}" width="200" height="200" style="background-color: white;">
            <a href=""></a>
        </div>

        <div class="information">
            <table class="info">
                <tr>
                    <td><label><font size="20px">${name}</font></label></td>
                </tr>
                <tr style="height: 5px">
                    <td style="height: 2px"><hr></td>
                    <td><div class="edit">
                        <a href="/editprofile" style="margin-bottom: 0">edit</a>
                    </div></td>
                </tr>
                <tr>
                    <td><label>Bday: ${bday}</label></td>
                </tr>
                <tr>
                    <td><label>City: ${city}</label></td>
                </tr>
                <%--<tr>--%>
                    <%--<td><label>Current city:<div id="user-city"></div></label></td>--%>
                <%--</tr>--%>
                <tr>
                    <td><label>Gender: ${gender}</label></td>
                </tr>
                <tr>
                    <td><label>E-mail: ${email}</label></td>
                </tr>
                <tr>
                    <td><label>Instagram:</label></td>
                </tr>
            </table>
        </div>
    </div>

    <div id="footer">
        <img src="/worldcup/images/system/sponsors.png" usemap="#mymap">
    </div>

    <map name="mymap">
        <area shape="rect" coords="1.06,4.00,5.82,5.80" href="http://adidas.com/">
    </map>
</div>
</body>
</html>