<%@ page import="com.ttn.linksharing.vo.ResourceVO;" %>
<!--TOp SHare-->

<div class="container-fluid  col-sm-12 col-xs-12 pull-left my-panel">
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Top Shares</span>

      %{--      <div class="btn-group pull-right" style="margin-top:-1px;">
                <button class="btn btn-xs"
                        style="background-color: transparent;border:1px solid #5bc0de ">Today</button>
                <button class="btn btn-xs dropdown-toggle" data-toggle="dropdown">
                    <span class="caret"></span>
                </button>
                <ul class="dropdown-menu dropdown-menu-right">
                    <li><a href="#">Week</a></li>
                    <li><a href="#">Month</a></li>
                    <li><a href="#">Year</a></li>
                </ul>
            </div>
      --}%  </div>

        <div class="panel-body">
        <!--FOr User Image,topic ,rating-->
            <g:if test="${resourceVOs}">
                <g:each in="${resourceVOs as List<com.ttn.linksharing.vo.ResourceVO>}" var="vo">
                    <div class="row well">
                        <div class="col-sm-3">
                            <asset:image class="user_img" src="user_img_default.png"/>
                        </div>

                        <div class="col-sm-9">
                            <div class="row">
                                <div class="col-sm-4"><h4>${vo.createdBy.firstName} ${vo.createdBy.lastName}</h4></div>

                                <div class="col-sm-3"><h5>@${vo.createdBy.userName}</h5></div>

                                <div class="col-sm-2 pull-right"><a
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
                                         height="10px"
                                         width="10px">
                                    <img src="https://upload.wikimedia.org/wikipedia/commons/e/ed/Google_Plus_icon.svg"
                                         height="10px"
                                         width="10px">
                                </div>

                                <div class="col-sm-3 pull-right">
                                    <a><p style="font-size:small"><u>View Full Post</u></p></a>
                                </div>

                            </div>

                        </div>

                    </div>
                </g:each>
            </g:if>
        </div>

    </div>
</div>



<!--Top SHare Ends-->
