<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html>

<head>
	<title>Users list</title>
</head>

<body>

	<div id="wrapper">
		<div id="header">
			<h2>URM - User Relationship Manager</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			
			<form action="list" method="post"> 
				<input id="value1" type="submit" value="Put data in database" onclick="saveUsers"/>
			</form>
		
			<table>
				<tr>
					<th> Name </th>
					<th> Win_pts </th>
					<th> Draw_pts </th>
					<th> Level </th>
				</tr>
				
				<c:forEach var="tempUser" items="${users}">
					<tr>
						<td> ${tempUser.name} </td>
						<td> ${tempUser.level} </td>
						<td> ${tempUser.win_pts} </td>
						<td> ${tempUser.draw_pts} </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>