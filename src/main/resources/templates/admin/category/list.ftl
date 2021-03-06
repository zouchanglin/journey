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
                    <#--边栏sidebar-->
                    <#include "nav-header.ftl">
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
                                    <a href="/admin/category/view/update/${category.id}" class="btn btn-success btn-sm">修改</a>
                                    <#if category.id == 1>
                                        <a class="btn btn-danger btn-sm disabled">删除</a>
                                    <#else>
                                        <a href="/admin/category/delete/${category.id}" class="btn btn-danger btn-sm">删除</a>
                                    </#if>
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

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>