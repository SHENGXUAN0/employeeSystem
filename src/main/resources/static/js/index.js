let currentPage = 1;
$(function (){
    loadEmpList();
    loadCount();
});
function loadEmpList(){
    $.ajax({
        url:"/emp/page",
        type:"get",
        data:{
            page:currentPage,
            size:5
        },
        success:function (res){
            let html = "";
            for(let emp of res){
                html += `
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.gender}</td>
                    <td>${emp.age}</td>
                    <td>${emp.phone}</td>
                    <td>
                        <button class="detail-btn" onclick="showDetail(${emp.id})">详细</button>
                        <button class="delete-btn" onclick="deleteEmp(${emp.id})">删除</button>
                    </td>
                </tr>
                `
            }
            $("#empTable").html(html);
            $("#pageNum").text(currentPage);

        },
        error:function (xhr){
            if(xhr.status === 401){
                alert("请先登录")
            }
        }
    })
}
function showDetail(id){
    location.href = "emp.html?id=" + id;
}
function deleteEmp(id){
    if(!confirm("是否删除")){
        return;
    }
    $.ajax({
        url:"/emp/delete",
        type:"post",
        data:{id:id},
        success:function (res){
            if(res){
                alert("删除成功");
                loadEmpList();
                loadCount();
            }else{
                alert("删除失败");
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
    })
}
function searchEmp(){
    let name = $("#searchName").val();
    $.ajax({
        url:"/emp/search",
        type:"post",
        data: {name:name},
        success:function (res){
            let html = "";
            for(let emp of res){
                html += `
                <tr>
                    <td>${emp.id}</td>
                    <td>${emp.name}</td>
                    <td>${emp.gender}</td>
                    <td>${emp.age}</td>
                    <td>${emp.phone}</td>
                    <td>
                        <button class="detail-btn" onclick="showDetail(${emp.id})">详细</button>
                        <button class="delete-btn" onclick="deleteEmp(${emp.id})">删除</button>
                    </td>
                </tr>
                `
            }
            $("#empTable").html(html);
            $("#count").text("共 " + res.length + " 名员工");

        }
    })
}
function refreshEmp(){
    $("#searchName").val("");
    loadEmpList();
}
function addEmp(){

    let name = prompt("请输入姓名");
    let gender = prompt("请输入性别");
    let age = prompt("请输入年龄");
    let phone = prompt("请输入电话");
    let salary = prompt("请输入工资");
    let entryDate = prompt("请输入入职日期，例如 2025-01-01");
    let deptId = prompt("请输入部门ID，例如 1");

    let emp = {
        name: name,
        gender: gender,
        age: age,
        phone: phone,
        salary: salary,
        entryDate: entryDate,
        deptId: deptId
    };

    $.ajax({
        url: "/emp/add",
        type: "post",
        contentType: "application/json",
        data: JSON.stringify(emp),

        success: function(res){
            if(res){
                alert("新增成功");
                loadEmpList();
                loadCount();
            }else{
                alert("新增失败");
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
function logout(){
    $.ajax({
        url:"/logout",
        type:"post",
        success:function (res){
            alert(res.msg);
            location.href = "login.html";
        }
    })
}
function prevPage(){
    if(currentPage > 1){
        currentPage--;
        loadEmpList();
    }
}

function nextPage(){
    currentPage++;
    loadEmpList();
}
function loadCount(){

    $.ajax({
        url:"/emp/count",
        type:"get",
        success:function(res){
            $("#count").text("共 " + res + " 名员工");
        }
    });
}