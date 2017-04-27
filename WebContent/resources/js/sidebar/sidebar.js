$(function(){
	sidebarContentClick();
	
	//카테고리 슬라이드는 여기서 선언 
	var sidebarCheck = false;
	$('#sidebar').click(function(){
		if( sidebarCheck ){
			$(this).animate({"height" : "5%"},300,"swing",function(){
				$('#sidebarContent').css({"display" : "none"});			
				$('#sidebarTitle').css({"display" : "block"});
				sidebarCheck = false;
	    	  });						
		}else{
			$('#sidebarTitle').css({"display" : "none"});
			$('#sidebarContent').css({"display" : "block"});
			$(this).animate({"height" : "60%"},300,"swing",function(){
				sidebarCheck = true;
	    	  });						
		}
	});
});

function sidebarContentClick(){
	$('#sidebarContentOuter').click(function(){
		  location = "../category.do?keyword=100";
	});
	
	$('#sidebarContentTop').click(function(){
		  location = "../category.do?keyword=200";
	});
	
	$('#sidebarContentBottom').click(function(){
		  location = "../category.do?keyword=300";
	});
	
	$('#sidebarContentGer').click(function(){
		  location = "../category.do?keyword=101";
	});
	$('#sidebarContentBarge').click(function(){
		  location = "../category.do?keyword=301";
	});
	
	$('#sidebarContentZipup').click(function(){
		  location = "../category.do?keyword=102";
	});
	$('#sidebarContentJumper').click(function(){
		  location = "../category.do?keyword=103";
	});
	$('#sidebarContentJacket').click(function(){
		  location = "../category.do?keyword=104";
	});
	$('#sidebarContentCoat').click(function(){
		  location = "../category.do?keyword=105";
	});
	$('#sidebarContentShirt').click(function(){
		  location = "../category.do?keyword=201";
	});
	$('#sidebarContentBlouse').click(function(){
		  location = "../category.do?keyword=202";
	});
	$('#sidebarContentSkirt').click(function(){
		  location = "../category.do?keyword=302";
	});
	$('#sidebarContentOnepice').click(function(){
		  location = "../category.do?keyword=303";
	});
}

