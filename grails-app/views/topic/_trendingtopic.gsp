<!--Trending Posts-->

<div class="container-fluid col-md-5 col-sm-12 col-xs-12 pull-left my-panel">

    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Trending Topics</span>
        </div>

        <div class="panel-body">

                <g:each in="${trendingTopics}" var="topic">
                    <div class="row well">
                        <div class="col-sm-3">
                          <asset:image src="user_img_default.png" class="user_img"/>
                        </div>

                        <div class="col-sm-3">
                            <h5>${topic.createdBy.fullName}</h5>
                            <h6>@${topic.createdBy.userName}</h6>
                            <a href="#"><p class="post-option">Subscribe</p></a>
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
                            <h6><ls:getPostCount topicId="${topic.id}"/> </h6>

                        </div>
                    </div>
                    <hr/>
                </g:each>
        </div>
    </div>
</div>
