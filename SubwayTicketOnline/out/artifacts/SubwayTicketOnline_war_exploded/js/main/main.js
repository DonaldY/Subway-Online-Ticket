/**
 * Created by Donald on 2016/8/18.
 */
/**
 * begain main.js loading city List
 */
//City-global and click-loading
$(document).on('click',"#cityId li",function () {
    var city = $(this).text();
    $("#inputCity").attr("value",city);//fillfull
    var pid = $(this).attr('value');
    $("#inputCategoryParent").attr('value', pid);

    //loading children by ajax
    $.ajax({
        async:true,
        cache:false,
        url:"/SubwayTicketOnline/CategoryServlet",
        data:{method:"ajaxFindChildren", pid:pid},
        type:"POST",
        dataType:"json",
        success:function(arr){
            $("#fromPath").empty();
            $("#toPath").empty();
            for(var i = 0; i < arr.length; ++i){
                var li1 = '<li value='+ arr[i].cid +'>'+ arr[i].cname +'</li>';
                $("#fromPath").append(li1);
                $("#toPath").append(li1);
            }
        }
    });
    showButton();

});

//fromPath-global and click-loading
$(document).on('click',"#fromPath li",function () {
    var fromPath = $(this).text();
    $("#inputFromPath").attr("value",fromPath);//fillfull

    var fromcid = $(this).attr('value');
    //loading children by ajax
    $.ajax({
        async:true,
        cache:false,
        url:"/SubwayTicketOnline/StationServlet",
        data:{method:"ajaxFindStation", cid:fromcid},
        type:"POST",
        dataType:"json",
        success:function(arr){
            $("#fromStation").empty();
            for(var i = 0; i < arr.length; ++i){
                var li1 = '<li value='+ arr[i].sid +'>'+ arr[i].sname +'</li>';
                $("#fromStation").append(li1);
            }
        }
    });
    showButton();

});

//fromPath-global and click-loading
$(document).on('click',"#toPath li",function () {
    var toPath = $(this).text();
    $("#inputToPath").attr("value",toPath);//fillfull

    var tocid = $(this).attr('value');
    //loading children by ajax
    $.ajax({
        async:true,
        cache:false,
        url:"/SubwayTicketOnline/StationServlet",
        data:{method:"ajaxFindStation", cid:tocid},
        type:"POST",
        dataType:"json",
        success:function(arr){
            $("#toStation").empty();
            for(var i = 0; i < arr.length; ++i){
                var li1 = '<li value='+ arr[i].sid +'>'+ arr[i].sname +'</li>';
                $("#toStation").append(li1);
            }
        }
    });
    showButton();
});

//inputfromStation click
$(document).on('click',"#fromStation li",function () {
    var fromStation = $(this).text();
    $("#inputFromStation").attr("value",fromStation);//fillfull
    showButton();
});

$(document).on('click',"#toStation li",function () {
    var toStation = $(this).text();
    $("#inputToStation").attr("value",toStation);//fillfull
    showButton();
});

//HTML loading do this
function loadCity(){
    $.ajax({
        async:false,
        cache:false,
        url:"/SubwayTicketOnline/CategoryServlet",
        data:{method:"findParent"},
        type:"POST",
        dataType:"json",
        success:function(arr){
            $("#cityId").empty();
            for(var i = 0; i < arr.length; ++i){
                var li1 = '<li value='+ arr[i].cid +'>'+ arr[i].cname +'</li>';
                $("#cityId").append(li1);
            }
        }
    });


}




$(function(){
    /**
     * 表单填充
     */
    //ticket change
    $("#ticket").children('li').bind('click', function(){
        var num = $(this).text();
        $("#ticketNum").attr("value", num);
        showButton();
    });

    /**
     * 提交表单验证
     */
   /* $("#createOrder").submit(function() {
        var bool = true;//表示校验通过


        return bool;
    });*/

});




/**
 * when city-input-text change
 * load this function
 * loading parent-path in button-list
 *
 * params:fromPath , toPath
 */
function loadParent() {

    $("#cityId").empty();
    $("#fromPath").empty();
    $("#toPath").empty();
    $("#fromStation").empty();
    $("#toStation").empty();

    $("#fromPath").append("<li>请选择所在城市</li>");
    $("#toPath").append("<li>请选择所在城市</li>");
    $("#fromStation").append("<li>请选择所在路线</li>");
    $("#toStation").append("<li>请选择所在路线</li>");

    $("#inputFromPath").attr("value", "");
    $("#inputToPath").attr("value", "");
    $("#inputFromStation").attr("value", "");
    $("#inputToStation").attr("value", "");

    var cname = $("#inputCity").val();
    /**
     * ajax返回时ciry集合，等以后模糊查询优化
     * 而这里假设的city-name不重复
     * 所以实际上返回只有一个
     *
     * 如果查到则inputCity 的 value 不为null
     * 然后load路线
     *
     * important，这里设置为同步
     * 若为异步可能返回ajaxcid的是空值
     */
    var ajaxcid = "";
    $.ajax({
        async:false,
        cache:false,
        url:"/SubwayTicketOnline/CategoryServlet",
        data:{method:"ajaxFindParentByName", cname:cname},
        type:"POST",
        dataType:"json",
        success:function(arr){
            for(var i = 0; i < arr.length; ++i){
                ajaxcid = arr[i].cid;
            }
        }
    });
    alert(ajaxcid);
    if(ajaxcid != "" && ajaxcid != NaN && ajaxcid != undefined){
        $.ajax({
            async:true,
            cache:false,
            url:"/SubwayTicketOnline/CategoryServlet",
            data:{method:"ajaxFindChildren", pid:ajaxcid},
            type:"POST",
            dataType:"json",
            success:function(arr){
                $("#fromPath").empty();
                $("#toPath").empty();
                for(var i = 0; i < arr.length; ++i){
                    var li1 = '<li value='+ arr[i].cid +'>'+ arr[i].cname +'</li>';
                    $("#fromPath").append(li1);
                    $("#toPath").append(li1);
                }
            }
        });
    }
}


/**
 * when path-input-text change
 * load this function
 * loading children-station in buttion-list
 *
 * params:fromStation
 */
function loadChildren1(){
    $("#fromStation").empty();  //删除元素的子元素
    $("#fromStation").append("<li>请选择出发站点</li>");

}


/**
 * when path-input-text change
 * load this function
 * loading children-station in buttion-list
 *
 * params:fromStation
 */
function loadChildren2(){
    $("#toStation").empty();  //删除元素的子元素
    $("#toStation").append("<li>请选择出发站点</li>");

}

/**
 * Button 改变
 */
function showButton() {

    if (isFillAllInput()) {
        $('#submit').attr("disabled",false);

    } else {
        $('#submit').attr("disabled",true);
    }
}


/**
 * 是否所有input均满
 */
function isFillAllInput() {

    var bool = true;

    $(".inputClass").each(function() {

        if ($(this).val().length == 0 || $(this).val() == "") {

            bool =  false;
            return;
        }

    });

    return bool;

}



