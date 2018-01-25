// JavaScript Document

function isMainCss(pathname){
	//var regexMain = /\/svm\/main$/;
	var regexMain = /\/*\/svm\/application/gi;
	var regexMain2 = /\/*\/svm\/application\/application/gi;
	if(regexMain.test(pathname)){
		if(!regexMain2.test(pathname)){
			$("#txt_go_register").hide();
			$("#txt_go_home").show();
		}
		else{
			$("#txt_go_register").show();
			$("#txt_go_home").hide();
		}
	}else{
		$("#txt_go_register").show();
		$("#txt_go_home").hide();
	}
}


//선택된 대메뉴
function on_menu(){
	$(".top_menu > ul > li").each(function(){
		if($(this).hasClass('on')){
			$(this).prev().addClass('before_01').css({"background":"#d63140"});
		}else{
			$(this).prev().removeClass('before_01');
		}
		
		var menu_num = $(".top_menu > ul > li").index(this);

		if(menu_num == 1){
			$(this).prev().addClass('first_01');

			var menu_02 = $(".top_menu > ul > li.on").index(this);
			if(menu_02 == 0){
				$(this).prev().removeClass('before_01').removeClass('first_01').css({"background":""}).addClass('first_01_add');
			}
		}
	});
}


//팝업 레이어(상하좌우 가운데 정렬)
function toggleLayer(obj, able) {
	if(able == "on") {
		var left = parseInt( $(window).scrollLeft() + ($(window).width() - obj.width()) / 2 );
		var top = parseInt( $(window).scrollTop() + ($(window).height() - obj.height()) / 2 );

		if(top < 0) top = 0;
		if(left < 0) left = 0;
		
		$('<div class="popup_dim"></div>').appendTo('body');
		obj.css({"left":left, "top":top}).addClass('PopupLayer');
		$('body').append(obj);

		wrap_mask();
		obj.show();
		
		
		if(obj.hasClass('pop_move')){
			//팝업 드래그
			$('.pop_move').draggable({
				cancel:'.pop_contents',
				containment:'window',
				opacity:0.7,
				scroll: true
			});
		}
	}

	if(able == "off") {
		obj.removeClass("PopupLayer").hide();
		if(!$('.pop_wrap_01').hasClass('PopupLayer')){
			$(".popup_dim").remove();
		}
	}
	
	//딤 클래스명 있으면 닫김
	if(obj.hasClass('dim_close')){
		$('.popup_dim').click(function(){
			$(this).remove();
			obj.removeClass("PopupLayer").hide();
		});
	}
}



//팝업 레이어 dim 영역 크기 브라우저 사이즈에 맞게 
function wrap_mask() { 
	var mask = $(".popup_dim");
	var maskHeight = $(document).height();
	var maskWidth = $(window).width();

	mask.css({'width':maskWidth,'height':maskHeight});
	mask.show();
}



//팝업 레이어 window 리사이즈 될 때 팝업 센터 위치로 이동 
function ResizingLayer() {
	if($(".popup_dim").css("display") == "block") {
		var maskHeight = $(document).height();
		var maskWidth = $(window).width();
		$(".popup_dim").css({'width':maskWidth,'height':maskHeight});  

		$(".PopupLayer").each(function () {
			var left = parseInt( $(window).scrollLeft() + ($(window).width() - $(this).width()) / 2 );
			var top = parseInt( $(window).scrollTop() + ($(window).height() - $(this).height()) / 2 );

			if(top < 0) top = 0;
			if(left < 0) left = 0;

			$(this).css({"left":left, "top":top});
		});
	}
}





//브라우저 버전 분기
function get_version_of_IE() {
    var word;
    var version = "N/A";
    var agent = navigator.userAgent.toLowerCase();
    var name = navigator.appName;
    // IE old version ( IE 10 or Lower ) 
    if (name == "Microsoft Internet Explorer") word = "msie ";
    else {
        // IE 11 
        if (agent.search("trident") > -1) word = "trident/.*rv:";
        // Microsoft Edge  
        else if (agent.search("edge/") > -1) word = "edge/";
    }
    var reg = new RegExp(word + "([0-9]{1,})(\\.{0,}[0-9]{0,1})");
    if (reg.exec(agent) != null) version = RegExp.$1 + RegExp.$2;
    return version;
}





$(function(){



	//브라우저 버전 분기
	var myTag = document.body;
	// 또는 var myTag = document.getElementById( "someId" ); 
	var callFunction = individual_case(myTag);
	
	function individual_case(tag) {
		var verNum = parseInt(get_version_of_IE());
		if (isNaN(verNum) || verNum >= 10){
			tag.className += " IE_10 Others";
		} 
		switch (verNum) {
			case 9: // verNum = 9 이면 
				tag.className += " IE_9";
				break;
			case 8: // verNum = 8 이면 
				tag.className += " IE_8";
				break;
			case 7:
				tag.className += " IE_7";
				break;
			case 6:
				tag.className += " IE_6";
				break;
		}
	}









	on_menu();

	//메뉴 hover
	$(".top_menu > ul > li").bind("focusin mouseenter", function(){
		var ul_height = $(this).children('ul').outerHeight();
		
		//console.log(ul_height);
		
		if($(this).children().length > 1){
			$(".top_menu_wrap").css({"border-bottom":"1px solid #dadada"});
		}else{
			$(".top_menu_wrap").css({"border-bottom":""});
		}
		
		$(".top_menu_wrap").stop().animate({"height": ul_height + 60 + "px", "border-color":"#dadada"}, 400, "easeOutCirc");
		//$(".top_menu_wrap").stop().animate({"height": "700px", "border-color":"#dadada"}, 300, "easeOutCubic"); 
		
		$(this).children('ul').slideDown(10);
		$(this).siblings().children('ul').slideUp(10);
		$(this).css({"background":"#7a0e18"});
		
		$(this).prev().addClass('before_01');
		$(this).siblings().css({"background":""});

		var li_width = $(".top_menu > ul > li").width();
		var depth_01_length = $(".top_menu > ul > li").length;
		var now_number = $(".top_menu > ul > li").index(this) + 1;
		var next_li_num = depth_01_length - now_number;
		var total = li_width * next_li_num;
		
		//console.log("depth_01_length:" + depth_01_length);
		//console.log("now_number:" + now_number);
		
		//★★ depth_01이 갖고 있는 depth_02의 메뉴 길이에 따라 수정
		if(depth_01_length == now_number){
			//맨 끝
			$(this).children('ul.txt_01').css({"margin-right": total + "px"});
		}else if(depth_01_length == now_number + 1){
			//끝에서 두번째
			//$(this).children('ul.txt_01').css({"margin-right": total - 100 + "px"});
			$(this).children('ul.txt_01').css({"right": "initial"});
		}else if(depth_01_length == now_number + 2){
			//끝에서 세번째
			$(this).children('ul.txt_01').css({"right": "initial"});
		}else if(depth_01_length == now_number + 3){
			//끝에서 네번째
			$(this).children('ul.txt_01').css({"right": "initial"});
		}else{
			//나머지
			$(this).children('ul.txt_01').css({"right": "initial"});
		}
		
		
	});

	//메뉴 leave
	$(".top_menu > ul > li").bind("focusout mouseleave", function(){
		$(".top_menu_wrap").css({"border-bottom":""});
		$(".top_menu_wrap").stop().animate({"height":"60px", "border-color":"none"}, 400, "easeOutCirc");
		$(this).css({"background":""});

		if($(this).hasClass('on')){
			$(this).prev().css({"background":"#d63140"});
		}else{
			$(this).prev().removeClass('before_01');
		}
		
		on_menu();

	});



	ResizingLayer();
	//조금 늦게 나오게
	$('.contents_wrap_01, .footer').css({"display":"block"});
	
	//div 테그 변경(table_search)
	$('div.table_search').find('strong').each(function(){
		$(this).replaceWith('<ul><li>' + $(this).html() +'</li></ul>');
	});
	$('div.table_search div').each(function(){
		$(this).replaceWith('<div class="table_search_cell">' + $(this).html() +'</div>');
	});



	//div 테그 변경(table_write)
	$('div.table_write').find('strong').each(function(){
		$(this).replaceWith('<ul><li>' + $(this).html() +'</li></ul>');
	});
	$('div.table_write div').each(function(){
		$(this).replaceWith('<div class="table_write_cell">' + $(this).html() +'</div>');
	});



	//파일 업로드
	$('.upload_01 input[type="file"]').on('change', function() {
	    if (window.FileReader) { // modern browser
	    	if($(this)[0].files.length != 0){
	    		var filename = $(this)[0].files[0].name;
	    	}
	    } else { // old IE
	        var filename = $(this).val().split('/').pop().split('\\').pop(); // ���ϸ� ����
	    }
	    // ������ ���ϸ� ����
		$(this).siblings('label').html(filename);
		$(this).siblings('label').attr('title', filename);
	});



	
	//달력 날짜 지움
	$('.cal_reset').bind('click', function(){
		$(this).prev().prev('.input_01').val('');
	});



	
	//라디오버튼 & 체크박스 테그 추가 및 변경
	$('.radio_01, .checkbox_01').each(function(){
		var label_style = $(this).attr('style');
		var id_name = $(this).attr('id');
		var title_name = $(this).attr('title');
		var label_name = $(this).next('label').text();
		
		//console.log(label_style);
		if(label_style == undefined){
			label_style = '';
		}
		if(title_name == undefined){
			title_name = '';
		}
		$(this).next('label').replaceWith('<label for=' + id_name + ' style="'+ label_style +'" title="'+ title_name +'"><span></span>' + label_name + '</label>');
	});




	//테이블 상단 라인 넣기(table_list_01, thead 있는 부분)
	$('.table_list_01 thead').each(function(){
		if($(this).parent().hasClass('in_table_01')){
			$(this).parent().before('<span style="display:block; border-bottom:1px solid #808080;"></span>');
			$(this).parent().after('<span style="display:block; border-bottom:1px solid #808080;"></span>');
		}else{
			$(this).parent().before('<span style="display:block; border-bottom:2px solid #d63140;"></span>');
		}
	});



	//체크박스 내용 없을 때(table_list_01)
	$('.table_list_01 .checkbox_01').next().each(function(){
		if($(this).text() == ''){
			$(this).addClass('no_txt');
		}
	});

	//체크박스 버블링 안되게(table_list_01)
	$('.table_list_01 .checkbox_01').parent('td').each(function(){
		var chk_box = $(this).html(); 
		$(this).replaceWith('<td onClick="event.cancelBubble = true;">' + chk_box + '</td>');
	});



	//체크박스 전체 체크 및 해제(chk_01)
	$(".chk_01 input[name=checkAll]").click(function(e){
		$(this).parents().find(".chk_01").find("[name=checkOne]").prop("checked", $(this).prop("checked"));
	});
	$(".chk_01 input[name=checkOne]").each(function(){
		$(this).click(function(){
			var allObj = $(this).parents().find(".chk_01").find("[name=checkAll]");
			var objName = $(this).attr("name");
		
			if($(this).prop("checked")){
				checkBoxLength = $(this).parents().find(".chk_01").find("input[name="+ objName +"]").length;
				checkedLength = $(this).parents().find(".chk_01").find("input[name="+ objName +"]:checked").length;
				
				if(checkBoxLength == checkedLength){
					allObj.prop("checked", true);
				}else{
					allObj.prop("checked", false);
				}
			}else{
				allObj.prop("checked", false);
			}
			
		});
	});


	//로그인 에러부분 스타일 변경
	if($('.error_wrap .error_01').css("display") == 'block'){
		$('.error_wrap .error_01').css({'display':'table-cell'});
	}else{
		$('.error_wrap .error_01').css({'display':'none'});
	}
	
	

	//02. scroll y, 상단 th 고정(o), 내용 36px씩 상하 스냅(x)
	$(".scroll_02 > div").mCustomScrollbar({
		axis:"y",
		theme:"dark-3",
		scrollInertia: 200,			//관성(탄력성)
		autoHideScrollbar: false,
		alwaysShowScrollbar:1,
		
		//snapAmount:37,
		//keyboard:{scrollAmount:37},
		//mouseWheel:{deltaFactor:37},
		
	});



});



$(window).resize(function() {
	ResizingLayer();
});





$(window).scroll(function() {
	
});


