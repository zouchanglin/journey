<div class="nexmoe-drawer mdui-drawer" id="drawer">
    <div class="nexmoe-avatar mdui-ripple">
        <a href="/" title="${blogTitle}">
            <img src="https://s2.ax1x.com/2019/10/30/K5S3QO.png" title="myblogTitle" alt="myuserName"></a>
    </div>
    <div class="nexmoe-count">
        <div>
            <span>文章</span>
            ${articleCount}
        </div>
        <div>
            <span>评论</span>
            ${discussCount}
        </div>
        <div>
            <span>点赞</span>
            ${loveCount}
        </div>
        <div>
            <span>浏览</span>
            ${readingCount}
        </div>
    </div>
    <div class="list-content">
        <ul class="nexmoe-list mdui-list header__nav" mdui-collapse="{accordion: true}">
            <a class="nexmoe-list-item mdui-list-item mdui-ripple" href="myserverPath/" title="myblogTittle">
                <i class="mdui-list-item-icon iconfont solo-home"></i>
                <div class="mdui-list-item-content">回到首页</div>
            </a>
            <a class="nexmoe-list-item mdui-list-item mdui-ripple" href="myserverPath/links.html"
               title="mylinkLabel - myblogTittle">
                <i class="mdui-list-item-icon iconfont solo-list"></i>
                <div class="mdui-list-item-content">友情链接</div>
            </a>
            <a class="nexmoe-list-item mdui-list-item mdui-ripple" href="myserverPath/tags.html"
               title="mytagLabel - myblogTittle">
                <i class="mdui-list-item-icon iconfont solo-tags"></i>
                <div class="mdui-list-item-content">标签库</div>
            </a>

            <a class="nexmoe-list-item mdui-list-item mdui-ripple" href="myserverPath/tags.html"
               title="mytagLabel - myblogTittle">
                <i class="mdui-list-item-icon iconfont solo-about"></i>
                <div class="mdui-list-item-content">关于我</div>
            </a>
<#--            <#list pageNavigations as page>-->
<#--                <a class="nexmoe-list-item mdui-list-item mdui-ripple" href="${page.pagePermalink}"-->
<#--                   title="${page.pageTitle}" target="${page.pageOpenTarget}">-->
<#--                    <i class="mdui-list-item-icon iconfont solo-${page.pageIcon}"></i>-->
<#--                    <div class="mdui-list-item-content">${page.pageTitle}</div>-->
<#--                </a>-->
<#--            </#list>-->
        </ul>
    </div>
    <aside id="nexmoe-sidebar">

        <div class="nexmoe-widget-wrap">
            <h3 class="nexmoe-widget-title">功能按钮</h3>
            <div class="nexmoe-widget nexmoe-social features">
                <a href="myserverPath/search" title="搜索">
                    <i class="mdui-list-item-icon iconfont solo-search"></i>
                    <div class="mdui-list-item-content">搜索</div>
                </a>
                <a href="myserverPath/rss.xml" title="RSS">
                    <i class="mdui-list-item-icon iconfont solo-rss"></i>
                </a>
                <a href="myserverPath/admin-index.do#main"
                   title="myadminLabel">
                    <i class="mdui-list-item-icon iconfont solo-spin"></i>
                </a>
                <a href="logoutURL" title="logoutURL">
                    <i class="mdui-list-item-icon iconfont solo-logout"></i>
                </a>
                    <a href="myserverPath/start" title="mystartToUseLabel">
                        <i class="mdui-list-item-icon iconfont solo-login"></i>
                        <div class="mdui-list-item-content"> mystartToUseLabel</div>
                    </a>
            </div>
        </div>

        <div class="nexmoe-widget-wrap">
            <h3 class="nexmoe-widget-title">社交按钮</h3>
            <div class="nexmoe-widget nexmoe-social">
                AAA
            </div>
        </div>

