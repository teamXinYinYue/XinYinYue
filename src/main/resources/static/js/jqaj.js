$(function () {
    $('#button').click(function (){

        var u_name=$("#u_name").val();
        var pass_word=$("#pass_word").val();
        $.ajax({
            url:"registerOneUserByuser",
            type:"post",
            data:JSON.stringify({u_id:"",r_id:"",score:"",sign_info:"",sex:"",priority:"",u_name:u_name,pass_word:pass_word}),//发送到服务器的数据
            contentType:"application/json;charset=UTF-8",
            // type:"get",//不封装，url传参
            // data: "u_name="+u_name+"&pass_word="+pass_word,
            // contentType: "html/text;charset=UTF-8",

            dataType:"text", // 预期服务器返回的数据类型
            success:function(backdata){
                var data = jQuery.parseJSON(backdata);
                if(backdata!=null){
                    alert(data.msg+" , u_id : "+data.login_user.u_id+" , other : "+data.error);
                    console.log(backdata);
                }
            },
            error: function (backdata) {
                if(backdata!=null){
                    alert("失败信息："+backdata.responseText)
                    console.log(backdata.responseText);
                }
            }
        });

    })

    $("#buttonUpload").click(function () {
        var file = $('#fileUpload').get(0).files[0];
        var sid = $('#sid').val();
        var iinfo = $('#iinfo').val();
        if(file!=undefined&&sid!=""&&iinfo!=""){

            var fd = new FormData();
            fd.append("file", file);
            fd.append("sid", sid);
            fd.append("iinfo", iinfo);
            $.ajax({
                url: "uploadOnePictureFileByformdata",
                type: "post",
                data: fd,

                contentType: false,

                dataType: "text",

                cache: false,
                processData: false,

                success:function(backdata){
                    var path = jQuery.parseJSON(backdata).path;
                    $("#imgshow").attr("src", path);
                },
                error: function (backdata) {
                    if(backdata!=null){
                        alert("失败信息："+backdata.responseText)
                        console.log(backdata.responseText);

                    }
                }
            });
        }else{
            alert("请提交完整歌手介绍图片信息！")
        }

    });

    $("#musicButtonUpload").click(function () {
        var file = $('#fileName').get(0).files[0];

        var mname = $('#mname').val();
        var cname = $('#cname').val();
        var sid2 = $('#sid2').val();
        if(file!=undefined&&mname!=""&&cname!=""&&sid2!=""){


            var fd = new FormData();
            fd.append("file", file);
            fd.append("mname", mname);
            fd.append("cname", cname);
            fd.append("sid2", sid2);
            $.ajax({
                url: "uploadOneMusicByFormData",
                type: "post",
                data: fd,

                contentType: false,

                dataType: "text",

                cache: false,
                processData: false,

                success:function(backdata){
                    var data = jQuery.parseJSON(backdata);
                    alert(data);
                    console.log(data);
                    var src=data.path;
                    var mid=data.mid;
                    $("#showmusic").attr("src", src);
                    $("#playmusicid").attr("value", mid);
                },
                error: function (backdata) {
                    if(backdata!=null){
                        alert("失败信息："+backdata.responseText)
                        console.log(backdata.responseText);
                    }
                }
            });
        }else{
            alert("请提交完整歌曲信息！")
        }
    });

    $('#buttonsinger').click(function (){

        var s_name=$("#sname").val();
        var s_info=$("#sinfo").val();
        $.ajax({
            url:"addOneSingerBysinger",
            type:"post",
            data:JSON.stringify({s_id:"",s_name:s_name,s_info:s_info}),//发送到服务器的数据
            contentType:"application/json;charset=UTF-8",
            // type:"get",//不封装，url传参
            // data: "u_name="+u_name+"&pass_word="+pass_word,
            // contentType: "html/text;charset=UTF-8",

            dataType:"text", // 预期服务器返回的数据类型
            success:function(backdata){
                var data = jQuery.parseJSON(backdata);
                if(backdata!=null){
                    alert(data.msg);
                }
            },
            error: function (backdata) {
                if(backdata!=null){
                    alert("失败信息："+backdata.responseText)
                    console.log(backdata.responseText);
                }
            }
        });

    })

    var times=0
    $("audio").bind("play", function(){
        times++;
        document.cookie="times."+$("#playmusicid").val()+"="+times
        alert(document.cookie);
    });

    $(window).on('load', function() {
        if(document.cookie !=""){
            var fd = new FormData();
            fd.append('cookie', document.cookie);
            navigator.sendBeacon('saveOneCookie', fd);
        }

    });

    // document.addEventListener("visibilitychange", function() {
    //     console.log( document.visibilityState );
    //     // if (document.visibilityState == 'hidden') {
    //     //     var fd = new FormData();
    //     //     fd.append('cookie', document.cookie);
    //     //     navigator.sendBeacon('cookie', fd);
    //     // }
    // });
})