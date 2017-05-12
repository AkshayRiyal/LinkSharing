<%@ page import="com.ttn.linksharing.vo.TopicVO" %>
<!doctype html>
<html lang="en" class="no-js">
<head>
    <meta name="layout" content="main">

</head>
<body>
<g:render template="inbox" model="[msgList : msgList]"/>
<ls:getTrendingTopic/>
</body>
</html>