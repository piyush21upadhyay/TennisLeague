/*
	- Author		: Muhammad Nasim
	- FileName		: intropage.js
	- Date			: 11 March, 2013
	- Target		: CityGolfLeague
	- Description	: Main JS file for intro page.	
*/

/*---// Global declaration //---*/
var vGlobalNav		= 0;
var vBackgroundImg	= "";
var vBoxID			= 0;
var vActiveBoxID	= 0;
var vVideoPlayStat	= 0;
var vCityBoxHT		= 0;

/*---// Startup on load //---*/
$(document).ready(function() {
	/*---// Fade loading page //---*/	
	setTimeout('jqLoadingPage();', 1500);	
});

/*---// Loading animation //---*/
function jqLoadingPage()
{
	/*---// Initial setup //---*/
	setTimeout('_jqSetHeight();', 100);	

	/*---// Play beep once //---*/	
	//setTimeout('_jqPlayBeep();', 200);	

	$("#loading-container").fadeOut(1500, function(){
		/*---// Start Animation //---*/	
		setTimeout('jqAnimateMainBox();', 200);
	});
}

/*---// Main box animation //---*/
function jqAnimateMainBox()
{
	var vPageID		= _jqCheckPage();
	vVideoPlayStat	= 0;

	if( vPageID > 0 )
		_jqHandleCustomeBox(vPageID);
	else
	{
		$("#nav-common").css({height:'0px', width:'0px'});
		$("#nav-common").animate({
				height	: '204px',
				width	:'398px'
			}, 1000,
			function(){
				jqAddMainBoxItem();
			}
		);
	}
}

/*---// Main box childlren //---*/
function jqAddMainBoxItem()
{
	$("#sidemenu-fixed").empty().html('<li id="nav-common-1" onclick="_jqHandleBoxes(1);" class=""></li><li id="nav-common-2" onclick="_jqHandleBoxes(2);" class=""></li><li id="nav-common-3" onclick="_jqHandleBoxes(3);" class=""></li><li id="nav-common-4" onclick="_jqHandleBoxes(4);" class=""></li>');
	setTimeout('jqAnimateMainBoxItem();', 300);
}

/*---// Main box childlren items //---*/
function jqAnimateMainBoxItem()
{
	$('<a style="width:0px;" href="javascript:void(0)" title="Enter site">Enter site</a>').appendTo($("#nav-common-1").empty()).animate({width:'373px'},300);
	$('<a style="width:0px;" href="javascript:void(0)" title="Sign up">Sign up</a>').appendTo($("#nav-common-2").empty()).animate({width:'373px'},600);
	$('<a style="width:0px;" href="javascript:void(0)" title="Log in">Log in</a>').appendTo($("#nav-common-3").empty()).animate({width:'373px'},900);
	$('<a style="width:0px;" href="javascript:void(0)" title="View Demo">View Demo</a>').appendTo($("#nav-common-4").empty()).animate({width:'373px'},1200);
}

/*---// Top navigations //---*/
function _jqNavLinks( id )
{
	if( vVideoPlayStat == 1 )
		_jqAutoCloseVideoPop(0);

	if( vActiveBoxID > 0 )
	{
		if( id != vActiveBoxID)
		{
			_jqResetLinkCSS(id);
			vBoxID			= id;
			_jqUpdateBoxItem(id);
		}
	}
	else
		_jqHandleBoxes( id );		
}

/*---// Handle boxes //---*/
function _jqHandleBoxes( id )
{
	$("#error-msg").css("display","none");	

	if( vActiveBoxID > 0 )
	{
		_jqResetLinkCSS(0);
		_jqReverseBoxes();
	}
	else
	{
		_jqResetLinkCSS(id);
		vActiveBoxID	= 0;
		vBoxID			= id;
		$("#nav-common-" + id).children("a").addClass("box-header");
	
		_jqHandleMainBox(id);		
	}
}

/*---// Middle animation //---*/
function _jqHandleMainBox( id )
{
	for( var i = 1; i <= 4; i++ )
	{
		if( i != id )
		{
			$("#nav-common-" + i).children("a").animate({ width: '0px', opacity: '0.0' }, 500, function() {				
				$(this).parent().remove();
			});
		}
	}
	setTimeout('_jqAddBoxContents();', 500);
}

