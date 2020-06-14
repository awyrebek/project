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
    <title><s:message code="menu.addDish"/></title>
</head>
<body>

<%@include file="/WEB-INF/incl/menu.app" %>

<h1><c:out value="Dodawanie nowej potrawy" /></h1>
<form action="addNewDish" method="post">
    <p>
        Tytuł <input name="title" placeholder="Tytuł" /><br/>
        Typ potrawy <select name="dishType">
                        <option>Typ 1</option>
                        <option>Typ 2</option>
                        <option>Typ 3</option>
                    </select><br/>
        Poziom trudności <input name="difficulty" type="number" min="0" max="5" /><br/>
        Czas wykonania <input name="time" type="number" min="0" max="1000" /> min<br/>
        <textarea name="recipes">Przepis</textarea><br/>
        <textarea name="description">Opis</textarea><br/>
        <input type="submit" value="Dodaj potrawę" />
    </p>
</form>
</body>
</html>