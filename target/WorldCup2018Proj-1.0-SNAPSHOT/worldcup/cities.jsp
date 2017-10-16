<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 10/1/17
  Time: 10:02 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Cities</title>
    <link rel="stylesheet" type="text/css" href="style.css">
    <script type="text/javascript" src="//web-ptica.ru/VRV-files/jquery-2.1.3.min.js"></script>
</head>
<body>
<div class="main">
    <div id="header"><a name="top"></a>
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
                        <li><a href="#kazan">Kazan</a></li>
                        <li><a href="#moscow">Moscow</a></li>
                        <li><a href="#spb">St. Petersburg</a></li>
                        <li><a href="#sochi">Sochi</a></li>
                        <li><a href="#kaliningrad">Kaliningrad</a></li>
                        <li><a href="#saransk">Saransk</a></li>
                        <li><a href="#">Nizhniy Novgorod</a></li>
                        <li><a href="#">Rostov-On-Don</a></li>
                        <li><a href="#">Volgograd</a></li>
                        <li><a href="#">Ekaterinburg</a></li>
                        <li><a href="#samara">Samara</a></li>
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
        <h3><a name="kazan">Kazan</a></h3>
        <img src="images/kazan.jpg">
        <h3><a name="moscow">Moscow</a></h3>
        <img src="images/moscow.jpg">
        <h3><a name="spb">St. Petersburg</a></h3>
        <img src="images/spb.jpg">
        <h3><a name="sochi">Sochi</a></h3>
        <img src="images/sch.jpg">
        <h3><a name="kaliningrad">Kaliningrad</a></h3>
        <img src="images/kgd.jpg">
        <h3><a name="samara">Samara</a></h3>
        <img src="images/smr.jpg">
        <h3><a name="saransk">Saransk</a></h3>
        <img src="images/srn.jpg">
        <h3>Volgograd</h3>
        <img src="images/vlg.jpg">
        <h3>Nizhniy Novgorod</h3>
        <img src="images/nng.jpg">
        <h3>Rostov-On-Don</h3>
        <img src="images/rnd.jpg">
        <h3>Ekaterinburg</h3>
        <img src="images/ekt.jpg">
    </div>


    <div id="footer">
        <img src="images/system/sponsors.png">
    </div>

</div>
<script type="text/javascript" src="//web-ptica.ru/VRV-files/knopkavverh/10.js"></script>
</body>
</html>
