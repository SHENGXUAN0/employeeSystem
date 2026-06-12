function login(){
    let username = $("#username").val();
    let password = $("#password").val();

    let user = {
        username:username,
        password:password
    };

    $.ajax({
        url:"/login",
        type:"post",
        contentType:"application/json",
        data:JSON.stringify(user),
        success:function (res){
           if(res.success){
               alert(res.msg);
               location.href = "index.html"
           }else {
               alert(res.msg)
           }
        }
    })
}
function toRegister(){
    location.href = "register.html";
}