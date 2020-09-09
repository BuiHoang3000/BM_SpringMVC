<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<div id="updateProduct" class="updateProduct">
		<div class="updateProductDialog">
			<form>
				<h3>CẬP NHẬT SẢN PHẨM</h3>
				<div class="group_Update_Pr">
					<p>Danh mục</p>
					<select id="categoryPrUpdate"></select>
					<p>Tên sản phẩm</p>
					<input type="text"  id="namePrUpdate">
					<p>Giá</p>
					<input type="number" min="0" id="pricePrUpdate">
					<p>Số lượng</p>
					<input type="number" min="1" id="quantifyPrUpdate">
					<p>Nhà cung cấp</p>
					<select id="supplierPrUpdate"></select>
				</div>
				<div id="notificationUpdate" class="notificationUpdate"></div>
			</form>
			<button onclick="updateProduct()" class="btnUpdatePr">Cập nhật</button>
			<button onclick="funcBack()" class="btnBack">Quay lại</button>
		</div>
	</div>
</html>