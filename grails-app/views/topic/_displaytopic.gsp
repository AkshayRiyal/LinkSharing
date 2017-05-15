<!--Trending Posts-->

<div class="panel-body">

    <g:each in="${topics}" var="topic">
        <div class="row well">
            <div class="col-sm-3">
                <asset:image src="user_img_default.png" class="user_img"/>
            </div>
            %{--   point to check--}%
            <div class="col-sm-7">
                <div class="row">
                    <div class="col-sm-6"><a href="/user/profile?userId=${topic.createdBy.id}"><h4>${topic.createdBy.fullName}</h4></a></div>

                    <div class="col-sm-4"><h5>Subscriptions</h5></div>

                    <div class="col-sm-2"><h5>Posts</h5></div>
                </div>

                <div class="row">
                    <div class="col-sm-6"><h5>@${topic.createdBy.userName}</h5></div>

                    <div class="col-sm-4"><h6><ls:getSubscriptionCount topicId="${topic.id}"/></h6>
                    </div>

                    <div class="col-sm-2"><h6><ls:getPostCount topicId="${topic.id}"/></h6></div>

                </div>

            </div>

            <div class="col-sm-2">
                <div class="row">
                    <div class="col-sm-12"><a href="/topic/show?topicId=${topic.id}"><h5><u>${topic.name}</u></h5></a>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-12">
                        <h5><ls:showSubscribe topicId="${topic.id}"/></h5>

                    </div>
                </div>

            </div>
            <ls:canEdit topic="${topic}"/>
        </div>

    </g:each>
</div>

%{--

        <div class="col-sm-3">
            <h5>${topic.createdBy.fullName}</h5>
            <h6>@${topic.createdBy.userName}</h6>
            <ls:showSubscribe topicId="${topic.id}"/>
        </div>

        <div class="col-sm-3">
            <h1></h1>

            <h1></h1>
            <h5>Subscriptions</h5>
            <h6><ls:getSubscriptionCount topicId="${topic.id}"/></h6>

        </div>

        <div class="col-sm-3">
            <a href="/topic/show?topicId=${topic.id}"><h5><u>${topic.name}</u></h5></a>
            <h5>Posts</h5>
            <h6><ls:getPostCount topicId="${topic.id}"/></h6>

        </div>
--}%

