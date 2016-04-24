<%@page import="com.qltiemchung.model.bean.LoaiTinTuc"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.qltiemchung.model.bo.CanBoBO"%>
<%@page import="com.qltiemchung.model.bean.CanBo"%>
<%@page import="com.qltiemchung.model.bean.MessageState"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp" >

	<tiles:putAttribute name="content">
		<div class="">
			<div class="page-title" style="margin-bottom: 50px">
				<div class="title_left">
					<h3>Danh sách loại tin tức</h3>
				</div>

				<div class="title_right">
					
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel" style="height: 600px;">
						<div class="x_title">
							<h2>Danh sách loại tin tức</h2>
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
							<%ArrayList<LoaiTinTuc> arLoaiTinTuc = new ArrayList<LoaiTinTuc>();
							arLoaiTinTuc = (ArrayList<LoaiTinTuc>) request.getAttribute("DanhSachLoaiTinTuc");
							
							%>
							<form action="<%=request.getContextPath() %>/LoaiTinTucDanhSachServlet" method = "post">
								<table border = "1" width = "50%" >
									<tr>
										<th>Mã loại</th>
										<th>Tên loại</th>
										<th></th>
										<th></th>
									</tr>
									<%for(LoaiTinTuc loaiTinTuc: arLoaiTinTuc) {%>
									<tr>
										<td><%=loaiTinTuc.getMaLoai()%></td>
										<td><%=loaiTinTuc.getTenLoai()%></td>
										<td><a href = "<%=request.getContextPath()%>/LoaiTinTucCapNhatServlet?maLoai=<%=loaiTinTuc.getMaLoai()%>">Xem</a></td>
										<td><a href = "<%=request.getContextPath()%>/doLoaiTinTucXoa?maLoai=<%=loaiTinTuc.getMaLoai()%>">Xóa</a></td>
									</tr>
									<%} %>
								</table>
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