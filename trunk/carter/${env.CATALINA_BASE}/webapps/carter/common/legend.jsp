<%@ include file="/common/taglibs.jsp"%>
<div class="legend">
	<h2><fmt:message key="legend.header"/></h2>
	<div class="stroke-legend">&nbsp;</div><h4><fmt:message key="legend.strokehole"/></h4>
	<div class="clear"></div>
	<c:if test='${param.layout ne "vertical"}'>
	<div class="left">
	</c:if>
		<div class="birdie-legend">&nbsp;</div><h4><fmt:message key="legend.birdie"/></h4>
		<div class="clear"></div>
		<div class="eagle-legend">&nbsp;</div><h4><fmt:message key="legend.eagle"/></h4>
		<div class="clear"></div>
		<div class="dbleagle-legend">&nbsp;</div><h4><fmt:message key="legend.doubleeagle"/></h4>
		<div class="clear"></div>
	<c:if test='${param.layout ne "vertical"}'>
	</div>
	<div class="left">
	</c:if>
		<div class="netbirdie-legend">&nbsp;</div><h4><fmt:message key="legend.netbirdie"/></h4>
		<div class="clear"></div>
		<div class="neteagle-legend">&nbsp;</div><h4><fmt:message key="legend.neteagle"/></h4>
		<div class="clear"></div>
		<div class="netdbleagle-legend">&nbsp;</div><h4><fmt:message key="legend.netdoubleeagle"/></h4>
		<div class="clear"></div>
	<c:if test='${param.layout ne "vertical"}'>
	</div>
	</c:if>
</div>
