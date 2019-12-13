<html lang="zh-CN">
<head>
    <meta charset="utf-8" />
    <title>编辑博客</title>
    <link rel="stylesheet" href="/editor/css/style.css" />
    <link rel="stylesheet" href="/editor/css/editormd.css" />

    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/bootstrap/css/dash-board.css" rel="stylesheet"/>
    <link href="/bootstrap/css/site-min.css" rel="stylesheet"/>
    <script src="/bootstrap/script/jquery-3.4.1.min.js"></script>
    <script src="/bootstrap/js/bootstrap.min.js"></script>
    <script>
        function checkLeave(){
            //event.returnValue="确定离开当前页面吗？";
        }
    </script>
</head>
<body style="padding: 0" onbeforeunload="checkLeave()">
<div style="width: 100%; height: 100%" id="top">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <span class="navbar-brand">博客标题</span>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="#" data-toggle="modal" data-target="#myModal">发布博客</a></li>
                <li><a href="#" data-toggle="modal" data-target="#myModal2">保存为草稿</a></li>
                <li><a href="#" onclick="returnIndex()">返回首页</a></li>
            </ul>
            <form class="navbar-form navbar-left" role="search">
                <div class="form-group">
                    <label for="tittle"></label><input type="text" id="tittle" name="title" class="form-control" placeholder="博客标题(1-100)"
                                                       style="width: 700px"/>
                    <label for="id"></label><input id="id" type="text" style="display: none">
                </div>
            </form>
        </div>
    </div>
    <div style="width: 100%; height: 100%">
        <form name="mdEditorForm" style="padding-top: 0; height: 100%">
            <div id="test-editormd" style="width: 100%; height: 100%">
                <!-- 如果是修改的话 -->
                <label for="content"></label><textarea style="display:none;" name="content" id="content">[TOC]</textarea>
            </div>
        </form>
    </div>
</div>

<!-- 模态框start -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="myModal">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">发布文章</h4>
            </div>
            <div class="modal-body" style="text-align: left">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="summary" class="col-sm-2 control-label">文章摘要</label>
                        <div class="col-sm-10">
                            <textarea name="form-control" placeholder="好的文章摘要易于检索...(摘要最多150字, 否则会保存失败)"
                                      id="summary" style="width: 95%;border-radius: 6px; padding: 10px; border-color: #EEEEEE; height: 150px"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">选择分类</label>
                        <div class="col-sm-10" style="margin: 0">
                            <label for="category"></label>
                            <select id="category" name="" style="width: 40%; height: 40px;">
                                <#list category as cate>
                                　　<option value="${cate.id}" style="border-radius: initial">${cate.myname}
                                    </option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">已选标签</label>
                        <div class="col-sm-10" style="margin: 0" id="selectedTag">

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">其他标签</label>
                        <div class="col-sm-10" style="margin: 0" id="allTags">
                            <#list uncheckedTag as onetag>
                            <button id="${onetag.id}"
                                    value="${onetag.id}"
                                    type="button"
                                    style="margin-top: 8px; margin-left: 8px"
                                    class="btn btn-default"
                                    onclick="checkedTag(this)">${onetag.name}</button>
                            </#list>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                <button type="button" class="btn btn-primary" id="submit">确认发布</button>
            </div>
        </div>
    </div>
</div>
<!-- 模态框end -->
<!-- 模态框start -->
<div class="modal fade bs-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" id="myModal2">
    <div class="modal-dialog modal-lg" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">保存草稿</h4>
            </div>
            <div class="modal-body" style="text-align: left">
                <form class="form-horizontal" role="form">
                    <div class="form-group">
                        <label for="summary" class="col-sm-2 control-label">文章摘要</label>
                        <div class="col-sm-10">
                            <label for="summary2">
                            </label>
                            <textarea name="form-control" placeholder="好的文章摘要易于检索...(摘要最多150字, 否则会保存失败)"
                                                                    id="summary2" style="width: 95%;border-radius: 6px; padding: 10px; border-color: #EEEEEE; height: 150px"></textarea>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">选择分类</label>
                        <div class="col-sm-10" style="margin: 0">
                            <label for="category2"></label>
                            <select id="category2" name="" style="width: 40%; height: 40px;">
                                <#list category as cate>
                                　　<option value="${cate.id}" style="border-radius: initial">${cate.myname}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">已选标签</label>
                        <div class="col-sm-10" style="margin: 0" id="selectedTag2">

                        </div>
                    </div>
                    <div class="form-group">
                        <label class="col-sm-2 control-label">其他标签</label>
                        <div class="col-sm-10" style="margin: 0" id="allTags2">
                            <#list uncheckedTag as onetag>
                            <button id="${onetag.id}"
                                    value="${onetag.id}" type="button" style="margin-top: 8px; margin-left: 8px"
                                    class="btn btn-default"
                                    onclick="checkedTag2(this)">${onetag.name}</button>
                            </#list>
                        </div>
                    </div>
                </form>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">返回</button>
                <button type="button" class="btn btn-primary" id="submit2">确认保存</button>
            </div>
        </div>
    </div>
