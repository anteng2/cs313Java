<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Log in | Discussion Thread</title>
    </head>
    <body>
        <h1>Sign in</h1>
        <form method="GET" action="SignInServlet">
            Please enter a username: <br />
            <input type="text" name="username">
            <input type="submit" value="Sign in">
        </form>
    </body>
</html>
