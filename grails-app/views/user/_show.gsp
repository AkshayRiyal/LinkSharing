<%@ page import="com.ttn.linksharing.User" %>
<div class="container-fluid col-md-5 col-sm-12 col-xs-12 pull-left my-panel">
    <!--   <div class="panel panel-default">
           <div class="panel-heading">
               <span class="panel-title">Post</span>
           </div>-->
    <div class="panel-body">
        <!--FOr User Image,topic ,rating-->
<g:each in="${users}" var="user">

    <div class="row">
            <div class="col-sm-5">
                <img class="user_img" src="img/user_img_default.png">
            </div>
            <div class="col-sm-3">
                <h3>${user.fullname}</h3>
                <h6>@${user.userName}</h6>
                <h4>Subscription</h4>
                <h5>50</h5>
            </div>
            <div class="col-sm-4" style="margin-top: 60px">
                <h1></h1>
                <h4>Topics</h4>
                <h5>30</h5>
            </div>
        </div>
</g:each>
    </div>
</div>