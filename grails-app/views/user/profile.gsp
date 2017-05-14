<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">
</head>

<body>
<div class="container-fluid col-md-6  col-xs-12 pull-left my-panel">
    <div class="panel panel-default">
        <g:render template="show" model="[userList: userList]"/>
    </div>
</div>

<div class="container-fluid col-md-6  col-xs-12 pull-right my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Topics</span>
        </div>

        <g:render template="/topic/displaytopic" model="[topics: topics]"/>
    </div>
</div>

<div class="container-fluid col-md-6  col-xs-12 pull-left my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Subscriptions</span>
        </div>
        <ls:getSubscribedTopics/>
    </div>
</div>

<div class="container-fluid col-md-6  col-xs-12 pull-right my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Posts</span>

        </div>
            <g:render template="/user/showresource" model="[msgList: resourcesCreated]"/>
        </div>
    </div>
</body>
</html>