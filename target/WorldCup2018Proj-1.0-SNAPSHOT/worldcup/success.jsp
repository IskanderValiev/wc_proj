<%--
  Created by IntelliJ IDEA.
  User: isko
  Date: 9/28/17
  Time: 10:56 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Success</title>
    <style>
        body {
            background-image: url('/worldcup/images/system/background.png');
            color: #CCCC99;
            font-family: DushaV5-Regular;
        }

        .header {
            height: 54px;
            font-size: 35px;
            text-align: left;
            margin: 0px 50px 0px 0px;
            position: relative;
        }

        .header span {
            margin: 0px 0px 0px 20%;
        }

        .content {
            text-align: center;
            font-size: 25px;
        }

        .content table {
            margin: 10px 0px 0px 40%;
            font-size: 28px;
            text-align:right;
        }

        .content table td input[type=submit] {
            float: right;
        }

        .content input {
            font-family: DushaV5-Regular;
            border-radius: 5px;
            font-size:30px;
        }

        .content input[type="submit"] {
            font-family: DushaV5-Regular;
            background-image: url('/worldcup/images/system/background.png');
            color: #CCCC99;
            font-size: 15px;
            cursor: pointer;
            border-radius: 20px;
            width: 80px;
            height: 30px;
        }

        .content {
            align-content: center;
        }
    </style>
</head>
<body>
<div class="container">
    <div class="header">
        <span style="vertical-align: -22px">Successfully registration</span>
    </div>
    <hr>
    <div class="content">
        <h2>Please, input your login and password below to enter the site.</h2>
        <form action="/profile" method="post" class="auth">
            <table class="enter-form">
                <tr>
                    <td>Login</td>
                    <td><input type="text" name="enterlogin"></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="enterpass"></td>
                </tr>
                <tr>
                    <td></td>
                    <td><input type="submit" name="signin" value="Sign In"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>
