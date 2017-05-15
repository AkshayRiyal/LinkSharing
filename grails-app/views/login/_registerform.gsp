<!--Registeration Form -->
<div class="container-fluid  col-sm-12 col-xs-12 pull-right my-panel">
    <div class="signup-validation-msg">
        <g:if test="${flash.signupError}">
            <div class="alert alert-danger">
                <g:each in="${flash.signupError}"  >
                    <strong> ${it}</strong><br/>
                </g:each>

            </div>
        </g:if>
        <g:if test="${flash.signupMessage}">
            <div class="alert alert-success">
                User registered successfully.
            </div>

        </g:if>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Register</span>
        </div>

        <div class="panel-body">
            <form class="form-signup" action="/login/register" method="post" onsubmit="return validateLogin()">
                <input type="text" name="firstName" pattern="[A-Za-z]{1,20}" title="Alphabets only." maxlength="20"
                       class="form-control" placeholder="First Name" required/>
                <input type="text" name="lastName" pattern="[A-Za-z]{1,20}" title="Alphabets only." class="form-control"
                       placeholder="Last Name" required style="margin-top: 10px"/>
                <input type="email" name="email" class="form-control" placeholder="Email Address" required
                       style="margin-top: 10px"/>
                <input type="text" name="userName" pattern=".{3,20}" title="min. 3 characters" maxlength="20"
                       class="form-control" placeholder="User Name" required style="margin-top: 10px"/>
                <input type="password" name="password" pattern=".{5,15}" id="password" title="range 5-15" class="form-control" placeholder="Password" required
                       style="margin-top: 10px"/>
                <input type="password" name="confirmPassword" id="confirmPassword" pattern=".{5,15}" title="range 5-15" class="form-control" placeholder="Confirm Password"
                       required style="margin-top: 10px"/>
                <label class="btn btn-block  btn-default btn-file" style="margin-top: 10px;color:slategray">
                    Choose Profile Photo <input type="file" hidden>
                </label>

                <div class="checkbox">
                    <button class="btn btn-info btn-block" type="submit">Sign-up</button>
                </div>


            </form>
        </div>
    </div>
</div>


<!--Registration Form Ends-->
