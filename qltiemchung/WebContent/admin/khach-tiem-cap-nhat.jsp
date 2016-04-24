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
							<h1>THÔNG TIN KHÁCH TIÊM</h1>
								<%
									if(request.getAttribute("khachTiem")!=null){
										KhachTiem khachTiem = new KhachTiem();
										khachTiem = (KhachTiem)request.getAttribute("khachTiem");
										%>
											<form action="<%=request.getContextPath()%>/doKhachTiemCapNhat" method="post">
													<label>Mã khách: </label><input type="hidden" name="maKhach" value="<%=khachTiem.getMaKhach()%>"/><br>
													<label>Họ và tên: </label><input type="text" name="hoTen" value="<%=khachTiem.getHoTen()%>"/><br>
													<label>Giới tính: </label>
													<select name="gioiTinh">
														<option value="1">Nam</option>
														<option value="2">Nữ</option>
														<option value="3">Khác</option>
													</select><br>
													<label>Ngày sinh: </label><input type="text" name="ngaySinh" value="<%
														out.print(DateUtils.formatDate(khachTiem.getNgaySinh()));
													%>"/><br>
													<label>Tên đăng nhập: </label><input type="text" name="tenDangNhap" value="<%=khachTiem.getTenDangNhap()%>"/><br>
													<label>Mật khẩu: </label><input type="text" name="matKhau" value="<%=khachTiem.getMaKhach()%>"/><br>
													<label>Chứng minh nhân dân: </label><input type="text" name="cmnd" value="<%=khachTiem.getCmnd()%>"/><br>
													<label>Email: </label><input type="text" name="email" value="<%=khachTiem.getEmail()%>"/><br>
													<label>Số điện thoại: </label><input type="text" name="soDienThoai" value="<%=khachTiem.getSoDienThoai()%>"/><br>
													<label>Địa chỉ: </label><input type="text" name="diaChi" value="<%=khachTiem.getDiaChi()%>"/><br>
													<input type="submit" name="submit" value="Cập nhật"/>
													<a href="<%=request.getContextPath()%>/KhachTiemDanhSachServlet" alt="Hủy bỏ thao tác">Hủy</a>
											</form>
										<%
									}
								%>
						</div>
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
		
	</tiles:putAttribute>

</tiles:insertTemplate>