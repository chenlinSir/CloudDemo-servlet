$(function(){
	
	//tr1点击加输入框
	$(".tr1 td:odd").click(function(){
		var td=$(this);
		var txt=td.text();
		var input = $("<input type='text' value='" + txt + "'/>");
		input.height(td.height()-3).width(td.width()-3);
	  	td.html(input);
	  	input.trigger("focus");
	  	input.blur(function(){
	  		if(input.val()!=txt){
	  			td.html(input.val());
	  		}
	  	})
	 
	 
	 })
	//tr2点击加输入框
	$(".tr2 td:odd").click(function(){
		var td=$(this);
		var txt=td.text();
		var input = $("<input type='text' value='" + txt + "'/>");
		input.height(td.height()-3).width(td.width()-3);
	  	td.html(input);
	  	
	  	input.trigger("focus");
	  	input.blur(function(){
	  		if(input.val()!=txt){
	  			td.html(input.val());
	  		}
	  	})
	
	 
	 })
	//td点击加输入框
	$(".td").click(function(){
		var td=$(this);
		var txt=td.text();
		var input = $("<input type='text' value='" + txt + "'/>");
		input.height(td.height()-3).width(td.width()-3);
	  	td.html(input);
	  	input.trigger("focus");
	  	input.blur(function(){
	  		if(input.val()!=txt){
	  			td.html(input.val());
	  		}
	  	})
	
	 
	 })
	
	/*$(".span td").click(function(){
		var td=$(this);
		var txt=td.text();
		var input = $("<input type='text' value='" + txt + "'/>");
		input.height($(".span td").height()-4).width("40px");
		$(".span td:eq(1) font").css({position: "relative",'top':0,'left':0,'z-index':2});
		input.css({position: "relative",'top':0,'left':-4,'z-index':2});
		
	  	td.html(input);
	  	input.trigger("focus");
	  	input.blur(function(){
	  		if(input.val()!=txt){
	  			td.html(input.val());
	  		}else{
	  			td.html(input.val());
	  		}
	  	})
	
	 
	 })
	*/
	//.span下除前两个的点击事件
	$(".span td").click(function(){
		var td=$(this);
		var txt=td.text();
		var input = $("<input type='text' value='" + txt + "'/>");
		input.height($(".span td").height()-3).width(td.width()-3);
		
	  	td.html(input);
	  	input.trigger("focus");
	  	input.blur(function(){
	  		if(input.val()!=txt){
	  			td.html(input.val());
	  		}else{
	  			td.html(input.val());
	  		}
	  	})
	
	 
	 })
	
	//.Grow_up的点击事件
	$(".Grow_up td").click(function(){
		var td=$(this);
		var txt=td.text();
		var input = $("<input type='text' value='" + txt + "'/>");
		input.height(td.height()-3).width(td.width()-3);
		
	  	td.html(input);
	  	input.trigger("focus");
	  	input.blur(function(){
	  		if(input.val()!=txt){
	  			td.html(input.val());
	  		}else{
	  			td.html(input.val());
	  		}
	  	})
	
	 
	 })
	
	//。Train下的点击事件
	$(".Train td").click(function(){
		var td=$(this);
		var txt=td.text();
		var input = $("<input type='text' value='" + txt + "'/>");
		input.height(td.height()-3).width(td.width()-3);
		
	  	td.html(input);
	  	input.trigger("focus");
	  	input.blur(function(){
	  		if(input.val()!=txt){
	  			td.html(input.val());
	  		}else{
	  			td.html(input.val());
	  		}
	  	})
	
	 
	 })
	
	
	//。Situation下点击框
	$(".Situation td:gt(0)").click(function(){
		var td=$(this);
		var txt=td.text();
		var input = $("<input type='text' value='" + txt + "'/>");
		input.height(td.height()-3).width(td.width()-3);
		
	  	td.html(input);
	  	input.trigger("focus");
	  	input.blur(function(){
	  		if(input.val()!=txt){
	  			td.html(input.val());
	  		}else{
	  			td.html(input.val());
	  		}
	  	})
	
	 
	 })
	
})
