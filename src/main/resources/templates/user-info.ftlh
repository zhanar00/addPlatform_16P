<!DOCTYPE html>
<html>
<head>
    <title>Ad</title>
</head>
<body>
<h1>Ad</h1><hr>
<h3>Detailed user information ${user.name}</h3>
<b>Phone number: </b> ${user.numberPhone}<br>
<b>Email: </b> ${user.email}<br>
<h4>User products ${user.name}</h4>
<#list products as product>
    <div>
        <p><b>${product.title}</b> ${product.price} руб. | <a href="/product/${product.id}">More details...</a></p>
    </div>
<#else>
    <h3>There are no products</h3>
</#list>
<#if errorMessage??>
    <h2 style="color: red">${errorMessage}</h2>
</#if>
</body>
</html>