<%-- 
    Document   : index
    Created on : Mar 3, 2017, 5:57:26 PM
    Author     : ahmad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Expdia Search hotels</title>
        <link type="text/css"  rel="stylesheet" href="resources/bootstrap/css/bootstrap.css"/>

        <link type="text/css" rel="stylesheet"  href="resources/date.css"/>

        <link type="text/css" rel="stylesheet"  href="resources/search.css"/>
        <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    </head>
    <script>
        $(function () {
            $("#datepickerStart").datepicker();
        });
        $(function () {
            $("#datepickerEnd").datepicker();
        });
    </script>
    <body>
        <div class="container-fluid" align="center">  
            <div id="head" class="col-lg-8 col-centered" align="center">
                <img src="images/logo.png" />
                <h4>Book Flight + Hotel at the same time</h4>
            </div><br>
            <div class="col-lg-8  col-md-8 col-sm-8 col-centered" id="cont"> 
                <form id="searchform" class="searchform" style="    color: #ffc500;font-family: cursive;" action="/expdiaTask/HandlerSearchHotels">
                    City Name: <input type="text" id="city" name="city" class="city" placeholder="ex:Dubai" required/>
                    <br>Start Date: <input type="text" id="datepickerStart" name="minTripStartDate" class="datepickerStart" required/>
                    <br>End Date: <input type="text" id="datepickerEnd" name="maxTripStartDate" class="datepickerEnd" required/>
                    <br><input type="submit" value="Search"/>
                </form>
            </div>
        </div>
    </body>
</html>
