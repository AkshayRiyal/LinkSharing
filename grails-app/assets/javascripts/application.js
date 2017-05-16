// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require_tree .
//= require_self
//= require indexjs
function insertRating(rId,score) {
    $.ajax({
        url: "/resourceRating/rate?resourceId="+rId+"&score="+score,
        type: 'GET',
        success: function (resp) {
            $(".jsonSuccess").html("Ratings Update")
            $('.jsonSuccess').addClass('alert alert-success alert-dismissible alert-success-custom');
        },
        error: function(e) {
            $(".jsonError").html("Ratings failed")
            $('.jsonError').addClass('alert alert-danger alert-dismissible alert-success-custom');
        }
    });
}
$(".edit").on('click', function (event) {
    event.stopPropagation();
    event.stopImmediatePropagation();
    $(this).closest('.myTopic').find(".topicEditDiv").show();
});

$(".editResource").on('click', function (event) {
    event.stopPropagation();
    event.stopImmediatePropagation();
    $(this).closest('.myResource').find(".resourceEditDiv").show();
});


if (typeof jQuery !== 'undefined') {
    (function ($) {
        $(document).ajaxStart(function () {
            $('#spinner').fadeIn();
        }).ajaxStop(function () {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}
