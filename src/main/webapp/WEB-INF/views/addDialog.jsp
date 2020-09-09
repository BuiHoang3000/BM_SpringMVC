<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<div id="fullAddDialog" class="fullAddDialog">
	<div class="addProductDialog">
		<form>
			<h3>THÊM SẢN PHẨM</h3>
			<div class="group_Add">
				<p>Danh mục</p>
				<select id="categoryPrAdd"></select>
				<p>Tên sản phẩm</p>
				<input type="text" id="namePrAdd">
				<p>Giá</p>
				<input type="number" id="pricePrAdd">
				<p>Số lượng</p>
				<input type="number" min="1" id="quantifyPrAdd">
				<p>Nhà cung cấp</p>
				<select id="supplierPrAdd"></select>
			</div>
			<div id="notificationAdd" class="notificationAdd"></div>
		</form>
		<button class="btnAdd">Thêm</button>
		<button onclick="funcBack()" class="btnBack">Quay lại</button>
	</div>
</div>
</html>