function register(){
    let username = $("#username").val();
    let password = $("#password").val();
    let confirmPassword = $("#confirmPassword").val();

    if(password !== confirmPassword){
        alert("两次密码不一致")
        return;
    }

    let user = {
        username:username,
        password:password,
        role:"user"
    };

    $.ajax({
        url:"/register",
        type:"post",
        contentType:"application/json",
        data:JSON.stringify(user),
        success:function (res){
            if(res.success){
                alert(res.msg);
                location.href = "login.html";
            }else {
                alert(res.msg)
            }
        }
    })

}

function toLogin(){
    location.href = "login.html";
}