<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Ayrat
  Date: 14.06.2014
  Time: 18:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ShortUrl</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/style.css">
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap-glyphicons.css" rel="stylesheet">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
    <script src="//ajax.googleapis.com/ajax/libs/jquery/1.11.0/jquery.min.js"></script>
</head>
<body>
<nav class="navbar navbar-default" role="navigation">
    <div class="container-fluid">

        <div style="margin-top: 5px">
            <a class="navbar-brand" href="/">ShortUrl</a>
        </div>

        <c:url value="/j_spring_security_logout" var="logoutUrl"/>
        <form action="${logoutUrl}" method="post" id="logoutForm">
        </form>

        <script>
            function formSubmit() {
                document.getElementById("logoutForm").submit();
            }
        </script>

        <div class="navbar-right">
               <span style="font-size: 18px; padding-right: 10px">
                Добро пожаловать, ${pageContext.request.userPrincipal.name}!
               </span>
            <button class="btn btn-default" type="submit" onclick="javascript:formSubmit()">Выход</button>
        </div>

    </div>
</nav>
<div align="center">
    <div class="form-inline">
        <div id="errors"></div>
        <input type="text" id="originalLink" name="originalLink" class="form-control" style="width: 300px" placeholder="Введите URL">
        <button class="btn btn-primary" onclick="addUrl();">Выполнить</button>
    </div>

    <br>
    <i class="glyphicon glyphicon-chevron-down"> </i><br>
    <i class="glyphicon glyphicon-chevron-down" style="margin-top: -5px"> </i><br><br>

    <form class="form-inline">
        <input id="shortUrl" type="text" name="shortCode" class="form-control" style="width: 400px" placeholder="Результат" onclick="this.select();">
    </form>
</div>



<script>
    /*<![CDATA[*/

    function addUrl() {
        $('#errors').html('');
        var originalLink = $('input#originalLink').val();
        if (isValidURL(originalLink)) {
            var url = "/url";
            $.post(url, {'originalLink': originalLink}, function (url) {
                alert(url.shortCode);
                $('input#shortUrl').val('localhost:8080/'+url.shortCode);  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            });
        } else {
            var html = '<div class="error">';
            html += 'Вы ввели некорректную ссылку';
            html += '</div>';
            $('#errors').html(html);
        }
    }

    function isValidURL(url) {
        var RegExp = /\(?(?:(http|https|ftp):\/\/)?(?:((?:[^\W\s]|\.|-|[:]{1})+)@{1})?((?:www.)?(?:[^\W\s]|\.|-)+[\.][^\W\s]{2,4}|localhost(?=\/)|\d{1,3}\.\d{1,3}\.\d{1,3}\.\d{1,3})(?::(\d*))?([\/]?[^\s\?]*[\/]{1})*(?:\/?([^\s\n\?\[\]\{\}\#]*(?:(?=\.)){1}|[^\s\n\?\[\]\{\}\.\#]*)?([\.]{1}[^\s\?\#]*)?)?(?:\?{1}([^\s\n\#\[\]]*))?([\#][^\s\n]*)?\)?/gi;

        if (RegExp.test(url)) {
            return true;
        } else {
            return false;
        }
    }
    /*]]>*/
</script>
</body>
</html>
