
<div class="panel-body">

<!--FOr User Image,topic ,rating-->
    <g:if test="${resource}">

            <div class="row well">
                <div class="row">
                    <div class="col-sm-3">
                        <asset:image src="user_img_default.png" class="user_img"/>
                    </div>

                    <div class="col-sm-3">
                        <a href="/user/profile?userId=${resource.createdBy.id}">    <h5>${resource.createdBy.fullName}</h5></a>

                    </div>

                    <div class="col-sm-2">
                        <h6>@${resource.createdBy.userName}</h6>
                    </div>

                    <div class="col-sm-2">
                        <g:link controller="topic" action="show" params="[topicId:resource.topic.id]" ><h6>${resource.topic.name}</h6></g:link>
                    </div>


                    <div class="col-sm-2">
                        <h6>${resource.dateCreated.format('dd-MM-YYYY HH:mm')}</h6>
                    </div>

                </div>
                <!--For full Post-->
                <div class="row post-text">

                    <div class="col-sm-9 pull-right">
                        <p>
                            ${resource.description}
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
                                <g:if test="${resource.class.toString() == 'class com.ttn.linksharing.DocumentResource'}">
                                    <g:link controller="documentResource" action="download" params="[resourceId:resource.id]"> <p class="post-option">Download</p></g:link>
                                </g:if>

                                <g:if test="${resource.class.toString() == 'class com.ttn.linksharing.LinkResource'}">
                                    <a href="${resource.url}"><p class="post-option">View-Site</p></a>
                                </g:if>
                            </div>

                            <div class="col-sm-4">
                                <ls:isResourceRead resourceId="$resource.id"/>
                                %{--<a href="/topic/updateRead/${msg.id}"><p class="post-option">Mark-Read</p></a>--}%
                            </div>


                        </div>
                    </div>
                </div>
            </div>


    </g:if>
</div>

</div>
</div>