<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>
        <g:layoutTitle default="Grails"/>
    </title>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>

    <asset:stylesheet src="application.css"/>


    <title>Title</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/poststyle.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <g:layoutHead/>
</head>

<body>

<!--Upper Navbar -->
<nav class="navbar navbar-default mynavbar">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand mybrand" href="/user/dashboard"><u>LinkSharing</u></a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">

            <ul class="nav navbar-nav navbar-right">
                <li><form class="navbar-form" action="/resource/searchByQuery" method="post">
                    <div class="form-group">
                        <div class="inner-addon left-addon">

                            <i class="glyphicon glyphicon-search"></i>
                            <input type="text" name="query" onkeydown="if (event.keyCode == 13) {
                                this.form.submit();
                                return false;
                            }" class="form-control search-box" placeholder="search"/>
                        </div>
                    </div>
                    <!--            <button type="submit" class="btn btn-default">Submit</button>-->
                </form></li>
                <g:if test="${session.user}">
                    <li><a href="#createtopic" data-toggle="modal"><span class="glyphicon glyphicon-plus"
                                                                         aria-hidden="true"></span></a></li>
                    <li><a href="#invitation" data-toggle="modal"><span class="glyphicon glyphicon-envelope"
                                                                        aria-hidden="true"></span></a></li>
                    <li><a href="#createlink" data-toggle="modal"><span class="glyphicon glyphicon-link"
                                                                        aria-hidden="true"></span></a></li>
                    <li><a href="#createdocument" data-toggle="modal"><span class="glyphicon glyphicon-file"
                                                                            aria-hidden="true"></span></a></li>

                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                           aria-expanded="false">${session.user} <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/user/profile"><ls:displayProfileOnNavbar/></a></li>
                            <li><a href="/user/edit">Edit</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="/login/logOut">Logout</a></li>
                        </ul>
                    </li>
                </g:if>
            </ul>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>
<g:if test="${flash.error}">
    <div class="alert alert-danger">
        <strong>${flash.error}</strong>
    </div>
</g:if>
<g:if test="${flash.message}">
    <div class="alert alert-success">
        <strong>${flash.message}</strong>
    </div>
</g:if>
<g:layoutBody/>

<div class="footer" role="contentinfo"></div>

<div id="spinner" class="spinner" style="display:none;">
    <g:message code="spinner.alt" default="Loading&hellip;"/>
</div>

<g:render template="/topic/create"/>
<g:render template="/topic/email"/>
<g:render template="/linkresource/create"/>
<g:render template="/documentresource/create"/>
<asset:javascript src="application.js"/>

</body>
</html>
