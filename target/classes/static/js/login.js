function login() {
	  	$("#error").html("");
	  	var name=$("#username").val().trim();
	  	var password=$("#password").val().trim();
	  	if(name==""){
	  		$("#error").html("用户名不能为空");
	  		return;
	  	}
	  	if(password==""){
	  		$("#error").html("密码不能为空");
	  		return;
	  	}
	  	$.ajax({
	  		url:"login/login.do",
	  		type:"post",
	  		data:{"username":name,"password":password},
	  		success:function(result){
	  			console.log(result.status);
	  			if(result.status==0){
	  				localStorage.setItem("username",name);
	  				window.location.href="/index";
	  			}else if(result.status==1){
	  				$("#errorU").html("用户未注册");
	  			}else if(result.status==2){
	  				$("#errorP").html("用户名或密码不正确");
	  			}
	  		},
	  		error:function(result){
	  			alert("未知错误请联系管理员");
	  		}
	  	});
	  }
	  
	  
	  $(document).ready(function(){
	  	
	  	$("#username").keydown(function(event){
	  		console.log(event.which);
	  		 if(event.which==13){
	  			 var name=$("#username").val().trim();
	  				if(name==""){
	  					$("#errorU").html("用户名不能为空");
	  					$("#username").focus();
	  					return;
	  				}
	  				$("#password").focus();
	  				$("#password").val("");
	  		 }
	  	});
	  	$("#password").keydown(function(event){
	  		if(event.which==13){
	  			login();	
	  		}
	  	});
	  });
	  
