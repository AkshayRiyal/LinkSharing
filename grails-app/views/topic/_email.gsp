<div id="invitation" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Send Invitation</h4>
            </div>
            <g:form class="form-horizontal" controller="topic" action="topicSave">

                <div class="modal-body">


                    <div class="form-group">
                        <label class="control-label col-sm-2" for="email" >Email:</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="email" name="email" placeholder="Email" required>
                        </div>
                    </div>

                    <div class="form-group">

                        <label class="control-label col-sm-2" for="topic" >Visibility:</label>

                        <div class="col-sm-10 ">
                            <select class="form-control" id="topic" name="topic" required>
                                <option value="PUBLIC">TOPIC</option>
                                <option value="PRIVATE">TOPIC</option>

                            </select>
                        </div>
                    </div>

                </div>


                <div class="modal-footer">
                    <g:submitButton type="submit" class="btn btn-default" name="save">Save</g:submitButton>
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancel</button>
                </div>
            </g:form>
        </div>

    </div>
</div>
