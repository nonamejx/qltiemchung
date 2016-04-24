<%@page import="com.qltiemchung.utils.StringUtils"%>
<%@page import="com.qltiemchung.model.bean.TinTuc"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Trung tâm y tế dự phòng</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="Content-Style-Type" content="text/css">
<link type="text/css" href="<%=request.getContextPath()%>/resources/user/style.css" rel="stylesheet">
</head>
<body>

<%
	ArrayList<TinTuc> dsThongBao = (ArrayList<TinTuc>) request.getAttribute("dsThongBao");
	ArrayList<TinTuc> dsTinTucMoiNhat = (ArrayList<TinTuc>) request.getAttribute("dsTinTucMoiNhat");
	ArrayList<TinTuc> dsTinTucGanDay = (ArrayList<TinTuc>) request.getAttribute("dsTinTucGanDay");
%>

<table width="100%" height="100%" border="0" cellspacing="0" cellpadding="0">
	<tr>
		<td width="100%" height="100" valign="top">
			<table width="1000" height="100" border="0" cellspacing="0" cellpadding="0" align="center" class="tab_white">
				
				<!-- header -->
				<tr>
					<td width="1000" height="56" valign="top" class="tab">
						<div class="company"><strong class="company1">TRUNG TÂM Y TẾ DỰ PHÒNG</strong></div>
					</td>
				</tr>
				
				<tr>
					<td width="1000" height="53" valign="top" class="menus">
					<a href="<%=request.getContextPath() %>/TrangChuKhachServlet" class="menu">Trang chủ</a> 
					<a href="index-1.html" class="menu">Giới thiệu</a> 
					<a href="index-2.html" class="menu">Lịch tiêm chủng</a> 
					<a href="<%=request.getContextPath() %>/NguoiDungTimKiemVCServlet" class="menu">Vắc xin</a> 
					<a href="index-5.html" class="menu">Liên hệ</a></td>
				</tr>
				<tr>
					<td width="1000" height="10" valign="top"></td>
				</tr>
				<tr>
					<td width="1000" height="281" valign="top" class="header">
						<div class="blok_top">
							<strong class="slogan">Trung tâm y tế dự phòng</strong><br>
							<span class="slogan1">Thành phố Đà Nẵng</span><br><br> 
							<strong>62 Ngô Sỹ Liên, P. Hòa Khánh, Q. Liên Chiểu<br> Sđt: 01666 555 666<br> Fax: 1 800 123 1234<br>
							E-mail: mail@.vacxinteam.com
							</strong>
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
									
										<!-- form login -->
										<span class="name">Đăng nhập</span><br><br>
										<table>
											<tr>
												<td><label for="posName">ID:</label></td>
												<td><input class="input_contact" type="text" name="" /></td>
											</tr>
											<tr>
												<td><label for="posEmail">Mật khẩu:</label></td>
												<td><input class="input_contact" type="password" name="" /></td>
											</tr>
											<tr>
												<td>&nbsp;</td>
												<td><input class="submit_registry" type="submit" name="selfCC" id="selfCC" value="Đăng nhập" /></td>
											</tr>
										</table><br>
											

										<!-- Tin gan day -->
										<span class="name">Tin gần đây</span><br><br> 
											
										<%if (dsTinTucGanDay != null) for (int i = 0; i < dsTinTucGanDay.size(); i++) { %>
										<img src="<%=request.getContextPath()%>/resources/user/images/str.jpg" align="absmiddle" class="str">
										<a href="#" class="links"><%=StringUtils.shorten(dsTinTucGanDay.get(i).getTieuDe(), 50) %></a><br>
										<img src="<%=request.getContextPath()%>/resources/user/images/line.jpg" class="line"> 
										<%} %>
											
									</div>
								</td>
									
									
								<td width="1" height="100" valign="top" class="liner"></td>

								<td width="720" height="100" valign="top">
										
									<!-- Thong bao -->
									<div class="blok">
										<img src="<%=request.getContextPath()%>/resources/user/images/logo.jpg" align="absmiddle" class="str">
										<span class="name">Thông báo</span><br><br> 
										<%if (dsThongBao != null) for (int i = 0 ; i < dsThongBao.size() ; i++) { %>
										<strong><%=dsThongBao.get(i).getTieuDe() %></strong>
										<br><%=StringUtils.shorten(dsThongBao.get(i).getNoiDung(), 300) %><br>
										<a href="#"><img src="<%=request.getContextPath()%>/resources/user/images/read.jpg" border="0"></a><br><br>
										<%} %>
									</div>
										
										
									<!-- Tin tuc -->
									<div class="blok1">
										<img src="<%=request.getContextPath()%>/resources/user/images/logo.jpg" align="absmiddle" class="str">
										<span class="name">Tin tức</span><br><br>	
											
										<%if (dsTinTucMoiNhat != null) for (int i = 0 ; i < dsTinTucMoiNhat.size() ; i++) { %>
										<img src="<%=request.getContextPath()%>/resources/user/images/str.jpg" align="absmiddle" class="str">
										<strong><%=dsTinTucMoiNhat.get(i).getTieuDe() %></strong>
										<br><%=StringUtils.shorten(dsTinTucMoiNhat.get(i).getNoiDung(), 300) %><br> 
										<a href="#"><img src="<%=request.getContextPath()%>/resources/user/images/read.jpg" border="0"></a><br><br> 
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
	
	<!-- footer -->
	<tr>
		<td width="100%" height="100%" valign="top" class="tab">
			<table width="1000" height="100%" border="0" cellspacing="0" cellpadding="0" align="center">
				<tr>
					<td width="1000" height="12" valign="top" class="tab_bot">
					<img src="<%=request.getContextPath()%>/resources/user/images/y1.jpg" style="float: left">
					<img src="<%=request.getContextPath()%>/resources/user/images/y2.jpg" style="float: right"></td>
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