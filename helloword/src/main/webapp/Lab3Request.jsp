<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<style>
    table, th, td {
        border: 2px solid black;
        border-collapse: collapse;
        text-align: center;
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
	table
	{
		
		width: 25%;
		border-collapse: collapse;
	}
	table tr:hover
	{
		background-color: cyan;
		color: black;
	}
</style>
<h1> Hoverable Table</h1>
<table>
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
        <th rowspan="2" colspan="2">Points</th>
    </tr>
    <tr>
        <td>Jill</td>
        <td>Smith</td>

    </tr>
    <tr>
        <td rowspan="2">Eve</td>
        <td rowspan="1">Jackson</td>
        <td rowspan="2" colspan="1">1</td>
        <td rowspan="2" colspan="1">2</td>
    </tr>
        <td rowspan="2">Adam</td>
</table>
</html>