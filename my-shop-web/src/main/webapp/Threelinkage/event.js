/**
 * 事件扩展，加载该js之后，$kit.ev事件既可以支持全浏览器拖拽
 * @class $Kit.Event
 * @requires kit.js
 * @requires dom.js
 * @see <a href="https://github.com/xueduany/KitJs/blob/master/KitJs/src/js/event.js">Source code</a>
 */
$Kit.Event = function() {
	//
	/**
	 * 原始的ev事件
	 * @member _ev
	 * @instance
	 * @memberOf $Kit.Event
	 */
	this._ev = function() {
		$Kit.prototype.ev.apply($kit, arguments);
	}
	/**
	 * 当前拖拽事件的拖拽元素
	 * @member dragElement
	 * @instance
	 * @memberOf $Kit.Event
	 */
	this.dragElement = undefined;
	/*$kit.ev = function() {
	 $kit.event.ev.apply($kit.event, arguments);
	 }*/
	this.eventExtraInfoFnArray = [];
	this.registExtraEventInfo(function() {
		return $Kit.prototype.evExtra.apply($kit, arguments);
	});
	this.registExtraEventInfo(function() {
		return {
			dragElement : this.dragElement
		};
	});
	this.registExtraEventInfo(function() {
		return {
			dragStartEventInfo : this.dragStartEventInfo
		};
	});
}
$kit.merge($Kit.Event.prototype,
/**
 * @lends $Kit.Event.prototype
 * @enum
 */
{
	KEYCODE_UP : 38,
	KEYCODE_DOWN : 40,
	KEYCODE_LEFT : 37,
	KEYCODE_RIGHT : 39,
	//
	KEYCODE_ADD : 107,
	KEYCODE_SUB : 109,
	KEYCODE_MULTIPLY : 106,
	KEYCODE_DIVIDE : 111,
	//
	KEYCODE_ENTER : 13,
	KEYCODE_ESC : 27,
	KEYCODE_BACKSPACE : 8,
	KEYCODE_TAB : 9,
	//
	KEYCODE_SHIFT : 16,
	KEYCODE_CTRL : 17,
	KEYCODE_ALT : 18,
	//
	KEYCODE_INSERT : 45,
	KEYCODE_DELETE : 46,
	//
	KEYCODE_PAGEUP : 33,
	KEYCODE_PAGEDOWN : 34
},
/**
 * @lends $Kit.Event.prototype
 */
{
	//event增强start
	/**
	 * 递归
	 * @private
	 */
	recurEv : function(evCfg, fn) {
		var me = this;
		if($kit.isAry(evCfg.el)) {
			$kit.each(evCfg.el, function(el) {
				fn.call(me, $kit.join(evCfg, {
					el : el
				}));
			});
		} else if($kit.isCanSplit2Ary(evCfg.el)) {
			me.recurEv($kit.join(evCfg, {
				el : evCfg.el.split($kit.CONSTANTS.REGEXP_SPACE)
			}), fn);
		} else if($kit.isStr(evCfg.el)) {
			var _el = $kit.el(evCfg.el);
			if($kit.isEmpty(_el)) {
				_el = $kit.el("#" + evCfg.el);
			}
			if(!$kit.isEmpty(_el)) {
				fn.call(me, $kit.join(evCfg, {
					el : _el
				}));
			}
		} else if($kit.isAry(evCfg.ev)) {
			$kit.each(evCfg.ev, function(ev) {
				fn.call(me, $kit.join(evCfg, {
					ev : ev
				}));
			});
		} else if($kit.isCanSplit2Ary(evCfg.ev)) {
			me.recurEv($kit.join(evCfg, {
				ev : evCfg.ev.split($kit.CONSTANTS.REGEXP_SPACE)
			}), fn);
		} else {
			return true;
		}
	},
	/**
	 * kit事件注册方法，支持拖拽
	 * @param {Object} config
	 * @param {Selector|Element|NodeList} config.el 触发事件的元素，等于event.currentTarget
	 * @param {String} config.ev 事件type，如click
	 * @param {Function} config.fn 事件方法
	 * @param {Object} config.scope this指针
	 */
	ev : function(config) {
		var me = this, defaultConfig = {
			el : null,
			ev : null,
			fn : null
		}
		config = $kit.join(defaultConfig, config);
		if($kit.isEmpty(config.el) || $kit.isEmpty(config.ev) || !$kit.isFn(config.fn)) {
			return;
		}
		if(me.recurEv(config, me.ev)) {
			var ev = config.ev.trim(), el = config.el;
			if('ondrag' in el) {
				//使用IE自带的drag事件，考虑到HTML5的普及，直接使用现成的
				if(me._isDragEv(ev) && el._flag_kitjs_drag_regist != true) {
					el._flag_kitjs_drag_regist = true;
					el.style.cursor = 'move';
					$kit.attr(el, 'draggable', 'true');
					if($kit.isIE()) {
						//如果是IE
						me._ev({
							el : el,
							ev : 'mousedown',
							fn : function(e) {
								var el = e.currentTarget;
								el.dragDrop && el.dragDrop();
								el._kitjs_dd_mousedown = true;
								//el._kitjs_dd_origin_positoin = $kit.css(el, 'position');
							}
						});
						me._ev({
							el : el,
							ev : 'dragstart',
							fn : function(e) {
								var el = e.currentTarget;
								//e.dataTransfer.effectAllowed = "all";
								me.dragElement = e.currentTarget;
								me.dragStartEventInfo = {
									clientX : e.clientX,
									clientY : e.clientY,
									offsetTarget : e.target.offsetParent,
									offsetTargetOffset : $kit.offset(e.target.offsetParent),
									offsetTargetClientOffset : $kit.dom.clientOffset(e.target.offsetParent)
								}
								e.dataTransfer.setData("text", e.currentTarget.innerHTML);
								//e.dataTransfer.setDragImage(e.target, 0, 0);
								if(el._kitjs_dd_start != true) {
									//
									// var cloneNode = document.createElement('div');
									// $kit.css(cloneNode, {
									// position : 'absolute',
									// display : 'block',
									// width : $kit.offset(el).width,
									// height : $kit.offset(el).height,
									// border : '2px dashed #aaa',
									// backgroundColor : 'transparent',
									// opacity : 0.5
									// });
									// document.body.appendChild(cloneNode);
									// $kit.css(cloneNode, {
									// top : e.pageY - 2,
									// left : e.pageX - 2
									// });
									// $kit.css(el, {
									// position : 'absolute',
									// top : el.offsetTop,
									// left : el.offsetLeft
									// });

									el._kitjs_dd_start = true;
									el._kitjs_dd_drag = true;
									//el._kitjs_dd_cloneNode = cloneNode;
								}
							}
						});
						me._ev({
							el : el,
							ev : 'drag',
							fn : function(e) {
								var el = e.currentTarget;
								//e.dataTransfer.effectAllowed = "all";
								if(el._kitjs_dd_mousedown == true) {
									// $kit.css(el._kitjs_dd_cloneNode, {
									// position : 'absolute',
									// display : 'block',
									// top : e.pageY - 2,
									// left : e.pageX - 2
									// });
									el._kitjs_dd_drag = true;
								}
							}
						});
						me._ev({
							el : el,
							ev : 'dragend',
							fn : function(e) {
								me.dragElement = null;
								me.dragStartEventInfo = null;
								var el = e.currentTarget;
								el._kitjs_dd_mousedown = false;
								el._kitjs_dd_drag = false;
								el._kitjs_dd_start = false;

								// $kit.css(el._kitjs_dd_cloneNode, {
								// display : 'none',
								// 'z-index' : -1
								// });

							}
						});
						el._kitjs_dd_init = true;
						el._kitjs_dd_start = false;
						el._kitjs_dd_drag = false;
						el._kitjs_dd_mousedown = true;
					} else {
						//非IE
						me._ev({
							el : el,
							ev : 'dragstart',
							fn : function(e) {
								var el = e.currentTarget;
								//e.dataTransfer.dropEffect = 'move';
								//e.dataTransfer.effectAllowed = "all";
								//e.dataTransfer.setDragImage(ev.target, 0, 0);
								me.dragElement = e.currentTarget;
								e.dataTransfer.setData("text", e.currentTarget.innerHTML);
								me.dragStartEventInfo = {
									clientX : e.clientX,
									clientY : e.clientY,
									screenX : e.screenX,
									screenY : e.screenY,
									layerX : e.layerX,
									layerY : e.layerY,
									offsetTarget : e.target.offsetParent,
									offsetTargetOffset : $kit.offset(e.target.offsetParent),
									offsetTargetClientOffset : $kit.dom.clientOffset(e.target.offsetParent)
								}
							}
						});
						me._ev({
							el : el,
							ev : 'drag',
							fn : function(e) {
								//e.dataTransfer.effectAllowed = "all";
							}
						});
						me._ev({
							el : el,
							ev : 'dragend',
							fn : function(e) {
								me.dragElement = null;
							}
						});
					}
				} else if(me._isDropEv(ev) && el._flag_kitjs_drop_regist != true) {
					el._flag_kitjs_drop_regist = true;
					me._ev({
						el : el,
						ev : 'dragover',
						fn : function(e) {
							e.stopDefault();
						}
					});
				} else {
					//mousemove代替drag事件，暂时hold
					/*
					 if(!el._kitjs_dd_init) {
					 me._ev({
					 el : el,
					 ev : 'mousedown',
					 fn : function(e) {
					 var el = e.currentTarget;
					 if(el._kitjs_dd_init) {
					 el._kitjs_dd_start = false;
					 el._kitjs_dd_drag = false;
					 el._kitjs_dd_mousedown = true;
					 }
					 }
					 });
					 el._kitjs_dd_init = true;
					 me._ev({
					 el : el,
					 ev : 'mousemove',
					 fn : function(e) {
					 var el = e.currentTarget;
					 if(el._kitjs_dd_init == true && el._kitjs_dd_mousedown == true) {
					 if(el._kitjs_dd_start != true) {
					 $kit.newEv({
					 el : el,
					 ev : 'dragstart'
					 });
					 el._kitjs_dd_start = true;
					 }
					 el._kitjs_dd_drag = true;
					 $kit.newEv({
					 el : el,
					 ev : 'drag'
					 });
					 }
					 }
					 });
					 me._ev({
					 el : el,
					 ev : 'mouseup',
					 fn : function(e) {
					 var el = e.currentTarget;
					 if(el._kitjs_dd_drag == true && el._kitjs_dd_init == true) {
					 $kit.newEv({
					 el : el,
					 ev : 'dragend'
					 });
					 el._kitjs_dd_drag = false;
					 el._kitjs_dd_start = false;
					 el._kitjs_dd_mousedown = false;
					 }
					 }
					 });
					 }
					 */
				}
				//
			}
			me._ev(config);
		}
	},
	_isDragEv : function(ev) {
		var ev = ev.toLowerCase().trim();
		if(ev == 'dragstart'//
		|| ev == 'drag'//
		|| ev == 'dragend'//
		) {
			return true;
		}
		return false;
	},
	_isDropEv : function(ev) {
		var ev = ev.toLowerCase().trim();
		if(ev == 'dragenter'//
		|| ev == 'dragleave'//
		|| ev == 'dragover'//
		|| ev == 'drop'//
		) {
			return true;
		}
		return false;
	},
	//event增强end
	draggable : function(el) {
		var me = this;
		if(el['kitjs-draggable']) {
			return;
		}
		el['kitjs-draggable'] = true;
		me.ev({
			el : el,
			ev : 'drag',
			fn : function(e, cfg) {
				//e.dataTransfer.setDragImage(e.target, 0, 0);//设置拖拽图片
				if(e.dragStartEventInfo && e.dragStartEventInfo.offsetTarget != document.body) {
					var position = $kit.css(e.dragStartEventInfo.offsetTarget, 'position');
					var distanceX = 0, distanceY = 0;
					/*
					 if(e.clientX == 0 && e.screenX > 0) {
					 distanceX = e.screenX - e.dragStartEventInfo.screenX;
					 } else if(e.clientX == 0 && e.screenX == 0 && e.layerX > 0) {
					 distanceX = e.layerX - e.dragStartEventInfo.layerX;
					 } else {
					 distanceX = e.clientX - e.dragStartEventInfo.clientX;
					 }
					 if(e.clientY == 0 && e.screenY > 0) {
					 distanceY = e.screenY - e.dragStartEventInfo.screenY;
					 } else if(e.clientY == 0 && e.screenY == 0 && e.layerY > 0) {
					 distanceY = e.layerY - e.dragStartEventInfo.layerY;
					 } else {
					 distanceY = e.clientY - e.dragStartEventInfo.clientY;
					 }*/
					if(e.clientX == 0 && e.screenX > 0) {
						distanceX = e.screenX - e.dragStartEventInfo.screenX;
					} else if(e.clientX > 0) {
						distanceX = e.clientX - e.dragStartEventInfo.clientX;
					}
					if(e.clientY == 0 && e.screenY > 0) {
						distanceY = e.screenY - e.dragStartEventInfo.screenY;
					} else if(e.clientY > 0) {
						distanceY = e.clientY - e.dragStartEventInfo.clientY;
					}
					if(distanceY != 0 || distanceX != 0) {
						if(position && position.toLowerCase() == 'fixed') {
							var pos = {
								top : e.dragStartEventInfo.offsetTargetClientOffset.top + distanceY + 'px',
								left : e.dragStartEventInfo.offsetTargetClientOffset.left + distanceX + 'px'
							};
							$kit.css(e.dragStartEventInfo.offsetTarget, pos);
						} else if(position && position.toLowerCase() == 'absolute') {
							var pos = {
								top : e.dragStartEventInfo.offsetTargetOffset.top + distanceY + 'px',
								left : e.dragStartEventInfo.offsetTargetOffset.left + distanceX + 'px'
							};
							$kit.css(e.dragStartEventInfo.offsetTarget, pos);
						}
					}
				}
			},
			scope : el
		});
		me.ev({
			el : el,
			ev : 'dragend',
			fn : function(e, cfg) {
				if(e.dragStartEventInfo && e.dragStartEventInfo.offsetTarget != document.body) {
					var position = $kit.css(e.dragStartEventInfo.offsetTarget, 'position');
					var distanceX = 0, distanceY = 0;
					if(e.clientX == 0 && e.screenX > 0) {
						distanceX = e.screenX - e.dragStartEventInfo.screenX;
					} else {
						distanceX = e.clientX - e.dragStartEventInfo.clientX;
					}
					if(e.clientY == 0 && e.screenY > 0) {
						distanceY = e.screenY - e.dragStartEventInfo.screenY;
					} else {
						distanceY = e.clientY - e.dragStartEventInfo.clientY;
					}
					if(distanceY != 0 || distanceX != 0) {
						if(position && position.toLowerCase() == 'fixed') {
							$kit.css(e.dragStartEventInfo.offsetTarget, {
								top : e.dragStartEventInfo.offsetTargetClientOffset.top + distanceY + 'px',
								left : e.dragStartEventInfo.offsetTargetClientOffset.left + distanceX + 'px'
							});
						} else if(position && position.toLowerCase() == 'absolute') {
							$kit.css(e.dragStartEventInfo.offsetTarget, {
								top : e.dragStartEventInfo.offsetTargetOffset.top + distanceY + 'px',
								left : e.dragStartEventInfo.offsetTargetOffset.left + distanceX + 'px'
							});
						}
					}
				}
			},
			scope : el
		});
	},
	evExtra : function(ev) {
		var me = this;
		var re = {};
		for(var i = 0; i < $kit.event.eventExtraInfoFnArray.length; i++) {
			if($kit.isFn(me.eventExtraInfoFnArray[i])) {
				$kit.merge(re, me.eventExtraInfoFnArray[i].call(me, ev));
			} else {
				$kit.merge(re, me.eventExtraInfoFnArray[i]);
			}
		}
		return re;
	},
	registExtraEventInfo : function(fn) {
		this.eventExtraInfoFnArray.push(fn);
	}
});
/**
 * $Kit.Event的实例，直接通过这个实例访问$Kit.Event所有方法
 * @global
 * @type $Kit.Event
 */

$kit.event = new $Kit.Event();
/*$kit.ev = function() {
	$kit.event.ev.apply($kit.event, arguments);
};*/
$kit.evExtra = function() {
	return $Kit.Event.prototype.evExtra.apply($kit.event, arguments);
};
