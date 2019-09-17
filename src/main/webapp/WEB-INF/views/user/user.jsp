<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Jsp-basicLib</title>
<%@include file="../commonJsp/basicLib.jsp" %>
<script>
// 문서 로딩이 완료된 후
$(document).ready(function(){
	//사용자 정보 클릭시 이벤트 핸들러
	$("#regBtn").on("click", function(){
		  
	   $("#frm").submit();
	})
})
</script>
</head>


<body>
	<!-- 가져간다  -->
	<form id="frm" action="${cp}/userModify" method="get">
       <input type="hidden" id="userId" name="userId" value = "${user.userId }"/>
    </form>
	
	<!-- header -->
	<%@include file="../commonJsp/header.jsp" %>
	
	<div class="container-fluid">
		<div class="row">
				
			<div class="col-sm-3 col-md-2 sidebar">
				<!-- left -->
				<%@include file="../commonJsp/left.jsp" %>
			</div>
		
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
		
				<form class="form-horizontal" role="form">
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
						<div class="col-sm-10">
							<label class="control-label">
								<%-- <img src="/jsp${user.realfilename2}"/> --%>
								<img src="${cp }/userPicture?userId=${user.userId}"/>
							</label>
						</div>
					</div>
		
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
						<div class="col-sm-10">
							<%-- <label class="control-label">${user.userId }</label> --%>
							<label class="control-label" data-userId = "${user.userId }">${user.userId }</label>
						</div>
					</div>
		
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
						<div class="col-sm-10">
							<label class="control-label">${user.userNM }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="userNm" class="col-sm-2 control-label">별명</label>
						<div class="col-sm-10">
							<label class="control-label">${user.alias }</label>
						</div>
					</div>
					<div class="form-group">
						<label for="reg_dt" class="col-sm-2 control-label">등록일</label>
						<div class="col-sm-10">
							<label class="control-label">
								<fmt:formatDate value="${user.reg_dt }" pattern="yyyy/MM/dd"/>
							</label>
						</div>
					</div>

					<div class="form-group">
						<label for="pass" class="col-sm-2 control-label">비밀번호</label>
						<div class="col-sm-10">
							<label class="control-label">${user.pass }</label>
						</div>
					</div>

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<!-- <button type="submit" class="btn btn-default">사용자 수정</button> -->
							<button type="button" id = "regBtn" class="btn btn-info">사용자 수정</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
    