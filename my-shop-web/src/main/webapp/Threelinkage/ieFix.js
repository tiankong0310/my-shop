$kit.merge(String.prototype, {
	trim : function() {
		if(/^\s+|\s+$/g.test(this)) {
			return this.replace(/^\s+|\s+$/g, '');
		} else {
			return this;
		}
	}
});

$kit.merge($Kit.prototype, {
	// 是否ie...
	isIE : function(o) {
		if(document.all) {
			return true;
		}
		return false;
	},
	//是否html元素
	isNodeList : function(o) {
		return !!(o && $kit.isObj(o) && 'length' in o && o.item && this.isNode(o[0]))
	},
	el8cls : function(cls, root) {
		var root = root || document, me = this, re = null;
		me.each(root.getElementsByTagName('*'), function(o) {
			if(me.hsCls(o, cls)) {
				re = o;
				return false;
			}
		});
		return re;
	},
	els8cls : function(cls, root) {
		var root = root || document, me = this, re = [];
		me.each(root.getElementsByTagName('*'), function(o) {
			if(me.hsCls(o, cls)) {
				re.push(o);
			}
		});
		return re.length ? re : null;
	},
	css : function(el, attr, value) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		if(value == null) {
			if(me.isObj(attr)) {
				for(var l in attr) {
					if(l.toLowerCase() == 'opacity') {
						try {
							el.filters.item("alpha").opacity = attr[l] * 100;
						} catch(e) {
							try {
								el.style.filter = 'alpha(opacity="' + attr[l] * 100 + '")';
							} catch(e1) {
								//alert(e1);
							}
						}
					} else {
						el.style[me._camelCssName(l)] = attr[l];
					}
				}
			} else {
				attr = me._camelCssName(attr);
				var re = el.currentStyle[attr];
				if(attr.toLowerCase() == 'opacity' && el.filters.length) {
					try {
						re = el.filters.item("alpha").opacity / 100;
					} catch(e) {
					}
					try {
						re = isNaN(parseFloat(re)) ? 1 : parseFloat(re);
					} catch(e) {
					}
				}
				try {
					re = isNaN(parseFloat(re)) ? re : parseFloat(re);
				} catch(e) {
				}
				return re;
			}
		} else {
			attr = me._camelCssName(attr);
			if(attr.toLowerCase() == 'opacity') {
				try {
					el.filters.item("alpha").opacity = value * 100;
				} catch(e) {
					try {
						el.style.filter = 'alpha(opacity="' + value * 100 + '")';
					} catch(e1) {
						//alert(e1);
					}
				}
			} else {
				el.style[attr] = value;
			}
		}
	},
	cssStr : function(el, attr) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		attr = me._camelCssName(attr);
		var re = el.currentStyle[attr];
		if(attr.toLowerCase() == 'opacity') {
			if(el.filters.length) {
				try {
					re = el.filters.item("alpha").opacity / 100;
				} catch(e) {
					re = 1;
				}
			} else {
				re = 1;
			}
		}
		return re;
	},
	_camelCssName : function(str) {
		/**
		 * Css Hack支持
		 */
		if(this._IEVer() <= 6 && str.indexOf('_') == 0) {
			str = str.substring(1, str.length);
		} else if(str.indexOf('+') == 0 || str.indexOf('*') == 0) {
			str = str.substring(1, str.length);
		}
		var firstLetter = str.substr(0, 1);
		var mainStr = str.substr(1);
		var a = mainStr.split('-');
		for(var i = 1; i < a.length; i++) {
			a[i] = a[i].substr(0, 1).toUpperCase() + a[i].substr(1);
		}
		return firstLetter.toLowerCase() + a.join('');
	},
	_IEVer : function() {
		return navigator.userAgent.match(/MSIE (\d+)\.?\d*/)[1];
	},
	rpEl : function(element, html) {
		var me = this;
		if(me.isEmpty(element) || me.isEmpty(html)) {
			return;
		}
		if($kit.isStr(html)) {
			element.parentNode.replaceChild(me.newHTML(html), element);
		} else if($kit.isNode(html)) {
			element.parentNode.replaceChild(html, element);
		}
	},
	nextEl : function(el, condition, scope) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		var next = null;
		if(el.nextSibling != null) {
			next = el.nextSibling;
		} else {
			var parent = el.parentNode;
			while(parent != null && parent.parentNode != null && parent == parent.parentNode.lastChild) {
				parent = parent.parentNode;
			}
			var firstEl = parent.nextSibling.firstChild;
			while(firstEl != null && firstEl.children.length > 0 && firstEl.firstChild != null) {
				firstEl = firstEl.firstChild;
			}
			next = firstEl;
		}
		if(next != null) {
			if(next.nodeType && next.nodeType == 1) {
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
			} else {
				return me.nextEl(next, condition, scope);
			}
		}
		return next;
	},
	prevEl : function(el, condition, scope) {
		var me = this;
		if(me.isEmpty(el)) {
			return;
		}
		var prev = null;
		if(el.previousSibling != null) {
			prev = el.previousSibling;
		} else {
			var parent = el.parentNode;
			while(parent != null && parent.parentNode != null && parent == parent.parentNode.firstChild) {
				parent = parent.parentNode;
			}
			var lastEl = parent.previousSibling.lastChild;
			while(lastEl != null && lastEl.children.length > 0 && lastEl.lastChild != null) {
				lastEl = lastEl.lastChild;
			}
			prev = lastEl;
		}
		if(prev != null) {
			if(prev.nodeType && prev.nodeType == 1) {
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
			} else {
				return me.prevEl(prev, condition, scope);
			}
		}
		return prev;
	}
});
//reinit
$kit = new $Kit();

