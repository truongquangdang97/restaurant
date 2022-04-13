<%@ page import="com.example.restaurant.entity.Categories" %><%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 4/11/2022
  Time: 3:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Categories obj = (Categories) request.getAttribute("obj");
%>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">

</head>
<body>
<div class="all">
    <h1>Sửa thể loại . </h1>
    <form action="/category/edit" method="post" name="create-form">
        <div class="mb-3">
            <label  class="form-label">Category Name</label>
            <input type="hidden"  name="id" value="<%=obj.getId()%>" />
            <input type="text"  class="form-control" name="nameCategory" value="<%=obj.getNameCategory()%>">
        </div>
        <div class="mb-3">
            <label class="form-label">Photo</label>
            <img  src="<%=obj.getPhoto()%>" class="w3-round image-preview hide" alt="Norway" id="image-preview">
            <input type="hidden" class="form-control" name="photo" value="<%=obj.getPhoto()%>">
            <button type="button" id="upload_widget" class="cloudinary-button">Upload files</button>
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
                    document.forms['create-form']['photo'].value = result.info.url;
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

</style>
</html>
