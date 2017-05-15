<%@ page import="com.ttn.linksharing.vo.TopicVO" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>

<body>
<!--Login Form-->
<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-right my-panel">

    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Forgot-Password</span>
        </div>
        <div class="panel-body">
            <form class="form-signin" method="post" name="loginForm" action="/login/forgotPasswordMail">
                <input type="email" name="email" id="loginEmail" class="form-control" placeholder="email"  maxlength="30" required >
                <div class="checkbox" >
                    <button class="btn btn-info" type="submit">Send</button>

                </div>
            </form>

        </div>

    </div>
</div>
<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-right my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Trending-Topics</span>
        </div>
    <ls:getTrendingTopic/>
    </div>
</div>
<!--Login Form Ends-->
</body>
</html>