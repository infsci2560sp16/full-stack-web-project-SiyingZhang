/**
 * @author siying
 */

$(document).ready(function(){
	$('#register').click(function() {
		var userName = $(' #userName').val(),
		userEmail = $(' #userEmail').val(),
		pwd1 = $(' #pwd1').val(),
		pwd2 = $(' #pwd2').val();
		
		if(inputValidate(userName, userEmail, pwd1, pwd2)) {
			var data = {
				userName: userName,
				userEmail: userEmail,
				password: pwd1
			};
			$.ajax({
				type: 'POST',
				url: "/register",
				data: data,
				success: function(user, textStatus, jqXHR) {
					$("#err-message-container").css("margin-top", "-30px");
                    $("#err-message").html(user.status);
                    if (user.hasOwnProperty('notExist')) {
                        if (user.notExist) {
                            $.get("/login",data);
                            window.location = '/index';
                        } else {
                            $("#userEmail").val("");
                            $('#pwd1').val("");
                            $('#pwd2').val("");
                        }
                    }
                    else {
                        $('#pwd1').val("");
                        $('#pwd2').val("");
                    }
                },
                error: function (jqXHR, textStatus, errorThrown) {
                },
				dataType: "json"
			});
		}
	});
});

function inputValidate(userName, userEmail, pwd1, pwd2) {
	var allClear = true;
	var Red = "#dd4b39";
	var Gray = "#d2d6de";
	if(userName == "") {
		$(' #userName').css("border-color", Red);
		allClear = false;
	} else {
		$(' #userName').css("border-color", Gray);
	}

	if(!emailValidate(userEmail)) {
		$(' #userEmail').css("border-color", Red);
		allClear = false;
	} else {
		$(' #userEmail').css("border-color", Gray);
	}

	if(pwd1 === "") {
		$(' #pwd1').css("border-color", Red);
		allClear = false;
	} else {
		$(' #pwd2').css("border-color", Gray);
	}

	if(pwd2 === "") {
		$(' #pwd2').css("border-color", Red);
		allClear = false;
	} else {
		$(' #pwd2').css("border-color", Gray);
	}

	if((pwd1 === "" && pwd2 === "") || pwd1 !== pwd2) {
		$('#pwd1').css("border-color", RED);
        $('#pwd2').css("border-color", RED);
        allClear = false;
    } else {
        $('#pwd1').css("border-color", GREY);
        $('#pwd2').css("border-color", GREY);
	}
}

function emailValidate(email) {
	 var re = /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	 return re.test(email);
}