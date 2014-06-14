<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<html>
<head>
    <title>LecLib</title>
    <link rel="stylesheet" href="/css/bootstrap.css">
    <link rel="stylesheet" href="/css/style.css">
    <meta http-equiv="content-type" content="text/html; charset=utf-8">
</head>
<body>
<h1 align="center">Добро пожаловать на сайт LecLib</h1>
<div align="center">
    <p style="text-align: justify; width: 500px">
        LecLib - это библиотека лекций. Здесь вы можете записать любую лекцию и затем поделиться ей с другими пользователями. Доступ к лекциям предоставляется только зарегестрированным пользователям. Авторизуйтесь в форме ниже, или <a href="/registr">зарегистрируйтесь</a>
    </p>
</div>
<div align="center" id="login-box">

    <c:if test="${not empty error}">
        <div class="error">${error}</div>
    </c:if>
    <c:if test="${not empty msg}">
        <div class="msg">${msg}</div>
    </c:if>
    <form class="form-horizontal" role="form" action="<c:url value='/j_spring_security_check'/>" method='POST'>
        <div class="form-group">
            <label for="username" class="col-sm-5 control-label">Логин</label>

            <div class="col-sm-2">
                <input type="text" class="form-control" id="username" name="username" placeholder="Логин">
            </div>
        </div>
        <div class="form-group">
            <label for="password" class="col-sm-5 control-label">Пароль</label>

            <div class="col-sm-2">
                <input type="password" class="form-control" id="password" name="password" placeholder="Пароль">
            </div>
        </div>
        <div class="form-group">
            <div class="col-sm-offset-4 col-sm-4">
                <button type="submit" class="btn btn-default">Войти</button>
            </div>
        </div>
    </form>

</div>
</body>
</html>
