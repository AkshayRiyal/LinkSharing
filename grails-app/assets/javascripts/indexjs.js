/**
 * Created by akshay on 24/4/17.
 */
function validateLogin()
{
if($('#password').val()==$('#confirmPassword').val())
{
    $(".signup-validation-msg").text()
    return true
}
else
{
   var html=  "<div class='alert alert-danger'> <strong>Passwords</strong> do not match.</div>"
   $(".signup-validation-msg").html(html)
    $('#confirmPassword').focus()
    return false
}
}