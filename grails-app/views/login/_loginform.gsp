<!--Login Form-->
<div class="container-fluid  col-sm-12 col-xs-12 pull-right my-panel">

    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title">Login</span>
        </div>
        <div class="panel-body">
            <form class="form-signin" method="post" name="loginForm" action="/login/loginHandler">
                <input type="text" name="username" id="loginEmail" class="form-control" placeholder="User-Name"  maxlength="30" required >
                <input type="password" name="password" id="loginPassword" class="form-control" placeholder="Password" maxlength="15" required style="margin-top: 10px">
                <div class="checkbox">
                    <button class="btn btn-info" type="submit">Sign-in</button>
                    <label>
                        <a href="/login/forgotPassword">Forgot-Password</a>
                    </label>
                </div>
            </form>
            <g:if test="${flash.loginError}">
            <div class="alert alert-danger">
                <strong>Wrong Credentials!</strong> Please check username or password.
            </div>
            </g:if>
        </div>

    </div>
</div>
<!--Login Form Ends-->
