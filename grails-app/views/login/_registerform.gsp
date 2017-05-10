<!--Registeration Form -->
<div class="container-fluid col-md-4 col-sm-12 col-xs-12 pull-right my-panel">

    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Register</span>
        </div>
        <div class="panel-body">
            <form class="form-signup" method="post" onsubmit="return validateLogin()">
                <input type="text" id="firstName" pattern="[A-Za-z]{1,20}" title="Alphabets only." maxlength="20" class="form-control" placeholder="First Name" required  />
                <input type="text" id="lastName" pattern="[A-Za-z]{1,20}" title="Alphabets only." class="form-control" placeholder="Last Name" required style="margin-top: 10px"/>
                <input type="email" id="email" class="form-control" placeholder="Email Address" required style="margin-top: 10px"/>
                <input type="text" id="userName" pattern=".{3,20}" title="min. 3 characters"  maxlength="20" class="form-control" placeholder="User Name" required style="margin-top: 10px"/>
                <input type="password" id="password" class="form-control" placeholder="Password" required style="margin-top: 10px"/>
                <input type="password" id="confirmPassword" class="form-control" placeholder="Confirm Password" required style="margin-top: 10px"/>
                <label class="btn btn-block  btn-default btn-file" style="margin-top: 10px;color:slategray">
                    Choose Profile Photo <input type="file" hidden >
                </label>
                <div class="checkbox">
                    <button class="btn btn-info btn-block" type="submit">Sign-up</button>
                </div>
                <div class="signup-validation-msg">

                </div>
            </form>
        </div>
    </div>
</div>


<!--Registration Form Ends-->
