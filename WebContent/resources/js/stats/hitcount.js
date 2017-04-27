$(function(){
	$('.button').click(function(){
		$(this).css('backgroun','red');
		$(this).append('<h3>hahaha</h3>');
		$(this).addClass('ddd');
	});
})

$(function(){
	$('a[href*=detail]').click(function(){
		var $imgSrc = $(this).find('img').attr('src').substring(2);
		var $shopUri = $imgSrc.split('/');
		
		var $detailURI = '/kostylemall/detail.ju'+$(this).attr('href').substring(20)+'&shopuri="'+$shopUri[0]+'"';
		
		$(this).attr('href',$detailURI);
	});
})
