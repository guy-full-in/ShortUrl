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
                Добро пожаловать,
                <c:choose>
                    <c:when test="${pageContext.request.userPrincipal.name != null}">
                        ${pageContext.request.userPrincipal.name}!
                    </c:when>
                    <c:otherwise>
                        Гость!
                    </c:otherwise>
                </c:choose>
               </span>

            <c:choose>
                <c:when test="${pageContext.request.userPrincipal.name != null}">
                    <button class="btn btn-default" type="submit" onclick="javascript:formSubmit()">Выход</button>
                </c:when>
            </c:choose>

        </div>

    </div>
</nav>
<div align="center">
    <div class="form-inline">
        <div id="errors"></div>
        <input type="text" id="originalLink" name="originalLink" class="form-control" style="width: 300px"
               placeholder="Введите URL">
        <button class="btn btn-primary" onclick="addUrl();">Выполнить</button>
        <br>
        <c:if test="${pageContext.request.userPrincipal.name != null}">
            <input type="checkbox" id="sendEmail" name="sendEmail">Отправить ссылку на e-mail</input>
        </c:if>
    </div>
    <h5>Просто вставьте вашу ссылку и получите сокращенную ниже</h5>
    <i class="glyphicon glyphicon-chevron-down"> </i><br>
    <i class="glyphicon glyphicon-chevron-down" style="margin-top: -5px"> </i><br><br>

    <form class="form-inline">
        <input id="shortUrl" type="text" name="shortCode" class="form-control" readonly
               style="cursor: pointer; width: 400px"
               placeholder="Результат" onclick="this.select();">
    </form>
    <br>


    <c:choose>
        <c:when test="${pageContext.request.userPrincipal.name == null}">

            <h5><a href="/registr">Зарегистрируйтесь</a> или пройдите авторизацию ниже <br> и тогда вы сможете
                видеть историю выших ссылок и продлевать их</h5>

            <div id="loginForm" class="loginBlock">
                <h3>Авторизация</h3>
                <c:if test="${not empty error}">
                    <div class="error">${error}</div>
                </c:if>
                <c:if test="${not empty msg}">
                    <div class="msg">${msg}</div>
                </c:if>
                <form class="form-horizontal" role="form" action="<c:url value='/j_spring_security_check'/>"
                      method='POST'>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-lg-8">
                            <input type="text" class="form-control" id="username" name="username" placeholder="Логин">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-2 col-lg-8">
                            <input type="password" class="form-control" id="password" name="password"
                                   placeholder="Пароль">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-4 col-sm-4">
                            <button type="submit" class="btn btn-primary">Войти</button>
                        </div>
                    </div>
                </form>
            </div>
        </c:when>
        <c:otherwise>
            <h4>История ссылок:</h4>

            <div id="urls"></div>
        </c:otherwise>
    </c:choose>
</div>
</div>

<script>
    /*<![CDATA[*/

    function addUrl() {
        $('#errors').html('');
        var originalLink = $('input#originalLink').val();
        var sendEmail = $('input#sendemail').val();
        if (isValidURL(originalLink)) {
            var url = "/url";
            $.post(url, {'originalLink': originalLink, 'sendEmail': sendEmail}, function (url) {
                $('input#shortUrl').val('localhost:8080/' + url.shortCode);  //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
                loadUrls();
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

    function loadUrls() {
        $.get("/urls", function (urls) {
            $('#urls').html('');
            if (urls.length == 0) {
                $('#urls').append('У вас пока нет добавленных ссылок, или их срок истек.');
            } else {
                var html = '<table class="table table-bordered urlHistory"><thead><tr><td>Оригинальная ссылка</td><td>Короткая ссылка</td><td>Дата добавления</td><td>Оставшийся срок</td></tr></thead><tbody>';
                urls.forEach(function (url) {
                    html += '<tr><td><a href="' + url.originalLink + '" target="_blank">' + url.originalLink + '</a></td><td><input style="cursor: pointer" type="text" class="form-control" readonly onclick="this.select();" value="localhost:8080/' + url.shortCode + '"/></td><td>';
                    var date = new Date(url.createdAt);
                    html += date.getDate() + '.' + (date.getMonth() + 1) + '.' + date.getFullYear();
                    html += '</td><td>' + (Math.ceil((url.deletedAt - new Date()) / (1000 * 60 * 60 * 24))) + ' дней</td></tr>';
                });
                html += '</tbody></table>';
                $('#urls').append(html);
            }
        })
    }

    $(loadUrls());
    /*]]>*/
</script>
</body>
</html>