/*---// Box contents //---*/
function _jqAddBoxContents()
{
	if( (vBoxID == 1) || (vBoxID == 2) || (vBoxID == 3) || (vBoxID == 4) )
		vActiveBoxID	= vBoxID;
	else
		vActiveBoxID	= 0;

	if( vBoxID == 1 )
	{
		/*---// Enter site //---*/
		$("#nav-common").animate({height:vCityBoxHT+'px',width:'398px'}, 500);
		var $vEntCityLis = $("#enter-city").children("li");
		$("#enter-box").show();
		$vEntCityLis.each(function( index ){
			$(this).children("a").css({width:'0px', opacity:0}).delay(index * 200).animate({width:'360px', opacity:1}, 300);
		});
	}
	else if( vBoxID == 2 )
	{
		/*---// Signup //---*/
		$("#nav-common").animate({height:vCityBoxHT+'px',width:'398px'}, 500);
		$("#signup-box").show();
		var $vSignupLis = $("#signup-city").children("li");
		$vSignupLis.each(function( index ){
			$(this).children("a").css({width:'0px', opacity:0}).delay(index * 200).animate({width:'360px', opacity:1}, 300);
		});
	}
	else if( vBoxID == 3 )
	{
		/*---// Login //---*/
		$("#nav-common").animate({height:'204px',width:'398px'}, 500);
		$("#login-box").show();
		$("#j_username").css({width:'0px', opacity:0}).animate({width:'368px', opacity:1}, 500);
		$("#j_password").css({width:'0px', opacity:0}).delay(200).animate({width:'368px', opacity:1}, 500);
		$("#login-bottom1").css({opacity:0}).delay(600).animate({opacity:1}, 300);
		$("#login-bottom2").css({opacity:0}).delay(600).animate({opacity:1}, 300);
		$("#login-bottom3").css({opacity:0}).delay(600).animate({opacity:1}, 300);
	}
	else if( vBoxID == 4 )
	{
		/*---// Video //---*/
		$("#nav-common").animate({height:'204px'}, 500);
		_jqHandleDemoBox();
	}
}

/*---// Reverse main box //---*/
function _jqReverseBoxes()
{
	if( vActiveBoxID <= 0 )
		return;
	
	$("#nav-common-" + vActiveBoxID).children("a").removeClass("box-header");
	$("#nav-common").animate({height:'204px'}, 500);

	_jqReversMainBoxItem();
}

