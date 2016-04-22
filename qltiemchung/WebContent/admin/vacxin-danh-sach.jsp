<%@page import="com.qltiemchung.model.bean.LoaiVacxin"%>
<%@page import="com.qltiemchung.model.bean.Vacxin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.qltiemchung.model.bean.MessageState"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp" >

	<tiles:putAttribute name="content">
		<div class="">
			<div class="page-title" style="margin-bottom: 50px">
				<div class="title_left">
					<h3>Quản lý Vacxin</h3>
				</div>

				<div class="title_right">
					
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel" style="height: 600px;">
						<div class="x_title">
							<h2>Danh sách vacxin</h2>
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
							<form action="VacxinDanhSachServlet" method="post">
								Loại vacxin 
								<select name="maLoaiVacxin">
								<%String maLVX = (String) request.getAttribute("maLVX");
								if(maLVX==null) maLVX = "-1";%>
									<option value="tatca">---Tất cả---</option>
									<c:if test="${DanhSachLoaiVacxin!=null && DanhSachLoaiVacxin.size()>0}">
										<%ArrayList<LoaiVacxin> dsLoaiVacxin = (ArrayList<LoaiVacxin>) request.getAttribute("DanhSachLoaiVacxin");%>
										<% for (LoaiVacxin loaiVx : dsLoaiVacxin) { %>
											<option value="<%=loaiVx.getMaLoai()%>" <%if(loaiVx.getMaLoai()==Integer.parseInt(maLVX)){%>selected<% } %>><%=loaiVx.getTenLoai()%></option>
										<% } %>
									</c:if>
								</select>
								<input type="submit" value="Tìm" />
							</form>
							<a href="VacxinThemServlet">Thêm</a>
							<c:if test="${DanhSachVacxin.size()!=null && DanhSachVacxin.size()>0}">
								<%ArrayList<Vacxin> dsVacxin = (ArrayList<Vacxin>) request.getAttribute("DanhSachVacxin");%>
					           <table border="1">
					           	<tr>
					           		<th>Tên</th>
					           		<th>Tác dụng</th>
					           		<th>Chức năng</th>
					           	<tr>
					           	<%for(Vacxin vacxin : dsVacxin){ %>
					           	<tr>
					           		<td><%=vacxin.getTenVacxin() %></td>
					           		<td><%=vacxin.getTacDung() %></td>
					           		<td><a href="VacxinCapNhatServlet?mavacxin=<%=vacxin.getMaVacxin()%>">Xem</a>
					           		<a href="doVacxinXoa?mavacxin=<%=vacxin.getMaVacxin()%>" onclick="return confirm('Bạn có chắc chắn muốn xóa?')">Xóa</a></td>
					           	</tr>
								<%} %>
					           </table>
							</c:if>
							
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
		
	</tiles:putAttribute>

</tiles:insertTemplate>