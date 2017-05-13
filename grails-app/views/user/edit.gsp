<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>

<body>

<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-left my-panel">
    <g:render template="show" model="[userList: userList]"/>
</div>


<div class="container-fluid col-md-6 col-sm-12  col-xs-12 pull-right my-panel">
    <div class="panel panel-default ">
        <div class="panel-heading">
            <span class="panel-title">Profile</span>
        </div>
        <g:render template="editform"/>
    </div>
</div>


<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-right my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Change Password</span>
        </div>
        <g:render template="changepassword"/>
    </div>
</div>

<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-left my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Topics</span>
        </div>
        <g:render template="/topic/displaytopic" model="[topics: topics]"/>
    </div>
</div>

</body>
</html>