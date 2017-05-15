<%@ page import="com.ttn.linksharing.vo.TopicVO" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>

<body>

<div class="container-fluid  col-sm-12 col-xs-12 pull-right my-panel">
    <div class="container-fluid col-md-7 col-sm-12 col-xs-12 pull-left my-panel">
        <div class="row">
            <div class="container-fluid  col-sm-12  pull-left my-panel">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <span class="panel-title">Recent Shares</span>
                    </div>
                    <g:render template="/topic/recentshare" model="[resourceVos: resourceVOs1]"/>
                </div>
            </div>

    </div>
        <div class="row">
            <ls:getTopPost/>
        </div>

</div>

    <div class="container-fluid col-md-5 col-sm-12 col-xs-12 pull-right my-panel">
    <div class="row">
        <g:render template="loginform"/>

    </div>
        <div class="row">
            <g:render template="registerform"/>
        </div>

    </div>


</div>

</body>
</html>