/*---// Reverse item //---*/
function _jqReversMainBoxItem()
{
	if( vActiveBoxID == 1 )
	{
		/*---// Enter site //---*/
		$("#enter-box").hide();
		$('<li id="nav-common-2" onclick="_jqHandleBoxes(2);" class=""></li><li id="nav-common-3" onclick="_jqHandleBoxes(3);" class=""></li><li id="nav-common-4" onclick="_jqHandleBoxes(4);" class=""></li>').appendTo($("#sidemenu-fixed"));
		$('<a style="width:0px;" href="javascript:void(0)" title="Sign up">Sign up</a>').appendTo($("#nav-common-2").empty()).animate({width:'373px'},600);
		$('<a style="width:0px;" href="javascript:void(0)" title="Log in">Log in</a>').appendTo($("#nav-common-3").empty()).animate({width:'373px'},900);
		$('<a style="width:0px;" href="javascript:void(0)" title="View Demo">View Demo</a>').appendTo($("#nav-common-4").empty()).animate({width:'373px'},1200);
	}
	else if( vActiveBoxID == 2 )
	{
		/*---// Signup //---*/
		$("#signup-box").hide();
		$('<li id="nav-common-1" onclick="_jqHandleBoxes(1);" class=""></li>').prependTo($("#sidemenu-fixed"));
		$('<li id="nav-common-3" onclick="_jqHandleBoxes(3);" class=""></li><li id="nav-common-4" onclick="_jqHandleBoxes(4);" class=""></li>').appendTo($("#sidemenu-fixed"));

		$('<a style="width:0px;" href="javascript:void(0)" title="Enter site">Enter site</a>').appendTo($("#nav-common-1").empty()).animate({width:'373px'},600);
		$('<a style="width:0px;" href="javascript:void(0)" title="Log in">Log in</a>').appendTo($("#nav-common-3").empty()).animate({width:'373px'},900);
		$('<a style="width:0px;" href="javascript:void(0)" title="View Demo">View Demo</a>').appendTo($("#nav-common-4").empty()).animate({width:'373px'},1200);
	}
	else if( vActiveBoxID == 3 )
	{
		/*---// Login //---*/
		$("#login-box").hide();
		$('<li id="nav-common-1" onclick="_jqHandleBoxes(1);" class=""></li><li id="nav-common-2" onclick="_jqHandleBoxes(2);" class=""></li>').prependTo($("#sidemenu-fixed"));
		$('<li id="nav-common-4" onclick="_jqHandleBoxes(4);" class=""></li>').appendTo($("#sidemenu-fixed"));

		$('<a style="width:0px;" href="javascript:void(0)" title="Enter site">Enter site</a>').appendTo($("#nav-common-1").empty()).animate({width:'373px'},300);
		$('<a style="width:0px;" href="javascript:void(0)" title="Sign up">Sign up</a>').appendTo($("#nav-common-2").empty()).animate({width:'373px'},600);
		$('<a style="width:0px;" href="javascript:void(0)" title="View Demo">View Demo</a>').appendTo($("#nav-common-4").empty()).animate({width:'373px'},1200);
	}
	else if( vActiveBoxID == 4 )
	{
		/*---// Video //---*/
		$("#demo-box").hide();
		$('<li id="nav-common-1" onclick="_jqHandleBoxes(1);" class=""></li><li id="nav-common-2" onclick="_jqHandleBoxes(2);" class=""></li><li id="nav-common-3" onclick="_jqHandleBoxes(3);" class=""></li>').prependTo($("#sidemenu-fixed"));

		$('<a style="width:0px;" href="javascript:void(0)" title="Enter site">Enter site</a>').appendTo($("#nav-common-1").empty()).animate({width:'373px'},600);
		$('<a style="width:0px;" href="javascript:void(0)" title="Sign up">Sign up</a>').appendTo($("#nav-common-2").empty()).animate({width:'373px'},900);
		$('<a style="width:0px;" href="javascript:void(0)" title="Log in">Log in</a>').appendTo($("#nav-common-3").empty()).animate({width:'373px'},1200);
	}

	vActiveBoxID	= 0;
}

/*---// Update box item : top links //---*/
function _jqUpdateBoxItem( id )
{
	if( (id == 1) || (id == 2) || (id == 3) || (id == 4) )
	{
		if( vActiveBoxID == 1 )
			$("#enter-box").hide();
		else if( vActiveBoxID == 2 )
			$("#signup-box").hide();
		else if( vActiveBoxID == 3 )
			$("#login-box").hide();
		else if( vActiveBoxID == 4 )
			$("#demo-box").hide();

		$("#sidemenu-fixed").children("li").children("a").animate({witdh: "0px"}, 300, function(){

			$(this).remove();

			$('<li id="nav-common-'+id+'" onclick="_jqHandleBoxes('+id+');" class="">').appendTo($("#sidemenu-fixed"));
			if( id == 1 )
				$('<a style="width:0px;" href="javascript:void(0)" title="Enter site">Enter site</a>').appendTo($("#nav-common-1").empty()).animate({width:'373px'},300);
			else if( id == 2 )
				$('<a style="width:0px;" href="javascript:void(0)" title="Sign up">Sign up</a>').appendTo($("#nav-common-2").empty()).animate({width:'373px'},300);
			else if( id == 3 )
				$('<a style="width:0px;" href="javascript:void(0)" title="Log in">Log in</a>').appendTo($("#nav-common-3").empty()).animate({width:'373px'},300);
			else if( id == 4 )
				$('<a style="width:0px;" href="javascript:void(0)" title="View Demo">View Demo</a>').appendTo($("#nav-common-4").empty()).animate({width:'373px'},300);

			$("#nav-common-" + id).children("a").addClass("box-header");
			setTimeout('_jqAddBoxContents();', 200);
		});
		vActiveBoxID	= id;	
	}
	else
		vActiveBoxID	= 0;
}

