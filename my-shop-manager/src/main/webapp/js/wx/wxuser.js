$(function () {
    $("#jqGrid").jqGrid({
        url: '../wxuser/list',
        datatype: "json",
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true},
			{label: 'openid', name: 'openid', index: 'openid', width: 80},
			{label: 'unionid', name: 'unionid', index: 'unionid', width: 80},
			{label: '微信昵称', name: 'nickname', index: 'nickname', width: 80},
			{label: '是否关注', name: 'subscribe', index: 'subscribe', width: 80},
			{label: '关注时间', name: 'subscribeat', index: 'subscribeAt', width: 80},
			{label: '性别', name: 'sex', index: 'sex', width: 80},
			{label: '国家', name: 'country', index: 'country', width: 80},
			{label: '省份', name: 'province', index: 'province', width: 80},
			{label: '城市', name: 'city', index: 'city', width: 80},
			{label: '头像', name: 'headimgurl', index: 'headimgurl', width: 80},
			{label: '微信ID', name: 'wxid', index: 'wxid', width: 80},
			{label: '操作人', name: 'opby', index: 'opBy', width: 80},
			{label: '操作时间', name: 'opat', index: 'opAt', width: 80},
			{label: '删除标记', name: 'delflag', index: 'delFlag', width: 80}],
		viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
        }
    });
});

let vm = new Vue({
	el: '#rrapp',
	data: {
        showList: true,
        title: null,
		wxUser: {},
		ruleValidate: {
			name: [
				{required: true, message: '名称不能为空', trigger: 'blur'}
			]
		},
		q: {
		    name: ''
		}
	},
	methods: {
		query: function () {
			vm.reload();
		},
		add: function () {
			vm.showList = false;
			vm.title = "新增";
			vm.wxUser = {};
		},
		update: function (event) {
            let id = getSelectedRow();
			if (id == null) {
				return;
			}
			vm.showList = false;
            vm.title = "修改";

            vm.getInfo(id)
		},
		saveOrUpdate: function (event) {
            let url = vm.wxUser.id == null ? "../wxuser/save" : "../wxuser/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.wxUser),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function (index) {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
			});
		},
		del: function (event) {
            let ids = getSelectedRows();
			if (ids == null){
				return;
			}

			confirm('确定要删除选中的记录？', function () {
				$.ajax({
					type: "POST",
				    url: "../wxuser/delete",
				    contentType: "application/json",
				    data: JSON.stringify(ids),
				    success: function (r) {
						if (r.code == 0) {
							alert('操作成功', function (index) {
								$("#jqGrid").trigger("reloadGrid");
							});
						} else {
							alert(r.msg);
						}
					}
				});
			});
		},
		getInfo: function(id){
			$.get("../wxuser/info/"+id, function (r) {
                vm.wxUser = r.wxUser;
            });
		},
		reload: function (event) {
			vm.showList = true;
            let page = $("#jqGrid").jqGrid('getGridParam', 'page');
			$("#jqGrid").jqGrid('setGridParam', {
                postData: {'name': vm.q.name},
                page: page
            }).trigger("reloadGrid");
            vm.handleReset('formValidate');
		},
        handleSubmit: function (name) {
            handleSubmitValidate(this, name, function () {
                vm.saveOrUpdate()
            });
        },
        handleReset: function (name) {
            handleResetForm(this, name);
        }
	}
});