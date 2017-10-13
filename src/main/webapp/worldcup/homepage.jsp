<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ru">
<head>
  <title>Homepage</title>
  <meta charset="UTF-8">
  <meta name="description" content="Описание">
  <meta name="author" content="Iskander Valiev">
  <!-- Стили -->
  <link rel="stylesheet" href="homepage/slick/slick.css">
  <link rel="stylesheet" href="homepage/slick/slick-theme.css">
  <link rel="stylesheet" href="homepage/style.css">
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
                  <li><a href="#">Teams</a>
                      <ul>
                          <li><a href="#">Europe</a></li>
                          <li><a href="#">South America</a></li>
                          <li><a href="#">Asia</a></li>
                          <li><a href="#">North and Central America</a></li>
                          <li><a href="#">Africa</a></li>
                          <li><a href="#">Oceania</a></li>
                      </ul>
                  </li>
                  <li><a href="/worldcup/galary.jsp">Galary</a></li>
                  <li><a href="/worldcup/contact.jsp">Contacts</a></li>
              </ul>
          </div>
          <div id="profile-menu">
              <ul class="profile-menu">
                  <li><a href="/profile">Profile</a></li>
                  <li><a href="/worldcup/authorization.html">Exit</a></li>
              </ul>
          </div>
      </div>

      <hr>

      <div class="sl">
          <div class="sl_slide"><a href="#"><img src="homepage/images/spain.jpg" alt="slide 1" class="sl_img">
              <div class="sl_text">
                  <h3 class="sl_header">Spain secure Russia 2018 berth.</h3>
                  <p class="sl_desc">Spain secure qualification to next year’s World Cup.</p>
              </div>
          </a></div>
          <div class="sl_slide"><a href="#"><img src="homepage/images/germany.jpg" alt="slide 2" class="sl_img">
              <div class="sl_text">
                  <h3 class="sl_header">Germay finished top of World Cup qualifying Group C and qualified to Russia.</h3>
                  <p class="sl_desc">Defending champions Germany confirmed their qualification for next year's World Cup in Russia by beating Northern Ireland 3-1 in Belfast.</p>
              </div>
          </a></div>
          <div class="sl_slide"><a href="#"><img src="homepage/images/1.jpg" alt="slide 3" class="sl_img">
              <div class="sl_text">
                  <h3 class="sl_header">Slide 3</h3>
                  <p class="sl_desc">Description 3</p>
              </div>
          </a></div>
          <div class="sl_slide"><a href="#"><img src="homepage/images/england.jpg" alt="slide 4" class="sl_img">
              <div class="sl_text">
                  <h3 class="sl_header">England’s lions: the late show specialists.</h3>
                  <p class="sl_desc">England qualified for 2018 FIFA World Cup with victory against Slovenia.</p>
              </div>
          </a></div>
          <div class="sl_slide"><a href="#"><img src="homepage/images/sweden.jpg" alt="slide 5" class="sl_img">
              <div class="sl_text">
                  <h3 class="sl_header">France edge closer as Sweden, Belgium break records.</h3>
                  <p class="sl_desc">The latest European qualifiers ended without any fresh names added to the list of 2018 FIFA World Cup Russia™ participants.</p>
              </div>
          </a></div>
      </div>

      <div class="information">
          <div class="block1">
              <a href="#">
                  <img src="homepage/images/news.jpg" alt="news" class="info_img">
                  <div class="info_text">
                      <h3 class="info_header">News 1</h3>
                      <p class="info_desc">Description</p>
                  </div>
              </a>
          </div>
          <div class="block2">
              <a href="#">
                  <img src="homepage/images/kazan_block2.jpg" alt="kazan" class="long_info_img">
                  <div class="info_text">
                      <h3 class="info_header">News 2</h3>
                      <p class="info_desc">Description</p>
                  </div>
              </a>
          </div>
          <div class="block1">
              <a href="#">
                  <img src="homepage/images/restaurants.jpg" alt="restaurants" class="info_img">
                  <div class="info_text">
                      <h3 class="info_header">News 3</h3>
                      <p class="info_desc">Description</p>
                  </div>
              </a>
          </div>
          <div class="block3">
              <a href="#">
                  <img src="homepage/images/fans.jpg" alt="fan" class="info_img">
                  <div class="info_text">
                      <h3 class="info_header">Fan guide</h3>
                      <p class="info_desc">Everything you need to know about travelling to Russia and staying there to enjoy the World Cup</p>
                  </div>
              </a>
          </div>
          <div class="block1">
              <a href="#">
                  <img src="homepage/images/vol.jpg" alt="volunteers" class="info_img">
                  <div class="info_text">
                      <h3 class="info_header">Volunteer programme</h3>
                      <p class="info_desc">Everything you need to know aboun volunteering</p>
                  </div>
              </a>
          </div>
      </div>

      <div id="footer">
          <img src="">
      </div>
  </div>
  <!-- Конец кода -->
  <!-- Подключаем скрипты -->
  <script src="http://yastatic.net/jquery/2.1.3/jquery.min.js"></script>
  <script src="homepage/slick/slick.min.js"></script>
  <script src="homepage/js/js.js"></script>
</body>
</html>
