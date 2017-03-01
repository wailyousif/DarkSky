<%@ page import="com.ironyard.data.AppUser" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Weather</title>

    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script type="text/javascript">
        function fetchCurrentLocation()
        {
            $('#showNotification').html("Fetching your current location, please wait...");
            $('#showNotification').show();

            if (navigator.geolocation)
            {
                navigator.geolocation.getCurrentPosition(showPosition);
            }
            else
            {
                $('#showNotification').html("Geolocation is not supported by your browser.");
            }
        }

        function showPosition(position)
        {
            $('#showNotification').html('');
            $('#showNotification').hide();
            $('#lat').attr('value', position.coords.latitude);
            $('#lon').attr('value', position.coords.longitude);
        }

        function getLocation()
        {
            $('#showNotification').hide();

            var getCurrentLoc = '${getCurrentLoc}';
            if (getCurrentLoc != null)
                if (getCurrentLoc == 0)
                    return;

            fetchCurrentLocation();
        }
    </script>
    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }
        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}
        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }
        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }
        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }
        hr.style8 {
            border-top: 1px solid dimgray;
            border-bottom: 1px solid dimgray;
        }
        hr.style8:after {
            content: '';
            display: block;
            margin-top: 2px;
            border-top: 1px solid dimgray;
            border-bottom: 1px solid dimgray;
        }
    </style>
</head>
<body onload="getLocation()">

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img style="width: 40px;" src="https://www.theironyard.com/etc/designs/theironyard/icons/iron-yard-logo.svg" alt="The Iron Yard" />
            </a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li>                <a href="/mvc/weather/show">Weather</a></li>
                <li class="active">                <a href="#">Search History</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">
                <li><a href="/mvc/weather/logout"><span class="glyphicon glyphicon-log-out"></span>Logout</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container text-center">
    <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-9 text-left">
            <h3>Last 5 Search History</h3>
            <hr />
            <div clas="row">

                <div class="row">
                    <table border="1px;" style="margin: auto; width: calc(100% + 160px);">
                        <tr>
                            <th style="text-align: center;">Time Stamp</th>
                            <th style="text-align: center;">Latitude</th>
                            <th style="text-align: center;">Longitude</th>
                            <th style="text-align: center;">Time Zone</th>
                            <th style="text-align: center;">Weather Summary</th>
                            <th style="text-align: center;">Temperature</th>
                            <th style="text-align: center;">Humidity</th>
                            <th style="text-align: center;">Wind Speed</th>
                        </tr>
                        <c:forEach items="${histList.iterator()}" var="aHist">

                                <div class="row">
                                    <tr>
                                        <td style="text-align: center;"><c:out value=" ${aHist.timeStamp}"/></td>
                                        <td style="text-align: center;"><c:out value=" ${aHist.lat}"/></td>
                                        <td style="text-align: center;"><c:out value=" ${aHist.lon}"/></td>
                                        <td style="text-align: center;"><c:out value=" ${aHist.timeZone}"/></td>
                                        <td style="text-align: center;"><c:out value=" ${aHist.weatherSummary}"/></td>
                                        <td style="text-align: center;"><c:out value=" ${aHist.temperature}"/></td>
                                        <td style="text-align: center;"><c:out value=" ${aHist.humidity}"/></td>
                                        <td style="text-align: center;"><c:out value=" ${aHist.windSpeed}"/></td>
                                    </tr>
                                </div>

                        </c:forEach>
                    </table>
                    <br />
                </div>

            </div>
            <br />

        </div>
        <div class="col-sm-2" style="font-size: larger; color: darkcyan;">Welcome, <%=((AppUser)request.getSession().getAttribute("appUser")).getDisplayName()%></div>
    </div>

</div>

<footer class="container-fluid text-center">
    <p>TIY Weather App</p>
</footer>

</body>
</html>