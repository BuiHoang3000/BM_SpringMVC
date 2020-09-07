<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<div id="updateProduct" class="updateProduct">
		<div class="updateProductDialog">
			<form action="">
				<h3>CẬP NHẬT SẢN PHẨM</h3>
				<div class="group_Update_Pr">
					<p>Danh mục</p>
					<select></select>
					<p>Tên sản phẩm</p>
					<input type="text"  id="namePrUpdate">
					<p>Giá</p>
					<input type="number">
					<p>Số lượng</p>
					<input type="number" min="1">
					<p>Nhà cung cấp</p>
					<input type="text">
				</div>
			</form>
			<button class="btnUpdatePr">Cập nhật</button>
			<button onclick="funcBack()" class="btnBack">Quay lại</button>
		</div>
	</div>
</html>