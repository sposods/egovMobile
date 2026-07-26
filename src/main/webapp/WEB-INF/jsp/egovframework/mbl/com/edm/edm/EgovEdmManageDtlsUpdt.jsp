<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>

<!DOCTYPE html>

<style type="text/css">
	.layer {display:none; position:fixed; _position:absolute; top:0; left:0; width:100%; height:100%; z-index:100000;}
	.layer_popup { position:absolute; left:10px; top:30px; z-index:10; width:100%; height:100%;}
	.layer_popup #layer_close { position:absolute; z-index:2; right:-2px; top:-2px;}
</style>
<html>

	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<title>지출 수정</title>
		
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/egovframework/mbl/cmm/jquery.mobile-1.4.5.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/egovframework/mbl/cmm/EgovMobile-1.4.5.css"/>
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/egovframework/mbl/com/uss/ussCommon.css"/>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/cmm/jquery-1.11.2.js"></script>
		
		 
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/cmm/jquery.mobile-1.4.5.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/cmm/EgovMobile-1.4.5.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/com/cop/smt/sdm/schdul-popup.js"></script>
		
		<!-- datebox javascript-->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/css/egovframework/mbl/com/datepicker/jqm-datebox.css"/>

		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/com/datepicker/jqm-datebox.core.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/com/datepicker/jqm-datebox.mode.calbox.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/com/datepicker/jqm-datebox.mode.datebox.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/com/datepicker/jqm-datebox.mode.flipbox.js"></script>
		<script type="text/javascript" src="${pageContext.request.contextPath}/js/egovframework/mbl/com/datepicker/jquery.mobile.datebox.i18n.ko.utf8.js"></script>
		
		<script type="text/javascript" src="${pageContext.request.contextPath}/validator.mdo"></script>
		<validator:javascript formName="edmManageVO" staticJavascript="false" xhtml="true" cdata="false"/> 
		
		<script type="text/javaScript" language="javascript">
		<!--
			
			function fn_egov_update() {
					if($('#managtCn').val() == "") {
						$('#managtCn').val("Testing...");
					}
						
					if(!validateEdmManageVO(document.detailForm)) {
						return;
					}
					
					document.detailForm.action = "${pageContext.request.contextPath}/edm/edm/EdmDtlsUpdt.mdo";			
					document.detailForm.submit();
											
				}
			function fn_showList() {

				document.detailForm.action = "${pageContext.request.contextPath}/edm/edm/EgovEdmManageListInqire.mdo";
				document.detailForm.submit();
				
			}

			function fn_show_view() {
				document.detailForm.action = "${pageContext.request.contextPath}/edm/edm/EdmDetailInqire.mdo";						         
				document.detailForm.submit();
				
			}
		-->
		</script>
	</head>
	
	<body>
		<div id="view" data-role="page">
									
			
			<div data-role="header">
				<a href="javascript:fn_show_view();" data-icon="arrow-l" data-ajax="false">뒤로</a>
			    <h1>지출 수정</h1>
			</div>
			
			<form:form modelAttribute="edmManageVO" name="detailForm" method="post">
				<div data-role="content" class="com-ussContent">
					<form:hidden path="expenseId"/>
					<form:hidden path="searchCondition" value="${searchVO.searchCondition}"/>
					<form:hidden path="searchKeyword" value="${searchVO.searchKeyword}"/>
					<form:hidden path="pageIndex" value="${searchVO.pageIndex}"/>
				
					<div data-inline="true">
						<dl class="uss-registOk">
							<dt><label for="expendCode"><strong>지출구분</strong></label></dt>
							<dd>
								<fieldset data-role="controlgroup" data-type="horizontal"  data-inline="true"> 	
					        		<c:forEach items="${expendCode}" var="expenseCode">
					        			<form:radiobutton path="categoryId" value="${expenseCode.code}" label="${expenseCode.codeDc}"/>
					        		</c:forEach>
				        		</fieldset>
							</dd>
							
							<dt><label for="expendCode"><strong>날짜/시간</strong></label></dt>
							<dd class="department">
								<div class="uss-time">
				        			<span class="uss-dataBox"><form:input path="expenseDt" type="date" data-role="datebox" data-options='{"mode": "datebox"}' class="new"/></span>
					        		<span class="uss-dataBox"><form:input path="expenseTm" type="date" data-role="datebox" data-options='{"mode": "timebox", "overrideTimeFormat": 24}' class="new"/></span>
				        		</div>
							</dd>
							
							<dt><label for="amount"><strong>지출금액</strong></label></dt>
							<dd><form:input path="amount" size="70" maxlength="70" title="지출금액"/></dd>
							
							<dt><label for="expenseNote"><strong>지출내용</strong></label></dt>
							<dd><form:textarea path="expenseNote" cols="300" rows="20" cssClass="txaClass" title="지출내용"/></dd>
						</dl>
					</div>
					
					<div class="ui-grid-a">	
						<div class="ui-block-a"><a href="javascript:fn_egov_update();" data-role="button" data-theme="b" data-ajax="false">수정</a></div>
						<div class="ui-block-b"><a href='javascript:fn_showList();' data-role="button" data-theme="b">목록</a></div>				
					</div>
				</div>
			</form:form>
			
			<!-- footer start -->
			<div data-role="footer" data-position="fixed">
				<h4>Copyright (c) MINISTRY OF SECURITY AND PUBLIC ADMINISTRATION.</h4>
			</div>
			<!-- footer end -->
		</div>
				
	
	</body>
</html>

