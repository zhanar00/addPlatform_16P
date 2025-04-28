<!DOCTYPE html>
<html>
<head>
    <title>Ad</title>
</head>
<body>
<h1>Ad</h1><hr>
<h4>Products from all over Kazakhstan</h4>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">more details...</a></p>
    </div>
</#list>
<hr>
<h3>Create a new product</h3>
<form action="/product/create" method="post">
    Ad title: <input type="text" name="title"/><br><br>
    Ad description: <input type="text" name="description"/><br><br>
    Price: <input type="number" name="price"/><br><br>
    City: <input type="text" name="city"/><br><br>
    Name: <input type="text" name="author"/><br><br>
    <input type="submit" value="Add product"/>
</form>
</body>
</html>