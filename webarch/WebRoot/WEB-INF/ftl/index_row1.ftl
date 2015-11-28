            <div class="i-row1">
                <div class="cl-l box">
                    <div id="slideBox" class="slideBox">
                        <div class="hd">
                            <ul></ul>
                        </div>
                        <div class="bd">
                            <ul id="imageList">
<#list pictures as picture>
   <li><a href="javascript:;" onclick="skipGallery(collection,);"target="_blank"><img width='694' height='238' src="${basePath}/${picture.fileName}" alt="${picture.name}"/></a></li>
</#list>
                            </ul>
                        </div>
                        <a class="prev" href="javascript:;"></a>
                        <a class="next" href="javascript:;"></a>
                    </div>
                </div>
                <div class="cl-r box">
                    <dl class="i-m1">
                        <dt><a target="_blank" href="notice.jsp">更多&gt;&gt;</a> <span><i class="ic ic-g1"></i><b>Notice</b><em>公 告 &gt;</em></span></dt>
                        <dd>
                            <ul class="i-news" id="notice" >
                            
<#list news as new>
   <li><a target="_blank" href="notice.jsp?no=${new.no}"><span>【网站公告】</span>${new.title}</a></li>
</#list>                            
                            </ul>
                        </dd>
                    </dl>
                </div>
            </div>