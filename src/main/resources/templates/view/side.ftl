<link href="https://cdn.staticfile.org/ionicons/2.0.1/css/ionicons.min.css"
        rel="stylesheet" />

<div class="nexmoe-drawer mdui-drawer" id="drawer">
    <div class="nexmoe-avatar mdui-ripple">
        <a href="/" title="${dataPackage.blogTitle}">
            <img src="https://s2.ax1x.com/2019/10/30/K5S3QO.png" title="myblogTitle" alt="myuserName"></a>
    </div>
    <div class="nexmoe-count">
        <div>
            <span>文章</span>
            ${dataPackage.articleCount}
        </div>
        <div>
            <span>评论</span>
            ${dataPackage.discussCount}
        </div>
        <div>
            <span>点赞</span>
            ${dataPackage.loveCount}
        </div>
        <div>
            <span>浏览</span>
            ${dataPackage.readingCount}
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
                <a href="myserverPath/start" title="mystartToUseLabel">
                        <i class="mdui-list-item-icon iconfont solo-about"></i>
                        <div class="mdui-list-item-content"> mystartToUseLabel</div>
                </a>
            </div>
        </div>

        <div class="nexmoe-widget-wrap">
            <h3 class="nexmoe-widget-title">社交按钮</h3>
            <div class="nexmoe-widget nexmoe-social">
                <a href="https://github.com/zouchanglin" title="https://github.com/zouchanglin" class="user__site mdui-ripple" target="_blank" rel="noopener nofollow">
                    <svg viewBox="0 0 32 32" width="100%" height="100%">
                        <path d="M16 0.331c-8.836 0-16 7.163-16 16 0 7.069 4.585 13.067 10.942 15.182 0.8 0.148 1.094-0.347 1.094-0.77 0-0.381-0.015-1.642-0.022-2.979-4.452 0.968-5.391-1.888-5.391-1.888-0.728-1.849-1.776-2.341-1.776-2.341-1.452-0.993 0.11-0.973 0.11-0.973 1.606 0.113 2.452 1.649 2.452 1.649 1.427 2.446 3.743 1.739 4.656 1.33 0.143-1.034 0.558-1.74 1.016-2.14-3.554-0.404-7.29-1.777-7.29-7.907 0-1.747 0.625-3.174 1.649-4.295-0.166-0.403-0.714-2.030 0.155-4.234 0 0 1.344-0.43 4.401 1.64 1.276-0.355 2.645-0.532 4.005-0.539 1.359 0.006 2.729 0.184 4.008 0.539 3.054-2.070 4.395-1.64 4.395-1.64 0.871 2.204 0.323 3.831 0.157 4.234 1.026 1.12 1.647 2.548 1.647 4.295 0 6.145-3.743 7.498-7.306 7.895 0.574 0.497 1.085 1.47 1.085 2.963 0 2.141-0.019 3.864-0.019 4.391 0 0.426 0.288 0.925 1.099 0.768 6.354-2.118 10.933-8.113 10.933-15.18 0-8.837-7.164-16-16-16z"></path>
                    </svg>
                </a>
                <a href="https://twitter.com/zouchanglin" title="https://twitter.com/zouchanglin" target="_blank" class="user__site mdui-ripple" rel="noopener nofollow">
                    <svg viewBox="0 0 32 32" width="100%" height="100%">
                        <path d="M32.003 6.075c-1.175 0.525-2.444 0.875-3.769 1.031 1.356-0.813 2.394-2.1 2.887-3.631-1.269 0.75-2.675 1.3-4.169 1.594-1.2-1.275-2.906-2.069-4.794-2.069-3.625 0-6.563 2.938-6.563 6.563 0 0.512 0.056 1.012 0.169 1.494-5.456-0.275-10.294-2.888-13.531-6.862-0.563 0.969-0.887 2.1-0.887 3.3 0 2.275 1.156 4.287 2.919 5.463-1.075-0.031-2.087-0.331-2.975-0.819 0 0.025 0 0.056 0 0.081 0 3.181 2.263 5.838 5.269 6.437-0.55 0.15-1.131 0.231-1.731 0.231-0.425 0-0.831-0.044-1.237-0.119 0.838 2.606 3.263 4.506 6.131 4.563-2.25 1.762-5.075 2.813-8.156 2.813-0.531 0-1.050-0.031-1.569-0.094 2.913 1.869 6.362 2.95 10.069 2.95 12.075 0 18.681-10.006 18.681-18.681 0-0.287-0.006-0.569-0.019-0.85 1.281-0.919 2.394-2.075 3.275-3.394z"></path>
                    </svg>
                </a>
                <a href="javascript:void(0)" class="user__site mdui-ripple" title="zcl17749162101">
                    <svg viewBox="0 0 32 32" width="100%" height="100%">
                        <path d="M9.062 9.203c0-0.859-0.562-1.422-1.422-1.422-0.844 0-1.703 0.562-1.703 1.422 0 0.844 0.859 1.406 1.703 1.406 0.859 0 1.422-0.562 1.422-1.406zM20.672 17.125c0-0.562-0.562-1.125-1.422-1.125-0.562 0-1.125 0.562-1.125 1.125 0 0.578 0.562 1.141 1.125 1.141 0.859 0 1.422-0.562 1.422-1.141zM16.984 9.203c0-0.859-0.562-1.422-1.406-1.422-0.859 0-1.703 0.562-1.703 1.422 0 0.844 0.844 1.406 1.703 1.406 0.844 0 1.406-0.562 1.406-1.406zM26.906 17.125c0-0.562-0.578-1.125-1.422-1.125-0.562 0-1.125 0.562-1.125 1.125 0 0.578 0.562 1.141 1.125 1.141 0.844 0 1.422-0.562 1.422-1.141zM22.75 10.922c-0.359-0.047-0.719-0.063-1.094-0.063-5.375 0-9.625 4.016-9.625 8.953 0 0.828 0.125 1.625 0.359 2.375-0.359 0.031-0.703 0.047-1.063 0.047-1.422 0-2.547-0.281-3.969-0.562l-3.953 1.984 1.125-3.406c-2.828-1.984-4.531-4.547-4.531-7.656 0-5.391 5.094-9.625 11.328-9.625 5.563 0 10.453 3.391 11.422 7.953zM32 19.687c0 2.547-1.688 4.813-3.969 6.516l0.859 2.828-3.109-1.703c-1.141 0.281-2.281 0.578-3.406 0.578-5.391 0-9.625-3.688-9.625-8.219s4.234-8.219 9.625-8.219c5.094 0 9.625 3.688 9.625 8.219z"></path>
                    </svg>
                </a>
                <a href="tencent://message/?uin=1610984228" title="1610984228" target="_blank" class="user__site mdui-ripple" rel="noopener nofollow">

                    <svg t="1574935733271" class="icon" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg" p-id="973" width="200" height="200"><path d="M867.7 656.3c-5.6-77.3-57.5-142-87.4-175.5 4.2-9.7 14.3-66.1-24.8-104.6 0.1-0.9 0.1-1.9 0.1-2.7 0-151.8-108-261-243.6-261.5-135.6 0.5-243.6 109.7-243.6 261.5v2.7c-39.1 38.4-28.9 94.8-24.8 104.6-30 33.5-81.8 98.2-87.4 175.5-1 20.3 2.1 49.9 12.1 63 12.1 16 45.3-3.2 69-54.4 6.6 23.7 21.9 59.9 56.3 105.9-57.7 13.1-74.2 70.1-54.8 101.2 13.7 21.9 45 40 99.1 40 96.1 0 138.6-25.8 157.5-43.8 3.9-4 9.4-5.8 16.5-5.9 7.1 0 12.7 1.9 16.5 5.9 18.9 18 61.4 43.8 157.5 43.8 54.1 0 85.4-18 99.1-40 19.4-31.1 3-88-54.7-101.2 34.5-46 49.7-82.2 56.3-105.9 23.7 51.2 56.9 70.5 69 54.4 10-13.1 13.2-42.7 12.1-63z m0 0" p-id="974"></path></svg>
                </a>
            </div>
        </div>

        <div class="nexmoe-widget-wrap">
            <h3 class="nexmoe-widget-title">标签</h3>
            <div class="nexmoe-widget tagcloud">
                <#list dataPackage.tagInfoList as tag>
                    <a rel="tag" href="#" title="" class="mdui-ripple">
                        ${tag.name}</a>
                </#list>
            </div>
        </div>

        <div class="nexmoe-widget-wrap">
        <h3 class="nexmoe-widget-title">分类</h3>
        <div class="nexmoe-widget">
            <ul class="category-list">
                <#list dataPackage.categoryInfoList as category>
                    <li class="category-list-item">
                        <a class="category-list-link mdui-ripple" href="#">
                            ${category.myname}</a>
                        <span class="category-list-count">
                            ${category.amount}</span>
                    </li>
                </#list>
            </ul>
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
        ©2019 ${dataPackage.blogTitle}<br/>
        <br>
        Powered by <a href="https://github.com/zouchanglin/journey" target="_blank">Journey</a> <br>
        Theme by <a rel="friend" href="https://github.com/nexmoe/hexo-theme-nexmoe" target="_blank">Nexmoe</a>
    </div>
</div>
