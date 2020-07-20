<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Tariff</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <div class="container">
            <h1>Tariff Info</h1>
        </div>
    </div>
</section>
<section class="container">
    <div class="row">
        <div class="col-md-5">
            <h3>${tariff.title}</h3>
            <p>Price: ${tariff.price}</p>
            <p>
                <strong>Tariff Code : </strong>
                <span class="label label-warning">${tariff.tariffId}</span>
            </p>
            <p>
                <strong>Available Options:</strong>
                <c:forEach items="${tariff.optionList}" var="option">
                    <p>Title: ${option.title}</p>
                </c:forEach>
            </p>
            <p>
                <a href="#" class="btn btn-warning btn-large">
                    <span class="glyphicon-shopping-cart glyphicon"></span> Order Now
                </a>
            </p>
        </div>
    </div>
</section>
</body>
</html>