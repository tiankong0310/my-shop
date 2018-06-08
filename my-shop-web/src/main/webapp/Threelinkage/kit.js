/*
* a javascript library used to mobile phone web develop
* 3q & enjoy it!
* @author 薛端阳<xueduanyang1985@163.com>
* @copyright 薛端阳  since 2011.10
*/

/**
 * Kit Js 基类，包含基本dom操作，object类型判断以及ready方法，还有事件委托等
 * @constructor $Kit
 * @param {Object} config 组件配置
 * @see <a href="https://github.com/xueduany/KitJs/blob/master/KitJs/src/js/kit.js">Source code</a>
 */
$Kit = function(config) {
	var me = this;
	var defaultConfig = {
		//默认配置
	}
	me.config = me.join(config, defaultConfig);
	// -----------------------------init------------------------------------
	window[me.CONSTANTS.KIT_EVENT_STOPALLEVENT] = false;
	window[me.CONSTANTS.KIT_EVENT_STOPIMMEDIATEPROPAGATION] = false;
	// me.SYSINFO = {}
	// var inf = me.iOSInfo();
	// if(inf != null) {
	// me.merge(me.SYSINFO, inf);
	// }
	/**
	 * @namespace $kit.ui
	 */
	me.ui = {};
}
$Kit.prototype = {
	constructor : $Kit,
	//----------------------CONSTANTS----------------------
	/**
	 * KitJs内部常量
	 * @enum
	 * @const
	 * @public
	 * @type {Object}
	 */
	CONSTANTS : {
		/**
		 * 异常处理,最大循环次数
		 */
		MAX_CYCLE_COUNT : 1000,
		/**
		 * element节点
		 */
		NODETYPE_ELEMENT : 1,
		NODETYPE_ELEMENT_ATTR : 2,
		/**
		 * 文本节点
		 */
		NODETYPE_TEXTNODE : 3,
		/**
		 * 注释
		 */
		NODETYPE_COMMENT : 8,
		/**
		 * 根
		 */
		NODETYPE_ROOT : 9,
		/**
		 * doc fragment
		 */
		NODETYPE_FRAGMENT : 11,
		/**
		 * contains比较结果-同一个
		 */
		DOCUMENT_POSITION_SAME : 0, //同一个
		/**
		 * contains比较结果-不在一个文档
		 */
		DOCUMENT_POSITION_DISCONNECTED : 1, //不在一个文档
		/**
		 * contains比较结果-b在a前面
		 */
		DOCUMENT_POSITION_PRECEDING : 2, //b在a前面
		/**
		 * contains比较结果-b在a后面
		 */
		DOCUMENT_POSITION_FOLLOWING : 4, //b在a后面
		/**
		 * contains比较结果-b是a祖先
		 */
		DOCUMENT_POSITION_CONTAINS : 10, //b是a祖先
		/**
		 * contains比较结果-b是a儿子
		 */
		DOCUMENT_POSITION_CONTAINED_BY : 20, //b是a儿子
		/**
		 * contains比较结果-不常用
		 */
		DOCUMENT_POSITION_IMPLEMENTATION_SPECIFIC : 32, //不常用
		/**
		 * 空格正则
		 */
		REGEXP_SPACE : /\s+/g,
		/**
		 * kit事件注册前缀
		 */
		KIT_EVENT_REGISTER : "_kit_event_register_",
		/**
		 * kit事件注册前缀
		 */
		KIT_EVENT_REGISTER_EVENT : "_kit_event_register_event",
		/**
		 * kit事件注册前缀
		 */
		KIT_EVENT_REGISTER_FUNCTION : "_kit_event_register_function",
		/**
		 * kit事件信号--立即停止所有事件
		 */
		KIT_EVENT_STOPIMMEDIATEPROPAGATION : "_kit_event_stopimmediatepropagation_",
		/**
		 * kit事件信号--停止所有事件
		 */
		KIT_EVENT_STOPALLEVENT : "_kit_event_stopallevent_",
		/**
		 * kit DOM ID 默认前缀
		 */
		KIT_DOM_ID_PREFIX : "J_Kit_"
	},
	// -----------------------------------is
	// something-----------------------------------
	/**
	 * 判断是否IE
	 * @return {Boolean}
	 */
	isIE : function() {
		return /MSIE/i.test(navigator.userAgent);
	},
	/**
	 * 是否是chrome
	 * @return {Boolean}
	 */
	isChrome : function() {
		return /Chrome/i.test(navigator.userAgent);
	},
	isWebKit : function() {
		return /WebKit/i.test(navigator.userAgent);
	},
	/**
	 * 是否是火狐
	 * @return {Boolean}
	 */
	isFirefox : function() {
		return /Firefox/i.test(navigator.userAgent);
	},
	/**
	 * 是否已定义
	 * @param {Object}
	 * @return {Boolean}
	 */
	isDefined : function(o) {
		return typeof (o) != "undefined";
	},
	/**
	 * 是否是字符串
	 * @param {Object}
	 * @return {Boolean}
	 */
	isStr : function(o) {
		return typeof (o) == "string";
	},
	/**
	 * 是否数字
	 * @param {Object}
	 * @return {Boolean}
	 */
	isNum : function(o) {
		return isFinite(o)
	},
	/**
	 * 是否是日期
	 * @param {Object}
	 * @return {Boolean}
	 */
	isDate : function(o) {
		return (null != o) && !isNaN(o) && ("undefined" !== typeof o.getDate);
	},
	/**
	 * 是否是对象类型
	 * @param {Object}
	 * @return {Boolean}
	 */
	isObj : function(o) {
		return !!(o && typeof (o) == "object" );
	},
	/**
	 * 是否是方法类型
	 * @param {Object}
	 * @return {Boolean}
	 */
	isFn : function(o) {
		return !!(o && typeof (o) == "function");
	},
	/**
	 * 是否是可以迭代
	 * @param {Object}
	 * @return {Boolean}
	 */
	isAry : function(o) {
		var me = this;
		return !!(o && (o.constructor && o.constructor.toString().indexOf("Array") > -1 || me.isNodeList(o)));
	},
	/**
	 * 是否是节点列表
	 * @param {Object}
	 * @return {Boolean}
	 */
	isNodeList : function(o) {
		return !!(o && (o.toString() == '[object NodeList]' || o.toString() == '[object HTMLCollection]' || (o.length && this.isNode(o[0]))));
	},
	/**
	 * 是否是节点
	 * @param {Object}
	 * @return {Boolean}
	 */
	isNode : function(o) {
		return !!(o && o.nodeType);
	},
	/**
	 * 一个字符串能否根据空格拆分成一个数组，数组内元素个数大于1
	 * @param {String}
	 * @return {Boolean}
	 */
	isCanSplit2Ary : function(o, sign) {
		var me = this;
		return me.isStr(o) && o.split(sign || /\s+/g).length > 1;
	},
	/**
	 * 是否为空
	 * @param {Object}
	 * @return {Boolean}
	 */
	isEmpty : function(o) {
		var me = this;
		return typeof (o) == "undefined" || o == null || (!me.isNode(o) && me.isAry(o) && o.length == 0 || (me.isStr(o) && o == ""));
	},
	// -----------------------------------string-----------------------------------
	/**
	 * 去除所有空格
	 * @param {String}
	 * @return {String}
	 */
	trimAll : function(str) {
		if(str == null) {
			return null;
		}
		str = str.toString();
		return str.replace(/\s+/ig, "");
	},
	// -----------------------------------array-----------------------------------
	/**
	 * 从一个数组里面剔除部分元素
	 * @param {String|Array}
	 * @return {Array}
	 */
	aryDel : function(ary, del) {
		var me = this;
		if(!me.isAry(ary)) {
			return;
		}
		if(me.isAry(del)) {
			for(var i = 0; i < del.length; i++) {
				me.aryDel(ary, del[i]);
			}
		} else {
			for(var j = 0; j < ary.length; j++) {
				if(ary[j] == del) {
					ary.splice(j, 1);
				}
			}
		}
		return ary;
	},
	/**
	 * 判断是否数组中是否存在参数
	 * @param {String|Array}
	 * @return {Boolean}
	 */
	inAry : function(ary, o) {
		var me = this, flag = false;
		if(!me.isAry(ary)) {
			return;
		}
		for(var i = 0; i < ary.length; i++) {
			if(me.isAry(o)) {
				for(var j = 0; j < o.length; j++) {
					if(ary[i] == o[j]) {
						flag = true;
						break;
					}
				}
			} else {
				if(ary[i] == o) {
					flag = true;
					break;
				}
			}
		}
		return flag;
	},
	// -----------------------------------find dom-----------------------------------
	/**
	 * ==document.getElementById 根据id选择
	 * @param {String}
	 * @param {Element} [root] 可选,从哪个根节点查找
	 * @return {Element}
	 */
	el8id : function(id, root) {
		var me = this, re = document.getElementById(id);
		if(root) {
			if(me.contains(root, re)) {
				return re;
			}
			return null;
		}
		return re;
	},
	/**
	 * ==document.getElementsByClassName 根据className选择，返回第一个找到的
	 * @param {String}
	 * @param {Element} [root] 可选,从哪个根节点查找
	 * @return {Element|Null}
	 */
	el8cls : function(cls, root) {
		var re = (root || document).getElementsByClassName(cls);
		return (re != null && re.length ) ? re[0] : null;
	},
	/**
	 * ==document.getElementsByClassName 根据className选择，返回所有找到的
	 * @param {String}
	 * @param {Element} [root] 可选,从哪个根节点查找
	 * @return {[Element]|Null}
	 */
	els8cls : function(cls, root) {
		var re = (root || document).getElementsByClassName(cls);
		return re != null && re.length ? re : null;
	},
	/**
	 * ==document.getElementsByTagName 根据tagName选择，返回所有找到的
	 * @param {String}
	 * @param {Element} [root] 可选,从哪个根节点查找
	 * @return {[Element]|Null}
	 */
	els8tag : function(tagName, root) {
		var re = (root || document).getElementsByTagName(tagName);
		return re != null && re.length ? re : null;
	},
	/**
	 * ==document.getElementsByTagName 根据tagName选择，返回第一个找到的
	 * @param {String}
	 * @param {Element} [root] 可选,从哪个根节点查找
	 * @return {[Element]|Null}
	 */
	el8tag : function(tagName, root) {
		var me = this;
		var re = me.els8tag(tagName, root);
		return re != null && re.length ? re[0] : null;
	},
	/**
	 * ==document.getElementsByName 根据name选择，返回第一个找到的
	 * @param {String}
	 * @param {Element} [root] 可选,从哪个根节点查找
	 * @return {[Element]|Null}
	 */
	el8name : function(name, root) {
		var me = this, re = document.getElementsByName(name);
		if(root) {
			for(var i = 0; i < re.length; i++) {
				if(me.contains(root, re[i])) {
					return re[i];
				}
			}
			return null;
		}
		return (re != null && re.length ) ? re[0] : null;
	},
	/**
	 * ==document.getElementsByName 根据name选择，返回所有找到的
	 * @param {String}
	 * @param {Element} [root] 可选,从哪个根节点查找
	 * @return {[Element]|Null}
	 */
	els8name : function(name, root) {
		var me = this, re = document.getElementsByName(name);
		if(root) {
			var _re = [];
			for(var i = 0; i < re.length; i++) {
				if(me.contains(root, re[i])) {
					_re.push(re[i]);
				}
			}
			return _re.length ? _re : null;
		}
		return re != null && re.length ? re : null;
	},
	/**
	 * 简单Css选择器 支持#id，.className，@formName，还有tagName.className，四种格式
	 * @param {String}
	 * @param {Element} [root] 可选,从哪个根节点查找
	 * @return {[Element]|Null}
	 */
	el : function(selector, root) {
		var me = this;
		if(me.isEmpty(selector)) {
			return;
		} else if(me.isNode(selector) || me.isNodeList(selector)) {
			return selector;
		}
		var selector = selector.toString().trim();
		if(selector.indexOf("#") == 0) {
			return me.el8id(selector.substring(1), root);
		} else if(selector.indexOf(".") == 0) {
			var a = me.els8cls(selector.substring(1), root), re = [];
			if(a.constructor && a.constructor.toString().indexOf("Array") > -1) {
				re = a;
			} else {
				for(var i = 0; i < a.length; i++) {
					re.push(a[i]);
				}
			}
			return re;
		} else if(selector.indexOf("@") == 0) {
			var a = me.els8name(selector.substring(1), root), re = [];
			for(var i = 0; i < a.length; i++) {
				re.push(a[i]);
			}
			return re;
		} else {
			var re = [];
			if(selector.indexOf(".") > 0 && selector.indexOf(".") < selector.length) {
				var a = me.els8tag(selector.substring(0, selector.indexOf(".")), root);
				var cls = selector.substr(selector.indexOf(".") + 1);
				for(var i = 0; !me.isEmpty(a) && i < a.length; i++) {
					if(me.hsCls(a[i], cls)) {
						re.push(a[i]);
					}
				}
			} else {
				re = me.els8tag(selector, root);
			}
			return re;
		}

	},
	// -----------------------------------dom manipulate-----------------------------------
	/**
	 * 比较element位置 如果a包含b返回true，否则返回false
	 * @param {Element}
	 * @param {Element}
	 * @reutn {Boolean}
	 */
	contains : function(a, b) {
		return a.contains ? a != b && a.contains(b) : !!(a.compareDocumentPosition(b) & 16);
	},
	/**
	 * 设置或者获取Element的attribute
	 * @param {Element}
	 * @param {String|Object} attr 可以为属性值，也可以为一个枚举对象，按照key,value顺序批量设置
	 * @param {String} [value]
	 * @reutn {String|Null}
	 */
	attr : function(el, attr, value) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		if(!me.isDefined(value)) {
			if(me.isObj(attr)) {
				for(var l in attr) {
					el.setAttribute(l, attr[l]);
				}
			} else {
				return el.getAttribute(attr);
			}
		} else {
			if(value == null) {
				if( attr in el) {
					try {
						el[attr] = null;
					} catch(e) {
					}
				}
				if(el.removeAttribute) {
					el.removeAttribute(attr);
				} else {
					el.setAttribute(attr, null);
				}
				try {
					delete el[attr];
				} catch(e) {
				}
			} else {
				el.setAttribute(attr, value);
			}
		}
	},
	/**
	 * 设置或者获取Element的css
	 * @param {Element}
	 * @param {String|Object} attr 可以为属性值，也可以为一个枚举对象，按照key,value顺序批量设置
	 * @param {String} [value]
	 * @reutn {String|Null}
	 */
	css : function(el, attr, value) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		if(value == null) {
			if(me.isObj(attr)) {
				for(var l in attr) {
					if(l.indexOf('-moz-') == 0) {
						var l1 = '';
						$kit.each(l.split('-'), function(o) {
							if(o.length) {
								l1 += o.substring(0, 1).toUpperCase() + o.substring(1, o.length);
							}
						});
						el.style[l1] = attr[l];
					} else {
						if(!me.isWebKit()) {
							l = me._camelCssName(l);
						}
						el.style[l] = attr[l];
					}
				}
			} else {
				var re = getComputedStyle(el, null)[this._camelCssName(attr)];
				try {
					re = isNaN(parseFloat(re)) ? re : parseFloat(re);
				} catch(e) {
					//
				}
				return re;
			}
		} else {
			if(attr.indexOf('-moz-') == 0) {
				var attr1 = '';
				$kit.each(attr.split('-'), function(o) {
					if(o.length) {
						attr1 += o.substring(0, 1).toUpperCase() + o.substring(1, o.length);
					}
				});
				el.style[attr1] = value;
			} else {
				if(!me.isWebKit()) {
					attr = me._camelCssName(attr);
				}
				el.style[attr] = value;
			}
		}
	},
	_camelCssName : function(str) {
		var a = str.split('-');
		for(var i = 1; i < a.length; i++) {
			a[i] = a[i].substr(0, 1).toUpperCase() + a[i].substr(1);
		}
		return a.join('');
	},
	/**
	 * 获取Element的cssStr
	 * @param {Element}
	 * @param {String}
	 */
	cssStr : function(el, attr) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		if(attr.indexOf('-moz-') == 0) {
			var attr1 = '';
			$kit.each(attr.split('-'), function(o) {
				if(o.length) {
					attr1 += o.substring(0, 1).toUpperCase() + o.substring(1, o.length);
				}
			});
			attr = attr1;
		} else {
			attr = this._camelCssName(attr);
		}
		var re = el.style[attr] || getComputedStyle(el, null)[attr];
		return re;
	},
	_camelCssName : function(str) {
		var firstLetter = str.substring(0, 1);
		var mainStr = str.substr(1);
		var a = mainStr.split('-');
		for(var i = 1; i < a.length; i++) {
			a[i] = a[i].substr(0, 1).toUpperCase() + a[i].substr(1);
		}
		return firstLetter.toLowerCase() + a.join('');
	},
	/**
	 * 取值 div等取innerHTML textarea等form元素取value
	 * @param {Element}
	 * @return {String}
	 */
	val : function(el) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		if(me.isNode(el) && ('value' in el)) {
			return el.value;
		} else if(me.isNodeList(el) && el.length > 1) {
			var a = [];
			for(var i = 0; i < el.length; i++) {
				if(el[i].checked && el[i].value) {
					a.push(el[i].value);
				}
			}
			return a.join(',');
		} else if(el.length == 1) {
			return me.val(el[0]);
		}
		return el.innerHTML;
	},
	/**
	 * 插入元素
	 * @param {Object} config
	 * @param {String} config.pos pos表示插入位置，有last,first,before(previous),after(nextSibling)，4种类型值
	 * @param {Element} config.where where为被插入目标Element
	 * @param {Element|String} config.what what为插入值，可以为一段HTML，也可以为一个HTML Node
	 */
	insEl : function(config) {
		var me = this, defaultConfig = {
			pos : "last",
			what : null,
			where : null
		}
		config = me.join(defaultConfig, config);
		var what = config.what, where = config.where;
		if(!me.isEmpty(what) && me.isNode(where)) {
			switch (config.pos.toString().toLowerCase()) {
				case "first" :
					if(me.isStr(what)) {
						me.insertHTML(where, "afterBegin", what);
					} else {
						me.insertNode(where, "afterBegin", what);
					}
					break;
				case "before" :
				case "previous" :
					if(me.isStr(what)) {
						me.insertHTML(where, "beforeBegin", what);
					} else {
						me.insertNode(where, "beforeBegin", what);
					}
					break;
				case "after" :
				case "nextsibling" :
					if(me.isStr(what)) {
						me.insertHTML(where, "afterEnd", what);
					} else {
						me.insertNode(where, "afterEnd", what);
					}
					break;
				case "last" :
					if(me.isStr(what)) {
						me.insertHTML(where, "beforeEnd", what);
					} else {
						me.insertNode(where, "beforeEnd", what);
					}
					break;
				default:
				//i don`t know how to do that
			}
		}
	},
	/**
	 * @private
	 */
	insertNode : function(el, where, parsedNode) {
		switch(where) {
			case "beforeBegin":
				el.parentNode.insertBefore(parsedNode, el);
				break;
			case "afterBegin":
				el.insertBefore(parsedNode, el.firstChild);
				break;
			case "beforeEnd":
				el.appendChild(parsedNode);
				break;
			case "afterEnd":
				if(el.nextSibling) {
					el.parentNode.insertBefore(parsedNode, el.nextSibling);
				} else {
					el.parentNode.appendChild(parsedNode);
				}
				break;
		}
	},
	/**
	 * @private
	 */
	insertHTML : function(el, where, html) {
		where = where.toLowerCase();
		if(el.insertAdjacentHTML) {
			switch(where) {
				case "beforebegin":
					el.insertAdjacentHTML('BeforeBegin', html);
					return el.previousSibling;
				case "afterbegin":
					el.insertAdjacentHTML('AfterBegin', html);
					return el.firstChild;
				case "beforeend":
					el.insertAdjacentHTML('BeforeEnd', html);
					return el.lastChild;
				case "afterend":
					el.insertAdjacentHTML('AfterEnd', html);
					return el.nextSibling;
			}
			throw 'Illegal insertion point -> "' + where + '"';
		}
		var range = el.ownerDocument.createRange();
		var frag;
		switch(where) {
			case "beforebegin":
				range.setStartBefore(el);
				frag = range.createContextualFragment(html);
				el.parentNode.insertBefore(frag, el);
				return el.previousSibling;
			case "afterbegin":
				if(el.firstChild) {
					range.setStartBefore(el.firstChild);
					frag = range.createContextualFragment(html);
					el.insertBefore(frag, el.firstChild);
					return el.firstChild;
				} else {
					el.innerHTML = html;
					return el.firstChild;
				}
			case "beforeend":
				if(el.lastChild) {
					range.setStartAfter(el.lastChild);
					frag = range.createContextualFragment(html);
					el.appendChild(frag);
					return el.lastChild;
				} else {
					el.innerHTML = html;
					return el.lastChild;
				}
			case "afterend":
				range.setStartAfter(el);
				frag = range.createContextualFragment(html);
				el.parentNode.insertBefore(frag, el.nextSibling);
				return el.nextSibling;
		}
		throw 'Illegal insertion point -> "' + where + '"';
	},
	/**
	 * 替换元素
	 * @param {Element}
	 * @param {Element|String} html 为一个html元素或者一段HTML string
	 */
	rpEl : function(element, html) {
		var me = this;
		if(me.isEmpty(element) || me.isEmpty(html)) {
			return;
		}
		if($kit.isStr(html)) {
			var range = element.ownerDocument.createRange();
			range.selectNodeContents(element);
			element.parentNode.replaceChild(range.createContextualFragment(html), element);
			range.detach();
		} else if($kit.isNode(html)) {
			element.parentNode.replaceChild(html, element);
		}
	},
	/**
	 * 删除元素
	 * @param {Element}
	 */
	rmEl : function(element) {
		var me = this;
		if(me.isEmpty(element)) {
			return;
		}
		if(me.isAry(element)) {
			for(var i = 0; i < element.length; i++) {
				me.rmEl(element[i]);
			}
		} else {
			me.traversal({
				root : element,
				fn : function(node) {
					me.delEv({
						el : node
					});
				}
			});
			element.parentNode.removeChild(element, true);
		}
	},
	/**
	 * 添加className
	 * @param {Element}
	 * @param {String}
	 */
	adCls : function(el, cls) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		/*
		 if(me.isAry(clss)) {
		 for(var i = 0; i < clss.length; i++) {
		 me.adCls(el, clss[i]);
		 }
		 } else {
		 var a = me.isEmpty(el.className) ? [] :
		 el.className.split(me.CONSTANTS.REGEXP_SPACE), flag = true;
		 for(var i = 0; i < a.length; i++) {
		 if(a[i] == clss) {
		 flag = false;
		 break;
		 }
		 }
		 if(flag) {
		 a.push(clss);
		 el.className = a.join(" ");
		 }
		 }*/
		var re = new RegExp('(\\s|^)' + cls + '(\\s|$)');
		if(re.test(el.className))
			return;
		//el.className += ' ' + cls;
		el.className = el.className.split(/\s+/).join(' ') + ' ' + cls;
	},
	/**
	 * 删除ClassName
	 * @param {Element}
	 * @param {String}
	 */
	rmCls : function(el, cls) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		/*
		 var a = me.isEmpty(el.className) ? [] :
		 el.className.split(me.CONSTANTS.REGEXP_SPACE), b = [];
		 if(a.length) {
		 b = me.aryDel(a, clss);
		 }
		 if(b.length) {
		 el.className = b.join(" ");
		 } else {
		 el.className = "";
		 me.attr(el, 'class', null);
		 }*/
		var clsAry = cls.split(/\s+/g);
		var reCls = el.className;
		for(var i = 0; i < clsAry.length; i++) {
			var cls = clsAry[i];
			var re = new RegExp('(\\s|^)' + cls + '(\\s|$)');
			if(reCls) {
				reCls = reCls.replace(re, ' ');
			}
		}
		reCls = reCls.trim();
		el.className = reCls;
	},
	/**
	 * 判断是否含有某个className
	 * @param {Element}
	 * @param {String}
	 */
	hsCls : function(el, cls) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		/*
		 if(!me.isEmpty(el.className)) {
		 var a = el.className.split(me.CONSTANTS.REGEXP_SPACE);
		 for(var i = 0; i < a.length; i++) {
		 if(a[i] == cls) {
		 flag = true;
		 break;
		 }
		 }
		 }
		 return flag;
		 */
		var re = new RegExp('(\\s|^)' + cls + '(\\s|$)');
		return re.test(el.className);
	},
	/**
	 * 切换css，有则删，无则加
	 * @param {Element}
	 * @param {String}
	 */
	toggleCls : function(el, cls) {
		var me = this;
		if(me.hsCls(el, cls)) {
			me.rmCls(el, cls);
		} else {
			me.adCls(el, cls);
		}
	},
	/**
	 * Dom遍历
	 * @param {Object} config
	 * @param {Object} config.root 遍历的根节点，表示从哪儿开始遍历
	 * @param {Object} config.fn 每遍历一个节点，执行的方法fn(node,root)
	 */
	traversal : function(config) {
		var me = this, defaultConfig = {
			root : document.body
		}
		me.mergeIf(config, defaultConfig);
		if(me.isEmpty(config.node)) {
			config.node = config.root;
		}
		if($kit.isFn(config.fn)) {
			config.fn.apply(config.node, [config.node, config.root])
		} else {
			return;
		}
		for(var i = 0; i < config.node.childNodes.length; i++) {
			var o = config.node.childNodes[i];
			me.traversal(me.join(config, {
				node : o
			}));
		}

	},
	/**
	 * 返回当前元素满足条件的下一个元素
	 * @param {Element}
	 * @param {Function} condition 用于检测是否满足条件的方法，返回true表示满足
	 * @param {Obejct} [scope] 执行condition时候的this指针
	 * @return {Element}
	 */
	nextEl : function(el, condition, scope) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		var next = null;
		if(el.nextElementSibling != null) {
			next = el.nextElementSibling;
		} else {
			var parent = el.parentNode;
			while(parent != null && parent.parentNode != null && parent == parent.parentNode.lastElementChild) {
				parent = parent.parentNode;
			}
			var firstEl = parent.nextElementSibling.firstElementChild;
			while(firstEl != null && firstEl.children.length > 0 && firstEl.firstElementChild != null) {
				firstEl = firstEl.firstElementChild;
			}
			next = firstEl;
		}
		if(next != null) {
			var condition = condition || null, scope = scope || null;
			if(me.isFn(condition)) {
				if(condition.call(scope, next, el) == true) {
					return next;
				} else if(condition.call(scope, next, el) == false) {
					return null;
				} else {
					var allNodes = document.getElementsByTagName("*");
					if(next != allNodes[allNodes.length - 1]) {
						return me.nextEl(next, condition, scope);
					} else {
						return null;
					}
				}
			}
		}
		return next;
	},
	/**
	 * 返回当前元素满足条件的前一个元素
	 * @param {Element}
	 * @param {Function} condition 用于检测是否满足条件的方法，返回true表示满足
	 * @param {Obejct} [scope] 执行condition时候的this指针
	 * @return {Element}
	 */
	prevEl : function(el, condition, scope) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		var prev = null;
		if(el.previousElementSibling != null) {
			prev = el.previousElementSibling;
		} else {
			var parent = el.parentNode;
			while(parent != null && parent.parentNode != null && parent == parent.parentNode.firstElementChild) {
				parent = parent.parentNode;
			}
			var lastEl = parent.previousElementSibling.lastElementChild;
			while(lastEl != null && lastEl.children.length > 0 && lastEl.lastElementChild != null) {
				lastEl = lastEl.lastElementChild;
			}
			prev = lastEl;
		}
		if(prev != null) {
			var condition = condition || null, scope = scope || null;
			if(me.isFn(condition)) {
				if(condition.call(scope, prev, el) == true) {
					return prev;
				} else if(condition.call(scope, prev, el) == false) {
					return null;
				} else {
					var allNodes = document.getElementsByTagName("*");
					if(prev != allNodes[0]) {
						return me.prevEl(prev, condition, scope);
					} else {
						return null;
					}
				}
			}
		}
		return prev;
	},
	/**
	 * 返回当前元素满足条件的父元素
	 * @param {Element}
	 * @param {Function} condition 用于检测是否满足条件的方法，返回true表示满足
	 * @param {Obejct} [scope] 执行condition时候的this指针
	 * @return {Element}
	 */
	parentEl : function(el, condition, scope) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		var parent = null;
		if(el.parentNode != null && el.parentNode != el) {
			parent = el.parentNode;
			var condition = condition || null, scope = scope || null;
			if(me.isFn(condition)) {
				if(condition.call(scope, parent, el) == true) {
					return parent;
				} else if(condition.call(scope, parent, el) == false) {
					return null;
				} else {
					return me.parentEl(parent, condition, scope);
				}
			}
		}
		return parent;
	},
	/**
	 * 返回一个 documentFragment，包含了HTML
	 * @param {String}
	 * @return {DocumentFragment}
	 */
	newHTML : function(html) {
		var me = this;
		if(me.isEmpty(html)) {
			return;
		}
		var box = document.createElement("div");
		box.innerHTML = html;
		var o = document.createDocumentFragment();
		while(box.childNodes && box.childNodes.length) {
			o.appendChild(box.childNodes[0]);
		}
		box = null;
		return o;
	},
	/**
	 * 计算元素相对于doc的 绝对偏移
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
	offset : function(el) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		var top = el.offsetTop, //
		left = el.offsetLeft, //
		width = el.offsetWidth, //
		height = el.offsetHeight;
		while(el.offsetParent != null && el.offsetParent != el) {
			el = el.offsetParent;
			top += el.offsetTop;
			left += el.offsetLeft;
		}
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
	 * 计算元素相对于doc的 绝对偏移
	 * @param {Element}
	 * @return {Number} clientWidth 可视内容的宽度
	 * @return {Number} clientHeight 可视内容的高度
	 * @return {Number} scrollWidth 滚动条的宽度
	 * @return {Number} scrollHeight 滚动条的高度
	 * @return {Number} scrollLeft 滚动条距离左边的宽度
	 * @return {Number} scrollTop 滚动条距离顶部的高度
	 */
	viewport : function() {
		var cWidth, cHeight, sWidth, sHeight, sLeft, sTop;
		if(document.compatMode == "BackCompat") {
			cWidth = document.body.clientWidth;
			cHeight = document.body.clientHeight;
			sWidth = document.body.scrollWidth;
			sHeight = document.body.scrollHeight;
			sLeft = document.body.scrollLeft;
			sTop = document.body.scrollTop;
		} else {//document.compatMode == "CSS1Compat"
			cWidth = document.documentElement.clientWidth;
			cHeight = document.documentElement.clientHeight;
			sWidth = document.documentElement.scrollWidth;
			sHeight = document.documentElement.scrollHeight;
			sLeft = document.documentElement.scrollLeft == 0 ? document.body.scrollLeft : document.documentElement.scrollLeft;
			sTop = document.documentElement.scrollTop == 0 ? document.body.scrollTop : document.documentElement.scrollTop;
		}
		return {
			clientWidth : cWidth,
			clientHeight : cHeight,
			scrollWidth : sWidth,
			scrollHeight : sHeight,
			scrollLeft : sLeft,
			scrollTop : sTop
		}
	},
	// -----------------------------------event-----------------------------------
	// -----------------------------------event-----------------------------------
	/**
	 * kit事件注册方法
	 * kitjs的事件对象event拥有以下属性
	 * target: 当前事件触发元素
	 * currentTarget：注册该事件的元素
	 * relatedTarget: 事件触发相关的元素，当事件在两个元素之间发生时候，这个有值，兼容了toElement,fromElement
	 * offsetX/Y: 事件相当于target的x,y
	 * clientX/Y: 事件相当于viewport的x,y
	 * pageX/Y: 事件相当于doc的
	 * firstFingerClientX/Y: 移动设备的touchmove
	 * firstFingerPageX/Y: 移动设备的touchmove
	 * stopNow(): 立即停止所有
	 * stopDefault(): 停止默认事件触发
	 * stopGoOn(): 停止冒泡
	 * @param {Object} config
	 * @param {Selector|Element|NodeList} config.el 触发事件的元素，等于event.currentTarget
	 * @param {String} config.ev 事件type，如click
	 * @param {Function} config.fn 事件方法
	 * @param {Object} config.scope this指针
	 */
	ev : function(config) {
		var me = this, defaultConfig = {
			el : window,
			ev : null,
			fn : null,
			scope : null
		}
		config = me.join(defaultConfig, config);
		if(me.isAry(config.el)) {
			for(var i = 0; i < config.el.length; i++) {
				me.ev(me.join(config, {
					el : config.el[i]
				}));
			}
		} else if(me.isCanSplit2Ary(config.el)) {
			var a = config.el.split(me.CONSTANTS.REGEXP_SPACE)
			for(var i = 0; i < a.length; i++) {
				var _el = me.el8id(a[i]);
				if(!me.isEmpty(_el)) {
					me.ev(me.join(config, {
						el : _el
					}));
				}
			}
		} else if(me.isStr(config.el)) {
			var _el = me.el(config.el);
			if(me.isEmpty(_el)) {
				_el = me.el("#" + config.el);
			}
			if(!me.isEmpty(_el)) {
				me.ev(me.join(config, {
					el : _el
				}));
			}
		} else if(me.isAry(config.ev)) {
			for(var i = 0; i < config.ev.length; i++) {
				me.ev(me.join(config, {
					ev : config.ev[i]
				}));
			}
		} else if(me.isCanSplit2Ary(config.ev)) {
			var a = config.ev.split(me.CONSTANTS.REGEXP_SPACE);
			for(var i = 0; i < a.length; i++) {
				me.ev(me.join(config, {
					ev : a[i]
				}));
			}
		} else {
			if(!me.isEmpty(config.el) && !me.isEmpty(config.ev) && !me.isEmpty(config.fn)) {
				config.ev = config.ev.toString().trim();
				// -------webkit support stopImmediatePropagation, so comment
				// this template
				var evReg = config.el[me.CONSTANTS.KIT_EVENT_REGISTER] = config.el[me.CONSTANTS.KIT_EVENT_REGISTER] || {};
				var evRegEv = evReg[me.CONSTANTS.KIT_EVENT_REGISTER_EVENT] = evReg[me.CONSTANTS.KIT_EVENT_REGISTER_EVENT] || {};
				var evRegFn = evReg[me.CONSTANTS.KIT_EVENT_REGISTER_FUNCTION] = evReg[me.CONSTANTS.KIT_EVENT_REGISTER_FUNCTION] || {};
				evRegEv[config.ev] = evRegEv[config.ev] || [];
				evRegFn[config.ev] = evRegFn[config.ev] || (function() {
					/*try {*/
					// stop global event on-off
					if(window[me.CONSTANTS.KIT_EVENT_STOPALLEVENT]) {
						return;
					}
					var EV = arguments[0] || window.event;

					me.mergeIf(EV, {
						target : EV.target || EV.srcElement,
						currentTarget : config.el,
						relatedTarget : EV.relatedTarget ? EV.relatedTarget : EV.toElement || EV.fromElement
					});
					//add dragElement temp reg
					if(!$kit.isEmpty($kit.event) && $kit.isEmpty(EV.relatedTarget) && !$kit.isEmpty($kit.event.dragElement) && (EV.type.indexOf('drag') == 0 || EV.type.indexOf('drop') == 0)) {
						EV.dragElement = $kit.event.dragElement;
					}
					me.mergeIf(EV, {
						stopNow : function() {
							EV.stopPropagation && EV.stopPropagation();
							EV.preventDefault && EV.preventDefault();
							//
							EV.cancelBubble = true;
							EV.returnValue = false;
							//
							window[me.CONSTANTS.KIT_EVENT_STOPIMMEDIATEPROPAGATION] = true;
						},
						stopDefault : function() {
							EV.preventDefault && EV.preventDefault();
							EV.returnValue = false;
						},
						stopGoOn : function() {
							//EV.preventDefault && EV.preventDefault();
							EV.stopPropagation && EV.stopPropagation();
							//
							EV.cancelBubble = true;
							//EV.returnValue = false;
						}
					}, me.evExtra(EV));
					var target = config.el;
					var evQueue = target[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_EVENT][config.ev];
					var returnValue;
					for(var i = 0; i < evQueue.length; i++) {
						if(window[me.CONSTANTS.KIT_EVENT_STOPIMMEDIATEPROPAGATION]) {
							break;
						}
						var _evConfig = evQueue[i];
						returnValue = _evConfig.fn.apply(_evConfig.scope || _evConfig.el, [EV, _evConfig]);
					}
					window[me.CONSTANTS.KIT_EVENT_STOPIMMEDIATEPROPAGATION] = false;
					/*
					 } catch(e) {
					 alert(e);
					 throw e;
					 };*/
					if(returnValue != null) {
						return returnValue;
					}
				});
				if(document.attachEvent) {
					config.el.attachEvent('on' + config.ev, config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_FUNCTION][config.ev]);
				} else {
					config.el.addEventListener(config.ev, config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_FUNCTION][config.ev], false);
				}
				evRegEv[config.ev].push(config);
			} else {
				if(!me.isEmpty(config.el) && !me.isEmpty(config.ev) && me.isEmpty(config.fn)) {
					if(window[me.CONSTANTS.KIT_EVENT_STOPALLEVENT]) {
						return;
					}
					// var evt = document.createEvent('Event');
					// evt.initEvent(config.ev, true, true);
					// config.el.dispatchEvent(evt);
					me.newEv({
						el : config.el,
						type : 'Events',
						ev : config.ev,
						bubbles : true,
						cancelable : true
					});
				}
			}
		}
	},
	/**
	 * kit事件注销方法
	 * @param {Object} config
	 * @param {Selector|Element|NodeList} config.el 触发事件的元素，等于event.currentTarget
	 * @param {String} [config.ev] 事件type，如无，则注销该元素下所有类型的事件
	 * @param {Function} [config.fn] 事件方法，如有，则根据toString对比，找到后注销，如无，则注销该事件下所有的方法
	 */
	delEv : function(config) {
		var me = this, defaultConfig = {
			el : window,
			ev : null,
			fn : null
		}
		config = me.join(defaultConfig, config);
		if(me.isAry(config.el)) {
			for(var i = 0; i < config.el.length; i++) {
				me.delEv(me.join(config, {
					el : config.el[i]
				}));
			}
		} else if(me.isCanSplit2Ary(config.el)) {
			var a = config.el.split(me.CONSTANTS.REGEXP_SPACE)
			for(var i = 0; i < a.length; i++) {
				var _el = me.el8id(a[i]);
				if(!me.isEmpty(_el)) {
					me.delEv(me.join(config, {
						el : _el
					}));
				}
			}
		} else if(me.isStr(config.el)) {
			var _el = me.el8id(config.el);
			if(me.isEmpty(_el)) {
				_el = me.el("#" + config.el);
			}
			if(!me.isEmpty(_el)) {
				me.delEv(me.join(config, {
					el : _el
				}));
			}
		} else if(me.isAry(config.ev)) {
			for(var i = 0; i < config.ev.length; i++) {
				me.delEv(me.join(config, {
					ev : config.ev[i]
				}));
			}
		} else if(me.isCanSplit2Ary(config.ev)) {
			var a = config.ev.split(me.CONSTANTS.REGEXP_SPACE)
			for(var i = 0; i < a.length; i++) {
				me.delEv(me.join(config, {
					ev : a[i]
				}));
			}
		} else if(!me.isEmpty(config.el)) {
			if(!me.isEmpty(config.ev)) {
				config.ev = config.ev.toString().trim();
				if(!me.isEmpty(config.fn)) {
					var evQueue = config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_EVENT][config.ev];
					for(var i = 0; i < evQueue.length; i++) {
						var _config = evQueue[i];
						if(_config.fn == config.fn || _config.fn.toString() == config.fn.toString() || me.trimAll(_config.fn.toString()) == me.trimAll(config.fn.toString())) {
							evQueue.splice(i, 1);
						}
					}
					if(evQueue.length == 0) {
						delete config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_EVENT][config.ev];
						rmEv(config.el, config.ev, config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_FUNCTION][config.ev]);
						delete config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_FUNCTION][config.ev];
					}
				} else {
					delete config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_EVENT][config.ev];
					rmEv(config.el, config.ev, config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_FUNCTION][config.ev]);
					delete config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_FUNCTION][config.ev];
				}
			} else {
				if($kit.isEmpty(config.el[me.CONSTANTS.KIT_EVENT_REGISTER]) || $kit.isEmpty(config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_EVENT])) {
					return;
				}
				for(var _ev in config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_EVENT]) {
					rmEv(config.el, _ev, config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_FUNCTION][_ev]);
				}
				delete config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_EVENT];
				delete config.el[me.CONSTANTS.KIT_EVENT_REGISTER][me.CONSTANTS.KIT_EVENT_REGISTER_FUNCTION];
			}
		}
		function rmEv(el, e, fn) {
			if(document.attachEvent) {
				el.detachEvent('on' + e, fn);
			} else {
				el.removeEventListener(e, fn, false);
			}
		}

	},
	/**
	 * 触发事件
	 * @param {Object} config
	 * @param {Element} config.el 触发元素
	 * @param {String} [config.ev] 事件类型
	 */
	newEv : function(config) {
		var me = this, defaultConfig = {
			el : window,
			type : 'Events',
			ev : null,
			bubbles : false,
			cancelable : false
		}
		config = me.join(defaultConfig, config);
		if(!$kit.isEmpty(config.ev)) {
			if(document.createEvent) {
				var e = document.createEvent(config.type);
				e.initEvent(config.ev, config.bubbles, config.cancelable);
				config.el.dispatchEvent(e);
			} else {
				config.el.fireEvent('on' + config.ev);
			}
		}
	},
	/**
	 * set event extra info
	 * @param {Event}
	 * @private
	 */
	evExtra : function(ev) {
		var me = this;
		var pageX = ev.pageX || ev.clientX + me.viewport().scrollLeft;
		var pageY = ev.pageY || ev.clientY + me.viewport().scrollTop;
		var offsetX = ev.offsetY || ev.layerX;
		var offsetY = ev.offsetY || ev.layerY;
		return me.merge({
			pageX : pageX,
			pageY : pageY,
			offsetX : offsetX,
			offsetY : offsetY
		}, me.evPos(ev))
	},
	/**
	 * get event coordinate info
	 * @param {Event}
	 * @private
	 */
	evPos : function(ev) {
		if(ev.type.indexOf("touch") == 0 && ev.targetTouches && ev.targetTouches.length) {
			return {
				firstFingerClientX : ev.targetTouches[0].clientX,
				firstFingerClientY : ev.targetTouches[0].clientY,
				firstFingerPageX : ev.targetTouches[0].pageX,
				firstFingerPageY : ev.targetTouches[0].pageY
			}
		}
		return {
			firstFingerClientX : ev.clientX,
			firstFingerClientY : ev.clientY,
			firstFingerPageX : ev.pageX,
			firstFingerPageY : ev.pageY
		}
	},
	// -----------------------------------object manipulate-----------------------------------
	/**
	 * 合并对象，生成一个新的对象
	 * @param {Object ...}
	 * @return {Object}
	 */
	join : function() {
		var a = arguments, b = {};
		if(a.length == 0) {
			return;
		}
		for(var i = 0; i < a.length; i++) {
			for(var r in a[i]) {
				if(!$kit.isEmpty(a[i][r])) {
					b[r] = a[i][r];
				}
			}
		}
		return b;
	},
	/**
	 * 合并对象，后面所有的对象的属性都加到第一个身上
	 * @param {Object ...}
	 * @return {Object}
	 */
	merge : function() {
		var a = arguments;
		if(a.length < 2) {
			return;
		}
		if(a[0] != null) {
			for(var i = 1; i < a.length; i++) {
				for(var r in a[i]) {
					a[0][r] = a[i][r];
				}
			}
		}
		return a[0];
	},
	/**
	 * 合并对象，后面所有的对象的属性都加到第一个身上，注意，如果第一个有了，则不覆盖
	 * @param {Object ...}
	 * @return {Object}
	 */
	mergeIf : function() {
		var a = arguments;
		if(a.length < 2) {
			return;
		}
		for(var i = 1; i < a.length; i++) {
			for(var r in a[i]) {
				if(a[0][r] == null) {
					a[0][r] = a[i][r];
				}
			}
		}
		return a[0];
	},
	/**
	 * is collection include object
	 */
	/*
	has : function(collection, object, ignoreCase) {
	if( typeof (collection) == "undefined" || typeof (object) == "undefined") {
	return false;
	}
	var me = this, flag = false, ignoreCase = (ignoreCase == true ? ignoreCase : false);
	if(me.isAry(collection)) {
	for(var i = 0; i < collection.length; i++) {
	if(collection[i] == object || (ignoreCase && collection[i].toLowerCase() == object.toLowerCase())) {
	flag = true;
	break;
	}
	}
	} else {
	if(collection != null) {
	if( object in collection) {
	flag = true;
	} else if(ignoreCase) {
	for(var p in collection) {
	if(p.toString().toLowerCase() == object.toString().toLowerCase()) {
	flag = true;
	break;
	}
	}
	}
	}
	}
	return flag;
	},*/

	// -----------------------------------log-----------------------------------
	/**
	 * 简单的log
	 * @param {String} info
	 * @param {Object} config
	 */
	log : function(info, config) {
		try {
			var me = this;
			config = me.merge({
				borderColor : "#000",
				container : null
			}, config);
			if(me.isAry(info)) {
				info = info.join("");
			}
			if(document.body) {
				var div;
				if(config.container == null) {
					div = document.body.appendChild(document.createElement("div"));
				} else {
					div = config.container.appendChild(document.createElement("div"));
				}
				div.className = "J_Debug_Info";
				div.style.borderBottom = "1px solid " + config.borderColor || "#000";
				try {
					div.innerHTML += info;
				} catch (e) {
					div.innerHTML += e.toString();
				}
			} else {
				alert(info);
			}
		} catch(e) {
			alert("error!" + e);
			throw e;
		}
	},
	/**
	 * 清空log
	 */
	clsLog : function() {
		var me = this;
		var a = me.els8cls("J_Debug_Info");
		while(a.length) {
			a[0].parentNode.removeChild(a[0]);
		}
	},
	// -----------------------------------else-----------------------------------
	/**
	 * 返回随机数
	 * @private
	 */
	only : function() {
		var rnd = Math.random(10000);
		return new Date().getTime().toString() + '_' + rnd.toString().substr(2, 10);
	},
	/**
	 * generate unique DOM id
	 * @return {String}
	 */
	onlyId : function() {
		var me = this;
		var id = me.CONSTANTS.KIT_DOM_ID_PREFIX + me.only();
		var count;
		if(arguments.length == 1) {
			count = arguments[0];
		} else {
			count = 0;
		}
		count++;
		if(count > me.CONSTANTS.MAX_CYCLE_COUNT) {
			throw "error!";
		}
		if(!me.isEmpty(me.el8id(id))) {
			return me.onlyId(count);
		}
		return id
	},
	/**
	 * 判断iOS版本信息
	 * @return {Object}
	 */
	iOSInfo : function() {
		var me = this, regExp_appleDevice = /\(([a-z; ]+)CPU ([a-z ]*)OS ([\d_]+) like Mac OS X/i;
		var ver, device, re;
		if(regExp_appleDevice.test(navigator.userAgent)) {
			var a = navigator.userAgent.match(regExp_appleDevice);
			ver = a[3].toString().trim();
			ver = ver.replace(/_/g, ".");
			device = a[1].toString().trim();
			device = device.substring(0, device.indexOf(";"));
			re = {
				device : device,
				ver : ver
			}
		}
		return re;
	},
	// each : function(config) {
	// var me = this;
	// var a = config.array;
	// for(var i = 0; i < a.length; i++) {
	// if(me.inAry(config.exclude, a[i])) {
	// continue;
	// } else {
	// config.fn.call(config.scope || this, a[i], i, a);
	// }
	// }
	// },
	/**
	 * 数组遍历
	 * @param {Array|NodeList}
	 * @param {Function} fn 遍历执行方法，执行方法中返回false值，则停止继续遍历
	 * @param {Object} [scope] 执行方法的this指针
	 */
	each : function(ary, fn, scope) {
		if(ary == null) {
			return;
		}
		var me = this;
		if(me.isFn(fn)) {
			if(me.isAry(ary)) {
				for(var i = 0; i < ary.length; i++) {
					var re = fn.call(scope || window, ary[i], i, ary);
					if(re == false) {
						break;
					}
				}
			} else if(me.isObj(ary)) {
				var i = 0;
				for(var k in ary) {
					i++;
					var re = fn.call(scope || window, ary[k], k, ary, i);
					if(re == false) {
						break;
					}
				}
			}
		}
	},
	/**
	 * 合并字符串
	 * @param {Array|Map}
	 * @param {String} connectStr 链接每个属性的字符
	 * @param {String} 遍历Map的时候，链接key与value的字符
	 * @return {String}
	 */
	concat : function(o, connectStr, connectOper) {
		if($kit.isStr(o)) {
			return o;
		}
		var connectStr = '&' || connectStr;
		var connectOper = '=' || connectOper;
		if($kit.isAry(o)) {
			return o.join(connectStr);
		}
		var reStr = [];
		this.each(o, function(v, k) {
			reStr.push(k + connectOper + v);
		});
		return reStr.join(connectStr);
	},
	/**
	 * 简单继承subClass inherit superClass
	 * @param {Object} config
	 * @param {Object} config.child 子类
	 * @param {Object} config.father 父类
	 */
	inherit : function(config) {
		var me = this, child = config.child, father = config.father;
		
		var _arguments = undefined || config.arguments;
		try {
			_arguments = arguments.callee.caller.arguments;
		} catch(e) {
			//don`t pass arguments of constructor
		}
		me.mergeIf(child.prototype, new father(_arguments));
		child.prototype.constructor = child;
		child.superClass = father;
	},
	/**
	 * 模板的简单实现
	 * @param {String} templ 模板文本
	 * @param {Map} data 替换对象
	 * <pre>
	 * render('this is ${obj}', {
	 * 	obj : 'car'
	 * });
	 * 结果：this is car
	 * </pre>
	 */
	tpl : function(templ, data) {
		// 充分利用变量，为单个节点提速
		// 正则尽快匹配失败
		// 理论上可以作为JSON的key，支持很多字符
		return templ.replace(/(\$)(\{([^}]*)\})/gm, function(value, clear, origin, key) {
			key = key.split('.');
			value = data[key.shift()];
			for(var i = 0; i < key.length; i++) {
				value = value[key[i]];
			}
			return (value === null || value === undefined) ? (!!clear ? '' : origin) : value;
		});
	}
}
/**
 * $Kit的实例，直接通过这个实例访问$Kit所有方法
 * @type $Kit
 */
$kit = new $Kit();
/**
 * dom ready event
 * @memberOf $Kit
 * @member $
 * @function
 * @instance
 * @param {Function}
 */
$kit.$ = function(fn) {
	document.addEventListener('DOMContentLoaded', fn, false);
}