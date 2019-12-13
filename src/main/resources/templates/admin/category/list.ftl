<html lang="zh-CN">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper" style="padding-top: 10px">
        <div class="container-fluid">
            <div class="row clearfix">
                <div class="col-md-12 column">
                    <nav class="navbar navbar-default" role="navigation">
                        <div class="navbar-header">
                            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span>
                                <span class="icon-bar"></span><span class="icon-bar"></span></button>
                            <a class="navbar-brand" href="/admin/category/list">分类管理</a>
                        </div>

                        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                            <form class="navbar-form navbar-left" role="search">
                                <div class="form-group">
                                    <input type="text" class="form-control" />
                                </div> <button type="submit" class="btn btn-default">Find</button>
                            </form>
                            <ul class="nav navbar-nav navbar-right">
                                <li>
                                    <a href="#" data-toggle="modal" data-target="#myModal">新建分类</a>
                                </li>
                            </ul>
                        </div>

                    </nav>
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>分类名称</th>
                            <th>分类描述</th>
                            <th>文章统计</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list list as category>
                            <tr>
                                <td>${category.id}</td>
                                <td>${category.myname}</td>
                                <td>${category.describes}</td>
                                <td>${category.amount}</td>
                                <td>
                                    <a href="/admin/category/update" class="btn btn-success btn-sm">修改</a>
                                    <a href="/admin/category/list" class="btn btn-danger btn-sm">删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>


<!-- 模态框start -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="myModal">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content col-sm-12" >
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">新增分类</h4>
            </div>
            <div class="modal-body" style="text-align: left" >
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="text" class="form-control" placeholder="分类名称" id="categoryName" />
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-12">
                            <input type="text" class="form-control" placeholder="分类的描述信息" id="categoryDec" />
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary" id="submit">确认新增</button>
            </div>
        </div>
    </div>
</div>
<!-- 模态框end -->
<script>
    document.getElementById('submit').onclick = function () {
        let categoryName = $("#categoryName").val();
        let categoryDec = $("#categoryDec").val();

        $.post({
            url: "/admin/category/new",
            data: {"categoryName":categoryName,
                "categoryDec":categoryDec},
            success:function (data) {
                window.location.href = data;
            },
            error:function () {
                alert("请检查输入信息完整性!");
                console.log("保存失败");
            }
        });
    }
</script>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>