<%@page import="com.qltiemchung.model.bean.LoaiVacxin"%>
<%@page import="com.qltiemchung.utils.DateUtils"%>
<%@page import="com.qltiemchung.model.bean.KhachTiem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.qltiemchung.model.bean.MessageState"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp">

	<tiles:putAttribute name="content">
		<div class="">
			<div class="page-title" style="margin-bottom: 50px">
				<div class="title_left">
					<h3>Blank Page</h3>
				</div>

				<div class="title_right">
					
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel" style="height: 600px;">
						<div class="x_title">
							<h2>Blank Page</h2>
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
							<h1>Danh sách Loại Vắc Xin</h1>
								<table border="1">
									<caption>DANH SÁCH NHÂN SỰ</caption>
									<tr>
										<th>Mã oại</th>
										<th>Tên loại</th>
										<th>Mô tả</th>
										<th>Ghi chú</th>
										<th>Thao tác</th>
									</tr>
								<%
									if(request.getAttribute("listLoaiVacXin")!=null){
										ArrayList<LoaiVacxin> listLoaiVacXin = new ArrayList<LoaiVacxin>();
										listLoaiVacXin = (ArrayList<LoaiVacxin>)request.getAttribute("listLoaiVacXin");
										for(LoaiVacxin loaiVacxin:listLoaiVacXin){
											%>
											<tr>
												<td><%=loaiVacxin.getMaLoai()%></td>
												<td><%=loaiVacxin.getTenLoai()%></td>
												<td><%=loaiVacxin.getMoTa()%></td>
												<td><%=loaiVacxin.getGhiChu()%></td>
												<td>
													<a href="<%=request.getContextPath()%>/LoaiVacXinCapNhatServlet?maLoai=<%=loaiVacxin.getMaLoai()%>" alt="xem và cập nhật">Xem</a>
													<a href="<%=request.getContextPath()%>/doLoaiVacXinXoa?maLoai=<%=loaiVacxin.getMaLoai()%>" alt="xóa">Xóa</a>
												</td>
											</tr>
											<% 		
										}
									}
								%>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
		
	</tiles:putAttribute>

</tiles:insertTemplate>