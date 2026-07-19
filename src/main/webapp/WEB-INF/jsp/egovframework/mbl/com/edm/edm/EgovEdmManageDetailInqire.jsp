<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<jsp:scriptlet>

	pageContext.setAttribute("crlf", "\r\n");

</jsp:scriptlet>

<!DOCTYPE html>
<html>

	<head>
	
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>지출상세조회 </title>
		
       <link rel="stylesheet" href="${pageContext.request.contextPath}/css/egovframework/mbl/cmm/jquery.mobile-1.4.5.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/egovframework/mbl/cmm/EgovMobile-1.4.5.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/egovframework/mbl/com/uss/ussCommon.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/cmm/jquery-1.11.2.js"></script>
		
		 
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/cmm/jquery.mobile-1.4.5.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/cmm/EgovMobile-1.4.5.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/com/EgovCom.js"></script>
				
        <script type="text/javaScript" language="javascript" defer="defer">
        <!--
			
	        function fn_password_confirm(url, msg) { 
	        
        		jPassword("비밀번호 입력", "알림", "a", function(writngPassword){
					if(writngPassword != null) {
	        			document.detailForm.writngPassword.value = writngPassword;
						
						$.getJSON("${pageContext.request.contextPath}/edm/edm/CnsltPasswordConfirm.mdo", $("#edmManageVO").serialize().replace(/%/g,'%25'), function(json){
							
							if(json.passwordConfirmAt == "Y") { 
			
								document.detailForm.action = url;
								document.detailForm.submit();
								
							}
							else {
			
								jAlert("비밀번호 오류", "알림", "a");
								
							}
							
						});
					}
        		});
			}
		
	        function fn_egov_delete() {
	
				jConfirm('삭제하시겠습니까?', '알림', 'a', function(r) {

					if(r) {
						
						var url = "${pageContext.request.contextPath}/edm/edm/EdmDtlsDelete.mdo";
						//var msg = "삭제";
						//fn_password_confirm(url, msg);

						document.detailForm.action = url;
						document.detailForm.submit();

					}
					
				});
				
			}

			function fn_egov_updt_confirm() {

				var url = "${pageContext.request.contextPath}/edm/edm/EdmDtlsUpdtView.mdo";
				//var msg = "수정";
				//fn_password_confirm(url, msg);
				
				document.detailForm.action = url;
				document.detailForm.submit();
			}

			function fn_showList() {
				
				document.detailForm.action = "${pageContext.request.contextPath}/edm/edm/EgovEdmManageListInqire.mdo";
				document.detailForm.submit();
				
			}
			
		-->
        </script>
        
	</head>
	
	<body>
		
		<!-- View start -->
		<div id="view" data-role="page">
						
				<!-- header start -->
				<div data-role="header">
				    <a href="javascript:fn_showList();" data-icon="arrow-l" data-ajax="false">뒤로</a>
				    <h1 id="viewTitle">지출상세조회</h1>
				</div>
				<!-- header end -->
				
				<!-- contents start -->
				<div data-role="content" class="com-copContent">
					<form:form modelAttribute="edmManageVO" name="detailForm" method="post">
						
						<!-- searchVO start -->
						<form:hidden path="searchCondition" value="${searchVO.searchCondition}"/>
						<form:hidden path="searchKeyword" value="${searchVO.searchKeyword}"/>
						<form:hidden path="pageIndex" value="${searchVO.pageIndex}"/>
						<!-- searchVO end -->
						
						<form:hidden path="expenseId" value=""/>
						
						<div class="qus">
							<span class="ic_result">지출상세</span>
							<strong><label for="name-d"><c:out value="${edmManageVO.mberNm}"/></label></strong>
							<p><label for="name-d"><c:out value="${edmManageVO.categoryNm}"/></label></p>
							<span class="time">
							금맥&nbsp;<span class="uss-txtBlack"><fmt:formatNumber value="${edmManageVO.amount}" pattern="#,###" /></span>
							<span class="uss-txtBlack"><c:out value="${edmManageVO.expenseDt}"/></span>
							<span class="uss-txtBlack"><c:out value="${edmManageVO.expenseTm}"/></span>
							내용&nbsp;<span class="uss-txtCommon">${fn:replace(edmManageVO.expenseNote , crlf , '<br/>')} </span>
							</span>
						</div>
												
						<div class="ui-grid-b">
							<div class="ui-block-a"><a href="javascript:fn_egov_updt_confirm()" data-role="button" data-theme="b" data-ajax="false">수정</a></div>
							<div class="ui-block-b"><a href='javascript:fn_egov_delete()' data-role="button" data-theme="b">삭제</a></div>
							<div class="ui-block-c"><a href='javascript:fn_showList();' data-role="button" data-theme="b">목록</a></div>
						</div>
						
					</form:form>
				</div>
				<!-- contents end -->
				
				<!-- footer start -->
				<div data-role="footer" data-position="fixed">
					<h4>Copyright (c) MINISTRY OF SECURITY AND PUBLIC ADMINISTRATION.</h4>
				</div>
				<!-- footer end -->
						
								
		</div>
		<!-- view end -->
		
	</body>
	
</html>