$kit.$ = function(fn) {
	IEContentLoaded(window, fn);
	/*
	* @ignore
	* IEContentLoaded.js
	*
	* Author: Diego Perini (diego.perini at gmail.com) NWBOX S.r.l.
	* Summary: DOMContentLoaded emulation for IE browsers
	* Updated: 05/10/2007
	* License: GPL
	* Version: TBD
	*
	* Copyright (C) 2007 Diego Perini & NWBOX S.r.l.
	*
	* This program is free software: you can redistribute it and/or modify
	* it under the terms of the GNU General Public License as published by
	* the Free Software Foundation, either version 2 of the License, or
	* (at your option) any later version.
	*
	* This program is distributed in the hope that it will be useful,
	* but WITHOUT ANY WARRANTY; without even the implied warranty of
	* MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
	* GNU General Public License for more details.
	*
	* You should have received a copy of the GNU General Public License
	* along with this program.  If not, see http://javascript.nwbox.com/IEContentLoaded/GNU_GPL.txt.
	*
	*/

	// @w	window reference
	// @fn	function reference
	function IEContentLoaded(w, fn) {
		var d = w.document, done = false, //
		// only fire once
		init = function() {
			if(!done) {
				done = true;
				fn();
			}
		};
		// polling for no errors
		(function() {
			try {
				// throws errors until after ondocumentready
				d.documentElement.doScroll('left');
			} catch (e) {
				setTimeout(arguments.callee, 50);
				return;
			}
			// no errors, fire
			init();
		})();
		// trying to always fire before onload
		d.onreadystatechange = function() {
			if(d.readyState == 'complete') {
				d.onreadystatechange = null;
				init();
			}
		};
	}

}
/*
 * @ignore
 * Cross-Browser Split 1.1.1
 * Copyright 2007-2012 Steven Levithan <stevenlevithan.com>
 * Available under the MIT License
 * ECMAScript compliant, uniform cross-browser split method
 * Splits a string into an array of strings using a regex or string separator. Matches of the
 * separator are not included in the result array. However, if `separator` is a regex that contains
 * capturing groups, backreferences are spliced into the result each time `separator` is matched.
 * Fixes browser bugs compared to the native `String.prototype.split` and can be used reliably
 * cross-browser.
 * @param {String} str String to split.
 * @param {RegExp|String} separator Regex or string to use for separating the string.
 * @param {Number} [limit] Maximum number of items to include in the result array.
 * @returns {Array} Array of substrings.
 * @example
 *
 * // Basic use
 * split('a b c d', ' ');
 * // -> ['a', 'b', 'c', 'd']
 *
 * // With limit
 * split('a b c d', ' ', 2);
 * // -> ['a', 'b']
 *
 * // Backreferences in result array
 * split('..word1 word2..', /([a-z]+)(\d+)/i);
 * // -> ['..', 'word', '1', ' ', 'word', '2', '..']
 */
