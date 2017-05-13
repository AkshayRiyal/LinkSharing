<div class="panel-body">

    <g:form class="form-horizontal" controller="user" action="updateInfo"  method="post">
        <div class="form-group">
            <label for="firstName" class="col-sm-2 control-label"><p align="left">FirstName</p></label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="fname" pattern="[A-Za-z]{5,15}" title="Alphabets only.Range 5-15" maxlength="20"s value="${userList.get(0).firstName}" id="firstName" placeholder="FirstName" required>
            </div>
        </div>

        <div class="form-group">
            <label for="lastName" class="col-sm-2 control-label"><p align="left">LastName</p></label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="lname" pattern="[A-Za-z]{5,15}" title="Alphabets only.Range 5-15" maxlength="20" id="lastName" value="${userList.get(0).lastName}" placeholder="LastName" required>
            </div>
        </div>
        <div class="form-group">
            <label for="userName" class="col-sm-2 control-label"><p align="left">UserName</p></label>
            <div class="col-sm-10">
                <input type="text" class="form-control" name="uname" id="userName" value="${userList.get(0).userName}" pattern=".{5,20}" title="Range 5-20." maxlength="20"  placeholder="FirstName" required>
            </div>
        </div>
        <div class="form-group">
            <label for="profileImage" class="col-sm-2 control-label"><p align="left">Photo</p></label>
            <div class="col-sm-10">
                <input type="file" class="form-control" id="profileImage" placeholder="FirstName">
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