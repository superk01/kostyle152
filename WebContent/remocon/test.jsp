<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>리모콘</title>
<link rel="stylesheet" type="text/css" href="remocon.css">
<script src="remocon.js"></script>
<script src="jquery/jquery-3.2.1.js"></script>
<script type="text/javascript" src="remocon.js"></script>
<script type="text/javascript">

/* $(function(){
	$(".wing_btn_next").click(function(){
		$("#wingRecentPrd_1").addClass('disable');
		$("#wingRecentPrd_2").removeClass('disable');
	})
	
})
 */
	

</script>
</head>
<body>
<div id = "windBanner" class = "wing_banner"> <!-- 리모콘 전제 -->
	<!-- //최근 본 상품 -->
	<div id = "wingRecentWrap" class = "wing_prd_wrap" style = ""> <!-- 리모콘 외부 -->
		<div class="hwrap">											<!-- 히스토리로 이동 -->
			<strong class = "tit">
				<a id = "wingRecentCount" href = "#">				
					<span class = "tx">최근 본상품</span>
					<span class="count">최대 15</span>				<!-- 최대상품은 15개까지. -->
					<span class = "ico"></span>	
				</a>
			</strong>
		</div>
		<div id = "windRecnetPrdList" class="wing_prd_list">			<!-- 상품리스트 전체 -->
			<ul id = "wingRecentPrd_1" style="" class = "">						<!-- 1번리스트 그룹 -->
				<li id = "1-1" class="wing_prd">						<!-- 1번그룹의 첫번째 상품 -->
					<a href = "http://www.sonyunara.com/shop/view.php?index_no=33113&cate=&myroute=main_new_arrival_item" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="http://img.sonyunara.com/files/goods/33113/1492067844_4.jpg">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name"> 상품 설명? 이름?</span>	<!-- 상품의 이름? -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>
				<li id = "1-2" class="wing_prd">						<!-- 1번그룹의 두번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name">이름?</span>				<!-- 상품의 이름 -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>					
				<li id = "1-3" class="wing_prd">						<!-- 1번그룹의 세번째 상품 -->
					<a href = "http://www.sonyunara.com/shop/view.php?index_no=33113&cate=&myroute=main_new_arrival_item" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="http://img.sonyunara.com/files/goods/33113/1492067844_4.jpg">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name">이름</span>				<!-- 상품의 이름 -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>					
			</ul>
			<ul id = "wingRecentPrd_2" style="" class = "disable">			<!-- 2번리스트 그룹 -->
				<li id = "2-1" class="wing_prd">						<!-- 2번그룹의 첫번째 상품 -->
					<a href = "http://www.loveloveme.com/product/detail.html?product_no=23652&cate_no=1&display_group=12" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="http://www.loveloveme.com/web/product/medium/201704/23652_shop1_560408.jpg">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name"> 상품 설명? 이름?</span>	<!-- 상품의 이름? -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>
				<li id = "2-2" class="wing_prd">						<!-- 2번그룹의 두번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name">이름?</span>				<!-- 상품의 이름 -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>					
				<li id = "2-3" class="wing_prd">						<!-- 2번그룹의 세번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name">이름</span>				<!-- 상품의 이름 -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>					
			</ul>
			<ul id = "wingRecentPrd_3" style="" class = "disable">			<!-- 3번리스트 그룹 -->
				<li id = "3-1" class="wing_prd">						<!-- 3번그룹의 첫번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name"> 상품 설명? 이름?</span>	<!-- 상품의 이름? -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>
				<li id = "3-2" class="wing_prd">						<!-- 3번그룹의 두번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name">이름?</span>				<!-- 상품의 이름 -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>					
				<li id = "3-3" class="wing_prd">						<!-- 3번그룹의 세번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name">이름</span>				<!-- 상품의 이름 -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>					
			</ul> 
			<ul id = "wingRecentPrd_4" style="" class = "disable">			<!-- 4번리스트 그룹 -->
				<li id = "4-1" class="wing_prd">						<!-- 4번그룹의 첫번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name"> 상품 설명? 이름?</span>	<!-- 상품의 이름? -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>
				<li id = "4-2" class="wing_prd">						<!-- 4번그룹의 두번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name">이름?</span>				<!-- 상품의 이름 -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>					
				<li id = "4-3" class="wing_prd">						<!-- 4번그룹의 세번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name">이름</span>				<!-- 상품의 이름 -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>					
			</ul>
			<ul id = "wingRecentPrd_5" style="" class = "disable">			<!-- 5번리스트 그룹 -->
				<li id = "5-1" class="wing_prd">						<!-- 5번그룹의 첫번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name"> 상품 설명? 이름?</span>	<!-- 상품의 이름? -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>
				<li id = "5-2" class="wing_prd">						<!-- 5번그룹의 두번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name">이름?</span>				<!-- 상품의 이름 -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>					
				<li id = "5-3" class="wing_prd">						<!-- 5번그룹의 세번째 상품 -->
					<a href = "상품링크" target="_blank">					<!-- 해당상품의 상세페이지 주소 -->
						<span class="wing_prd_img">
							<img alt="" src="이미지 주소">
						</span>
						<span class="wing_prd_info">					<!-- 상품의 정보 -->
							<span class="p_name">이름</span>				<!-- 상품의 이름 -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">상품제거 버튼</button>
				</li>					
			</ul>
		</div> 
		<div class="wing_paging">
			<div class="wing_btn">
				<button id = "wb_btn_recentPrd_prev" class="wing_btn_prev" type="button">이전 상품 목록</button>
				<button id = "wb_btn_recentPrd_next" class="wing_btn_next" type="button">다음 상품 목록</button>
			</div>
		</div>
	</div>
	<div class = "btn_top">
		<a href="#">
			<img alt="페이지 상단으로 이동" src="이미지 파일">
		</a>
	</div>
</body>
</html>