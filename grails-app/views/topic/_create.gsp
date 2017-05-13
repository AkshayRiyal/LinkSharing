<div id="createtopic" class="modal fade" role="dialog">
    <div class="modal-dialog">

        <div class="modal-content">

            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Create Topic</h4>
            </div>
            <g:form class="form-horizontal" controller="topic" action="save">

                <div class="modal-body">


                    <div class="form-group">
                        <label class="control-label col-sm-2" for="name" >Name:</label>

                        <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" name="name" placeholder="Enter Name" required>
                        </div>
                    </div>

                    <div class="form-group">

                        <label class="control-label col-sm-2" for="visibility" >Visibility:</label>

                        <div class="col-sm-10 ">
                            <select class="form-control" id="visibility" name="visibility" required>
                                <option value="PUBLIC">PUBLIC</option>
                                <option value="PRIVATE">PRIVATE</option>

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
