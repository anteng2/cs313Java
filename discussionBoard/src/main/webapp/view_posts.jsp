<%
    request.getSession(false);
    session=request.getSession();
    if(session.getAttribute("username") == null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Discussion Thread</title>
    </head>
    <body>
        <h1 style="text-align: center">Discussion Thread</h1>
        <p style="text-align: center"><a href="post.jsp"><b>Create a New Post</b></a></p>
        <br />
        <table style="margin: 0 auto; background-color: grey" width="800px">
                        <tr>
                <th>Username</th><th>Content</th><th>Date</th>
            </tr>
    <c:forEach var="post" items="${postArray}"> 
            <tr style="background-color: white">
                <td align="center">
                ${post.username}<br />
                </td>
                <td align="center">
        ${post}<br />
                </td>
                <td width="200px" align="center">
        ${post.time}<br /><br />
                </td>
        </tr>

              </c:forEach>
                </table>
        <br /><br />
    </body>
</html>
