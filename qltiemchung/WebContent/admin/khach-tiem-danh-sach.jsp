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
							<h1>Danh sách khách tiêm</h1>
								<table border="1">
									<caption>DANH SÁCH KHÁCH TIÊM</caption>
									<tr>
										<th>Mã Khách</th>
										<th>Họ và tên</th>
										<th>Giới tính</th>
										<th>Ngày sinh</th>
										<th>Địa chỉ</th>>
										<th>Chứng minh nhân dân</th>
										<th>Email</th>
										<th>Số điện thoại</th>
										<th>Thao tác</th>
									</tr>
								<%
									if(request.getAttribute("listKhachTiem")!=null){
										ArrayList<KhachTiem> listKhachTiem = new ArrayList<KhachTiem>();
										listKhachTiem = (ArrayList<KhachTiem>)request.getAttribute("listKhachTiem");
										for(KhachTiem khachTiem:listKhachTiem){
											%>
											<tr>
												<td><%=khachTiem.getMaKhach()%></td>
												<td><%=khachTiem.getHoTen()%></td>
												<td>
													<%
														switch(khachTiem.getGioiTinh()){
															case 1:
																out.print("Nam");
																break;
															case 2:
																out.print("Nữ");
																break;
															case 3:
																out.print("Khác");
																break;
														}
													%>
												</td>
												<td><%
													String date = DateUtils.formatDate(khachTiem.getNgaySinh());
													out.print(date);
												%></td>
												<td><%=khachTiem.getDiaChi()%></td>
												<td><%=khachTiem.getCmnd()%></td>
												<td><%=khachTiem.getEmail()%></td>
												<td><%=khachTiem.getSoDienThoai()%>
												<td>
													<a href="<%=request.getContextPath()%>/KhachTiemCapNhatServlet?makhach=<%=khachTiem.getMaKhach()%>" alt="xem và cập nhật" method="post">Xem</a>
													<a href="<%=request.getContextPath()%>/XoaThongTinServlet?makhach=<%=khachTiem.getMaKhach()%>" alt="sữa">Xóa</a>
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