<!DOCTYPE html>
<html lang="zh">
<head>
    <title>${blogTitle}</title>

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
<#--            <#if pjax><!---- pjax {#pjax} start --&ndash;&gt;</#if>-->
            <#include "article-list.ftl">
<#--            <#if pjax><!---- pjax {#pjax} end --&ndash;&gt;</#if>-->
        </main>

        <#if blogSubtitle??>
            <div class="nexmoe-hitokoto">
                <p id="hitokoto">${blogSubtitle}</p>
            </div>
        </#if>
        <div class="back-to-top iconfont solo-gotop" onclick="Util.goTop()"></div>
    </div>
</div>
<#include "footer.ftl">
</body>
</html>