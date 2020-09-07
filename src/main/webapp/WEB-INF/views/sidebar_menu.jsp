<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<header>

	<!-- header area -->
	<div class="left_area">
		<img src="/BM_SpringMVC/resources/image/bm.jpg" class="logo_image" />
		<h3>Business Management</h3>
	</div>
	<div class="right_area">
		<label>Xin chào <b>${sessionScope.nameEmployee}!</b></label>
		<a href="/BM_SpringMVC/logout" class="logout_btn">Logout</a>
	</div>
	
	<!-- sidebar -->
	<div class="sidebar">
		<a href="#"><i class="fas fa-spa"></i><span>Sản phẩm</span></a>
		<a href="#"><i class="fas fa-user-friends"></i><span>Khách hàng</span></a>
		<a href="#"><i class="fas fa-user-tie"></i><span>Nhân viên</span></a>
		<a href="#"><i class="fas fa-file-invoice"></i><span>Hoá đơn</span></a>
		<a href="#"><i class="fas fa-file-invoice-dollar"></i><span>Chi tiết hoá đơn</span></a>
		<c:if test="${sessionScope.accType == 'Boss'}">
			<a href="#"><i class="fas fa-truck-moving"></i><span>Nhà cung cấp</span></a>
		</c:if>
		<a href="#"><i class="fas fa-align-justify"></i><span>Danh mục</span></a>
	</div>
	
</header>
</html>