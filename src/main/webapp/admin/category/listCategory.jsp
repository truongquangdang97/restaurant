<%@ page import="java.util.List" %>
<%@ page import="com.example.restaurant.entity.Categories" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/11/2022
  Time: 2:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Categories> list = (List<Categories>)request.getAttribute("listCategory");
%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="container">
    <div class="row">
        <div class="all">
            <h1>Các thể loại món ăn . </h1>
        </div>
        <div>
            <a href="/category/create">
                <button class="btn btn-primary">Add Category</button>
            </a>
            <a href="/food/lists">
                <button>Tất cả các món ăn </button>
            </a>
        </div>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Photo</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
            <% for (Categories cate:list){
            %>
            <tr>
                <th><%=cate.getId()%></th>
                <th><%=cate.getNameCategory()%></th>
                <th>
                    <img src="<%=cate.getPhoto()%>" width="100px"/>
                </th>
                <th>
                    <a href="">
                        <button>Add to cart</button>
                    </a>
                    <a href="/category/delete?id=<%=cate.getId()%>" class="btn-delete">
                        <button type="button" class="btn btn-danger">Delete</button>
                    </a>
                    <a href="/category/edit?id=<%=cate.getId()%>">
                        <button type="button" class="btn btn-warning">Edit</button>
                    </a>
                    <a href="/food/list?name=<%=cate.getNameCategory()%>">
                        <button type="button" class="btn btn-info">Danh sách các món ăn về : <%=cate.getNameCategory()%></button>
                    </a>
                </th>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>

    </div>
</div>
<script>
    document.addEventListener('DOMContentLoaded',function (){
        let listDeleteButton = document.querySelectorAll('.btn-delete');
        for (let i =0 ; i<listDeleteButton.length;i++){
            listDeleteButton[i].addEventListener('click',function (event){
                event.preventDefault();
                if (confirm("are you sure ?")){
                    // alert(this.href)
                    let xhr = new XMLHttpRequest();
                    xhr.onreadystatechange = function (){
                        if (xhr.readyState==4 && xhr.status==200){
                            alert('Delete suc')
                            window.location.href="/category/list"
                        }
                    }
                    xhr.open('POST',this.href,false)
                    xhr.send();
                }
            })
        }
    })
</script>
</body>
<style>
    .all{
        text-align: center;
    }
    .khungChua{
        align-items: center;
    }
</style>
</html>
