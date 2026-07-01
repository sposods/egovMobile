<%
 /**
  * @Class Name : EgovMobileSyncList.jsp
  * @Description : EgovMobileSyncList 화면
  * @Modification Information
  * @
  * @  수정일   	수정자		수정내용
  * @ ----------	------		---------------------------
  * @ 2011.08.22	조준형		최초 생성
  *
  *  @author 조준형
  *  @since 2011.08.24
  *  @version 1.0
  *  @see
  *  
  */
%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html> 
<html manifest="<c:url value='/offlineInfo_ows.manifest'/>">
    <head> 
       	<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no"/>
       	<title>모바일 화면</title>
        
		<!-- eGovFrame Common import -->
		<link rel="stylesheet" href="<c:url value='/css/egovframework/mbl/cmm/jquery.mobile-1.4.5.css'/>"/>
		<link rel="stylesheet" href="<c:url value='/css/egovframework/mbl/cmm/EgovMobile-1.4.5.css'/>"/>
		<script type="text/javascript" src="<c:url value='/js/egovframework/mbl/cmm/jquery-1.11.2.js'/>"></script>
		
		
		<script type="text/javascript" src="<c:url value='/js/egovframework/mbl/cmm/jquery.mobile-1.4.5.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/js/egovframework/mbl/cmm/EgovMobile-1.4.5.js'/>"></script>
	  
		<!-- 신규공통컴포넌트 import -->
		<link rel="stylesheet" href="<c:url value='/css/egovframework/mbl/mcomd/egovMcomd.css'/>"/>

        <script type="text/javascript">
        	var contextPath = "${pageContext.request.contextPath}";	// js uri 적용을 위한 contextpath
			var fetchRowIdx = 1;
			var deviceType = "M";

			/*********************************************************
			 * 오프라인 서비스 글 목록 조회 초기화
			 ******************************************************** */				
    		$(document).ready(function() {
				if(window.navigator.onLine == true) {
	    			// 1. 오프라인 서비스 목록 조회
	    			fn_offlineList();
				} else {
	                // 2. [오프라인] 오프라인 목록 조회 내용 webstorage에 적재
	                var html = localStorage.getItem("localOfflineList");
	                $('div[id="list"] ul[data-role="listview"]').html(html).listview('refresh');
				}
	        });
        </script>
        
        <!-- 오프라인웹 서비스 js -->
		<script type="text/javascript" src="<c:url value='/js/egovframework/mbl/com/ows/ows.js'/>"></script>
	</head>

	<body>
	 	<form:form name="frmOfflineWeb" method="post" modelAttribute="searchVO" >
	 		<input type="hidden" name="searchSn"/>
	 	</form:form>		
		
		<!-- 오프라인 서비스 목록 -->
	    <div id="list" data-role="page" data-theme="d">
		    <!-- header start -->
		    <div data-role="header" data-theme="z">
	   			<a href="<c:url value='/index.jsp'/>" data-ajax="false" data-icon="home" class="ui-btn-left">메인</a>
				<h1><img src="<c:url value='/images/egovframework/mbl/mcomd/h1_logo.png'/>"/></h1>
				<div class="ui-body-a mcomd-title"><h3>오프라인서비스</h3></div>
			</div>
		    <!-- header end -->
		
		    <!-- content start -->
			<div data-role="content">
				<ul data-role="listview" data-inset="true"></ul>
			</div>
			
			<div class="mcomd-more" id="pageNavi"><a href="javascript:fn_moreFetch();"><div> 더보기 </div></a></div>
			<!-- content end -->
		
		    <!-- footer start -->
			<div data-role="footer" data-theme="z" data-position="fixed">
				<h4>Copyright(c)2011 Ministry of Government Administration and Home Affairs.</h4>
			</div>
		    <!-- footer end -->
		    
	    </div>
	 
	    
	</body>
</html>    