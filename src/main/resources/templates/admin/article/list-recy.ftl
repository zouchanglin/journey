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
                    <ul class="nav nav-tabs">
                        <li>
                            <a href="/admin/article/list?status=RELEASE">已发布</a>
                        </li>
                        <li>
                            <a href="/admin/article/list?status=DEBUG">草稿箱</a>
                        </li>
                        <li class="active">
                            <a href="/admin/article/list?status=DELETE">回收站</a>
                        </li>
                    </ul><br>
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
                                    <a href="/admin/article/recycle/tomanuscript/${article.articleInfo.id}"
                                       class="btn btn-success btn-sm">移至草稿箱</a>
                                    <a href="/admin/article/recycle/delete/${article.articleInfo.id}"
                                       class="btn btn-danger btn-sm">彻底删除</a>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                    <ul class="pagination">
                        <#if currentPage lte 1>
                            <li class="disabled"><a href="#">上一页</a></li>
                        <#else>
                            <li><a href="/admin/article/list?status=DELETE&page=${currentPage - 1}&size=${size}">上一页</a></li>
                        </#if>

                        <#list 1..totalPage as index>
                            <#if currentPage == index>
                                <li class="disabled"><a href="#">${index}</a></li>
                            <#else>
                                 <#if index != 0>
                                <li><a href="/admin/article/list?status=DELETE&page=${index}&size=${size}">${index}</a></li></#if>
                            </#if>
                        </#list>

                        <#if currentPage gte totalPage>
                            <li class="disabled"><a href="#">下一页</a></li>
                        <#else>
                            <li><a href="/admin/article/list?status=DELETE&page=${currentPage + 1}&size=${size}">下一页</a></li>
                        </#if>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="https://cdn.bootcss.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</body>
</html>