</div>
<!-- 模态框end -->


<script src="/bootstrap/script/jquery-3.4.1.min.js"></script>
<script src="/bootstrap/script/editormd.min.js"></script>
<script type="text/javascript">
    let testEditor;

    //初始化Markdown编辑器
    $(function() {
        testEditor = editormd("test-editormd", {
            width   : "100%",
            height  : "100%",
            syncScrolling : "single",
            // 静态浏览的话应该是 ../../static/editor/lib/ */
            path    : "../../../editor/lib/",
            imageUpload : true,
            tex : true,
            imageFormats : ["jpg", "jpeg", "gif", "png", "bmp", "webp"],
            imageUploadURL : "/file/fileUpload",
            // 指定需要显示的功能按钮
            toolbarIcons : function() {
                return ["undo","redo","|","bold","del","italic","quote","ucwords","uppercase","lowercase","|","h1","h2","h3","h4","h5","h6","|","list-ul","list-ol","hr","|","link","reference-link","image","static.code","preformatted-text","code-block","table","datetime","emoji","html-entities","pagebreak","|","goto-line","watch","preview","fullscreen","clear","search"]
            }
        });
    });

    document.getElementById("submit").onclick = contentRelease;
    document.getElementById("submit2").onclick = savedRafts;

    //标签取消选择
    function uncheckedTag(btn) {
        btn.remove();
        btn.onclick = function () { checkedTag(this); };
        document.getElementById('allTags').appendChild(btn);
    }
    //标签确定选择
    function checkedTag(btn) {
        btn.remove();
        btn.onclick = function () { uncheckedTag(this); };
        document.getElementById('selectedTag').appendChild(btn);
    }

    //标签取消选择
    function uncheckedTag2(btn) {
        btn.remove();
        btn.onclick = function () { checkedTag2(this); };
        document.getElementById('allTags2').appendChild(btn);
    }
    //标签确定选择
    function checkedTag2(btn) {
        btn.remove();
        btn.onclick = function () { uncheckedTag2(this); };
        document.getElementById('selectedTag2').appendChild(btn);
    }

    //发布博客
    function contentRelease(){
        let buttonList = document.getElementById('selectedTag').getElementsByTagName('button');
        let tagString = '';
        for (let i = 0; i < buttonList.length; i++) {
            tagString += buttonList[i].getAttribute('id')+' ';
        }

        let id = $("#id").val();
        let tittle = $("#tittle").val();
        let content = $("#content").val();
        let summary = $("#summary").val();
        let category = $("#category").val();

        if(summary == null) {
            summary = "仗剑天涯，从你的摘要开始";
        }

        $.post({
            url: "/admin/article/release",
            data: {"id":id,
                   "tittle":tittle,
                   "summary":summary,
                   "content":content,
                   "category":category,
                   "tags":tagString},
            success:function (data) {
                window.location.href = data;
            },
            error:function () {
                alert("发布失败");
                console.log("发布失败");
            }
        });
    }
    function savedRafts(){
        let buttonList = document.getElementById('selectedTag2').getElementsByTagName('button');
        let tagString = '';
        for (let i = 0; i < buttonList.length; i++) {
            tagString += buttonList[i].getAttribute('id')+' ';
        }

        let id = $("#id").val();
        let tittle = $("#tittle").val();
        let content = $("#content").val();
        let summary = $("#summary2").val();
        let category = $("#category2").val();

        if(summary == null) {
            summary = "仗剑天涯，从你的摘要开始";
        }

        $.post({
            url: "/admin/article/manuscript",
            data: {"id":id,
                "tittle":tittle,
                "summary":summary,
                "content":content,
                "category":category,
                "tags":tagString},
            success:function (data) {
                window.location.href = data;
            },
            error:function () {
                alert("保存失败");
                console.log("保存失败");
            }
        });
    }

    //返回首页
    function returnIndex(){
        let se = confirm('文章未保存, 确定返回首页?');
        if (se === true)
            window.location.href="/admin/center";
    }
</script>
</body>
</html>