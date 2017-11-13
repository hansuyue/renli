<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%
	
	session.removeAttribute("empLoginName");
	
%>

<script type="text/javascript">
	window.top.location.href = 'login.html';
</script>