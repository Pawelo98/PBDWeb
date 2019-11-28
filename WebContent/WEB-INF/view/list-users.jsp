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
					<th> Id </th>
					<th> Login </th>
					<th> Password </th>
				</tr>
				
				<c:forEach var="tempUser" items="${users}">
					<tr>
						<td> ${tempUser.id} </td>
						<td> ${tempUser.login} </td>
						<td> ${tempUser.password} </td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>

</body>

</html>