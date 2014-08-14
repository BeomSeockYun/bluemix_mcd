<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <!-- 부트스트랩 -->
    <link href="resources/bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
<title>Insert title here</title>
</head>
<body>

<div class="page-header" align="center">
<h1>Legacy Simulation
<small>Push Test</small></h1>
</div>
<br><br>

<ul class="nav nav-tabs">
  <li class="active"><a href="#">Dashboard</a></li>
  <li><a href="#">Analytics</a></li>
  <li><a href="#">Inventory</a></li>
</ul>
<br><br>

<table calss="table">
<tr>
<td><h3>Product Name</h3></td>
<td>
<select id="product_name" class="form-control">
<option value="Big Mac">Bic Mac</option>
<option value="Crunch Burger">Crunch Burger</option>
<option value="Veggle Burger">Veggle Burger</option>
<option value="Quarter Pounder With Cheese">Quarter Pounder With Cheese</option>
<option value="Daily Double">Daily Double</option>
</select>
</td>
</tr>
</table>

<h1>Dashboard</h1>
판매 제품 이름 :  
<select id="product_name">
<option value="Big Mac">Bic Mac</option>
<option value="Crunch Burger">Crunch Burger</option>
<option value="Veggle Burger">Veggle Burger</option>
<option value="Quarter Pounder With Cheese">Quarter Pounder With Cheese</option>
<option value="Daily Double">Daily Double</option>
</select><br>
판매량 : <input type="number" id="product_count" /><br>
<br>
<button type="button"class="btn btn-primary btn-lg btn-block" id="dashboardBtn">INPUT</button>
<br><br>

<h1>Analytics</h1>
이벤트 이름 : <input type="text" id="event_info" /><br>
인원수 : <input type="number" id="attendance_count" /><br><br>
<button type="button"class="btn btn-primary btn-lg btn-block" id="analyticsBtn">INPUT</button>
<br><br>
<h1>Inventory</h1>
현재 수량 : <input type="text" id="current_level" /><br><br>
<button type="button"class="btn btn-primary btn-lg btn-block" id="inventoryBtn">INPUT</button>
<br><br>

<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>

<script>

// dashboard ajax
$("#dashboardBtn").click(function(){
	
	var product_name = $("#product_name").val();
	var product_count = $("#product_count").val();
	
	var data = {"product_name" : product_name,"product_count" : product_count};
	
	$.ajax({
		url : "/retail/v1/smartstore/dashboard/insertDamoData",
		type : "post",
		data : data,
		success : function(data){
			alert(data);
		}
	});
	
});

// analytics ajax
$("#analyticsBtn").click(function(){
	
	var event_info = $("#event_info").val(); // date
	var attendance_count = $("#attendance_count").val();
	
	var data = {"event_info" : event_info,"attendance_count" : attendance_count};
	
	$.ajax({
		url : "/retail/v1/smartstore/analytics/insertDemodata",
		type : "post",
		data : data,
		success : function(data){
			alert(data);
		}
	});
	
});

//inventory ajax
$("#inventoryBtn").click(function(){
	
	var current_level = $("#current_level").val();
	
	var data = {"current_level" : current_level};
	
	$.ajax({
		url : "/retail/v1/smartstore/inventory/updateDemodata",
		type : "post",
		data : data,
		success : function(data){
			alert(data);
		}
	});
	
});

</script>

</body>
</html>