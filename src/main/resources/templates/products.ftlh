<!DOCTYPE html>
<html>
<head>
    <title>Ad</title>
</head>
<body>
<h1>Ad </h1><hr>
<#if user.email??>
    <h3>User name: <i>${user.name}</i></h3>
    <form action="/logout" method="post">
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Logout"/>
    </form>
    <#if user.isAdmin()>
        <a href="/admin">Панель администратора</a>
    </#if>
<#else>
    <a href="/login">Login</a></h1>
</#if>
<hr>
<h4>Products from all over Kazakhstan</h4>
<form action="/" method="get">
    Search by ad title: <input type="text" name="title"><br>
    <input type="submit" value="Search"/>
</form>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">more details...</a></p>
    </div>
<#else>
    <h3>There are no products</h3>
</#list>
<#if user.email??>
    <hr>
    <h3>Create a new product</h3>
    <form action="/product/create" method="post" enctype="multipart/form-data">
        Ad title: <input type="text" name="title"/><br><br>
        Ad description: <input type="text" name="description"/><br><br>
        Price: <input type="number" name="price"/><br><br>
        City: <input type="text" name="city"/><br><br>
        First photo: <input type="file" name="file1"/><br><br>
        Second photo: <input type="file" name="file2"/><br><br>
        Third photo: <input type="file" name="file3"/><br><br>
        <input type="hidden" name="_csrf" value="${_csrf.token}">
        <input type="submit" value="Add product"/>
    </form>
</#if>
</body>
</html>