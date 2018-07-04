<%@ include file="/common/taglibs.jsp"%>

<jsp:useBean id="rand" class="com.sageconsulting.webapp.util.CustomRandBean"/>
<c:set target="${rand}" property="min" value="1"/>
<c:set target="${rand}" property="max" value="4"/>
<c:set target="${rand}" property="random" value="0"/>
<c:set var="vRandom" value='${rand.random}'/>

<c:set target="${rand}" property="min" value="1"/>
<c:set target="${rand}" property="max" value="6"/>
<c:set target="${rand}" property="random" value="0"/>
<c:set var="vTagIndex" value='${rand.random}'/>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="webapp.name" /></title>

<meta http-equiv="X-UA-Compatible" content="IE=EDGE">

<%@ include file="/common/meta.jsp"%>
<script type="text/javascript">
function checkUserPass()
{
	$("#error-msg").css("display","none");
	var x="";
	if(document.getElementById("j_username").value=="" && document.getElementById("j_password").value=="")
	{
		x=x+"please enter your username and password.";
	}
	else if ( document.getElementById("j_username").value=="")
	  {  
	   x=x+"please enter your username.";
      }
	else if(document.getElementById("j_password").value=="")
		{
		x=x+"please enter your password.";
		}
	else 
	  {
	     return true;
	  }
	
	if(x!="")
	{
		$("#error-msg").html(x);
		$("#error-msg").css("display", "block");
		return false;
	}
}
</script>
<script src="http://www.google-analytics.com/urchin.js"	type="text/javascript"></script>
<script type="text/javascript">
	_uacct = "UA-3192845-1";
	urchinTracker();
</script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/grid.css'/>" />
<script type="text/javascript" src="scripts/jquery.min.js"></script>
<script type="text/javascript" src="scripts/login.js"></script>

<script type="text/javascript" src="scripts/intropage.js"></script>

<c:choose>
	<c:when test="${ vRandom eq 3 }">
		<link  rel="stylesheet" type="text/css" href="css/bg_white.css">
	</c:when>
	<c:otherwise>
		<link  rel="stylesheet" type="text/css" href="css/bg_regular.css">
		<style type="text/css">
			#main-container {
				width: 100%;
				height: 100%;
				margin: auto;
				background: #fff url("images/bg_img_<c:out value='${vRandom}'/>.jpg") repeat center top;
				margin-left: -0.5px;
			}
		</style>
	</c:otherwise>
</c:choose>
<!--[if lt IE 9]>
	<script type="text/javascript" src="scripts/html5.js"></script>
<![endif]-->
<!--[if IE 7]>
	<script src="http://ie7-js.googlecode.com/svn/version/2.1(beta4)/IE7.js" type="text/javascript"></script>
	<link rel="stylesheet" href="css/style-IE7.css" type="text/css" media="all" />
<![endif]-->

<style type="text/css">
	/* Safari/Chrome css hack */
	@media screen and (-webkit-min-device-pixel-ratio:0)
	{
		.video-container{margin-top:0px!important;}
		#sampleMovie{margin-top:0px!important;}
	}

	#loading-container{		
		background:#000;
		width:99%;
		height:100%;
		margin:auto;	
		margin-left:-0.5px;
		position: absolute;
		z-index:10000;
	}

	.tagline-p
	{
		font-family: "avantgardemediumbt", "Avant_Garde_Gothic_Demibold", Arial, sans-serif;
		color:#FFFFFF; font-size:20px;
		padding-top:362px; 
		text-align:middle;
	}
</style>

<script type="text/javascript">
	
	$(document).ready(function() {
		var vTglineHT	= 0;
		var vOuterHT	= $("#outer-container").height() / 2;

		if(  vOuterHT > 38 )
			vTglineHT	= vOuterHT - 38;
		$(".tagline-p").css("padding-top", vTglineHT);
		
		if ($.browser.msie) {
			$(".check-txt").css({
				'margin-top' : '-18px'
			});
			$("#login-bottom3").css({
				'padding-left' : '26px',
				clear : 'both'
			});
		}
	});
</script>

