<html lang="zh-CN">
<#include "../common/header.ftl">
<body>
<div id="wrapper" class="toggled">
    <#--边栏sidebar-->
    <#include "../common/nav.ftl">
    <div id="page-content-wrapper" style="padding-top: 10px">
        <div class="container-fluid">
                <div class="col-md-12 column">
                    <#--边栏sidebar-->
                    <#include "nav-header.ftl">
                    <div class="row clearfix">
                        <div class="col-md-12 column">
                            <form role="form" action="/admin/category/update">
                                <input type="hidden" class="form-control" name="id" value="${categoryInfo.id}"/>
                                <div class="form-group">
                                    <label for="myname">分类名称</label>
                                    <input type="text" id="myname" class="form-control" name="myname" value="${categoryInfo.myname}"/>
                                </div>
                                <div class="form-group">
                                    <label for="describes">分类描述</label>
                                    <input type="text" id="describes" class="form-control" name="describes" value="${categoryInfo.describes}"/>
                                </div>
                                <button type="submit" class="btn btn-success">修改</button>
                            </form>
                        </div>
                    </div>
                </div>
        </div>
    </div>
</div>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>