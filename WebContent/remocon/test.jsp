<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>������</title>
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
<div id = "windBanner" class = "wing_banner"> <!-- ������ ���� -->
	<!-- //�ֱ� �� ��ǰ -->
	<div id = "wingRecentWrap" class = "wing_prd_wrap" style = ""> <!-- ������ �ܺ� -->
		<div class="hwrap">											<!-- �����丮�� �̵� -->
			<strong class = "tit">
				<a id = "wingRecentCount" href = "#">				
					<span class = "tx">�ֱ� ����ǰ</span>
					<span class="count">�ִ� 15</span>				<!-- �ִ��ǰ�� 15������. -->
					<span class = "ico"></span>	
				</a>
			</strong>
		</div>
		<div id = "windRecnetPrdList" class="wing_prd_list">			<!-- ��ǰ����Ʈ ��ü -->
			<ul id = "wingRecentPrd_1" style="" class = "">						<!-- 1������Ʈ �׷� -->
				<li id = "1-1" class="wing_prd">						<!-- 1���׷��� ù��° ��ǰ -->
					<a href = "http://www.sonyunara.com/shop/view.php?index_no=33113&cate=&myroute=main_new_arrival_item" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="http://img.sonyunara.com/files/goods/33113/1492067844_4.jpg">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name"> ��ǰ ����? �̸�?</span>	<!-- ��ǰ�� �̸�? -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>
				<li id = "1-2" class="wing_prd">						<!-- 1���׷��� �ι�° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name">�̸�?</span>				<!-- ��ǰ�� �̸� -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>					
				<li id = "1-3" class="wing_prd">						<!-- 1���׷��� ����° ��ǰ -->
					<a href = "http://www.sonyunara.com/shop/view.php?index_no=33113&cate=&myroute=main_new_arrival_item" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="http://img.sonyunara.com/files/goods/33113/1492067844_4.jpg">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name">�̸�</span>				<!-- ��ǰ�� �̸� -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>					
			</ul>
			<ul id = "wingRecentPrd_2" style="" class = "disable">			<!-- 2������Ʈ �׷� -->
				<li id = "2-1" class="wing_prd">						<!-- 2���׷��� ù��° ��ǰ -->
					<a href = "http://www.loveloveme.com/product/detail.html?product_no=23652&cate_no=1&display_group=12" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="http://www.loveloveme.com/web/product/medium/201704/23652_shop1_560408.jpg">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name"> ��ǰ ����? �̸�?</span>	<!-- ��ǰ�� �̸�? -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>
				<li id = "2-2" class="wing_prd">						<!-- 2���׷��� �ι�° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name">�̸�?</span>				<!-- ��ǰ�� �̸� -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>					
				<li id = "2-3" class="wing_prd">						<!-- 2���׷��� ����° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name">�̸�</span>				<!-- ��ǰ�� �̸� -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>					
			</ul>
			<ul id = "wingRecentPrd_3" style="" class = "disable">			<!-- 3������Ʈ �׷� -->
				<li id = "3-1" class="wing_prd">						<!-- 3���׷��� ù��° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name"> ��ǰ ����? �̸�?</span>	<!-- ��ǰ�� �̸�? -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>
				<li id = "3-2" class="wing_prd">						<!-- 3���׷��� �ι�° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name">�̸�?</span>				<!-- ��ǰ�� �̸� -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>					
				<li id = "3-3" class="wing_prd">						<!-- 3���׷��� ����° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name">�̸�</span>				<!-- ��ǰ�� �̸� -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>					
			</ul> 
			<ul id = "wingRecentPrd_4" style="" class = "disable">			<!-- 4������Ʈ �׷� -->
				<li id = "4-1" class="wing_prd">						<!-- 4���׷��� ù��° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name"> ��ǰ ����? �̸�?</span>	<!-- ��ǰ�� �̸�? -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>
				<li id = "4-2" class="wing_prd">						<!-- 4���׷��� �ι�° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name">�̸�?</span>				<!-- ��ǰ�� �̸� -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>					
				<li id = "4-3" class="wing_prd">						<!-- 4���׷��� ����° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name">�̸�</span>				<!-- ��ǰ�� �̸� -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>					
			</ul>
			<ul id = "wingRecentPrd_5" style="" class = "disable">			<!-- 5������Ʈ �׷� -->
				<li id = "5-1" class="wing_prd">						<!-- 5���׷��� ù��° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name"> ��ǰ ����? �̸�?</span>	<!-- ��ǰ�� �̸�? -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>
				<li id = "5-2" class="wing_prd">						<!-- 5���׷��� �ι�° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name">�̸�?</span>				<!-- ��ǰ�� �̸� -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>					
				<li id = "5-3" class="wing_prd">						<!-- 5���׷��� ����° ��ǰ -->
					<a href = "��ǰ��ũ" target="_blank">					<!-- �ش��ǰ�� �������� �ּ� -->
						<span class="wing_prd_img">
							<img alt="" src="�̹��� �ּ�">
						</span>
						<span class="wing_prd_info">					<!-- ��ǰ�� ���� -->
							<span class="p_name">�̸�</span>				<!-- ��ǰ�� �̸� -->
						</span>
					
					</a>				
					<button class="wing_btn_delete" type="button">��ǰ���� ��ư</button>
				</li>					
			</ul>
		</div> 
		<div class="wing_paging">
			<div class="wing_btn">
				<button id = "wb_btn_recentPrd_prev" class="wing_btn_prev" type="button">���� ��ǰ ���</button>
				<button id = "wb_btn_recentPrd_next" class="wing_btn_next" type="button">���� ��ǰ ���</button>
			</div>
		</div>
	</div>
	<div class = "btn_top">
		<a href="#">
			<img alt="������ ������� �̵�" src="�̹��� ����">
		</a>
	</div>
</body>
</html>