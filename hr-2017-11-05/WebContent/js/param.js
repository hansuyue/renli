/*
 *获得请求参数的jq插件 
 * 
 * */

$.extend({
	
	getParam:function(key){
		url = location.href;
				
		var index = url.indexOf('?');
			
		var str = url.substr(index + 1);
				
		var arr = str.split('&');//按照&分解字符串
		
		console.log(arr);
				
		for(i = 0;i < arr.length;i ++){
			
			var param = arr[i].split('=');
			
			console.log(param[0]);
			
			if(param[0] == key)
				return param[1];
			
		}
	}
	
	
});
