<%@page import="com.qltiemchung.model.bean.LoaiTinTuc"%>
<%@page import="com.qltiemchung.model.bean.MessageState"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp" >

	<tiles:putAttribute name="content">
		<div class="">
			<div class="page-title" style="margin-bottom: 50px">
				<div class="title_left">
					<h3>Cập nhật loại tin tức</h3>
				</div>

				<div class="title_right">
					
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel" style="height: 600px;">
						<div class="x_title">
							<h2>Cập nhật loại tin tức</h2>
							<div class="clearfix"></div>
						</div>
						<!-- Message -->
						<div class="col-md-6 col-sm-6 col-xs-6" style="float: none; margin: 0 auto;">
							<!-- Success Message -->
							<c:set var="SUCCESS"><%=MessageState.SUCCESS %></c:set>
							<c:set var="FAIL"><%=MessageState.FAIL %></c:set>
							<c:if test="${MessageBundleQLVX != null && MessageBundleQLVX.getMessages(SUCCESS).size() > 0}" >
									<div class="alert alert-success alert-dismissible fade in" role="alert">
					                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
					                    <c:forEach var="m" items="${MessageBundleQLVX.getMessages(SUCCESS) }">
					                    	<p><strong><c:out value="${m.getContent() }"></c:out></strong></p>
					                    </c:forEach>
				                	</div>
							</c:if>
							<c:if test="${MessageBundleQLVX != null && MessageBundleQLVX.getMessages(FAIL).size() > 0}" >
									<div class="alert alert-danger alert-dismissible fade in" role="alert">
					                    <button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">×</span></button>
					                    <c:forEach var="m" items="${MessageBundleQLVX.getMessages(FAIL) }">
					                    	<p><strong><c:out value="${m.getContent() }"></c:out></strong></p>
					                    </c:forEach>
				                	</div>
							</c:if>
							
						</div>
						<!-- /Message -->
						<div class="x_content">
							<!-- Put your code here -->
							<%LoaiTinTuc loaiTinTuc = (LoaiTinTuc)request.getAttribute("LoaiTinTuc"); %>
							<form action="<%=request.getContextPath()%>/doLoaiTinTucCapNhat" method = "post">
								Mã loại: <input type = "text" name = "maLoai" value = "<%=loaiTinTuc.getMaLoai()%>"/><br />
								Tên loại: <input type = "text" name = "tenLoai" value = "<%=loaiTinTuc.getTenLoai()%>"/><br />
								Mô tả: <input type = "text" name = "moTa" value = "<%=loaiTinTuc.getMoTa()%>"/><br />
								<input type = "submit" name = "submit" value = "Sửa"/>
								<input type = "reset" name = "reset" value = "Reset"/>
								<input type = "button" name = "huy" value = "Hủy"/>
							</form>
							
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
		
	</tiles:putAttribute>

</tiles:insertTemplate>