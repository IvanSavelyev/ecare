<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<html>
<head>
    <style>
        .rect{
            width: auto;
            height: auto;
            border: 3px solid #000000;
            margin: 4px;
        }
    </style>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Tariff</h1>
            <p>All the available options</p>
            <p> <a href="/">GO TO HOME</a></p>
            <p> <a href="#">ADD NEW Option</a></p>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <c:forEach items="${tariffs}" var="tariff">
            <div class="col-sm-6 col-md-3" style="padding-bottom: 15px">
                <div class="thumbnail">
                    <div class="caption">
                        <p>OPTION INFO</p>
                        <h3>Title: ${tariff.title}</h3>
                        <p>Price: ${tariff.price}</p>
                        <p>Option list:</p>
                        <c:forEach items="${tariff.optionList}" var="option">
                            <p>Title: ${option.title}</p>
                        </c:forEach>
                        <p>
                            <a href="<spring:url value="/tariff?id=${tariff.tariffId}"/>" class="btn btn-primary">
                                <span class="glyphicon-info-sign glyphicon"></span> Details
                            </a>
                        </p>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>
</section>
</body>
</html>
