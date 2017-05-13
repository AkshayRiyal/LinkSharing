<%@ page import="com.ttn.linksharing.vo.TopicVO" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>

<body>
<div class="container-fluid col-md-5 col-sm-12 col-xs-12 pull-left my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Topic:${topic}</span>
        </div>
        <ls:getsearchedtopic topic='${topic}'/>
    </div>
</div>

<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-right my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Posts</span>
        </div>


<ls:getsearchedtopicresources topic="${topic}"/>

    </div>
</div>
<div class="container-fluid col-md-5 col-sm-12 col-xs-12 pull-left my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Users</span>
        </div>

<ls:getsearchedtopicsubscribeduser topic="${topic}"/>
    </div>
</div>
</body>
</html>