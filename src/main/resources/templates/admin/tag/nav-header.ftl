<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span>
            <span class="icon-bar"></span><span class="icon-bar"></span></button>
        <a class="navbar-brand" href="/admin/tag/list">标签管理</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <form class="navbar-form navbar-right" action="/admin/tag/new">
            <div class="form-group">
                <input type="text" class="form-control" name="tagName" placeholder="请输入标签名称"/>
            </div>
            <button type="submit" class="btn btn-default">新标签</button>
        </form>
    </div>
</nav>