/*---// Reset top link : CSS //---*/
function _jqResetLinkCSS( id )
{
	if( id == 1 )
		$("#enter-lnk").css("color","#89C417");
	else
		$("#enter-lnk").css("color","#ffffff");

	if( id == 2 )
		$("#signup-lnk").css("color","#89C417");
	else
		$("#signup-lnk").css("color","#ffffff");

	if( id == 3 )
		$("#login-lnk").css("color","#89C417");
	else
		$("#login-lnk").css("color","#ffffff");

	if( id == 4 )
		$("#video-lnk").css("color","#89C417");
	else
		$("#video-lnk").css("color","#ffffff");
}

/*---// Check custom page //---*/
function _jqCheckPage()
{
	var vPageID	= 0;
	var x		= location.search;
	var n		= x.replace("?", "");
	var arr		= n.split("&");

	/*---// Iterate URL param //---*/
	for( var s = 0; s < arr.length; s++ )
	{
		var arr2 = arr[s].split("=");
		if( (arr2[0] == 'error') && arr2[1] )
			vPageID = 3;
		else if( (arr2[0] == 'page') && (arr2[1] == '1') )
			vPageID = 31;
		else if( (arr2[0] == 'page') && (arr2[1] == '2') )
			vPageID = 1;
	}
	return vPageID;
}

/*---// Custom box handler //---*/
function _jqHandleCustomeBox( id )
{
	if( (id == 1) || (id == 2) || (id == 3) || (id == 31) )
	{
		$("#nav-common").css({height:'0px', width:'0px'});

		if( id == 1 )
		{
			/*---// Enter site //---*/
			vBoxID		= 1;
			_jqResetLinkCSS(1);
			$("#nav-common").animate({height:vCityBoxHT+'px',width:'398px'}, 500, function(){
				_jqShowCustomBox(1);
			});
		}
		else if( id == 2 )
		{
			/*---// Signup //---*/
			vBoxID		= 2;
			_jqResetLinkCSS(2);
			$("#nav-common").animate({height:vCityBoxHT+'px',width:'398px'}, 500, function(){
				_jqShowCustomBox(2);
			});
		}
		else if( (id == 3) || (id == 31) )
		{
			/*---// Login //---*/
			vBoxID		= 3;
			if( id == 3 )
			{
				$("#error-msg").html("An error occurred, please try again.");
				$("#error-msg").css("display", "block");
			}
			else
				$("#error-msg").css("display","none");

			_jqResetLinkCSS(3);
			$("#nav-common").animate({height:'204px',width:'398px'}, 500, function(){
				_jqShowCustomBox(3);
			});
		}
	}
}

/*---// Custom box item //---*/
function _jqShowCustomBox( id )
{
	if( (id == 1) || (id == 2) || (id == 3) || (id == 4) )
		vActiveBoxID	= id;
	else
		vActiveBoxID	= 0;

	if( id == 1 )
	{
		/*---// Enter site //---*/
		$('<li id="nav-common-1" onclick="_jqHandleBoxes(1);" class="">').appendTo($("#sidemenu-fixed"));
		$('<a style="width:0px;" href="javascript:void(0)" title="Enter site">Enter site</a>').appendTo($("#nav-common-1").empty()).animate({width:'373px'},300);
		$("#nav-common-1").children("a").addClass("box-header");
		var $vEntCityLis = $("#enter-city").children("li");
		$("#enter-box").show();
		$vEntCityLis.each(function( index ){
			$(this).children("a").css({width:'0px', opacity:0}).delay(index * 200).animate({width:'360px', opacity:1}, 300);
		});
	}
	else if( id == 2 )
	{
		/*---// Signup //---*/
		$('<li id="nav-common-2" onclick="_jqHandleBoxes(2);" class="">').appendTo($("#sidemenu-fixed"));
		$('<a style="width:0px;" href="javascript:void(0)" title="Sign up">Sign up</a>').appendTo($("#nav-common-2").empty()).animate({width:'373px'},300);
		$("#nav-common-2").children("a").addClass("box-header");
		$("#signup-box").show();
		var $vSignupLis = $("#signup-city").children("li");
		$vSignupLis.each(function( index ){
			$(this).children("a").css({width:'0px', opacity:0}).delay(index * 200).animate({width:'360px', opacity:1}, 300);
		});
	}
	else if( id == 3 )
	{
		/*---// Login //---*/
		$('<li id="nav-common-3" onclick="_jqHandleBoxes(3);" class="">').appendTo($("#sidemenu-fixed"));
		$('<a style="width:0px;" href="javascript:void(0)" title="Log in">Log in</a>').appendTo($("#nav-common-3").empty()).animate({width:'373px'},300);
		$("#nav-common-3").children("a").addClass("box-header");
		$("#login-box").show();
		$("#j_username").css({width:'0px', opacity:0}).animate({width:'368px', opacity:1}, 500);
		$("#j_password").css({width:'0px', opacity:0}).delay(200).animate({width:'368px', opacity:1}, 500);
		$("#login-bottom1").css({opacity:0}).delay(600).animate({opacity:1}, 300);
		$("#login-bottom2").css({opacity:0}).delay(600).animate({opacity:1}, 300);
		$("#login-bottom3").css({opacity:0}).delay(600).animate({opacity:1}, 300);
	}
	else if( id == 4 )
	{
		/*---// Video //---*/
		//$("#nav-common").animate({height:'204px'}, 500);
	}
}