var split;

// Avoid running twice; that would break the `nativeSplit` reference
split = split || function(undef) {

	var nativeSplit = String.prototype.split, compliantExecNpcg = /()??/.exec("")[1] === undef, // NPCG: nonparticipating capturing group
	self;
	self = function(str, separator, limit) {
		// If `separator` is not a regex, use `nativeSplit`
		if(Object.prototype.toString.call(separator) !== "[object RegExp]") {
			return nativeSplit.call(str, separator, limit);
		}
		var output = [], flags = (separator.ignoreCase ? "i" : "") + (separator.multiline ? "m" : "") + (separator.extended ? "x" : "") + // Proposed for ES6
		(separator.sticky ? "y" : ""), // Firefox 3+
		lastLastIndex = 0,
		// Make `global` and avoid `lastIndex` issues by working with a copy
		separator = new RegExp(separator.source, flags + "g"), separator2, match, lastIndex, lastLength;
		str += "";
		// Type-convert
		if(!compliantExecNpcg) {
			// Doesn't need flags gy, but they don't hurt
			separator2 = new RegExp("^" + separator.source + "$(?!\\s)", flags);
		}
		/* Values for `limit`, per the spec:
		 * If undefined: 4294967295 // Math.pow(2, 32) - 1
		 * If 0, Infinity, or NaN: 0
		 * If positive number: limit = Math.floor(limit); if (limit > 4294967295) limit -= 4294967296;
		 * If negative number: 4294967296 - Math.floor(Math.abs(limit))
		 * If other: Type-convert, then use the above rules
		 */
		limit = limit === undef ? -1 >>> 0 : // Math.pow(2, 32) - 1
		limit >>> 0;
		// ToUint32(limit)
		while( match = separator.exec(str)) {
			// `separator.lastIndex` is not reliable cross-browser
			lastIndex = match.index + match[0].length;
			if(lastIndex > lastLastIndex) {
				output.push(str.slice(lastLastIndex, match.index));
				// Fix browsers whose `exec` methods don't consistently return `undefined` for
				// nonparticipating capturing groups
				if(!compliantExecNpcg && match.length > 1) {
					match[0].replace(separator2, function() {
						for(var i = 1; i < arguments.length - 2; i++) {
							if(arguments[i] === undef) {
								match[i] = undef;
							}
						}
					});
				}
				if(match.length > 1 && match.index < str.length) {
					Array.prototype.push.apply(output, match.slice(1));
				}
				lastLength = match[0].length;
				lastLastIndex = lastIndex;
				if(output.length >= limit) {
					break;
				}
			}
			if(separator.lastIndex === match.index) {
				separator.lastIndex++;
				// Avoid an infinite loop
			}
		}
		if(lastLastIndex === str.length) {
			if(lastLength || !separator.test("")) {
				output.push("");
			}
		} else {
			output.push(str.slice(lastLastIndex));
		}
		return output.length > limit ? output.slice(0, limit) : output;
	};
	// For convenience
	String.prototype.split = function(separator, limit) {
		return self(this, separator, limit);
	};
	return self;

}();
