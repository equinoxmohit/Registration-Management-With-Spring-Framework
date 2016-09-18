<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


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
                <h1>Registration Form:</h1>
                <form action="${pageContext.request.contextPath}/save" method="post">
                <div>
                    <label>First Name</label>
                    <input type="text" class="form-control" placeholder="enter your first name..." name="firstName" required="required"/>
                </div>
                <div>
                    <label>Last Name</label>
                    <input type="text" class="form-control" placeholder="enter your last name..." name="lastName" required="required"/>
                </div>
                <div>
                    <label>Username</label>
                    <input type="text" class="form-control" placeholder="enter a username..." name="username" required="required"/>
                </div>
                <div>
                    <label>Email</label>
                    <input type="text" class="form-control" placeholder="enter your email..." name="email" required="required"/>
                </div>
                <div>
                    <label>Password</label>
                    <input type="password" class="form-control" placeholder="enter your password" name="password" required="required"/>
                </div>
                <div>
                    <button type="submit" class="btn btn-success">Submit</button>
                    <button type="reset" class="btn btn-danger">Reset</button>
                    <a href="${pageContext.request.contextPath}/login" class="btn btn-default">Login</a>
                </div>

            </form>
        </div>
    </body>
</html>
