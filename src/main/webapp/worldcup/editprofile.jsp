<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 9/24/17
  Time: 2:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Profile</title>
    <link rel="stylesheet" type="text/css" href="/worldcup/style.css">
    <style type="text/css">
        .information {
            font-size: 25px;
            float: left;
            width: 60%;
        }

        .image {
            background: #CCCC99;
            float: left;
            width: 250px;
            height: 250px;
            margin: 0 50px 0 50px;
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
            <img src="${image}" width="200" height="200">
            <input type="text" form="editing" name="image" style="width: 100%; margin: 0 0 0 0; float: left">
        </div>

        <div class="information">
            <form action="/editprofile" method="post" id="editing">
                <table class="info">
                    <tr>
                        <td><label>Name: </label></td>
                        <td><input type="text" name="name" placeholder="${name}"></td>
                    </tr>
                    <tr>
                        <td><label>Lastname: </label></td>
                        <td><input type="text" name="lastname" placeholder="${lastname}"></td>
                    </tr>
                    <tr>
                        <td><label>Current password: </label></td>
                        <td><input type="password" name="currpass"></td>
                    </tr>
                    <tr>
                        <td><label>New password: </label></td>
                        <td><input type="password" name="newpass"></td>
                    </tr>
                    <tr>
                        <td><label>Confirm new password: </label></td>
                        <td><input type="password" name="cnewpass"></td>
                    </tr>
                    <tr>
                        <td><label for="birthday">Birthday:</label></td>
                        <td>
                            <select id="birthday" name="bday">
                                <option value="0" disabled>Day</option>
                                <option name="bday" value="1">1</option>
                                <option name="bday" value="2">2</option>
                                <option name="bday" value="3">3</option>
                                <option name="bday" value="4">4</option>
                                <option name="bday" value="5">5</option>
                                <option name="bday" value="6">6</option>
                                <option name="bday" value="7">7</option>
                                <option name="bday" value="8">8</option>
                                <option name="bday" value="9">9</option>
                                <option name="bday" value="10">10</option>
                                <option name="bday" value="11">11</option>
                                <option name="bday" value="12">12</option>
                                <option name="bday" value="13">13</option>
                                <option name="bday" value="14">14</option>
                                <option name="bday" value="15">15</option>
                                <option name="bday" value="16">16</option>
                                <option name="bday" value="17">17</option>
                                <option name="bday" value="18">18</option>
                                <option name="bday" value="19">19</option>
                                <option name="bday" value="20">20</option>
                                <option name="bday" value="21">21</option>
                                <option name="bday" value="22">22</option>
                                <option name="bday" value="23">23</option>
                                <option name="bday" value="24">24</option>
                                <option name="bday" value="25">25</option>
                                <option name="bday" value="26">26</option>
                                <option name="bday" value="27">27</option>
                                <option name="bday" value="28">28</option>
                                <option name="bday" value="29">29</option>
                                <option name="bday" value="30">30</option>
                                <option name="bday" value="31">31</option>
                            </select>

                            <select name="bmon">
                                <option value="0" disabled>Month</option>
                                <option name="bmon" value="01">Jan</option>
                                <option name="bmon" value="02">Feb</option>
                                <option name="bmon" value="03">Mar</option>
                                <option name="bmon" value="04">Apr</option>
                                <option name="bmon" value="05">May</option>
                                <option name="bmon" value="06">Jun</option>
                                <option name="bmon" value="07">Jul</option>
                                <option name="bmon" value="08">Aug</option>
                                <option name="bmon" value="09">Sep</option>
                                <option name="bmon" value="10">Oct</option>
                                <option name="bmon" value="11">Nov</option>
                                <option name="bmon" value="12">Dec</option>
                            </select>

                            <select name="byear">
                                <option value="0" disabled>Year</option>
                                <option name="byear" value="2010">2010</option>
                                <option name="byear" value="2009">2009</option>
                                <option name="byear" value="2008">2008</option>
                                <option name="byear" value="2007">2007</option>
                                <option name="byear" value="2006">2006</option>
                                <option name="byear" value="2005">2005</option>
                                <option name="byear" value="2004">2004</option>
                                <option name="byear" value="2003">2003</option>
                                <option name="byear" value="2002">2002</option>
                                <option name="byear" value="2001">2001</option>
                                <option name="byear" value="2000">2000</option>
                                <option name="byear" value="1999">1999</option>
                                <option name="byear" value="1998">1998</option>
                                <option name="byear" value="1997">1997</option>
                                <option name="byear" value="1996">1996</option>
                                <option name="byear" value="1995">1995</option>
                                <option name="byear" value="1994">1994</option>
                                <option name="byear" value="1993">1993</option>
                                <option name="byear" value="1992">1992</option>
                                <option name="byear" value="1991">1991</option>
                                <option name="byear" value="1990">1990</option>
                                <option name="byear" value="1989">1989</option>
                                <option name="byear" value="1988">1988</option>
                                <option name="byear" value="1987">1987</option>
                                <option name="byear" value="1986">1986</option>
                                <option name="byear" value="1985">1985</option>
                                <option name="byear" value="1984">1984</option>
                                <option name="byear" value="1983">1983</option>
                                <option name="byear" value="1982">1982</option>
                                <option name="byear" value="1981">1981</option>
                                <option name="byear" value="1980">1980</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td><label for="city">City</label></td>
                        <td>
                            <select id="city" name="city">
                                <option disabled>Chose city</option>
                                <option name="city" value="Kazan">Kazan</option>
                                <option name="city" value="Moscow">Moscow</option>
                                <option name="city" value="St. Petersburg">St. Petersburg</option>
                                <option name="city" value="Sochi">Sochi</option>
                                <option name="city" value="Kaliningrad">Kaliningrad</option>
                                <option name="city" value="Rostov-On-Don">Rostov-On-Don</option>
                                <option name="city" value="Nizhniy Novgorod">Nizhniy Novgorod</option>
                                <option name="city" value="Ekaterinburg">Ekaterinburg</option>
                                <option name="city" value="Saransk">Saransk</option>
                                <option name="city" value="Samara">Samara</option>
                                <option name="city" value="Volgograd">Volgograd</option>
                            </select></td>
                    </tr>
                    <%--<tr>--%>
                    <%--<td><label>Current city:<div id="user-city"></div></label></td>--%>
                    <%--</tr>--%>
                    <tr>
                        <td><label>Gender</label></td>
                        <td>
                            <input type="radio" name="gender" value="true" checked>
                            <label>Male</label>
                            <input type="radio" name="gender" value="false">
                            <label>Female</label>
                        </td>
                    </tr>
                    <tr>
                        <td><label>E-mail:</label></td>
                        <td><input name="email" placeholder="${email}"></td>
                    </tr>
                    <tr>
                        <td><label>Telephone:</label></td>
                        <td><input name="telephone" placeholder="${telephone}"></td>
                    </tr>
                    <tr>
                        <td><label>Instagram:</label></td>
                        <td><input name="instagram" placeholder="${instagram}"></td>
                    </tr>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="send"></td>
                    </tr>
                </table>
            </form>
        </div>
    </div>
</div>
</body>
</html>
