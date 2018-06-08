/**
 * Dom扩展
 * @class $Kit.Dom
 * @requires kit.js
 * @see <a href="https://github.com/xueduany/KitJs/blob/master/KitJs/src/js/dom.js">Source code</a>
 */
$Kit.Dom = function() {
	//
}
$kit.merge($Kit.Dom.prototype,
/**
 * @lends $Kit.Dom.prototype
 */
{
	/**
	 * 根据tagName查找父元素
	 * @param {Element}
	 * @param {String}
	 * @param {Element} [topEl] 到topEl停止查找
	 * @return {Element|Null}
	 */
	parentEl8tag : function(el, tagName, topEl) {
		var topEl = topEl || document.body;
		return $kit.parentEl(el, function(p) {
			if(p.tagName && p.tagName.toLowerCase() == tagName.toLowerCase()) {
				return true;
			}
			if(p == topEl) {
				return false;
			}
		}, topEl);
	},
	/**
	 * 根据className查找父元素
	 * @param {Element}
	 * @param {String}
	 * @param {Element} [topEl] 到topEl停止查找
	 * @return {Element|Null}
	 */
	parentEl8cls : function(el, cls, topEl) {
		var topEl = topEl || document.body;
		return $kit.parentEl(el, function(p) {
			if($kit.hsCls(p, cls)) {
				return true;
			}
			if(p == topEl) {
				return false;
			}
		}, topEl);
	},
	/**
	 * 注入script块
	 * @param {Object} config
	 * @param {String} config.id 注入script的id，自定义，只要与现有dom里面的元素id不相同即可
	 * @param {String} [config.url] 注入script的加载url
	 * @param {String} [config.text] 注入script的script内容
	 * @param {String} [config.then] 注入script的加载完毕的回调方法
	 * @param {String} [config.scope] 注入script的回调方法的this指针
	 * @return {Element} script
	 */
	injectJs : function() {
		if(arguments.length == 1) {
			var config = arguments[0];
			if(config.id && $kit.el8id(config.id)) {
				return;
			}
			config.id = config.id || $kit.onlyId();
			var where = config.where || window.document.body;
			var script = document.createElement('script');
			$kit.attr(script, 'type', 'text/javascript');
			if(config.id) {
				$kit.attr(script, 'id', config.id);
			}
			if(!$kit.isEmpty(config.url)) {
				script.src = config.url;
				if(!$kit.isEmpty(config.then)) {
					var scope = config.scope || window;
					script.onload = function() {
						config.then.call(scope, script);
					}
				}
			} else if(!$kit.isEmpty(config.text)) {
				script.innerHTML = config.text;
				if(!$kit.isEmpty(config.then)) {
					setTimeout(function() {
						config.then.call(scope, script);
					}, 0);
				}
			}
			where.appendChild(script);
			return script;
		}
	},
	/**
	 * 注入css
	 * @param {Object} config
	 * @param {String} config.id 注入css的id，自定义，只要与现有dom里面的元素id不相同即可
	 * @param {String} [config.url] 注入css的url
	 * @param {String} [config.text] 如果没有url的话，写入style的文本
	 * @return {Element} css
	 */
	injectCss : function() {
		if(arguments.length == 1) {
			var config = arguments[0];
			if(config.id && $kit.el8id(config.id)) {
				return;
			}
			// Takes a string of css, inserts it into a `<style>`, then injects it in at the very top of the `<head>`. This ensures any user-defined styles will take precedence.
			var where = config.where || document.getElementsByTagName('head')[document.getElementsByTagName('head').length - 1];
			var css;
			if(!$kit.isEmpty(config.url)) {
				css = document.createElement('link');
				config.id && $kit.attr(css, 'id', config.id);
				$kit.attr(css, {
					rel : 'stylesheet',
					href : config.url
				});
			} else if(!$kit.isEmpty(config.text)) {
				css = document.createElement('style');
				config.id && $kit.attr(css, 'id', config.id);
				$kit.attr(css, 'type', 'text/css');
				css.innerHTML = config.text;
			}
			if(css) {
				$kit.insEl({
					pos : 'last',
					what : css,
					where : where
				});
			}
			return css;
		}
	},
	/**
	 * 删除所有样式
	 * @param {String}
	 * @param {Element}
	 */
	rmClsAll : function(cls, top) {
		var a = $kit.el8cls(cls, top);
		while(a) {
			$kit.rmCls(a, cls);
			a = $kit.el8cls(cls, top);
		}
	},
	/**
	 * 通过className前缀取className
	 * @param {Element}
	 * @param {String}
	 * @return {NodeList||Null}
	 */
	getClassNameByPrefix : function(el, prefixCls) {
		var clsAry = el.className.split(/\s+/);
		var re = null;
		if(clsAry && clsAry.length) {
			$kit.each(clsAry, function(o) {
				if(o.indexOf(prefixCls) == 0) {
					re = o;
					return false;
				}
			});
		}
		return re;
	},
	/**
	 * innerText
	 * @param {Element}
	 * @param {String} [text]
	 * @return {String|Null}
	 */
	text : function(el, text) {
		if(el != null && 'innerText' in el) {
			if(text) {
				el.innerText = text;
			} else {
				return el.innerText;
			}
		} else {
			if(text) {
				el.textContent = text;
			} else {
				return el.textContent;
			}
		}
	},
	/**
	 * innerHTML
	 * @param {Element}
	 * @param {String} [html]
	 * @return {String|Null}
	 */
	html : function(el, html) {
		if(html) {
			if(el != null && 'innerHTML' in el) {
				el.innerHTML = html;
			}
		} else {
			return el.innerHTML;
		}
	},
	/**
	 * clone a node
	 * @param {Element}
	 * @return {Element}
	 */
	clone : function(node) {
		if(document.createElement("nav").cloneNode(true).outerHTML !== "<:nav></:nav>") {
			return node.cloneNode(true);
		} else {
			var fragment = document.createDocumentFragment(), //
			doc = fragment.createElement ? fragment : document;
			doc.createElement(node.tagName);
			var div = doc.createElement('div');
			fragment.appendChild(div);
			div.innerHTML = node.outerHTML;
			return div.firstChild;
		}
	},
	/**
	 * height
	 * @param {Element}
	 * @param {Number} [value]
	 * @return {Number|Null}
	 */
	height : function(node, value) {
		var me = this;
		if(node != null) {
			if(value == null) {
				return $kit.offset(node).height;
			}
			if(document.compatMode == "BackCompat") {
				node.style.height = value;
			} else {
				node.style.height = value//
				- ($kit.css(node, 'border-top-width') || 0)//
				- ($kit.css(node, 'border-bottom-width') || 0)//
				- ($kit.css(node, 'padding-top-width') || 0)//
				- ($kit.css(node, 'padding-bottom-width') || 0)//
				;
			}
		}
		return $kit.viewport().clientHeight;
	},
	/**
	 * width
	 * @param {Element}
	 * @param {Number} [value]
	 * @return {Number|Null}
	 */
	width : function(node, value) {
		var me = this;
		if(node != null) {
			if(value == null) {
				return $kit.offset(node).width;
			}
			if(document.compatMode == "BackCompat") {
				node.style.width = value;
			} else {
				node.style.width = value//
				- ($kit.css(node, 'border-left-width') || 0)//
				- ($kit.css(node, 'border-right-width') || 0)//
				- ($kit.css(node, 'padding-left-width') || 0)//
				- ($kit.css(node, 'padding-right-width') || 0)//
				;
			}
		}
		return $kit.viewport().clientHeight;
	},
	/**
	 * height + padding
	 * @param {Element}
	 * @return {Number}
	 */
	innerHeight : function(node) {
		var me = this;
		if(document.compatMode == "BackCompat") {
			return $kit.css(node, 'height') - ($kit.css(node, 'border-top-width') || 0) - ($kit.css(node, 'border-bottom-width') || 0);
		}
		return $kit.css(node, 'height') + ($kit.css(node, 'padding-top-width') || 0) - ($kit.css(node, 'padding-bottom-width') || 0);
	},
	/**
	 * width + padding
	 * @param {Element}
	 * @return {Number}
	 */
	innerWidth : function(node) {
		var me = this;
		if(document.compatMode == "BackCompat") {
			return $kit.css(node, 'width') - ($kit.css(node, 'border-left-width') || 0) - ($kit.css(node, 'border-right-width') || 0);
		}
		return $kit.css(node, 'width') + ($kit.css(node, 'padding-left-width') || 0) - ($kit.css(node, 'padding-right-width') || 0);
	},
	/**
	 * height + padding + border
	 * @param {Element}
	 * @return {Number}
	 */
	outerHeight : function(node) {
		var me = this;
		if(document.compatMode == "BackCompat") {
			return $kit.css(node, 'height');
		}
		return $kit.css(node, 'height') + ($kit.css(node, 'padding-top-width') || 0) - ($kit.css(node, 'padding-bottom-width') || 0)//
		+ ($kit.css(node, 'border-top-width') || 0) + ($kit.css(node, 'border-bottom-width') || 0);
	},
	/**
	 * width + padding + border
	 * @param {Element}
	 * @return {Number}
	 */
	outerWidth : function(node) {
		var me = this;
		if(document.compatMode == "BackCompat") {
			return $kit.css(node, 'width');
		}
		return $kit.css(node, 'width') + ($kit.css(node, 'padding-left-width') || 0) - ($kit.css(node, 'padding-right-width') || 0)//
		+ ($kit.css(node, 'border-left-width') || 0) + ($kit.css(node, 'border-right-width') || 0);
	},
	/**
	 * 包围一个html
	 * @param {Element}
	 * @param {String}
	 */
	wrap : function(node, html) {
		if($kit.isNode(html)) {
			//
		} else if($kit.isStr(html)) {
			html = $kit.newHTML(html).childNodes[0];
		} else {
			return;
		}
		$kit.insEl({
			where : node,
			what : html,
			pos : 'before'
		});
		html.appendChild(node);
		return html;
	},
	/**
	 * 序列化form元素
	 * @param {Element}
	 * @param {String}
	 * @return {String}
	 */
	serialize : function(form) {
		if($kit.isNode(form)) {
			if(form.tagName.toLowerCase() == 'form') {
				var formEls = {};
				$kit.each($kit.el('input', form), function(o) {
					if(o.type && o.type.toString.toLowerCase() == 'text') {
						formEls[o.name] = o.value;
					} else if(o.type && o.type.toString().toLowerCase() == 'radio') {
						if(o.checked) {
							formEls[o.name] = o.value;
						}
					} else if(o.type && o.type.toString().toLowerCase() == 'checkbox') {
						if(o.checked) {
							if(!$kit.isAry(formEls[o.name])) {
								formEls[o.name] = [formEls[o.name]];
							}
							formEls[o.name].push(o.value);
						}
					}
				});
				$kit.each($kit.el('textarea', form), function(o) {
					formEls[o.name] = o.value;
				});
				$kit.each($kit.el('select', form), function(o) {
					formEls[o.name] = o.options[o.selectedIndex].value;
				});
				var re = [];
				for(var key in formEls) {
					if($kit.isAry(formEls[key])) {
						re.push(key + '=' + encodeURIComponent(formEls[key].join(',')));
					} else {
						re.push(key + '=' + encodeURIComponent(formEls[key]));
					}
				}
				return re.join('');
			}
			return form.name + '=' + encodeURIComponent($kit.val(form));
		}
	},
	/**
	 * 计算元素相对于他的offsetParent的偏移
	 * @param {Element}
	 * @return {Number} top 距离顶部
	 * @return {Number} left 距离左边
	 * @return {Number} height 高度
	 * @return {Number} width 宽度
	 * @return {Number} bottom 底部距离顶部
	 * @return {Number} right 右边距离最左边
	 * @return {Number} middleTop 中间距离顶部
	 * @return {Number} middleLeft 中间距离最左边
	 */
	position : function(el) {
		var me = this;
		if($kit.isEmpty(el)) {
			return;
		}
		var top = el.offsetTop, //
		left = el.offsetLeft, //
		width = el.offsetWidth, //
		height = el.offsetHeight;
		return {
			top : top,
			left : left,
			width : width,
			height : height,
			bottom : top + height,
			right : left + width,
			middleTop : top + height / 2,
			middleLeft : left + width / 2
		}
	},
	/**
	 * 计算元素相对于他的可视区的偏移
	 * @param {Element}
	 * @return {Number} top 距离顶部
	 * @return {Number} left 距离左边
	 * @return {Number} height 高度
	 * @return {Number} width 宽度
	 * @return {Number} bottom 底部距离顶部
	 * @return {Number} right 右边距离最左边
	 * @return {Number} middleTop 中间距离顶部
	 * @return {Number} middleLeft 中间距离最左边
	 */
	clientOffset : function(el) {
		var me = this;
		if($kit.isEmpty(el)) {
			return;
		}
		var offset = $kit.offset(el);
		var viewport = $kit.viewport();
		return {
			top : offset.top - viewport.scrollTop,
			left : offset.left - viewport.scrollLeft,
			width : offset.width,
			height : offset.height,
			bottom : offset.bottom - viewport.scrollTop,
			right : offset.right - viewport.scrollLeft,
			middleTop : offset.top - viewport.scrollTop + offset.height / 2,
			middleLeft : offset.left - viewport.scrollLeft + offset.width / 2
		}
	},
	/**
	 * 获取当一个元素居中的时候，他相对于doc绝对值的top,bottom,left,right等等
	 * @param {Element}
	 * @return {Number} top 距离顶部
	 * @return {Number} left 距离左边
	 * @return {Number} height 高度
	 * @return {Number} width 宽度
	 * @return {Number} bottom 底部距离顶部
	 * @return {Number} right 右边距离最左边
	 * @return {Number} middleTop 中间距离顶部
	 * @return {Number} middleLeft 中间距离最左边
	 */
	offsetCenter : function(el) {
		var me = this;
		var viewport = $kit.viewport();
		var offset = $kit.offset(el);
		return {
			top : viewport.clientHeight / 2 + viewport.scrollTop - offset.height / 2,
			left : viewport.clientWidth / 2 + viewport.scrollLeft - offset.width / 2,
			right : viewport.clientWidth / 2 + viewport.scrollLeft + offset.width / 2,
			bottom : viewport.clientHeight / 2 + viewport.scrollTop + offset.height / 2,
			middleTop : viewport.clientHeight / 2 + viewport.scrollTop,
			middleLeft : viewport.clientWidth / 2 + viewport.scrollLeft
		}
	},
	/**
	 * 获取当一个元素居中的时候，他相对于可视区域的top,bottom,left,right等等
	 * @param {Element}
	 * @return {Number} top 距离顶部
	 * @return {Number} left 距离左边
	 * @return {Number} height 高度
	 * @return {Number} width 宽度
	 * @return {Number} bottom 底部距离顶部
	 * @return {Number} right 右边距离最左边
	 * @return {Number} middleTop 中间距离顶部
	 * @return {Number} middleLeft 中间距离最左边
	 */
	clientOffsetCenter : function(el) {
		var me = this;
		var viewport = $kit.viewport();
		var offset = $kit.offset(el);
		return {
			top : (viewport.clientHeight / 2 - offset.height / 2),
			left : (viewport.clientWidth / 2 - offset.width / 2),
			right : (viewport.clientWidth / 2 + offset.width / 2),
			bottom : (viewport.clientHeight / 2 + offset.height / 2),
			middleTop : (viewport.clientHeight / 2),
			middleLeft : (viewport.clientWidth / 2)
		}
	},
	/**
	 * 获取当一个元素居中的时候，他相对于可视区域的top,bottom,left,right等等
	 * @param {Element}
	 * @return {Number} top 距离顶部
	 * @return {Number} left 距离左边
	 * @return {Number} height 高度
	 * @return {Number} width 宽度
	 * @return {Number} bottom 底部距离顶部
	 * @return {Number} right 右边距离最左边
	 * @return {Number} middleTop 中间距离顶部
	 * @return {Number} middleLeft 中间距离最左边
	 */
	clientPos : function(el) {
		var me = this;
		var viewport = $kit.viewport();
		var offset = $kit.offset(el);
		return {
			top : viewport.clientHeight / 2 + viewport.scrollTop - offset.height / 2,
			left : viewport.clientWidth / 2 + viewport.scrollLeft - offset.width / 2,
			right : viewport.clientWidth / 2 + viewport.scrollLeft + offset.width / 2,
			bottom : viewport.clientHeight / 2 + viewport.scrollTop + offset.height / 2,
			middleTop : viewport.clientHeight / 2 + viewport.scrollTop,
			middleLeft : viewport.clientWidth / 2 + viewport.scrollLeft
		}
	},
	/**
	 * 交换两个element的位置
	 */
	switchPos : function(origin, target) {
		var targetPos;
		if(target.previousSibling) {
			targetPos = {
				pos : 'after',
				where : target.previousSibling
			}
		} else {
			targetPos = {
				pos : 'first',
				where : target.parentNode
			}
		}
		$kit.insEl({
			pos : 'after',
			where : origin,
			what : target
		});
		$kit.insEl($kit.merge({
			what : origin
		}, targetPos));
	}
});
/**
 * $Kit.Dom的实例，直接通过这个实例访问$Kit.Dom所有方法
 * @global
 * @name $kit.dom
 * @alias $kit.d
 * @type $Kit.Dom
 */
$kit.dom = $kit.d = new $Kit.Dom();
