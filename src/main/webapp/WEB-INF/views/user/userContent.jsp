<%@page import="kr.or.ddit.user.model.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<script>
// 문서 로딩이 완료된 후
$(document).ready(function(){
	//사용자 정보 클릭시 이벤트 핸들러
	$("#regBtn").on("click", function(){
		  
	   $("#frm").submit();
	})
})
</script>

<form id="frm" action="${cp}/user/userModify" method="get">
   <input type="hidden" id="userId" name="userId" value = "${user.userId }"/>
</form>
	

<form class="form-horizontal" role="form">
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 사진</label>
		<div class="col-sm-10">
			<label class="control-label">
				<%-- <img src="/jsp${user.realfilename2}"/> --%>
				<img src="${cp }/user/userPicture?userId=${user.userId}"/>
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
			<label class="control-label">${user.userNm }</label>
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


    