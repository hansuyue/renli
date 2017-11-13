//后端访问地址前缀
var baseUrl = 'http://localhost:7777/hr';

//全局ajax事件，处理ajax session超时问题

$.ajaxSetup({
	
	complete:function(xhr,textStatus){
		
		//通过ajax核心对象获得相应报头
		var sessionStstus = xhr.getResponseHeader('sessionStatus');
		
		if(sessionStstus == 'timeout'){
			
			alert('登录超时，请重新登录！');
			location.href = baseUrl + '/logout.jsp';
			
		}
		
		
	}
	
	
});
