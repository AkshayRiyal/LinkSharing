<%@ page import="com.ttn.linksharing.vo.TopicVO" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>

<body>
<%@ page import="com.ttn.linksharing.vo.TopicVO" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>

<body>
<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-left my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Post</span>
        </div>

        <g:render template="viewpost" model="resource:${resource}"/>

    </div>
</div>

<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-right my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Trending Topics</span>
        </div>
        <ls:getTrendingTopic/>
    </div>
</div>

</body>
</html>