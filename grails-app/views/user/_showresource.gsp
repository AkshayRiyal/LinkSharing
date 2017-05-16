<%@ page import="java.text.SimpleDateFormat; com.ttn.linksharing.User" %>

<div class="panel-body">

<!--FOr User Image,topic ,rating-->
    <g:if test="${msgList}">
        <g:each in="${msgList}" var="msg">
            <div class="row well myResource">
                <div class="col-sm-3">
                    <div class="row">
                        <div class="col-sm-12">
                            <ls:userImage userId="${msg.createdBy.id}"/>
                        </div>
                    </div>

                    <div class="row" style="margin-top:10px">
                        <div class="col-sm-12">
                            <div class="col-sm-4">
                                <img src="http://vignette1.wikia.nocookie.net/logopedia/images/f/fb/Facebook_icon_2013.svg"
                                     height="15" width="15">
                            </div>

                            <div class="col-sm-4">
                                <img src="https://upload.wikimedia.org/wikipedia/commons/f/f3/Twitter_icon.png"
                                     height="15px"
                                     width="15px">
                            </div>

                            <div class="col-sm-4">
                                <img src="https://upload.wikimedia.org/wikipedia/commons/e/ed/Google_Plus_icon.svg"
                                     height="15px" width="15px">
                            </div>

                        </div>
                    </div>

                    <div class="row " style="margin-top:10px">
                        <div class="col-sm-12">
                            <ls:isSubscribed resourceId="${msg.id}">

                                <div class="dropdown">
                                    <button class="btn btn-default dropdown-toggle" type="button"
                                            data-toggle="dropdown">Rate
                                        <span class="caret"></span></button>
                                    <ul class="dropdown-menu">
                                        <li><a href="#" onclick="insertRating(${msg.id}, 1)">1</a></li>
                                        <li><a href="#" onclick="insertRating(${msg.id}, 2)">2</a></li>
                                        <li><a href="#" onclick="insertRating(${msg.id}, 3)">3</a></li>
                                        <li><a href="#" onclick="insertRating(${msg.id}, 4)">4</a></li>
                                        <li><a href="#" onclick="insertRating(${msg.id}, 5)">5</a></li>
                                    </ul>
                                </div>
                            </ls:isSubscribed>
                        </div>
                    </div>
                </div>

                <div class="col-md-9">
                    <div class="row">
                        <div class="col-sm-3">
                            <a href="/user/profile?userId=${msg.createdBy.id}"><h5>${msg.createdBy.fullName}</h5></a>
                        </div>

                        <div class="col-sm-3">
                            <h6>@${msg.createdBy.userName}</h6>
                        </div>

                        <div class="col-sm-3">

                            <g:link controller="topic" action="show"
                                    params="[topicId: msg.topic.id]"><h6>${msg.topic.name}</h6></g:link>

                        </div>

                        <div class="col-sm-3">
                            <ls:getResourceCount resourceId="${msg.id}"/>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col-sm-12">
                            <p>
                                ${msg.description}
                            </p>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-sm-1">
                            <ls:isResourceEditable resource="${msg}"/>
                        </div>

                        <div class="col-sm-2">
                            <ls:isResourceDeletable resource="${msg}"/>
                        </div>

                        <div class="col-sm-3">
                            <g:if test="${msg.class.toString() == 'class com.ttn.linksharing.DocumentResource'}">
                                <g:link controller="documentResource" action="download"
                                        params="[resourceId: msg.id]"><p class="post-option">Download</p></g:link>
                            </g:if>

                            <g:if test="${msg.class.toString() == 'class com.ttn.linksharing.LinkResource'}">
                                <a href="${msg.url}"><p class="post-option">View-Site</p></a>
                            </g:if>
                        </div>

                        <div class="col-sm-3">
                            <ls:isResourceRead resourceId="${msg.id}"/>
                        </div>

                        <div class="col-sm-3">
                            <a href="/resource/show/${msg.id}"><p class="post-option">View-Post</p></a>

                        </div>
                    </div>

                    <div class="row">

                        <div class="col-sm-12 resourceEditDiv" style="display: none">

                            <g:form class="form-inline form-group" controller="resource" action="update">
                            <div class="col-sm-6">  <textarea cols="20"name="newDescription">${msg.description}</textarea></div>
                                <input type="hidden" name="resourceId" value="${msg.id}">
                                <div class="col-sm-2">  <input type="submit" value="Update"></div>


                            </g:form>

                        </div>

                    </div>
                </div>

            </div>

        </g:each>
    </g:if>
</div>

