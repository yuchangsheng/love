<%@page language="java" pageEncoding="UTF-8" contentType="text/html;UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
    </tr>
    <c:forEach items="${list}" var="s" varStatus="st">
        <tr>
            <td>${s.name}</td>
        </tr>
    </c:forEach>
    <c:forEach items="${list2}" var="s" varStatus="st">
        <tr>
            <td>${s.name}</td>
        </tr>
    </c:forEach>
</table>