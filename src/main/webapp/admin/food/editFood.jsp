<%@ page import="java.util.List" %>
<%@ page import="com.example.restaurant.entity.Categories" %>
<%@ page import="java.util.Objects" %>
<%@ page import="com.example.restaurant.entity.Foods" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/11/2022
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Foods foods = (Foods) request.getAttribute("obj");
    List<Categories> categoriesList = (List<Categories>) request.getAttribute("listCategory");
%>
<%
    HashMap<String,String> errors = (HashMap<String, String>) request.getAttribute("errors");
    if (errors==null){
        errors = new HashMap<>();
    }
%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="all">
    <h1>Thêm món ăn </h1>
    <form action="/food/edit" method="POST" name="create-form">
        <div class="w3-panel w3-red">
        </div>
        <div class="mb-3">
            <label  class="form-label">Food Name</label>
            <input  type="hidden"  class="form-control" name="id" value="<%=foods.getId()%>">
            <input type="text"  class="form-control" name="nameFood" value="<%=foods.getNameFood()%>">
            <% if (errors.containsKey("nameFood")){%>
            <span style="color: red"><%=errors.get("nameFood")%></span>
            <%}%>
        </div>

        <div class="mb-3">
            <label  class="form-label">describeFood</label>
            <input type="text"  class="form-control" name="describeFood" value="<%=foods.getDescribeFood()%>">
        </div>
        <div class="mb-3">
            <label class="form-label">photoFood</label>
            <img src="<%=foods.getPhotoFood()%>" class="w3-round image-preview" alt="Norway" id="image-preview">
            <input type="hidden" class="form-control" value="<%=foods.getPhotoFood()%>" name="photoFood">
            <button type="button" id="upload_widget" class="cloudinary-button">Upload files</button>
        </div>
        <div class="mb-3">
            <label  class="form-label">statusFood</label>
            <select name="statusFood">
                <option value="1">Đang bán </option>
                <option value="2">Dừng bán  </option>
                <option value="3">Đã xóa </option>
            </select>
        </div>
        <div class="mb-3">
            <label  class="form-label">Price</label>
            <input type="number"  class="form-control" name="price" value="<%=foods.getPrice()%>">$
            <% if (errors.containsKey("price")){%>
            <span style="color: red"><%=errors.get("price")%></span>
            <%}%>
        </div>

        <div  class="mb-3">
            <label  class="form-label">Category</label>
            <select name="categoriesId">
                <% for (Categories ca:categoriesList) {%>
                    <option value="<%=ca.getId()%>" ><%=ca.getNameCategory()%></option>
                <%}%>
            </select>
        </div>



        <button type="submit" class="btn btn-primary">Submit</button>
    </form>


    <script src="https://upload-widget.cloudinary.com/global/all.js" type="text/javascript"></script>

    <script type="text/javascript">
        var myWidget = cloudinary.createUploadWidget({
                cloudName: 'quangdang',
                uploadPreset: 'ml_default'}, (error, result) => {
                if (!error && result && result.event === "success") {
                    console.log('Done! Here is the image info: ', result.info);
                    var img =   document.getElementById("image-preview")
                    img.classList.remove("hide");
                    img.src = result.info.url;
                    document.forms['create-form']['photoFood'].value = result.info.url;
                }
            }
        )

        document.getElementById("upload_widget").addEventListener("click", function(){
            myWidget.open();
        }, false);
    </script>
</div>


</body>
<style>
    .all{
        text-align: center;
        width: 50%;
        margin: auto;
    }
    .image-preview{
        width: 200px;
    }
    .hide{
        display: none;
    }
</style>
</html>
