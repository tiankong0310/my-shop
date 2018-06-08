$(function () {
    $("#jqGrid").jqGrid({
        url: '../cmssite/list',
        datatype: "json",
        colModel: [
			{label: 'id', name: 'id', index: 'id', key: true, hidden: true},
			{label: '预留商城ID', name: 'shopid', index: 'shopid', width: 80},
			{label: '名称', name: 'siteName', index: 'site_name', width: 80},
			{label: '域名', name: 'siteDomain', index: 'site_domain', width: 80},
			{label: 'ICP', name: 'siteIcp', index: 'site_icp', width: 80},
			{label: 'LOGO', name: 'siteLogo', index: 'site_logo', width: 80},
			{label: 'WAPLOGO', name: 'siteWapLogo', index: 'site_wap_logo', width: 80},
			{label: '客服QQ', name: 'siteQq', index: 'site_qq', width: 80},
			{label: '邮箱', name: 'siteEmail', index: 'site_email', width: 80},
			{label: '电话', name: 'siteTel', index: 'site_tel', width: 80},
			{label: '微博', name: 'weiboName', index: 'weibo_name', width: 80},
			{label: '微博地址', name: 'weiboUrl', index: 'weibo_url', width: 80},
			{label: '微博二维码', name: 'weiboQrcode', index: 'weibo_qrcode', width: 80},
			{label: '微信名称', name: 'wechatName', index: 'wechat_name', width: 80},
			{label: '微信ID', name: 'wechatId', index: 'wechat_id', width: 80},
			{label: '微信二维码', name: 'wechatQrcode', index: 'wechat_qrcode', width: 80},
			{label: '关键词', name: 'seoKeywords', index: 'seo_keywords', width: 80},
			{label: '描述', name: 'seoDescription', index: 'seo_description', width: 80},
			{label: '底部版权', name: 'footerContent', index: 'footer_content', width: 80},
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
		cmsSite: {},
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
			vm.cmsSite = {};
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
            let url = vm.cmsSite.id == null ? "../cmssite/save" : "../cmssite/update";
			$.ajax({
				type: "POST",
			    url: url,
			    contentType: "application/json",
			    data: JSON.stringify(vm.cmsSite),
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
				    url: "../cmssite/delete",
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
			$.get("../cmssite/info/"+id, function (r) {
                vm.cmsSite = r.cmsSite;
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