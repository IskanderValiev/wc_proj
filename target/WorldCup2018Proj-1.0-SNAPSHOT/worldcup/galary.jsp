<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Galary</title>
    <link rel="stylesheet" type="text/css" href="/worldcup/galary/style.css">
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
    <div class="albums">
        <div class="album">
            <a href="/worldcup/galary/images/portugalvschile/porchi.html">
           <img src="/worldcup/galary/images/porchi.jpg" alt="portugalvschile">
            <div class="album_text">
                <h3 class="album_header">Portugal - Chile</h3>
                <p class="album_desc">28th July, Kazan, Semifinal</p>
            </div>
            </a>
        </div>
        <div class="album">
            <a href="/worldcup/galary/images/germanyvschile/germanyvschile.html">
            <img src="/worldcup/galary/images/gerchi.jpg" alt="germanyvschile">
            <div class="album_text">
                <h3 class="album_header">Germany - Chile</h3>
                <p class="album_desc">22th June, Kazan, Group stage</p>
            </div>
            </a>
        </div>
        <div class="album">
            <a href="/worldcup/galary/images/portugalvsmexico/pormex.html">
            <img src="/worldcup/galary/images/pormex.jpg" alt="portugalvsmexico">
            <div class="album_text">
                <h3 class="album_header">Portugal - Mexico</h3>
                <p class="album_desc">2 July, Moscow, 3rd place</p>
            </div>
            </a>
        </div>
        <div class="album">
            <a href="/worldcup/galary/images/germanyvscameroon/gercam.html">
            <img src="/worldcup/galary/images/gercam.jpg" alt="germanyvscameroon">
            <div class="album_text">
                <h3 class="album_header">Germany - Cameroon</h3>
                <p class="album_desc">25 June, Sochi, Group stage</p>
            </div>
            </a>
        </div>
    </div>
</div>
</body>
</html>