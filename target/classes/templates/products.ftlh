<!DOCTYPE html>
<html>
<head>
    <title>Ad</title>
</head>
<body>
<h1>Ad | <a href="/login">Login</a></h1><hr>
<form action="/" method="get">
    Search by ad title: <input type="text" name="title"><br>
    <input type="submit" value="Search"/>
</form>
<h4>Products from all over Kazakhstan</h4>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">more details...</a></p>
    </div>
</#list>
<hr>
<h3>Create a new product</h3>
<form action="/product/create" method="post" enctype="multipart/form-data">
    Ad title: <input type="text" name="title"/><br><br>
    Ad description: <input type="text" name="description"/><br><br>
    Price: <input type="number" name="price"/><br><br>
    City: <input type="text" name="city"/><br><br>
    Name: <input type="text" name="author"/><br><br>
    First photo: <input type="file" name="file1"/><br><br>
    Second photo: <input type="file" name="file2"/><br><br>
    Third photo: <input type="file" name="file3"/><br><br>
    <input type="submit" value="Add product"/>
</form>
</body>
</html>