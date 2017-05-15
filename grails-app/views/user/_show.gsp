<%@ page import="com.ttn.linksharing.User" %>

<div class="panel-body">
<!--FOr User Image,topic ,rating-->
    <g:each in="${userList}" var="user">

        <div class="row well">
            <div class="col-sm-3">
                <asset:image src="user_img_default.png" class="user_img"/>
            </div>

            <div class="col-sm-9">
                <div class="row">
                    <div class="col-sm-12">
                       <a href="/user/profile?userId=${user.id}"><h4>${user.fullName}</h4></a>

                    </div>
                </div>
                <div class="row">
                    <div class="col-sm-12">
                        <h6>@${user.userName}</h6>

                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-6">

                        <h4 >Subscriptions</h4>
                        <h6 >${user.subscriptions.size()}</h6>

                    </div>

                    <div class="col-sm-6">
                        <h4 >Topics</h4>
                        <h6 >${user.topics.size()}</h6>
                    </div>

                </div>

            </div>

        </div>
    </g:each>
</div>

