/**
 * 校验注册页面
 * */

$(function(){
    /**
     * 输入框得到焦点
     */
    $(".form-control").focus(function(){
        //获得input-email/userpasswd/reuserpasswd
        var className = ".input-" + $(this).attr("id");
        showStatus(className, 0);
    });

    /**
     * 输入框失去焦点进行校验
     */
    $(".form-control").blur(function(){
        var id = $(this).attr("id");
        //得到对应校验函数名
        var functionName = "validate" + id.substring(0,1).toUpperCase() + id.substring(1) + "()";
        eval(functionName);	//执行函数调用
    });

    /**
     * 对表单校验
     */
    $("#registForm").submit(function(){
        return isSubmit();
    });

});


/**
 * Email校验
 */
function validateEmail(){

    var id = "email";
    var value = $("#" + id).val();  //获取输入框内容

    if(!value){
        //email为空 显红色
        showStatus(id, 2);
        return false;
    }else if(!(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/).test(value)){
        //email格式不正确 显红色
        showStatus(id, 2);
        return false;
    }


    $.ajax({
        url:"/SubwayTicketOnline/UserServlet",
        data:{method:"ajaxValidateEmail", email:value},
        type:"POST",
        dataType:"json",
        async:false,
        cache:false,
        success:function(result){

            if(result == false){
                //email被注册 显红色
                showStatus(id, 2);
                return false;
            }

        }
    });

    //email正确 显绿色
    showStatus(id, 1);
    return true;
}

/**
 * 登录密码校验
 */
function validateUserpasswd(){
    var id = "userpasswd";
    var value = $("#" + id).val();  //获取输入框内容
    if(!value){
        //userpasswd为空 显红色
        showStatus(id, 2);
        return false;
    }else if(value.length < 3 || value.length > 20){
        //userpasswd长度不对 显红色
        showStatus(id, 2);
        return false;
    }
    //userpasswd 显绿色
    showStatus(id, 1);
    return true;
}


/**
 * 确定登录密码校验
 */
function validateReuserpasswd(){
    var id = "reuserpasswd";
    var value = $("#" + id).val();  //获取输入框内容
    if(!value){
        //reuserpasswd为空 显红色
        showStatus(id, 2);
        return false;
    }else if(value != $("#userpasswd").val()){
        //reuserpasswd不一致 显红色
        showStatus(id, 2);
        return false;
    }
    showStatus(id, 1);
    return true;
}


/**
 * status == 0 灰色
 *        == 1 绿色
 *        == 2 红色
 */
function showStatus(ele, status){
    var className = ele;
    if(status == 0){
        $(".input-" + className).css("border-bottom"," 1px solid #d6d6d6");
    }else if(status == 1){
        $(".input-" + className).css("border-bottom"," 1px solid #58FF4A");
    }else if(status == 2){
        $(".input-" + className).css("border-bottom"," 1px solid #FF0A36");
    }
}

/**
 * checkbox 是否选中
 * @returns {boolean}
 */
function isCheckbox(){
    if(document.getElementById("checkboxId").checked == true){
        return true;
    }
    return false;
}

function isSubmit(){
    var bool = true;	//表示校验通过
    if(!validateUserpasswd()){
        bool = false;
    }
    if(!validateReuserpasswd()){
        bool = false;
    }
    if(!validateEmail()){
        bool = false;
    }
    if(!isCheckbox()){
        bool;
    }
    return bool;
}