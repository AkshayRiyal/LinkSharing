<div class="panel-body">
<!--FOr User Image,topic ,rating-->
    <g:if test="${resourceVos}">
        <g:each in="${resourceVos as List<com.ttn.linksharing.vo.ResourceVO>}" var="vo">

            <div class="row well">
                <div class="col-sm-3">
                    <asset:image class="user_img" src="user_img_default.png"/>
                </div>

                <div class="col-sm-9">
                    <div class="row">
                        <div class="col-sm-4"><h4>${vo.createdBy.firstName} ${vo.createdBy.lastName}</h4></div>

                        <div class="col-sm-4"><h5>@${vo.createdBy.userName}</h5></div>

                        <div class="col-sm-3 pull-right "><a
                                href="/topic/show?topicId=${vo.topic.id}"><h5>${vo.topic.name}</h5></a></div>
                    </div>

                    <div class="row">
                        <div class="col-sm-12">${vo.description}</div>
                    </div>

                    <div class="row">
                        <div class="col-sm-2">
                            <img src="http://vignette1.wikia.nocookie.net/logopedia/images/f/fb/Facebook_icon_2013.svg"
                                 height="10" width="10">
                            <img src="https://upload.wikimedia.org/wikipedia/commons/f/f3/Twitter_icon.png"
                                 height="10px" width="10px">
                            <img src="https://upload.wikimedia.org/wikipedia/commons/e/ed/Google_Plus_icon.svg"
                                 height="10px" width="10px">
                        </div>

                        <div class="col-sm-3 pull-right">
                            <a href="/resource/show?id=${vo.id}"><p style="font-size:small"><u>View Full Post</u></p>
                            </a>
                        </div>

                    </div>

                </div>
            </div>
        </g:each>
    </g:if>
</div>

