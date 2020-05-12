<%@ include file="/common/taglibs.jsp"%>

<menu:useMenuDisplayer name="Velocity" config="WEB-INF/classes/cssHorizontalMenu.vm" permissions="rolesAdapter">
<menu:displayMenu name="Welcome"/>
<menu:displayMenu name="Profile"/>
<menu:displayMenu name="Schedule"/>
<menu:displayMenu name="Lookup"/>
<menu:displayMenu name="Courts"/>
<menu:displayMenu name="Standings"/>
<menu:displayMenu name="Playoffs"/>
<menu:displayMenu name="Champions"/>
<menu:displayMenu name="AdminMenu"/>
<hr>
<div class="second-menu">
<menu:displayMenu name="About"/>
<menu:displayMenu name="Rules"/>
<menu:displayMenu name="Contact"/>
<menu:displayMenu name="Cities"/>
</div>
</menu:useMenuDisplayer>