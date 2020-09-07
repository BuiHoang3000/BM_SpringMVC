<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page import = "com.hoang.model.Product" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.14.0/css/all.min.css" />
	<script type="text/javascript" src="<%=request.getContextPath()%>/resources/js/jquery-3.5.1.min.js"></script>
	<title>Product</title>
</head>
<body>
<div class="main">
	<jsp:include page="sidebar_menu.jsp"></jsp:include>
	<div class="tbProduct">
	<div class="right_btn">
		<button class="btnAddProduct" onclick="btnAddPr()">Thêm</button>
		<button class="btnUpdateProduct" onclick="btnUpdatePr()">Sửa</button>
		<button class="btnDeleteProduct">Xoá</button>
		<button class="btnDetailProduct">Chi tiết</button>
	</div>
	<form:form action="/BM_SpringMVC/product" method="POST" modelAttribute="prForm">
		<table>
			<tr class="titleProduct">
				<th>Chọn</th>
				<th>ID</th>
				<th>Nhà cung cấp</th>
				<th>Tên sản phẩm</th>
				<th>Giá</th>
				<th>Số lượng</th>
				<th>Nhà cung cấp</th>
			</tr>
			<c:forEach items="${prList}" var="pr">
				<tr class="eachProduct">
					<td><input type="checkbox" value="${pr.getPr_ID()}" class="selectPr"></td>
					<td>${pr.getPr_ID()}</td>
					<td>${pr.getPr_CA()}</td>
					<td>${pr.getPr_Name()}</td>
					<td>${pr.getPr_Price()}</td>
					<td>${pr.getPr_Quantify()}</td>
					<td>${pr.getPr_SU()}</td>
				</tr>
			</c:forEach>
		</table>
		<div class="numOfPages">
			<c:forEach var="j" begin="1" step="1" end="${numOfPages}">
				<c:if test="${page == j && j != numOfPages}">${page} |</c:if>
				<c:if test="${page == j && j == numOfPages}">${page}</c:if>
				<c:if test="${page != j && j != numOfPages}"><a href="/BM_SpringMVC/product?page=${j}">${j}</a> |</c:if>
				<c:if test="${page != j && j == numOfPages}"><a href="/BM_SpringMVC/product?page=${j}">${j}</a></c:if>
			</c:forEach>
		</div>
	</form:form>
	</div>
</div>
<jsp:include page="addDialog.jsp"></jsp:include>
<jsp:include page="updateProduct.jsp"></jsp:include>

<script type="text/javascript">
	function btnAddPr(){
		var addDialog = document.getElementById('fullAddDialog');
		addDialog.style.display = "block";
	}
	
	function getCategory(){
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/BM_SpringMVC/category/getInfo",
			data : {
			},
			dataType : 'json',
			timeout: 100000,
			success : function(data) {
				if(data != null) {
					for (key in data) {
						if (typeof (data[key] == 'string'))
							$('#categoryPrUpdate').append('<option value="' + key + '">' + data[key].ca_Name + '</option>');
					}
				}
			}
		});
	}
	
	function getSupplier(){
		$.ajax({
			type : "GET",
			contentType : "application/json",
			url : "/BM_SpringMVC/supplier/getInfo",
			data : {},
			dataType : 'json',
			timeout: 100000,
			success : function(data) {
				if(data != null){
					for(key in data){
						if(typeof (data[key] == 'string'))
							$('#supplierPrUpdate').append('<option value="' + key + '">' + data[key].su_Name + '</option>');
					}
				}
			}
		});
	}
	
	function btnUpdatePr(){
		if(funcCheck() >= 0){
			var updateProduct = document.getElementById('updateProduct');
			updateProduct.style.display = "block";
			var idPr = funcCheck();
			
			// Get categories
			getCategory();
			
			// Get supplier
			getSupplier();
			
			// Get info product update
			$.ajax({
				type : "GET",
				contentType : "application/json",
				url : "/BM_SpringMVC/product/getInfo",
				data : {
					idPr : idPr
				},
				dataType : 'json',
				timeout : 100000,
				success : function(data) {
					console.log("SUCCESS: ", data);
					if (data != null) {
						$('#namePrUpdate').val(data[0].pr_Name);
						//document.getElementById('namePrUpdate').value = data[0].pr_Name;
						$('#pricePrUpdate').val(data[0].pr_Price);
						$('#quantifyPrUpdate').val(data[0].pr_Quantify);
					}
				},
				error : function(e) {
					console.log("ERROR: ", e);
				}
			});
		}
	}
	
	function updateProduct(){
		var idPr = funcCheck();
		$.ajax({
			type : "PUT",
			contentType : "text",
			url : "/BM_SpringMVC/updateProduct",
			data : {
				idPr : idPr,
				supplierPr : supplierPr,
				namePr : namePr,
				pricePr : pricePr,
				quantifyPr : quantifyPr,
				supplierPr : supplierPr
			},
			dataType : 'text',
			timeout : 100000,
			success : function(data){
				if(data == "success")
					$('#notificationUpdate').val("Cập nhật thành công!");
				else
					$('#notificationUpdate').val("Cập nhật thất bại!");
			}
		});
	}
	
	function funcCheck() {
		  var checkboxPr = document.getElementsByClassName("selectPr");
		  var sp = 0;
		  var idUpdate;
		  for(var i=0;i<checkboxPr.length;i++){
				if(checkboxPr[i].checked){
					idUpdate = checkboxPr[i].value;
					sp++;
				}
			}
		  if(sp == 0)
			  alert("Bạn chưa chọn sản phẩm nào");
		  else {
			  if(sp > 1)
				  alert("Bạn chỉ có thể sửa 1 sản phẩm");
			  else {
				  return idUpdate;
			  }
		  }
	  };
	
	function funcBack(){
		document.getElementById('fullAddDialog').style.display = "none";
		document.getElementById('updateProduct').style.display = "none";
	}
</script>
</body>
</html>