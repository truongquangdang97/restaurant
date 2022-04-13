<%@ page import="java.util.List" %>
<%@ page import="com.example.restaurant.entity.Foods" %>
<%@ page import="com.example.restaurant.entity.Categories" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/11/2022
  Time: 9:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Foods> foodsList = (List<Foods>) request.getAttribute("foodsList");
    List<Categories> listCategory = (List<Categories>) request.getAttribute("listCategory");
    String name = (String) request.getAttribute("name");
%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<%if (name==null){%>
<div style="text-align: center">
    <h1>Tất cá các món ăn </h1>
    <a href="/category/list">
        <button >Quay về trang thể loại </button>
    </a>
    <a href="/food/create">
        <button class="btn btn-primary">Thêm món ăn</button>
    </a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>nameFood</th>
            <th>describeFood</th>
            <th>photoFood</th>
            <th>statusFood</th>
            <th>price</th>
            <th>startTime</th>
            <th>updateTime</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% for (Foods st:foodsList){
        %>

        <tr>
            <th><%=st.getId()%></th>
            <th><%=st.getNameFood()%></th>
            <th><%=st.getDescribeFood()%></th>
            <th>
                <img src="<%=st.getPhotoFood()%>" width="100px"/>
            </th>
            <th>
                <%if (st.getStatusFood()==1){%>
                <div  style="color: green;size: 20px">Đang bán </div>
                <%}%>
                <%if (st.getStatusFood()==2){%>
                <div  style="color: red;size: 20px"> Dừng bán </div>
                <%}%>
                <%if (st.getStatusFood()==3){%>
                <div  style="color: gold;size: 20px">Đã xóa </div>
                <%}%>
            </th>
            <th><%=st.getPrice()%>$</th>
            <th><%=st.getStartTime()%></th>
            <th><%=st.getUpdateTime()%></th>
            <th>
                <%for (Categories ca:listCategory) {
                %>
                <%if (ca.getId()==st.getCategoriesId()){%>
                <div> <%=ca.getNameCategory()%></div>
                <%}%>
                <%}%>

            </th>
            <th>
                <a href="/food/delete?id=<%=st.getId()%>" class="btn-delete">
                    <button type="button" class="btn btn-danger">Delete</button>
                </a>
                <a href="/food/edit?id=<%=st.getId()%>">
                    <button type="button" class="btn btn-warning">Edit</button>
                </a>
                <a href="">
                    <button type="button" class="btn btn-info">Detail </button>
                </a>
            </th>
        </tr>


        <%
            }
        %>
        </tbody>
    </table>
</div>
<%}else {%>
<div style="text-align: center">
     <h1>Danh sách các món ăn thuộc kiểu ăn <%=name%> </h1>
    <a href="/food/create">
        <button class="btn btn-primary">Thêm món ăn</button>
    </a>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>ID</th>
            <th>nameFood</th>
            <th>describeFood</th>
            <th>photoFood</th>
            <th>statusFood</th>
            <th>price</th>
            <th>startTime</th>
            <th>updateTime</th>
            <th>Category</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <% for (Foods st:foodsList){
        %>
                <%for (Categories ca:listCategory) {
                %>
                <%if (ca.getId()==st.getCategoriesId()){%>
                    <%if (Objects.equals(name, ca.getNameCategory())){%>
        <tr>
            <th><%=st.getId()%></th>
            <th><%=st.getNameFood()%></th>
            <th><%=st.getDescribeFood()%></th>
            <th>
                <img src="<%=st.getPhotoFood()%>" width="100px"/>
            </th>
            <th>
                <%if (st.getStatusFood()==1){%>
                <div  style="color: green;size: 20px">Đang bán </div>
                <%}%>
                <%if (st.getStatusFood()==2){%>
                <div  style="color: red;size: 20px"> Dừng bán </div>
                <%}%>
                <%if (st.getStatusFood()==3){%>
                <div  style="color: gold;size: 20px">Đã xóa </div>
                <%}%>
            </th>
            <th><%=st.getPrice()%></th>
            <th><%=st.getStartTime()%></th>
            <th><%=st.getUpdateTime()%></th>
            <th>

                <%if (ca.getId()==st.getCategoriesId()){%>
                <div> <%=ca.getNameCategory()%></div>
                <%}%>

            </th>
            <th>
                <a href="/food/delete?id=<%=st.getId()%>" class="btn-delete">
                    <button type="button" class="btn btn-danger">Delete</button>
                </a>
                <a href="/food/edit?id=<%=st.getId()%>">
                    <button type="button" class="btn btn-warning">Edit</button>
                </a>
                <a href="">
                    <button type="button" class="btn btn-info">Detail </button>
                </a>
            </th>
        </tr>
                     <%}%>
                <%}%>
                <%
                    }
                %>


        <%
            }
        %>
        </tbody>
    </table>
</div>
<%}%>
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
        window.location.href="/food/list"
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

</html>
