/* =================================================
//
// jQuery Fixed Plugins 1.3.1
// author : 
// Url: 
// Data : 2012-03-30
//
// 参数 : float --> 悬浮方向[left or right]
//		  minStatue --> 最小状态，只有show_btn
//		  skin      --> 皮肤控制
//		  durationTime --> 完成时间
//事例  :	
		  $("#scrollsidebar2").fix({
		  	float : 'right',	//default.left or right 
			minStatue : true,	//default.false or true 
			skin : 'green',		//default.gray or yellow 、blue 、green 、orange 、white 
		  	durationTime : 1000 //
		  });
//
// =================================================*/

;(function($){
    $.fn.fix = function(options){
        var defaults = {
            float : 'left',
			minStatue : false,
			skin : 'blue',
			durationTime : 1000	
        }
        var options = $.extend(defaults, options);		

        this.each(function(){			
            //获取对象
			var thisBox = $(this),
				closeBtn = thisBox.find('.close_btn' ),
				show_btn = thisBox.find('.show_btn' ),
				sideContent = thisBox.find('.side_content'),
				sideList = thisBox.find('.side_list')
				sidetitle=thisBox.find('.side_title');
				scrollsidebar=thisBox.find('.page_right_style');	
			var defaultTop = thisBox.offset().top;	//对象的默认top	
			
			thisBox.css(options.float, 0);			
			if(options.minStatue){
				$(".show_btn").css("float", options.float);
				sideContent.css('width', 0);
				show_btn.css('width', 25);
			}
			//皮肤控制
			//if(options.skin) thisBox.addClass('side_'+options.skin);
				
						
			//核心scroll事件			
			//$(window).bind("scroll",function(){
//				var offsetTop = defaultTop + $(window).clientHeight()+ "px";
//	            show_btn.animate({
//	                top: offsetTop
//	            },
//	            {
//	                duration: options.durationTime,	
//	                queue: false    //此动画将不进入动画队列
//	            });
//			});	
			//close事件
			closeBtn.bind("click",function(){
				sideContent.animate({width: '0px'},"fast").addClass('active');
            	show_btn.stop(true, true).delay(300).animate({ width: '25px'},"fast");
				sideList.css("display","none");
				sidetitle.css("display","none");
				show_btn.css("display","block")
				scrollsidebar.addClass("Widescreen")
			});
			//show事件
			 show_btn.click(function() {
	            $(this).animate({width: '0px'},"fast").css('display','none');
	            sideContent.stop(true, true).delay(0).animate({ width: '220px'},"fast");
				sideList.css("display","block")
				sidetitle.css("display","block");
				scrollsidebar.removeClass("Widescreen")
				
	        });
				
        });	//end this.each

    };
})(jQuery);