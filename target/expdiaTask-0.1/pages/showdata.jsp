<%-- 
    Document   : showdata
    Created on : Mar 4, 2017, 10:35:51 AM
    Author     : ahmad
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css"  rel="stylesheet" href="resources/bootstrap/css/bootstrap.css"/>
        <link type="text/css"  rel="stylesheet" href="resources/showdata.css"/>
        <script src=”//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js”></script>
        <title>Hotels</title>

    </head>

    <body>
        <div class="container-fluid">

            <div class="fixed-plugin">
                <div class="dropdown show-dropdown">
                    <a href="#" class="back-to-top" style="display: inline;">
                       <img src="images/arrow-icon-up.png"></i>

                    </a>
                </div>
            </div>
            <div class="row">
                <c:forEach items="${beanJsonExpdia.offers.hotel}" var="hotel">
                    <div class="col-lg-4 col-md-6 col-sm-6">
                        <div class="card card-stats">
                            <div class="card-header" background="">
                                <!--<i class="material-icons"></i>-->
                                <a href="${hotel.hotelUrls.hotelInfositeUrl}" target="_blaank"> <img src="${hotel.hotelInfo.hotelImageUrl}"/></a>
                            </div>
                            <div class="card-content">
                                <p class="category">${hotel.hotelInfo.hotelName}</p>
                                <h3 class="title">${hotel.hotelPricingInfo.originalPricePerNight}<small>${beanJsonExpdia.offerInfo.currency}</small></h3>
                            </div>
                            <div class="card-footer">
                                <div class="stats">
                                    <a href="https://www.expedia.com/" target="_blank"><img src="images/logoSmall.png"></a>
                                    <i class="material-icons text-danger"></i> <a href="${hotel.hotelUrls.hotelInfositeUrl}" target="_blaank">Get More info...</a>
                                    <a href="${hotel.hotelUrls.hotelSearchResultUrl}" target="_blank" style="margin-left: 179px;"><img src="images/searchicon.png" ></a>
                                    <address style="    color: #ffc700;">Address : ${hotel.hotelInfo.hotelStreetAddress}</address>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
            </div>

        </div>
    </body>
</html>
