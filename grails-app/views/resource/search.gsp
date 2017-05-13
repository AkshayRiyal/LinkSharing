<%@ page import="com.ttn.linksharing.vo.TopicVO" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>
<body>
<div class="container-fluid col-md-6  col-xs-12 pull-left my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Trending Topics</span>
        </div>
        <ls:getTrendingTopic/>
    </div>
</div>
<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-right my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">

            <span class="panel-title">${query}</span>
        </div>
        <g:render template="/user/showresource" model="[msgList:searchResources]"/>
    </div>
</div>
</body>
</html>