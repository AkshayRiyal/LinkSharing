<%@ page import="com.ttn.linksharing.vo.TopicVO" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>

<body>

<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-right my-panel">
    <div class="row">
        <div class="container-fluid col-sm-12 col-xs-12 pull-right my-panel">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="panel-title">Inbox</span>
                </div>

                <g:render template="showresource" model="[msgList: msgList]"/>
            </div>
        </div>

    </div>

</div>

<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-left my-panel">

    <div class="row">
        <div class="container-fluid col-sm-12 col-xs-12 pull-left my-panel">
            <div class="panel panel-default">
                <g:render template="show" model="[userList: userList]"/>
        </div>
    </div>
    </div>
    <div class="row">
        <div class="container-fluid col-sm-12 col-xs-12 pull-left my-panel">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="panel-title">Trending Topics</span>
                </div>
                <ls:getTrendingTopic/>
            </div>
        </div>

    </div>

    <div class="row">
        <div class="container-fluid  col-sm-12 col-xs-12 pull-left my-panel">

            <div class="panel panel-default">
                <div class="panel-heading">
                    <span class="panel-title">Subscribed Topics</span>
                </div>

                <ls:getSubscribedTopics/>
            </div>
        </div>

    </div>
</div>

</body>
</html>