</head>
<body>
	<audio id="beep" controls preload="auto" HIDDEN="TRUE" style="display: none !important;">
		<source src="swf/assets/sound/rollover.mp3" type="audio/mpeg" />
		<source src="swf/assets/sound/rollover.wav" type="audio/wav" />
	</audio>
	<div id="outer-container">

		<!--// Loading container //-->
		<div id="loading-container" >
			<c:if test="${vTagIndex eq 1}"><p class="tagline-p">Tour caddy optional</p></c:if>
			<c:if test="${vTagIndex eq 2}"><p class="tagline-p">Get a birdie and the entire internet will know</p></c:if>
			<c:if test="${vTagIndex eq 3}"><p class="tagline-p">We'll post your bragging rights online</p></c:if>
			<c:if test="${vTagIndex eq 4}"><p class="tagline-p">You athletic glory days are in front of you.</p></c:if> 
			<c:if test="${vTagIndex eq 5}"><p class="tagline-p">Prove it</p></c:if>
			<c:if test="${vTagIndex eq 6}"><p class="tagline-p">Start beating new people</p></c:if>
		</div>

		<div id="main-container">
			<div id="main">
				<header>
					<h3 id="enter-lnk" onclick="_jqNavLinks(1);">ENTER SITE</h3>
					<img class="separator" src="images/separator_bg.png">
					<h3 id="signup-lnk" onclick="_jqNavLinks(2);">SIGN UP</h3>
					<img class="separator" src="images/separator_bg.png">
					<h3 id="login-lnk" onclick="_jqNavLinks(3);">LOG IN</h3>
					<img class="separator" src="images/separator_bg.png">
					<h3 id="video-lnk" onclick="_jqNavLinks(4);">VIEW DEMO</h3>
				</header>
				<div id="logo">
		        	<img src="images/logo.png" alt="">
				</div>
				
				<div class="clear"></div>

				<div id="site_content">
					<div class="sidebar-menu">
						<nav id="nav-common" style="height:0px;width:0px;" class="menubg flt" >
							<ul id="sidemenu-fixed" class="menu flt">
								<!-- Dynamic contents -->
							</ul>

							<div id="login-box" style="display:none;">
								<!--<div class="login-txt">Log in</div>-->
								<form method="get" style="padding-right:5px;" class="signin" onsubmit="setUserValues(this);" action="j_security_check">
									<fieldset class="textbox">
										<label class="username">
											<span id="error-msg"></span>
										</label>
										<div>
											<input id="j_username" name="j_username" type="text"
												autocomplete="off" placeholder="ENTER USERNAME"
												onfocus="javascript:this.placeholder='';"
												onblur="javascript:this.placeholder='ENTER USERNAME';" style="margin-bottom:4px;float:left;">

											<div class="clear"></div>

											<input id="j_password"
												name="j_password" type="password" placeholder="ENTER PASSWORD"
												onfocus="javascript:this.placeholder='';"
												onblur="javascript:this.placeholder='ENTER PASSWORD';" style="float:left;">
										</div>
										
										<div id="login-bottom1" style="height: 24px; width:360px; display:block;">
											<button class="submit button" type="submit" style="float:right; margin-top:6px;" onclick="return checkUserPass();"></button>
										</div>
										<div id="login-bottom2" style="height:30px;display:block;margin-top:17px;">
											<span style="text-align:left; float:left; width:115px; color:#FFFFFF; position:relative; top:10px; font-weight:bold;">
												<input type="checkbox" name="rememberMe" id="rememberMe" value="true" style="width:10px; margin-right:4px; margin-top:3px;">
												<label class="check-txt" for="rememberMe">Remember me</label>
											</span>
										</div>
										
										<input type="hidden" id="fname" value=""/>
										<p id="login-bottom3">
											Forgotten your password? Click <a id="forgot-lnk" class="forgot" href="javascript:void(0)">here</a>
										</p>
									</fieldset>
								</form>
							</div>
	
							<div id="enter-box" style="display:none;">
								<!--<div class="enter-txt">Enter site</div>-->
								<p class="par-txt">To enter City Golf League, please choose the city you'd like to view from the list below:</p>
								<ul id="enter-city" class="submenu flt"></ul>
							</div>
	
							<div id="signup-box" style="display:none;">
								<!--<div class="signup-txt">Sign up</div>-->
								<p class="par-txt">Welcome to City Golf League, please select your city from the bellow:</p>
								<ul id="signup-city" class="submenu flt"></ul>
							</div>
						</nav>
					</div>
					
					<div id="demo-box" class="video-container">
						<div id="btn_close_video" class="btn_close" title="Close" onclick="_jqAutoCloseVideoPop(4);"></div>
						<video id="sampleMovie" width="890"
							controls="controls"
							preload="auto"
							onended="_jqListenVideoPop();"
							onclick="_jqNavToSignup();">
							<source src="swf/assets/demo/demo.m4v" type="video/mp4" />
							<source src="swf/assets/demo/demo.ogv" type="video/ogg" />
						</video>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
