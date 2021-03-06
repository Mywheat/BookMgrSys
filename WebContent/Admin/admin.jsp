<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>管理员页面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-Control" content="no-cache">
<meta http-equiv="expires" content="0">

<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="format-detection" content="telephone=no">
<link rel="stylesheet" href="./css/x-admin.css" media="all">
</head>
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header header header-demo">
			<div class="layui-main">
				<a class="logo"> <img src="images/banner2.png"></img>
				</a>
				<ul class="layui-nav" lay-filter="">
					<li class="layui-nav-item"><img src="images/0.jpg"
						class="layui-circle" style="border: 2px solid #A9B7B7;"
						width="35px" alt=""></li>
					<li class="layui-nav-item"><a href="javascript:;">admin</a></li>
					<li class="layui-nav-item x-index"><a href="../index.html">返回上一页</a></li>
				</ul>
			</div>
		</div>
		<div class="layui-side layui-bg-black x-side">
			<div class="layui-side-scroll">
				<ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
					<!--引导页面-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="../picture.html">
                                <i style="top: 3px;"></i>
                            </a>
                        </li>
                        
					<!--用户管理-->
					<li class="layui-nav-item"><a class="javascript:;"
						href="javascript:;"> <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>用户信息管理</cite>
					</a>
						<dl class="layui-nav-child">
							<dd class="">
							<dd class="">
								<a href="javascript:;" _href="lookAllReader"> <i
									class="layui-icon"></i><cite>查看用户</cite>
								</a>
							</dd>
							</dd>


							<dd class="">
							<dd class="">
								<a href="javascript:;" _href="findAllReader"> <i
									class="layui-icon"></i><cite>用户操作</cite>
								</a>
							</dd>
							</dd>

							<dd class="">
							<dd class="">
								<a href="javascript:;" _href="insertReaderIfo.jsp"> <i
									class="layui-icon"></i><cite>添加用户</cite>
								</a>
							</dd>
							</dd>
						</dl></li>

					<!--书籍信息管理-->
					<li class="layui-nav-item"><a class="javascript:;"
						href="javascript:;"> <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>书籍信息管理</cite>
					</a>
						<dl class="layui-nav-child">
							<dd class="">
							<dd class="">
								<a href="javascript:;" _href="lookAllBook"> <i
									class="layui-icon"></i><cite>查看书籍</cite>
								</a>
							</dd>
							</dd>


							<dd class="">
							<dd class="">
								<a href="javascript:;" _href="findAllBook"> <i
									class="layui-icon"></i><cite>书籍操作</cite>
								</a>
							</dd>
							</dd>

							<dd class="">
							<dd class="">
								<a href="javascript:;" _href="insertBookIfo.jsp"> <i
									class="layui-icon"></i><cite>添加书籍</cite>
								</a>
							</dd>
							</dd>
						</dl></li>

					<!--借阅记录管理-->
					<li class="layui-nav-item"><a class="javascript:;"
						href="javascript:;"> <i class="layui-icon" style="top: 3px;">&#xe629;</i><cite>借阅记录管理</cite>
					</a>
						<dl class="layui-nav-child">
							<dd class="">
							<dd class="">
								<a href="javascript:;" _href="lookLend_return"> <i
									class="layui-icon"></i><cite>查看借阅记录</cite>
								</a>
							</dd>
							</dd>
							<dd class="">
							<dd class="">
								<a href="javascript:;" _href="findLend_return"> <i
									class="layui-icon"></i><cite>借阅记录操作</cite>
								</a>
							</dd>
							</dd>
							<dd class="">
							<dd class="">
								<a href="javascript:;" _href="insertLend_return.jsp"> <i
									class="layui-icon"></i><cite>添加借阅记录</cite>
								</a>
							</dd>
							</dd>
						</dl></li>
						
						<!--用户注销管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="../logoutServlet">
                                <i class="layui-icon" style="top: 3px;">&#xe612;</i><cite>用户注销管理</cite>
                            </a>
                        </li>
				</ul>
			</div>

		</div>
		<div class="layui-tab layui-tab-card site-demo-title x-main"
			lay-filter="x-tab" lay-allowclose="true">
			<div class="x-slide_left"></div>
			<ul class="layui-tab-title">
				<li class="layui-this">FIRSTPAGE<i
					class="layui-icon layui-unselect layui-tab-close"></i>
				</li>
			</ul>
			<div class="layui-tab-content site-demo site-demo-body">
				<div class="layui-tab-item layui-show">
					<iframe frameborder="0" src="../picture.html" class=" x-iframe"></iframe>
				</div>
			</div>
		</div>
		<div class="site-mobile-shade"></div>
	</div>
	<script src="./lib/layui/layui.js" charset="utf-8"></script>
	<script src="./js/x-admin.js"></script>
	<script>
		var _hmt = _hmt || [];
		(function() {
			var hm = document.createElement("script");
			var s = document.getElementsByTagName("script")[0];
			s.parentNode.insertBefore(hm, s);
		})();
	</script>
</body>
</html>