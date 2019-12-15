<!DOCTYPE html>
<html lang="zh">
<head>
    <title>${dataPackage.blogTitle}</title>
    <link rel="apple-touch-icon" href="https://s2.ax1x.com/2019/07/25/eVznmt.png">
    <link rel="shortcut icon" type="image/x-icon" href="https://s2.ax1x.com/2019/07/25/eVznmt.png">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/mdui@0.4.3/dist/css/mdui.min.css">
    <link rel="stylesheet" href="bootnexmoe/css/base.css">
    <link rel="stylesheet" href="bootnexmoe/css/font-icon.css">
</head>
<body class="mdui-drawer-body-left mdui-loaded">
<div id="nexmoe-background">
    <#include "header.ftl">
</div>
<div id="nexmoe-header">
    <#include "side.ftl">
</div>
<div id="nexmoe-content">
    <div class="nexmoe-primary">
        <main id="pjax" class="fn__flex-1">
            <section class="nexmoe-posts" id="brand-waterfall">
                <#list articles as article>
                    <div class="nexmoe-post">
                        <a href="" title="${article.articleInfo.tittle}">
                            <div class="nexmoe-post-cover mdui-ripple">
                                <#if article.articleInfo.top == 0>
                                    <i class="top iconfont solo-top"></i>
                                </#if>
                                <img src="https://img.hacpai.com/bing/20190303.jpg?imageView2/1/w/960/h/540/interlace/1/q/100"
                                     alt="${article.articleInfo.tittle}"
                                     data-src="/images/5c3aec85a4343.jpg" class="ls-is-cached lazyloaded index-img"
                                     referrerpolicy="no-referrer">
                                <h1>${article.articleInfo.tittle}</h1>
                            </div>
                        </a>
                        <div class="nexmoe-post-meta">
                <span>
                    <i class="nexmoefont iconfont solo-calendarl"></i>
                    ${article.creatimeStr}
                </span><span>
                    <i class="nexmoefont iconfont solo-heat"></i>${article.articleInfo.reading} °C
                </span>
                        <#if article.articleInfo.discuss == 0>
                        <#else>
                            <span>
                                <i class="nexmoefont iconfont solo-comment"></i>
                                ${article.articleInfo.discuss}
                            </span>
                        </#if>
                            <span>
                            <a class="nexmoefont iconfont solo-category -link" href="#">${article.categoryStr}</a>
                        </span>
                        <#list article.tagArrayStr as tag>
                            <span>
                                <a class="nexmoefont iconfont solo-tag -link" href="#">${tag}</a>
                            </span>
                        </#list>
                        </div>
                        <article>
                            <p class="summary">${article.articleInfo.summary}</p>
                        </article>
                    </div>
                </#list>
            </section>

            <#if 0 < totalPage >
                <nav class="nexmoe-page-nav">
                    <#list 0..totalPage as index>
                        <#if index == currentPage>
                            <span class="page-number current">${index}</span>
                        <#else>
                            <a class="page-number"
                               href="/?page=${index}">${index}</a>
                        </#if>
                    </#list>
                </nav>
            </#if>

        </main>

        <#if blogSubtitle??>
            <div class="nexmoe-hitokoto">
                <p id="hitokoto">${dataPackage.blogSubtitle}</p>
            </div>
        </#if>
        <div class="back-to-top iconfont solo-gotop" onclick="Util.goTop()"></div>
    </div>
</div>
<#include "footer.ftl">
</body>
</html>