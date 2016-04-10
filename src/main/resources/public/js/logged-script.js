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
$('.login-button').on("click", function () {
    var userEmail = $('#userEmail').val(),
        password = $('#password').val();

    if (correctEmail(userEmail)) {
        $.getJSON("/login", function (data) {
            if (data.hasOwnProperty('status')) {
                $("#info-message-container").css("margin-top", "-30px");
                $("#info-message").html(data.status);
                window.location = '/index';
            }
        });
    }

});

function correctEmail(userEmail) {
    var RED = "#dd4b39";
    var GREY = "#d2d6de";
    if (!emailValidate(userEmail)) {
        $('#userEmail').css("border-color", RED);
        return false;
    } else {
        $('#userEmail').css("border-color", GREY);
        return true;
    }
}

function emailValidate(email) {
    var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
    return re.test(email);
}
