<%@page import="com.qltiemchung.model.bean.UrlCollection"%>
<%@page import="com.qltiemchung.utils.UrlUtils"%>
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
	
		<!-- Custom styling plus plugins -->
		<link href="css/custom.css" rel="stylesheet">
		<link href="css/icheck/flat/green.css" rel="stylesheet">
		
		<link href="<%=request.getContextPath() %>/resources/production/js/datatables/jquery.dataTables.min.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath() %>/resources/production/js/datatables/buttons.bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath() %>/resources/production/js/datatables/fixedHeader.bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath() %>/resources/production/js/datatables/responsive.bootstrap.min.css" rel="stylesheet" type="text/css" />
		<link href="<%=request.getContextPath() %>/resources/production/js/datatables/scroller.bootstrap.min.css" rel="stylesheet" type="text/css" />
		<!-- /Custom styling plus plugins -->
	
		<!-- UrlUtils -->
		<%
			UrlUtils urlUtils = UrlUtils.getInstance(request);
		%>
		<!-- /UrlUtils -->
	
		<div class="">
			<div class="page-title" style="margin-bottom: 50px">
				<div class="title_left">
					<h3>Danh sách cán bộ</h3>
				</div>

				<div class="title_right">
					
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<a class="btn btn-success btn-sm" href="<%=urlUtils.getPath(UrlCollection.CAN_BO_THEM_MOI)%>"><i class="fa fa-plus"></i> Thêm mới</a>
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
							<%ArrayList<CanBo> arCanBo = new ArrayList<CanBo>();
							arCanBo = (ArrayList<CanBo>) request.getAttribute("DanhSachCanBo");
							
							%>
							<form action="<%=request.getContextPath() %>/CanBoDanhSachServlet" method = "post">
								<table id="datatable" class="table table-striped table-bordered">
									<thead>
										<tr>
										<th>#Mã</th>
										<th>Họ tên</th>
										<th>Ngày sinh</th>
										<th></th>
									</tr>
									</thead>
									<tbody>
										<%for(CanBo canbo: arCanBo) {%>
										<tr>
											<td><%=canbo.getMaCanBo()%></td>
											<td><%=canbo.getTenCanBo()%></td>
											<td><%=canbo.getFormattedBirtday()%></td>
											<td>
												<a class="btn btn-primary btn-xs" href="<%=request.getContextPath()%>/CanBoCapNhatServlet">Xem</a>
												<a class="btn btn-danger btn-xs" href="#" data-toggle="modal" data-target=".bs-example-modal-sm">Xóa</a>
											</td>
										</tr>
										<%} %>
									</tbody>
								</table>
							</form>
							
						</div>
						
						<!-- modals -->
						<div class="x_content">
		                    <!-- Small modal -->
			                <!-- <button type="button" class="btn btn-primary" data-toggle="modal" data-target=".bs-example-modal-sm">Small modal</button> -->
			
			                <div class="modal fade bs-example-modal-sm" tabindex="-1" role="dialog" aria-hidden="true">
			                  <div class="modal-dialog modal-sm">
			                    <div class="modal-content">
			
			                      <div class="modal-header">
			                        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">×</span>
			                        </button>
			                        <h4 class="modal-title" id="myModalLabel2">Thông báo</h4>
			                      </div>
			                      <div class="modal-body">
			                        <h4>Bạn có chắc muốn xóa thông tin này?</h4>
			                      </div>
			                      <div class="modal-header">
				                      <div style="float:right">
				                      	<button type="button" class="btn btn-sm btn-danger">Xóa</button>
				                        <button type="button" class="btn btn-sm btn-default" data-dismiss="modal">Đóng</button>
				                      </div>
			                      </div>
			
			                    </div>
			                  </div>
			                </div>
				            <!-- /modals -->
						
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
		
		<!-- Datatables-->
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/jquery.dataTables.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/dataTables.bootstrap.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/dataTables.buttons.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/buttons.bootstrap.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/jszip.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/pdfmake.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/vfs_fonts.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/buttons.html5.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/buttons.print.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/dataTables.fixedHeader.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/dataTables.keyTable.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/dataTables.responsive.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/responsive.bootstrap.min.js"></script>
        <script src="<%=request.getContextPath() %>/resources/production/js/datatables/dataTables.scroller.min.js"></script>


        <!-- pace -->
        <script src="js/pace/pace.min.js"></script>
        <script>
          var handleDataTableButtons = function() {
              "use strict";
              0 !== $("#datatable-buttons").length && $("#datatable-buttons").DataTable({
                dom: "Bfrtip",
                buttons: [{
                  extend: "copy",
                  className: "btn-sm"
                }, {
                  extend: "csv",
                  className: "btn-sm"
                }, {
                  extend: "excel",
                  className: "btn-sm"
                }, {
                  extend: "pdf",
                  className: "btn-sm"
                }, {
                  extend: "print",
                  className: "btn-sm"
                }],
                responsive: !0
              })
            },
            TableManageButtons = function() {
              "use strict";
              return {
                init: function() {
                  handleDataTableButtons()
                }
              }
            }();
        </script>
        <script type="text/javascript">
          $(document).ready(function() {
            $('#datatable').dataTable({
            	responsive : true,
				language : {
					"sProcessing" : "Đang xử lý...",
					"sLengthMenu" : "Xem _MENU_ mục",
					"sZeroRecords" : "Không tìm thấy dòng nào phù hợp",
					"sInfo" : "Đang xem _START_ đến _END_ trong tổng số _TOTAL_ mục",
					"sInfoEmpty" : "Đang xem 0 đến 0 trong tổng số 0 mục",
					"sInfoFiltered" : "(được lọc từ _MAX_ mục)",
					"sInfoPostFix" : "",
					"sSearch" : "Tìm:",
					"sUrl" : "",
					"oPaginate" : {
						"sFirst" : "Đầu",
						"sPrevious" : "Trước",
						"sNext" : "Tiếp",
						"sLast" : "Cuối"
					}
				}
            });
          });
          TableManageButtons.init();
        </script>
		
	</tiles:putAttribute>

</tiles:insertTemplate>