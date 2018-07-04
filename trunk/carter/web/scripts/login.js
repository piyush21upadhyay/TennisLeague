var enterCityHtml	= "";
var signupCityHtml	= "";

$(document).ready(
	function() {
		$("#error-msg").css("display","none");
		
		var userValCookie = getCookie("REMEMBER_ME_COOKIE");
		
		if (userValCookie != null && userValCookie != "") {
			document.getElementById("j_username").value = userValCookie;
			document.getElementById("rememberMe").checked = "checked";
		}

		$.ajax({
			type : "GET",
			url : "choosecity.html?format=xml",
			dataType : "xml",
			success : parseCityXml,
			cache : false,
			async : false
		});

		function parseCityXml(xml) {
			var enterCityObject = $("#enter-city");
			var signupCityObject = $("#signup-city");

			$(xml)
					.find("city")
					.each(
							function() {
								isActive = false;
								if ($(this).find("active").text() == 'true')
									isActive = true;

								if (isActive) {
									enterCityHtml += "<li><a style='width:0px;opacity:0;' href='choosecity.html?id="
											+ $(this).find("id")
													.text()
											+ "&target=home.html'>"
											+ $(this).find("name")
													.text()
											+ "</a></li>";
									signupCityHtml += "<li><a style='width:0px;opacity:0;' href='choosecity.html?id="
											+ $(this).find("id")
													.text()
											+ "&target=signup.html'>"
											+ $(this).find("name")
													.text()
											+ "</a></li>";
								} else if (!isActive) {
									inActiveTxt = $(this).find(
											"inactiveMessage")
											.text();
									enterCityHtml += "<li><a style='width:0px;opacity:0;' href='javascript:void(0)' onmouseover='javascript:this.innerHTML = &#39;"
											+ inActiveTxt
											+ "&#39;;' onmouseout='javascript:this.innerHTML = &#39;"
											+ $(this).find("name")
													.text()
											+ "&#39;;'>"
											+ $(this).find("name")
													.text()
											+ "</a></li>";
									signupCityHtml += "<li><a style='width:0px;opacity:0;' href='javascript:void(0)' onmouseover='javascript:this.innerHTML = &#39;"
											+ inActiveTxt
											+ "&#39;;' onmouseout='javascript:this.innerHTML = &#39;"
											+ $(this).find("name")
													.text()
											+ "&#39;;'>"
											+ $(this).find("name")
													.text()
											+ "</a></li>";
								}
							});

			enterCityObject.html(enterCityHtml);
			signupCityObject.html(signupCityHtml);
		}

		//forgot password
		$("#forgot-lnk").click(function() {
			var objUserName = $("#j_username");

			if (objUserName.val().length == 0) {
				$("#error-msg").html("You need to enter your username.");
				$("#error-msg").css("display", "block");
			} else {
				urlTxt = "passwordHint.html?username="
						+ objUserName.val();

				$.ajax({
					url : urlTxt,
					cache : false,
					async : false,
					success : function(response) {
						var ajaxResMsg = $(response).filter('#ajaxResMsg').html(); 
						$("#error-msg").html(ajaxResMsg);
						$("#error-msg").css("display", "block");
					}
				});
			}
		});
	});
//end of the home page.

$(document).ready(function() {
	var beep = $("#beep")[0];
	/*---// Beep for signup-city //---*/
	$("#signup-city li a").mouseover(function() {
		try
		{
			beep.play();
		}
		catch(exp)
		{}
	});
	/*---// Beep for enter-city //---*/
	$("#enter-city li a").mouseover(function() {
		try
		{
			beep.play();
		}
		catch(exp)
		{}
	});
});

function setUserValues(objForm) {
	var objCheck = document.getElementById("rememberMe");
	var userName = document.getElementById("j_username");
	
	if(objCheck=="" && userName=="")
			$("#error-msg").html("Please Enter Proper Credentials");
	
	if(objCheck.checked)
	{
		var cookieContent = getCookie("REMEMBER_ME_COOKIE");
		
		if (userName.value.length > 0) {
			setCookie("REMEMBER_ME_COOKIE", userName.value, (365 * 5));
		}
	}
	else
	{
		if (getCookie("REMEMBER_ME_COOKIE") != null)
			setCookie("REMEMBER_ME_COOKIE", "", -1);
	}
}

function setCookie(c_name,value,exdays)
{
	var exdate = new Date();
	exdate.setDate((exdate.getDate() - 1) + exdays);
	var c_value = escape(value)
			+ ((exdays == null) ? "" : "; expires="
					+ exdate.toUTCString());
	document.cookie = c_name + "=" + c_value;
}

function getCookie(c_name)
{
	var i, x, y, ARRcookies = document.cookie.split(";");
	
	for (i = 0; i < ARRcookies.length; i++) {
		x = ARRcookies[i].substr(0, ARRcookies[i]
				.indexOf("="));
		y = ARRcookies[i]
				.substr(ARRcookies[i].indexOf("=") + 1);
		x = x.replace(/^\s+|\s+$/g, "");
		if (x == c_name) {
			return unescape(y);
		}
	}
}
