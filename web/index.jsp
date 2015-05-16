<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: sergei
  Date: 15.05.2015
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<table border="1">
    <c:forEach var="posts" items="${requestScope.books}">
        <tr>
            <td>
                    ${posts.userName}
            </td>
            <td>
                    ${posts.post}
            </td>
            <td>
                <a href="delete?id=${posts.id}"><img src="delete.png"></a>
            </td>
        </tr>
    </c:forEach>
</table>
<form method="post" action="main">
<textarea  rows="10" cols="15" name="text"></textarea>
<input type="submit" name="Постить" id="post"/>
</form>
</body>
</html>
