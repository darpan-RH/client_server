<!DOCTYPE html >
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta http-equiv="Pragma" content="no-cache">
<meta http-equiv="Cache-Control" content="no-cache">
<meta http-equiv="Expires" content="sat, 01 Dec 2001 00:00:00 GMT">
<title>FirstApp | User</title>
<link href="static/css/bootstrap.min.css" rel="stylesheet">
<link href="static/css/style.css" rel="stylesheet">
<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body>
	<div role="navigation">
		<div class="navbar navbar-inverse">
			<a href="/welcome" class="navbar-brand">FirstApp</a>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a href="/login">Login</a></li>
					<li><a href="/register">New Registration</a></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="container text-center" id="tasksDiv">
		<h3>User Data</h3>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>UserName</th>
						<th>First Name</th>
						<th>LastName</th>
						<th>Age</th>
						<th>Delete</th>
						<th>Edit</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="user" items="${users }">
						<tr>
							<td>${user.id}</td>
							<td>${user.username}</td>
							<td>${user.firstname}</td>
							<td>${user.lastname}</td>
							<td>${user.age}</td>
							<td><a href="/delete-user?id=${user.id }"><span
									class="glyphicon glyphicon-trash"></span></a></td>
							<td><a href="/edit-user?id=${user.id }"><span
									class="glyphicon glyphicon-pencil"></span></a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>

	<div class="container text-center" id="tasksDiv">
		<h3>Job Data</h3>
		<div class="table-responsive">
			<table class="table table-striped table-bordered">
				<thead>
					<tr>
						<th>Id</th>
						<th>Job Tile</th>
						<th>Description</th>
						<th>Status</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="job" items="${jobs }">
						<tr>
							<td>${job.id}</td>
							<td>${job.jobtitle}</td>
							<td>${job.jobdescription}</td>
							<td>${job.jobstatus}</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<div class="container text-center">
		<h3>Add Job</h3>
		<hr>
		<form class="form-horizontal" method="POST" action="add-job">
			<input type="hidden" name="id" value="${job.id }" />
			<div class="form-group">
				<label class="control-label col-md-3">Job Title</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="jobtitle"
						value="${job.jobtitle }" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Description</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="jobdescription"
						value="${job.jobdescription }" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-md-3">Status</label>
				<div class="col-md-7">
					<input type="text" class="form-control" name="jobstatus"
						value="${job.jobstatus }" />
				</div>
			</div>
			<div class="form-group ">
				<input type="submit" class="btn btn-primary" value="Add" />
			</div>
		</form>
	</div>


	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="static/js/jquery-1.11.1.min.js"></script>
	<script src="static/js/bootstrap.min.js"></script>
</body>
</html>