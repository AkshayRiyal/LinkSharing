<%@ page import="com.ttn.linksharing.vo.TopicVO" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>

<body>
<!--Recent Share COnatiner-->
<div class="container-fluid col-md-7 col-sm-12 col-xs-12 pull-left my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Recent Shares</span>
        </div>
        <g:render template="/topic/recentshare" model="[resourceVos: resourceVOs1]"/>
    </div>
</div>
<g:render template="loginform"/>
<g:render template="registerform"/>
<ls:getTopPost/>
</body>
</html>