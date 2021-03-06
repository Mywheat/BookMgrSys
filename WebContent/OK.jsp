<%@ page language="java" contentType="text/html; charset=GB2312"
	pageEncoding="GB2312" import="java.util.*,cn.edu.lingnan.dto.SelectDTO"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=GB2312">
<title>登录成功页面</title>
</head>
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<meta name="description"
	content="Free HTML5 Website Template by sc.chinaz.com" />
<meta name="keywords" content="" />
<meta name="author" content="sc.chinaz.com" />

<link href="https://fonts.googleapis.com/css?family=Raleway"
	rel="stylesheet">
<link rel="stylesheet" href="css/bootstrapOK.min.css">
<link rel="stylesheet" href="css/styleOK.css">
</head>
<body>
	<nav
		class="navbar navbar-expand-lg navbar-dark bg-dark probootstrap-navabr-dark">
		<div class="container">
			<a class="navbar-brand" href="index.html">Congratulation</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#probootstrap-nav" aria-controls="probootstrap-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="probootstrap-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item probootstrap-cta probootstrap-seperator"><a
						href="index.html" class="nav-link">返回登录页面</a></li>
				</ul>
			</div>
		</div>
	</nav>


	<section class="probootstrap-cover">
		<div class="container">
			<div class="row probootstrap-vh-100 align-items-center text-center">
				<div class="col-sm">
					<div class="probootstrap-text">
						<h1 class="probootstrap-heading text-white mb-4">login in
							successfully!</h1>
						<div class="probootstrap-subheading mb-5">
							<p class="h4 font-weight-normal">你已经登录成功了喔！</p>
						</div>
						<p>						
						<form action="./Admin/admin.jsp" method="post">
							<input type="submit" name="btnLogin"
								class="btn btn-primary btn-outline-white mb-2" value="用户权限过滤" />
						</form>
						<!--  							<a href="Admin/admin.html" class="btn btn-primary btn-outline-white mb-2">用户权限过滤</a> -->
						<a href="logoutServlet" class="btn btn-primary mr-2 mb-2">用户账号注销</a>
						</p>
					</div>
				</div>
			</div>
		</div>
	</section>
	
</body>
</html>