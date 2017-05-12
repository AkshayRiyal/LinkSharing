<div class="container-fluid col-md-6 col-sm-12 col-xs-12 pull-right my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Inbox</span>
        </div>

        <div class="panel-body">

        <!--FOr User Image,topic ,rating-->
            <g:if test="${msgList}">
                <g:each in="${msgList}" var="msg">
   <div class="row well">
                    <div class="row">
                        <div class="col-sm-3">
                            <asset:image src="user_img_default.png" class="user_img"/>
                        </div>

                        <div class="col-sm-3">
                            <h5>${msg.createdBy.fullName}</h5>

                        </div>

                        <div class="col-sm-2">
                            <h6>@${msg.createdBy.userName}</h6>
                        </div>
                        <div class="col-sm-2">
                            <h6>${msg.topic.name}</h6>
                        </div>


                        <div class="col-sm-2">
                            <h6>${msg.dateCreated}</h6>
                        </div>

                    </div>
                    <!--For full Post-->
                    <div class="row post-text">

                        <div class="col-sm-9 pull-right">
                            <p>
                                ${msg.description}
                            </p>

                        </div>
                    </div>

                    <div class="row">

                        <div class="container-fluid col-md-4 pull-left">
                            <div class="row">
                                <div class="col-sm-1">
                                    <img src="http://vignette1.wikia.nocookie.net/logopedia/images/f/fb/Facebook_icon_2013.svg"
                                         height="20" width="20">
                                </div>

                                <div class="col-sm-1">
                                    <img src="https://upload.wikimedia.org/wikipedia/commons/f/f3/Twitter_icon.png"
                                         height="20px"
                                         width="20px">
                                </div>

                                <div class="col-sm-1">
                                    <img src="https://upload.wikimedia.org/wikipedia/commons/e/ed/Google_Plus_icon.svg"
                                         height="20px" width="20px">
                                </div>
                            </div>
                        </div>


                        <div class="container-fluid col-md-6 pull-right">
                            <div class="row">
                                <div class="col-sm-4">
                                    <g:if test="${msg.class.toString() == 'class com.ttn.linksharing.DocumentResource'}">
                                        <a href="#"><p class="post-option">Download</p></a>
                                    </g:if>

                                    <g:if test="${msg.class.toString() == 'class com.ttn.linksharing.LinkResource'}">
                                        <a href="#"><p class="post-option">View-Site</p></a>
                                    </g:if>
                                </div>

                                <div class="col-sm-4">
                                    <ls:isResourceRead resourceId="$msg.id"/>
                                    %{--<a href="/topic/updateRead/${msg.id}"><p class="post-option">Mark-Read</p></a>--}%
                                </div>


                                <div class="col-sm-4">
                                    <a href="#"><p class="post-option">View-Post</p></a>
                                </div>
                            </div>
                        </div>
                    </div>
   </div>

                </g:each>
            </g:if>
        </div>

    </div>
</div>