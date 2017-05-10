<%@ page import="com.ttn.linksharing.vo.TopicVO" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>
<body>
<g:render template="/topic/recentshare" model="[resourceVos:resourceVOs1]"/>
<g:render template="loginform" />
<g:render template="registerform"/>
<g:render template="/topic/trendingtopic" model="[resourceVos : resourceVOs]"/>

</body>
</html>