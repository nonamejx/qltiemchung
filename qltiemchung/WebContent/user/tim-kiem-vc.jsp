<%@page import="com.qltiemchung.model.bean.Vacxin"%>
<%@page import="com.qltiemchung.utils.StringUtils"%>
<%@page import="com.qltiemchung.model.bean.TinTuc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Trung tâm y tế dự phòng</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resources/user/style.css" type="text/css">
</head>
<body>

<%
	ArrayList<Vacxin> dsVacxin = (ArrayList<Vacxin>) request.getAttribute("dsVacxin");
	ArrayList<TinTuc> dsTinTucGanDay = (ArrayList<TinTuc>) request.getAttribute("dsTinTucGanDay");
	String error = (String) request.getAttribute("error");
		
%>

<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" height="100" valign="top">
			<table width="1000" height="100" border="0" cellspacing="0" cellpadding="0" align="center" class="tab_white">
				<tr>
					<td width="1000" height="56" valign="top" class="tab">
						<div class="company"> 
							<strong class="company1">TRUNG TÂM Y TẾ DỰ PHÒNG</strong>
						</div>
					</td>
				</tr>
				<tr>
					<td width="1000" height="53" valign="top" class="menus"><a
						href="<%=request.getContextPath()%>/TrangChuKhachServlet" class="menu">Trang chủ</a> <a
						href="index-1.html" class="menu">Giới thiệu</a> <a
						href="index-2.html" class="menu">Lịch tiêm chủng</a> <a
						href="<%=request.getContextPath()%>/NguoiDungTimKiemVCServlet" class="menu">Vắc xin</a> <a
						href="index-5.html" class="menu">Liên hệ</a>
					</td>
				</tr>
				<tr>
					<td width="1000" height="10" valign="top"></td>
				</tr>
				<tr>
					<td width="1000" height="281" valign="top" class="header">
						<div class="blok_top">
							<strong class="slogan">Trung tâm y tế dự phòng</strong><br>
							<span class="slogan1">Thành phố Đà Nẵng</span><br> <br>
							<strong>62 Ngô Sỹ Liên, P. Hòa Khánh, Q. Liên Chiểu<br>Sđt: 01666 555 666<br> Fax: 1 800 123 1234<br>E-mail: mail@.vacxinteam.com</strong>
						</div>
					</td>
				</tr>
				<tr>
					<td width="1000" height="10" valign="top"></td>
				</tr>

				<tr>
					<td width="1000" height="20" valign="top"></td>
				</tr>
				<tr>
					<td width="1000" height="100" valign="top">
						<table width="1000" height="100" border="0" cellspacing="0" cellpadding="0">
							<tr>
								<td width="279" height="100" valign="top">
									<div class="blok_left">
										<span class="name">Đăng nhập</span><br><br>

											<table>
												<tr>
													<td><label for="posName">ID:</label></td>
													<td><input class="input_contact" type="text" name="" /></td>
												</tr>
												<tr>
													<td><label for="posEmail">Mật khẩu:</label></td>
													<td><input class="input_contact" type="password"
														name="" /></td>
												</tr>
												<tr>
													<td>&nbsp;</td>
													<td><input class="submit_registry" type="submit"
														name="selfCC" id="selfCC" value="Đăng nhập" /></td>
												</tr>
											</table><br>


											<!-- Tin gan day -->
											<span class="name">Tin gần đây</span><br> <br>

											<%
												if (dsTinTucGanDay != null)
													for (int i = 0; i < dsTinTucGanDay.size(); i++) {
											%>
											<img
												src="<%=request.getContextPath()%>/resources/user/images/str.jpg"
												align="absmiddle" class="str"> <a href="#"
												class="links"><%=StringUtils.shorten(dsTinTucGanDay.get(i).getTieuDe(), 50)%></a><br> <img
												src="<%=request.getContextPath()%>/resources/user/images/line.jpg"
												class="line">
											<%
												}
											%>

									</div>
								</td>


								<td width="1" height="100" valign="top" class="liner"></td>
									
								<td width="720" height="100" valign="top">
									
										<!-- Tìm kiếm vắc xin -->
									
										<div class="blok">
											<img src="<%=request.getContextPath()%>/resources/user/images/logo.jpg" align="absmiddle" class="str"> 
											<span class="name">Tìm kiếm Vắc xin</span><br> <br>
											
											<%if (error != null) {%>
												<p style="color: red"><%=error %></p>
											<%} %>
											
											<form action="<%=request.getContextPath()%>/NguoiDungTimKiemVCServlet" method="post">
												<input style="width: 30%" class="input_contact" placeholder="Nhập tên vắc xin" type="text" name="keyword" value="${keyword }" /> 
												<input style="width: 80px; height: 24px;" class="submit_registry" type="submit" value="Tìm kiếm" />
											</form>
											<br><br>

											<!-- danh sach ket qua tim duoc -->
					
											<%
												if (dsVacxin != null) {
													for (int i = 0; i < dsVacxin.size(); i++) {
											%>
											<img src="<%=request.getContextPath()%>/resources/user/images/str.jpg" align="absmiddle" class="str"> 
											<strong>
												<a href="#" style="color: #2586d7; text-decoration: none;"><%=dsVacxin.get(i).getTenVacxin()%></a>
											</strong><br><%=StringUtils.shorten(dsVacxin.get(i).getTacDung(), 200)%>
											<br><br>

											<%
												}
											%>

											<!-- phan trang -->
											<br>
											
											<table id="pagination-flickr">
											<tr>
											<td>
												<c:choose>
													<c:when test="${currentPage == 1}">
														<li class="previous-off">«Previous</li>
													</c:when>
													<c:otherwise>
														<li class="previous">
															<form action="<%=request.getContextPath()%>/NguoiDungTimKiemVCServlet" method="post">
																<input type="text" name="keyword" value="${keyword }" hidden="true" > 
																<input type="text" name="page" value="${currentPage - 1 }" hidden="true" > 
																<input type="submit" value="«Previous" >
															</form>
														</li>
													</c:otherwise>
												</c:choose>
											</td>
												<c:forEach begin="1" end="${noOfPages}" var="i">
													<td>
													<c:choose>
														<c:when test="${currentPage eq i}">
															<li class="active">${i}</li>
														</c:when>
														<c:otherwise>
															<li>
															<form action="<%=request.getContextPath()%>/NguoiDungTimKiemVCServlet" method="post">
																<input type="text" name="keyword" value="${keyword }" hidden="true" > 
																<input type="text" name="page" value="${i }" hidden="true" > 
																<input type="submit" value="${i }" >
															</form>
															</li>
														</c:otherwise>
													</c:choose>
													</td>
												</c:forEach>
											<td>
												<c:choose>
													<c:when test="${currentPage lt noOfPages}">
														<li class="next">
														<form action="<%=request.getContextPath()%>/NguoiDungTimKiemVCServlet" method="post">
															<input type="text" name="keyword" value="${keyword }" hidden="true" > 
																<input type="text" name="page" value="${currentPage + 1 }" hidden="true"> 
																<input type="submit" value="Next »" ></form>
														</li>
													</c:when>
													<c:otherwise>
														<li class="next-off">Next »</li>
													</c:otherwise>
												</c:choose>
												</td>
												</tr>
											</table>
								
											<!-- ket thuc phan trang -->
											<%} %>
										</div>

									</td>
								</tr>
							</table>
						</td>
					</tr>
					<tr>
						<td width="1000" height="15" valign="top"></td>
					</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td width="100%" height="100%" valign="top" class="tab">
				<table width="1000" height="100%" border="0" cellspacing="0"
					cellpadding="0" align="center">
					<tr>
						<td width="1000" height="12" valign="top" class="tab_bot"><img
							src="<%=request.getContextPath()%>/resources/user/images/y1.jpg"
							style="float: left"><img
							src="<%=request.getContextPath()%>/resources/user/images/y2.jpg"
							style="float: right"></td>
					</tr>
					<tr>
						<td width="1000" height="100%" valign="top">
							<div class="copyright">Copyright &copy; 2016 <br>VacxinTeam<br></div>
						<div class="div_menu_bottom">
							<a href="<%=request.getContextPath() %>/TrangChuKhachServlet" class="menu_bottom">Trang chủ</a> &nbsp; &nbsp; | &nbsp; &nbsp; 
							<a href="index-1.html" class="menu_bottom">Services</a> &nbsp; &nbsp; | &nbsp; &nbsp;
							<a href="index-2.html" class="menu_bottom">Giới thiệu</a> &nbsp; &nbsp; | &nbsp; &nbsp; 
							<a href="index-3.html" class="menu_bottom">Lịch tiêm chủng</a> &nbsp; &nbsp; | &nbsp; &nbsp; 
							<a href="<%=request.getContextPath() %>/NguoiDungTimKiemVCServlet" class="menu_bottom">Vắc xin</a> &nbsp; &nbsp; | &nbsp; &nbsp; 
							<a href="index-5.html" class="menu_bottom">Liên hệ</a>
						</div>
						</td>
					</tr>
				</table>

			</td>
		</tr>
	</table>
</body>
</html>