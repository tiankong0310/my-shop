/**
 * 树状字典，加速下拉菜单读取速度
 * @class TreeDict
 * @see <a href="https://github.com/xueduany/KitJs/blob/master/KitJs/src/js/TreeDict.js">Source code</a>
 * @modify
 * 2012/04/09
 * 清明休假想到的，如果遇到“北京”和“北京市”，这两个作为key存入字典，时，按照现在的逻辑，北京市会把北京盖掉，
 * 现在改为对于同前缀的key，加入结束标记作为区分，这样时间存在字典里面的是"北京endSing"和北京市endSign，这样就可以区分开了
 */
var TreeDict = function(config) {
	var me = this;
	me.config = $kit.join(arguments.callee.defaultConfig, config);
	me.size = 0;
	me.deep = me.config.deep;
	me.data = {};
}
/**
 * @member
 * @enum
 */
TreeDict.defaultConfig = {
	deep : 10, //嵌套深度，此参数影响词典内存对象大小，也影响search索引性能
	data : undefined,
	endSign : '$end$'//避免"北京"作为key被"北京市"覆盖掉，现引用结束标记概念，以区别ab和abc这样的字符
}
TreeDict.prototype = {
	constructor : TreeDict,
	/**
	 * 判断是否存在
	 * @param {String}
	 * @return {Boolean}
	 */
	hs : function(key) {
		var key = key || null, me = this;
		if(key == null) {
			var beginIndex = 0, recurDeep = 0, //
			lookfor = me.data, index, lastLookfor, find;
			while(beginIndex < key.length) {
				if(recurDeep < me.deep - 1) {
					index = key.substring(beginIndex, beginIndex + 1);
					find = lookfor[index];
				} else {
					index = key.substring(beginIndex);
					find = lookfor[index];
				}
				if($kit.isEmpty(find)) {
					return false;
				} else {
					if(beginIndex == key.length - 1 || recurDeep == me.deep - 1) {
						return true;
					}
				}
				lookfor = find;
				beginIndex++;
				recurDeep++;
			}
			return false;
		}
	},
	/**
	 * 添加
	 * @param {String}
	 * @param {String}
	 */
	ad : function(key, value) {
		var value = value || null;
		var key = key || null;
		var me = this;
		if(key == null || value == null) {
			return;
		}
		var beginIndex = 0, recurDeep = 0, //
		lookfor = me.data, index, lastLookfor, find;
		while(beginIndex < key.length) {
			if(recurDeep < me.deep - 1) {
				index = key.substring(beginIndex, beginIndex + 1);
				find = lookfor[index];
			} else {
				index = key.substring(beginIndex);
				find = lookfor[index];
			}
			if($kit.isEmpty(find)) {//如果找不到key了
				if(beginIndex == key.length - 1 || recurDeep == me.deep - 1) {
					lookfor[index] = {};
					lookfor[index][me.config.endSign] = value;
					find = lookfor[index];
				} else {
					find = lookfor[index] = {};
				}
			} else {
				if(beginIndex == key.length - 1 || recurDeep == me.deep - 1) {
					find[me.config.endSign] = value;
				}
			}
			lookfor = find;
			beginIndex++;
			recurDeep++;
		}
	},
	/**
	 * 删除
	 * @param {String}
	 */
	rm : function(key) {
		var key = key || null;
		var me = this;
		if(key == null) {
			return;
		}
		var beginIndex = 0, recurDeep = 0, //
		lookfor = me.data, index, lastLookfor, find;
		while(beginIndex < key.length) {
			if(recurDeep < me.deep - 1) {
				index = key.substring(beginIndex, beginIndex + 1);
				find = lookfor[index];
			} else {
				index = key.substring(beginIndex);
				find = lookfor[index];
			}
			if($kit.isEmpty(find)) {
				return false;
			} else {
				if(beginIndex == key.length - 1 || recurDeep == me.deep - 1) {
					delete lookfor[index][me.config.endSign];
					//有没别的索引，没有就斩草除根!!!
					var deleteIndex = false;
					for(var p in lookfor[index]) {
						deleteIndex = true;
						break;
					}
					if(deleteIndex) {
						delete lookfor[index];
					}
				}
			}
			lookfor = find;
			beginIndex++;
			recurDeep++;
		}
	},
	/**
	 * 存放数据总数
	 * @return {Number}
	 */
	size : function() {
		this.size = this.count(0, this.data);
		return this.size;
	},
	count : function(size, o) {
		var me = this;
		size = size || 0;
		for(var p in o) {
			if(o[p][me.config.endSign]) {
				size++;
			} else {
				size += this.count(size, o[p]);
			}
		}
		return size;
	},
	/**
	 * 从字典中取出符合key的value值
	 * @param {String}
	 * @return {String}
	 */
	get : function(key) {
		var value = value || null;
		var key = key || null;
		var me = this;
		if(key == null) {
			return;
		}
		var beginIndex = 0, recurDeep = 0, //
		lookfor = me.data, index, lastLookfor, find;
		while(beginIndex < key.length) {
			if(recurDeep < me.deep - 1) {
				index = key.substring(beginIndex, beginIndex + 1);
				find = lookfor[index];
			} else {
				index = key.substring(beginIndex);
				find = lookfor[index];
			}
			if($kit.isEmpty(find)) {//如果找不到key了
				return null;
			} else {
				if(beginIndex == key.length - 1 || recurDeep == me.deep - 1) {
					return find[me.config.endSign];
				}
			}
			lookfor = find;
			beginIndex++;
			recurDeep++;
		}
		return null;
	},
	/**
	 * 按首字符匹配原则查询，返回
	 * [{key: 'key', value: 'value'}, {key: 'key', value: 'value'}]格式数组
	 * @param {String}
	 * @return {Array}
	 */
	search : function(key) {
		var value = value || null;
		var key = key || null;
		var me = this;
		if(key == null || key == '') {
			var re = [];
			me.travel(me.data, re);
			return re;
		}
		var beginIndex = 0, recurDeep = 0, //
		lookfor = me.data, index, lastLookfor, find;
		var keyArray = [];
		while(beginIndex < key.length) {
			if(recurDeep < me.deep - 1) {
				index = key.substring(beginIndex, beginIndex + 1);
				find = lookfor[index];
			} else {
				index = key.substring(beginIndex);
				find = lookfor[index];
			}
			if($kit.isEmpty(find)) {//如果找不到key了
				return null;
			} else {
				keyArray.push(index);
				if(beginIndex == key.length - 1 || recurDeep == me.deep - 1) {
					break;
				}
			}
			lookfor = find;
			beginIndex++;
			recurDeep++;
		}
		var re = [];
		var beginData;
		beginData = me.data[keyArray[0]];
		for(var i = 1; i < keyArray.length; i++) {
			beginData = beginData[keyArray[i]];
		}
		me.travel(beginData, re, keyArray.join(''));
		return re;
	},
	/**
	 * @private
	 */
	travel : function(tree, array, key, currentKey) {
		var me = this;
		if(tree == null) {
			return;
		}
		key = key || '';
		array = array || [];
		if(tree[me.config.endSign]) {
			array.push({
				key : key,
				value : tree[me.config.endSign]
			});
		}
		for(var k in tree) {
			if(k != me.config.endSign) {
				me.travel(tree[k], array, key + k, k);
			}
		}
	}
};
/**
 * @class $kit.TreeDict
 * @extends TreeDict
 */
$kit.TreeDict = TreeDict;
