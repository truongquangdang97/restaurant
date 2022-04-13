<%@ page import="java.util.HashMap" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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

    <h1>Thêm loại </h1>
    <form action="/category/create" method="post" name="create-form">
        <div class="w3-panel w3-red">
        </div>
        <div class="mb-3">
            <label  class="form-label">Category Name</label>
            <input type="text"  class="form-control" name="nameCategory">
            <% if (errors.containsKey("nameCategory")){%>
            <span style="color: red"><%=errors.get("nameCategory")%></span>
            <%}%>
        </div>
        <div class="mb-3">
            <label class="form-label">Photo</label>
            <img src="" class="w3-round image-preview hide" alt="Norway" id="image-preview">
            <input type="hidden" class="form-control" name="photo">
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
    .hide{
        display: none;
    }
</style>
</html>
