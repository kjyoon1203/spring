<%@page import="kr.or.ddit.user.model.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<nav class="navbar navbar-inverse navbar-fixed-top">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">JSP/SPRING</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Dashboard</a></li>
				<li><a href="#">Settings</a></li>
				<li><a href="#">Profile</a></li>
				<li><a href="#">Help</a></li>
        		<li><a href="${cp }/logout">Logout</a></li> <!-- 로그아웃 기능 -->
				<li><a href="#">${S_USERVO.userNm}</a></li>
<%-- 			<% User s_user = (User)session.getAttribute("S_USERVO"); %> --%>
				<%-- <li><a href="#">표현식: <%=s_user.getUserNM() %></a></li>
				<li><a href="#">EL(field): ${S_USERVO.userName}</a></li> <!-- field는 getter에서 가져온다 -->
				<li><a href="#">EL(method): ${S_USERVO.getUserNM()}</a></li> --%>
			</ul>
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search...">
			</form>
		</div>
	</div>
</nav>