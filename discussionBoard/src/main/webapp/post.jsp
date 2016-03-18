<%
    request.getSession(false);
    session=request.getSession();
    if(session.getAttribute("username") == null)
    {
        response.sendRedirect("index.jsp");
    }
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 style="text-align: center">New Post</h1>
        <p style="text-align: center">Welcome <b>${sessionScope.username}</b>! To view the posts, please 
        <a href="LoadPostsServlet">click here</a>.</p>
        <form action="CreatePostServlet" method="POST">
            <textarea name="content" rows="10" cols="80"></textarea>
            <br /><br />
            <input type="submit" value="Post">
        </form>
    </body>
</html>
