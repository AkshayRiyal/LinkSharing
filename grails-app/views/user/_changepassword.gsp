<div class="panel-body">

    <g:form controller="user" action="updatePassword" class="form-horizontal">
        <div class="form-group">
            <label for="password" class="col-sm-2 control-label"><p align="left">Password</p></label>
            <div class="col-sm-10">
                <input type="password" pattern=".{5,15}" id="password" title="range 5-15" class="form-control" id="password" name="password" placeholder="Password" required>
            </div>
        </div>

        <div class="form-group">
            <label for="confirmPassword" class="col-sm-2 control-label"><p align="left">Password</p></label>
            <div class="col-sm-10">
                <input type="password" pattern=".{5,15}"  title="range 5-15" class="form-control" name="confirmPassword" id="confirmPassword" placeholder="Confirm-Password" required>
            </div>
        </div>

        <div class="form-group">
            <label class="col-sm-2 control-label"><p align="left"></p></label>
            <div class="col-sm-10">
                <button type="submit" class="btn btn-info">Update</button>
            </div>
        </div>
    </g:form>

</div>
