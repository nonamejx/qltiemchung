<%@page import="com.qltiemchung.model.bean.LoaiVacxin"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.qltiemchung.model.bean.Vacxin"%>
<%@page import="com.qltiemchung.model.bean.MessageState"%>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<tiles:insertTemplate template="../templates/admin-template.jsp" >

	<tiles:putAttribute name="content">
		<div class="">
			<div class="page-title" style="margin-bottom: 50px">
				<div class="title_left">
					<h3>Vacxin</h3>
				</div>

				<div class="title_right">
					
				</div>
			</div>
			<div class="clearfix"></div>

			<div class="row">

				<div class="col-md-12 col-sm-12 col-xs-12">
					<div class="x_panel">
						<div class="x_title">
							<h2>Thông tin vacxin</h2>
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
							<form class="form-horizontal form-label-left" novalidate action="<%=request.getContextPath()%>/doVacxinCapNhat" method="post">
							<% 	Vacxin vacxin = (Vacxin) request.getAttribute("vacxin");%>
								<input type="hidden" name="maVacxin" value="<%=vacxin.getMaVacxin()%>">
								<div class="item form-group">
									<label class="control-label col-md-3 col-sm-3 col-xs-12"
										for="name">Tên vacxin<span class="required">*</span></label>
									<div class="col-md-6 col-sm-6 col-xs-12">
										<input id="ten" class="form-control col-md-7 col-xs-12" value="<%=vacxin.getTenVacxin()%>"
											data-validate-length-range="6"
											name="tenVacxin" placeholder="Tên đầy đủ, ví dụ: Pentaxin"
											required="required" type="text">
									</div>
								</div>
								<div class="item form-group">
			                      	<label class="control-label col-md-3 col-sm-3 col-xs-12">Loại vacxin<span class="required">*</span></label>
			                      	<div class="col-md-6 col-sm-6 col-xs-12">
			                        	<select class="form-control" name="loaiVacxin">
											<c:if test="${DanhSachLoaiVacxin.size()!=null && DanhSachLoaiVacxin.size()>0}">
												<%	ArrayList<LoaiVacxin> dsLoaiVacxin = (ArrayList<LoaiVacxin>) request.getAttribute("DanhSachLoaiVacxin");
												%>
												<% for (LoaiVacxin loaiVx : dsLoaiVacxin) { %>
													<option value="<%=loaiVx.getMaLoai()%>" <%if(loaiVx.getMaLoai()==vacxin.getMaLoai()){%>selected<% } %>><%=loaiVx.getTenLoai()%></option>
												<% } %>
											</c:if>
			                        	</select>
			                      	</div>
		                      	</div>
								<div class="item form-group">
			                      	<label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">Tác dụng </label>
			                      	<div class="col-md-6 col-sm-6 col-xs-12"	>
			                        	<textarea rows="5" name="tacDung" class="form-control col-md-7 col-xs-12"><c:out value="<%=vacxin.getTacDung()%>"></c:out> </textarea>
			                      	</div>
		                    	</div>
								<div class="item form-group">
			                      	<label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">Chỉ định </label>
			                      	<div class="col-md-6 col-sm-6 col-xs-12"	>
			                        	<textarea rows="5" name="chiDinh" class="form-control col-md-7 col-xs-12"><c:out value="<%=vacxin.getChiDinh()%>"></c:out> </textarea>
			                      	</div>
		                    	</div>
								<div class="item form-group">
			                      	<label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">Chống Chỉ định </label>
			                      	<div class="col-md-6 col-sm-6 col-xs-12"	>
			                        	<textarea rows="5" name="chongChiDinh" class="form-control col-md-7 col-xs-12"><c:out value="<%=vacxin.getChongChiDinh()%>"></c:out> </textarea>
			                      	</div>
		                    	</div>
		                    	<div class="item form-group">
			                      	<label class="control-label col-md-3 col-sm-3 col-xs-12" for="textarea">Tác dụng phụ </label>
			                      	<div class="col-md-6 col-sm-6 col-xs-12"	>
			                        	<textarea rows="5" name="tacDungPhu" class="form-control col-md-7 col-xs-12"><c:out value="<%=vacxin.getTacDungPhu()%>"></c:out> </textarea>
			                      	</div>
		                    	</div>
								<div class="ln_solid"></div>
								<div class="form-group">
									<div class="col-md-6 col-md-offset-3">
										<button id="send" type="submit" class="btn btn-success">Cập nhật</button>
										<a href="<%=request.getContextPath() %>/VacxinDanhSachServlet" class="btn btn-default">Hủy</a>
									</div>
								</div>
							</form>
							
						</div>
						
					</div>
				</div>
			</div>
		</div>
	</tiles:putAttribute>
	
	<tiles:putAttribute name="javascript-source">
		<!-- input mask -->
		<script
			src="<%=request.getContextPath()%>/resources/production/js/input_mask/jquery.inputmask.js"></script>
		<!-- input_mask -->
	  	<script>
	    	$(document).ready(function() {
	      		$(":input").inputmask();
	    	});
	  	</script>
	  	<!-- /input mask -->
		<!-- form validation -->
		<script
			src="<%=request.getContextPath()%>/resources/production/js/validator/validator.js"></script>
		<script>
			// initialize the validator function
			validator.message['date'] = 'not a real date';

			// validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
			$('form').on('blur',
					'input[required], input.optional, select.required',
					validator.checkField).on('change', 'select.required',
					validator.checkField).on('keypress',
					'input[required][pattern]', validator.keypress);

			$('.multi.required').on('keyup blur', 'input', function() {
				validator.checkField.apply($(this).siblings().last()[0]);
			});

			// bind the validation to the form submit event
			//$('#send').click('submit');//.prop('disabled', true);

			$('form').submit(function(e) {
				e.preventDefault();
				var submit = true;
				// evaluate the form using generic validaing
				if (!validator.checkAll($(this))) {
					submit = false;
				}

				if (submit)
					this.submit();
				return false;
			});

			/* FOR DEMO ONLY */
			$('#vfields').change(function() {
				$('form').toggleClass('mode2');
			}).prop('checked', false);

			$('#alerts').change(function() {
				validator.defaults.alerts = (this.checked) ? false : true;
				if (this.checked)
					$('form .alert').remove();
			}).prop('checked', false);
		</script>
	</tiles:putAttribute>

</tiles:insertTemplate>