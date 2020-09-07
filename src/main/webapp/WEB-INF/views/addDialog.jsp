<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<div id="fullAddDialog" class="fullAddDialog">
	<div class="addDialog">
		<form>
			<h3>THÊM SẢN PHẨM</h3>
			<div class="group_Add">
				<p>Danh mục</p>
				<select></select>
				<p>Tên sản phẩm</p>
				<input type="text">
				<p>Giá</p>
				<input type="number">
				<p>Số lượng</p>
				<input type="number" min="1">
				<p>Nhà cung cấp</p>
				<input type="text">
			</div>
		</form>
		<button class="btnAdd">Thêm</button>
		<button onclick="funcBack()" class="btnBack">Quay lại</button>
	</div>
</div>
</html>