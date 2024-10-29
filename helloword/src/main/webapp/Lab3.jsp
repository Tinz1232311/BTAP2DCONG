<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Table</title>
<style>
	html, body
	{
		margin: 0;
	}
	table, h1
	{
		margin-left: 5px;
	}
	table.table1
	{
		width: 50%;
		border-collapse: collapse;
	}
	table.table2
	{
		width: 50%;
		border: none;
	}
	table.table3
	{
		width: 30%;
		border-collapse: collapse;
	}
	table.table1 th, table.table1 td,
	table.table2 th, table.table2 td 
	{
		padding: 5px;
		text-align: left;
	    font-family: Arial;
	}
	table.table3 th, table.table3 td
	{
		padding: 5px;
		text-align: center;
		font-family: Arial;
		font-size: 8px;
	}
	tr
	{
		border: 1px solid black;
	}
	table tr:nth-child(even)
	{
		background-color: white;
		color: black;
	}
	table tr:nth-child(odd)
	{
		background-color: #EEEE;
		color: black;
	}
	table tr:hover
	{
		background-color: cyan;
		color: black;
	}
	thead 
	{
    	background-color: white;
    	color: black;
	}
	thead th 
	{
    	background-color: white;
	}
</style>
</head>
<body>
<div>
	<h1>Mode 1</h1>
	<table class="table1">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Points</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Jill</td>
				<td>Smith</td>
				<td>50</td>
			</tr>
			<tr>
				<td>Eve</td>
				<td>Jackson</td>
				<td>90</td>
			</tr>
			<tr>
				<td>Adam</td>
				<td>Johnson</td>
				<td>67</td>
			</tr>
		</tbody>
	</table>
</div>
<div>
	<h1>Mode 2</h1>
	<table class="table2">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Points</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Jill</td>
				<td>Smith</td>
				<td>50</td>
			</tr>
			<tr>
				<td>Eve</td>
				<td>Jackson</td>
				<td>90</td>
			</tr>
			<tr>
				<td>Adam</td>
				<td>Johnson</td>
				<td>67</td>
			</tr>
		</tbody>
	</table>
</div>
<div>
	<h1>Tiny Table</h1>
	<table class="table3">
		<thead>
			<tr>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Points</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td>Jill</td>
				<td>Smith</td>
				<td>50</td>
			</tr>
			<tr>
				<td>Eve</td>
				<td>Jackson</td>
				<td>90</td>
			</tr>
			<tr>
				<td>Adam</td>
				<td>Johnson</td>
				<td>67</td>
			</tr>
		</tbody>
	</table>
</div>
</body>
</html>