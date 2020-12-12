$(function(){
  $.ajax({
  	url:"/qryTitleList",
  	type:"post",
  	async:true,
  	success:function(result){
  		console.log(result);
  		for(var i=0;i<result.length;i++){
  			$("#listData").append(
  			"<tr>"+
  			  "<td>"+result[i].titleId+"</td>"+
  			  "<td>"+result[i].titleDesc+"</td>"+
  			"</tr>"
  			);
  		}
  	},
  	error:function(result){
  		alert("未知错误联系管理员！");
  	}
  });
});