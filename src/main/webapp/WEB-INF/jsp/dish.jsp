<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec"
           uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title><s:message code="menu.dish"/></title>
</head>
<body>
<%@include file="/WEB-INF/incl/menu.app"%>

<c:if test="${!allDish.isEmpty()}">
<div>
    <h1>Wszystkie potrawy</h1>

    <c:forEach items="${allDish}" var="allDish">
    <br/>
    <table border="1">
        <thead>
        <tr>
            <th>Tytuł</th>
            <td>${allDish.title}</td>
        </tr>
        </thead>
        <tbody>
        <tr>
            <th>Typ dania</th>
            <td>${allDish.dishType}</td>
        </tr>
        <tr>
            <th>Trudność wykonania</th>
            <td>${allDish.difficulty}</td>
        </tr>
        <tr>
            <th>Czas wykonania</th>
            <td>${allDish.time}</td>
        </tr>
        <tr>
            <th>Przepis</th>
            <td>${allDish.recipes}</td>
        </tr>
        <tr>
            <td>Opis</td>
            <td>${allDish.description}</td>
        </tr>
        <tr>
            <th>Autor</th>
            <td>${allDish.authorEmail}</td>
        </tr>
        </tbody>
    </table>
    </c:forEach>
</div>
</c:if>

<c:if test="${allDish.isEmpty()}">
<div>
    <h1>Brak potraw w bazie.</h1>
</div>
</c:if>

</body>
</html>