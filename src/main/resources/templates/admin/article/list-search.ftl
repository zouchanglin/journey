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
                            <th>标题</th>
                            <th>创建时间</th>
                            <th>更新时间</th>
                            <th>阅读量</th>
                            <th>点赞</th>
                            <th>评论</th>
                            <th>分类</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tbody>
                        <#list list as article>
                            <tr>
                                <td>${article.articleInfo.tittle}</td>
                                <td>${article.creatimeStr}</td>
                                <td>${article.updatimeStr}</td>
                                <td>${article.articleInfo.reading}</td>
                                <td>${article.articleInfo.love}</td>
                                <td>${article.articleInfo.discuss}</td>
                                <td>${article.categoryStr}</td>
                                <td>
                                    <a href="/admin/article/edit/${article.articleInfo.id}"
                                       class="btn btn-success btn-sm">修改</a>
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