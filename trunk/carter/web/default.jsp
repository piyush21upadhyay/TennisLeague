<%@ include file="/common/taglibs.jsp"%>

<jsp:useBean id="rand" class="com.sageconsulting.webapp.util.CustomRandBean"/>
<c:set target="${rand}" property="min" value="1"/>
<c:set target="${rand}" property="max" value="4"/>
<c:set target="${rand}" property="random" value="0"/>
<c:set var="vRandom" value='${rand.random}'/>

<c:set target="${rand}" property="min" value="1"/>
<c:set target="${rand}" property="max" value="2"/>
<c:set target="${rand}" property="random" value="0"/>
<c:set var="vTagIndex" value='${rand.random}'/>

<!DOCTYPE html>
<html>
<head>
<title><fmt:message key="webapp.name" /></title>
<meta http-equiv="X-UA-Compatible" content="IE=EDGE">
<meta name="viewport" content="width=device-width, minimum-scale=1, maximum-scale=1">
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
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/css/user/bootstrap.min.css'/>" />
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
   			 min-height: 100%;
   		 	margin: auto;
			}
			.tagline-p
	{
		padding-top:222px;
		color:#FFFFFF; 
		 font-size: 100px;
    	line-height: 1;
    	text-align: left !important;
    	font-family:montserrat_exbold, Arial, sans-serif !important; font-weight:800;margin-left:125px;
    	
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
		.video-container{margin-top: 70px!important;}
		#sampleMovie{margin-top:0px!important;}
	}

	#loading-container{		
		/*background:#000;*/
		width:99%;
		height:100%;
		margin:auto;	
		margin-left:-0.5px;
		position: absolute;
		z-index:10000;
	}

	
</style>

<script type="text/javascript">
	
	$(document).ready(function() {
		var vTglineHT	= 0;
		var vOuterHT	= $("#outer-container").height() / 2;

		if(  vOuterHT > 30 )
			vTglineHT	= vOuterHT - 30;
		//$(".tagline-p").css("padding-top", vTglineHT);
		
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
	 <img src="images/bg_img_2.jpg" alt="" class="bg-image">
	<div id="outer-container">
		<!--// Loading container //-->
		<div id="loading-container" >
		<div class="container">
<%-- <c:if test="${vTagIndex eq 3}"><p class="tagline-p">We'll post your bragging rights online</p></c:if>
			<c:if test="${vTagIndex eq 4}"><p class="tagline-p">You athletic glory days are in front of you.</p></c:if> 
			<c:if test="${vTagIndex eq 5}"><p class="tagline-p">Prove it</p></c:if>
			<c:if test="${vTagIndex eq 6}"><p class="tagline-p">Start beating new people</p></c:if>
			<c:if test="${vTagIndex eq 6}"><p class="tagline-p">BEAT SOMEONE NEW</p></c:if> --%>
			<!--NEED TO VIEW THESE TWO PARA ONCE THE PAGE LOAD -->
			<c:if test="${vTagIndex eq 1}"><p class="tagline-p">BEAT <br/> <span class="highlightGreen"> SOMEONE</span> <br/> NEW</p></c:if>
			<c:if test="${vTagIndex eq 2}"><p class="tagline-p">OPEN <span class="highlightGreen">PLAY</span><br/>TENNIS</p></c:if>
			</div>
		</div>

		<div id="main-container">
			<div id="main" class="container">
			<div class="header-section">
			<div class="row">
			<div  class="col-sm-2">
			<div id="logo">
		        	<img src="images/open-tennis-logo.png" alt="">
				</div>
				</div>
				<header class="col-sm-10">
					<h3 id="enter-lnk" onclick="_jqNavLinks(1);">Enter Site</h3>
					<h3 id="signup-lnk" onclick="_jqNavLinks(2);">Sign Up</h3>
					<h3 id="login-lnk" onclick="_jqNavLinks(3);">Login</h3>
					<h3 id="video-lnk" onclick="_jqNavLinks(4);">View Demo</h3>
				</header>
              </div>
                </div>
				<div class="clear"></div>

				<div id="site_content">
					<div class="sidebar-menu">
						<nav id="nav-common" style="height:0px;width:0px;" class="menubg flt" >
							<ul id="sidemenu-fixed" class="menu flt">
								<!-- Dynamic contents -->
							</ul>

							<div id="login-box" style="display:none;">
							<p class="text-left">Welcome to the website</p>
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
												onblur="javascript:this.placeholder='ENTER USERNAME';">

											<div class="clear"></div>

											<input id="j_password"
												name="j_password" type="password" placeholder="ENTER PASSWORD"
												onfocus="javascript:this.placeholder='';"
												onblur="javascript:this.placeholder='ENTER PASSWORD';" style="float:left;">
										</div>
										
									<div class="clear"></div>
										<div class="row">
											<div id="login-bottom2" class="col-sm-5">
											<span style="text-align:left; float:left; width:115px; color:#FFFFFF; position:relative; top:10px; font-weight:bold;">
												<input type="checkbox" name="rememberMe" id="rememberMe" value="true" style="width:10px; margin-right:4px; margin-top:3px;">
												<label class="check-txt" for="rememberMe">Remember me</label>
											</span>
										      </div>
											<div class="col-sm-7">
											<input type="hidden" id="fname" value=""/>
											<p id="login-bottom3">
												<a id="forgot-lnk" class="forgot" href="javascript:void(0)">Forget your password?</a>
											</p>
											   </div>
										</div>
										<div id="login-bottom1">
											<button class="submit button" type="submit"  onclick="return checkUserPass();"> Login</button>
											<div style="clear: both"></div>
											<a id="signup-lnk" onclick="_jqNavLinks(2);">Sign Up</a>
										</div>
										
										
									</fieldset>
								</form>
							</div>
	
							<div id="enter-box" style="display:none;">
								<!--<div class="enter-txt">Enter site</div>-->
								<p class="par-txt">To enter City Tennis League, please choose the city you'd like to view from the list below:</p>
								<ul id="enter-city" class="submenu flt"></ul>
							</div>
	
							<div id="signup-box" style="display:none;">
								<!--<div class="signup-txt">Sign up</div>-->
								<p class="par-txt">Welcome to City Tennis League, please select your city from the bellow:</p>
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
					<div class="homeDefault-socail">
				<div id="links" class="text-right">
		<a class="ie-post-link" onclick="showLink('http://www.facebook.com/pages/City-Golf-League/348284351925121');">
			<i class="fa fa-facebook"></i>
		</a>
		<a class="ie-post-link" onclick="showLink('https://twitter.com/CityGolfLeague');">
			<i class="fa fa-twitter"></i>
		</a>
		<a href="" target="_blank"><i class="fa fa-instagram"></i></a>
	</div>
		</div>
			</div>
		<div id="footer">
		<div class="container">
		<div class="row">
		<div class="col-sm-8 text-left">
		<jsp:include page="/common/footer.jsp"/>
		</div>
		<div class="col-sm-4">
		<span class="copyright">OPEN PLAY TENNIS, LLC &copy; 2018</span>
		</div>
		</div>
		</div>
	</div>
		</div>
	

	</div>

</body>
</html>