$(function (){
    let id  = new URLSearchParams(location.search).get("id");
    $.ajax({
        url:"/emp/get",
        type:"get",
        data:{id:id},
        success:function (res){
            $("#id").text(res.id);
            $("#name").text(res.name);
            $("#gender").text(res.gender);
            $("#age").text(res.age);
            $("#phone").text(res.phone);
            $("#salary").text(res.salary);
            $("#entryDate").text(res.entryDate);
            $("#deptName").text(res.deptName);
            $("#createTime").text(res.createTime);
            $("#updateTime").text(res.updateTime);
        }
    })
})
function updateEmp(){

    let id = new URLSearchParams(location.search).get("id");

    let name = prompt("请输入姓名", $("#name").text());
    let gender = prompt("请输入性别", $("#gender").text());
    let age = prompt("请输入年龄", $("#age").text());
    let phone = prompt("请输入电话", $("#phone").text());
    let salary = prompt("请输入工资", $("#salary").text());
    let entryDate = prompt("请输入入职日期", $("#entryDate").text());
    let deptId = prompt("请输入部门ID");

    let emp = {
        id:id,
        name:name,
        gender:gender,
        age:age,
        phone:phone,
        salary:salary,
        entryDate:entryDate,
        deptId:deptId
    };

    $.ajax({
        url:"/emp/update",
        type:"post",
        contentType:"application/json",
        data:JSON.stringify(emp),

        success:function(res){
            if(res){
                alert("修改成功");
                location.reload();
            }else{
                alert("修改失败");
            }
        },
        error: function(xhr){
            if(xhr.status === 401){
                alert("请先登录");
                location.href = "/login.html";
            }else if(xhr.status === 403){
                alert(xhr.responseText);
            }else{
                alert("系统错误");
            }
        }
    });
}