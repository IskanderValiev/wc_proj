<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 9/24/17
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="dao.UsersDao" %>
<%@ page import="dao.UsersDoaJdbcTemplateImpl" %>
<%@ page import="org.springframework.jdbc.datasource.DriverManagerDataSource" %>


<%
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setUrl("jdbc:postgresql://localhost:5432/wc_proj_users");
    dataSource.setUsername("postgres");
    dataSource.setPassword("BVB09");
    UsersDao usersDao = new UsersDoaJdbcTemplateImpl(dataSource);

    String cookieName = "loginCookie";
    Cookie cookie = null;
    Cookie[] cookies = request.getCookies();
    if (cookies != null) {
        for (int i = 0; i < cookies.length; i++) {
            String name = cookies[i].getName();
            if (name.equals(cookieName)) {
                cookie = cookies[i];
                break;
            }
        }
    }

    String login = cookie.getValue();
    System.out.println(login);


    String name = usersDao.getColumnByLogin("name", login);
    String lastname = usersDao.getColumnByLogin("lastname", login);
    String city = usersDao.getColumnByLogin("city", login);
    String gender = usersDao.getColumnByLogin("gender", login);
    String email = usersDao.getColumnByLogin("email", login);
    String bday = usersDao.getColumnByLogin("bday", login);


%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="/worldcup/style.css">
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
                <td><a href="/worldcup/profile.jsp">Profile</a></td>
            </tr>
            <tr>
                <td><a href="/worldcup/homepage/index.html">Homepage</a></td>
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
        <div class="image">
            <img src="/worldcup/images/system/null.jpg" width="200" height="200">
            <a href=""></a>
        </div>

        <div class="information">
            <table class="info">
                <tr>
                    <td><label><font size="28px"><%=name + " " + lastname%></font></label></td>
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
        <img src="/worldcup/images/system/sponsors.png" usemap="#mymap">
    </div>

    <map name="mymap">
        <area shape="rect" coords="1.06,4.00,5.82,5.80" href="http://adidas.com/">
    </map>
</div>
</body>
</html>