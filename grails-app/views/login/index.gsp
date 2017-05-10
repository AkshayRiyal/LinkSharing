<%@ page import="com.ttn.linksharing.vo.TopicVO" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>
<body>
<g:render template="loginform" />
<g:render template="/topic/recentshare"/>
<g:render template="/topic/trendingtopic" model="[topicVOs : topicVOs]"/>
<g:render template="registerform"/>
</body>
</html>