<#--        <#if noticeBoard?? && 'bulletin'== customVars.key0>
            <div class="nexmoe-widget-wrap">
                <h3 class="nexmoe-widget-title">公告栏</h3>
                <div class="nexmoe-widget tagcloud">
                    <div class="links-of-author">
                        我的公告
                    </div>
                </div>
            </div>
        <#elseif  0 != mostUsedTags?size>
            <div class="nexmoe-widget-wrap">
                <h3 class="nexmoe-widget-title">${tagLabel}</h3>
                <div class="nexmoe-widget tagcloud">
                    <#list mostUsedTags as tag>
                        <a rel="tag"
                           href="myserverPath/tags/${tag.tagTitle?url('UTF-8')}"
                           title="${tagLabel}:${tag.tagTitle} - myblogTittle"
                           class="mdui-ripple">
                            ${tag.tagTitle}</a>
                    </#list>
                </div>
            </div>
        </#if>-->


<#--        <#if 0 != mostUsedCategories?size>-->
<#--            <div class="nexmoe-widget-wrap">-->
<#--                <h3 class="nexmoe-widget-title">${categoryLabel}</h3>-->
<#--                <div class="nexmoe-widget">-->
<#--                    <ul class="category-list">-->
<#--                        <#list mostUsedCategories as category>-->
<#--                            <li class="category-list-item">-->
<#--                                <a class="category-list-link mdui-ripple"-->
<#--                                   href="myserverPath/category/${category.categoryURI}"-->
<#--                                   title="${category.categoryTitle} - myblogTittle">-->
<#--                                    ${category.categoryTitle}</a>-->
<#--                                <span class="category-list-count">${category.categoryPublishedArticleCount}</span>-->
<#--                            </li>-->
<#--                        </#list>-->
<#--                    </ul>-->
<#--                </div>-->
<#--            </div>-->
<#--        </#if>-->


<#--        <#if 0 != archiveDates?size>-->
<#--            <div class="nexmoe-widget-wrap">-->
<#--                <h3 class="nexmoe-widget-title">${archiveLabel}</h3>-->
<#--                <div class="nexmoe-widget">-->
<#--                    <ul class="category-list">-->
<#--                        <#list archiveDates as archiveDate>-->
<#--                            <#if archiveDate_index < 10>-->
<#--                                <li class="category-list-item">-->
<#--                                    <#if "en" == localeString?substring(0, 2)>-->
<#--                                        <a class="category-list-link mdui-ripple"-->
<#--                                           href="myserverPath/archives/${archiveDate.archiveDateYear}/${archiveDate.archiveDateMonth}"-->
<#--                                           title="${archiveDate.archiveDateYear} ${yearLabel} ${archiveDate.archiveDateMonth} ${monthLabel} ${archiveLabel} - myblogTittle">-->
<#--                                            ${archiveDate.monthName} ${archiveDate.archiveDateYear}</a><span-->
<#--                                            class="category-list-count">${archiveDate.archiveDatePublishedArticleCount}</span>-->
<#--                                    <#else>-->
<#--                                        <a href="myserverPath/archives/${archiveDate.archiveDateYear}/${archiveDate.archiveDateMonth}"-->
<#--                                           title="${archiveDate.archiveDateYear} ${yearLabel} ${archiveDate.archiveDateMonth} ${monthLabel} ${archiveLabel} - myblogTittle">-->
<#--                                            ${archiveDate.archiveDateYear} ${yearLabel} ${archiveDate.archiveDateMonth} ${monthLabel}</a>-->
<#--                                        <span class="category-list-count">${archiveDate.archiveDatePublishedArticleCount}</span>-->
<#--                                    </#if>-->
<#--                                </li>-->
<#--                            </#if>-->
<#--                        </#list>-->
<#--                    </ul>-->
<#--                </div>-->
<#--            </div>-->
<#--        </#if>-->

    </aside>
    <div class="nexmoe-copyright">
        © my2019<a href="myhttp://">myblogTitle</a> <br/>
        myfooterContent <br>
        Powered by <a href="https://solo.b3log.org" target="_blank">Solo</a> <br>
        Theme <a rel="friend" href="https://github.com/InkDP/solo-nexmoe" target="_blank">myskinDirName</a>
        by <a rel="friend" href="https://www.jinjianh.com" target="_blank">InkDP</a>
    </div>
</div>