/*---// Handle 'video demo' box events //---*/
function _jqHandleDemoBox()
{
	var objContainer	= $("#main-container");
	var back			= objContainer.css("background-image");
	objContainer.css("background-image","none");
	objContainer.css("background-color","#000");
	$("#logo img").css("display","none");

	/*---// Set black bg : video start //---*/
	vBackgroundImg = back;
	$(".sidebar-menu").fadeOut(300);
	$(".video-container").css("display","block");
	$("#demo-box").show();
	$("#btn_close_video").css({opacity:0}).delay(500).animate({opacity:1}, 100);

	/*---// Play demo video//---*/
	try
	{
		vGlobalNav		= 0;
		vVideoPlayStat	= 1;
		$('#sampleMovie').get(0).play();
	}
	catch(exp)
	{}
}

/*---// jqListenVideoPop //---*/
function _jqListenVideoPop()
{
	vGlobalNav	= 1;
	setTimeout("if( vGlobalNav == 1 ) _jqAutoCloseVideoPop(4);", 3000);
}

/*---// jqAutoCloseVideoPop //---*/
function _jqAutoCloseVideoPop( id )
{
	_jqCloseVideo();

	if (vBackgroundImg != '')
		$("#main-container").css("background-image", vBackgroundImg);
	else if (vBackgroundImg == '')
		$("#main-container").css("background-image", "url('../images/bg_img_2.jpg')");
	
	$("#logo img").css("display","inline-block");
	$("#sidemenu-fixed").css("display","block");

	if( id == 4 )
	{
		if( vVideoPlayStat === 0 )
			_jqCloseVideo();
		setTimeout('_jqHandleBoxes(4);', 500);
	}
	else if( id == 2 )
	{
		vBoxID		= 2;
		_jqResetLinkCSS(2);
		$("#nav-common-4").remove();
		$("#nav-common").css({height:'0px', width:'0px'});
		$("#nav-common").animate({height:vCityBoxHT+'px',width:'398px'}, 500, function(){
			if( vVideoPlayStat === 0 )
				_jqCloseVideo();
			_jqShowCustomBox(2);
		});
	}
}

/*---// jqCloseVideo //---*/
function _jqCloseVideo()
{
	try
	{
		$('#sampleMovie').get(0).pause();
		$('#sampleMovie').get(0).currentTime = 0;
		vVideoPlayStat	= 0;
	}
	catch(exp){}

	$("#demo-box").hide();
	$(".sidebar-menu").show();
	$("#nav-common").show();
	$("#sidemenu-fixed").show();
}

/*---// jqNavToSignup //---*/
function _jqNavToSignup()
{
	if( vGlobalNav <= 0 )
		return false;
	else
	{
		vGlobalNav	= 0;
		_jqAutoCloseVideoPop(2);
	}
}

/*---// Box height //---*/
function _jqSetHeight()
{
	var vCityCount	= 0;

	try
	{
		vCityCount	= $("#signup-city").children("li").length;
	}
	catch(exp){}

	if( vCityCount > 0 )	
		vCityBoxHT		= 137 + (25 * vCityCount);
	else
		vCityBoxHT		= 204;
	
	if( vCityBoxHT > 600 )
		$("body").css("overflow-y", "auto");
}

/*---// Play beep //---*/
function _jqPlayBeep()
{
	try
	{
		var vAudio = $("#beep")[0];
		vAudio.play();
	}
	catch(exp)
	{}
}

/*---// End of intropage.js //---*/