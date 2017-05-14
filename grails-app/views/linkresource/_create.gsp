<%@ page import="com.ttn.linksharing.User" %>
<div id="createlink" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Link</h4>
            </div>

            <div class="modal-body">
                <g:form class="form-horizontal" controller="linkResource"
                        action="save">%{-- controller="topic" action="topicSave"--}%

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="link">Link:</label>

                        <div class="col-sm-10">
                            <input type="text" name="link" class="form-control" id="link" placeholder="Enter Link">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="description">Description:</label>

                        <div class="col-sm-10">
                            <input type="text" name="description" class="form-control" id="description"
                                   placeholder="Enter Description">
                        </div>
                    </div>

                    <div class="form-group">

                        <label class="control-label col-sm-2" for="Topic">Topic:</label>

                        <div class="col-sm-10 ">
                            <g:select
                                    from="${User.getSubscribedTopics(com.ttn.linksharing.User.findByUserName(session.user))}"
                                    class="form-control" name="topicId" id="Topic" optionKey="id" optionValue="name">

                            </g:select>
                        </div>
                    </div>

                    <div class="modal-footer">
                        <button type="submit" class="btn btn-default">Share</button>
                        <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                    </div>

                </g:form>
            </div>
        </div>

    </div>
</div>