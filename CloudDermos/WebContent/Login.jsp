<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html>
<html lang="ZH-cn">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta http-equiv="X-UA-Compatible" content="ie=edge">
  <title>Login</title>
  <link rel="stylesheet" href="dist/css/layui.css">
  <link rel="stylesheet" href="dist/css/login.css">
  <script src="http://www.jq22.com/jquery/jquery-1.10.2.js"></script>
  <script src="dist/jq_slideImage.js" type="text/javascript" charset="utf-8"></script>
  <style>
	.demo1{
		width: 100%;
		height: 300px;
	}
	.demo2{
		width: 300px;
		height: 200px;
	}
</style>
</head>

<body>
  <div class="kit-login">
    <div class="kit-login-bg"></div>
    <div class="kit-login-wapper">
      <h2 class="kit-login-slogan">欢迎使用 <br> 云端汽车维修后台管理 </h2>
      <div class="kit-login-form">
        <h4 class="kit-login-title">登录</h4>
        <form class="layui-form">
          <div class="kit-login-row">
            <div class="kit-login-col">
              <i class="layui-icon">&#xe612;</i>
              <span class="kit-login-input">
                            <input id="name" type="text" name="loginName" lay-verify="required" placeholder="用户名/邮箱/手机号" />
                        </span>
            </div>
            <div class="kit-login-col"></div>
          </div>
          <div class="kit-login-row">
            <div class="kit-login-col">
              <i class="layui-icon">&#xe64c;</i>
              <span class="kit-login-input">
                            <input id="pwd" type="password" name="password" lay-verify="required" placeholder="密码" />
                        </span>
            </div>
            <div class="kit-login-col"></div>
          </div>
          <div class="kit-login-row">
            <div class="kit-login-col">
              <input type="checkbox" name="rememberMe" value="true" title="记住帐号" lay-skin="primary">
            </div>
          </div>
          <div class="kit-login-row">
            <button class="layui-btn kit-login-btn" lay-submit="submit" lay-filter="login_hash">登录</button>
          </div>
          <div class="kit-login-row" style="margin-bottom:0;">
            <a href="javascript:;" style="color: rgb(153, 153, 153); text-decoration: none; font-size: 13px;" id="forgot">忘记密码</a>
          	<br/>
          	<span style="color: rgb(153, 153, 153); text-decoration: none; font-size: 13px;" >其他方式登录  &nbsp<a id="qqLoginBtn" href=""><img src="dist/images/Connect_logo_1.png"/></a></span>
          </div>
        </form>
      </div>
    </div>
  </div>
  <script src="dist/polyfill.min.js"></script>
  <script src="dist/layui.js"></script>
  <script>
    //'axios', 'lodash'
    layui.use(['layer', 'form'], function() {
      var form = layui.form,
        $ = layui.jquery;

      $('#forgot').on('click', function() {
        layer.msg('请联系管理员.');
      });

      //监听提交
      form.on('submit(login_hash)', function(data) {
        var layIndex = layer.load(2, {
          shade: [0.1, '#393D49']
        });
        var password=data.field.password;
        if(password.length<6){
        	 layer.msg('请输入六位有效密码');
     			 layer.close(layIndex);
     			 return false;
        }
        var formData =  $("form").serialize();
        $.post("servlet/LoginServlet?op=login",formData,function(res){
  					if(res>0){
 						    layer.open({
                        type:2,
                        title: false,
                        area: ['300px','200px'],
                        fixed :true,
                        closeBtn: 0,
                        resize :false,
                        btn :false,
                        shift: 2,
                        shadeClose: true,
                        content: 'test.jsp',
                        end :function(){
 						    	layer.close(layIndex);
                        }
                    });
  							
		          		/*setTimeout(function(){location.href='index.jsp';},500);*/
				        
  					}else{
  						layer.msg("账号或密码有误！");
  						 layer.close(layIndex);
  					}
  				})
        
/*      console.log(data.field);
        setTimeout(function() {
          location.href = 'servlet/LoginServlet?op=login&loginName=&pwd='+$("#name").val()+$("#pwd").val();
        }, 2000);*/
        // axios.post('/api/account/checklogin', data.field)
        //   .then(function(response) {
        //     if (response.status === 500) {
        //       throw new Error(response.statusText);
        //     }
        //     return response.data;
        //   })
        //   .then(function(res) {
        //     setTimeout(function() {
        //       if (res.success) {
        //         var to = getParams(location.href);
        //         location.href = to !== null && to.ReturnUrl !== undefined ? unescape(to.ReturnUrl) : '/';
        //       } else {
        //         layer.msg(res.message);
        //         layer.close(layIndex);
        //       }
        //     }, 500);
        //   })
        //   .catch(function(err) {
        //     console.log(err);
        //     layer.close(layIndex);
        //   });
        return false;
      });
    });

    // function getParams(href) {
    //   var p = href.substr(href.indexOf('?') + 1);
    //   if (href === p) return null;
    //   var params = p.split('&');
    //   var data = {};
    //   _.forEach(params, function(item, index) {
    //     var kv = item.split('=');
    //     var key = kv[0];
    //     var value = kv[1];
    //     data[key] = value;
    //   });
    //   return data;
    // }
  </script>
  <script type="text/javascript"  charset="utf-8"
    src="http://connect.qq.com/qc_jssdk.js"
    data-appid="101565169"
    data-redirecturi="http://www.biubiuboom.club/index.jsp"
></script>
<script type="text/javascript">
    QC.Login({
       btnId:"qqLoginBtn"	//插入按钮的节点id
});
    
</script>
</body>

</html>
