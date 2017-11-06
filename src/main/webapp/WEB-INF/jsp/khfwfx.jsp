<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@include file="../common/head.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<body>
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
$(function(){
	var myChart = echarts.init(document.getElementById('main'));
//异步加载数据
$.post('${ctx}/customer/findkhfw.action',
		function(result){
			if(result.status == Util.SUCCESS) {
				var xAxisData=new Array();
					var seriesData=new Array();
					var data = result.data;
		        	// 填入数据
					option = {
						   

						    title: {
						        text: '客户服务分析',
						        left: 'center',
						        top: 20,
						        textStyle: {
						            color: '#ccc'
						        }
						    },

						    tooltip : {
						        trigger: 'item',
						        formatter: "{a} <br/>{b} : {c} ({d}%)"
						    },
						    
						    legend: {
						        orient: 'vertical',
						        left: 'left',
						        data: [data[0].serviceType,data[1].serviceType,data[2].serviceType]
						    },
						    series : [
						        {
						            name:'客户服务',
						            type:'pie',
						            radius : '55%',
						            center: ['50%', '50%'],
						            data:[
							                {value:data[0].num, name:data[0].serviceType},
							                {value:data[1].num, name:data[1].serviceType},
							                {value:data[2].num, name:data[2].serviceType},
						            ] ,
						            itemStyle: {
						                emphasis: {
						                    shadowBlur: 10,
						                    shadowOffsetX: 0,
						                    shadowColor: 'rgba(0, 0, 0, 0.5)'
						                }
						            }
						        }
						    ]
						};
					myChart.setOption(option);
			} else {
				alert("查询失败");
			}
	        	
		},
		'json'
	);
})
</script>
</body>
</html>