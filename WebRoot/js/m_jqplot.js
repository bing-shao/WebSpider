var j = {jqplot :{}};
j.jqplot.diagram = {
	/**
	 * document: 输出图形的位置id
	 * s：柱状图数据 
	 * title：每一个柱状对应的名称 
	 * ticks:x轴显示数据
	 * x_label:x轴名称
	 * y_label:y轴名称
	 * t: 1：曲线图 2：柱状图 3：饼图
	 */
	base : function(document, s, xtitle, title, ticks, x_label, y_label, max, t){
		if(t==1||t==2){
			var renderer;
			if(t == 1) renderer = $.jqplot.BlockRenderer ;
			else if(t == 2) renderer = $.jqplot.BarRenderer ;
			var plot3 = $.jqplot(document, s, {
				title: title,
				legend:{show:true,labels: xtitle},
				animate:true,
				seriesDefaults: {  
			       renderer: renderer, // 利用渲染器（BarRenderer）渲染现有图表  
			       pointLabels: { show: true }  
			    },
				axes:{
					yaxis:{
			    		label: y_label==null?"":y_label,
			    		max : max
					},
					xaxis:{
						renderer: $.jqplot.CategoryAxisRenderer, // 设置横（纵）轴上数据加载的渲染器,
						ticks: ticks,
			        	label: x_label==null?"":x_label
					}
				}, 
				series:[{color:'#5FAB78'}] 
			});
		}
        if(t ==3){
        	$.jqplot(document,s,{
        		 title: title,
        		 seriesDefaults: {
                     renderer: $.jqplot.PieRenderer,
                     rendererOptions: {
                         showDataLabels: true
                     }
                 },
                 legend: {
                     show: true,
                     location: "e"
                 }
        	});
        }
	}
};