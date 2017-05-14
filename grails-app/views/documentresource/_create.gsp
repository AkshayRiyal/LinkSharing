<%@ page import="com.ttn.linksharing.User" %>
<div id="createdocument" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Share Doc</h4>
            </div>

            <div class="modal-body">
                <g:form  enctype="multipart/form-data" class="form-horizontal" controller="documentResource" action="upload">%{-- controller="topic" action="topicSave"--}%

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="document">Link:</label>

                        <div class="col-sm-10">
                            <input type="file" class="form-control" name="document" id="document" required placeholder="Upload Doc">
                        </div>
                    </div>

                    <div class="form-group">
                        <label class="control-label col-sm-2" for="description">Description:</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="description" name="description" required placeholder="Enter Description">
                        </div>
                    </div>


                    <div class="form-group">

                        <label class="control-label col-sm-2" for="Topic">Topic:</label>

                        <div class="col-sm-10 ">
                            <g:select
                                    from="${com.ttn.linksharing.User.getSubscribedTopics(com.ttn.linksharing.User.findByUserName(session.user))}"
                                    class="form-control" name="topicId" id="Topic" optionKey="id" optionValue="name">

                            </g:select>
                        </div>
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