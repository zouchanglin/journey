<nav class="navbar navbar-default" role="navigation">
    <div class="navbar-header">
        <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"> <span class="sr-only">Toggle navigation</span><span class="icon-bar"></span>
            <span class="icon-bar"></span><span class="icon-bar"></span></button>
        <a class="navbar-brand" href="/admin/category/list">分类管理</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <form class="navbar-form navbar-right" action="/admin/category/new">
            <div class="form-group">
                <input type="text" class="form-control" name="categoryName" placeholder="分类名称"/>
            </div>
            <div class="form-group">
                <input type="text" class="form-control" name="categoryDec" placeholder="分类描述"/>
            </div>
            <button type="submit" class="btn btn-default">新建分类</button>
        </form>
    </div>
</nav>