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
                    <#include "nav-header.ftl">
                    <table class="table table-bordered table-condensed">
                        <thead>
                        <tr>
                            <th>编号</th>
                            <th>标签名称</th>
                            <th>文章统计</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list allTags as tag>
                            <tr>
                                <td>${tag.id}</td>
                                <td>
                                    <input id="${tag.id}" class="form-control" value="${tag.name}" name="myname" type="text"/>
                                </td>
                                <td>${tag.amount}</td>
                                <td>
                                    <a onclick="update(${tag.id})" class="btn btn-success btn-sm">修改</a>
                                    <a href="/admin/tag/delete/${tag.id}" class="btn btn-danger btn-sm">删除</a>
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
<script>
    function update(myId) {
        let tagName = document.getElementById(myId).value;
        location.href = '/admin/tag/update?tagId='+myId+'&tagName=' + tagName;
    }
</script>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>