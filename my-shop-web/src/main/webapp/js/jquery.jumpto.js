/* ===========================================================
 * jquery-jumpto.js v1
 * ===========================================================
 * Copyright 2013 Pete Rojwongsuriya.
 * http://www.thepetedesign.com
 *
 * Create a smooth jump to sub navigational sidebar
 * with one js call
 *
 * https://github.com/peachananr/jumpto
 *
 * ========================================================== */

!function($){
  
  var defaults = {
    firstLevel: "> h2",
	firstNumber:">.sort_floor",
    secondLevel: false,
    innerWrapper: ".jumpto-block .sort_title .title_name",
    offset: 1400,
    animate: 500,
    navContainer: false,
    anchorTopPadding: 20,
   // showTitle: "Jump To",
    closeButton: true
	};
	
	function isScrolledIntoView(elem)
  {
      var docViewTop = $(window).scrollTop();
      var docViewBottom = docViewTop + ($(window).height() /4);
      
      var elemTop = $(elem).offset().top;
      var elemBottom = elemTop + $(elem).height();

      return ((elemBottom <= docViewBottom) && (elemTop >= docViewTop));
  }
	
  $.fn.jumpto = function(options){
    var settings = $.extend({}, defaults, options),
        el = $(this),
        html = "",
        block = $(settings.innerWrapper),
        selectors = "",
        title = "",
        close ="";
        
    el.addClass("jumpto-cotainer");
    
    redrawMenu = function(){
      $(selectors.slice(0,-2)).each(function( index ) {
        if (isScrolledIntoView($(this))) {
          $(".jumpto-subnav a").removeClass("active").parent().find(" a[href='#"+$(this).attr("id")+"']").addClass("active")
          
          if($("a[href='#"+$(this).attr("id")+"']").parent().parent().hasClass("jumpto-second")) {
            $("a[href='#"+$(this).attr("id")+"']").closest(".jumpto-second").show()
          }
          if($("a[href='#"+$(this).attr("id")+"']").parent().parent().hasClass("jumpto-first")) {
            $("a[href='#"+$(this).attr("id")+"']").closest(".jumpto-first").find(".jumpto-second").hide()
          }
          if($("a[href='#"+$(this).attr("id")+"']").parent().find(".jumpto-second")) {
            $("a[href='#"+$(this).attr("id")+"']").parent().find(".jumpto-second").show()
          }
        }
      });
      if($(document).scrollTop() > settings.offset) {
        $(".jumpto-subnav").removeClass("bottom").addClass("fixed");
      } else {
        $(".jumpto-subnav").removeClass("bottom fixed");
      }
      if($(document).scrollTop() > el.outerHeight(true)) {
        $(".jumpto-subnav").addClass("bottom fixed");
      }
    }
    
    block.find(settings.firstLevel,settings.firstNumber).each(function( index ) {
      var b = $(this);
	  var c= $(this),
          i = index+1,
          inner_html = "";
      if ( b.parent().find(settings.secondLevel).length > 0) {
        inner_html += "<ul class='jumpto-second'>"
        b.parent().find(settings.secondLevel).each(function( index ) {
          var id = "jumpto_" + i + "_" + index;
          $(this).attr("id", id);
          link_to = "<a href='#" + id + "'>" + $(this).text() +"</a>"+ "<a CLASS='firstNumber' href='#" + id + "'>"+i+"F"+"</a>"
          inner_html += "<li>" + link_to + "</li>"
          selectors += "#"+id + ", ";
        });
        inner_html += "</ul>"
        var id = "jumpto_" + i;
        b.attr("id", id);
        link_to = "<a href='#" + id + "'>" + b.text() +"</a>"+ "<a CLASS='firstNumber' href='#" + id + "'>"+ i+"F"+"</a>"
        selectors += "#"+id + ", ";
        html += "<li>" + link_to + inner_html + "</li>"
      } else {
        var id = "jumpto_" + i;
        link_to = "<a href='#" + id + "'>" + b.text()+"</a>" + "<a CLASS='firstNumber' href='#" + id + "'>"+ i+"F"+"</a>"
        b.attr("id", id);
        selectors += "#"+id + ", ";
        html += "<li>" + link_to + "</li>"
      }
    });
 /*   if (settings.showTitle != false) {
      var title = "<div class='jumpto-title'>"+settings.showTitle+"</div>"
    }
    */
    if (settings.closeButton != false) {
      var close = "<div class='jumpto-close'><a href='#' id='jumpto-close'>Close</a></div><div class='fold'><a href='#' id='headertop' ><span class='iconfont icon-fold'></span></a></div>"
    }
    if(settings.navContainer == false) {
      $(this).append("<nav class='jumpto-subnav'>"+ title +"<ul class='jumpto-first'>" + html + "</ul>"+ close +"</nav>")
    }else{
      $(settings.navContainer).addClass("jumpto-subnav").html(title +"<ul class='jumpto-first'>" + html + "</ul>"+ close)
    }
    
    
    $('.jumpto-subnav a[href*=#]:not([href=#])').click(function() {
      if (location.pathname.replace(/^\//,'') == this.pathname.replace(/^\//,'') 
          || location.hostname == this.hostname) {
    
        var target = $(this.hash);
        target = target.length ? target : $('[name=' + this.hash.slice(1) +']');
        if (target.length) {
          $('html,body').animate({
            scrollTop: target.offset().top - settings.anchorTopPadding
          }, settings.animate, 'swing');
          return false;
        }
      }
    });
    
    $(window).scroll(function() {
      redrawMenu()
    });
    
    $(".jumpto-subnav #jumpto-close").click(function() {
      var btn = $(this)
      btn.parent().parent().find("> .jumpto-first").slideToggle( "slow", function() {
          if ($(this).is(":visible")) {
            btn.html("Close");
          } else {
            btn.html("Open");
          }
        });
        return false;
    });
    
    setInterval(function() {
      var track = [];
      $(selectors.slice(0,-2)).each(function( index ) {
        track.push(isScrolledIntoView($(this)))
      });
      if($.inArray(true, track) == -1) {
        $(".jumpto-subnav a").removeClass("active")
        $(".jumpto-subnav .jumpto-second").hide()
      }
    }, 500);
  }
}(window.jQuery);

