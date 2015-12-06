<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.slj.basic.util.*" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'page.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<style type="text/css">
/*css manu style pagination*/
.manu{padding:3px;margin:3px;text-align:center;}
.manu a{border:#eee 1px solid;padding:2px 5px;margin:2px;color:#036cb4;text-decoration:none;}
.manu a:hover{border:#999 1px solid;color:#666;}
.manu a:active{border:#999 1px solid;color:#666;}
.manu .current{border:#036cb4 1px solid;padding:2px 5px;font-weight:bold;margin:2px;color:#fff;background-color:#036cb4;}
.manu .disabled{border:#eee 1px solid;padding:2px 5px;margin:2px;color:#ddd;}
</style>
<%
	Page<Goods> p = (Page<Goods>)request.getAttribute("page");
	for(Goods good : p.getResultList()) {
		out.println(good.getGoodsName() + " " + good.getGoodsmaterial() + "<br>");
	}
%>
</head>

<body>

	
	
	<div class="manu">
		<span class="disabled"> < Prev</span><span class="current">1</span><a
			href="#?page=2">2</a><a href="#?page=3">3</a><a href="#?page=4">4</a><a
			href="#?page=5">5</a><a href="#?page=6">6</a><a href="#?page=7">7</a>...<a
			href="#?page=199">199</a><a href="#?page=200">200</a><a
			href="#?page=2">Next > </a>
	</div>
</body>
</html>
