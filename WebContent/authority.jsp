<%@ page language="java" contentType="text/html; charset=GB2312"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>普通用户页面</title>
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
					<li class="layui-nav-item"><a href="javascript:;">authority</a></li>
					<li class="layui-nav-item x-index"><a href="index.html">返回上一页</a></li>
				</ul>
			</div>
		</div>
		<div class="layui-side layui-bg-black x-side">
			<div class="layui-side-scroll">
				<ul class="layui-nav layui-nav-tree site-demo-nav" lay-filter="side">
					    <!--普通用户个人信息-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="#">
                                <i style="top: 3px;"></i><cite></cite>
                            </a>
                        </li>

                        <!--普通用户查看书籍信息-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="lookAllBook1">
                                <i class="layui-icon" style="top: 3px;">&#xe62d;</i><cite>书籍信息</cite>
                            </a>
                        </li>
                                           
                        
                        <!--普通用户查看个人借书记录-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="findLendBook">
                                <i class="layui-icon" style="top: 3px;">&#xe62d;</i><cite>借书记录</cite>
                            </a>
                        </li>
                        
                        <!--普通用户查看个人还书记录-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="javascript:;" _href="findReturnBook">
                                <i class="layui-icon" style="top: 3px;">&#xe62d;</i><cite>还书记录</cite>
                            </a>
                        </li>

					
						
						<!--用户注销管理-->
                        <li class="layui-nav-item">
                            <a class="javascript:;" href="logoutServlet">
                                <i class="layui-icon" style="top: 3px;">&#xe62d;</i><cite>用户注销管理</cite>
                            </a>
                        </li>
				</ul>
			</div>
			
		</div>
		
		<div class="layui-tab layui-tab-card site-demo-title x-main"
			lay-filter="x-tab" lay-allowclose="true">
			<div class="x-slide_left"></div>
			<ul class="layui-tab-title">
				<li class="layui-this">个人信息<i
					class="layui-icon layui-unselect layui-tab-close"></i>
				</li>
			</ul>
			<div class="layui-tab-content site-demo site-demo-body">
				<div class="layui-tab-item layui-show">
					<iframe frameborder="0" src="LookAuthority.jsp" class=" x-iframe"></iframe>
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