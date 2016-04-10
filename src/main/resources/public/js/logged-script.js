$(document).ready(function () {
    $.getJSON("/loggedUserId", function (data) {
        if (data.hasOwnProperty("userId")) {
            // login/user div display
            $('.login-menu .dropdown-toggle').css('display', 'none');
            $(".user-menu .dropdown-toggle").css("display", "block");
            //
        } else {
            // login/user div display
            $('.login-menu a').html('Sign In');
            $('.login-menu .dropdown-toggle').css('display', 'block');
            $(".user-menu .dropdown-toggle").css("display", "none");
        }
    });


});

// Sign out


// Sign in
$('.btn.btn-primary.btn-block.btn-flat').on("click", function () {
    var userAccount = $('#sign-in-userAccount').val(),
        password = $('#sign-in-pwd').val();

    if ($(".icheckbox_square-blue").hasClass("checked")) {
        // TODO: add operation.
    }

    if (correctEmail(userAccount)) {
        $.getJSON("/login", function (data) {
            if (data.hasOwnProperty('status')) {
                $("#info-message-container").css("margin-top", "-30px");
                $("#info-message").html(data.status);
                window.location = '/index';
            }
        });
    }

});

function correctEmail(userAccount) {
    var RED = "#dd4b39";
    var GREY = "#d2d6de";
    if (!emailValidate(userAccount)) {
        $('#sign-in-userAccount').css("border-color", RED);
        return false;
    } else {
        $('#sign-in-userAccount').css("border-color", GREY);
        return true;
    }
}

function emailValidate(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
