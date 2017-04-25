$(function ( ) {
	
function updateList( ) {
	var $prev = $wing_btn.find('.wing_btn_prev');
	var $next = $wing_btn.find('.wing_btn_next');
	
	if(currentIndex ==0){
		$prev.addClass('.disable');
	}else{
		$prev.removeClass('.disbale')
	}
	

}

$wing_btn.on('click',function(event){
	event.preventDefault;
	
	}
	
})

$wing_btn.on('click',function(){
	var $wingRecentPrd_1 = $('$wingRecentPrd_1')
	var $wingRecentPrd_2 = $('$wingRecentPrd_2')
	var $wingRecentPrd_3 = $('$wingRecentPrd_3')
	var $wingRecentPrd_4 = $('$wingRecentPrd_4')
	var $wingRecentPrd_5 = $('$wingRecentPrd_5')
	
	
})

});