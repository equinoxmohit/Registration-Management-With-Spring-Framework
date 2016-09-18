<%-- 
    Document   : login
    Created on : Sep 18, 2016, 9:58:23 PM
    Author     : Mohit
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    </head>
    <body>
        <div class="container-fluid">
            <h1>Login Page</h1>
            <form action="${pageContext.request.contextPath}/login/admin" method="post">
                <div>
                    <label>Username</label>
                    <input type="text" name="username" required="required" class="form-control" placeholder="enter your username..."/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" name="password" required="required" class="form-control" placeholder="enter your password..."/>
                </div>
                <div>
                    <button type="submit" class="btn btn-success">Submit</button>
                    <button type="reset" class="btn btn-danger">Reset</button>
                    <a href="${pageContext.request.contextPath}/register" class="btn btn-default">Register</a>
                </div>
            </form>
        </div>
    </body>
</html>
